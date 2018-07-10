package com.example.cesarsantacruz.tw.Activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.cesarsantacruz.tw.Adapters.CustomPagerAdapter;
import com.example.cesarsantacruz.tw.R;

import java.util.ArrayList;

public class GalleryActivity extends AppCompatActivity {
    CustomPagerAdapter mCustomPagerAdapter;
    ArrayList<String> intentString;
    int imageViewPosition;
    ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        intentString = getIntent().getExtras().getStringArrayList("image");
        imageViewPosition = getIntent().getExtras().getInt("position");
        mCustomPagerAdapter = new CustomPagerAdapter(this,intentString);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mCustomPagerAdapter);
        mViewPager.setCurrentItem(imageViewPosition);

    }
}
