package eu.b24u.vaadin.canvas;

import org.vaadin.hezamu.canvas.Canvas;
import org.vaadin.hezamu.canvas.Canvas.CanvasMouseMoveListener;

import com.vaadin.shared.MouseEventDetails;

public class VaadinCanvas {
  
  private boolean canDraw;

  
  public Canvas mouseDrawCanvas(){
    Canvas canvas = new Canvas();
    canvas.setSizeFull();
    canvas.fillRect(10, 10, 20, 20);

    canvas.addMouseMoveListener(new CanvasMouseMoveListener() {
      @Override
      public void onMove(MouseEventDetails mouseDetails) {
       // System.out.println(
       //     canDraw+" Mouse moved at " + mouseDetails.getClientX() + "," + mouseDetails.getClientY());
        if (canDraw) {
          canvas.lineTo(mouseDetails.getClientX(), mouseDetails.getClientY());        canvas.stroke();

        }
      }
    });

    canvas.addMouseDownListener(new Canvas.CanvasMouseDownListener() {

      @Override
      public void onMouseDown(MouseEventDetails mouseDetails) {
        canDraw = true;
        canvas.closePath();
        canvas.beginPath();
        System.out.println("onMouseDown "+canDraw);
      }
    });
    canvas.addMouseUpListener(new Canvas.CanvasMouseUpListener() {

      @Override
      public void onMouseUp(MouseEventDetails mouseDetails) {
        canDraw = false;        System.out.println("onMouseUp "+canDraw);          
        canvas.stroke();
        

      }
    });
    return canvas;
  }

}
