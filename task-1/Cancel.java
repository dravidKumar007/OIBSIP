import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Cancel extends JFrame {
    String msg="";
    int f=0;
    JLabel l=new JLabel(msg);
    Cancel(){
        JLabel txt=new JLabel("Enter PNR number:");
        JTextField pnr=new JTextField();
        JButton b= new JButton("Submit");
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)  {
                try{
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ors", "root", "admin@123");
                    Statement st=con.createStatement();
                    ResultSet r= st.executeQuery("select * from reg where pnr="+pnr.getText()+";");
                    if(!r.isBeforeFirst()){msg="INVALID PNR NUMBER!";l.setText(msg);}
                    else{
                        r.next();
                        msg="<html><font size=\"+1\">id: " + r.getString(2) + "<br>"
                        + "date of register: " + r.getString(3) + "<br>"
                        + "from: " + r.getString(4) + "<br>"
                        + "To: " + r.getString(5) + "<br>"
                        + "Train Name: " + r.getString(6) + "<br>"
                        + "Train Number: " + r.getInt(7) + "</font></html>";
                        l.setText(msg);
                        f++;
                    }
                }catch(Exception ex){
                    System.out.println(ex);
                }}});
                JButton button=new JButton("OK");
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)  {
              try{
                   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ors", "root", "admin@123");
                Statement st=con.createStatement();
                int r= st.executeUpdate("delete from reg where pnr="+pnr.getText()+";");
              }catch(Exception ex){System.out.println(ex);}}});
            txt.setBounds(100, 100, 200, 20);
            pnr.setBounds(320,100,100, 20);
            b.setBounds(100,210,100, 20);
            l.setBounds(100,200 ,700, 300);
            button.setBounds(100, 550, 70, 40);
            add(button);
         add(txt);
         add(pnr);
         add(b);
         add(l);
         add(new JLabel(""));
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setVisible(true);
         setSize(1000, 1000);
         setLayout(null);
         
        }
}
