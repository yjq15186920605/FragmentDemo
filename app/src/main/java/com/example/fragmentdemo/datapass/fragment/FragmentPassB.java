package com.example.fragmentdemo.datapass.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.fragmentdemo.R;
import com.example.fragmentdemo.datapass.FragmentPassBetweenActivity;


public class FragmentPassB extends Fragment {


//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//    private String mParam1;
//    private String mParam2;
private Button btnPass;
    private TextView tvReceive,btnPassByInterface;
    private String mData;

    public FragmentPassB() {
        // Required empty public constructor
    }
    public void setData(String data){
        this.mData = data;
        tvReceive.setText(mData);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pass_b, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvReceive = view.findViewById(R.id.tv_b_receive);
        btnPass = view.findViewById(R.id.btn_pass_b);
        btnPassByInterface = view.findViewById(R.id.btn_pass_b_by_interface);
        tvReceive.setText(mData);

        btnPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 向FragmentA传递数据
                ((FragmentPassBetweenActivity) getActivity())
                        .fragmentA.setData("这是来自FragmentB的数据");
            }
        });

        //通过接口向FragmentA传递数据
        btnPassByInterface.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mFragmentBChangeListener != null){
                    mFragmentBChangeListener.onFragmentBChange("这是通过接口来自FragmentB的数据" );
                }
            }
        });



//监听FragmentA的变化，接收其变化数据
        ((FragmentPassBetweenActivity) getActivity())
                .fragmentA.setOnFragmentAChangeListener(new FragmentPassA.OnFragmentAChangeListener() {
            @Override
            public void onFragmentAChange(String data) {
                tvReceive.setText(data);
            }
        });

    }
    private OnFragmentBChangeListener mFragmentBChangeListener;
    public void setOnFragmentBChangeListener(OnFragmentBChangeListener fragmentBChangeListener){
        this.mFragmentBChangeListener = fragmentBChangeListener;
    }
    public interface OnFragmentBChangeListener{
        void onFragmentBChange(String data);
    }
}