package com.flowz.recyclerviewwithdatabindinglibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.flowz.recyclerviewwithdatabindinglibrary.adapter.MyAdapter;
import com.flowz.recyclerviewwithdatabindinglibrary.databinding.ActivityMainBinding;
import com.flowz.recyclerviewwithdatabindinglibrary.entity.Users;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        activityMainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        activityMainBinding.recyclerView.setHasFixedSize(true);

        adapter = new MyAdapter(this, prepareUser());
        activityMainBinding.recyclerView.setAdapter(adapter);

    }

    private List<Users> prepareUser(){

        List<String> names = Arrays.asList(getResources().getStringArray(R.array.names));
        List<String> emails = Arrays.asList(getResources().getStringArray(R.array.emails));

        int [] imageId = {R.drawable.einstein, R.drawable.excited, R.drawable.excited2, R.drawable.greatjob, R.drawable.happyface,
        R.drawable.tryagain, R.drawable.tryagain2, R.drawable.sad_face_emoji, R.drawable.greatjob, R.drawable.happyface, R.drawable.tryagain};

        List<Users> Names = new ArrayList<>();

        int count = 0;

        for (String name : names){

            Names.add(new Users(name, emails.get(count), imageId[count]));
            count++;
        }
        return Names;
    }
}
