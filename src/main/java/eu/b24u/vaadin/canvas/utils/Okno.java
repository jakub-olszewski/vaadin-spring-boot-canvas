package eu.b24u.vaadin.canvas.utils;

import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;

public class Okno extends Window {

	private FormLayout layout;

	public Okno() {
		super();
		init();
		UI.getCurrent().addWindow(this);
	}

	public void zamknijOkno() {
		close();
	}

	/**
	 * metoda ustawia wysokosc
	 * 
	 * @param wysokoscWPikselach
	 *            wysokosc podana w pikselach
	 */
	public void ustawWysokosc(int wysokoscWPikselach) {
		setHeight(wysokoscWPikselach, Unit.PIXELS);
	}

	/**
	 * metoda ustawia szerokosc
	 * 
	 * @param szerokoscWPikselach
	 */
	public void ustawSzerokosc(int szerokoscWPikselach) {
		setWidth(szerokoscWPikselach, Unit.PIXELS);
	}

	/**
	 * metoda dodaje komponent
	 * 
	 * @param component
	 *            to obiekt typu np. pole tekstowe lub przycisk
	 */
	public void dodajKomponent(Component component) {
		layout.addComponent(component);
	}

	private void init() {
		center();
		layout = new FormLayout();
		layout.setMargin(true);
		layout.setSpacing(true);
		layout.setSizeFull();
		setContent(layout);
	}
}
