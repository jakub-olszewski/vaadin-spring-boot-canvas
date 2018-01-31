package eu.b24u.selenide;

import org.junit.Test;

import eu.b24u.vaadin.canvas.utils.ObslugaPlikow;

public class ObslugaPlikowTest {

	@Test
	public void zapiszDoPliku() {
		// TypObiektu nazwaObiektu = new TypObiektu();
		ObslugaPlikow obslugaPlikow = new ObslugaPlikow();
		String tekst;
		// aby wywolac metode nalezy uzyc kropki po nazwieObiektu
		obslugaPlikow.zapiszDoPliku(tekst, plikDoZapisu);
	}

}
