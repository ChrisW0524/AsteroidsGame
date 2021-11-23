import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;


/**
 * World where gameplay takes place
 */
public class GameWorld extends WorldMenu
{

    //game variables
    private final int initialDifficulty = 5;
    /**
     * The current difficulty of the game (number of meteorites spawned)
     */
    public static int difficulty;
    /**
     * The number of meteorites left on the screen
     */
    public static int numMeteorites;
    private Rocket player;

    //init variables
    private int initCounter = 15;
    private Text numMeteoritesText;
    private Text startText;
    private Text waveText;
    //public static Text powerupText= new Text(powerupString, new Font(36), 700, 700);
    private Countdown countdown = new Countdown();
    private PlaceHolder placeHolder;
    private boolean isInitiated = false;
    private boolean canStart = false;
    public static boolean isStarted = false;
    private boolean canRemoveTransparent = false;
    
    private int powerupCounter = 0;
    private int powerupInterval = getRandomNumber(750, 1250);
    /**
     * The bar which provides info about the current power up state
     */
    public static Bar bar = new Bar("Player 1", "Health Points", 0, Rocket.powerupLength);
    
    private PauseButton pause = new PauseButton("Buttons/pause_1.jpg", "Buttons/pause_2.jpg", 50);
    
    
    /**
     * <p>
     * Initializes GameWorld with text, UI, indicators, and player</br>
     * Handles transparency transition and UI
     * </p>
     */
    public GameWorld()
    {    
        super(800, 800, 1); 
        placeHolder = new PlaceHolder();
        addObject(placeHolder,getWidth()/2, getHeight()/2);
        player = new Rocket();
        addObject(player,getWidth()/2, getHeight()/2);
        difficulty = initialDifficulty;
        initBar();
                
        numMeteorites = difficulty;
        numMeteoritesText = new Text("Meteorites remaining: " + numMeteorites, new Font(24), 10, 25);
        startText = new Text("Press space to start", new Font(36), 250, 300);
        startText.getImage().setTransparency(0);
        addObject(startText, getWidth()/2, getHeight()/2);
        
        pause.scale = 60;
        pause.resizeImages();
        
        setPaintOrder(PlaceHolder.class, Countdown.class, Button.class, Text.class, Overlay.class, Rocket.class, Particle.class, Bar.class);
        
        resetWorld();
        
    }
    
    /**
     * <p>
     * Handles the transparency and UI logic</br>
     * Spawns more meteorites when all meteorites are destroyed </br>
     * Updates difficulty and wave counter </br>
     * Manages UI elements
     * </p>
     */
    public void act(){
        
        //remove placeholder after a small time 
        //This is done to remove the 'freezing' issue when you create the world to create a smoother transition
        if(initCounter == 0){
            initCounter--;
            if(!isInitiated){
                removeObject(placeHolder);
                isInitiated = true;
            }
            canStart = true;
        }
        else{
            initCounter--;
        }
        
        //When the placeholder is removed increase the transparency of the start text and overlay
        if(getObjects(PlaceHolder.class).size() == 0){
            if(startText.getImage().getTransparency()+5<=255){
                startText.getImage().setTransparency(startText.getImage().getTransparency()+5);
            }
            if(transparency-3>125){
                transparency-=3;
            }
        }
        
        //Lets the player start the game when the placeholder is removed
        if(canStart && Greenfoot.isKeyDown("space")){
            canStart = false;
            addObject(countdown, getWidth()/2, 200);
            removeObject(startText);
        }
        
        //continously update the transparency of the overlay
        overlay.setTransparency(transparency);
        
        //if the game has started spawn meteorites and add UI elements
        if(isStarted){
            spawnMeteorites(difficulty);
            player.canMove = true;
            addObject(numMeteoritesText, getWidth()/2, getHeight()/2);
            isStarted = false;
            canRemoveTransparent = true;
            waveTransition();
            addObject(pause, getWidth()-pause.getImage().getWidth()+15, pause.getImage().getHeight()-15);
            addObject(bar, (getWidth()/2)+10, getHeight()-50);
        }
        
        //if there are no meteorites after the game has started start a new wave 
        if(getObjects(Meteorite.class).size()==0 && canRemoveTransparent){
            difficulty+=5;
            spawnMeteorites(difficulty);
            numMeteorites = difficulty;
            waveTransition();
        }
        
        //update transparency
        if(canRemoveTransparent && transparency-5>0){
            transparency-=5;
        }
        
        //Update the numer of meteorites text
        numMeteoritesText.setText("Meteorites remaining: " + numMeteorites);
        
        //Powerup spawning
        if(canRemoveTransparent){
            if(getObjects(Powerup.class).size()==0){
                if(powerupCounter <= powerupInterval){
                    powerupCounter++;
                }
                else{
                    addObject(new Powerup(),0,0);
                    powerupCounter = 0;
                    powerupInterval = getRandomNumber(500, 1000);
                }
            }
            if(Greenfoot.mouseClicked(pause)){
                Greenfoot.setWorld(new PauseScreen(this));
            }
        }
    }
    private void waveTransition(){
        int wave = difficulty/5;
        WaveText waveText = new WaveText("Wave " +wave, new Font(48), 350, 600, 50);
        addObject(waveText, getWidth()/2, getHeight()/2);
    }
    private void resetWorld(){
        bar.setValue(0);        
        difficulty = initialDifficulty;
        numMeteorites = difficulty;
    }
    
    private void initBar(){
        bar.setTextColor(Color.WHITE);
        bar.setSafeColor(Color.WHITE);
        bar.setDangerColor(Color.WHITE);
        bar.setBarWidth(200);
        bar.setBarHeight(25);
        bar.setReferenceText("");
        bar.setShowTextualUnits(false);
    }
    
}
