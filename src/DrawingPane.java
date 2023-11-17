import javax.swing.*;
import java.awt.*;

//drawing stuff
public class DrawingPane extends JPanel {
    static int WINDOW_HEIGHT = 550;
    static int WINDOW_WIDTH = 900;
    static int PADDLE_HEIGHT=100;
    static int PADDLE_WIDTH=20;
    int y1,y2,x3,y3,s1,s2;
    public void setDrawingData(int y1, int y2, int x3, int y3,int s1,int s2){
        this.y1=y1;
        this.y2=y2;
        this.x3=x3;
        this.y3=y3;
        this.s1=s1;
        this.s2=s2;
    }
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(448,10,2,500);
        g.fillOval(x3,y3,20,20);

        g.setColor(Color.red);
        g.drawString(String.valueOf(s1), 460,30);
        g.fillRect(WINDOW_WIDTH-30,y2, PADDLE_WIDTH, PADDLE_HEIGHT);


        g.setColor(Color.blue);
        g.drawString(String.valueOf(s2), 430,30);
        g.fillRect(0,y1, PADDLE_WIDTH, PADDLE_HEIGHT);


        Toolkit.getDefaultToolkit().sync();
    }
}