package eu.b24u.selenide;

import java.io.File;

import org.junit.Test;

import eu.b24u.vaadin.canvas.utils.ObslugaPlikow;

public class ObslugaPlikowTest {

	@Test
	public void zapiszDoPliku() {
		// TypObiektu nazwaObiektu = new TypObiektu();
		ObslugaPlikow obslugaPlikow = new ObslugaPlikow();
		// null to pusta wartosc
		// string to napis
		String tekst = "jakis napis";
		File plikDoZapisu = obslugaPlikow.pobierzPlik("C:\\Users\\student\\Desktop\\dane.json");
		// aby wywolac metode nalezy uzyc kropki po nazwieObiektu
		obslugaPlikow.zapiszDoPliku(tekst, plikDoZapisu);
	}

}
