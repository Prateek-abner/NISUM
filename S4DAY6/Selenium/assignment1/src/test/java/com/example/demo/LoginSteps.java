package com.example.demo;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {
    private final WebDriver driver = WebDriverFactory.getDriver();

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver.get("https://the-internet.herokuapp.com/login"); // Example login page
    }

    @When("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    @Then("I should be redirected to the dashboard")
    public void i_should_be_redirected_to_the_dashboard() {
        assertTrue(driver.getCurrentUrl().contains("secure"));
    }

    @Then("I should see a welcome message")
    public void i_should_see_a_welcome_message() {
        assertTrue(driver.findElement(By.id("flash")).getText().contains("You logged into a secure area!"));
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String errorMessage) {
        assertTrue(driver.findElement(By.id("flash")).getText().contains(errorMessage));
    }

    @After
    public void tearDown() {
        WebDriverFactory.quitDriver();
    }
}
