package eu.b24u.vaadin.canvas;

import java.awt.Point;

public interface Rysowanie {
  
  default public void rysujOkrag(int x, int y, int r){
    drawCircle(x, y, r);
  }
  
  public void drawCircle(int x, int y, int r);
  
  default public Punkt pobierzKliknietyPunkt(){
    return (Punkt) getClickPoint();
  }
  
  public Point getClickPoint();
  
  default public void rysujLinie(int x1, int y1,int x2, int y2){
    drawLine(x1, y1, x2, y2);
  }
  
  public void drawLine(int x1, int y1,int x2, int y2);

}
