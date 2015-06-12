
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sankhe
 */
public class View extends javax.swing.JPanel {

	private ActionListener listener; // reference to controller
	

	/*
	 *  Please change the path to the folder where Cupacke image is stored.
	 *       
	 */
	
	//private String pathToTeddyImage = "C:/Users/sankhe/Desktop/JAVA/CD_contents/Contents/JavaBook/image/";
	  File file=new File(".");
	  private String path = file.getAbsolutePath().replace(".", "").trim() + "audioAndimages/";
	  private String pathToTeddyImage = path.replace("\\", "/");
	
	/*
	 * 				  ^  ^  ^  ^  ^  ^  ^  ^  ^
	 *                |  |  |  |  |  |  |  |  | 
	 */
	

	/**
	 * Creates new form View
	 */
	public View() {
		initComponents();
		Border compound, raisedbevel, loweredbevel;
		raisedbevel = BorderFactory.createRaisedBevelBorder();
		loweredbevel = BorderFactory.createLoweredBevelBorder();
		Border redline = BorderFactory.createLineBorder(Color.blue, 2);
		//This creates a nice frame.
		compound = BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);
		setBorder(compound);
		//Add a red outline to the frame.
		compound = BorderFactory.createCompoundBorder(
				redline, compound);
		setBorder(compound);
	}

	public void callInitComponents() {
		initComponents();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D myGraphics = (Graphics2D) g;
		// controller updates display
		if(listener != null)
			((Controller) listener).update(myGraphics);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		nextButton = new javax.swing.JButton();
		endButton = new javax.swing.JButton();

		setLayout(new java.awt.GridBagLayout());

		jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(255, 51, 0));
		jLabel1.setText("Can you give Teddy 5 cakes?");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 3;
		gridBagConstraints.ipadx = 15;
		gridBagConstraints.ipady = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(4, 156, 0, 0);
		add(jLabel1, gridBagConstraints);

		String str = pathToTeddyImage+"teady.png";
		try {
		ImageIcon pic = new ImageIcon(str);
		jLabel2.setIcon(pic); // NOI18N
		} catch(Exception e) {
			System.out.println("An error has occurred while reading image file. Check that file exists and is in the correct directory.");
		    System.exit(1);
		}

		setBackground(Color.WHITE);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.ipady = 17;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(31, 10, 0, 0);
		add(jLabel2, gridBagConstraints);

		nextButton.setBackground(new java.awt.Color(255, 0, 0));
		nextButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		nextButton.setText("NEXT");
		nextButton.setToolTipText("click me to go for next question");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridheight = 2;
		gridBagConstraints.ipadx = 45;
		gridBagConstraints.ipady = 15;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(315, 50, 11, 0);
		add(nextButton, gridBagConstraints);

		endButton.setBackground(new java.awt.Color(255, 0, 0));
		endButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		endButton.setText("QUIT");
		endButton.setToolTipText("click me to quit the game");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridwidth = 4;
		gridBagConstraints.gridheight = 2;
		gridBagConstraints.ipadx = 51;
		gridBagConstraints.ipady = 15;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(315, 50, 11, 22);
		add(endButton, gridBagConstraints);
		setPreferredSize(new Dimension(800, 480));
	}// </editor-fold>                        


	public javax.swing.JFrame getWindow() {
		JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, this);
		return f;
	}

	/**
	 * @return the jLabel1
	 */
	public javax.swing.JLabel getjLabel1() {
		return jLabel1;
	}
	/**
	 * @return the jPanel1
	 */
	public javax.swing.JPanel getjPanel1() {
		return this;
	}

	// add a action listener to the view
	public void addActionListener(ActionListener listener) {
		this.listener = listener;
		this.setFocusable(true);
		this.requestFocusInWindow();
	}

	public  void  addStartListener(ActionListener listner) {
		nextButton.addActionListener(listner);
	}

	public  void  addStopListener(ActionListener listner) {
		endButton.addActionListener(listner);
	}

	public void addKeyboardListener(KeyListener listener) {
		//System.out.println (" Listener Called:" );
		getjPanel1().addKeyListener(listener);
	}
	
	public JOptionPane getJOptionPane() {
		return optionPane;
	}

	private JOptionPane optionPane;
	// Variables declaration - do not modify                     
	private javax.swing.JButton endButton;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JButton nextButton;
	// End of variables declaration                   
}