package eu.b24u.tests.utils;

import static org.junit.Assert.assertEquals;

public class Sprawdz {
	/**
	 * metoda sprawda czy wartosc oczekiwana jest rowna wartosci
	 * 
	 * @param wartoscOczekiwana
	 *            to wartosc ktorej oczekujemy
	 * @param wartosc
	 *            porownywana z wartosciaOczekiwana
	 * @param wiadomosc
	 *            to tekst wyswietlony w trakcie niepowodzenia
	 */
	public static void czySaRowne(String wartoscOczekiwana, String wartosc, String wiadomosc) {
		assertEquals(wiadomosc, wartoscOczekiwana, wartosc);
	}
}
