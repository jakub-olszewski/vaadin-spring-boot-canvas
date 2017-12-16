package eu.b24u.vaadin.sandbox;

import com.vaadin.shared.ui.colorpicker.Color;

import eu.b24u.vaadin.canvas.Plotno;
import eu.b24u.vaadin.canvas.Punkt;

/**
 * @author mary
 *
 */
/**
 * @author mary
 *
 */
public class Strzala extends ElementNaPlotnie {

	private Punkt wierzcholekStrzaly;

	/**
	 * Rysuje strzale w punkcie x,y 
	 * @param plotno miejsce gdzie ma narysowac strzale
	 * @param x wspolrzedna pozioma
	 * @param y wspolrzedna pionowa
	 */
	public Strzala(Plotno plotno, int x, int y) {
		super(plotno, x, y);
	}
	
	/**
	 * Rysuje strzale w punkcie wierzcholekStrzaly
	 * @param plotno miejsce gdzie ma narysowac strzale
	 * @param wierzcholekStrzaly wierzcholek strzaly
	 */
	public Strzala(Plotno plotno, Punkt wierzcholekStrzaly) {
		this(plotno, wierzcholekStrzaly.x, wierzcholekStrzaly.y);
	}

	@Override
	public void rysowanie() {
		Punkt a = new Punkt(x , y );
		Punkt c = new Punkt(x + 20, y + 5);
		Punkt b = new Punkt(x + 5, y + 20);
		plotno.rysujTrojkat(a, b, c, Color.BLACK);
		Punkt d = new Punkt(x + 30, y + 30);
		plotno.rysujLinie(a, d, Color.RED);
	}

}
