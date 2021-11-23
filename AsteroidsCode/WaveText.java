import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Text used to display current wave of the Game
 */
public class WaveText extends Text
{
    /**
     * Act - do whatever the waveText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int transparency = 0;
    private int counter;
    private GreenfootImage image;
    /**
     * Initializes a waveText with a font, (x,y) coordinates, and time
     * @param text The string of the text object
     * @param font The font of the text
     * @param x X coordinate of bottom left corner of the text
     * @param y Y coordinate of bottom left corner of the text
     * @param counter How long the text will stay in the world in game ticks
     */
    public WaveText(String text, Font font, int x, int y, int counter){
        super(text, font, x, y);
        this.counter = counter;
        this.image = getImage();
        image.setTransparency(this.transparency);
    }
    /**
     * Handles the transparency of the text object
     * <p>
     * If the image is not fully opaque, the transparency will increase</br>
     * If the image is fully opaque, The counter will decrease</br>
     * If the counter is expired, decrease transparency </br>
     * If the transparency and counter is less than 0, remove text from world
     */
    public void act()
    {
        if(transparency+5 <=255 && counter >= 1){
            transparency+=5;
        }
        if(transparency >=255 && counter >=1){
            counter--;
        }
        if(counter<=0 && transparency-5>=0){
            transparency-=5;
        }
        if(transparency == 0 && counter <= 0){
            getWorld().removeObject(this);
        }
        image.setTransparency(transparency);
        setImage(image);
    }
}
