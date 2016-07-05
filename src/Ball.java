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
        if (getX() <= 0) {
            myBox.gameOver();
        }
        
        if (getX() >= myBox.getWidth()-getWidth()) {
            myBox.gameOver();

        }
        if (getY() <= 0) {
            myBox.gameOver();
        }
        
        if (getY() >= myBox.getHeight()-getHeight()) {
            myBox.gameOver();

        }
        if (getY()<=myBox.getMyPaddleTop().getHeight()){
            if (getX()>=myBox.getMyPaddleTop().getX() && getX()<=myBox.getMyPaddleTop().getWidth()+myBox.getMyPaddleTop().getX()){
                myYVelocity = -myYVelocity;
                setLocation(getX(),myBox.getMyPaddleBottom().getHeight());
                myBox.getScore().add(1);
            }
        }
        if (getY()+getHeight() >= myBox.getMyPaddleBottom().getY()){
            if (getX() >= myBox.getMyPaddleBottom().getX() && getX() <= myBox.getMyPaddleBottom().getWidth() + myBox.getMyPaddleBottom().getX()) {
                myYVelocity = -myYVelocity;
                setLocation(getX(),myBox.getMyPaddleBottom().getY()-getHeight());
                myBox.getScore().add(1);
            }
        }
        if (getX() <= myBox.getMyPaddleLeft().getWidth()){
            if (getY() >= myBox.getMyPaddleLeft().getY()&&getY() <= myBox.getMyPaddleLeft().getHeight()+myBox.getMyPaddleLeft().getY()){
                myXVelocity = -myXVelocity;
                setLocation(myBox.getMyPaddleLeft().getWidth(),getY());
                myBox.getScore().add(1);
            }
        }
        if (getX() >= myBox.getMyPaddleRight().getX()-getWidth()){
            if (getY() >= myBox.getMyPaddleRight().getY() && getY() <= myBox.getMyPaddleRight().getHeight() + myBox.getMyPaddleRight().getY()) {
                setLocation(myBox.getMyPaddleRight().getX()-getWidth(),getY());
                myXVelocity = -myXVelocity;
                myBox.getScore().add(1);
            }
        }
        
        super.move(myXVelocity, myYVelocity);
    }
}