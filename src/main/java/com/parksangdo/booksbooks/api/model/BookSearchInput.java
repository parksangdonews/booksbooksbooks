package com.parksangdo.booksbooks.api.model;

import lombok.Builder;
import lombok.Data;

/**
 * The type Book search input.
 * query	string	-	-	검색을 원하는 문자열로서 UTF-8로 인코딩한다.	상세검색시 생략가능
 * display	integer	N	10(기본값), 100(최대)	검색 결과 출력 건수 지정
 * start	integer	N	1(기본값), 1000(최대)	검색 시작 위치로 최대 1000까지 가능
 * sort	string	N	sim(기본값), date	정렬 옵션: sim(유사도순), date(출간일순), count(판매량순)
 */
@Data
public class BookSearchInput {
    
    String query;
    int display;
    int start;
    String sort;

    /**
     * Instantiates a new Book search input.
     *
     * @param query the query
     */
    public BookSearchInput(String query) {
        this.query = query;
        this.display = 24;
        this.start = 1;
        this.sort = "sim";
    }

}
