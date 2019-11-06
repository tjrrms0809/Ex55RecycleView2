package com.ahnsafety.ex55recycleview2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecyclerDecoration extends RecyclerView.ItemDecoration {


    //리사이클러 뷰 위에 그러지는 그림 그릴 때 사용
    @Override
    public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDrawOver(c, parent, state);

        Bitmap bm= BitmapFactory.decodeResource(parent.getResources(),R.drawable.ch_chopa);
        bm=Bitmap.createScaledBitmap(bm,256,256,true);
        c.drawBitmap(bm,100,100,null);

    }

    //아이템뷰마다 마다의 위치를 조금씩 변경하고자 할때
    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        if(parent.getLayoutManager() instanceof GridLayoutManager){

            int position= parent.getChildAdapterPosition(view);

            if(position%2==0){
                outRect.set(0,0,30,0);
            }
        }
    }
}
