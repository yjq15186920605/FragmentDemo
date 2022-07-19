package com.example.fragmentdemo.datapass.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.fragmentdemo.R;
import com.example.fragmentdemo.datapass.DataPassTestActivity;


public class DataPassFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private TextView mTextView;
    private String mData;
    private int mIntData;
    private Button mButton,mButton2;

    private String mParam1;
    private String mParam2;

    public DataPassFragment(String data) {
        mParam1 = data;
    }
    public DataPassFragment() {
    }


    public void setParam1(String data)
    {
     this.mParam1 = data;
        if (!TextUtils.isEmpty(mParam1)){
            mTextView.setText(mParam1);
        }
    }

    public static DataPassFragment newInstance(String param1, String param2) {
        DataPassFragment fragment = new DataPassFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

            mData = getArguments().getString("data");
            mIntData = getArguments().getInt("int data");


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_data_pass, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTextView = view.findViewById(R.id.tv_content);
        mButton = view.findViewById(R.id.btn_pass_data_by_get_activity);
        mButton2 = view.findViewById(R.id.btn_pass_data_by_interface);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((DataPassTestActivity)getActivity()).setReceive("这是Fragment向Activity传递的数据");
            }
        });

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mFragmentDataChangeListener != null){
                    mFragmentDataChangeListener.onFragmentDataChange("这是Fragment通过接口向Activity传递的数据");
                }
            }
        });

        if (!TextUtils.isEmpty(mParam1)){
            mTextView.setText(mParam1);
        }
        if (!TextUtils.isEmpty(mData)){
            mTextView.setText(mData+mIntData);
        }

        ((DataPassTestActivity)getActivity()).setOnDataChangeListener(new DataPassTestActivity.OnDataChangeListener() {
            @Override
            public void onDataChange(String data) {
                if (!TextUtils.isEmpty(data)){
                    mTextView.setText(data);
                }
            }
        });
    }

    private OnFragmentDataChangeListener mFragmentDataChangeListener;

    public void setFragmentDataChangeListener(OnFragmentDataChangeListener fragmentDataChangeListener){
        this.mFragmentDataChangeListener = fragmentDataChangeListener;
    }

    public interface OnFragmentDataChangeListener{
        void onFragmentDataChange(String data);
    }
}