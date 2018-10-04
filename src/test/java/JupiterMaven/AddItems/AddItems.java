package JupiterMaven.AddItems;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class AddItems {
	WebDriver driver;
	String baseURL;

	
	@Given("^I am at home screen$")
	public void i_am_at_home_screen() {
		baseURL = "http://jupiter.cloud.planittesting.com/#/home";

		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(baseURL);
		// Thread.sleep(3000);
	}

	@Given("^I click on  shop button$")
	public void i_click_on_shop_button() {
		WebElement shop = driver.findElement(By.xpath("//li[@id=\"nav-shop\"]//a"));
		shop.click();
	}

	@Given("^I click on  buy button of the items$")
	public void i_click_on_buy_button_of_the_items() {
		WebElement buyItem = driver.findElement(By.xpath("//li[@id=\"product-1\"]//a"));
		buyItem.click();

		WebElement buyItem3 = driver.findElement(By.xpath("//li[@id=\"product-3\"]//a"));
		buyItem3.click();
		// Thread.sleep(2000);

	}

	@Given("^I click on cart button$")
	public void i_click_on_cart_button() throws Throwable {
		WebElement cart = driver.findElement(By.xpath("//li[@id=\"nav-cart\"]//a"));
		cart.click();
	}

	@Given("^I click on checkout button$")
	public void i_click_on_checkout_button() throws Throwable {
		WebElement checkOut = driver.findElement(By.xpath("//div[@class='ng-scope']//a[@class='btn-checkout btn btn-success  ng-scope']"));
		checkOut.click();
		// Thread.sleep(2000);
	}

	@Given("^I enter payment details$")
	public void i_enter_payment_details() throws Throwable {
		WebElement forename = driver.findElement(By.id("forename"));
		forename.sendKeys("Muhammad");

		WebElement surname = driver.findElement(By.id("surname"));
		surname.sendKeys("Akhtar");

		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("suliman_akhtar@hotmail.com");

		WebElement telephone = driver.findElement(By.id("telephone"));
		telephone.sendKeys("07446108782");

		WebElement address = driver.findElement(By.id("address"));
		address.sendKeys("Slough Berkshire UK");

		WebElement cardType = driver.findElement(By.id("cardType"));
		Select card = new Select(cardType);
		card.selectByValue("Visa");

		WebElement cardNumber = driver.findElement(By.id("card"));
		cardNumber.sendKeys("5539761225187006");
		Thread.sleep(1000);

	}

	@Given("^I click on submit button$")
	public void i_click_on_submit_button() {
		WebElement checkoutSubmit = driver.findElement(By.id("checkout-submit-btn"));
		checkoutSubmit.click();
	}

	@Then("^I should receive order confirmation number$")
	public void i_should_receive_order_confirmation_number() {
		WebElement orderNo = driver.findElement(By.xpath("//div[@class='alert alert-success']//strong[2]"));
		System.out.println("Order number is -> " + orderNo.getText());
		driver.quit();
	}



}
