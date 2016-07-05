import acm.graphics.GLabel;

/**
 * Created by Adam on 7/5/2016. Lab 7
 */
public class Score extends GLabel {
    private int myScore;

    public Score(double x, double y) {
        super("0", x, y);
        myScore=0;
    }
    public void add(int toAdd){
        myScore+=toAdd;
        setLabel(""+myScore);
    }
}
