import acm.program.*;
import acm.graphics.*;

import java.awt.Color;

public class Box extends GraphicsProgram
{
    private Ball[] myBall;
    private Paddle myPaddleTop, myPaddleBottom, myPaddleRight, myPaddleLeft;
    public static void main(String[] args){
        new Box().start();
    }
    public void init()
    {
        myBall = new Ball[17];
        
        for (int k = 0 ; k < 17 ; k++)
        {
            myBall[k] = new PulsingBall(getWidth() * Math.random(),
                                 getHeight() * Math.random(), (Math.random()*8)+2, 
                                 new Color((int)(256 * Math.random()), (int)(256 * Math.random()), (int)(256 * Math.random())), 
                                 10 * Math.random() - 5, 
                                 10 * Math.random() - 5, 
                                 this);
            add(myBall[k]);
        }
        myPaddleTop = new Paddle(getWidth()/2, 0, 200, 20, Color.black, this);
        myPaddleBottom = new Paddle(getWidth()/2, (getHeight()-40), 200, 20, Color.black, this);
        myPaddleLeft = new Paddle(0, getHeight()/2, 20, 200, Color.black, this);
        myPaddleRight = new Paddle(getWidth()-20, getHeight()/2, 20, 200, Color.black, this);
        add(myPaddleBottom);
        add(myPaddleLeft);
        add(myPaddleRight);
        add(myPaddleTop);
    }
    
    public void run()
    {
        while (true)
        {
            for (int k = 0 ; k < 17 ; k++)
                myBall[k].move();

            pause(100);
        }
    }
}