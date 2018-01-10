package eu.b24u.vaadin.components;

import com.vaadin.ui.TextField;

public class PoleTekstowe extends TextField {

	public void wstawText(String tekst) {
		setValue(tekst);
	}

	public String pobierzTekst() {
		return getValue();
	}

	public void dodajNaglowek(String naglowek) {
		setCaption(naglowek);
	}
}
