package com.example.inventorynavigation.iu.producto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.inventorynavigation.R;

public class ProductInfoFragment extends Fragment {

    public static final String TAG = "ProductInfoFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_product_info,null);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public static Fragment newInstance(Bundle bundle){
        ProductInfoFragment fragment = new ProductInfoFragment();
        if(bundle!=null){
            fragment.setArguments(bundle);
        }
        return fragment;
    }
}
