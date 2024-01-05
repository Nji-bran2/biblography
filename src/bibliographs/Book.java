/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bibliographs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Brandon
 */
public class Book extends javax.swing.JFrame {

    /**
     * Creates new form Book
     */
    public Book() {
        
         initComponents();
         Connect();
        table_upload();
    }
     Connection con;
     PreparedStatement pst;
     ResultSet rs; 
     
     public void Connect(){
           
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//load drivers
             con = DriverManager.getConnection("jdbc:mysql://localhost/bgms","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conference_paper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conference_paper.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
      public void table_upload(){
         // load table
         
         int c;
        try {
            pst = con.prepareStatement("select * from book");
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            DefaultTableModel d = (DefaultTableModel)tableBook.getModel();
            d.setRowCount(0);
            
            while(rs.next()){
                Vector v2 = new Vector();
                for(int i =1;i<=c;i++){
                  v2.add(rs.getString("Id"));
                  v2.add(rs.getString("Authors"));
                  v2.add(rs.getString("Year"));
                  v2.add(rs.getString("Title"));
                  v2.add(rs.getString("Volume"));
                  v2.add(rs.getString("Publisher"));
                }
                d.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conference_paper.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtauthors = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtyear = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txttitle = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtvolume = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtpublisher = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBook = new javax.swing.JTable();
        txtsearch = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Books");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("New Book"));
        jPanel2.setOpaque(false);

        jLabel2.setText("Authors");

        txtauthors.setText(" ");

        jLabel3.setText("Year");

        txtyear.setText(" ");

        jLabel4.setText("Title");

        txttitle.setText(" ");

        jLabel5.setText("Volume");

        txtvolume.setText(" ");

        jLabel6.setText("Publisher");

        txtpublisher.setText(" ");

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Cancel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Home");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtauthors)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtyear)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txttitle)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtvolume)
            .addComponent(txtpublisher)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(32, 32, 32)
                                .addComponent(jButton2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jButton5)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtauthors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtvolume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtpublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        tableBook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Authors", "Year", "Title", "Volume", "Publisher"
            }
        ));
        tableBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableBookMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableBook);

        txtsearch.setText(" ");

        jButton6.setText("search");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Main  mn=new Main();
        mn.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         String Authors = txtauthors.getText();
        String Year = txtyear.getText();
        String Title = txttitle.getText();
        String Volume = txtvolume.getText();
        String Publisher = txtpublisher.getText();
        
         try {
            pst = con.prepareStatement("insert into book(Authors,Year,Title, Volume ,Publisher) values(?,?,?,?,?,?,?)");
            pst.setString(1, Authors);
            pst.setString(2, Year);
            pst.setString(3, Title);
            pst.setString(5, Volume );
            pst.setString(5, Publisher );
             String referenceAPA = Authors + " (" + Year + "). " + Title + ". " + Volume + ", " + Publisher + ".";
        System.out.println("<p>" + referenceAPA+ "</p>");
        
        String referenceIEEE = Authors+ ", "+ Year+", \""+ Title+ "\",  "+Volume+" "+ Publisher; 
        System.out.println("<p>" + referenceIEEE+ "</p>");

        // display the generated reference in HTML format
        JEditorPane output = new JEditorPane();
        output.setContentType("text/html");
        output.setEditable(false);
               output.setEditable(false);
        output.setText("<html><body>" + "<p>" + referenceAPA + "</p>" + "<p>" + referenceIEEE + "</p>" + "</body></html>");
        
            
             int k = pst.executeUpdate();
             if(k==1){
              JOptionPane.showMessageDialog(null,"book added");
              txtauthors.setText("");
              txtyear.setText("");
              txttitle.setText("");
              txtvolume.setText("");
              txtpublisher.setText("");
              txtauthors.requestFocus();
              table_upload();
           }
             else{
                JOptionPane.showMessageDialog(null,"error");
             }
        } catch (SQLException ex) {
            Logger.getLogger(Conference_paper.class.getName()).log(Level.SEVERE, null, ex);
        }

                                         

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         DefaultTableModel d1 = (DefaultTableModel)tableBook.getModel();
        int selectIndex = tableBook.getSelectedRow();
         int id =  Integer.parseInt(d1.getValueAt(selectIndex,   0).toString());
        
        
         String Authors = txtauthors.getText();
       String Year = txtyear.getText();
        String Title = txttitle.getText();
        String Volume = txtvolume.getText();
        String Publisher= txtpublisher.getText();
        
        try {
            pst = con.prepareStatement("update book set Authors=?, Year = ?, Title = ?,Volume =?, Publisher=? where id = ?");
            pst.setString(1, Authors);
            pst.setString(2, Year);
            pst.setString(3, Title);
            pst.setString(4, Volume);
            pst.setString(5, Publisher);
            pst.setInt(6, id);
             int k = pst.executeUpdate();
             if(k==1){
              JOptionPane.showMessageDialog(null,"book Updated");
              txtauthors.setText("");
              txtyear.setText("");
              txttitle.setText("");
              txtvolume.setText("");
              txtpublisher.setText("");
              txtauthors.requestFocus();
              table_upload();
              jButton1.setEnabled(true);
           }
             else{
                JOptionPane.showMessageDialog(null,"error");
             }
        } catch (SQLException ex) {
            Logger.getLogger(Conference_paper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         DefaultTableModel d1 = (DefaultTableModel)tableBook.getModel();
        int selectIndex = tableBook.getSelectedRow();
         int id =  Integer.parseInt(d1.getValueAt(selectIndex,   0).toString());
        
        
        try {
            pst = con.prepareStatement("delete from conference_paper where id = ?");
            pst.setInt(1, id);
             int k = pst.executeUpdate();
             if(k==1){
              JOptionPane.showMessageDialog(null,"book Deleted");
              txtauthors.setText("");
              txtyear.setText("");
              txttitle.setText("");
              txtvolume.setText("");
              txtpublisher.setText("");
              txtauthors.requestFocus();
              table_upload();
              jButton1.setEnabled(true);
           }
             else{
                JOptionPane.showMessageDialog(null,"error");
             }
        } catch (SQLException ex) {
            Logger.getLogger(Conference_paper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
         DefaultTableModel d1 = (DefaultTableModel)tableBook.getModel();
    int selectIndex = tableBook.getSelectedRow();
    
    // Check if a row is selected
    if (selectIndex >= 0) {
        // Get the ID of the selected row
        int id =  Integer.parseInt(d1.getValueAt(selectIndex,   0).toString());
        
        try{
            // Prepare the SQL statement to select rows with matching authors
            String sql = "select * from conference_paper where authors = ?";
            pst = con.prepareStatement(sql);
            
            // Set the parameter for the authors column to the text in txtsearch
            pst.setString(1, txtsearch.getText());
            
            // Execute the query and get the result set
            ResultSet rs = pst.executeQuery();
            
            // If there is a matching row, update the text fields with its values
            if (rs.next()){
                txtauthors.setText(rs.getString("Authors"));
                txtyear.setText(rs.getString("Year"));  
                txttitle.setText(rs.getString("Title"));
                txtvolume.setText(rs.getString("Volume"));
                txtpublisher.setText(rs.getString("Publisher"));
            }
        } catch(Exception e){
           
        }
    }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void tableBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableBookMouseClicked
        // TODO add your handling code here:
         DefaultTableModel d1 = (DefaultTableModel)tableBook.getModel();
        int selectIndex = tableBook.getSelectedRow();
        
        int id =  Integer.parseInt(d1.getValueAt(selectIndex,   0).toString());
          txtauthors.setText(d1.getValueAt(selectIndex, 1).toString());
           txtyear.setText(d1.getValueAt(selectIndex, 2).toString());
            txttitle.setText(d1.getValueAt(selectIndex, 3).toString());
             txtvolume.setText(d1.getValueAt(selectIndex, 4).toString());
              txtpublisher.setText(d1.getValueAt(selectIndex, 5).toString());
           
              jButton1.setEnabled(false);

    }//GEN-LAST:event_tableBookMouseClicked

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
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Book().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableBook;
    private javax.swing.JTextField txtauthors;
    private javax.swing.JTextField txtpublisher;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JTextField txttitle;
    private javax.swing.JTextField txtvolume;
    private javax.swing.JTextField txtyear;
    // End of variables declaration//GEN-END:variables
}
