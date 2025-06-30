package com.example.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CrossBrowserTest {
    private WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) {
        driver = WebDriverFactory.getDriver(browser);
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

    @AfterMethod
    public void tearDown() {
        WebDriverFactory.quitDriver(driver);
    }
}
