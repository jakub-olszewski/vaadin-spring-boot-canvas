package eu.b24u.vaadin.sandbox;

import eu.b24u.vaadin.canvas.Plotno;

public class Ludzik {
	int x;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	int y;

	/**
	 * Konstruktor - konstruje obiekt np rysuje go na planszy
	 * 
	 * @param plotno
	 *            - plansza na ktorej rysujemy ludzika
	 */
	public Ludzik(Plotno plotno, int x, int y) {
		setX(x);
		setY(y);
		plotno.rysujOkrag(x, y, 200);
		plotno.rysujOkrag(x, y, 150);
		plotno.rysujOkrag(x, y, 100);
	}

	public void przedstawSie() {
		System.out.println("Czesc to ja ludzik !");
	}

}
