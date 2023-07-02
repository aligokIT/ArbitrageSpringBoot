package com.example.ReusableMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserUtils {
    static WebDriver driver;
    public static void openWebsite(String websiteName) {
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--headless=chrome");
        driver = new ChromeDriver();
        driver.get("https://" + websiteName+".com");
        System.out.println("CurrentUrl: " +driver.getCurrentUrl());

    }
}
