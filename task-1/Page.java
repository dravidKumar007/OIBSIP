import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Page extends JFrame {

    public Page(String id) {
JButton b1=new JButton("Reserve a seat");
JButton b2=new JButton("cancel");
b1.setBounds(100, 300, 300, 100);
        b2.setBounds(100, 500, 300, 100);
        add(b1);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reserve(id);
                dispose();
            }
        });
        add(b2);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Cancel();
                dispose();
            }
        });
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(1000, 1000);

    }

}
