package eu.b24u.vaadin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleTest {
	WebDriver driver;
	Wait<WebDriver> wait;

	// @Test
	public void userCanSearch() {

		ClassLoader classLoader = getClass().getClassLoader();
		String path = classLoader.getResource("chromedriver.exe").getPath();

		System.setProperty("webdriver.chrome.driver", path);

		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 30);
		driver.get("http://www.google.com/");

		boolean result;
		try {
			result = firstPageContainsQAANet();
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			driver.close();
		}

		/*
		 * File file = new File("resources/chromedriver.exe"); String absolutePath =
		 * file.getAbsolutePath();
		 * 
		 * ClassLoader classLoader = getClass().getClassLoader(); String path =
		 * classLoader.getResource("chromedriver.exe").getPath();
		 * 
		 * System.setProperty("webdriver.chrome.driver", path);
		 * System.setProperty("selenide.browser", "Chrome");
		 * 
		 * GooglePage page = open("https://www.google.com/", GooglePage.class);
		 * SearchResultsPage results = page.searchFor("selenide");
		 * results.getResults().shouldHave(size(9)); //
		 * results.getResult(0).shouldHave(text("Selenide: concise UI tests in Java"));
		 * 
		 */
	}

	private boolean firstPageContainsQAANet() {
		// type search query
		driver.findElement(By.name("q")).sendKeys("qa automation\n");

		// click search
		driver.findElement(By.name("btnG")).click();

		// Wait for search to complete
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver webDriver) {
				System.out.println("Searching ...");
				return webDriver.findElement(By.id("resultStats")) != null;
			}
		});

		// Look for QAAutomation.net in the results
		return driver.findElement(By.tagName("body")).getText().contains("qaautomation.net");
	}
}