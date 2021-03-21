package br.com.dev.felipeferreira.instagramremake.login.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import br.com.dev.felipeferreira.instagramremake.R;

public class LoginActivity extends AppCompatActivity {

    TextInputLayout txtInputEmail;
    TextInputEditText editInputEmail;
    TextInputLayout txtInputPassword;
    TextInputEditText editInputPassword;

    Button btnEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        txtInputEmail = findViewById(R.id.edit_text_email_input_login);
        editInputEmail = findViewById(R.id.edit_text_email_login);
        txtInputPassword = findViewById(R.id.edit_text_password_input_login);
        editInputPassword = findViewById(R.id.edit_text_password_login);
        btnEnter = findViewById(R.id.btn_enter_login);

        // Adicionando evento de texto aos editTexts
        editInputEmail.addTextChangedListener(watcher);
        editInputPassword.addTextChangedListener(watcher);

        btnEnter.setOnClickListener(v -> {

            txtInputEmail.setError("Email Inválido!");
            //txtInputPassword.setError("Senha Inválida!");

            editInputEmail.setBackground(ContextCompat.getDrawable(
                    LoginActivity.this, R.drawable.bg_edit_text_error_login));

            // editInputPassword.setBackground(ContextCompat.getDrawable(
            //       LoginActivity.this, R.drawable.bg_edit_text_error_login));

            txtInputPassword.setErrorIconDrawable(null);
        });
    }

    private TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (!s.toString().isEmpty())
                btnEnter.setEnabled(true);
            else
                btnEnter.setEnabled(false);
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

}