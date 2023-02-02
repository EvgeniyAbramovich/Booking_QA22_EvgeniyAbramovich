package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookingResultsPage extends BasePage{

    private final static By SEARCH_RESULTS = By.cssSelector("#search_results_table .d20f4628d0");

    public BookingResultsPage(WebDriver driver) {
        super(driver);
    }

    public String getSearchResultTextByIndex(int index) {
       return getSearchResultByIndex(index).getText();
    }

    private WebElement getSearchResultByIndex(int index) {
        return driver.findElements(SEARCH_RESULTS).get(index - 1);
    }

}
