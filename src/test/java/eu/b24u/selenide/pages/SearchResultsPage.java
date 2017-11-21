package eu.b24u.selenide.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class SearchResultsPage {
  public ElementsCollection getResults() {
    return $$("#ires .g");
  }
  public SelenideElement getResult(int index) {
    return $("#ires .g", index);
  }
}
