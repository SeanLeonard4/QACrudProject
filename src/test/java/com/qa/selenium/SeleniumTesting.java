package com.qa.selenium;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SeleniumTesting {

	private RemoteWebDriver driver;

	@BeforeEach
	void setup() {
		this.driver = new ChromeDriver();
	}

	@Test
	void testRead() {
		this.driver.get("http://127.0.0.1:5500/QAProject-FrontEnd/index.html");
		WebElement logo = this.driver.findElement(By.xpath("/html/body/header/h1/a/i"));

		assertThat(logo.getText()).isEqualTo("UkHS");
	}

	@Test
	void testSubmit() {

		this.driver.get("http://127.0.0.1:5500/QAProject-FrontEnd/index.html");

		WebElement name = this.driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/input"));

		name.sendKeys("John");

		WebElement age = this.driver.findElement(By.xpath("/html/body/div[1]/form/div[2]/input"));

		age.sendKeys("27");

		WebElement email = this.driver.findElement(By.xpath("/html/body/div[1]/form/div[3]/input"));

		email.sendKeys("Johndoe@hotmail.co.uk");

		WebElement postcode = this.driver.findElement(By.xpath("/html/body/div[1]/form/div[4]/input"));

		postcode.sendKeys("HU11 3TU");

		Select dropdown = new Select(this.driver.findElement(By.xpath("/html/body/div[1]/form/div[5]/select")));

		dropdown.selectByVisibleText("Oxford/Astrazeneca");

		WebElement refresh = this.driver.findElement(By.xpath("/html/body/div[1]/form/button[2]"));
		refresh.click();
	}

	@Test
	void testUpdate() {
		this.driver.get("http://127.0.0.1:5500/QAProject-FrontEnd/index.html");
		WebDriverWait explicitWait = new WebDriverWait(driver, 10);

		WebElement update = explicitWait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/table/tbody/tr[1]/button[1]")));

		update.click();
		WebElement name = explicitWait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[2]/form/div[1]/input")));
		name.clear();
		name.sendKeys("Sean Eric John Leonard");

		WebElement submitUpdates = this.driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[6]/button"));
		submitUpdates.click();
	}

	@AfterEach
	void tearDown() {
		this.driver.close();
	}
}
