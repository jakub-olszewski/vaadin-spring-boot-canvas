package eu.b24u.vaadin.canvas.utils;

import java.util.ArrayList;
import java.util.Collection;

/**
 * lista graczy, jest to klasa/obiekt
 * 
 * @author student
 *
 */
public class ListaGraczy extends ArrayList<Gracz> {

	private String ZNAK_ENTER = "\n";

	/**
	 * Zamien obiekt (listaGraczy) na napis
	 */
	@Override
	public String toString() {
		// lista graczy to napis
		String listaGraczy= "";
		// for to jest dla każdego gracza z listy
		// this to lista graczy w której teraz jesteśmy
		for(Gracz graczZListy: this) {
			// listaGraczy = listaGraczy + "imie gracza"
			// listaGraczy += "imie gracza"
			listaGraczy += graczZListy.toString() + ZNAK_ENTER;
		}
		return listaGraczy;
	}

	private static final long serialVersionUID = 1L;

	public ListaGraczy() {
		super();
	}

	public ListaGraczy(Collection<? extends Gracz> c) {
		super(c);
	}

	public ListaGraczy(int initialCapacity) {
		super(initialCapacity);
	}

	public void dodajGracza(Gracz nowyGracz) {
		add(nowyGracz);
	}

	public Gracz pobierzPierwszegoGracza() {
		if (size() == 0) {
			return null;
		}
		return get(0);
	}

}
