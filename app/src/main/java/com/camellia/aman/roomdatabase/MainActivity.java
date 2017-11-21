package com.camellia.aman.roomdatabase;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.camellia.aman.roomdatabase.db.Repo;
import com.camellia.aman.roomdatabase.db.RepoDatabase;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context context = MainActivity.this;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.tvTextHello);

        RepoDatabase
                .getInstance(context)
                .getRepoDao()
                .insert(new Repo("1", "Amandeep Tomar", "url"));

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Repo> repoList=RepoDatabase.getInstance(context)
                        .getRepoDao().getAllRepos();

                Log.e("test room datbase",repoList.size()+" "+repoList.get(0).name);
            }
        });


    }







}
