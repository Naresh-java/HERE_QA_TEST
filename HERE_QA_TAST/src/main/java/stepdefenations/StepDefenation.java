package stepdefenations;

import java.awt.AWTException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.AngularJSValidation;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefenation {
	WebDriver driver;
	List<WebElement> allLinks;
	String mainWindowHandle;

	@Given("^user is already launch application$")
	public void user_is_already_launch_application() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://developer.here.com");
		mainWindowHandle = driver.getWindowHandle();
	}

	@When("^click on documentation tab$")
	public void click_on_documentation_tab() {
		driver.findElement(
				By.xpath("//div[@class='navigation__bottom']//a[@target='_self']/span[text()=' Documentation ']"))
				.click();
	}

	@When("^fetch all internal links in documentation section$")
	public void fetch_all_internal_links_in_documentation_section() {
		allLinks = driver.findElements(By.xpath("//div[@class='cta-links']//li[@class='']//a"));
	}

	@Then("^iterate over the all internal links$")
	public void iterate_over_the_all_internal_links() throws IOException, AWTException, InterruptedException {
		Actions actions = new Actions(driver);
		for (WebElement link : allLinks) {
			actions.keyDown(Keys.CONTROL).perform();
			try {
				new WebDriverWait(driver, 50).until(ExpectedConditions.elementToBeClickable(link)).click();
				actions.keyUp(Keys.CONTROL).perform();
				Set<String> windows = driver.getWindowHandles();

				for (String window : windows) {
					driver.switchTo().window(window);
					String curl = driver.getCurrentUrl();
					if (!window.equals(mainWindowHandle)) {
						URL url = new URL(curl);
						HttpURLConnection http = (HttpURLConnection) url.openConnection();
						int statusCode = http.getResponseCode();
						if (200 == statusCode) {
							System.out.println("This url is Working :" + url + ", Status Code is : " + statusCode);
						} else {
							Assert.assertFalse("This url is Not Working , Status Code is : " + statusCode, true);
						}

						if (AngularJSValidation.angularIsBeingUsed(driver)) {
							boolean isAngularLoaded = AngularJSValidation.checkAngularIsLoaded(driver, 5);

							if (isAngularLoaded) {
								System.out.println("Angular JS is loaded successfully.");
							} else {

								Assert.assertFalse("Angular JS is NOT loaded successfully.", true);
							}
						} else {
							System.out.println("Angular JS is not used.");
						}

						driver.close();
						driver.switchTo().window(mainWindowHandle);
					}

				}

			} catch (Exception e) {
				break;
			}

		}

	}

	@Then("^Close the browser$")
	public void close_the_browser() {
		driver.quit();
	}

}
