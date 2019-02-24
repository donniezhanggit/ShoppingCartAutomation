package sanitySuite;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ReadPropertyFile;
import base.SharedSteps;
import junit.framework.Assert;


public class ShoppingCartTest extends SharedSteps{

	
	HomePage homepage=new HomePage(driver);
	boolean isTrue;
	ReadPropertyFile props;
	//generate dynamic user string
	String datetime = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	
	public ShoppingCartTest() throws IOException{
		props = new ReadPropertyFile();
	}
	
	@Test (priority=1)	
	public void AddItemToCartandCheckoutForNewUser() throws InterruptedException {

		driver.get(props.getURL());
		homepage.enter_Search_Value("Faded Short Sleeve T-shirts");
		homepage.click_on_searchs_buton();
		Reporter.log( "Searched for item successfully", true );
		isTrue=homepage.addtocart();
		Assert.assertEquals(true, isTrue);
		Reporter.log( "Item added successfully to cart", true );
		homepage.proceedToCheckOutButtonOnModalPopup();
		homepage.clickOnProceedToCheckoutOnDashboard();
		homepage.enterEmailForNewUser("AutomationUser"+datetime+"@gmail.com");
		Reporter.log( "Entered new user email successfully", true );
		homepage.enterPersonalDetails(props.getfirstName(),props.getlastName(),props.getpassword(),props.getday(),props.getmonth(), props.getyear());
		homepage.enterAddress(props.getaddress(),props.getcity(),props.getstate(),props.getpin(),props.getcountry(),props.getphoneNo(),props.getAlias());
		homepage.clickOnRegisterButton();
		Reporter.log( "New user created successfully", true );
		homepage.clickOnprocessAddress();
		Reporter.log( "Confirmed address.", true );
		homepage.clickOnTermsConditions();
		Reporter.log( "Accepted T&C", true );
		homepage.clickOnprocessCarrier();
		Reporter.log( "Confirmed carrier", true );
		homepage.selectPaymentMethod();
		Reporter.log( "Selected payment method.", true );
		homepage.confirmOrder();
		boolean isTrue=homepage.verifyOderComplete();
		Assert.assertEquals(true, isTrue);
		Reporter.log( "Order is completed successfully", true );
		homepage.SignOut();
		Reporter.log( "User sign out from app.", true );        
	}
	
	
	@Test (priority=2)	
	public void AddItemToCartandCheckoutForExistingUser() throws InterruptedException {

		driver.get(props.getURL());
		homepage.SignIn(props.getexistingUser(),props.getpassword());
		homepage.enter_Search_Value("Faded Short Sleeve T-shirts");
		homepage.click_on_searchs_buton();
		isTrue=homepage.addtocart();
		Assert.assertEquals(true, isTrue);
		Reporter.log( "Item added successfully to cart", true );
		homepage.proceedToCheckOutButtonOnModalPopup();
		homepage.clickOnProceedToCheckoutOnDashboard();
		homepage.clickOnprocessAddress();
		Reporter.log( "Confirmed address.", true );
		homepage.clickOnTermsConditions();
		Reporter.log( "Accepted T&C", true );
		homepage.clickOnprocessCarrier();
		Reporter.log( "Confirmed carrier", true );
		homepage.selectPaymentMethod();
		Reporter.log( "Selected payment method.", true );
		homepage.confirmOrder();
		boolean isTrue=homepage.verifyOderComplete();
		Assert.assertEquals(true, isTrue);
		Reporter.log( "Order is completed successfully", true );
		homepage.SignOut();
		Reporter.log( "User sign out from app.", true );   
		        
	}


}
