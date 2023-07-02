package com.example;

import com.example.ReusableMethods.BrowserUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);
		BrowserUtils.openWebsite("adidas");
	}

}
