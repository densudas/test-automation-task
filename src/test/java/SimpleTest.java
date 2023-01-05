import org.example.DriverFactory;
import org.example.pages.AkamaiCareers;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class SimpleTest {

  @Test(description = "Unlogged customer is able to search for a job")
  public void test1() {

    int numberOfOffers = AkamaiCareers
        .navigateToPage()
        .setCountryFilter("Poland")
        .setKeywordLocationFilter("Senior Software Development Engineer in Test")
        .getNumberOfOffersFound();

    Assert.assertNotEquals(numberOfOffers, 0, "No offers found on page.");
  }

  @Test(priority = 1, description = "Customer is notified when no offers match given criteria")
  public void test2() {

    boolean isEmptyResultMessageDisplay = AkamaiCareers
        .navigateToPage()
        .setKeywordLocationFilter("Find Your Career”: XXX")
        .isEmptyResultMessageDisplay();

    Assert.assertTrue(isEmptyResultMessageDisplay, "Some offers found on page, but should not.");
  }

  @AfterSuite
  public void tearDown() {
    DriverFactory.closeAllDrivers();
  }
}
