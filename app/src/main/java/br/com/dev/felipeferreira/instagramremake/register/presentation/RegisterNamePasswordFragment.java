package br.com.dev.felipeferreira.instagramremake.register.presentation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import br.com.dev.felipeferreira.instagramremake.R;

public class RegisterNamePasswordFragment extends Fragment {

    public RegisterNamePasswordFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_register_name_password, container, false);

        return root;
    }
}