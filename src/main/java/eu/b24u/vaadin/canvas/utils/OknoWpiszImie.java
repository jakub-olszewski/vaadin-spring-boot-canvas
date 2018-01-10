package eu.b24u.vaadin.canvas.utils;

import com.vaadin.ui.Button.ClickEvent;

import eu.b24u.vaadin.components.PoleTekstowe;
import eu.b24u.vaadin.components.Powiadomienie;
import eu.b24u.vaadin.components.Przycisk;
import eu.b24u.vaadin.listener.SluchaczKlikniecia;

public class OknoWpiszImie extends Okno {

	public OknoWpiszImie() {
		super();
		buduj();
	}

	private void buduj() {
		ustawWysokosc(400);
		ustawSzerokosc(800);
		PoleTekstowe imiePoleTekstowe = new PoleTekstowe();
		imiePoleTekstowe.dodajNaglowek("imie");
		dodajKomponent(imiePoleTekstowe);
		Przycisk zatwierdzPrzycisk = new Przycisk();
		zatwierdzPrzycisk.dodajNaglowek("Zatwierdz");
		zatwierdzPrzycisk.dodajZdarzenie(new SluchaczKlikniecia() {

			@Override
			public void zdarzenieNaKlikniecie(ClickEvent klikniecie) {
				Powiadomienie.wyswietl("klikniety przycisk");
			}

		});
		dodajKomponent(zatwierdzPrzycisk);
	}

}
