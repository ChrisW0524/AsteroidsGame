import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Powerup class
 */
public class Powerup extends Entity
{

    private final int scale = 10;
    private int speed;
    private int rotation;
    private int spin;
    
    /**
     * Initializes powerup with a random speed, direction and spin
     */
    public Powerup(){
        this.speed = getRandomNumber(2, 4);
        this.rotation = getRandomNumber(0, 359);
        if(getRandomNumber(0, 1) == 0){
            this.spin = -1;
        }
        else{
            this.spin = 1;   
        }
        
        GreenfootImage img = getImage();  
        img.scale(img.getWidth()*scale/100, (int)img.getHeight()*scale/100);       
        setImage(img);
    }
    
    /**
     * Spawns the powerup on the world edge when added to world
     */
    public void addedToWorld(World w){
        World world = getWorld();
            int num = getRandomNumber(0,1);
            switch(num){
                case 0:
                    setLocation(getRandomNumber(1, world.getWidth()-1), 1);
                    break;
                case 1:
                    setLocation(world.getWidth()-2, getRandomNumber(1, world.getHeight()-1));
                    break;
            }
    }
    
    /**
     * Move and rotate the powerup
     */
    public void act()
    {
        // Add your action code here.
        moveDirection(rotation, speed);
        rotate(this.spin);
        edgeMovement();
    }
}
