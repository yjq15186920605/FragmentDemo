package com.example.fragmentdemo.fragment;

import android.content.Context;
import android.os.Bundle;
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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragmentdemo.GlobalConstants;
import com.example.fragmentdemo.R;


public class DynamicFragment extends Fragment {

    private static final String TAG = GlobalConstants.TAG;
    public static final String ARG_PARAM1 = "param1";
    public static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    private TextView tvLike,tvContent;
    private RadioButton rbLike,rbDislike;
    private RatingBar rbStar;

    public DynamicFragment() {
        // Required empty public constructor
        Log.d(TAG, "DynamicFragment: construct");
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
    public static DynamicFragment newInstance(String param1, String param2) {
        DynamicFragment fragment = new DynamicFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: DynamicFragment");
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: DynamicFragment");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dynamic, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreated: DynamicFragment");
        tvLike = view.findViewById(R.id.tv_like);
        rbLike = view.findViewById(R.id.rb_like);
        rbDislike = view.findViewById(R.id.rb_dislike);
        rbStar = view.findViewById(R.id.rb_star);
        tvContent = view.findViewById(R.id.tv_content);

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
        tvContent.setText(mParam1);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated: DynamicFragment");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: DynamicFragment");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: DynamicFragment");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: DynamicFragment");
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView: DynamicFragment");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: DynamicFragment");
    }

    @Override
    public void onInflate(@NonNull Context context, @NonNull AttributeSet attrs, @Nullable Bundle savedInstanceState) {
        super.onInflate(context, attrs, savedInstanceState);
        Log.d(TAG, "onInflate: DynamicFragment");
    }
}