public class Shrek {

    public String name;
    public int xpos;
    public int ypos;
    public int dx;
    public int dy;
    public int width;
    public int length;
    public boolean isOgre;

    public Shrek(String pName, int pXpos, int pYpos){
        name = pName;
        xpos = pXpos;
        ypos = pYpos;
        dx = 5;
        dy = 3;
        width = 100;
        length = 120;
        isOgre = true;
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



    }

    public void wrap(){
        xpos = xpos + dx;
        ypos = ypos + dy;


        if (xpos>=1000 || xpos<=0){
            xpos = 0;
        }

        if (ypos<=700 || ypos<=0){
            ypos=0;
        }

    }
}
