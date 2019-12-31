package com.example.banksearchapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GalleryActivity extends AppCompatActivity
{

    private LinearLayout mGallery;
    private int[] mImgIds;
    private LayoutInflater mInflater;
    private HorizontalScrollView horizontalScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        mInflater = LayoutInflater.from(this);
        initData();
        initView();


    }

    private void initData()
    {
        mImgIds = new int[] { R.drawable.image_1, R.drawable.image_2, R.drawable.image_3,R.drawable.image_4,
                R.drawable.image_1, R.drawable.image_2, R.drawable.image_3,R.drawable.image_4,
                R.drawable.image_1, R.drawable.image_2, R.drawable.image_3,R.drawable.image_4
        };
    }

    private void initView()
    {
        mGallery = (LinearLayout) findViewById(R.id.id_gallery);

        for (int i = 0; i < mImgIds.length; i++)
        {

            View view = mInflater.inflate(R.layout.gallery_item,
                    mGallery, false);
            ImageView img = (ImageView) view
                    .findViewById(R.id.id_index_gallery_item_image);
            img.setImageResource(mImgIds[i]);
            TextView txt = (TextView) view
                    .findViewById(R.id.id_index_gallery_item_text);
            txt.setText("info "+i);
            mGallery.addView(view);
        }
    }
}
