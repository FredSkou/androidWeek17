package com.example.fragmentstest2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private fragmentA fa;
    private fragmentB fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // We have to initialize the 2 fragments before we can use them.
        fa = fragmentA.newInstance(this);
        fb = fragmentB.newInstance("Please Select a Family Member From the List!");
        updateFragment(R.id.mainFrameLayout,fa);
        updateFragment(R.id.mainFrameLayout2,fb);

    }
    public void selectedItemFromFragment(String value){
        try {
            Log.i("myfragmentapp","Main Initinated!");

            // We get what ever was was selected from Fragment B
            // In this case just a String. We could take that String and do a Database Query
            // Here we just set fragment B with the String Value.
            fb = fragmentB.newInstance(value);
            updateFragment(R.id.mainFrameLayout2,fb);


        }catch (Exception e){
            Log.i("myfragmentapp","ERROR: "+e.getMessage());
        }
    }


    public void updateFragment(int frameLayout, Fragment fragment){

        // This is just a method to make the Fragments.
        // We could have this in the Methods them selves, but this is better.

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayout,fragment);
        fragmentTransaction.commit();

    }


}
