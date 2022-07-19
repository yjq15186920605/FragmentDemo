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


public class FragmentPassA extends Fragment {


//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    private String mParam1;
//    private String mParam2;

    private Button btnPass,btnPassByInterface;
    private TextView tvReceive;
    private String mData;


    public FragmentPassA() {

    }

    public void setData(String data){
        this.mData = data;
        tvReceive.setText(mData);
    }


//    public static FragmentPassA newInstance(String param1, String param2) {
//        FragmentPassA fragment = new FragmentPassA();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
////        if (getArguments() != null) {
////            mParam1 = getArguments().getString(ARG_PARAM1);
////            mParam2 = getArguments().getString(ARG_PARAM2);
////        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pass_a, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvReceive = view.findViewById(R.id.tv_a_receive);
        btnPass = view.findViewById(R.id.btn_pass_a);
        btnPassByInterface = view.findViewById(R.id.btn_pass_a_by_interface);
        tvReceive.setText(mData);

        btnPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 向FragmentB传递数据
                Fragment fragmentB =
                        ((FragmentPassBetweenActivity) getActivity())
                                .getSupportFragmentManager().findFragmentById(R.id.fcv_b);

                if (fragmentB != null){

                    ((FragmentPassB)fragmentB).setData("这是FragmentA传来的数据");
                }

            }
        });
//通过接口向FragmentB传递数据
        btnPassByInterface.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mFragmentAChangeListener!=null){
                    mFragmentAChangeListener.onFragmentAChange("这是通过接口，来自FragmentA的数据");
                }
            }
        });

//监听FragmentB的变化，接收其变化数据
        ((FragmentPassBetweenActivity) getActivity())
                .fragmentB.setOnFragmentBChangeListener(new FragmentPassB.OnFragmentBChangeListener() {
            @Override
            public void onFragmentBChange(String data) {
                tvReceive.setText(data);
            }
        });

    }
    private OnFragmentAChangeListener mFragmentAChangeListener;
    public void setOnFragmentAChangeListener(OnFragmentAChangeListener fragmentAChangeListener){
        this.mFragmentAChangeListener = fragmentAChangeListener;
    }
    public interface OnFragmentAChangeListener{
        void onFragmentAChange(String data);
    }

}