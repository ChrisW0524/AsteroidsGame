import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Text class
 */
public class Text extends Actor
{
    private int x;
    private int y;
    private String text;
    private Font font;
    private GreenfootImage img;
    /**
     * Initializes Text with a font and (x,y) coordinates
     * @param text The string of the text object
     * @param font The font of the text
     * @param x X coordinate of bottom left corner of the text
     * @param y Y coordinate of bottom left corner of the text
     */
    public Text(String text, Font font, int x, int y){
        this.text = text;
        this.x = x;
        this.y = y;
        this.font = font;
        img = new GreenfootImage(800, 800); 
        img.setFont(this.font);
        img.setColor(new Color(255, 255, 255));
        img.drawString(this.text, this.x, this.y);       
        setImage(img);
    }
    /**
     * Sets the string of the text object
     */
    public void setText(String text){
        this.text = text;
        this.img.clear();
        img.drawString(this.text, this.x, this.y);       
        setImage(img);
        
    }
}
