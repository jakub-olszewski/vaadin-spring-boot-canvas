package eu.b24u.selenide;

import static com.codeborne.selenide.Selenide.open;

public class JavaStartTest {
	// @Test
	public void userCanSearch() {

		ClassLoader classLoader = getClass().getClassLoader();
		String path = classLoader.getResource("chromedriver.exe").getPath();

		System.setProperty("webdriver.chrome.driver", path);
		System.setProperty("selenide.browser", "Chrome");

		open("https://javastart.pl/static/podstawy-jezyka/pierwszy-program/");

		// SearchResultsPage results = page.searchFor("selenide");
		// results.getResults().shouldHave(size(9));
		// results.getResult(0).shouldHave(text("Selenide: concise UI tests in Java"));
	}
}
