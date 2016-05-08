package demo.driver.google.web;

import org.concordion.selenium.Browser;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * A WebDriver Page Object corresponding to the Google Search Page.
 */
public class GoogleSearchPage {

	@FindBy(name = "q")
	private WebElement queryBox;

	@FindBy(name = "btnG")
	private WebElement submitButton;

    @FindBy(className = "nonExistent")
    private WebElement nonExistentLink;

    private Browser browser;

	/**
	 * Opens the Google Search Page.
	 */
	public GoogleSearchPage(Browser browser) {
		this.browser = browser;
        WebDriver driver = browser.getDriver();
        PageFactory.initElements(driver, this);
		driver.get("http://www.google.com");
	}

    /**
     * Searches for the specified string and opens the results page,
     * waiting for the page to fully load.
     */
	public GoogleResultsPage searchFor(String query) {
        browser.getDriver().get("http://www.google.com");
	    queryBox.clear();
        queryBox.sendKeys(query);
        queryBox.sendKeys(Keys.ESCAPE);
		submitButton.click();
		return new GoogleResultsPage(browser);
	}

    public void clickOnNonExistentLink() {
        nonExistentLink.click();
    }
}
