package com.ahnsafety.ex55recycleview2;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecyclerAnimator extends DefaultItemAnimator {

    @Override
    public boolean animateAdd(RecyclerView.ViewHolder holder) {


        Animation ani= AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.appear_item);
        holder.itemView.startAnimation(ani);
        return super.animateAdd(holder);
    }
}
