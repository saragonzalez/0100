import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private ArrayList <BouncingBall> bolas = new ArrayList<>(); 

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        // 600 es la x y 500 es la y
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int bola)
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // caja y mostrar las bolas
        for(int i=0; i<bola; i++){

            Random aleatorio = new Random ();
            int x = aleatorio.nextInt(300);
            int y = aleatorio.nextInt(250);
            int diametro = aleatorio.nextInt(50);
            int colorRojo = aleatorio.nextInt(256);
            int colorVerde = aleatorio.nextInt(256);
            int colorAzul = aleatorio.nextInt(256);
            

            BouncingBall ball = new BouncingBall(x, y, diametro, new Color(colorRojo, colorVerde, colorAzul), ground, myCanvas);
            ball.draw();
            bolas.add(ball);
        }

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);      // small delay
            for(BouncingBall cadaBola:bolas){
            cadaBola.move();
            
            // stop once ball has travelled a certain distance on x axis
                if(cadaBola.getXPosition() >= 550) {
                finished = true;
                }
            }
        }
    }
}
