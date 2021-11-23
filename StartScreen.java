import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class StartScreej here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends WorldMenu
{

    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    private boolean isStarting = false;
    private boolean isInitiated = false;
    private boolean finishedTransition = false;
    private Title title = new Title();
    private PlaceHolder placeHolder;
    private int initCounter = 25;
    private PlayButton play = new PlayButton("Buttons/play_1.png", "Buttons/play_2.png", 50);
    
    /**
     * Initialize start screen with title and play button
     * <p>
     * The meteorites spawned in the background is purely for visuals
     * </p>
     */
    public StartScreen()
    {    
        super(800, 800, 1);
        spawnMeteorites(50);
        transparency = 255;
        title.getImage().setTransparency(0);
        play.setButtonTransparency(0);
        placeHolder = new PlaceHolder();
        addObject(placeHolder,getWidth()/2, getHeight()/2);
        addObject(title, 400, 150);
        addObject(play, 400, 500);
        setPaintOrder(Title.class, Text.class, Button.class);
    }
    
    /**
     * Handles transparency animations and UI elements
     */
    public void act(){
        //Remove placeholder after some time
        //Placeholders are used to fix the 'freezing' issue when switching between greenfoot worlds
        if(initCounter == 0){
            if(!isInitiated){
                removeObject(placeHolder);
                isInitiated = true;
            }
        }
        else{
            initCounter--;
        }
        
        //Update transparency
        overlay.setTransparency(transparency);
        
        //Change to new world if play button is clicked 
        //Below if statement block handles changing worlds and transition between worlds animation
        if(isStarting || play.getIsClicked()){
            isStarting = true;
            if(title.getImage().getTransparency()-10>0){
                title.getImage().setTransparency(title.getImage().getTransparency()-10);
                play.setButtonTransparency(play.getImage().getTransparency()-10);
            }
            if(transparency<=255){
                transparency+=5;
            }
            if(transparency >= 255){
                Greenfoot.setWorld(new GameWorld());
            }
            
        }
        
        //Set transparency of background 
        if(!finishedTransition){
            if(transparency-5 >= 125){
                transparency-=5;
            }
            else if(title.getImage().getTransparency()+10 <= 255){
                title.getImage().setTransparency(title.getImage().getTransparency()+10);
                play.setButtonTransparency(play.getImage().getTransparency()+10);
            }
            else{
                finishedTransition = true;
            }
        }
    }

}
