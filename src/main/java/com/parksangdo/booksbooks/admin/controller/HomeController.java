package com.parksangdo.booksbooks.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <b>작업목적</b>
 * <p>
 * 작업내용
 * </p>
 *
 * @author 박상도 <>
 * @since 2023/04/09
 */
@Controller
public class HomeController {

	@GetMapping("/admin")
	public String home() {
		return "/home";
	}



	@GetMapping(value = {"/", "/index"})
	public String index() {
		return "/index";
	}



}
