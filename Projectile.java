import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Projeciles shot by the player
 */
public class Projectile extends Entity
{

    
    private boolean notInitialized = true;
    private final int projectileSpeed = 20;
    private int timer = 0;
    private final int duration = 50;
    
    private int offset;
    
    /**
     * Initializes projectile with no offset
     */
    public Projectile(){
        this.offset = 0;
    }
    /**
     * Initializes projectile with a given angle offset
     * @param offset The offset of the angle's direction in degrees
     */
    public Projectile(int offset){
        this.offset = offset;
    }
    
    /**
     * <p>
     * Set direction to be relative to the player whilst including offset</br>
     * Destroys meteorites if projectile collides with a meteorite object</br>
     * Remove the projecile from the world if the timer expires or projecilte hits the edge</br>
     * Move the projectile
     */
    public void act()
    {
        // Add your action code here.
        //set direction to be the same as player
        if(notInitialized){
            setRotation(getWorld().getObjects(Rocket.class).get(0).getRotation() + this.offset);
            notInitialized = false;
        }
        
        
        
        Meteorite meteorite = (Meteorite)(getOneObjectAtOffset(0, 0, Meteorite.class));
        if(meteorite != null) {
            //getWorld().addObject(new Meteorite(getRandomNumber(1,4)), Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(800));
            meteorite.spawnNewMeteorite();
            getWorld().removeObject(this);
            return;
        }
        
        if(timer >= duration || atEdge()){
            getWorld().removeObject(this);
        }
        
        timer++;
        move(projectileSpeed);
        
        
    }
}
