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
    public void bounce1(int bola)
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);
        ArrayList <BouncingBall> bolas = new ArrayList<>(); 

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
                    break;
                }
            }
        }
    }

    public void boxBounce(int bola){
        ArrayList <BoxBall> bolas = new ArrayList<>();      
        
            int techoDelRectangulo = 100;
            int sueloDelRectangulo = 300;
            int paredIzquierdaRectangulo = 100;
            int paredDerechaRectangulo = 400;
        
        myCanvas.fillRectangle(paredIzquierdaRectangulo,techoDelRectangulo,paredDerechaRectangulo - paredIzquierdaRectangulo,sueloDelRectangulo - techoDelRectangulo);
        myCanvas.setVisible(true);       
                     

        // caja y mostrar las bolas
        for(int i=0; i<bola; i++){

            Random aleatorio = new Random ();
            int x = aleatorio.nextInt(300)+100;
            int y = aleatorio.nextInt(200) +100;
            int diametro = aleatorio.nextInt(50);            
            int colorRojo = aleatorio.nextInt(256);
            int colorVerde = aleatorio.nextInt(256);
            int colorAzul = aleatorio.nextInt(256);
            int ySpeed = 1;
            int xSpeed = 1;
           

            // BouncingBall ball = new BouncingBall(x, y, diametro, new Color(colorRojo, colorVerde, colorAzul), ground, myCanvas);
            BoxBall ball = new BoxBall(x, y, diametro, new Color(colorRojo, colorVerde, colorAzul), ySpeed, xSpeed, paredIzquierdaRectangulo, techoDelRectangulo, paredDerechaRectangulo, sueloDelRectangulo, myCanvas);
            ball.draw();
            bolas.add(ball);
        }

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(10);  // Cambiado el parametro de 50 a 10 para que vaya mas rapido
            for(BoxBall cadaBola:bolas){
                cadaBola.move();
            }
        }
    }
}
