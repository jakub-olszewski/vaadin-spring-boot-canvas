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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaGraczy == null) ? 0 : listaGraczy.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PamiecGry other = (PamiecGry) obj;
		if (listaGraczy == null) {
			if (other.listaGraczy != null)
				return false;
		} else {
			for (Gracz gracz : listaGraczy) {
				if (!other.listaGraczy.contains(gracz)) {
					return false;
				}
			}
			return true;
		}
		return false;

	}

	ListaGraczy listaGraczy;

	public ListaGraczy pobierzListaGraczy() {
		return listaGraczy;
	}

	public void ustawListaGraczy(ListaGraczy listaGraczy) {
		this.listaGraczy = listaGraczy;
	}

}
