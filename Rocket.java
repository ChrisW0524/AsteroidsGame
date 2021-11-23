import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Playeer
 */
public class Rocket extends Entity
{

    private double speed = 0;
    private final double maxSpeed = 10;
    private double acceleration = 0.1;
    
    private int projectileTimer = 100;
    private int projectileInterval = 30;
    
    public boolean canMove = false;

    private GreenfootImage rocket0 = new GreenfootImage("rocket_0.png");
    private GreenfootImage rocket1 = new GreenfootImage("rocket_1.png");
    
    private int state = 0;
    public static final int powerupLength = 600;
    //private int powerupTimer = powerupLength;
    private String powerupString = "";
    private String powerupText = "";
    
    /**
     * <p>
     * Manage keyboard inputs</br>
     * Implements Player movement (turns left and right, boost to increase speed and turning rate)</br>
     * Adds shooting function (press x to shoot bullets)</br>
     * Controls collision with meteorite</br>
     * Powerup logic (machine gun = increase firerate, scatter shot = fire multiple projectiles)</br>
     * Update powerup bar information
     */
    public void act()
    {
        //exits the act cycle if the rocket cant move
        if(!canMove){
            return;
        }

        //Movement and key input
        if(Greenfoot.isKeyDown("left")){
            turn((int)-speed*7/10-2);
        }

        if(Greenfoot.isKeyDown("right")){
            turn((int)speed*7/10+2);
        }
        //booster
        if(Greenfoot.isKeyDown("z")){
            setImage(rocket1);
            if(speed <= maxSpeed){
                speed += acceleration;
            }
            for(int i=0; i<2;i++){
                 getWorld().addObject(new Smoke(), getX(), getY());
            }
            
        }
        //handles speed if not boosting
        else{
            if(speed > 0){
                speed -= acceleration;
            }

            setImage(rocket0);
        }
        
        //rocket movement
        edgeMovement();
        move((int)speed);
        
        
        //Firing projectiles
        if(Greenfoot.isKeyDown("x") && projectileTimer >= projectileInterval){
            
            //powerups 
            switch(state){
                
                case 0:
                    getWorld().addObject(new Projectile(), getX(), getY());
                    break;
                case 1:
                    getWorld().addObject(new Projectile(), getX(), getY());
                    getWorld().addObject(new Projectile(-10), getX(), getY());
                    getWorld().addObject(new Projectile(10), getX(), getY());
                    getWorld().addObject(new Projectile(-20), getX(), getY());
                    getWorld().addObject(new Projectile(20), getX(), getY());
                case 2: 
                    getWorld().addObject(new Projectile(), getX(), getY());

            }
            projectileTimer = 0;
        }
        projectileTimer++;
        
        //collision with meteorite
        Actor meteorite = getOneObjectAtOffset(0, 0, Meteorite.class);
        if (meteorite != null){
            Greenfoot.setWorld(new EndingScreen());
        }
        
        //collision with powerup
        Actor powerup = getOneObjectAtOffset(0, 0, Powerup.class);
        if (powerup != null){
            GameWorld.bar.setValue(powerupLength);
            getWorld().removeObject(powerup);
            this.state = getRandomNumber(1,2);
            switch(this.state){
                case 1:
                    this.powerupText = "Scatter shot: ";
                    break;
                case 2:
                    this.projectileInterval = 6;
                    this.powerupText = "Machine gun: ";
                    break;
            }
        }
        
        //handles powerup bar info
        if(state>0){
            powerupString = powerupText;
            GameWorld.bar.setValue(GameWorld.bar.getValue()-1);
        }
        if(GameWorld.bar.getValue()<=0){
            resetRocket();
        }
        GameWorld.bar.setReferenceText(powerupString);
    }
    
    private void resetRocket(){
        state = 0;
        powerupString = "";
        GameWorld.bar.setValue(0);
        projectileInterval = 30;
    }
}
