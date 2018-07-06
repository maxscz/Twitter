package com.example.cesarsantacruz.tw.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.cesarsantacruz.tw.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomPagerAdapter extends PagerAdapter{
    Context mContext;
    LayoutInflater mLayoutInflater;
    ArrayList<String> urlPictures;
    public CustomPagerAdapter(Context context, ArrayList<String> urlPictures) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.urlPictures = urlPictures;
    }

    @Override
    public int getCount() {
        return urlPictures.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.item_pager_galeries, container, false);

        ImageView imageView =  itemView.findViewById(R.id.iv_image);
        Picasso.get().load(urlPictures.get(position)).into(imageView);

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
