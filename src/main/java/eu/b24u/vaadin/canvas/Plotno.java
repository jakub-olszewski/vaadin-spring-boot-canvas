package eu.b24u.vaadin.canvas;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.vaadin.hezamu.canvas.Canvas;

import com.vaadin.shared.MouseEventDetails;

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
				drawCircle(klikPunkt.x, klikPunkt.y, 3);
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
	public void drawCircle(int x, int y, int r) {
		beginPath();
		arc(x, y, r, 0, 2 * Math.PI, true);
		stroke();
	}

	@Override
	public void drawLine(int x1, int y1, int x2, int y2) {
		/*
		 * saveContext();
		 * 
		 * beginPath(); moveTo(x1, y1); lineTo(x2, y2); stroke();
		 */
		beginPath();
		moveTo(x1, y1);
		lineTo(x2, y2);
		stroke();
	}

	public void rysujLinie() {
		int ostatniPunkt = punkty.size();
		Punkt punktOd = punkty.get(0);
		Punkt punktDo = punkty.get(1);

		drawLine(punktOd.x, punktOd.y, punktDo.x, punktDo.y);
	}

}
