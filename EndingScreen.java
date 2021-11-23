import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ending screen when the game ends
 */
public class EndingScreen extends WorldMenu
{

    /*
     * Constructor for objects of class EndingScreen.
     * 
     */
    private PlayButton play = new PlayButton("Buttons/play_1.png", "Buttons/play_2.png", 50);
    private HomeButton home = new HomeButton("Buttons/home_1.png", "Buttons/home_2.png", 50);
    
    /**
     * Initializes ending screen with text and buttons
     */
    public EndingScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 800, 1); 
        
        int wave = GameWorld.difficulty/5;
       
        addObject(new Text("You lose!", new Font(48), 300, 150), getWidth()/2, getHeight()/2);
        addObject(new Text("You got to wave "+wave, new Font(48), 200, 250), getWidth()/2, getHeight()/2);
        addObject(home, getWidth()/2, (getHeight()/2)+200);
        addObject(play, getWidth()/2, (getHeight()/2)+50);
        setPaintOrder(Button.class, Text.class);
        
        
    }
    
    /**
     * Manages button logic
     */
    public void act(){
        if(home.getIsClicked()){
            Greenfoot.setWorld(new StartScreen());
        }
        if(play.getIsClicked()){
            Greenfoot.setWorld(new GameWorld());
        }
    }
}
