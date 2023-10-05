package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage
	{
	public ShoppingCartPage(WebDriver driver)
	{
		super(driver);
	}
	
	//@FindBy(xpath="//button[@aria-expanded='false']")
	@FindBy(xpath="//div[@id='header-cart']//button[@type='button']")
	WebElement btnItems;
	
	@FindBy(xpath="//strong[normalize-space()='View Cart']")
	WebElement lnkViewCart;
	
	@FindBy(xpath="//*[@id='content']/div[1]/div/table//strong[text()='Total']//following::td")
	WebElement lblTotalPrice;  //$246.40
	
	@FindBy(xpath="//a[text()='Checkout']")
	WebElement btnCheckout;
	
	public void clickItemsToNavigateToCart()
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("arguments[0].click();", btnItems);
	}
	
	public void clickViewCart()
	{
		lnkViewCart.click();
	}
	
	public String getTotalPrice()
	{
		return lblTotalPrice.getText();
	}
	
	public void clickOnCheckout()
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("arguments[0].click();", btnCheckout);
//		btnCheckout.click();
	}
}
