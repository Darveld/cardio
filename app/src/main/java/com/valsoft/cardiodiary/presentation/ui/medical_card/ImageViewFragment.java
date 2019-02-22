package com.valsoft.cardiodiary.presentation.ui.medical_card;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.valsoft.cardiodiary.R;

import java.util.Date;
import java.util.GregorianCalendar;

public class ImageViewFragment extends DialogFragment {
    private Uri imageUri;

    public Uri getImageUri() {
        return imageUri;
    }

    public void setImageUri(Uri imageUri) {
        this.imageUri = imageUri;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_image_view, null);
        ImageView imageView = view.findViewById(R.id.selectedIV);
        if (imageUri!=null){
            imageView.setImageURI(imageUri);
        }
        return new AlertDialog.Builder(getContext())
                .setView(view)
                .create();
    }
}
