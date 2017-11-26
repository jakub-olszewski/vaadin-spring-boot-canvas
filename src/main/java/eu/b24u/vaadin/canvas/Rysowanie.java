package eu.b24u.vaadin.canvas;

import java.awt.Point;

import org.vaadin.hezamu.canvas.Canvas.CanvasMouseDownListener;

import com.vaadin.shared.ui.colorpicker.Color;

public interface Rysowanie {

	public void dodajZdarzenieNaKlikniecieMyszka(CanvasMouseDownListener listener);

	default public void rysujOkrag(Punkt p, int r) {
		drawCircle(p, r, null);
	}

  default public void rysujOkrag(int x, int y, int r){
		drawCircle(new Point(x, y), r, null);
  }
  
	default public void rysujTrojkat(Punkt a, Punkt b, Punkt c) {
		drawTriangle(a, b, c, null);
	}

	default public void rysujTrojkat(Punkt a, Punkt b, Punkt c, Color color) {
		drawTriangle(a, b, c, color);
	}

	default public void rysujKolo(int x, int y, int r, Color color) {
		drawCircle(new Point(x, y), r, color);
	}

	public void drawCircle(Point s, int r, Color color);

  default public Punkt pobierzKliknietyPunkt(){
    return (Punkt) getClickPoint();
  }
  
  public Point getClickPoint();

	default public void wstawText(Punkt p, String text) {
		insertText(p, text);
	}

	public void insertText(Point p, String text);
  
  default public void rysujLinie(int x1, int y1,int x2, int y2){
		drawLine(new Point(x1, y1), new Point(x2, y2), null);
	}

	default public void rysujLinie(int x1, int y1, int x2, int y2, Color color) {
		drawLine(new Point(x1, y1), new Point(x2, y2), color);
  }
  
	default public void rysujLinie(Point a, Point b, Color color) {
		drawLine(a, b, color);
	}
	default public void rysujProstokat(Point a, Point b, Color color) {
		drawRectangle(a, b, color);
	}
	public void drawTriangle(Point a, Point b, Point c, Color color);

	public void drawLine(Point a, Point b, Color color);

	public void drawRectangle(Point a, Point b, Color color);

}
