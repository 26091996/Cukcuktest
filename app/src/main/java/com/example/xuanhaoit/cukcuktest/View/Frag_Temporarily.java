package com.example.xuanhaoit.cukcuktest.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xuanhaoit.cukcuktest.R;

/**
 * Created by XuanHaoIT on 10/08/2017.
 */

public class Frag_Temporarily extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_tam_tinh,container,false);
        return view;
    }
}
