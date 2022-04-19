package script;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {

	private static ChromeDriver driver;
	WebElement element;

	@Given("Open Chrome Browser and enter url of appln")
	public void open_Chrome_Browser_and_enter_url_of_appln() {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setAcceptInsecureCerts(true);
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\manishabajirao.balwa\\Downloads\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver(caps);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		System.out.println("Given Open Browser Done");

	}

	@When("enter mobilenumber with invalid value")
	public void enter_mobile_number_with_invalid_value() throws InterruptedException {
		System.out.println("enter mobile number with valid and invalid value");
		WebElement logOptionElement = driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[1]/ul/li[3]"));
		logOptionElement.click();

		Thread.sleep(100);
		// WebElement advElement = driver.findElement(By.cssSelector(".langCardClose"));
		// advElement.click();

		logOptionElement.click();

		WebElement mobileOrEmailNumber = driver.findElement(By.id("username"));
		mobileOrEmailNumber.sendKeys("aakhaallk");

		WebElement continueButton = driver.findElement(By.cssSelector("button.capText.font16"));
		if (!continueButton.isEnabled()) {
			System.out.println("Invalid login details");
		}
		Thread.sleep(100);
		// login using gmail
		Thread.sleep(50);

		System.out.println("when done");
	}

	@When("enter mobilenumber with valid value")
	public void enter_mobile_number_with_valid_value() throws InterruptedException {
		System.out.println("enter mobile number with valid and invalid value");
		WebElement logOptionElement = driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[1]/ul/li[3]"));
		logOptionElement.click();

		Thread.sleep(100);
		// WebElement advElement = driver.findElement(By.cssSelector(".langCardClose"));
		// advElement.click();

		logOptionElement.click();

		WebElement mobileOrEmailNumber = driver.findElement(By.id("username"));
		mobileOrEmailNumber = driver.findElement(By.id("username"));
		mobileOrEmailNumber.sendKeys("8888082782");

		WebElement continueButton = driver.findElement(By.cssSelector("button.capText.font16"));
		continueButton = driver.findElement(By.cssSelector("button.capText.font16"));
		if (continueButton.isEnabled()) {
			System.out.println("Valid login details");
			continueButton.click();
		}

		// login using gmail
		Thread.sleep(50);
		System.out.println("when done");
	}

	@Then("Register and login")
	public void register_and_login() {
		WebElement we = driver.findElement(By.cssSelector("button[data-cy='continueBtn']"));
		System.out.println(we.getText());
		we.getLocation();
		// we.click();
		System.out.println("Register and login");
		driver.close();
	}

	@Given("Open Chrome Browser and enter search url of appln")
	public void open_Chrome_Browser_and_enter_search_url_of_appln() throws InterruptedException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setAcceptInsecureCerts(true);
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\manishabajirao.balwa\\Downloads\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver(caps);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://www.makemytrip.com/flights/");
		Thread.sleep(50);
		System.out.println("Given Open Browser Done");

	}

	@When("enter data for flight search")
	public void enter_data_for_flight_search() {
		try {
			System.out.println("enter data for flight search");
			driver.navigate().to("https://www.makemytrip.com/flights/");
			List<WebElement> searchBtnOpton = driver.findElements(By.cssSelector("ul.fswTabs.latoBlack.greyText"));

			System.out.println(searchBtnOpton.size());
			if (searchBtnOpton.size() == 3) {
				searchBtnOpton.get(0).click();
				searchBtnOpton.get(1).click();
				searchBtnOpton.get(2).click();
			}

			WebElement menuflight = driver.findElement(By.cssSelector("li[data-cy='menu_Flights']"));
			menuflight.click();

			WebElement searchOpt1 = driver.findElement(By.cssSelector("li[data-cy='oneWayTrip']"));
			searchOpt1.click();

			WebElement searchOpt2 = driver.findElement(By.cssSelector("li[data-cy='roundTrip']"));
			searchOpt2.click();

			WebElement searchOpt3 = driver.findElement(By.cssSelector("li[data-cy='mulitiCityTrip']"));
			searchOpt3.click();

			searchOpt1.click();
			WebElement fromCity = driver.findElement(By.xpath("//input[@id = 'fromCity']"));
			System.out.println(fromCity.getText());
			fromCity.click();

			WebElement fromVal = driver.findElement(By.xpath("//input[@placeholder='From']"));
			fromVal.sendKeys("Pune, India");
			fromVal.click();

			WebElement toCity = driver.findElement(By.xpath("//input[@id = 'toCity']"));
			System.out.println(toCity.getText());
			toCity.click();

			Thread.sleep(10);
			WebElement toVal = driver.findElement(By.xpath("//input[@placeholder='To']"));
			toVal.sendKeys("Goa, India");
			toVal.click();

			/*
			 * WebElement depart = driver.
			 * findElement(By.xpath("//input[@id='departure']"));
			 * depart.sendKeys("Tuesday, 19 May 2022");
			 */

			Thread.sleep(150);
		} catch (Exception e) {

		} finally {
			System.out.println("when done");
			driver.close();
		}

	}

	@Then("search")
	public void search() {
		try {
			WebElement searchBtnClick = driver.findElement(By.cssSelector("p[data-cy='submit']"));

			searchBtnClick.click();

		} catch (Exception e) {

		} finally {
			System.out.println("Search");
			driver.quit();
		}
	}
}
