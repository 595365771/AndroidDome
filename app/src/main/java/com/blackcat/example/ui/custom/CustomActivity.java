package com.blackcat.example.ui.custom;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.blackcat.example.R;
import com.blackcat.example.utils.GlideUtils;

public class CustomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        GlideUtils.laodImg(this,getApplication(),this,new FragmentActivity());
    }
}
