import java.awt.*;
import java.awt.geom.*;
/**
 * Write a description of class BoxBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoxBall
{
    private int ballDegradation = 2;
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private Canvas canvas;
    private int ySpeed; // initial downward speed
    private int xSpeed;
    
    //Dimensiones rectangulo
    private int techoDelRectangulo;
    private int sueloDelRectangulo;
    private int paredIzquierdaRectangulo;
    private int paredDerechaRectangulo;

    /**
     * Constructor for objects of class BouncingBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param groundPos  the position of the ground (where the wall will bounce)
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor, int ySpeed, int xSpeed,
                        int paredIzq, int techoRect, int paredDer, int sueloRect, Canvas drawingCanvas)
    {
        xPosition = xPos;
        yPosition = yPos;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        color = ballColor;
        diameter = ballDiameter;        
        canvas = drawingCanvas;        
        techoDelRectangulo = techoRect;
        sueloDelRectangulo = sueloRect;
        paredIzquierdaRectangulo = paredIzq;
        paredDerechaRectangulo = paredDer;
        
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();            
        // compute new position        
        yPosition += ySpeed;
        xPosition += xSpeed; //
        // check if it has hit the ground
        if(yPosition >= (sueloDelRectangulo - diameter) || yPosition <= techoDelRectangulo) {
            ySpeed = -ySpeed; 
        }//
        
         if(xPosition >= (paredDerechaRectangulo - diameter) || xPosition <= paredIzquierdaRectangulo) {
            xSpeed = -xSpeed; 
        }

        // draw again at new position
        draw();
    }    

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
}
