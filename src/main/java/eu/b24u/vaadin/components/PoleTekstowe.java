package eu.b24u.vaadin.components;

import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.TextField;

/**
 * klasa ktora tworzy pole tekstowe w ktore mozna wpisac i pobrac tekst
 * 
 * @author student
 *
 */
public class PoleTekstowe extends TextField {
	/**
	 * metoda wstawia tekst
	 * 
	 * @param tekst
	 */
	public void wstawTekst(String tekst) {
		setValue(tekst);
	}

	/**
	 * metoda pobiera tekst
	 * 
	 * @return tekst z pola tekstowego
	 */
	public String pobierzTekst() {
		return getValue();
	}

	/**
	 * metoda dodaje naglowek
	 * 
	 * @param naglowek
	 *            to tekst po lewej stronie pola tekstowego
	 */
	public void dodajNaglowek(String naglowek) {
		setCaption(naglowek);
	}

	public void wstawPodpowiedz(String podpowiedz) {
		setDescription(podpowiedz, ContentMode.TEXT);
	}
}
