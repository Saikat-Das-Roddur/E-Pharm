package com.saikat.e_pharm.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.saikat.e_pharm.Activities.MainActivity;
import com.saikat.e_pharm.Activities.NotificationActivty;
import com.saikat.e_pharm.Adapters.BlogAdapter;
import com.saikat.e_pharm.Adapters.ViewPagerImageAdapter;
import com.saikat.e_pharm.Model.Blog;
import com.saikat.e_pharm.R;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment implements View.OnClickListener {

    ImageView imageViewDrawer,imageViewAccount,imageViewNotification;

    RecyclerView recyclerViewBlog,recyclerViewAwareness;
    BlogAdapter blogAdapter;
    ViewPager viewPager;
    Context context;
    LinearLayoutManager layoutManagerBlog,layoutManagerAwareness;

    ArrayList<Blog> blogArrayList = new ArrayList<>();
    Timer timer;
    int currentPage = 0;
    private int[] imageUrls = new int[]{
            R.drawable.gecko,
            R.drawable.fish,
            R.drawable.bivalvia,
            R.drawable.scyphozo,
            R.drawable.echinoidea
    };



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getContext();
        final View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_home, container, false);
        viewPager = view.findViewById(R.id.image_view_pager);
        imageViewDrawer = view.findViewById(R.id.menuIv);
        imageViewAccount = view.findViewById(R.id.accountIv);
        imageViewNotification = view.findViewById(R.id.notiIv);
        recyclerViewBlog = view.findViewById(R.id.blogRv);
        recyclerViewAwareness = view.findViewById(R.id.awarenessRv);

        blogArrayList.add(new Blog("",R.mipmap.camera_colored,"Title1","Description1",true));
        blogArrayList.add(new Blog("",R.mipmap.camera_colored,"Title2","Description2",true));
        blogArrayList.add(new Blog("",R.mipmap.camera_colored,"Title3","Description3",false));
        blogArrayList.add(new Blog("",R.mipmap.camera_colored,"Title4","Description4",true));
        blogArrayList.add(new Blog("",R.mipmap.camera_colored,"Title5","Description5",true));
        blogArrayList.add(new Blog("",R.mipmap.camera_colored,"Title6","Description6",true));
        blogArrayList.add(new Blog("",R.mipmap.camera_colored,"Title7","Description7",true));

        blogAdapter = new BlogAdapter(context,blogArrayList);
        layoutManagerBlog = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
        layoutManagerBlog.scrollToPosition(Integer.MAX_VALUE/2);
        recyclerViewBlog.setLayoutManager(layoutManagerBlog);
        recyclerViewBlog.setAdapter(blogAdapter);

        imageViewDrawer.setOnClickListener(this);
        imageViewAccount.setOnClickListener(this);
        imageViewNotification.setOnClickListener(this);
        showImageSlider();
        return view;
    }

    public void showImageSlider(){

        ViewPagerImageAdapter adapter = new ViewPagerImageAdapter(getContext(), imageUrls);
        viewPager.setAdapter(adapter);
        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if (currentPage == blogArrayList.size()){
                    currentPage= 0;
                    viewPager.setCurrentItem(currentPage,true);
                }
                viewPager.setCurrentItem(currentPage++,true);
            }
        };
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        },300,6000);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.menuIv:
                ((MainActivity)context).drawerOpen();
                break;
            case R.id.accountIv:
                ((MainActivity)context).setViewPagerPosition(2);
                break;
            case R.id.notiIv:
                startActivity(new Intent(context,NotificationActivty.class));
                break;
        }



    }



}
