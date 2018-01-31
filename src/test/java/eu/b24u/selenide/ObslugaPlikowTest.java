package eu.b24u.selenide;

import java.io.File;

import org.junit.Test;

import eu.b24u.tests.utils.Program;
import eu.b24u.tests.utils.Sprawdz;
import eu.b24u.vaadin.canvas.utils.Gracz;
import eu.b24u.vaadin.canvas.utils.ObslugaPlikow;

public class ObslugaPlikowTest {

	@Test
	public void zapiszDoPliku() {
		// TypObiektu nazwaObiektu = new TypObiektu();
		ObslugaPlikow obslugaPlikow = new ObslugaPlikow();
		// null to pusta wartosc
		// string to napis
		String tekstDoPliku = "mmmmmm2";
		File plikDoZapisu = obslugaPlikow.pobierzPlik("C:\\Users\\student\\Desktop\\dane.json");
		// aby wywolac metode nalezy uzyc kropki po nazwieObiektu
		obslugaPlikow.zapiszDoPliku(tekstDoPliku, plikDoZapisu);

		File plikDoOdczytu = plikDoZapisu;
		String tekstZPliku = obslugaPlikow.odczytajZPliku(plikDoOdczytu);
		Sprawdz.czySaRowne(tekstZPliku, tekstDoPliku, "zapis do pliku nie dziala");
	}

	@Test
	public void utworzJSON() {
		String oczekiwanyGraczWFormacieJSON = "{\"imieGracza\":\"JSON\",\"punkty\":0,\"czas\":0.0}";
		Gracz graczJSON = new Gracz();
		graczJSON.ustawImieGracza("JSON");
		ObslugaPlikow obslugaPlikow = new ObslugaPlikow();
		String graczWFormacieJSON = obslugaPlikow.zapiszDoJSON(graczJSON);
		Program.wypisz(graczWFormacieJSON);
		Sprawdz.czySaRowne(oczekiwanyGraczWFormacieJSON, graczWFormacieJSON, "zapis w postaci JSON nie działa");
	}

}
