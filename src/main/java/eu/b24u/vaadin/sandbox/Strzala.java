package eu.b24u.vaadin.sandbox;

import com.vaadin.shared.ui.colorpicker.Color;

import eu.b24u.vaadin.canvas.Plotno;
import eu.b24u.vaadin.canvas.Punkt;

public class Strzala extends ElementNaPlotnie {

	public Strzala(Plotno plotno, int x, int y) {
		super(plotno, x, y);
	}

	@Override
	public void rysowanie() {
		Punkt a = new Punkt(x, y);
		Punkt c = new Punkt(x + 200, y + 50);
		Punkt b = new Punkt(x + 50, y + 200);
		plotno.rysujTrojkat(a, b, c, Color.RED);
		Punkt d = new Punkt(x + 300, y + 300);
		plotno.rysujLinie(a, d, Color.RED);
	}

}
