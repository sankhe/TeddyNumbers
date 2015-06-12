
import java.awt.CardLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sankhe
 */
public class MainFrame extends javax.swing.JFrame {
	public static CardLayout layCard;
	private static JPanel topPanel;
	private AdminLogin loginPanel;
	private TeacherDisplay dispPanel;
	private AddStudentEntry studentEntryPanel;
	private DeleteStudentEntry studentDeletePanel;
	private GamePlayerLogin gamePlayerPanel;
	private LevelSelection levelPanel;
	private StartGame startGamePanel;
	private static View viewPanel;
	private ClassSummary classSummaryPanel;
	private static StudentModel studentModel; // database connection object



	/**
	 * Creates new form MainFrame
	 */
	public MainFrame() {
		initComponents();

		layCard = new CardLayout();
		topPanel = new JPanel();
		topPanel.setLayout(layCard);
		add(topPanel);
		
		studentModel = new StudentModel();

		loginPanel = new AdminLogin();
		topPanel.add(loginPanel, "1");

		dispPanel = new TeacherDisplay();
		topPanel.add(dispPanel, "2");

		studentEntryPanel = new AddStudentEntry();
		topPanel.add(studentEntryPanel, "3");

		studentDeletePanel = new DeleteStudentEntry();
		topPanel.add(studentDeletePanel, "4");

		gamePlayerPanel = new GamePlayerLogin();
		topPanel.add(gamePlayerPanel, "5");

		levelPanel = new LevelSelection();
		topPanel.add(levelPanel, "6");

		startGamePanel = new StartGame();
		topPanel.add(startGamePanel, "7");

		viewPanel = new View();
		topPanel.add(viewPanel, "8");

		classSummaryPanel = new ClassSummary();
		topPanel.add(classSummaryPanel, "9");

		layCard.show(topPanel, "1");
		loginPanel.startFocusListeners();

		pack();  
	}

	public static View getView() {
		return viewPanel;
	}

	public static JPanel getTopPanel() {
		return topPanel;
	}

	
	public static StudentModel getStudentModel() {
		return studentModel;
	}
	
	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	private void initComponents() {

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(new java.awt.CardLayout());

		pack();
	}// </editor-fold>                        

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainFrame().setVisible(true);

			}
		});
	}

	// Variables declaration - do not modify                     
	// End of variables declaration                   
}
