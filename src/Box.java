import acm.program.*;
import acm.graphics.*;

import java.awt.Color;

public class Box extends GraphicsProgram
{
    private Ball[] myBall;
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