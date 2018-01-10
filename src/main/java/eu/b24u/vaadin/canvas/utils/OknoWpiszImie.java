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
	public OknoWpiszImie() {
		super();// wykonanie wczesniej napisanych metod
		buduj();
	}

	/**
	 * buduje nam okno w ktorym jest pole tekstowe i przycisk
	 */
	private void buduj() {
		ustawWysokosc(400);
		ustawSzerokosc(800);
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
				Powiadomienie.wyswietl("Cześć " + imieGracza + " witaj w grze");
			}

		});
		dodajKomponent(zatwierdzPrzycisk);
	}

}
