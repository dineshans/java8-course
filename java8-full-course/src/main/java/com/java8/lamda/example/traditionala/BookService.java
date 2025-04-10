package com.java8.lamda.example.traditionala;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookService {

    public List<Book> getAllBooksInSortingOrder() {

       List<Book> bookList = new BookDAO().getBooks();
        //Collections.sort(bookList, new MyComparator());

        // instead of writting as above, we can directly call using lambda expression

        Collections.sort(bookList, (o1,o2) -> o1.getBookName().compareTo(o2.getBookName()));
        return bookList;
    }

    public static void main(String[] args) {
        BookService bookService = new BookService();
        List<Book> bookList = bookService.getAllBooksInSortingOrder();
        System.out.println("Books are in sorted order : ");
        for(Book b1 : bookList) {
            System.out.println("  " + b1);
        }
    }
}

class MyComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        return o1.getBookName().compareTo(o2.getBookName());
    }
}
