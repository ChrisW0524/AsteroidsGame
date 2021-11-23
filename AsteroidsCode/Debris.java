import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Debris particles for the destruction of meteorites
 */
public class Debris extends Particle
{
    
    private int movementSpeed = getRandomNumber(2,5); 
    private int acceleration = -1;
    
    
    /**
     * Initializes particle image and sets a random direction
     */
    public Debris(){
        GreenfootImage img = getImage();  
        img.scale(img.getWidth()/3, img.getWidth()/3);       
        image = img;
        setImage(img);
        setRotation(getRandomNumber(0, 360));
        
    }
    
    /**
     * Move and shrink the particle 
     */
    public void act()
    {      
        move(movementSpeed);
        shrink(93);
        
    }
}
