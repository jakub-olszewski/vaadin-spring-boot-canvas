package eu.b24u.vaadin.sandbox;

import eu.b24u.vaadin.canvas.Plotno;

public abstract class ElementNaPlotnie {
	int x;
	Plotno plotno;
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
	public ElementNaPlotnie(Plotno plotno, int x, int y) {
		setX(x);
		setY(y);
		setPlotno(plotno);
		rysowanie();
	}

	abstract public void rysowanie();
	public void przedstawSie() {
		System.out.println("Czesc to ja ludzik !");
	}

	public Plotno getPlotno() {
		return plotno;
	}

	public void setPlotno(Plotno plotno) {
		this.plotno = plotno;
	}

}
