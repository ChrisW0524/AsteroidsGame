import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Smoke particles for the player
 */
public class Smoke extends Particle
{
    private final int movementSpeed = 2;
    private boolean notInitiated = true;
    
    /**
     * Initializes and scale smoke image
     */
    public Smoke(){
        GreenfootImage img = getImage();  
        img.scale(img.getWidth()/6, img.getWidth()/6);       
        image = img;
        setImage(img);
        
    }
    
    /**
     * <p>
     * Set a random direction relative to the player's direction</br>
     * Move and shrink the particles
     */
    public void act()
    {
        // Add your action code here.
        if(notInitiated){
            setRotation(getWorld().getObjects(Rocket.class).get(0).getRotation() + 180 + getRandomNumber(-90, 90));
            notInitiated = false;
        }

        move(movementSpeed);
        shrink(99);
        
    }
}
