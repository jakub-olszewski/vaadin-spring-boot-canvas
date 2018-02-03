package eu.b24u.selenide;

import org.junit.Test;

import eu.b24u.tests.utils.Program;
import eu.b24u.tests.utils.Sprawdz;
import eu.b24u.vaadin.canvas.utils.Gracz;
import eu.b24u.vaadin.canvas.utils.ObslugaPlikow;
import eu.b24u.vaadin.canvas.utils.Plik;

/**
 * klasa do testowania obsługi plików
 * 
 * @author Adam
 *
 */
public class ObslugaPlikowTest {

	String PRZYKLADOWA_ZAWARTOSC_PLIKU = "[{\"imieGracza\":\"Adam\",\"punkty\":0,\"czas\":0.0}]\r\n" + "";

	/**
	 * @Test jest to adnotacja oznaczajAca testowanie metody poniżej
	 */
	@Test
	public void zapiszDoPliku() {
		// TypObiektu nazwaObiektu = new TypObiektu();
		ObslugaPlikow obslugaPlikow = new ObslugaPlikow();
		// null to pusta wartosc
		// string to napis
		String sciezkaDoPlikuDataJson = obslugaPlikow.pobierzSciezkeDoPlikuZProjektu("data.json");
		Program.wypisz(sciezkaDoPlikuDataJson);
		Plik plikDoZapisu = obslugaPlikow.pobierzPlik(sciezkaDoPlikuDataJson);
		// aby wywolac metode nalezy uzyc kropki po nazwieObiektu
		obslugaPlikow.zapiszDoPliku(PRZYKLADOWA_ZAWARTOSC_PLIKU, plikDoZapisu);

		Plik plikDoOdczytu = plikDoZapisu;
		String tekstZPliku = obslugaPlikow.odczytajZPliku(plikDoOdczytu);
		Sprawdz.czySaTakieSame(tekstZPliku, PRZYKLADOWA_ZAWARTOSC_PLIKU, "zapis do pliku nie dziala");
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

	@Test
	public void zapisDoPlikuNaPulpicie() {
		ObslugaPlikow samolot = new ObslugaPlikow();
		samolot.zapiszDoPliku("pociAg lata autem", "C:\\Users\\Adam\\Desktop\\Angry Birds Breakfast 1.lnk");
	}

}
