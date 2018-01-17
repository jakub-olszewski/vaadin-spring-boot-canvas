package eu.b24u.vaadin.canvas.utils;

import com.vaadin.ui.Button.ClickEvent;

import eu.b24u.vaadin.components.PoleTekstowe;
import eu.b24u.vaadin.components.Powiadomienie;
import eu.b24u.vaadin.components.Przycisk;
import eu.b24u.vaadin.listener.SluchaczKlikniecia;

/**
 * ta klasa buduje okno w którym gracz wpisuje imie
 * 
 * @author student
 *
 */
public class OknoWpiszImie extends Okno {
	/**
	 * konstruktor - glowna metoda ktora buduje okno
	 */
	public OknoWpiszImie(PamiecGry pamiecGry) {
		super();// wykonanie wczesniej napisanych metod
		buduj(pamiecGry);
	}

	/**
	 * buduje nam okno w ktorym jest pole tekstowe i przycisk
	 * 
	 * @param pamiecGry
	 */
	private void buduj(PamiecGry pamiecGry) {
		ustawWysokosc(150);
		ustawSzerokosc(375);
		PoleTekstowe imiePoleTekstowe = new PoleTekstowe();
		// imiePoleTekstowe to nazwa zmiennej typu / rodzaju PoleTekstowe
		imiePoleTekstowe.wstawPodpowiedz("tutaj wpisz imię");
		imiePoleTekstowe.dodajNaglowek("Imię gracza");
		dodajKomponent(imiePoleTekstowe);
		Przycisk zatwierdzPrzycisk = new Przycisk();
		zatwierdzPrzycisk.dodajNaglowek("Zatwierdz");
		zatwierdzPrzycisk.dodajZdarzenie(new SluchaczKlikniecia() {

			@Override
			public void zdarzenieNaKlikniecie(ClickEvent klikniecie) {
				String imieGracza = imiePoleTekstowe.pobierzTekst();
				Gracz nowyGracz = new Gracz();
				nowyGracz.ustawImieGracza(imieGracza);
				pamiecGry.pobierzListaGraczy().dodajGracza(nowyGracz);
				Powiadomienie.wyswietl("Cześć " + imieGracza + " witaj w grze");
				zamknijOkno();
			}

		});
		dodajKomponent(zatwierdzPrzycisk);
	}

}
