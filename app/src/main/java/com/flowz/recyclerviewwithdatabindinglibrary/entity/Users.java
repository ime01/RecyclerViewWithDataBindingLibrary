package com.flowz.recyclerviewwithdatabindinglibrary.entity;

import android.view.View;
import android.widget.ImageView;

import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;

public class Users {
    public String names;
    public String emails;
    public int imageId;


    public Users(String names, String emails, int imageId) {
        this.names = names;
        this.emails = emails;
        this.imageId = imageId;
    }

    @BindingAdapter("android:imageUrl")
    public static void loadImage (View view, int imageId){

        ImageView imageView = (ImageView) view;
        imageView.setImageDrawable(ContextCompat.getDrawable(view.getContext(), imageId));

    }


}
