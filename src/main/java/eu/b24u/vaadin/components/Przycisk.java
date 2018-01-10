package eu.b24u.vaadin.components;

import com.vaadin.ui.Button;

/**
 * klasa ktora tworzy przycisk
 * 
 * @author student
 *
 */
public class Przycisk extends Button {
	/**
	 * metoda dodaje zdarzenie ktoree ma sie wykonac po kliknieciu w przycisk
	 * 
	 * @param listener
	 */
	public void dodajZdarzenie(ClickListener listener) {
		addClickListener(listener);
	}

	public void dodajNaglowek(String naglowek) {
		setCaption(naglowek);
	}
}
