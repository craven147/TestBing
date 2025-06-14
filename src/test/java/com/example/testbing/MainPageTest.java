package com.example.testbing;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class MainPageTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.bing.com/");


    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void search() {

        WebElement searchField = driver.findElement(By.cssSelector("#sb_form_q"));
        searchField.sendKeys("Selenium");
        searchField.submit();


        WebElement searchPageField = driver.findElement(By.cssSelector("#sb_form_q"));
        assertEquals("Selenium", searchPageField.getAttribute("value"));
    }

}
