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
        if (getY()<=myBox.getMyPaddleTop().getHeight()){
            if (getX()>=myBox.getMyPaddleTop().getX() && getX()<=myBox.getMyPaddleTop().getWidth()+myBox.getMyPaddleTop().getX()){
                System.out.println("top");
                myYVelocity = -myYVelocity;
                setLocation(getX(),myBox.getMyPaddleBottom().getHeight());
            }
        }
        if (getY()+getHeight() >= myBox.getMyPaddleBottom().getY()){
            if (getX() >= myBox.getMyPaddleBottom().getX() && getX() <= myBox.getMyPaddleBottom().getWidth() + myBox.getMyPaddleBottom().getX()) {
                myYVelocity = -myYVelocity;
                setLocation(getX(),myBox.getMyPaddleBottom().getY()-getHeight());
                System.out.println("bottom");
            }
        }
        if (getX() <= myBox.getMyPaddleLeft().getWidth()){
            if (getY() >= myBox.getMyPaddleLeft().getY()&&getY() <= myBox.getMyPaddleLeft().getHeight()+myBox.getMyPaddleLeft().getY()){
                myXVelocity = -myXVelocity;
                System.out.println("left");
                setLocation(myBox.getMyPaddleLeft().getWidth(),getY());
            }
        }
        if (getX() >= myBox.getMyPaddleRight().getX()-getWidth()){
            if (getY() >= myBox.getMyPaddleRight().getY() && getY() <= myBox.getMyPaddleRight().getHeight() + myBox.getMyPaddleRight().getY()) {
                setLocation(myBox.getMyPaddleRight().getX()-getWidth(),getY());
                myXVelocity = -myXVelocity;
                System.out.println("right");
            }
        }
        
        super.move(myXVelocity, myYVelocity);
    }
}