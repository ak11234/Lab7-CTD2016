import acm.program.*;
import acm.graphics.*;

import java.awt.Color;

public class Ball extends GOval
{
    private double myXVelocity;
    private double myYVelocity;
    private Box myBox;
    
    public Ball(double x, double y, double size, Color c, double xVel, double yVel, Box box)
    {
        super(x, y, size, size);
        
        setColor(c);
        setFillColor(c);
        setFilled(true);
        
        myXVelocity = xVel;
        myYVelocity = yVel;
        myBox = box;
    }
    
    public void move()
    {
        if (getX() <= 0)
            myXVelocity = -myXVelocity;
        
        if (getX() >= myBox.getWidth()-getWidth()) {
            setLocation(myBox.getWidth() - getWidth(), getY());
            myXVelocity = -myXVelocity;
        }
        if (getY() <= 0)
            myYVelocity = -myYVelocity;
        
        if (getY() >= myBox.getHeight()-getHeight()) {
            setLocation(getX(), myBox.getHeight() - getHeight());
            myYVelocity = -myYVelocity;
        }
        
        super.move(myXVelocity, myYVelocity);
    }
}