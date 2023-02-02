package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.BookingResultsPage;
import pages.BookingSearchPage;

import java.util.concurrent.TimeUnit;

public class BookingSearchSteps {
    WebDriver driver;
    BookingSearchPage bookingSearchPage;
    BookingResultsPage bookingResultsPage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        bookingSearchPage = new BookingSearchPage(driver);
        bookingResultsPage = new BookingResultsPage(driver);

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("I am at booking.com page")
    public void navigateToBookingSearchPage() {
        bookingSearchPage.open();
    }

    @When("I set {string} into search bar")
    public void iSetHiltonIntoSearchBar(String value) {
        bookingSearchPage.setSearchValue(value);
    }

    @And("I click on Search button")
    public void iClickOnSearchButton() {
        bookingSearchPage.clickSearchButton();
    }

    @Then("{string} should be present in first search result title")
    public void hiltonShouldBePresentInFirstSearchResultTitle(String value) {
       String resultText =  bookingResultsPage.getSearchResultTextByIndex(1);
        Assert.assertTrue(resultText.contains(value));
    }
}
