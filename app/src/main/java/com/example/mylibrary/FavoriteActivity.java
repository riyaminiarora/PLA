package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class FavoriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        RecyclerView recyclerView=findViewById(R.id.bookfRecView);
        BookRecViewAdapter adapter=new BookRecViewAdapter(this,"favoriteBooks");
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setBooks(Utils.getFavoriteBooks());
    }
    public void onBackPressed() {
        //super.onBackPressed();
        Intent intent =new Intent(this,MainActivity.class);
        //This is used to clear the back stack (history of user's visit to an activity) and define this intent as a new task.On pressing back button we exit the app
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
    }
