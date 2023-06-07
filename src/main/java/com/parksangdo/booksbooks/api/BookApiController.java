package com.parksangdo.booksbooks.api;

import com.parksangdo.booksbooks.api.model.BookSearchInput;
import com.parksangdo.booksbooks.api.model.BookSearchOutput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * <b>API</b>
 * <p>
 * 책 정보를 가져오는 api
 * </p>
 *
 * @author 박상도 <>
 * @since 2023/04/09
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BookApiController {

	private final BookApiService bookApi;


	@PostMapping("/bookApi")
	public @ResponseBody ResponseEntity<BookSearchOutput> bookApi(BookSearchInput bookSearchInput) throws ExecutionException, InterruptedException, TimeoutException {
		log.debug(bookSearchInput.toString());

		long current = System.currentTimeMillis();

		// naver api
		CompletableFuture<BookSearchOutput> searchOutputCompletableFutureNaver = CompletableFuture.supplyAsync(() -> bookApi.callApi(bookSearchInput));

		// aladin api
		///CompletableFuture<BookSearchOutput> searchOutputCompletableFutureAladin = CompletableFuture.supplyAsync(() -> bookApi.callApi(bookSearchInput));

		// receive
		CompletableFuture<Object> rst = CompletableFuture
				.anyOf(searchOutputCompletableFutureNaver);

		//BookSearchOutput result = (BookSearchOutput) rst.get(2000L, TimeUnit.MILLISECONDS);
		BookSearchOutput result = (BookSearchOutput) rst.get();

		long resultMilliseconds = System.currentTimeMillis() - current;
		log.debug("api call time :: ");
		log.debug(Long.toString(resultMilliseconds));

		return new ResponseEntity<>(result, HttpStatus.OK);

	}





}
