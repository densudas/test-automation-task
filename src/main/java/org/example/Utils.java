package org.example;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class Utils {

  public static void waitForElementToBeDisplayed(By by) {
    FluentWait<WebDriver> wait = new FluentWait<>(DriverFactory.getDriver());
    wait.withTimeout(Duration.ofSeconds(20));
    wait.pollingEvery(Duration.ofSeconds(1));
    wait.until(ExpectedConditions.visibilityOfElementLocated(by));
  }

  public static void waitForElementToBeDisplayed(WebElement element) {
    FluentWait<WebDriver> wait = new FluentWait<>(DriverFactory.getDriver());
    wait.withTimeout(Duration.ofSeconds(20));
    wait.pollingEvery(Duration.ofSeconds(1));
    wait.until(ExpectedConditions.visibilityOf(element));
  }

  public static void waitForInvisibilityOfElementLocated(By by) {
    FluentWait<WebDriver> wait = new FluentWait<>(DriverFactory.getDriver());
    wait.withTimeout(Duration.ofSeconds(20));
    wait.pollingEvery(Duration.ofSeconds(1));
    wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
  }
}
