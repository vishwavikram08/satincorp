

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class TendableTechPageClass {
	
	WebDriver driver;
	Boolean requestADemoBtnDisplayed;
	Boolean requestADemoBtnEnabled;
	
	
	
	By home = By.xpath("//a[@href='https://www.tendable.com/']");
	By ourStory = By.xpath("//a[@href='https://www.tendable.com/our-story']");
	By ourSolution = By.xpath("//*[@id=\"main-navigation-new\"]/ul/li[2]/a");
	By whyTendable = By.xpath("//a[@href='https://www.tendable.com/why-tendable']");
	By bookADemo = By.xpath("//a[@href='https://www.tendable.com/book-a-demo']");
	By contactUs = By.xpath("/html/body/header/div/div[1]/a[1]");
	By marketingButton = By.xpath("//button[@class='body-button bg-plain-600 toggle-control']");
	By fullName = By.xpath("//input[@name='fullName']");
	By organisationName = By.xpath("//input[@name='organisationName']");
	By phoneNumbber = By.xpath("//input[@name='cellPhone']");
	By emailAddress = By.xpath("//input[@name='email']");
	By consentRadioBtn = By.xpath("//input[@name='consentAgreed']");
	By submitBtn = By.xpath("//button[@name='form_page_submit']");
	By errorText = By.xpath("//*[ text() = 'Sorry, there was an error submitting the form. Please try again.' ]");
	
	
	
	@SuppressWarnings("deprecation")
	public void setUp() {
        
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(" https://www.tendable.com");
	}
	
	
	public void navigateThroughTopMenus() {
		
		driver.findElement(home).click();
		requestADemoBtnEnabled = driver.findElement(bookADemo).isEnabled();
		System.out.println("Request a demo button is enabled ? " +requestADemoBtnEnabled);
		
		driver.findElement(ourStory).click();
		requestADemoBtnEnabled = driver.findElement(bookADemo).isEnabled();
		System.out.println("Request a demo button is enabled ? " +requestADemoBtnEnabled);
		
		Actions act = new Actions(driver);
		WebElement ourSolution = driver.findElement(By.xpath("//*[@id=\"main-navigation-new\"]/ul/li[2]/a"));
		act.moveToElement(ourSolution).perform();
		requestADemoBtnEnabled = driver.findElement(bookADemo).isEnabled();
		System.out.println("Request a demo button is enabled ? " +requestADemoBtnEnabled);
		
		driver.findElement(whyTendable).click();
		requestADemoBtnEnabled = driver.findElement(bookADemo).isEnabled();
		System.out.println("Request a demo button is enabled ? " +requestADemoBtnEnabled);
		
	}
	
	public void clickContactUsBtn() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(contactUs));
		
		driver.findElement(contactUs).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(marketingButton));
		
		
	}
	
	public void clickMarketingOption() {
		driver.findElement(marketingButton).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(fullName));
		
	}
	
	public void enterCustomerDetails(String completeName, String orgName, String jobRole, String phoneNm, String email) {
		
		
		driver.findElement(fullName).sendKeys(completeName);
		driver.findElement(organisationName).sendKeys(orgName);
		driver.findElement(phoneNumbber).sendKeys(phoneNm);
		driver.findElement(emailAddress).sendKeys(email);
		
		Select st = new Select(driver.findElement(By.xpath("//select[@name='jobRole']")));
		st.selectByVisibleText(jobRole);

		
		Actions act = new Actions(driver);
		
		WebElement consentRadioButton = driver.findElement(consentRadioBtn);
		
		act.moveToElement(consentRadioButton).build().perform();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(consentRadioBtn));
		
		consentRadioButton.click();
		
		WebElement submitButton = driver.findElement(submitBtn);
		
		act.moveToElement(submitButton).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
		driver.findElement(submitBtn).click();
		
		Boolean errorMessageDisplayed = driver.findElement(errorText).isDisplayed();
		if(errorMessageDisplayed) {
			System.out.println("Test is passed");
		}
		else {
			System.out.println("Test is failed");
		}
		
	}
	
	

}
