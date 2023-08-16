import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Login  extends JFrame  {
    Login(){ 
        JButton b=new JButton("Login");
        JLabel mess=new JLabel("");
        JLabel name = new JLabel("Enter Login Id:");
       JLabel pass=new JLabel("Enter Password");
    JTextField nameFeild=new JTextField();
    JTextField passFeild=new JTextField();
    
    name.setBounds(100, 200, 100, 20);
    pass.setBounds(100,300,100, 20);
    nameFeild.setBounds(200,200,100, 20);
    passFeild.setBounds(200,300,100, 20);
    setLayout(null);
     b.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e)  {
          try{
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ors", "root", "admin@123");
                Statement st=con.createStatement();
                ResultSet r= st.executeQuery("select * from login;");
                int flag=0,f=0;
                String s="";
               while( r.next()){
                if(r.getString(1).equals(nameFeild.getText())){
                 flag++; 
                    if(r.getString(2).equals(passFeild.getText())){
                 f++;
                }

                }

            }
            if(flag==0){ mess.setText("wrong id");}
        else if(f==0){
            mess.setText("wrong password"); 
           }else{
            new Page(nameFeild.getText());
            dispose();
           }
            }catch(Exception ex){System.out.println(ex);}
        }
    });
    mess.setBounds(700, 700, 100, 100);
    b.setBounds(500,500,100,30);
    add(mess);
    add(nameFeild);
    add(passFeild);
    add(name);
    add(pass);
    add(b);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    setSize(1000, 1000);
    }

   
}
