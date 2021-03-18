package br.com.dev.felipeferreira.instagramremake.login.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import br.com.dev.felipeferreira.instagramremake.R;

public class LoginActivity extends AppCompatActivity {

    TextInputLayout txtInputEmail;
    TextInputEditText editInputEmail;
    TextInputLayout txtInputPassword;
    TextInputEditText editInputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtInputEmail = findViewById(R.id.edit_text_email_input_login);
        editInputEmail = findViewById(R.id.edit_text_email_login);
        txtInputPassword = findViewById(R.id.edit_text_password_input_login);
        editInputPassword = findViewById(R.id.edit_text_password_login);

        txtInputEmail.setError("Email Inválido!");
        txtInputPassword.setError("Senha Inválida!");

         editInputEmail.setBackground(ContextCompat.getDrawable(
               LoginActivity.this, R.drawable.bg_edit_text_error_login));

        editInputPassword.setBackground(ContextCompat.getDrawable(
                LoginActivity.this, R.drawable.bg_edit_text_error_login));

    }
}