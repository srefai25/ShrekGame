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
    public boolean withCat;
    public boolean isCrashing;
    public boolean isCrashingWithShrek;
    public boolean isCrashingWithFiona;
    public boolean GameIsPaused;
    public Rectangle rec;

    public Shrek(String pName, int pXpos, int pYpos, int pWidth, int pHeight, int pDx, int pDy){
        name = pName;
        xpos = pXpos;
        ypos = pYpos;
        dx = pDx;
        dy = pDy;
        width = pWidth;
        height = pHeight;
        isOgre = true;
        withCat = true;
        isCrashing = false;
        isCrashingWithShrek = false;
        isCrashingWithFiona = false;
        GameIsPaused = false;
        rec = new Rectangle(xpos,ypos,width,height);
    }

    public void move(){//move the character
        xpos = xpos+dx;
        ypos = ypos+dy;
    }

    public void sizeMinus(){//make character change sizes and dimensions
        width = width+dx;
        height=height+dy;
    }


    public void bounce(){//bounce against the sides of the screen
        xpos = xpos+dx;
        ypos = ypos+dy;

        if(xpos>=900-width || xpos<=0-width){//right or left wall
            dx=-dx;
        }

        if (ypos<=0-height || ypos>=600-height){//top or bottom wall
            dy=-dy;
        }

        rec = new Rectangle(xpos,ypos, width, height);

    }

    public void wrap(){//go around the screen
        xpos = xpos + dx;
        ypos = ypos + dy;


        if (xpos>=1000 || xpos<=0){
            xpos = 0;
        }

        if (ypos>=700 || ypos<=0){
            ypos=0;
        }

        rec = new Rectangle(xpos,ypos, width, height);//creates a hitbox
    }

    public void pause(){
        xpos = xpos;
        ypos = ypos;
    }
}
