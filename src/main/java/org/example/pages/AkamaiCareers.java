package org.example.pages;

import static org.example.Utils.waitForElementToBeDisplayed;
import static org.example.Utils.waitForInvisibilityOfElementLocated;

import org.example.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AkamaiCareers {

  private static final String URL = "https://akamaicareers.inflightcloud.com/";

  @FindBy(css = "input#keywordLocation")
  WebElement keywordLocationField;

  @FindBy(css = "input#location")
  WebElement locationField;

  @FindBy(css = "button[title='Search']")
  WebElement searchButton;

  @FindBy(css = "section#results")
  WebElement results;

  public AkamaiCareers() {
    PageFactory.initElements(DriverFactory.getDriver(), this);
  }

  public static AkamaiCareers navigateToPage() {
    DriverFactory.getDriver().get(URL);
    waitForElementToBeDisplayed(By.cssSelector("akamai-multi-input-search"));
    return new AkamaiCareers();
  }

  public AkamaiCareers setKeywordLocationFilter(String text) {
    keywordLocationField.sendKeys(text);
    searchButton.click();
    return this;
  }

  public AkamaiCareers setCountryFilter(String text) {
    locationField.sendKeys(text);
    String xpath = ".//ifc-taleo-lookup-rest[@controlid='location']//ul[@id='location_list']//li[normalize-space(text())='" + text + "']";
    waitForElementToBeDisplayed(By.xpath(xpath));
    locationField.sendKeys(Keys.ENTER);
    return this;
  }

  public int getNumberOfOffersFound() {
    waitForElementToBeDisplayed(results);
    waitForInvisibilityOfElementLocated(By.cssSelector("ui-loading-spinner"));
    return results.findElements(By.cssSelector(".list-group-item")).size();
  }

  public boolean isEmptyResultMessageDisplay() {
    waitForElementToBeDisplayed(results);
    waitForInvisibilityOfElementLocated(By.cssSelector("ui-loading-spinner"));
    return !DriverFactory.getDriver().findElements(By.xpath(
            ".//div[contains(@class,'count-and-sort')]//span[text()='We found 0 jobs based on your search criteria']"))
        .isEmpty();
  }
}
