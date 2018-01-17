package eu.b24u.vaadin.canvas.utils;

/**
 * Jest to klasa ktora zawiera takie informacje jak: graczy punkty czas imie
 * gracza
 * 
 * @author student
 *
 */
public class PamiecGry {
	// to jest klasa w kotrej mozemy napisac pole i metody
	// pole jest to zmienna badz zmienne np. tekst lub liczba
	/**
	 * jest to część kodu do tworzenia/konstruowania pamięci gry
	 * 
	 * @param listaGraczy
	 */
	public PamiecGry() {
		ustawListaGraczy(new ListaGraczy());
	}

	ListaGraczy listaGraczy;

	public ListaGraczy pobierzListaGraczy() {
		return listaGraczy;
	}

	public void ustawListaGraczy(ListaGraczy listaGraczy) {
		this.listaGraczy = listaGraczy;
	}

}
