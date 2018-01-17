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
