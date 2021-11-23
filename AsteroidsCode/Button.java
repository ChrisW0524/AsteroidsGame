import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Base class of all buttons
 */
public class Button extends Actor
{
    private GreenfootImage mouseNotOver;
    private GreenfootImage mouseOver;
    
    /**
     * scale of the button image in a percentage
     */
    protected int scale;
    
    /**
     * Constructor for objects of class Button.
     * @param mouseNotOver path to image of button when mouse is not hovering over
     * @param mouseOver path to image of button when mouse is hovering over
     * @param scale scale of the original sprites
     */
    
    public Button(String mouseNotOver, String mouseOver, int scale){
        this.mouseNotOver = new GreenfootImage(mouseNotOver);
        this.mouseOver = new GreenfootImage(mouseOver);
        this.scale = scale;
        resizeImages();
        setImage(this.mouseNotOver);
    }
    
    /**
     * <p>Set the image to mouseOver if mouse is hovering over button</br>
     * Set the image to mouseNotOver if mouse is not hovering over button</p>
     */
    public void act()
    {
        if(isMouseOver()){
            setImage(this.mouseOver);            
        }
        else{
            setImage(this.mouseNotOver);
        }
        if(Greenfoot.mouseClicked(this)){
            action();
        }
    }
    /**
     * Returns true if mouse is hovering over button object
     */
    protected boolean isMouseOver(){
        if(Greenfoot.getMouseInfo() == null){
            return false;
        }
        int Mx = Greenfoot.getMouseInfo().getX();
        int My = Greenfoot.getMouseInfo().getY();
        int x = getX();
        int y = getY();
        int width = getImage().getWidth()/2;
        int height = getImage().getHeight()/2;
        return (Mx >= x-width && Mx <= x+width && 
                My >= y-height && My <= y+height);
    }
    /**
     * Action of button if button is clicked
     */
    void action(){
        return;
    }
    /**
     * Resize image based on scale 
     */
    public void resizeImages(){
        mouseOver.scale(mouseOver.getWidth()*this.scale/100, mouseOver.getHeight()*this.scale/100);   
        mouseNotOver.scale(mouseNotOver.getWidth()*this.scale/100, mouseNotOver.getHeight()*this.scale/100);  
    }
    
    /**
     * Set transparency of the button object
     */
    public void setButtonTransparency(int transparency){
        this.mouseNotOver.setTransparency(transparency);
        this.mouseOver.setTransparency(transparency);
    }

}
