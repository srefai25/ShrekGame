//Basic Game Application
//Version 2
// Basic Object, Image, Movement
// Astronaut moves to the right.
// Threaded

//K. Chun 8/2018

//*******************************************************************************
//Import Section
//Add Java libraries needed for the game
//import java.awt.Canvas;

//Graphics Libraries
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.*;
import javax.swing.*;


//*******************************************************************************
// Class Definition Section

public class BasicGameApp implements Runnable {

    //Variable Definition Section
    //Declare the variables used in the program
    //You can set their initial values too

    //Sets the width and height of the program window
    final int WIDTH = 1000;
    final int HEIGHT = 700;

    //Declare the variables needed for the graphics
    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;

    public BufferStrategy bufferStrategy;
    public Image shrekPic;//doesnt matter whether public or private
    public Image fionaPic;
    public Image humanfionaPic;
    public Image humanshrekPic;
    public Image donkeyPic;
    public Image catPic;
    public Image backgroundPic;

    //Declare the objects used in the program
    //These are things that are made up of more than one variable type
    public Shrek shrek;
    public Shrek fiona;
    public Shrek humanfiona;
    public Shrek humanshrek;
    public Shrek donkey;
    public Shrek cat;

    // Main method definition
    // This is the code that runs first and automatically
    public static void main(String[] args) {
        BasicGameApp ex = new BasicGameApp();   //creates a new instance of the game
        new Thread(ex).start();                 //creates a threads & starts up the code in the run( ) method
    }


    // This section is the setup portion of the program
    // Initialize your variables and construct your program objects here.
    public BasicGameApp() { // BasicGameApp constructor

        setUpGraphics();

        //variable and objects
        //create (construct) the objects needed for the game and load up
        shrekPic = Toolkit.getDefaultToolkit().getImage("shrek.png"); //load the picture
        shrek = new Shrek("Shrek",800,100, 200, 270); //construct the astronaut

        fionaPic = Toolkit.getDefaultToolkit().getImage("fiona.png");
        fiona = new Shrek("Fiona", 800, 500, 275, 270);

        humanfionaPic = Toolkit.getDefaultToolkit().getImage("humanfiona.png");
        humanfiona = new Shrek("HumanFiona", 800, 300, 100, 280);

        humanshrekPic = Toolkit.getDefaultToolkit().getImage("humanshrek.png");
        humanshrek = new Shrek("HumanShrek", 800, 350, 300, 400);

        donkeyPic = Toolkit.getDefaultToolkit().getImage("donkey.png");
        donkey = new Shrek("Donkey", 200,800, 250, 200);

        catPic = Toolkit.getDefaultToolkit().getImage("donkeycat.png");
        cat = new Shrek ("Puss & Boots", 300, 500, 250, 200);

        backgroundPic = Toolkit.getDefaultToolkit().getImage("shrekforest.jpeg");
    }

    public void run() {//helps place all reactions in order

        //for the moment we will loop things forever.
        while (true) {
            moveThings();  //move all the game objects
            FionaShrekCrash();
            DonkeyFionaCrash();
            DonkeyShrekCrash();
            render();  // paint the graphics
            pause(20); // sleep for 10 ms

        }
    }

    public void moveThings() {
        //calls the move( ) code in the objects
        //fiona.isOgre = !fiona.isOgre;
        shrek.bounce();
        fiona.wrap();
        donkey.wrap();
        shrek.sizeMinus();
    }

    public void FionaShrekCrash(){
        //when the two characters crash, then they will bounce off one another
        if (shrek.rec.intersects(fiona.rec) && shrek.isCrashing == false) {
            int x = (int) (Math.random() * 40 + 10);
            if (x >= 20 && x <= 40) {
                System.out.println("CRASH");
                shrek.isCrashing = true;
                fiona.isOgre = !fiona.isOgre;//fiona could possibly become an ogre and vice versa
            }
            else {
                System.out.println("CRASH2");
                shrek.isCrashing = true;
                shrek.isOgre = !shrek.isOgre;//shrek could become an ogre and vice versa
            }
        }
        if(!shrek.rec.intersects(fiona.rec)){//reset shrek.isCrashing to false if no longer intersecting
            shrek.isCrashing = false;
        }
    }

    public void DonkeyFionaCrash(){
        //when two objects crash into one another
        if (donkey.rec.intersects(fiona.rec) && donkey.isCrashingWithFiona == false) {
            int x = (int) (Math.random() * 40 + 10);
            if (x >= 20 && x <= 40) {
                System.out.println("CRASH");
                donkey.isCrashingWithFiona = true;
                donkey.withCat = !donkey.withCat;//donkey could have a cat on its back and vice versa
            }
            else {
                System.out.println("CRASH2");
                donkey.isCrashingWithFiona = true;
                fiona.isOgre = !fiona.isOgre;//fiona could become an ogre and vice versa
            }
        }
        if(!donkey.rec.intersects(fiona.rec)){//reset shrek.isCrashing to false if no longer intersecting
            donkey.isCrashingWithFiona = false;
        }
    }

    public void DonkeyShrekCrash(){//when donkey and shrek crashing, two reactions could possibly happen
        if (donkey.rec.intersects(shrek.rec) && donkey.isCrashingWithShrek == false) {
            int x = (int) (Math.random() * 40 + 10);
            if (x >= 20 && x <= 40) {
                System.out.println("CRASH");
                donkey.isCrashingWithShrek = true;
                donkey.withCat = !donkey.withCat;//donkey could have a cat on its back and vice versa
            }
            else {
                System.out.println("CRASH2");
                donkey.isCrashingWithShrek = true;
                shrek.isOgre = !shrek.isOgre;//shrek could become ogre and vice versa
            }
        }
        if(!donkey.rec.intersects(shrek.rec)){//reset shrek.isCrashing to false if no longer intersecting
            donkey.isCrashingWithShrek = false;
        }
    }

        //Pauses or sleeps the computer for the amount specified in milliseconds
        public void pause(int time ) {
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
            }
        }

        //Graphics setup method
        private void setUpGraphics() {
            frame = new JFrame("Application Template");   //Create the program window or frame.  Names it.

            panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
            panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
            panel.setLayout(null);   //set the layout

            // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
            // and trap input events (Mouse and Keyboard events)
            canvas = new Canvas();
            canvas.setBounds(0, 0, WIDTH, HEIGHT);
            canvas.setIgnoreRepaint(true);

            panel.add(canvas);  // adds the canvas to the panel.

            // frame operations
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
            frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
            frame.setResizable(false);   //makes it so the frame cannot be resized
            frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!

            // sets up things so the screen displays images nicely.
            canvas.createBufferStrategy(2);
            bufferStrategy = canvas.getBufferStrategy();
            canvas.requestFocus();
            System.out.println("DONE graphic setup");
        }

        //Paints things on the screen using bufferStrategy
        private void render() {
            Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
            g.clearRect(0, 0, WIDTH, HEIGHT);//clears characters after each movement (so if not there, there would be a lot of astronauts)

            //draw the image of the astronaut

            g.drawImage(backgroundPic, 0,0, WIDTH, HEIGHT, null);

            if (donkey.withCat == true){
                g.drawImage(donkeyPic, donkey.xpos, donkey.ypos, donkey.width, donkey.height, null);
            }
            else{
                g.drawImage(catPic, donkey.xpos, donkey.ypos, cat.width, cat.height, null);
            }

            if (fiona.isOgre == true) {
                g.drawImage(fionaPic, fiona.xpos, fiona.ypos, fiona.width, fiona.height, null);
            }
            else {
                g.drawImage(humanfionaPic, fiona.xpos, fiona.ypos, humanfiona.width, humanfiona.height, null);
            }

            if (shrek.isOgre == true){
                g.drawImage(shrekPic, shrek.xpos, shrek.ypos, shrek.width, shrek.height, null);
            }

            else {
                g.drawImage(humanshrekPic, shrek.xpos, shrek.ypos, humanshrek.width, humanshrek.height, null);
            }


            g.dispose();//done with the image
            bufferStrategy.show();//show everything we have drawn
        }
    }