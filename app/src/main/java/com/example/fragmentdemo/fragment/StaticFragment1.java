package com.example.fragmentdemo.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fragmentdemo.GlobalConstants;
import com.example.fragmentdemo.R;


public class StaticFragment1 extends Fragment {

    private static final String TAG = GlobalConstants.TAG;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    private TextView tvLike;
    private RadioButton rbLike,rbDislike;
    private RatingBar rbStar;

    public StaticFragment1() {
        // Required empty public constructor
        Log.d(GlobalConstants.TAG,"StaticFragment1: construct");
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StaticFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StaticFragment1 newInstance(String param1, String param2) {
        StaticFragment1 fragment = new StaticFragment1();
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
        }
        Log.d(GlobalConstants.TAG,"onCreate: StaticFragment1");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: StaticFragment1");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_static1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvLike = view.findViewById(R.id.tv_like);
        rbLike = view.findViewById(R.id.rb_like);
        rbDislike = view.findViewById(R.id.rb_dislike);
        rbStar = view.findViewById(R.id.rb_star);

        rbLike.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    tvLike.setText("app喜欢");
                }
            }
        });
        rbDislike.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    tvLike.setText("app不喜欢");
                }
            }
        });
        rbStar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if (fromUser){
                    Toast.makeText(getActivity(),"点了"+rating,Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated: StaticFragment1");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: StaticFragment1");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: StaticFragment1");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: StaticFragment1");
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView: StaticFragment1");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: StaticFragment1");
    }

    @Override
    public void onInflate(@NonNull Context context, @NonNull AttributeSet attrs, @Nullable Bundle savedInstanceState) {
        super.onInflate(context, attrs, savedInstanceState);
        Log.d(TAG, "onInflate: StaticFragment1");
    }
}