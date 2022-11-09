/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.poly.display;

import edu.poly.model.Member;
import edu.poly.helper.DataValidator;
import edu.poly.helper.MessageDialogHelper;
import javax.swing.JOptionPane;
import edu.poly.DAO.MemberDAO;
import edu.poly.helper.SharedData;
import java.awt.event.KeyEvent;
import javax.swing.JDialog;

/**
 *
 * @author ADMIN
 */
public class AccountFrame extends javax.swing.JFrame {
    private Main frame;
    Member member;
    /**
     * Creates new form AccountFrame
     */
    
 
    public AccountFrame(java.awt.Frame parent, boolean modal){
       initComponents();
    }

   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label4 = new java.awt.Label();
        jPasswordField2 = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        lbUser = new java.awt.Label();
        txtName = new java.awt.TextField();
        lbPass = new java.awt.Label();
        btLogin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();

        jPasswordField2.setText("jPasswordField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(183, 223, 243));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label1.setFont(new java.awt.Font("Franklin Gothic Demi", 1, 24)); // NOI18N
        label1.setForeground(new java.awt.Color(0, 153, 153));
        label1.setText("Viking Internet");
        jPanel2.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 204, 43));
        label1.getAccessibleContext().setAccessibleDescription("");

        lbUser.setCursor(new java.awt.Cursor(java.awt.Cursor.SE_RESIZE_CURSOR));
        lbUser.setFont(new java.awt.Font("Franklin Gothic Demi", 1, 18)); // NOI18N
        lbUser.setForeground(new java.awt.Color(0, 153, 153));
        lbUser.setText("UserName");
        jPanel2.add(lbUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 105, -1));

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        jPanel2.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 160, -1));

        lbPass.setFont(new java.awt.Font("Franklin Gothic Demi", 1, 18)); // NOI18N
        lbPass.setForeground(new java.awt.Color(0, 153, 153));
        lbPass.setText("Password");
        jPanel2.add(lbPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 105, -1));

        btLogin.setBackground(new java.awt.Color(204, 204, 204));
        btLogin.setForeground(new java.awt.Color(0, 153, 153));
        btLogin.setText("Log In");
        btLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoginActionPerformed(evt);
            }
        });
        jPanel2.add(btLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/user-info-icon.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/secrecy-icon.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 226, -1, -1));

        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });
        txtPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPassKeyPressed(evt);
            }
        });
        jPanel2.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 224, 160, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/hinh-nen-1.jpg"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLoginActionPerformed
         StringBuilder sb = new StringBuilder();
        DataValidator.validateEmpty(txtName, sb, "UserName cannot be empty");
        DataValidator.validateEmpty(txtPass, sb, "Password cannot be empty");
        if(sb.length()>0){
            MessageDialogHelper.showErrorDialog(this, sb.toString(), "error");
            return;
        }
        MemberDAO dao = new MemberDAO();
        Main main = new Main();
        try{
           
            member = dao.checkLogin(new String(txtName.getText()), new String(txtPass.getPassword()));
            if(member == null){
                JOptionPane.showMessageDialog(this, "User Name or Password is not correct");
            }else{
                SharedData.txtName = member;
                this.dispose();
                main.setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(this, e.getMessage(), "Error");
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btLoginActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            
        }
    }//GEN-LAST:event_txtPassKeyPressed

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassActionPerformed

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
            java.util.logging.Logger.getLogger(AccountFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccountFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccountFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccountFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AccountFrame account = new AccountFrame(new javax.swing.JFrame(), true);
                JDialog.setDefaultLookAndFeelDecorated(false);
                account.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                account.setVisible(true);
            }
        });
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField2;
    private java.awt.Label label1;
    private java.awt.Label label4;
    private java.awt.Label lbPass;
    private java.awt.Label lbUser;
    private java.awt.TextField txtName;
    private javax.swing.JPasswordField txtPass;
    // End of variables declaration//GEN-END:variables
}
