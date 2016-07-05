import acm.graphics.GRect;

import java.awt.*;

/**
 * Created by Adam on 7/5/2016. ws8
 */
public class Paddle extends GRect {
    public static void main(String[] args){

    }
    public Paddle(double x, double y, double width, double height, Color c, Box box){
        super(x, y, width, height);
        setColor(c);
        setFillColor(c);
        setFilled(true);


    }
    public void setX(double coord){
        super.setLocation(coord, getY());
    }
    public void setY(double coord){
        super.setLocation(getX(), coord);
    }
    public double getX(){
        return super.getX();
    }
    public double getY(){
        return super.getY();
    }
    public double getWidth(){
        return super.getWidth();
    }
    public double getHeight(){
        return super.getHeight();
    }

}
