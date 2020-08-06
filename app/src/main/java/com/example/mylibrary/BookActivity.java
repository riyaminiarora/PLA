package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {
    public static final String BOOK_ID_KEY="bookId";
    private TextView txtBookName,txtAuthor,txtPages,txtDescription;
    private Button btnAddToWantRead,btnAddToAlreadyRead,btnAddToCurrentlyReading,btnAddToFavourite;
    private ImageView bookImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        initViews();
        //String longDescription="lorem30";

        //Book book=new Book(1,"1Q84","Haruki Murakami",1350,"https://images.penguinrandomhouse.com/cover/9780307476463","A work of brilliance",longDescription);
        //Getting data from recyclyer view through intent
        Intent intent=getIntent();
        if(null!=intent){
            int bookId=intent.getIntExtra(BOOK_ID_KEY,-1);
            if(bookId!=-1){
                Book incomingBook=Utils.getInstance(this).getBookById(bookId);
                if(null!=incomingBook){
                    setData(incomingBook);
                    handleAlreadyRead(incomingBook);
                    handleWantToReadBooks(incomingBook);
                    handleCurrentlyReadingBooks(incomingBook);
                    handleFavoriteBooks(incomingBook);
                }
            }
        }
    }

    private void handleFavoriteBooks(final Book book) {
        ArrayList<Book> favoriteBooks=Utils.getInstance(this).getFavoriteBooks();
        boolean existInFavoriteBooks=false;

        for(Book b:favoriteBooks){
            if(b.getId()==book.getId()){
                existInFavoriteBooks =true;
            }

        }
        if(existInFavoriteBooks){
            btnAddToFavourite.setEnabled(false);
        }
        else{
            btnAddToFavourite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance(BookActivity.this).addToFavorite(book)){
                        Toast.makeText(BookActivity.this,"Book added",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(BookActivity.this, FavoriteActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(BookActivity.this,"Try again...",Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }

    }

    private void handleCurrentlyReadingBooks(final Book book) {
        ArrayList<Book> currentlyReadingBooks=Utils.getInstance(this).getCurrentlyReadingBooks();
        boolean existIncurrentlyReadingBooks=false;

        for(Book b:currentlyReadingBooks){
            if(b.getId()==book.getId()){
                existIncurrentlyReadingBooks =true;
            }

        }
        if(existIncurrentlyReadingBooks){
            btnAddToCurrentlyReading.setEnabled(false);
        }
        else{
            btnAddToCurrentlyReading.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance(BookActivity.this).addToCurrentlyReading(book)){
                        Toast.makeText(BookActivity.this,"Book added",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(BookActivity.this, CurrentlyReadingActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(BookActivity.this,"Try again...",Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }

    private void handleWantToReadBooks(final Book book) {
        ArrayList<Book> wantToReadBooks=Utils.getInstance(this).getWantToReadBooks();
        boolean existInWantToReadBooks=false;

        for(Book b:wantToReadBooks){
            if(b.getId()==book.getId()){
                existInWantToReadBooks=true;
            }

        }
        if(existInWantToReadBooks){
            btnAddToWantRead.setEnabled(false);
        }
        else{
            btnAddToWantRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance(BookActivity.this).addToWantToRead(book)){
                        Toast.makeText(BookActivity.this,"Book added",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(BookActivity.this, WantToReadActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(BookActivity.this,"Try again...",Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }

    /**
     * enable and disable button
     * add book to  already read list
     * @param book
     */
    private void handleAlreadyRead(final Book book) {
        ArrayList<Book> alreadyReadBooks=Utils.getInstance(this).getAlreadyReadBooks();
        boolean existInAlreadyReadBooks=false;

        for(Book b:alreadyReadBooks){
            if(b.getId()==book.getId()){
                existInAlreadyReadBooks=true;
            }

        }
        if(existInAlreadyReadBooks){
            btnAddToAlreadyRead.setEnabled(false);
        }
        else{
            btnAddToAlreadyRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance(BookActivity.this).addToAlreadyRead(book)){
                        Toast.makeText(BookActivity.this,"Book added",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(BookActivity.this, AlreadyReadBookActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(BookActivity.this,"Try again...",Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }


    }


    private void setData(Book book) {
        txtBookName.setText(book.getName());
        txtAuthor.setText(book.getAuthor());
        txtPages.setText(String.valueOf(book.getPages()));
        txtDescription.setText(book.getLongDesc());
        Glide.with(this).asBitmap().load(book.getImageUrl()).into(bookImage);
    }

    private void initViews() {
        txtBookName=findViewById(R.id.txtBookName);
        txtAuthor =findViewById(R.id.txtAuthorName);
        txtPages=findViewById(R.id.txtPages);
        txtDescription=findViewById(R.id.txtDescription);

        btnAddToWantRead=findViewById(R.id.btnAddToWantToReadList);
        btnAddToAlreadyRead=findViewById(R.id.btnAddToAlreadyReadList);
        btnAddToCurrentlyReading=findViewById(R.id.btnAddToCurrentlyReading);
        btnAddToFavourite=findViewById(R.id.btnAddToFavourite);

        bookImage=findViewById(R.id.imgBook);

    }
}