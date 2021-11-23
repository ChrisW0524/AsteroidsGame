import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Countdown animation when starting the game
 */
public class Countdown extends Actor
{
    /**
     * Act - do whatever the Countdown wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private boolean animationEnded = false;
    
    private final int initialCounter = 125;
    private int counter = initialCounter;
    
    private GreenfootImage threeImage = new GreenfootImage("3.png");
    private GreenfootImage twoImage = new GreenfootImage("2.png");
    private GreenfootImage oneImage = new GreenfootImage("1.png");
    /**
     * Initializes the image of the countdown object
     */
    public Countdown(){
        setImage(threeImage);
    }
    
    /**
     * <p>Sets the image of the countdown based on the object's counter</br>
     * Updates counter for every gametick of the world </br>
     * Removes object if countdown is completed</p>
     */
    public void act()
    {
        counter--;
        if(counter == initialCounter*2/3){
            setImage(twoImage);
        }
        if(counter == initialCounter/3){
            setImage(oneImage);
        }
        if(counter <= 0){
            animationEnded = true;
            GameWorld.isStarted = true;
        }
        if(animationEnded){
            getWorld().removeObject(this);
        }
    }
    
    /**
     * Returns true if the countdown has ended
     */
    public boolean getAnimationEnded(){
        return this.animationEnded;
    }
}
