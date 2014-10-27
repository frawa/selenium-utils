package com.pojosontheweb.selenium;

import com.google.common.base.Function;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleRawTest {

    @Test
    public void testChrome() {
        System.out.println("Testing with Chrome");
        performTest(
                DriverBuildr
                        .chrome()
                        .build()
        );
    }

    @Test
    public void testFirefox() {
        System.out.println("Testing with Firefox");
        performTest(
                DriverBuildr
                        .firefox()
                        .build()
        );
    }

    public static void performTest(final WebDriver driver) {

        try {

            // get google
            driver.get("http://www.google.com");

            // type in our query
            new Findr(driver)
                    .elem(By.id("gbqfq"))
                    .sendKeys("pojos on the web");
            new Findr(driver)
                    .elem(By.cssSelector("button.gbqfb"))
                    .click();

            // check the results
            new Findr(driver)
                    .elem(By.id("search"))
                    .elemList(By.cssSelector("h3.r"))
                    .at(0)
                    .elem(By.tagName("a"))
                    .where(Findrs.textStartsWith("POJOs on the Web"))
                    .eval();

            System.out.println("OK !");

            // regexp matching
            new Findr(driver)
                    .elem(By.id("search"))
                    .elemList(By.cssSelector("h3.r"))
                    .at(0)
                    .elem(By.tagName("a"))
                    .where(Findrs.textMatches("^POJOs.*"))
                    .eval();

        } finally {
            driver.quit();
        }
    }


}
