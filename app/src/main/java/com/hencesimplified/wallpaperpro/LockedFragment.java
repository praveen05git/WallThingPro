package com.hencesimplified.wallpaperpro;


import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class LockedFragment extends Fragment {

    private List<SamplePhotos> listPhotos;
    private RecyclerView myRecyclerView;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private RecyclerViewAdapter myAdapter;


    public LockedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_locked_fg, container, false);


        firebaseDatabase = FirebaseDatabase.getInstance();
        listPhotos = new ArrayList<>();
        myRecyclerView = root.findViewById(R.id.locked_rec_id);
        myRecyclerView.setHasFixedSize(true);
        myRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        myAdapter = new RecyclerViewAdapter(getContext(), listPhotos);

        SharedPreferences pref = getContext().getSharedPreferences("ProPref", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("ProPage", 5);
        editor.apply();

        databaseReference = firebaseDatabase.getReference("locked");


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    SamplePhotos photos = postSnapshot.getValue(SamplePhotos.class);
                    listPhotos.add(photos);
                }

                myRecyclerView.setAdapter(myAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        return root;
    }

}
