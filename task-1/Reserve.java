import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Reserve extends JFrame {
   int tr_no;String tr;
   int flag = 0;
   Reserve(String name){
    JLabel cla = new JLabel("Enter class:");
    JButton button = new JButton("OK");
    JLabel doj=new JLabel("enter date of journey(yyyy/mm/dd):");
    JLabel fro = new JLabel("Enter From location:");
    JLabel too = new JLabel("Enter To location:");
    JLabel train_no=new JLabel("Train number:");
    JLabel train_name = new JLabel("Train name:");
    String[] options = {"class 1", "class 2", "class 3", "class 4"};
     JComboBox clas= new JComboBox(options);
    JTextField date=new JTextField();
    String[] option1 = {"Chennai", "Mumbai", "Delhi", "Andra Pradesh"};
    String[] option2 = {"Chennai", "Mumbai", "Delhi", "Andra Pradesh"};
 JComboBox from= new JComboBox(option1);
  JComboBox to= new JComboBox(option2);
  JButton b=new JButton("insert");
 cla.setBounds(100, 100, 200, 50);
 doj.setBounds(100, 160, 200, 50);
 fro.setBounds(100, 230, 200, 50);
 too.setBounds(100, 300,  200,70);
 clas.setBounds(320, 100, 200, 30);
 date.setBounds(320, 160, 200, 30);
 from.setBounds(320, 230, 200, 30);
 to.setBounds(320, 300, 200, 30);
 b.setBounds(200, 370, 100, 50);
 b.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e)  {
      if(date.getText().equals("")){}else{
      Random random = new Random();
      int randomNumber = random.nextInt(9999-1111+1)+1111;
      String[] trainNames = {"Rajdhani Express","Shatabdi Express","Duronto Express","Gatimaan Express","Garib Rath Express","Jan Shatabdi Express","Vande Bharat Express","Humsafar Express","Tejas Express","Sampark Kranti Express"};
      train_no.setText("Train number:"+randomNumber);
      tr_no=randomNumber;
      train_name.setText("Train name:"+trainNames[randomNumber%10]);
      tr=trainNames[randomNumber%10];
      flag++;
      ;}
   }});
   train_name.setBounds(100, 440, 700, 50);
   train_no.setBounds(100, 510, 500, 50);
   button.setBounds(200, 690, 100, 50);
   button.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e)  {
      if(flag>0){
         try{
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ors", "root", "admin@123");
                Statement st=con.createStatement();
                int rows=st.executeUpdate("INSERT INTO reg (id,dat,fro,too,train_name,train_no) values('"+name+"','"+date.getText()+"','"+from.getSelectedItem().toString()+"','"+to.getSelectedItem().toString()+"','"+tr+"',"+tr_no+");");
                 ResultSet r= st.executeQuery("select * from reg where id='"+name+"'and dat='"+date.getText()+"'and fro='"+from.getSelectedItem().toString()+"'and too='"+to.getSelectedItem().toString()+"'and train_name='"+tr+"'and train_no="+tr_no+";");
                 int pnr=0;
                 while (r.next()){pnr=r.getInt(1);}
                 String msssg="Your Ticket has booked successfully \n your PNR number is "+pnr+"";
               JOptionPane.showMessageDialog(null, msssg, "Congratulations", JOptionPane.CLOSED_OPTION);
               dispose();
         }catch(Exception exe){System.out.println(exe);}
      }
   }

});
   add(button);
 add(cla);
 add(doj);
 add(fro);
 add(too);
 add(clas);
 add(date);
 add(from);
 add(to);
  add(b);  
  add(train_name);
  add(train_no);
 setLayout(null);
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 setVisible(true);
 setSize(1000, 1000);

    
 }   
}
