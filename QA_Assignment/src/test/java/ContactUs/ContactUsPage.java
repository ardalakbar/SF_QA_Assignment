package ContactUs;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
	// Variables
	private WebDriver driver;
	private final String URL = "https://webdriveruniversity.com/Contact-Us/contactus.html";

	// Elements
	@FindBy(name = "first_name")
	private WebElement firstNameBox;

	@FindBy(name = "last_name")
	private WebElement lastNameBox;

	@FindBy(name = "email")
	private WebElement emailBox;

	@FindBy(name = "message")
	private WebElement commentBox;

	@FindBy(xpath = "//input[@value='RESET']")
	private WebElement resetButton;

	@FindBy(xpath = "//input[@value='SUBMIT']")
	private WebElement submitButton;

	@FindBy(xpath = "//h1[normalize-space()='Thank You for your Message!']")
	private WebElement thankYouMessage;

	@FindBy(xpath = "//body")
	private List<WebElement> errorMessage;

	// Constructor
	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Actions

	public void validatePageLoad() {
		if (!URL.equals(driver.getCurrentUrl())) {
			try {
				throw new Exception("page URL did not match");
			} catch (Exception e) {
				System.out.println("Caught an exception " + e.getMessage());
			}

		}
	}

	public void navigate() {
		driver.get(URL);
	}

	public void enterFirstName(String firstName) {
		firstNameBox.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		lastNameBox.sendKeys(lastName);
	}

	public void enterEmail(String email) {
		emailBox.sendKeys(email);
	}

	public void enterComments(String comments) {
		commentBox.sendKeys(comments);
	}

	public void clickOnResetButton() {
		resetButton.click();
	}

	public void clickOnSubmitButton() {
		submitButton.click();
	}

	public void validateThankYou() {
		String expectedMessage = "Thank You for your Message!";
		String actualMessage = thankYouMessage.getText();
		
		assertEquals(expectedMessage, actualMessage);

		System.out.println("Test passed");
	}

	public void validateError(List<String> errors) {

		ArrayList<String> actualErrors = new ArrayList<String>();

		for (WebElement webElement : errorMessage) {
			actualErrors.add(webElement.getText());
		}

		for (String error : errors) {
			if (actualErrors.get(0).equals(error)) {
				System.out.println("Test passed");
				break;
			} else {
				System.out.println("Test failed! Expected error message not found");
			}
		}

	}

}
