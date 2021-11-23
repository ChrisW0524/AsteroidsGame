import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Base class for particles
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Particle extends Entity
{
    /**
     * Image of the particle
     */
    protected GreenfootImage image;
    
    /**
     * Shrinks the particle by a percentage of its size
     * @param percentage The percentage of the size of the scaled particle in relation to its original size.
     */
    public void shrink(int percentage){
        if(getImage().getWidth() < 5){
            getWorld().removeObject(this);
        }
        else{
            GreenfootImage img = new GreenfootImage(image);
            img.scale(getImage().getWidth() *percentage/100, getImage().getHeight()*percentage/100);         
            setImage(img);
        }
    }
}
