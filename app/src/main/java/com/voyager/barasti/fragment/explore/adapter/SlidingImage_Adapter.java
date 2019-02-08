package com.voyager.barasti.fragment.explore.adapter;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.squareup.picasso.Picasso;
import com.voyager.barasti.R;
import com.voyager.barasti.fragment.explore.model.ExploreHeader.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 19-Nov-18.
 */

public class SlidingImage_Adapter extends PagerAdapter {


    private ArrayList<Integer> IMAGES;
    private List<Banner> bannerArrayList;
    private LayoutInflater inflater;
    private Context context;


    public SlidingImage_Adapter(Context context, List<Banner> bannerArrayList) {
        this.context = context;
        this.bannerArrayList=bannerArrayList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return bannerArrayList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View imageLayout = inflater.inflate(R.layout.content_slidingimages, view, false);

        assert imageLayout != null;
        final ImageView imageView = (ImageView) imageLayout
                .findViewById(R.id.image);
        Banner banner = bannerArrayList.get(position);

        //imageView.setImageResource(IMAGES.get(position));
        Picasso.with(context)
                .load(banner.getImage_url())
                .placeholder(R.drawable.placeholder_image)
                .into(imageView);

        view.addView(imageLayout, 0);

        return imageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }


}