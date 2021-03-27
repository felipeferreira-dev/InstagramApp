package br.com.dev.felipeferreira.instagramremake.common.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;

import br.com.dev.felipeferreira.instagramremake.R;


public class CustomDialog extends Dialog {

    private LinearLayout dialogLinearLayout;

    //Referência do título da minha Dialog
    private TextView titleView;
    //Array de textos
    private TextView[] textViews;

    private LinearLayout.LayoutParams layoutParams;

    private int titleId;

    // Construtor da classe Dialog
    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    // Construtor da classe Dialog
    public CustomDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    // Implementando o Método OnCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_custom); // Conectando o layout à classe

        // Referencia do container e do título
        dialogLinearLayout = findViewById(R.id.dialog_container);
        titleView = findViewById(R.id.dialog_title);

        // LayoutParams é exatamente as dimensões que utilizamos no XML (Aqui eu posso configurar
        // toodo o design do meu container).
        layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        layoutParams.setMargins(50, 30, 50, 30);

    }

    // Sobrescrevendo o método show() da classe Dialog
    @Override
    public void show() {
        super.show();
        // Configurando o título que eu recebi via código da classe que instanciou a CustomDialog
        titleView.setText(titleId);

        // Fazendo um loop para adicionar os textos/botões, como uma SubView dos componentes
        // Utilizando o layoutParams para pegar as margins que defini no OnCreate()
        for (TextView textView : textViews) {
            // Adicionando os textos/botões ao meu LinearLayout container e passando o layoutParams,
            // para dizer qual é o formato dos meus componentes (Match_parent, Wrap_content, margins, etc)
            dialogLinearLayout.addView(textView, layoutParams);
        }
    }

    // Sobrescrevendo os métodos da classe Dialog
    // OBS: Posso sobreescrever qualquer método que exista na classe Dialog para personaliza-la do
    // meu jeito
    @Override
    public void setTitle(int titleId) {
        // Guardando a referência do titulo na minha própria variavel
        this.titleId = titleId;
    }

    // Aqui eu customizo a forma com a qual eu quero que meus botões aparecam na Caixa de Dialogo
    private void addButton(final View.OnClickListener listener, @StringRes int... texts) {
        // criando um array com o tamanho da quantidade de textos que forão passados "texts.length"
        textViews = new TextView[texts.length];
        // Cirando um loop para adicionar cada característica que o meu textView vai ter. tudo o que eu faria
        // no XML eu consigo fazer aqui em linhas de código! ex: Id, text, padding, height, gravity etc.
        for(int i = 0; i < texts.length; i++) {
            //                                  ContextThemeWrapper me permite passar um STYLE em linhas de código!!!!
            TextView textView = new TextView(new ContextThemeWrapper(getContext(), R.style.TextViewBaseDialog), null, 0);
            textView.setId(texts[i]);
            textView.setText(texts[i]);
            textView.setHeight(80);
            textView.setGravity(Gravity.CENTER);
            textView.setPadding(8, 0, 0, 0);
            textView.setOnClickListener((v) -> {
                listener.onClick(v);
                dismiss();
            });
            textViews[i] = textView;
        }
    }

    // Builder é uma classe responsável por criar atributos e métodos de maneira simplificada
    // Ele é utilizado na hora que necessito instanciar a classe "CustomDialog". Com o builder eu posso
    // simplesmente colocar um ponto final . e ir criando os componentes da custom EX: .setTitle .addButton
    // Essa classe é estática justamente para obrigar a implementar todos os métodos na hora da construção.
    // TODO: Sempre que eu chamar a classe Builder eu posso utilizar o ponto final para chamar os métodos
    //  isso ocorre pois quando eu adiciono o ponto, quer dizer que eu posso executar qualquer método
    //  que retorne ele mesmo!
    //  Ex: public Builder : return this. | public CustomDialog : return customDialog;
    public static class Builder {

        private final Context context;
        private int titleId;
        private int[] texts;
        private View.OnClickListener listener;

        // Construtor pegando a referência do contexto
        public Builder(Context context){
            this.context = context;
        }

        // Metodo setTitle @StringRes serve para obrigar o cara que estiver chamando esse método,
        // Sempre passe o ID do texto lá do arquivo de recurso RES.
        public Builder setTitle(@StringRes int titleId) {
            this.titleId = titleId; // arnazenando o titulo
            return this; // retornando o próprio Builder
        }

        // Metodo addButton para adicionar os botões da CustomDialog, Como parâmetro eu passo
        // O evento de clique e (Um array de Strings do arquivo RES "int... texts"!)
        // Os tres pontos ... servem para indicar que esta variável se trata de um Array []
        public Builder addButton(View.OnClickListener listener, @StringRes int... texts) {
            this.listener = listener;
            this. texts = texts;
            return this;
        }

        // Construindo uma dialog, aqui eu pego todos os dados que armazenei dos métodos anteriores
        // e utilizo eles para a construção da CustomDialog
        public CustomDialog build() {
            CustomDialog customDialog = new CustomDialog(context);
            customDialog.setTitle(titleId);
            customDialog.addButton(listener, texts);
            return customDialog;
        }
    }
}
