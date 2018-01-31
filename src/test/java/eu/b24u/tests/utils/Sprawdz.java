package eu.b24u.tests.utils;

import static org.junit.Assert.assertEquals;

public class Sprawdz {

	public static void czySaRowne(String wartoscOczekiwana, String wartosc, String wiadomosc) {
		assertEquals(wartoscOczekiwana, wartosc, wiadomosc);
	}
}
