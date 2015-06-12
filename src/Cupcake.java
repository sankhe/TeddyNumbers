import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/**
 *
 * @author sankhe
 */
public class Cupcake extends Cake{
	protected float x , y; //cake's position
	protected static ArrayList<Cake> cakeList;
	
	
	/*
	 *  Please change the path to the folder where Cupacke image is stored.
	 *       
	 */
	
	//private String pathToCupcakeImage = "C:/Users/sankhe/Desktop/JAVA/CD_contents/Contents/JavaBook/image/";
		File file=new File(".");
	  private String path = file.getAbsolutePath().replace(".", "").trim() + "audioAndimages/";
	  private String pathToCupcakeImage = path.replace("\\", "/");
	
	/*
	 * 				  ^  ^  ^  ^  ^  ^  ^  ^  ^
	 *                |  |  |  |  |  |  |  |  | 
	 */
	
	
	/**
	 * @return the cakeList
	 */
	public static ArrayList<Cake> getCakeList() {
		return cakeList;
	}

	// constructor updates x and y to specific values
	public Cupcake() {	
		this(400,100);
	}

	// constructor updates x and y to values passed in as arguments
	public Cupcake(float xValue, float yValue) {	
		x = xValue;
		y = yValue;
	}	

	public static void start() {
		cakeList.clear();
		int step = 100;
		int nCol = 0;
		int yCord = 100;
		int xCord = 400;
		for(int i = 0; i < 12; i++) {
			
			cakeList.add(new Cupcake((int)(xCord + step * nCol), (int)(yCord)));
			nCol++;
			if(nCol == 4) {
				yCord = yCord + step;
				nCol = 0;
			}
		}
	}
	
	public static void startCupcake() {
		cakeList = new ArrayList<Cake>();

		int step = 100;
		int nCol = 0;
		int yCord = 100;
		int xCord = 400;
		for(int i = 0; i < 12; i++) {
			cakeList.add(new Cupcake((int)(xCord + step * nCol), (int)(yCord)));
			nCol++;
			if(nCol == 4) {
				yCord = yCord + step;
				nCol = 0;
			}
		}
		
		//System.out.println("Najuka ");
		View view = MainFrame.getView();
		Controller ct = new Controller(cakeList, view);
		
		view.addActionListener(ct);
		view.setVisible(true);
	}
	

	/* public static void main(String[] args) {
		cakeList = new ArrayList<Cake>();

		int step = 100;
		int nCol = 0;
		int yCord = 100;
		int xCord = 400;
		for(int i = 0; i < 12; i++) {
			cakeList.add(new Cupcake((int)(xCord + step * nCol), (int)(yCord)));
			nCol++;
			if(nCol == 4) {
				yCord = yCord + step;
				nCol = 0;
			}
		}
		
		//View v = new View(cupcake);
		View view = new View();
		Controller ct = new Controller(cakeList, view);
		view.addActionListener(ct);
		view.getWindow().setVisible(true);
	} */

	/* (non-Javadoc)
	 * @see com.programwithjava.animation.Cake#drawShape(java.awt.Graphics2D)
	 */
	@Override
	public void drawShape(Graphics2D myGraphics) {
		// TODO Auto-generated method stub
		Image image = null;
		try {
			String str =  pathToCupcakeImage+"cupcake.jpg";
			image = ImageIO.read(new File(str));
		} catch (IOException e) {
			System.out.println("An error has occurred while reading image file. Check that file exists and is in the correct directory.");
		    System.exit(1);
			//e.printStackTrace();
		}

		myGraphics.drawImage(image, (int)x,(int) y, null);
	}

	/* (non-Javadoc)
	 * @see com.programwithjava.animation.Cake#step()
	 */
	@Override
	protected void step() {
		// TODO Auto-generated method stub
		x = x - 10f;
	}
	
}
