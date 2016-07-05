import java.awt.*;

/**
 * Created by Adam on 7/5/2016. Ws8
 */
public class PulsingBall extends Ball {
    private boolean upOrDown;
    public static void main(String [] args){

    }
    public PulsingBall(double x, double y, double size, Color c, double xVel, double yVel, Box box){
        super(x,  y,  size, c, xVel, yVel, box);
        upOrDown=true;

    }
    public void move(){
        super.move();
        if (getWidth()>=10){
            upOrDown=false;
        }
        if (getWidth()<=2){
            upOrDown=true;
        }
        if (upOrDown){
            setSize(getWidth()+1.0, getWidth()+1.0);
        } else {
            setSize(getWidth()-1.0, getWidth()-1.0);
        }
    }
}
