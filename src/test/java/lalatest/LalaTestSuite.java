package lalatest;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LalaTestSuite {
	WebDriver driver;
	boolean outOfStock = false;
	@BeforeTest
	public void beforeTest() throws MalformedURLException {	

		//chrome remote Driver
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.setBinary("/usr/bin/google-chrome");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); 
	}

	@AfterTest
	public void afterTest(){

		driver.quit();

	}
	@Test
	public void LalaTest() {
		Logger logger = Logger.getLogger("");
		logger.setLevel(Level.OFF);

		//OPEN BEACHTREE WEBSITE
		driver.get("http://www.lala.com.pk");

		WebDriverWait waitForSpan= new WebDriverWait(driver, 100);
		//*[@id="header-cart"]/div[3]/div[3]/div/a[1]/span
		waitForSpan.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div/div[1]/div[6]/div/div[1]/span")));


		driver.findElement(By.xpath("html/body/div/div[1]/div[6]/div/div[1]/span")).click();
		driver.findElement(By.linkText("Pakistan")).click();

		System.out.println("Page title is: " + driver.getTitle());

		List<String> LinksString = Arrays.asList("LAWN","CAMBRIC","MEGA SALE","FALL WINTER");

		//RANDOMLY SELECT CATEGORY
		Random randomCategories = new Random();
		String randomLink = LinksString.get(randomCategories.nextInt(LinksString.size()));
		driver.findElement(By.linkText(randomLink)).click();
		System.out.println("Randomly selected Tab is : " + randomLink);

		//WebElement randomCategory=driver.findElement(By.linkText("LAWN"));
		//randomCategory.click();

		if(randomLink==LinksString.get(0))
		{
			System.out.println("Page title is: " + driver.getTitle());
			//SELECT A RANDOM PRODUCT
			List<WebElement> allProducts = driver.findElements(By.cssSelector("a.product-image"));
			System.out.println("print the allProducts total size "+allProducts.size());
			System.out.println("print the allProducts "+allProducts);
			// System.out.println("print the allProducts.size() "+allProducts.size());
			Random random2 = new Random();
			WebElement randomProduct = allProducts.get(random2.nextInt(allProducts.size()));

			WebDriverWait waitForRandomProduct= new WebDriverWait(driver, 100);
			waitForRandomProduct.until(ExpectedConditions.visibilityOf(randomProduct));
			System.out.println("Random product getText is "+randomProduct.getText());
			System.out.println("Random product getAttribute is "+randomProduct.getAttribute("title"));
			//randomProduct.click();
			Actions actions = new Actions(driver);

			actions.moveToElement(randomProduct).click().perform();

			System.out.println("Random product is clicked");

			//ADDCART
			//*[@id="product_addtocart_form"]/div[4]/div[5]/div/div/div[3]/button
			driver.findElement(By.xpath("//*[@id='product_addtocart_form']/div[4]/div[5]/div/div/div[3]/button")).click();

			//CHECKOUT
			//*[@id="header-cart"]/div[3]/div[3]/div/a[2]
			WebDriverWait waitForCheckOut= new WebDriverWait(driver, 100);
			waitForCheckOut.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='header-cart']/div[3]/div[3]/div/a[2]"))).click();
		}
		else if(randomLink==LinksString.get(1))
		{
			System.out.println("Page title is: " + driver.getTitle());
			//SELECT A RANDOM PRODUCT
			List<WebElement> allProducts = driver.findElements(By.cssSelector("a.product-image"));
			System.out.println("print the allProducts total size "+allProducts.size());
			System.out.println("print the allProducts "+allProducts);
			// System.out.println("print the allProducts.size() "+allProducts.size());
			Random random2 = new Random();
			WebElement randomProduct = allProducts.get(random2.nextInt(allProducts.size()));

			WebDriverWait waitForRandomProduct= new WebDriverWait(driver, 100);
			waitForRandomProduct.until(ExpectedConditions.visibilityOf(randomProduct));

			System.out.println("Random product is getText "+randomProduct.getText());
			System.out.println("Random product getAttribute is "+randomProduct.getAttribute("title"));
			//randomProduct.click();
			Actions actions = new Actions(driver);

			actions.moveToElement(randomProduct).click().perform();

			System.out.println("Random product is clicked");

			//ADDCART
			//*[@id="product_addtocart_form"]/div[4]/div[5]/div/div/div[3]/button/span/span
			driver.findElement(By.xpath("//*[@id='product_addtocart_form']/div[4]/div[5]/div/div/div[3]/button/span/span")).click();

			//CHECKOUT
			//*[@id="header-cart"]/div[3]/div[3]/div/a[2]/span
			WebDriverWait waitForCheckOut= new WebDriverWait(driver, 100);
			waitForCheckOut.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='header-cart']/div[3]/div[3]/div/a[2]/span"))).click();
		}
		else if(randomLink==LinksString.get(2))
		{
			System.out.println("Page title is: " + driver.getTitle());
			//SELECT A RANDOM PRODUCT
			List<WebElement> allProducts = driver.findElements(By.cssSelector("a.product-image"));
			System.out.println("print the allProducts total size "+allProducts.size());
			System.out.println("print the allProducts "+allProducts);
			// System.out.println("print the allProducts.size() "+allProducts.size());
			Random random2 = new Random();
			WebElement randomProduct = allProducts.get(random2.nextInt(allProducts.size()));

			WebDriverWait waitForRandomProduct= new WebDriverWait(driver, 100);
			waitForRandomProduct.until(ExpectedConditions.visibilityOf(randomProduct));

			System.out.println("Random produc getTextt is "+randomProduct.getText());
			System.out.println("Random product getAttribute is "+randomProduct.getAttribute("title"));
			//randomProduct.click();
			Actions actions = new Actions(driver);

			actions.moveToElement(randomProduct).click().perform();

			System.out.println("Random product is clicked");

			//ADDCART
			//*[@id="product_addtocart_form"]/div[4]/div[5]/div/div/div[3]/button/span/span
			driver.findElement(By.xpath("//*[@id='product_addtocart_form']/div[4]/div[5]/div/div/div[3]/button/span/span")).click();

			//CHECKOUT
			//*[@id="header-cart"]/div[3]/div[3]/div/a[2]/span
			WebDriverWait waitForCheckOut= new WebDriverWait(driver, 100);
			waitForCheckOut.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='header-cart']/div[3]/div[3]/div/a[2]/span"))).click();
		}
		else if(randomLink==LinksString.get(3))
		{
			System.out.println("Page title is: " + driver.getTitle());
			//SELECT A RANDOM PRODUCT
			List<WebElement> allProducts = driver.findElements(By.cssSelector("a.product-image"));
			System.out.println("print the allProducts total size "+allProducts.size());
			System.out.println("print the allProducts "+allProducts);
			// System.out.println("print the allProducts.size() "+allProducts.size());
			Random random2 = new Random();
			WebElement randomProduct = allProducts.get(random2.nextInt(allProducts.size()));

			WebDriverWait waitForRandomProduct= new WebDriverWait(driver, 100);
			waitForRandomProduct.until(ExpectedConditions.visibilityOf(randomProduct));

			System.out.println("Random product getText is "+randomProduct.getText());
			System.out.println("Random product getAttribute is "+randomProduct.getAttribute("title"));
			//randomProduct.click();
			Actions actions = new Actions(driver);

			actions.moveToElement(randomProduct).click().perform();

			System.out.println("Random product is clicked");

			//ADDCART
			//*[@id="product_addtocart_form"]/div[4]/div[5]/div/div/div[3]/button/span/span
			driver.findElement(By.xpath("//*[@id='product_addtocart_form']/div[4]/div[5]/div/div/div[3]/button/span/span")).click();

			//CHECKOUT
			//*[@id="header-cart"]/div[3]/div[3]/div/a[2]/span
			WebDriverWait waitForCheckOut= new WebDriverWait(driver, 100);
			waitForCheckOut.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='header-cart']/div[3]/div[3]/div/a[2]/span"))).click();
		}
		//FILL IN THE BILLING INFORMATION
		driver.findElement(By.xpath("//*[@id='billing:firstname']")).sendKeys("test");
		System.out.println("First Name is Enterd");
		driver.findElement(By.xpath("//*[@id='billing:lastname']")).sendKeys("test");
		System.out.println("Last Name is Enterd");
		driver.findElement(By.xpath("//*[@id='bill_form']/div[3]/div[1]/input")).sendKeys("test@gmail.com");
		System.out.println("Email is Enterd");
		//*[@id="billing:confirm_email"]
		driver.findElement(By.xpath("//*[@id='billing:confirm_email']")).sendKeys("test@gmail.com");
		System.out.println("Email is confirmed");
		driver.findElement(By.xpath("//*[@id='billing:street1']")).sendKeys("test");
		System.out.println("Street 1 is Enterd");
		driver.findElement(By.xpath("//*[@id='billing:street2']")).sendKeys("test");
		System.out.println("Street 2 is Enterd");
		//		driver.findElement(By.xpath("//*[@id='billing:region']")).sendKeys("test");
		//		System.out.println("Region is Enterd");
		//		driver.findElement(By.xpath("//*[@id='billing:postcode']")).sendKeys("test");
		//		System.out.println("Billing postcode is Enterd");

		//		Select oSelect2 = new Select(driver.findElement(By.xpath("//*[@id='billing:country_id']")));
		//		oSelect2.selectByVisibleText("PAKISTAN");

		Select oSelect3 = new Select(driver.findElement(By.xpath("//*[@id='billing:city']")));
		oSelect3.selectByIndex(3);
		System.out.println("City is Enterd");

		driver.findElement(By.xpath("//*[@id='billing:telephone']")).sendKeys("03001234567");
		System.out.println("Telephone is Enterd");

		driver.findElement(By.xpath("//*[@id='tel2']")).sendKeys("03001234567");
		System.out.println("Telephone is Confirmed");


		//SELECT CASH ON DELEIVERY
		driver.findElement(By.id("p_method_cashondelivery")).click();
		System.out.println("Cash on Delivery is Clicked");

		//PLACE ORDER
		WebDriverWait wait3 = new WebDriverWait(driver, 200);
		//*[@id="review-buttons-container"]/button
		wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='review-buttons-container']/button")));
		driver.findElement(By.xpath("//*[@id='review-buttons-container']/button")).click();
		System.out.println("Place Order Now Button is Clicked");
	}
}
