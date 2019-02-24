package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import base.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	WebDriver driver;

	@FindBy(id = "search_query_top")
	WebElement searchBox;

	@FindBy(xpath = "//button[@name='submit_search']")
	WebElement searchbutton;

	@FindBy(xpath = "//*[contains(text(),'Faded Short Sleeve T-shirts')]")
	WebElement productDetail;

	@FindBy(id = "image-block")
	WebElement fullsize;

	@FindBy(xpath = "//button/span[contains(text(),'Add to cart')]")
	List<WebElement> addtocart;

	@FindBy(xpath = "//*[@title='Proceed to checkout']/span")
	WebElement proceedToCheckout;

	@FindBy(xpath = "//p/a[@title='Proceed to checkout']/span")
	WebElement proceedToCheckout_2;

	@FindBy(id = "email_create")
	WebElement emailcreat;

	@FindBy(id = "SubmitCreate")
	WebElement createAccountButton;

	@FindBy(id = "id_gender1")
	WebElement gender;

	@FindBy(id = "customer_firstname")
	WebElement customer_firstname;

	@FindBy(id = "customer_lastname")
	WebElement customer_lastname;

	@FindBy(id = "email_create")
	WebElement email_create;

	@FindBy(id = "SubmitCreate")
	WebElement SubmitCreate;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "passwd")
	WebElement passwd;

	@FindBy(id = "days")
	WebElement days;

	@FindBy(id = "months")
	WebElement months;

	@FindBy(id = "years")
	WebElement years;

	@FindBy(id = "firstname")
	WebElement firstname;

	@FindBy(id = "lastname")
	WebElement lastname;

	@FindBy(id = "company")
	WebElement company;

	@FindBy(id = "address1")
	WebElement address1;

	@FindBy(id = "city")
	WebElement city;

	@FindBy(id = "id_state")
	WebElement id_state;

	@FindBy(id = "postcode")
	WebElement postcode;

	@FindBy(id = "id_country")
	WebElement id_country;

	@FindBy(id = "phone_mobile")
	WebElement phone_mobile;

	@FindBy(id = "alias")
	WebElement alias;

	@FindBy(id = "submitAccount")
	WebElement registerButton;

	@FindBy(xpath = "//button[@name='processAddress']/span")
	WebElement processAddress;

	@FindBy(xpath = "//button[@name='processCarrier']/span")
	WebElement processCarrier;

	@FindBy(id = "cgv")
	WebElement tc;

	@FindBy(xpath = "//p/a[contains(text(),'Pay by bank wire ')]/span")
	WebElement payment;

	@FindBy(xpath = "//span[contains(text(),'I confirm my order')]")
	WebElement confirmOrder;

	@FindBy(xpath = "//*[contains(text(),'Your order on My Store is complete.')]")
	List<WebElement> orderCompleteMessage;

	@FindBy(xpath = "//a[@class='logout']")
	WebElement logout;

	@FindBy(xpath = "//a[@class='login']")
	WebElement login;

	@FindBy(id = "SubmitLogin")
	WebElement SubmitLogin;

	public void enter_Search_Value(String Search_text) {
		searchBox.sendKeys(Search_text);
	}

	public void click_on_searchs_buton() {
		searchbutton.click();
	}

	public boolean addtocart() throws InterruptedException {
		productDetail.click();
		if (addtocart.size() > 0) {
			addtocart.get(0).click();
			return true;
		} else {
			return false;
		}

	}

	public void proceedToCheckOutButtonOnModalPopup() {

		proceedToCheckout.click();
	}

	public void clickOnprocessCarrier() {

		if (processCarrier.isDisplayed() && processCarrier.isEnabled()) {
			processCarrier.click();
		}
	}

	public void clickOnprocessAddress() {

		if (processAddress.isDisplayed() && processAddress.isEnabled()) {
			processAddress.click();
		}
	}

	public void enterEmailForNewUser(String emailvalue) {
		email_create.sendKeys(emailvalue);

		SubmitCreate.click();
	}

	public void clickOnCreateAccountButton() {
		createAccountButton.click();
	}

	public void enterPersonalDetails(String firstName, String lastName, String password, String date, String month,
			String year) {

		gender.click();
		customer_firstname.sendKeys(firstName);
		customer_lastname.sendKeys(lastName);
		passwd.sendKeys(password);
		this.selectDate(date);
		this.selectMonth(month);
		this.selectYears(year);
	}

	public void enterAddress(String addressvalue, String cityName, String state, String pincode, String country,
			String phonenumber, String aliasname) {

		address1.sendKeys(addressvalue);
		city.sendKeys(cityName);
		this.selectState(state);
		postcode.sendKeys(pincode);
		this.selectCountry(country);
		phone_mobile.sendKeys(phonenumber);
		alias.clear();
		alias.sendKeys(aliasname);

	}

	public void selectDate(String date) {
		Select dropdown = new Select(days);
		dropdown.selectByValue(date);
	}

	public void selectMonth(String month) {
		Select dropdown = new Select(months);
		dropdown.selectByValue(month);
	}

	public void selectYears(String year) {
		Select dropdown = new Select(years);
		dropdown.selectByValue(year);
	}

	public void selectState(String state) {
		Select dropdown = new Select(id_state);
		dropdown.selectByVisibleText(state);
	}

	public void selectCountry(String country) {
		Select dropdown = new Select(id_country);
		dropdown.selectByVisibleText(country);
	}

	public void clickOnProceedToCheckoutOnDashboard() {

		proceedToCheckout_2.click();
	}

	public void clickOnRegisterButton() {

		registerButton.click();
	}

	public void clickOnTermsConditions() {

		tc.click();

	}

	public void selectPaymentMethod() {

		payment.click();

	}

	public void confirmOrder() {
		confirmOrder.click();
	}

	public boolean verifyOderComplete() {
		if (orderCompleteMessage.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public void SignOut() {
		logout.click();
	}

	public void SignIn(String user, String password) {

		login.click();
		email.sendKeys(user);
		passwd.sendKeys(password);
		SubmitLogin.click();
	}

}
