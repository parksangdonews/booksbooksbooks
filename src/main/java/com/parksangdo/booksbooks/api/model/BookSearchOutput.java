package com.parksangdo.booksbooks.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BookSearchOutput {

    String lastBuildDate;
    int total;
    int start;
    int display;
    List<BookSearchEach> items;

    // using on error
    String errorMessage;
    String errorCode;

}



/*
        출력 결과 설명 표
        요청 변수	값	설명
        rss	-	디버그를 쉽게 하고 RSS 리더기만으로 이용할 수 있게 하기 위해 만든 RSS 포맷의 컨테이너이며 그 외의 특별한 의미는 없다.
        channel	-	검색 결과를 포함하는 컨테이너이다. 이 안에 있는 title, link, description 등의 항목은 참고용으로 무시해도 무방하다.
        lastBuildDate	datetime	검색 결과를 생성한 시간이다.
        total	integer	검색 결과 문서의 총 개수를 의미한다.
        start	integer	검색 결과 문서 중, 문서의 시작점을 의미한다.
        display	integer	검색된 검색 결과의 개수이다.
        item/items	-	XML 포멧에서는 item 태그로, JSON 포멧에서는 items 속성으로 표현된다. 개별 검색 결과이며 title, link, description을 포함한다.
        title	string	검색 결과 문서의 제목을 나타낸다. 제목에서 검색어와 일치하는 부분은 태그로 감싸져 있다.
        link	string	검색 결과 문서의 하이퍼텍스트 link를 나타낸다.
        image	string	썸네일 이미지의 URL이다. 이미지가 있는 경우만 나타납난다.
        author	string	저자 정보이다.
        price	integer	정가 정보이다. 절판도서 등으로 가격이 없으면 나타나지 않는다.
        discount	integer	할인 가격 정보이다. 절판도서 등으로 가격이 없으면 나타나지 않는다.
        publisher	string	출판사 정보이다.
        isbn	integer	ISBN 넘버이다.
        description	string	검색 결과 문서의 내용을 요약한 패시지 정보이다. 문서 전체의 내용은 link를 따라가면 읽을 수 있다. 패시지에서 검색어와 일치하는 부분은 태그로 감싸져 있다.
        pubdate	datetime	출간일 정보이다.

*/
