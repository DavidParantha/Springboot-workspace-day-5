package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductServicesController {
	@GetMapping("/product")
	public String getProduct()throws Exception
	{
		Thread.sleep(5000);
		return "Laptop price: Ruppes- 65000 ";
		
	}

}
