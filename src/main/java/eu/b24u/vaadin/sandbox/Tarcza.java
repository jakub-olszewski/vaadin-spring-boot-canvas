package eu.b24u.vaadin.sandbox;

import com.vaadin.shared.ui.colorpicker.Color;

import eu.b24u.vaadin.canvas.Plotno;
import eu.b24u.vaadin.canvas.Punkt;

public class Tarcza {
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
	public Tarcza(Plotno plotno, int x, int y) {
		setX(x);
		setY(y);
		plotno.rysujKolo(x, y, 200, Color.BLUE);
		plotno.rysujKolo(x, y, 150, Color.WHITE);
		plotno.rysujKolo(x, y, 100, Color.RED);
		plotno.rysujKolo(x, y, 50, Color.WHITE);
		plotno.dodajZdarzenieNaKlikniecieMyszka(e -> plotno.rysujOkrag(plotno.pobierzKliknietyPunkt(), 3));
	}

	public void przedstawSie() {
		System.out.println("Czesc to ja ludzik !");
	}

	/*
	 * sroded<br> |\ <br> p | \<br> | \ odleglosc<br> | \<br> | \<br> -------<br>
	 * q<br>
	 */
	public double obliczOdlegloscOdSrodka(Punkt s) {
		return obliczOdlegloscPomiedzyPunktami(pobierzSrodek(), s);
	}

	public double obliczOdlegloscPomiedzyPunktami(Punkt a, Punkt b) {
		double p = Math.abs(b.getY() - a.getY());
		double q = Math.abs(b.getX() - a.getX());
		double odleglosc = Math.sqrt(Math.pow(p, 2) + Math.pow(p, 2));
		return odleglosc;
	}

	private Punkt pobierzSrodek() {
		return new Punkt(getX(), getY());
	}

}