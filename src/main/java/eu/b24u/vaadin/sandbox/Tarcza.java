
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
	 * Tarcza kolorowa na ktorej rysujemy strzale
	 * 
	 * @param plotno to plansza na ktorej rysujemy objekt np. tarcza<br>
	 * X i Y to wspolrzedne gdzie ma byc narysowana tarcza.
	 * @param x to wspolrzedna pozioma 
	 * @param y to wspolrzedna pionowa
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

	/**
	 * Obliczanie odleglosci od srodka tarczy          
	 * @param s to wspolrzedna punktu od ktorego liczymy odleglosc
	 * @return odleglosc punktu s od srodka tarczy
	 */
	public double obliczOdlegloscOdSrodka(Punkt s) {
		return obliczOdlegloscPomiedzyPunktami(pobierzSrodek(), s);
	}

	/**
	 * Oblicza odleglosc pomiedzy dwoma punktami a i b
	 * @param a punkt od ktorego zaczynamy liczyc
	 * @param b punkt na ktorym konczymy liczyc odleglosc
	 * @return odleglosc pomiedzy punktami a i b
	 */
	public double obliczOdlegloscPomiedzyPunktami(Punkt a, Punkt b) {
		double p = Math.abs(b.getY() - a.getY());
		double q = Math.abs(b.getX() - a.getX());
		double odleglosc = Math.sqrt(Math.pow(p, 2) + Math.pow(q, 2));
		return odleglosc;
	}

	private Punkt pobierzSrodek() {
		return new Punkt(getX(), getY());
	}

}
