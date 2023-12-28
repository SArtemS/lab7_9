package com.example.demo;

import org.jsoup.Jsoup;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	final String SITE_URL = "https://atlas.herzen.spb.ru/";

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		final var department = args[0];
		System.out.println("Department: " + department);
		final var doc = Jsoup.connect(SITE_URL + "/faculty.php").get();
		final var departmentUri = doc
				.select("a.alist:contains(" + department + ")")
				.attr("href");
		System.out.println("Department URL: " + SITE_URL + departmentUri);
	}
}
