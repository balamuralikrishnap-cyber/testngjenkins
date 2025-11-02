package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class GridTestExample {


    private WebDriver driver;
    private WebDriverWait wait;

    @Parameters({"browser"})
    @BeforeClass
    public void setup(String browser) throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        if(browser.equalsIgnoreCase("chrome")) {
            // Chrome-specific options
            options.addArguments("--start-maximized");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-notifications");
        } else {
            throw new IllegalArgumentException("Currently only Chrome is supported for this example.");
        }

        String hubURL = "http://localhost:4444/wd/hub";  // local Selenium Grid URL
        driver = new RemoteWebDriver(new URL(hubURL), options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Test(priority = 1)
    public void testPageLoadAndTitle() {
        driver.get("https://www.selenium.dev/");
        String title = driver.getTitle();
        System.out.println("Page title: " + title);
        Assert.assertTrue(title.toLowerCase().contains("selenium"));
    }

    @Test(priority = 2)
    public void testNavigationAndLinks() {
        driver.get("https://www.selenium.dev/");
        WebElement projectsLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Projects")));
        projectsLink.click();

        WebElement javaDocLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Selenium Java')]")));
        Assert.assertTrue(javaDocLink.isDisplayed());
    }

    @Test(priority = 3)
    public void testSearchFunctionality() {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        WebElement textInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("my-text")));
        textInput.sendKeys("Hello Grid!");

        WebElement checkbox = driver.findElement(By.name("my-check"));
        if(!checkbox.isSelected()) {
            checkbox.click();
        }

        WebElement submitBtn = driver.findElement(By.cssSelector("button"));
        submitBtn.click();

        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertTrue(message.getText().contains("Received!"));
    }

    @Test(priority = 4)
    public void testAlertsAndFrames() {
        driver.get("https://www.selenium.dev/selenium/web/modal.html");

        WebElement openModal = wait.until(ExpectedConditions.elementToBeClickable(By.id("openModal")));
        openModal.click();

        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-content")));
        Assert.assertTrue(modal.isDisplayed());

        WebElement closeModal = modal.findElement(By.xpath(".//button[text()='Close']"));
        closeModal.click();
    }

    @AfterClass
    public void teardown() {
        if(driver != null) {
            driver.quit();
        }
    }

}
