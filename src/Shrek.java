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
        dy = 0;
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

             for(int x=0;x<1000;x=x+1){
                if(xpos==900){
                dx=-dx;
                 }
             }

    }

    public void wrap(){
        xpos = xpos + dx;
        ypos = ypos + dy;


            for(int x=0;x<1000;x=x+1){
                if (xpos==1000){
                    xpos = 0;
                }
            }

    }
}
