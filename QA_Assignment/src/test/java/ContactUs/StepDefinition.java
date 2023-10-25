package ContactUs;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	WebDriver driver;

	ContactUsPage contactUsPage;

	@Given("user is on the Contact us page")
	public void user_is_on_the_contact_us_page() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		contactUsPage = new ContactUsPage(driver);

		contactUsPage.navigate();
		contactUsPage.validatePageLoad();
	}

	@When("user enters first name - {string}")
	public void user_enters_first_name(String string) {
		contactUsPage.enterFirstName(string);
	}

	@When("user enters last name - {string}")
	public void user_enters_last_name(String string) {
		contactUsPage.enterLastName(string);
	}

	@When("user enters email - {string}")
	public void user_enters_email(String string) {
		contactUsPage.enterEmail(string);
	}

	@When("user enters comments - {string}")
	public void user_enters_comments(String string) {
		contactUsPage.enterComments(string);
	}

	@When("user click on submit button")
	public void user_click_on_submit_button() throws InterruptedException {
		contactUsPage.clickOnSubmitButton();
		Thread.sleep(3000);
	}

	@Then("user should be on Thank you page")
	public void user_should_be_on_thank_you_page() {
		contactUsPage.validateThankYou();
		
		driver.close();
		driver.quit();
	}

	@Then("user should see {string} messages")
	public void user_should_see_error_messages(String expectedErrorMessage) {
	    List<String> expectedErrorMessages = Arrays.asList(expectedErrorMessage.split(", "));
	    contactUsPage.validateError(expectedErrorMessages);
	    driver.close();
	    driver.quit();
	}

}
