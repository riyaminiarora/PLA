package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class AlreadyReadBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_already_read_book);
        RecyclerView recyclerView=findViewById(R.id.bookaRecView);
        BookRecViewAdapter adapter=new BookRecViewAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setBooks(Utils.getAlreadyReadBooks());

    }

    /**
     * This method is called when user clicks on back button
     * It navigates user back to the main activity instead of the previous one.
     */
    @Override
    public void onBackPressed() {
       //super.onBackPressed();
        Intent intent =new Intent(this,MainActivity.class);
        //This is used to clear the back stack (history of user's visit to an activity) and define this intent as a new task.On pressing back button we exit the app
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}