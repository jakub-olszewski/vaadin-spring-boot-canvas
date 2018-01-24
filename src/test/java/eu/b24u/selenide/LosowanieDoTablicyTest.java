package eu.b24u.selenide;

import org.junit.Assert;
import org.junit.Test;

import eu.b24u.vaadin.canvas.utils.Tablica;

public class LosowanieDoTablicyTest {

	@Test
	public void losowanie() {
		Tablica tablicaNumerkow = new Tablica();

		int wylosowanaOsoba = tablicaNumerkow.losujLiczbeZPrzedzialu(1, 6);
		tablicaNumerkow.wypisz(wylosowanaOsoba);
		Assert.assertTrue(true);
	}
}
