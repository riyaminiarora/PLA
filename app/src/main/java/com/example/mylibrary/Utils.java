package com.example.mylibrary;

import java.util.ArrayList;

//Database class(It is a singleton class)
public class Utils {
    private static Utils instance;

    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> alreadyReadBooks;
    private static ArrayList<Book> wantToReadBooks;
    private static ArrayList<Book> currentlyReadingBooks;
    private static ArrayList<Book> favoriteBooks;

    private Utils(){
        if(null==allBooks){
            allBooks=new ArrayList<>();
            initData();
        }
        if(null==alreadyReadBooks){
            alreadyReadBooks=new ArrayList<>();
        }
        if(null==wantToReadBooks){
            wantToReadBooks=new ArrayList<>();
        }
        if(null==currentlyReadingBooks){
            currentlyReadingBooks=new ArrayList<>();
        }
        if(null==favoriteBooks){
            favoriteBooks=new ArrayList<>();
        }

    }

    private void initData() {
        //todo add data
        allBooks.add(new Book(1,"1Q84","Haruki Murakami",1350,"https://images.penguinrandomhouse.com/cover/9780307476463","A work of brilliance","long Desc"));
    }

    public static Utils getInstance() {
        //logic for making this class singleton
        if(null!=instance){
            return instance;
        }
        else{
            instance=new Utils();
            return instance;
        }

    }

    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Book> getAlreadyReadBooks() { return alreadyReadBooks; }

    public static ArrayList<Book> getWantToReadBooks() {
        return wantToReadBooks;
    }

    public static ArrayList<Book> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }

    public static ArrayList<Book> getFavoriteBooks() {
        return favoriteBooks;
    }
    public Book getBookById(int id){
        for(Book b:allBooks){
            if(b.getId()==id){
                return b;
            }
        }
        return null;
    }

    public boolean addToAlreadyRead(Book book){
        return alreadyReadBooks.add(book); //returns true if book added

    }
    public boolean addToWantToRead(Book book){
        return wantToReadBooks.add(book); //returns true if book added

    }
    public boolean addToFavorite(Book book){
        return favoriteBooks.add(book); //returns true if book added

    }
    public boolean addToCurrentlyReading(Book book){
        return currentlyReadingBooks.add(book); //returns true if book added

    }
    public boolean removeFromAlreadyRead(Book book){
       return alreadyReadBooks.remove(book); //returns true if book removed from arraylist
    }
    public boolean removeFromWantToRead(Book book){
        return wantToReadBooks.remove(book); //returns true if book removed from arraylist
    }
    public boolean removeFromFavorites(Book book){
        return favoriteBooks.remove(book); //returns true if book removed from arraylist
    }
    public boolean removeFromCurrentlyReading(Book book){
        return currentlyReadingBooks.remove(book); //returns true if book removed from arraylist
    }

}
