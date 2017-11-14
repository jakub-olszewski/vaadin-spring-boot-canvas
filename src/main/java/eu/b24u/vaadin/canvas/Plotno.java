package eu.b24u.vaadin.canvas;

import java.awt.Point;

import org.vaadin.hezamu.canvas.Canvas;

import com.vaadin.shared.MouseEventDetails;

public class Plotno extends Canvas implements Rysowanie {
  
  Punkt klikPunkt;

  public Plotno() {
    super();
    setSizeFull();
    klikPunkt = new Punkt();
    addMouseDownListener(new Canvas.CanvasMouseDownListener() {

      @Override
      public void onMouseDown(MouseEventDetails mouseDetails) {
        klikPunkt.setLocation(mouseDetails.getRelativeX(), mouseDetails.getRelativeY());
        drawCircle(klikPunkt.x, klikPunkt.y, 3);
      }
    });
  }

  @Override
  public Point getClickPoint() {
    return klikPunkt;
  }

  @Override
  public void drawCircle(int x, int y, int r) {
    saveContext();
    arc(x, y, r, 0, 2 * Math.PI, true);
    stroke();
    beginPath();
    setFillStyle("blue");
    fill();    
  }

  @Override
  public void drawLine(int x1, int y1, int x2, int y2) {
    beginPath();
    moveTo(x1, y1);
    lineTo(x2, y2);
    saveContext();
  }

  


}
