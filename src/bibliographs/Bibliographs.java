/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bibliographs;

/**
 *
 * @author Brandon
 */
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
 import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Bibliographs {

    public static void main(String[] args) {
          
    try {        // Load the driver for MySQL
    Class.forName("com.mysql.cj.jdbc.Driver");

      // create a connection to the database
      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bgms", "root", "");

      // create a statement object
      Statement stmt = conn.createStatement();

      // generate the HTML reference for APA style for conference paper
      ResultSet rs1 = stmt.executeQuery("SELECT * FROM conference_paper");
      while (rs1.next()) {
        String author = rs1.getString("Authors");
        String year = rs1.getString("Year");
        String title = rs1.getString("Title");
        String conference= rs1.getString("Conference");
       
        String pages = rs1.getString("Pages");

        // generate APA reference
        String referenceAPA = author + " (" + year + "). " + title + ". " + conference + ", " + pages + ".";
        System.out.println("<p>" + referenceAPA+ "</p>");
        
        String referenceIEEE = author+ ", "+ year+", \""+ title+ "\",  "+conference+" "+ pages; 
        System.out.println("<p>" + referenceIEEE+ "</p>");

        // display the generated reference in HTML format
        JEditorPane output = new JEditorPane();
        output.setContentType("text/html");
        output.setEditable(false);
               output.setEditable(false);
        output.setText("<html><body>" + "<p>" + referenceAPA + "</p>" + "<p>" + referenceIEEE + "</p>" + "</body></html>");
        
        // write the contents of the JEditorPane to a file
        File file = new File("reference.html");
        file.createNewFile();
        
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file));
        
        writer.write(output.getText());
        
        writer.close();
        
        // open the file in the default browser
        Desktop.getDesktop().browse(file.toURI());
      }  
      
      // generate the HTML reference for APA style for journal article
      ResultSet rs2 = stmt.executeQuery("SELECT * FROM journal_article");
      while (rs2.next()) {
        String author = rs2.getString("Authors");
        String year = rs2.getString("Year");
        String title = rs2.getString("Title");
        String journal = rs2.getString("Journal");
        String volume = rs2.getString("Volume");
        String issue = rs2.getString("Issue");
        String pages = rs2.getString("Pages");

        // generate APA reference
        String referenceAPA = author + " (" + year + "). " + title + ". " + journal + ", " + volume + ", " + issue + ", " + pages + ".";
        System.out.println("<p>" + referenceAPA+ "</p>");
        String referenceIEEE = author + ", \"" + title + "\", " + journal + ", vol. " + volume + ", no. " +issue + ",   pp. " + pages + ", " + year;
        System.out.println("<p>" + referenceIEEE + "</p>");
        }                                                                         
      ResultSet rs3 = stmt.executeQuery("SELECT * FROM book  ");
      while (rs3.next()) {
        String author = rs3.getString("Authors");
        String year = rs3.getString("Year");
        String title = rs3.getString("Title");
        String volume = rs3.getString("Volume");
        String publisher = rs3.getString("Publisher");

        String referenceAPA = author + " (" + year + "). " + title + ". In " + volume + ", " + publisher;
        System.out.println("<p>" + referenceAPA+ "</p>");

        String referenceIEEE = author+ ", "+ year+", \""+ title+ "\", in <i>"+volume+ "</i>, "+ publisher  ;
        System.out.println("<p>" + referenceIEEE+ "</p>");
      //  
           // display the generated references in HTML format
     JEditorPane output = new JEditorPane();
     output.setContentType("text/html");
     output.setEditable(false);
     output.setText("<html><body>"+"<h3>APA Style References</h3>"+referenceAPA+"<h3>IEEE Style References</h3>"+referenceIEEE+"</body></html>");

     // write the contents of the JEditorPane to a file
     File file=new File("reference.html");
     file.createNewFile();

     OutputStreamWriter writer=new OutputStreamWriter(new FileOutputStream(file));

     writer.write(output.getText());

     writer.close();

     // open the file in the default browser
     Desktop.getDesktop().browse(file.toURI());
      
    }
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(Bibliographs.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
      Logger.getLogger(Bibliographs.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(Bibliographs.class.getName()).log(Level.SEVERE, null, ex);
    }
   Main mn = new Main();
    mn.show();
  }
}
