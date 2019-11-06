package com.ahnsafety.ex55recycleview2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter adapter;
    ArrayList<Item> datas= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //데이터 추가작업
        datas.add(new Item("루피","해적단 선장",R.drawable.ch_luffy,R.drawable.img01));
        datas.add(new Item("조로","해적단 부선장 ",R.drawable.ch_zoro,R.drawable.img02));
        datas.add(new Item("나미","해적단 항해사",R.drawable.ch_nami,R.drawable.img03));
        datas.add(new Item("상디","해적단 요리사",R.drawable.ch_sandi,R.drawable.img04));
        datas.add(new Item("우솝","해적단 저격수",R.drawable.ch_usoup,R.drawable.img05));
        datas.add(new Item("쵸파","해적단 의사",R.drawable.ch_chopa,R.drawable.img06));
        datas.add(new Item("겨울왕국","눈싸움",R.drawable.winter,R.drawable.winter));

        recyclerView= findViewById(R.id.recycler);
        adapter=new MyAdapter(datas,this);
        recyclerView.setAdapter(adapter);

        //리사이클러뷰 및 아이템 꾸미기
        MyRecyclerDecoration decoration= new MyRecyclerDecoration();
        recyclerView.addItemDecoration(decoration);

        //리사이클러뷰의 아이템이 변경될 때 애니메이션 효과
        MyRecyclerAnimator animator= new MyRecyclerAnimator();
        recyclerView.setItemAnimator(animator);


    }

    public void clickAdd(View view) {
        Item item= new Item("NEW","message",R.drawable.ch_sandi,R.drawable.img04);
        datas.add(0,item);

        //데이터가 변경되었다고 공지(notify)
        adapter.notifyItemInserted(0);
        recyclerView.scrollToPosition(0);
    }

    public void clickDel(View view) {
        if(datas.size()==0) return;

        datas.remove(0);
        adapter.notifyItemRemoved(0);
    }

    public void clickLinear(View view) {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    public void clickGrid(View view) {
        GridLayoutManager gridLayoutManager =new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);

    }
}
