package com.parksangdo.booksbooks.api.model;

import lombok.Data;

@Data
public class BookSearchEach {

    String title;
    String link;
    String image;
    String author;
    int price;
    int discount;
    String publisher;
    String isbn;
    String description;
    String pubdate;

}
