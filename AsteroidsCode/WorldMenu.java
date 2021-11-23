import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class WorldMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldMenu extends World
{

    /**
     * Ovelay for world objects used for transition animations
     */
    protected Overlay overlay = new Overlay();
    /**
     * Transparency value of the overlay variable
     */
    protected int transparency = 255;
    
    /**
     * Constructor for objects of class WorldMenu.
     * @param x width of world
     * @param y height of world
     * @param i pixel resolution of world
     */
    public WorldMenu(int x, int y, int i)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(x, y, i); 
        addObject(overlay,getWidth()/2, getHeight()/2);
        setPaintOrder(Overlay.class);
        
    }
    
    /**
     * Spawn meteorites in the world
     * @param difficulty the total number of small meteorites spawned
     * <p>
     * Method spawns a random  combination of different sizes of meteorites in the world based on the total number of small meteorites in the parameter</br>
     * Large meteorite = 8 small meteorites</br>
     * Big meteorite = 4 small meteorites</br>
     * Medium meteorite = 2 small meteorites </br>
     * Small meteorite = 1 small meteorites
     * </p>
     */
    protected void spawnMeteorites(int difficulty){
        int[] numMeteorites = {8,4,2,1};
        int index;
        int meteorite;
        ArrayList<Integer> meteorites = new ArrayList<Integer>();
        while(difficulty !=0){
            index = getRandomNumber(0,3);
            meteorite = numMeteorites[index];
            if(difficulty-meteorite >=0){
                difficulty -= meteorite;
                meteorites.add(index+1);
            }
        }
        for (int i = 0; i < meteorites.size(); i++) {
            addObject(new Meteorite(meteorites.get(i), true), 0, 0);
        }
    }
    /**
     * Returns a random number based on the range
     * Spawn meteorites in the world
     * @param minimum the minimum range of random numbers
     * @param maximum the maximum range of random numbers
     * 
     * <p>
     * Method returns a random interger in the minimum and maximum range</br>
     * 
     * </p>
     */
    protected int getRandomNumber(int minimum,int maximum)
    {
        return minimum + Greenfoot.getRandomNumber( maximum - minimum + 1 );
    }
}
