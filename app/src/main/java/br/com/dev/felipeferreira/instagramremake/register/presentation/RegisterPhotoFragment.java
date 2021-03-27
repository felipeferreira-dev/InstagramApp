package br.com.dev.felipeferreira.instagramremake.register.presentation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import br.com.dev.felipeferreira.instagramremake.R;
import br.com.dev.felipeferreira.instagramremake.common.view.CustomDialog;

public class RegisterPhotoFragment extends Fragment {

    public RegisterPhotoFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_register_photo, container, false);

        // TODO: 22/03/2021  scroll gravity top

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CustomDialog dialog = new CustomDialog.Builder(getContext())
                .setTitle(R.string.define_photo_profile)
                .addButton((build) -> {

                    switch (build.getId()) {
                        case R.string.take_picture :
                            showAlertShort("Foto tirada");
                            break;
                        case R.string.search_gallery :
                            showAlertShort("Galeria Aberta");
                            break;
                    }

                }, R.string.take_picture, R.string.search_gallery)
                .build();

        dialog.show();

    }

    public void showAlertShort(String text) {
        Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();
    }
}