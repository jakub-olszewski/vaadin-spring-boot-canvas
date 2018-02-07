package eu.b24u.tests.utils;

import static org.junit.Assert.assertEquals;

import eu.b24u.vaadin.canvas.utils.PamiecGry;

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

	public static void czySaRowne(PamiecGry wartoscOczekiwana, PamiecGry wartosc, String wiadomosc) {
		assertEquals(wiadomosc, wartoscOczekiwana, wartosc);
	}

	/**
	 * metoda sprawda czy wartosc oczekiwana jest rowna wartosci
	 * 
	 * @param wartoscOczekiwana
	 *            to wartosc ktorej oczekujemy
	 * @param wartosc
	 *            porownywana z wartosciaOczekiwana
	 * @param wiadomosc
	 *            to tekst wyswietlony w trakcie niepowodzenia, czyli wtedy kiedy
	 *            wartosc i wartoscOczekiwana nie sa takie same
	 */
	public static void czySaTakieSame(String wartoscOczekiwana, String wartosc, String wiadomosc) {
		assertEquals(wiadomosc, wartoscOczekiwana, wartosc);
	}

}
