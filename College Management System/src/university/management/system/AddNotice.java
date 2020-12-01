package university.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.*;

public class AddNotice implements ActionListener {

    JTextField t;
    JComboBox choice;
    JLabel l, l1, l2;
    JButton b;
    JFrame f;
    JTextArea ta;

    public AddNotice() {
        f = new JFrame("Add Notice");
        f.setBackground(Color.white);
        f.setBounds(0, 0, 1000, 1000);
        f.setLayout(null);

        l = new JLabel("Enter Notice Here");
        l.setBounds(20, 20, 130, 30);
        f.add(l);

        l1 = new JLabel("Title");
        l1.setBounds(20, 70, 70, 30);
        f.add(l1);

        t = new JTextField();
        t.setBounds(120, 70, 150, 30);
        f.add(t);

        l2 = new JLabel("Department");
        l2.setBounds(300, 70, 70, 30);
        f.add(l2);

        String x[] = {"Computer Science", "ENTC", "IT"};
        choice = new JComboBox(x);
        choice.setBounds(400, 70, 130, 30);
        f.add(choice);
        ta = new JTextArea();
        ta.setBounds(20, 120, 900, 450);

        ta.setCaretPosition(0);
        ta.requestFocusInWindow();
        f.add(ta);

        b = new JButton("Add");
        b.setBounds(450, 600, 100, 50);
        f.add(b);

        b.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b) {
            conn c = new conn();
            String title = t.getText();
            String notice = ta.getText();
            Date date = new Date();
            
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            
            LocalDateTime now = LocalDateTime.now();
           
            Date dt = new Date();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            String currentTime = sdf.format(dt);
            String dep = (String)choice.getSelectedItem();
            int dept_id;
            if(dep=="Computer Science")
                dept_id = 1;
            else if(dep=="IT")
                dept_id = 2;
            else
                dept_id = 3;
            try {
                c.s.executeUpdate("insert into notice values('" + currentTime + "','" + title + "','" + notice + "',"+dept_id+")");
                JOptionPane.showMessageDialog(null, "Notice Added Successfully");
                f.setVisible(false);
                //new Project().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(AddNotice.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public static void main(String[] arg) {
        new AddNotice().f.setVisible(true);
    }
}
