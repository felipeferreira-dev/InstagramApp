package br.com.dev.felipeferreira.instagramremake.login.presentation;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;

import br.com.dev.felipeferreira.instagramremake.R;

// Extendendo um FrameLayout pois é o layout que quero inflar! Poderia ser qualquer outro
public class LoadingButton extends FrameLayout {

    private AppCompatButton button;
    private ProgressBar progress;
    private String text;

    public LoadingButton(@NonNull Context context) {
        super(context);
        setup(context, null);
    }

    // Utilizamos esses "attrs" (Atributos) para pegar a referência dos atributos do XML
    // e alterar eles dinamicamente no código.
    public LoadingButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setup(context, attrs);
    }

    public LoadingButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup(context, attrs);
    }

    private void setup(Context context, AttributeSet attrs) {
        // Para fazer o layout aparecer, é necessário inflar o layout
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.button_loading, this, true);

        // Obtendo um stylable que são os atributos que eu mesmo defini no XML "attrs"
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TestButton, 0, 0);
        text = typedArray.getString(R.styleable.TestButton_text); // Pegando a referência do atributo de texto
        typedArray.recycle();

        // Pegando a referência do primeiro filho "0" do meu FrameLayout, que no caso é o Botão
        button = (AppCompatButton) getChildAt(0);
        // Alterando dinamicamente o valor dos atributos do botão
        button.setText(text);
        button.setEnabled(false);

        //Pegando a referência do segundo filho "1"
        progress = (ProgressBar) getChildAt(1);

        // Alterando dinamicamente a cor da ProgressBar
        progress.getIndeterminateDrawable().setColorFilter(
                ContextCompat.getColor(context, android.R.color.white), PorterDuff.Mode.SRC_IN);

    }


    // Sobreescrevendo o setOnClick do FrameLayout para que ele automaticamente sobrescreva o
    // setOnClick do botão.
    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        // Fazendo o evento de clique no botão
        button.setOnClickListener(l);
    }

    // Sobreescrevendo o setEnabled do FrameLayout para que ele automaticamente sobrescreva o
    // setEnablad do botão e junto com o do FrameLayout.
    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        button.setEnabled(enabled);
    }

    // Metodo criado para exibir ou não a ProgressBar
    public void showProgress(boolean enabled) {
        //  ProgressBar  se for ativado ? visivel se não : Escondido
        progress.setVisibility(enabled ? VISIBLE : GONE);
        button.setText(enabled ? "" : text);
    }
}
