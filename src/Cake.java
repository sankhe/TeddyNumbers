import java.awt.*;

/**
 *
 * @author sankhe
 */

public abstract class Cake {	
  protected float x = 30, y = 300; // cake's position
  
  // constructor updates x and y to specific values
  public Cake() {	
    this(0, 0);
  }

  // constructor updates x and y to values passed in as arguments
  public Cake(float xValue, float yValue) {	
    x = xValue;
    y = yValue;
  }	


/**
 * @return the x
 */
public float getX() {
	return x;
}

/**
 * @param x the x to set
 */
public void setX(float x) {
	this.x = x;
}

/**
 * @return the y
 */
public float getY() {
	return y;
}

/**
 * @param y the y to set
 */
public void setY(float y) {
	this.y = y;
}


	// method to draw shape of Vehicle
    public abstract void drawShape(Graphics2D myGraphics);	
  
  // change the (x, y) position by a small amount
	protected abstract void step();
	
}
