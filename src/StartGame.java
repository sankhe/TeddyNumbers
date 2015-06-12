
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import sun.audio.AudioPlayer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sankhe
 */
public class StartGame extends javax.swing.JPanel {
	/**
	 * Creates new form StartGame
	 */
	private static StartGame game;
	private static int i = 1;
	
	public StartGame() {
		initComponents();
		Color c = new Color(243, 247, 110);
		setBackground(c);
		Border compound, raisedbevel, loweredbevel;
		raisedbevel = BorderFactory.createRaisedBevelBorder();
		loweredbevel = BorderFactory.createLoweredBevelBorder();
		Border redline = BorderFactory.createLineBorder(Color.red, 10);
		//This creates a nice frame.
		compound = BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);
		setBorder(compound);
		//Add a red outline to the frame.
		compound = BorderFactory.createCompoundBorder(
				redline, compound);
		setBorder(compound);
		game = this;
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();

		addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				formKeyPressed(evt);
			}
		});
		setLayout(new java.awt.GridBagLayout());

		jButton1.setBackground(new java.awt.Color(0, 51, 204));
		jButton1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
		jButton1.setText("START");
		jButton1.setToolTipText("click me to start the game");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.ipadx = 176;
		gridBagConstraints.ipady = 98;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(41, 68, 0, 0);
		add(jButton1, gridBagConstraints);

		jButton2.setBackground(new java.awt.Color(255, 0, 0));
		jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		jButton2.setText("Back");
		jButton2.setToolTipText("click me to go back");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.ipadx = 47;
		gridBagConstraints.ipady = 19;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(47, 318, 11, 22);
		add(jButton2, gridBagConstraints);

	}// </editor-fold>                        

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
		// TODO add your handling code here:
		MainFrame.layCard.show(MainFrame.getTopPanel(), "6");
	}                                        

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
		// TODO add your handling code here:
		doEnterKeyPressed();
	}                                        

	
	
	public void doEnterKeyPressed() {
		MainFrame.layCard.show(MainFrame.getTopPanel(), "8");
		AudioPlayer.player.stop();
		if(i==1) {
			Cupcake.startCupcake();
			i = i + 1;
		} else {
			Cupcake.start();
			MainFrame.getView().getjPanel1().setFocusable(true);
			MainFrame.getView().getjPanel1().requestFocusInWindow();
		}
			
	}

	private void formKeyPressed(java.awt.event.KeyEvent e) {                                
		// TODO add your handling code here:
		if(e.getKeyCode() == 10 ) {
			doEnterKeyPressed();
		}
	}                               

	public static StartGame getObjectofClass() {
		return game;
	}
	
	// Variables declaration - do not modify                     
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	// End of variables declaration                   
}