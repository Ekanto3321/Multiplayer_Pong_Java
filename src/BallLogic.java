import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class BallLogic {


    Random random = new Random();
    int ballXVelocity = 2;
    int ballYVelocity = 2;
    int YdirectionVector = setRandomDirection();
    int XdirectionVector = setRandomDirection();
    int y1,y2,bx,by;
    int s1 = 0;
    int s2 = 0;



    public String runLogic(){
        by+=ballYVelocity*YdirectionVector;
        bx+=ballXVelocity*XdirectionVector;

        Paddle p1 = new Paddle(0,y2);
        Paddle p2 = new Paddle(870,y1);
        Ball b = new Ball(bx,by);

        if(by>=500){
            YdirectionVector = -1;
        }
        if(by<=0){
            YdirectionVector = 1;
        }
        if(bx>=900){
            s2++;
            by=random.nextInt(500);
            bx=450;
            ballYVelocity = 2;
            ballXVelocity = 2;
            XdirectionVector = setRandomDirection();
            YdirectionVector = setRandomDirection();
        }
        if(bx<=0){
            s1++;
            by=random.nextInt(500);
            bx=450;
            ballYVelocity = 2;
            ballXVelocity = 2;
            XdirectionVector = setRandomDirection();
            YdirectionVector = setRandomDirection();
        }
        if(b.intersects(p2)){
            XdirectionVector = -1;
            if(ballXVelocity<=12&&ballYVelocity<=12) {
                ballXVelocity++;
                ballYVelocity++;
            }
        }
        if(b.intersects(p1)){
            XdirectionVector = 1;
            if(ballXVelocity<=12&&ballYVelocity<=12) {
                ballXVelocity++;
                ballYVelocity++;
            }
        }


        return y1+" "+y2+ " "+bx+" "+by+" "+s1+" "+s2;
    }

    public int setRandomDirection(){
        if(random.nextBoolean())return -1;
        else return 1;
    }

    public String setCoordinates(int y1, int y2, int bx, int by,int s1,int s2){
        this.y1 =y1;
        this.y2 =y2;
        this.bx =bx;
        this.by =by;
        this.s1 =s1;
        this.s2 =s2;

        return runLogic();
    }


}


class Paddle extends Rectangle{
    Paddle(int x, int y){
        super(x,y,20,100);
    }

}
class Ball extends Rectangle{
    Ball(int x, int y){
        super(x,y,20,20);
    }
}




