package eu.b24u.vaadin.canvas.utils;

public class Gracz {
	String imieGracza;

	public String pobierzImieGracza() {
		return imieGracza;
	}

	public void ustawImieGracza(String imieGracza) {
		this.imieGracza = imieGracza;
	}

	int punkty;
	double czas;

	/**
	 * Zamiana gracza na napis
	 */
	@Override
	public String toString() {
		return "Gracz [imieGracza=" + imieGracza + ", punkty=" + punkty + ", czas=" + czas + "]";
	}
}
