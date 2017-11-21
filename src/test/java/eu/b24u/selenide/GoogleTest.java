package eu.b24u.selenide;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

import org.junit.Test;

import eu.b24u.selenide.pages.GooglePage;
import eu.b24u.selenide.pages.SearchResultsPage;

public class GoogleTest {
	@Test
	public void userCanSearch() {

		ClassLoader classLoader = getClass().getClassLoader();
		String path = classLoader.getResource("chromedriver.exe").getPath();

		System.setProperty("webdriver.chrome.driver", path);
		System.setProperty("selenide.browser", "Chrome");

		GooglePage page = open("http://google.com/ncr", GooglePage.class);
		SearchResultsPage results = page.searchFor("selenide");
		results.getResults().shouldHave(size(9));
		results.getResult(0).shouldHave(text("Selenide: concise UI tests in Java"));
	}
}
