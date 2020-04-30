package com.saikat.e_pharm.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.saikat.e_pharm.R;

public class FragmentTab extends Fragment {
    String string;
    TextView textView;

    public FragmentTab( String string) {
        this.string = string;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_tab,container,false);
        textView = view.findViewById(R.id.tab);
        if (string.equals("Delivered")){
            textView.setText(string);
        }else if (string.equals("Canceled")){
            textView.setText(string);
        }else
            textView.setText(string);

        return view;
    }

}
