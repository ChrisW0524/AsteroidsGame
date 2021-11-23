import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HomeButton extends Button
{
    /**
     * Act - do whatever the play wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean isClicked = false;
    public HomeButton(String mouseNotOver, String mouseOver, int scale){
        super(mouseNotOver, mouseOver, scale);

    }
    @Override
    void action(){
        isClicked = true;
    }
    public boolean getIsClicked(){
        return this.isClicked;
    }
}
