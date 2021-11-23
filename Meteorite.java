import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;


/**
 * Write a description of class Meteorite here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Meteorite extends Entity
{

    private GreenfootImage image;
    private int speed;
    private int rotation;
    private int spin;
    private int size;
    private boolean spawnEdge;
    private boolean isInitialized;
    
    /**
     * Constructor for objects of class Meteorite.
     * @param size size of the meteorite
     * @param spawnEdge boolean of whether the meteorite is spawned at the worldEdge
     * <p>
     * Constructor initializes class variables and the image of the meteorite class based on its size
     * </p>
     */
    public Meteorite(int size, boolean spawnEdge){
        this.speed = getRandomNumber(2, 4);
        this.rotation = getRandomNumber(0, 359);
        this.spin = getRandomNumber(-5, 5);
        this.size = size;
        this.isInitialized = false;
        this.spawnEdge = spawnEdge;
        
        image = new GreenfootImage("meteorites/meteorite_" + size +".png");
        setImage(image);
        resize(250);
    }
    
    /**
     * <p>Spawns the meteorite on the world edge if spawnEdge is true</br>
     * Moves and rotates the meteorite in the world</p>
     */
    public void act()
    {
        
        if(!isInitialized){
            if(spawnEdge){
            //int num = getRandomNumber(0,4);
            World world = getWorld();
            int num = getRandomNumber(0,1);
            switch(num){
                case 0:
                    setLocation(getRandomNumber(1, world.getWidth()), 1);
                    break;
                case 1:
                    setLocation(world.getWidth()-2, getRandomNumber(1, world.getHeight()));
                    break;
            }
            isInitialized= true;
        }
        }
        moveDirection(rotation, speed);
        rotate(this.spin);
        edgeMovement();
    }

    /**
     * Resizes the image of the meteorite based on scale out of 100
     * @param scale scale of the image in a 100 point scale
     */
    private void resize(int scale){
        GreenfootImage img = getImage();  
        img.scale(img.getWidth()*scale/100, img.getHeight()*scale/100);       
        image = img;
        this.setImage(img);
    }
    
    /**
     * Spawns 2 smaller meteorites in place of the meteorite object
     * <p>
     * If the meteorite is not the smallest size meteorite, the method will spawn 2 smaller meteorites</br>
     * Update the number of meteorites (static variable) in GameWorld</p>
     */
    
    public void spawnNewMeteorite(){
        World world = getWorld();
        if(size < 4){
            for(int i =0; i<2; i++){
                world.addObject(new Meteorite(size+1, false), getX(), getY());
            }
        }
        else{
            GameWorld.numMeteorites--;
        }
        for(int i =0; i<10; i++){
            world.addObject(new Debris(), getX(), getY());
        }
        getWorld().removeObject(this);
    }

}
