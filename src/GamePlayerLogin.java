
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sankhe
 */
public class GamePlayerLogin extends javax.swing.JPanel {
	StudentModel model;
	static Student currentPlayer;
	/**
	 * Creates new form gamePlayerLogin
	 */
	public GamePlayerLogin() {
		initComponents();
		Color c = new Color(183, 238, 242);
		setBackground(c);
		Border compound, raisedbevel, loweredbevel;
		raisedbevel = BorderFactory.createRaisedBevelBorder();
		loweredbevel = BorderFactory.createLoweredBevelBorder();
		Border redline = BorderFactory.createLineBorder(Color.red, 5);
		//This creates a nice frame.
		compound = BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);
		setBorder(compound);
		//Add a red outline to the frame.
		compound = BorderFactory.createCompoundBorder(
				redline, compound);
		setBorder(compound);
		model = MainFrame.getStudentModel();
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

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		firstNameTextField = new javax.swing.JTextField();
		lastNameTextField = new javax.swing.JTextField();
		nextButton = new javax.swing.JButton();
		backButton = new javax.swing.JButton();

		setLayout(new java.awt.GridBagLayout());

		jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		jLabel1.setText("First Name");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridheight = 2;
		gridBagConstraints.ipadx = 24;
		gridBagConstraints.ipady = 17;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(70, 40, 0, 0);
		add(jLabel1, gridBagConstraints);

		jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		jLabel2.setText("Last Name");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.ipadx = 25;
		gridBagConstraints.ipady = 18;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(11, 40, 0, 0);
		add(jLabel2, gridBagConstraints);

		firstNameTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		firstNameTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
		firstNameTextField.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				firstNameTextFieldActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 3;
		gridBagConstraints.ipadx = 128;
		gridBagConstraints.ipady = 18;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(70, 38, 0, 0);
		add(firstNameTextField, gridBagConstraints);

		lastNameTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		lastNameTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridwidth = 3;
		gridBagConstraints.gridheight = 2;
		gridBagConstraints.ipadx = 128;
		gridBagConstraints.ipady = 18;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(18, 38, 0, 0);
		add(lastNameTextField, gridBagConstraints);

		nextButton.setBackground(new java.awt.Color(0, 153, 0));
		nextButton.setText("NEXT");
		nextButton.setToolTipText("click me to go to next page");
		nextButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				nextButtonActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.ipadx = 126;
		gridBagConstraints.ipady = 23;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(18, 78, 0, 0);
		add(nextButton, gridBagConstraints);

		backButton.setBackground(new java.awt.Color(255, 0, 0));
		backButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		backButton.setText("Back");
		backButton.setToolTipText("click me to go back");
		backButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				backButtonActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.gridwidth = 4;
		gridBagConstraints.ipadx = 48;
		gridBagConstraints.ipady = 22;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(29, 24, 0, 10);
		add(backButton, gridBagConstraints);
	}// </editor-fold>                        

	private void firstNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                   
		// TODO add your handling code here:
	}                                                  

	private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
		// TODO add your handling code here:
		MainFrame.layCard.show(MainFrame.getTopPanel(), "2");
	}                                          

	private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
		// TODO add your handling code here:
		String str1 = firstNameTextField.getText();
		String str2 = lastNameTextField.getText();
		boolean flag = true;
		if(str1.equals(""))
		{
			JOptionPane.showMessageDialog(this, "Please enter first name.",
					"Error Message", JOptionPane.ERROR_MESSAGE);
			flag = false;
		}
		if(str2.equals(""))
		{
			JOptionPane.showMessageDialog(this, "Please enter last name.",
					"Error Message", JOptionPane.ERROR_MESSAGE);
			flag = false;
		}
		if(flag == true) { 
			int loginResult = 0;
			currentPlayer = model.loginPlayer(str1, str2);
			if(currentPlayer != null)
				loginResult = 1;
			if(loginResult > 0) {
				resetAll();
				MainFrame.layCard.show(MainFrame.getTopPanel(), "6");
			} else {
				String str = "Student Entry for" + "\"" + str1 + " " + str2+ "\"" + " is does not exist, can not login.";
				JOptionPane.showMessageDialog(this, str, "Error Message", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}                                          
	
	public void resetAll() {
		firstNameTextField.setText("");
		lastNameTextField.setText("");
	}

	// Variables declaration - do not modify                     
	private javax.swing.JButton backButton;
	private javax.swing.JTextField firstNameTextField;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JTextField lastNameTextField;
	private javax.swing.JButton nextButton;
	// End of variables declaration                   
}
