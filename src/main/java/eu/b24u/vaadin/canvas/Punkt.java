package eu.b24u.vaadin.canvas;

import java.awt.Point;

public class Punkt extends Point{

	public Punkt() {
		super();
	}

	public Punkt(int x, int y) {
		super(x, y);
	}

	@Override
	public String toString() {
		return "Punkt [x=" + x + ", y=" + y + "]";
	}

}
