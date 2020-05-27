package com.example.fragmentstest2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class fragmentB extends Fragment {

    String value = "Please Select a Famlily Member from the List!";

    // The constructor here takes a String.
    // Return the fragment.

    public static fragmentB newInstance(String text) {
        fragmentB fragment = new fragmentB();
        fragment.value = text;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){

        return inflater.inflate(R.layout.fragment_b_layout,parent,false);

    }
    // All fragment B really does it set a TextView.
    // But you can what ever here.
    // Again onViewCreated is better.
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView textView = view.findViewById(R.id.fragmentBTextField);
        textView.setText(value);


        }

}
