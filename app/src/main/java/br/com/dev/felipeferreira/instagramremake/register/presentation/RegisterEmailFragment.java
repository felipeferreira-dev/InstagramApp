package br.com.dev.felipeferreira.instagramremake.register.presentation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import br.com.dev.felipeferreira.instagramremake.R;
import br.com.dev.felipeferreira.instagramremake.login.presentation.LoginActivity;

public class RegisterEmailFragment extends Fragment {

    public RegisterEmailFragment () {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_register_email, container, false);

        TextInputLayout txtEmail = root.findViewById(R.id.edit_text_email_input_register);
        TextInputEditText editEmail = root.findViewById(R.id.edit_text_email_register);

        txtEmail.setError("Email Inválido!");
        //txtInputPassword.setError("Senha Inválida!");

        editEmail.setBackground(ContextCompat.getDrawable(
                getContext(), R.drawable.bg_edit_text_error_login));

        return root;

    }
}
