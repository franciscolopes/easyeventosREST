package com.francisco.pds2.resources;

import org.springframework.web.bind.annotation.RequestMapping;

public class TesteLeitorQrcodeResource {

	@RequestMapping(value = "/")
	public String index() {
		return "index.html";
	}
}