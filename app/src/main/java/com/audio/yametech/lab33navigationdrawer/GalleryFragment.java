package com.audio.yametech.lab33navigationdrawer;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment {
    private ImageView imageViewPhoto;
    private Button buttonGetPhoto;
    private final int REQUEST_PHOTO = 0;
    public GalleryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        imageViewPhoto = view.findViewById(R.id.imageViewPhoto);
        buttonGetPhoto = view.findViewById(R.id.buttonGetPhoto);
        buttonGetPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_PHOTO);
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_PHOTO && resultCode == RESULT_OK){
            if(data != null) {
                imageViewPhoto.setImageURI(data.getData());
            }
        }
    }
}
