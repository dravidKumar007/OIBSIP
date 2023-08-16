import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class First extends JFrame  {
    JButton b1=new JButton("Sign up");
    JButton b2=new JButton("Login");
    First(){
        b1.setBounds(100, 300, 300, 100);
        b2.setBounds(100, 500, 300, 100);
        add(b1);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Sign();
                dispose();
            }
        });
        add(b2);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Login();
                dispose();
            }
        });
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(1000, 1000);
    }

   
}
