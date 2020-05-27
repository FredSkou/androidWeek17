package com.example.fragmentstest2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class fragmentA extends Fragment {

    private MainActivity mainActivity;

    // The constructor connectects the Fragment to the Main activity.
    // return fragment A.

    public static fragmentA newInstance(MainActivity mainActivity){
        fragmentA fragment = new fragmentA();
        fragment.mainActivity = mainActivity;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle instanceSavedState){

        return inflater.inflate(R.layout.fragment_a_layout,parent,false);

    }

    //Because onCreateView sometimes crashes, put all important things in onViewCreated
    //Its called right after so its no big deal
    //Also, You cannot add an Adapter to a ListView in onCreateView, the view isnt there yet.

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        ArrayList<String> familyMembers = new ArrayList<>();


        familyMembers.add("Fred");
        familyMembers.add("Shuai");
        familyMembers.add("Josephine");

        final ListView listView = view.findViewById(R.id.fragmentAListView);
        ListAdapter adapter = new ArrayAdapter<>(view.getContext(),android.R.layout.simple_list_item_1,familyMembers);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // Here we attach an onItemClick listener.
            // We have to put the selected item in a Bundle and then pass it to the main activity.
            // Normally we just ude an Intent, but since we are working with fragments this is better.
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("myfragmentapp","onClick initiated!");
                String selectedItem = (String) listView.getItemAtPosition(position);
                Bundle bundle = new Bundle();
                bundle.putString("key",selectedItem);
                if (selectedItem !=null){
                    Log.i("myfragmentapp","Selected Item in fragmen A: "+selectedItem+" Bundle is :"+bundle.getString("key",""));
                    mainActivity.selectedItemFromFragment(bundle.getString("key"));
                }else
                    Log.i("myfragmentapp","Selected Item is null!");
            }
        });





    }
}
