import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class PauseScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PauseScreen extends WorldMenu
{

    /**
     * Constructor for objects of class PauseScreen.
     * 
     */
    private boolean isStarting = false;
    private HomeButton home = new HomeButton("Buttons/home_1.png", "Buttons/home_2.png", 50);
    private UnpauseButton pause = new UnpauseButton("Buttons/play_1.png", "Buttons/play_2.png", 50);
    /**
     * Gameworld loaded to the pause screen
     */
    public static GameWorld gameWorld;
    
    /**
     * Constructor for objects of class PauseScreen.
     * <p>
     * Initializes pause screen with UI elements and background transparency</p>
     */
    public PauseScreen(GameWorld gameWorld)
    {
        super(800, 800, 1);
        this.gameWorld = gameWorld;
        addObject(home, getWidth()/2, (getHeight()/2)+100);
        addObject(pause, getWidth()/2, (getHeight()/2)-100);
        setPaintOrder(Title.class, Text.class, Button.class);
        transparency = 125;
    }
    /**
     * <p>
     * Controls transparency animations</br>
     * Manages button functions</p>
     */
    public void act(){
        //Update transparency for every game tick
        overlay.setTransparency(transparency);
        
        //Set to start screen if home button is clicked
        //Transition animation when switching to start screen
        if(isStarting || home.getIsClicked()){
            isStarting = true;
            if(home.getImage().getTransparency()-10>0){
                home.getImage().setTransparency(home.getImage().getTransparency()-10);
                pause.getImage().setTransparency(pause.getImage().getTransparency()-10);
            }
            if(transparency<=255){
                transparency+=5;
            }
            if(transparency >= 255){
                Greenfoot.setWorld(new StartScreen());
            }
            
        }
        
        //Unpause the game if the pause button is clicked
        if(pause.getIsClicked()){
                Greenfoot.setWorld(this.gameWorld);
        }

    }
}
