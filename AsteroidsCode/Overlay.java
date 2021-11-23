import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Overlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Overlay extends Actor
{
    /**
     * Act - do whatever the Overlay wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage image = new GreenfootImage(800, 800);
    private int transparency;

    public Overlay(){
        this.transparency = 0;
    }
    public Overlay(int transparency){
        this.transparency = transparency;
    }
    public void act()
    {
        image.setColor(new Color(0, 0, 0));
        image.fill();
        image.setTransparency(transparency);
        setImage(image);
        
    }
    
    public void setTransparency(int transparency){
        this.transparency = transparency;
    }
}
