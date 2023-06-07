package com.parksangdo.booksbooks.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.parksangdo.booksbooks.api.model.BookSearchInput;
import com.parksangdo.booksbooks.api.model.BookSearchOutput;
import lombok.extern.slf4j.Slf4j;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.net.URIBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

@Service
@Slf4j
public class BookApiService {

    public static final String API_URI = "https://openapi.naver.com/v1/search/book.json";

    //@Value("${api.id:90NaqIpDfd9MKHwWpwMI}")
    @Value("${api.id}")
    private String apiId;

    //@Value("${api.pw:cluz_oS884}")
    @Value("${api.pw}")
    private String apiKey;

    public BookSearchOutput callApi(BookSearchInput bookSearchInput) {
        log.debug("input ::: ");
        log.debug(bookSearchInput.toString());

        // set
        log.debug("API_SET ::::::::::::::::::::0::::::::::::::::::::::::::::::::::::::::::");
        log.debug(API_URI);
        log.debug(apiId);
        log.debug(apiKey);
        log.debug("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

        ObjectMapper mapper = new ObjectMapper();

        try (CloseableHttpClient closeableHttpClient = HttpClients.createDefault()) {

            // set serach key
            URI uri = new URI(API_URI);
            URIBuilder uriBuilder = new URIBuilder(uri, StandardCharsets.UTF_8)
                    .addParameter("query", bookSearchInput.getQuery())
                    .addParameter("display", Integer.toString(bookSearchInput.getDisplay()))
                    .addParameter("start", Integer.toString(bookSearchInput.getStart()))
                    .addParameter("sort", bookSearchInput.getSort());

            HttpGet httpGet = new HttpGet(uriBuilder.toString());

            // set header
            httpGet.setHeader("X-Naver-Client-Id", apiId);
            httpGet.setHeader("X-Naver-Client-Secret", apiKey);

            BookSearchOutput output = closeableHttpClient.execute(httpGet, httpResponse -> mapper.readValue(httpResponse.getEntity().getContent(), BookSearchOutput.class));

            return output;

        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

        return new BookSearchOutput(); // notthing

    }
}
