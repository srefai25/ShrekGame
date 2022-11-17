import java.awt.*;

public class Shrek {

    public String name;
    public int xpos;
    public int ypos;
    public int dx;
    public int dy;
    public int width;
    public int height;
    public boolean isOgre;
    public Rectangle rec;

    public Shrek(String pName, int pXpos, int pYpos, int pWidth, int pHeight){
        name = pName;
        xpos = pXpos;
        xpos = (int)(Math.random()*400+100);
        ypos = pYpos;
        ypos = (int)(Math.random()*150+50);
        dx = 5;
        dy = 3;
        width = pWidth;
        height = pHeight;
        isOgre = true;
        rec = new Rectangle(xpos,ypos,width,height);
    }

    public void move(){
        xpos = xpos+dx;
        ypos = ypos+dy;
    }

    public void bounce(){
        xpos = xpos+dx;
        ypos = ypos+dy;

        if(xpos>=900 || xpos<=0){//right or left wall
            dx=-dx;
        }

        if (ypos<=0 || ypos>=600){//top or bottom wall
            dy=-dy;
        }

        rec = new Rectangle(xpos,ypos, width, height);

    }

    public void wrap(){
        xpos = xpos + dx;
        ypos = ypos + dy;


        if (xpos>=1000 || xpos<=0){
            xpos = 0;
        }

        if (ypos>=700 || ypos<=0){
            ypos=0;
        }

        rec = new Rectangle(xpos,ypos, width, height);
    }
}
