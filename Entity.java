import greenfoot.*;

/**
 * Base class for all entities
 */
public class Entity extends Actor
{
    /**
     * Returns a random number based on the range
     * @param minimum the minimum range of random numbers
     * @param maximum the maximum range of random numbers
     * 
     * <p>
     * Method returns a random interger in the minimum and maximum range</br>
     * 
     * </p>
     */
    public int getRandomNumber(int minimum,int maximum)
    {
        return minimum + Greenfoot.getRandomNumber( maximum - minimum + 1 );
    }
    
    /**
     * If entity is at the edge of the world, move entity to the opposite edge.
     */
    protected void edgeMovement(){
        if(getX() <= 0){
            setLocation(getWorld().getWidth(), getY());
        }
        else if(getX() >= getWorld().getWidth()-1){
            setLocation(0, getY());
        }
        else if(getY() <= 0){
            setLocation(getX(), getWorld().getHeight()-1);
        }
        else if(getY() >= getWorld().getHeight()-1){
            setLocation(getX(), 0);
        }
    }
    
    /**
     * Returns true if entity is at world edge
     */
    protected boolean atEdge(){
        if(getX() <= 0){
            return true;
        }
        else if(getX() >= getWorld().getWidth()-1){
            return true;
        }
        else if(getY() <= 0){
            return true;
        }
        else if(getY() >= getWorld().getHeight()-1){
            return true;
        }
        return false;
    }
    /**
     * Moves entity in a direction at a speed
     * @param degrees the direction of the velocity vector in degrees
     * @param speed the magnitude of the velocity vector
     */
    protected void moveDirection(int degrees, int speed){
        double x = (speed * Math.cos(Math.toRadians(-degrees)));
        double y = (speed * Math.sin(Math.toRadians(-degrees)));
        setLocation(getX()+(int)x, getY()+(int)y);
    }
    
    /**
     * Rotate entity by a set amount
     * @param rotation how much the entity is rotated in degrees
     */
    protected void rotate(int rotation){
        setRotation(getRotation()+rotation);
    }
}