import acm.program.*;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class Box extends GraphicsProgram
{
    private final static int NUM_BALLS=2;
    private Ball[] myBall;
    private boolean myRun;
    private Paddle myPaddleTop, myPaddleBottom, myPaddleRight, myPaddleLeft;
    private Score myScore;
    public static void main(String[] args){
        new Box().start();
    }
    public void init()
    {
        myBall = new Ball[NUM_BALLS];
        myRun=true;
        for (int k = 0 ; k < NUM_BALLS ; k++)
        {
            myBall[k] = new Ball(getWidth() * Math.random(),
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

        myScore = new Score(100, 100);
        add(myScore);

        addMouseListeners();
    }
    public void mouseMoved(MouseEvent e)
    {
        double y, x;

        y = e.getY();

        if (y < 0)
            y = 0;

        if (y > getHeight() - myPaddleRight.getHeight())
            y = getHeight() - myPaddleRight.getHeight();

        myPaddleLeft.setY(y);
        myPaddleRight.setY(y);

        x = e.getX();
        if (x < 0)
            x = 0;

        if (x > getWidth() - myPaddleBottom.getWidth())
            x = getWidth() - myPaddleBottom.getWidth();

        myPaddleTop.setX(x);
        myPaddleBottom.setX(x);
    }
    
    public void run()
    {
        while (myRun)
        {
            for (int k = 0 ; k < NUM_BALLS ; k++)
                myBall[k].move();

            pause(50);
        }
    }
    public Paddle getMyPaddleTop(){
        return  myPaddleTop;
    }
    public Paddle getMyPaddleBottom(){
        return myPaddleBottom;
    }
    public Paddle getMyPaddleRight(){
        return myPaddleRight;
    }
    public Paddle getMyPaddleLeft(){
        return myPaddleLeft;
    }
    public Score getScore(){
        return myScore;
    }
    public void gameOver(){
        myScore.setLabel("Game Over");
        myRun=false;
    }
}