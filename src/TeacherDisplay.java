
import java.awt.Color;
import javax.swing.BorderFactory;
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
public class TeacherDisplay extends javax.swing.JPanel {

    /**
     * Creates new form TeacherDisplay
     */
    public TeacherDisplay() {
        initComponents();
        setBackground(Color.PINK);
        Border compound, raisedbevel, loweredbevel;
        raisedbevel = BorderFactory.createRaisedBevelBorder();
        loweredbevel = BorderFactory.createLoweredBevelBorder();
        Border redline = BorderFactory.createLineBorder(Color.blue, 5);
        //This creates a nice frame.
        compound = BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);
        setBorder(compound);
        //Add a red outline to the frame.
        compound = BorderFactory.createCompoundBorder(
                          redline, compound);
        setBorder(compound);
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

        playGameButton = new javax.swing.JButton();
        addStudentButton = new javax.swing.JButton();
        deleteStudentButton = new javax.swing.JButton();
        viewSummaryButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        playGameButton.setBackground(new java.awt.Color(0, 153, 0));
        playGameButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        playGameButton.setText("Play Game");
        playGameButton.setToolTipText("click me to play game");
        playGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playGameButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 95;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 98, 0, 0);
        add(playGameButton, gridBagConstraints);

        addStudentButton.setBackground(new java.awt.Color(0, 153, 0));
        addStudentButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addStudentButton.setText("Add Student Entry");
        addStudentButton.setToolTipText("click me to add new student entry");
        addStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 33;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(33, 98, 0, 0);
        add(addStudentButton, gridBagConstraints);

        deleteStudentButton.setBackground(new java.awt.Color(0, 153, 0));
        deleteStudentButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        deleteStudentButton.setText("Delete Student Entry");
        deleteStudentButton.setToolTipText("click me to delete student entry");
        deleteStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteStudentButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 98, 0, 0);
        add(deleteStudentButton, gridBagConstraints);

        viewSummaryButton.setBackground(new java.awt.Color(0, 153, 0));
        viewSummaryButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        viewSummaryButton.setText("View Class Summary");
        viewSummaryButton.setToolTipText("click me to view class summary");
        viewSummaryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewSummaryButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(29, 98, 13, 0);
        add(viewSummaryButton, gridBagConstraints);

        logoutButton.setBackground(new java.awt.Color(255, 0, 0));
        logoutButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        logoutButton.setText("Logout");
        logoutButton.setToolTipText("click me to logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 18, 0, 3);
        add(logoutButton, gridBagConstraints);
    }// </editor-fold>        
    
    private void addStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
        MainFrame.layCard.show(MainFrame.getTopPanel(), "3");
    }                                                

    private void deleteStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        // TODO add your handling code here:
         MainFrame.layCard.show(MainFrame.getTopPanel(), "4");
         DeleteStudentEntry.getObjectDeleteEntry().setFocusable(true);
         DeleteStudentEntry.getObjectDeleteEntry().requestFocusInWindow();
    }                                                   

    private void playGameButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
         MainFrame.layCard.show(MainFrame.getTopPanel(), "5");
    }                                              

    private void viewSummaryButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
        MainFrame.layCard.show(MainFrame.getTopPanel(), "9");
    }                                                 

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
         MainFrame.layCard.show(MainFrame.getTopPanel(), "1");
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton addStudentButton;
    private javax.swing.JButton deleteStudentButton;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton playGameButton;
    private javax.swing.JButton viewSummaryButton;
    // End of variables declaration                   
}
