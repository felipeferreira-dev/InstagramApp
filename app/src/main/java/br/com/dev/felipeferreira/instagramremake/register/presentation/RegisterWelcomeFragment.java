package br.com.dev.felipeferreira.instagramremake.register.presentation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import br.com.dev.felipeferreira.instagramremake.R;

public class RegisterWelcomeFragment extends Fragment {

    public RegisterWelcomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_register_welcome, container, false);

        return root;
    }
}