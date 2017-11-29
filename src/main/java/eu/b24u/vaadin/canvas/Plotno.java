package eu.b24u.vaadin.canvas;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.vaadin.hezamu.canvas.Canvas;

import com.vaadin.shared.MouseEventDetails;
import com.vaadin.shared.ui.colorpicker.Color;

public class Plotno extends Canvas implements Rysowanie {

	List<Punkt> punkty;
	Punkt klikPunkt;
	Logger logger = Logger.getLogger(getClass());

	public Plotno() {
		super();
		setSizeFull();
		klikPunkt = new Punkt();
		punkty = new ArrayList<>();
		addMouseDownListener(new Canvas.CanvasMouseDownListener() {

			@Override
			public void onMouseDown(MouseEventDetails mouseDetails) {
				klikPunkt.setLocation(mouseDetails.getRelativeX(), mouseDetails.getRelativeY());
				punkty.add(klikPunkt);
				logger.info(klikPunkt);
			}
		});
	}

	@Override
	public Point getClickPoint() {
		return klikPunkt;
	}

	@Override
	public void drawCircle(Point s, int r, Color color) {
		beginPath();
		arc(s.x, s.y, r, 0, 2 * Math.PI, true);
		fillColor(color);
		stroke();
	}

	private void fillColor(Color color) {
		if (color != null) {
			setFillStyle(color.getRed(), color.getGreen(), color.getBlue());
			fill();
		}
	}

	@Override
	public void drawLine(Point a, Point b, Color color) {
		beginPath();
		moveTo(a.getX(), a.getY());
		lineTo(b.getX(), b.getY());
		fillColor(color);
		stroke();
		closePath();
	}

	@Override
	public void drawTriangle(Point a, Point b, Point c, Color color) {
		beginPath();
		moveTo(a.getX(), a.getY());
		lineTo(b.getX(), b.getY());
		lineTo(c.getX(), c.getY());
		fillColor(color);
		closePath();
	}

	@Override
	public void drawRectangle(Point a, Point b, Color color) {
		beginPath();
		fillColor(color);
		fillRect(a.getX(), a.getY(), b.getX(), b.getY());
		closePath();
	}

	@Override
	public void insertText(Point p, String text) {
		setFont("30px Arial");
		fillText(text, p.getX(), p.getY(), 200);
	}

	@Override
	public void dodajZdarzenieNaKlikniecieMyszka(CanvasMouseDownListener listener) {
		addMouseDownListener(listener);

		// ;

	}

}
