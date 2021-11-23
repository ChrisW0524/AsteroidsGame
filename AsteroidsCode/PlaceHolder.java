import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlaceHolder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlaceHolder extends Actor
{
    /**
     * Act - do whatever the PlaceHolder wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public PlaceHolder(){
        GreenfootImage img = getImage();  
        img.scale(img.getWidth()*5, img.getWidth()*5);       
        setImage(img);
    }
    public void act()
    {
        // Add your action code here.
    }
}
