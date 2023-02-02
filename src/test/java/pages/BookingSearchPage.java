package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookingSearchPage extends BasePage{
    public BookingSearchPage(WebDriver driver) {
        super(driver);
    }

    private final static By SEARCH_INPUT = By.id("b2indexPage");
    private final static By SEARCH_BUTTON = By.cssSelector(".js-sb-submit-text");

    public void open(){
        driver.get("https://www.booking.com");
    }

    public void setSearchValue(String value) {
        driver.findElement(SEARCH_INPUT).sendKeys(value);
    }

    public void clickSearchButton() {
        driver.findElement(SEARCH_BUTTON).click();
    }
}
