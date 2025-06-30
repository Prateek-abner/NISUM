package com.example.demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GoogleSearchTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.getDriver();
    }

    @Test
    public void testGoogleSearch() {
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("BDD in Selenium");
        WebElement searchButton = driver.findElement(By.name("btnK"));
        searchButton.click();
        WebElement results = driver.findElement(By.id("search"));
        assertTrue(results.isDisplayed(), "Search results should be displayed");
    }

    @AfterEach
    public void tearDown() {
        WebDriverFactory.quitDriver();
    }
}
