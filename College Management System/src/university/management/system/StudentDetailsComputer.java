package university.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentDetailsComputer extends JFrame implements ActionListener, ItemListener {

    JLabel l1, l2, l3;
    JTable t1;
    Choice c2;
    
    String a[][];
    public static boolean shown = false;
    JComboBox option, tenth, twelve, crse;
    String text = "Name";
    JButton b1, b2, b3,def;
    JTextField tf;
    JTextField t2;
    String x[] = {"Name", "Father's Name", "Last Name", "Date of Birth", "Address", "Phone", "Email", "Class X(%)", "Class XII(%)", "Aadhar No", "Roll No", "Course", "Branch"};
    String z[] = {"Name", "Father's Name", "Last Name", "Address", "Email", "Class X(%)", "Class XII(%)", "Aadhar No", "Roll No", "Course"};
    String mrks[] = {"90-100", "75-89", "50-74", "35-49"};
    String y[][];
    int i = 0, j = 0;

    StudentDetailsComputer() {
        super("Student Details");
        setSize(1260, 650);
        setLocation(200, 200);
        setLayout(null);

        option = new JComboBox(z);
        option.setBackground(Color.WHITE);

        String course[] = {"BTech", "MTech"};
        crse = new JComboBox(course);
        crse.setBackground(Color.WHITE);
        crse.setBounds(240, 360, 200, 30);
        add(crse);
        crse.setVisible(false);
        option.setBounds(50, 360, 150, 30);
        add(option);
        option.addItemListener(this);
        //400 360 200 30

        def = new JButton("Show All Students");
        def.setBackground(Color.black);
        def.setForeground(Color.WHITE);
        def.setBounds(620, 360, 160, 30);
        add(def);
        def.addActionListener(this);
        b1 = new JButton("Search");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(470, 360, 100, 30);
        add(b1);

        l2 = new JLabel("Add New Student");
        l2.setBounds(50, 450, 400, 30);
        l2.setFont(new Font("serif", Font.BOLD, 20));
        add(l2);

        b2 = new JButton("Add Student");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(300, 450, 150, 30);
        add(b2);

        t2 = new JTextField();
        t2.setBounds(240, 360, 200, 30);
        t2.setBackground(Color.black);
        t2.setCaretPosition(0);
        t2.setVisible(true);
        t2.setForeground(Color.WHITE);
        add(t2);

        l3 = new JLabel("Update Student Details");
        l3.setBounds(50, 490, 400, 30);
        l3.setFont(new Font("serif", Font.BOLD, 20));
        add(l3);

        b3 = new JButton("Update Student");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(300, 490, 150, 30);
        add(b3);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        tenth = new JComboBox(mrks);
        tenth.setBackground(Color.WHITE);
        tenth.setBounds(240, 360, 200, 30);
        //tenth.addItemListener(this);
        add(tenth);

        t2.setEditable(true);
        c2 = new Choice();
        try {
            conn c = new conn();

            ResultSet rs = c.s.executeQuery("select name,fathers_name,last_name,dob,address,phone,email,class_x,class_xii,aadhar,rollno,c_name,dept_name from student NATURAL JOIN course NATURAL JOIN department where dept_name = 'Computer Science'");
            while (rs.next()) {
                c2.add(Integer.toString(rs.getInt("rollno")));
            }
        } catch (Exception e) {
        }
        c2.setBounds(240, 360, 200, 30);
        add(c2);
        twelve = new JComboBox(mrks);
        twelve.setBackground(Color.WHITE);
        twelve.setBounds(240, 360, 200, 30);
        //twelve.addItemListener(this);
        add(twelve);
        if (!shown) {
            try {
                conn c1 = new conn();
                int cnt = 0;
                ResultSet r = c1.s.executeQuery("select count(*) from student NATURAL JOIN department where dept_name = 'Computer Science'");
                r.next();
                cnt = r.getInt(1);
                System.out.println(cnt);
                y = new String[cnt][13];
                String s1 = "select name,fathers_name,last_name,dob,address,phone,email,class_x,class_xii,aadhar,rollno,c_name,dept_name from student NATURAL JOIN course NATURAL JOIN department where dept_name = 'Computer Science'";
                ResultSet rs = c1.s.executeQuery(s1);
                while (rs.next()) {
                    y[i][j++] = rs.getString("name");
                    y[i][j++] = rs.getString("fathers_name");
                    y[i][j++] = rs.getString("last_name");
                    y[i][j++] = rs.getString("dob");
                    y[i][j++] = rs.getString("address");
                    y[i][j++] = rs.getString("phone");
                    y[i][j++] = rs.getString("email");
                    y[i][j++] = rs.getString("class_x");
                    y[i][j++] = rs.getString("class_xii");
                    y[i][j++] = rs.getString("aadhar");
                    y[i][j++] = rs.getString("rollno");
                    y[i][j++] = rs.getString("c_name");
                    y[i][j++] = rs.getString("dept_name");
                    i++;
                    j = 0;
                }
                t1 = new JTable(y, x);
                JLabel total = new JLabel("Total Students are: " + Integer.toString(cnt));
                total.setForeground(Color.BLUE);
                total.setBounds(390, 550, 350, 30);
                total.setFont(new Font("serif", Font.BOLD, 30));
                add(total);
            } catch (Exception e) {
                e.printStackTrace();
            }

            JScrollPane sp = new JScrollPane(t1);
            sp.setBounds(20, 20, 1200, 330);
            add(sp);
            shown = true;
        }
        getContentPane().setBackground(Color.WHITE);

        b1.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {

        conn c1 = new conn();

        if (ae.getSource() == b1) {
            try {
                int i = 0;
                System.out.println("HII" + text);
                switch (text) {
                    case "Name":
                        String nme = t2.getText();
                        System.out.println("THIS is: " + nme);
                        if (nme != null) {
                            try {
                                ResultSet cntSet = c1.s.executeQuery("select count(*) from student NATURAL JOIN department where dept_name = 'Computer Science' and name = '" + nme + "'");
                                cntSet.next();
                                a = new String[cntSet.getInt(1)][14];
                                ResultSet nameSet = c1.s.executeQuery("select name,fathers_name,last_name,dob,address,phone,email,class_x,class_xii,aadhar,rollno,c_name,dept_name from student NATURAL JOIN course NATURAL JOIN department where dept_name = 'Computer Science' and name = '" + nme + "'");

                                while (nameSet.next()) {
                                    a[i][j++] = nameSet.getString("name");
                                    a[i][j++] = nameSet.getString("fathers_name");
                                    a[i][j++] = nameSet.getString("last_name");
                                    a[i][j++] = nameSet.getString("dob");
                                    a[i][j++] = nameSet.getString("address");
                                    a[i][j++] = nameSet.getString("phone");
                                    a[i][j++] = nameSet.getString("email");
                                    a[i][j++] = nameSet.getString("class_x");
                                    a[i][j++] = nameSet.getString("class_xii");
                                    a[i][j++] = nameSet.getString("aadhar");
                                    a[i][j++] = nameSet.getString("rollno");
                                    a[i][j++] = nameSet.getString("c_name");
                                    a[i][j++] = nameSet.getString("dept_name");
                                    i++;
                                    j = 0;
                                }
                                t1 = new JTable(a, x);
                                JScrollPane sp = new JScrollPane(t1);
                                sp.setBounds(20, 20, 1200, 330);
                                add(sp);
                            } catch (Exception ex) {
                                Logger.getLogger(StudentDetailsComputer.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            i = 0;
                        }
                        break;
                    case "Father's Name":
                        String lnme = t2.getText();
                        System.out.println("THIS is: " + lnme);
                        if (lnme != null) {
                            try {
                                ResultSet cntSet = c1.s.executeQuery("select count(*) from student NATURAL JOIN department where dept_name = 'Computer Science' and fathers_name = '" + lnme + "'");
                                cntSet.next();
                                a = new String[cntSet.getInt(1)][14];
                                ResultSet nameSet = c1.s.executeQuery("select name,fathers_name,last_name,dob,address,phone,email,class_x,class_xii,aadhar,rollno,c_name,dept_name from student NATURAL JOIN course NATURAL JOIN department where dept_name = 'Computer Science' and fathers_name = '" + lnme + "'");

                                while (nameSet.next()) {
                                    a[i][j++] = nameSet.getString("name");
                                    a[i][j++] = nameSet.getString("fathers_name");
                                    a[i][j++] = nameSet.getString("last_name");
                                    a[i][j++] = nameSet.getString("dob");
                                    a[i][j++] = nameSet.getString("address");
                                    a[i][j++] = nameSet.getString("phone");
                                    a[i][j++] = nameSet.getString("email");
                                    a[i][j++] = nameSet.getString("class_x");
                                    a[i][j++] = nameSet.getString("class_xii");
                                    a[i][j++] = nameSet.getString("aadhar");
                                    a[i][j++] = nameSet.getString("rollno");
                                    a[i][j++] = nameSet.getString("c_name");
                                    a[i][j++] = nameSet.getString("dept_name");
                                    i++;
                                    j = 0;
                                }
                                t1 = new JTable(a, x);
                                JScrollPane sp = new JScrollPane(t1);
                                sp.setBounds(20, 20, 1200, 330);
                                add(sp);
                            } catch (Exception ex) {
                                Logger.getLogger(StudentDetailsComputer.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            i = 0;
                        }
                        break;
                    case "Address":
                        String add = t2.getText();
                        //System.out.println("THIS is: " + lnme);
                        if (add != null) {
                            try {
                                ResultSet cntSet = c1.s.executeQuery("select count(*) from student NATURAL JOIN department where dept_name = 'Computer Science' and address = '" + add + "'");
                                cntSet.next();
                                a = new String[cntSet.getInt(1)][14];
                                ResultSet nameSet = c1.s.executeQuery("select name,fathers_name,last_name,dob,address,phone,email,class_x,class_xii,aadhar,rollno,c_name,dept_name from student NATURAL JOIN course NATURAL JOIN department where dept_name = 'Computer Science' and address = '" + add + "' order by rollno");

                                while (nameSet.next()) {
                                    a[i][j++] = nameSet.getString("name");
                                    a[i][j++] = nameSet.getString("fathers_name");
                                    a[i][j++] = nameSet.getString("last_name");
                                    a[i][j++] = nameSet.getString("dob");
                                    a[i][j++] = nameSet.getString("address");
                                    a[i][j++] = nameSet.getString("phone");
                                    a[i][j++] = nameSet.getString("email");
                                    a[i][j++] = nameSet.getString("class_x");
                                    a[i][j++] = nameSet.getString("class_xii");
                                    a[i][j++] = nameSet.getString("aadhar");
                                    a[i][j++] = nameSet.getString("rollno");
                                    a[i][j++] = nameSet.getString("c_name");
                                    a[i][j++] = nameSet.getString("dept_name");
                                    i++;
                                    j = 0;
                                }
                                t1 = new JTable(a, x);
                                JScrollPane sp = new JScrollPane(t1);
                                sp.setBounds(20, 20, 1200, 330);
                                add(sp);
                            } catch (Exception ex) {
                                Logger.getLogger(StudentDetailsComputer.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            i = 0;
                        }
                        break;
                    case "Email":
                        String mail = t2.getText();
                        //System.out.println("THIS is: " + lnme);
                        if (mail != null) {
                            try {
                                ResultSet cntSet = c1.s.executeQuery("select count(*) from student NATURAL JOIN department where dept_name = 'Computer Science' and email = '" + mail + "'");
                                cntSet.next();
                                a = new String[cntSet.getInt(1)][14];
                                ResultSet nameSet = c1.s.executeQuery("select name,fathers_name,last_name,dob,address,phone,email,class_x,class_xii,aadhar,rollno,c_name,dept_name from student NATURAL JOIN course NATURAL JOIN department where dept_name = 'Computer Science' and email = '" + mail + "'");

                                while (nameSet.next()) {
                                    a[i][j++] = nameSet.getString("name");
                                    a[i][j++] = nameSet.getString("fathers_name");
                                    a[i][j++] = nameSet.getString("last_name");
                                    a[i][j++] = nameSet.getString("dob");
                                    a[i][j++] = nameSet.getString("address");
                                    a[i][j++] = nameSet.getString("phone");
                                    a[i][j++] = nameSet.getString("email");
                                    a[i][j++] = nameSet.getString("class_x");
                                    a[i][j++] = nameSet.getString("class_xii");
                                    a[i][j++] = nameSet.getString("aadhar");
                                    a[i][j++] = nameSet.getString("rollno");
                                    a[i][j++] = nameSet.getString("c_name");
                                    a[i][j++] = nameSet.getString("dept_name");
                                    i++;
                                    j = 0;
                                }
                                t1 = new JTable(a, x);
                                JScrollPane sp = new JScrollPane(t1);
                                sp.setBounds(20, 20, 1200, 330);
                                add(sp);
                            } catch (Exception ex) {
                                Logger.getLogger(StudentDetailsComputer.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            i = 0;
                        }
                        break;
                    case "Class X(%)":
                        String percent = (String) tenth.getSelectedItem();
                        char l1 = (char) percent.charAt(0);// + (char)percent.charAt(0);
                        char l2 = (char) percent.charAt(1);
                        String lower = Character.toString(l1) + Character.toString(l2);
                        System.out.println(lower);
                        String upper = "";
                        if (lower.equals("90")) {
                            upper = "100";
                        } else if (lower.equals("75")) {
                            upper = "89";
                        } else if (lower.equals("50")) {
                            upper = "74";
                        } else {
                            upper = "49";
                        }
                        double low = Double.parseDouble(lower);
                        double high = Double.parseDouble(upper);
                        if (percent != null) {
                            try {
                                ResultSet cntSet = c1.s.executeQuery("select count(*) from student NATURAL JOIN department where dept_name = 'Computer Science' and class_x between " + low + " and " + high + " ");
                                cntSet.next();
                                a = new String[cntSet.getInt(1)][14];
                                ResultSet nameSet = c1.s.executeQuery("select name,fathers_name,last_name,dob,address,phone,email,class_x,class_xii,aadhar,rollno,c_name,dept_name from student NATURAL JOIN course NATURAL JOIN department where dept_name = 'Computer Science' and class_x between " + low + " and " + high + " ");

                                while (nameSet.next()) {
                                    a[i][j++] = nameSet.getString("name");
                                    a[i][j++] = nameSet.getString("fathers_name");
                                    a[i][j++] = nameSet.getString("last_name");
                                    a[i][j++] = nameSet.getString("dob");
                                    a[i][j++] = nameSet.getString("address");
                                    a[i][j++] = nameSet.getString("phone");
                                    a[i][j++] = nameSet.getString("email");
                                    a[i][j++] = nameSet.getString("class_x");
                                    a[i][j++] = nameSet.getString("class_xii");
                                    a[i][j++] = nameSet.getString("aadhar");
                                    a[i][j++] = nameSet.getString("rollno");
                                    a[i][j++] = nameSet.getString("c_name");
                                    a[i][j++] = nameSet.getString("dept_name");
                                    i++;
                                    j = 0;
                                }
                                t1 = new JTable(a, x);
                                JScrollPane sp = new JScrollPane(t1);
                                sp.setBounds(20, 20, 1200, 330);
                                add(sp);
                            } catch (Exception ex) {
                                Logger.getLogger(StudentDetailsComputer.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            i = 0;
                        }
                        break;
                    case "Class XII(%)":
                        String percent12 = (String) twelve.getSelectedItem();
                        char l12 = (char) percent12.charAt(0);// + (char)percent.charAt(0);
                        char l212 = (char) percent12.charAt(1);
                        String lower12 = Character.toString(l12) + Character.toString(l212);
                       
                        String upper12 = "";
                        if (lower12.equals("90")) {
                            upper12 = "100";
                        } else if (lower12.equals("75")) {
                            upper12 = "89";
                        } else if (lower12.equals("50")) {
                            upper12 = "74";
                        } else {
                            upper12 = "49";
                        }
                        double low12 = Double.parseDouble(lower12);
                        double high12 = Double.parseDouble(upper12);
                        if (percent12 != null) {
                            try {
                                ResultSet cntSet = c1.s.executeQuery("select count(*) from student NATURAL JOIN department where dept_name = 'Computer Science' and class_xii between " + low12 + " and " + high12 + " ");
                                cntSet.next();
                                a = new String[cntSet.getInt(1)][14];
                                ResultSet nameSet = c1.s.executeQuery("select name,fathers_name,last_name,dob,address,phone,email,class_x,class_xii,aadhar,rollno,c_name,dept_name from student NATURAL JOIN course NATURAL JOIN department where dept_name = 'Computer Science' and class_xii between " + low12 + " and " + high12 + " ");

                                while (nameSet.next()) {
                                    a[i][j++] = nameSet.getString("name");
                                    a[i][j++] = nameSet.getString("fathers_name");
                                    a[i][j++] = nameSet.getString("last_name");
                                    a[i][j++] = nameSet.getString("dob");
                                    a[i][j++] = nameSet.getString("address");
                                    a[i][j++] = nameSet.getString("phone");
                                    a[i][j++] = nameSet.getString("email");
                                    a[i][j++] = nameSet.getString("class_x");
                                    a[i][j++] = nameSet.getString("class_xii");
                                    a[i][j++] = nameSet.getString("aadhar");
                                    a[i][j++] = nameSet.getString("rollno");
                                    a[i][j++] = nameSet.getString("c_name");
                                    a[i][j++] = nameSet.getString("dept_name");
                                    i++;
                                    j = 0;
                                }
                                t1 = new JTable(a, x);
                                JScrollPane sp = new JScrollPane(t1);
                                sp.setBounds(20, 20, 1200, 330);
                                add(sp);
                            } catch (Exception ex) {
                                Logger.getLogger(StudentDetailsComputer.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            i = 0;
                        }
                        break;
                    case "Aadhar No":
                        String aadhar = t2.getText();
                        if (aadhar != null) {
                            try {
                                ResultSet cntSet = c1.s.executeQuery("select count(*) from student NATURAL JOIN department where dept_name = 'Computer Science' and aadhar = '" + aadhar + "'");
                                cntSet.next();
                                a = new String[cntSet.getInt(1)][14];
                                ResultSet nameSet = c1.s.executeQuery("select name,fathers_name,last_name,dob,address,phone,email,class_x,class_xii,aadhar,rollno,c_name,dept_name from student NATURAL JOIN course NATURAL JOIN department where dept_name = 'Computer Science' and aadhar = '" + aadhar + "'");

                                while (nameSet.next()) {
                                    a[i][j++] = nameSet.getString("name");
                                    a[i][j++] = nameSet.getString("fathers_name");
                                    a[i][j++] = nameSet.getString("last_name");
                                    a[i][j++] = nameSet.getString("dob");
                                    a[i][j++] = nameSet.getString("address");
                                    a[i][j++] = nameSet.getString("phone");
                                    a[i][j++] = nameSet.getString("email");
                                    a[i][j++] = nameSet.getString("class_x");
                                    a[i][j++] = nameSet.getString("class_xii");
                                    a[i][j++] = nameSet.getString("aadhar");
                                    a[i][j++] = nameSet.getString("rollno");
                                    a[i][j++] = nameSet.getString("c_name");
                                    a[i][j++] = nameSet.getString("dept_name");
                                    i++;
                                    j = 0;
                                }
                                t1 = new JTable(a, x);
                                JScrollPane sp = new JScrollPane(t1);
                                sp.setBounds(20, 20, 1200, 330);
                                add(sp);
                            } catch (Exception ex) {
                                Logger.getLogger(StudentDetailsComputer.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            i = 0;
                        }
                        break;
                    case "Roll No":
                        String roll = (String) c2.getSelectedItem();
                        if (roll != null) {
                            try {
                                ResultSet cntSet = c1.s.executeQuery("select count(*) from student NATURAL JOIN department where dept_name = 'Computer Science' and rollno = '" + roll + "'");
                                cntSet.next();
                                a = new String[cntSet.getInt(1)][14];
                                ResultSet nameSet = c1.s.executeQuery("select name,fathers_name,last_name,dob,address,phone,email,class_x,class_xii,aadhar,rollno,c_name,dept_name from student NATURAL JOIN course NATURAL JOIN department where dept_name = 'Computer Science' and rollno = '" + roll + "'");

                                while (nameSet.next()) {
                                    a[i][j++] = nameSet.getString("name");
                                    a[i][j++] = nameSet.getString("fathers_name");
                                    a[i][j++] = nameSet.getString("last_name");
                                    a[i][j++] = nameSet.getString("dob");
                                    a[i][j++] = nameSet.getString("address");
                                    a[i][j++] = nameSet.getString("phone");
                                    a[i][j++] = nameSet.getString("email");
                                    a[i][j++] = nameSet.getString("class_x");
                                    a[i][j++] = nameSet.getString("class_xii");
                                    a[i][j++] = nameSet.getString("aadhar");
                                    a[i][j++] = nameSet.getString("rollno");
                                    a[i][j++] = nameSet.getString("c_name");
                                    a[i][j++] = nameSet.getString("dept_name");
                                    i++;
                                    j = 0;
                                }
                                t1 = new JTable(a, x);
                                JScrollPane sp = new JScrollPane(t1);
                                sp.setBounds(20, 20, 1200, 330);
                                add(sp);
                            } catch (Exception ex) {
                                Logger.getLogger(StudentDetailsComputer.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            i = 0;
                        }
                        break;
                    case "Course":
                        String cours = (String) crse.getSelectedItem();
                        
                        if (cours != null) {
                            try {
                                ResultSet cntSet = c1.s.executeQuery("select count(*) from student NATURAL JOIN department NATURAL JOIN course where dept_name = 'Computer Science' and c_name = '" + cours + "'");
                                cntSet.next();
                                a = new String[cntSet.getInt(1)][14];
                                ResultSet nameSet = c1.s.executeQuery("select name,fathers_name,last_name,dob,address,phone,email,class_x,class_xii,aadhar,rollno,c_name,dept_name from student NATURAL JOIN course NATURAL JOIN department where dept_name = 'Computer Science' and c_name = '" + cours + "'");

                                while (nameSet.next()) {
                                    a[i][j++] = nameSet.getString("name");
                                    a[i][j++] = nameSet.getString("fathers_name");
                                    a[i][j++] = nameSet.getString("last_name");
                                    a[i][j++] = nameSet.getString("dob");
                                    a[i][j++] = nameSet.getString("address");
                                    a[i][j++] = nameSet.getString("phone");
                                    a[i][j++] = nameSet.getString("email");
                                    a[i][j++] = nameSet.getString("class_x");
                                    a[i][j++] = nameSet.getString("class_xii");
                                    a[i][j++] = nameSet.getString("aadhar");
                                    a[i][j++] = nameSet.getString("rollno");
                                    a[i][j++] = nameSet.getString("c_name");
                                    a[i][j++] = nameSet.getString("dept_name");
                                    i++;
                                    j = 0;
                                }
                                t1 = new JTable(a, x);
                                JScrollPane sp = new JScrollPane(t1);
                                sp.setBounds(20, 20, 1200, 330);
                                add(sp);
                            } catch (Exception ex) {
                                Logger.getLogger(StudentDetailsComputer.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            i = 0;
                        }
                        break;
                    default:
                        
                        break;
                }
            } catch (Exception e) {
            }

        } else if (ae.getSource() == b2) {
            new AddStudent().f.setVisible(true);
            this.setVisible(false);
        } else if (ae.getSource() == b3) {
        new UpdateStudent().f.setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==def){
            try {
                int cnt = 0;
                i=0;
                ResultSet r = c1.s.executeQuery("select count(*) from student NATURAL JOIN department where dept_name = 'Computer Science'");
                r.next();
                cnt = r.getInt(1);
                System.out.println(cnt);
                y = new String[cnt][13];
                String s1 = "select name,fathers_name,last_name,dob,address,phone,email,class_x,class_xii,aadhar,rollno,c_name,dept_name from student NATURAL JOIN course NATURAL JOIN department where dept_name = 'Computer Science'";
                ResultSet rs = c1.s.executeQuery(s1);
                while (rs.next()) {
                    y[i][j++] = rs.getString("name");
                    y[i][j++] = rs.getString("fathers_name");
                    y[i][j++] = rs.getString("last_name");
                    y[i][j++] = rs.getString("dob");
                    y[i][j++] = rs.getString("address");
                    y[i][j++] = rs.getString("phone");
                    y[i][j++] = rs.getString("email");
                    y[i][j++] = rs.getString("class_x");
                    y[i][j++] = rs.getString("class_xii");
                    y[i][j++] = rs.getString("aadhar");
                    y[i][j++] = rs.getString("rollno");
                    y[i][j++] = rs.getString("c_name");
                    y[i][j++] = rs.getString("dept_name");
                    i++;
                    j = 0;
                }
                t1 = new JTable(y, x);
                JScrollPane sp = new JScrollPane(t1);
            sp.setBounds(20, 20, 1200, 330);
            add(sp);
                JLabel total = new JLabel("Total Students are: " + Integer.toString(cnt));
                total.setForeground(Color.BLUE);
                total.setBounds(390, 550, 350, 30);
                total.setFont(new Font("serif", Font.BOLD, 30));
                add(total);
            } catch (SQLException ex) {
                Logger.getLogger(StudentDetailsComputer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) {
        new StudentDetailsComputer().setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        text = (String) option.getSelectedItem();
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(StudentDetailsComputer.class.getName()).log(Level.SEVERE, null, ex);
        }
         switch (text) {
            case "Name":
                
                t2.setEditable(true);
                t2.setText("");
                tenth.setVisible(false);
                twelve.setVisible(false);
                t2.setBounds(240, 360, 200, 30);
                t2.setBackground(Color.black);
                c2.setVisible(false);
                t2.setVisible(true);
                crse.setVisible(false);
                t2.setForeground(Color.WHITE);
                add(t2);
                break;
            case "Father's Name":
                tenth.setVisible(false);
                crse.setVisible(false);
                c2.setVisible(false);
                t2.setEditable(true);
                twelve.setVisible(false);
                t2.setText("");
                t2.setVisible(true);
                break;
            case "Last Name":
                t2.setText("");
                tenth.setVisible(false);
                crse.setVisible(false);
                c2.setVisible(false);
                twelve.setVisible(false);
                t2.setEditable(true);
                t2.setVisible(true);
                break;
            case "Address":
                t2.setText("");
                tenth.setVisible(false);
                t2.setEditable(true);
                c2.setVisible(false);
                twelve.setVisible(false);
                crse.setVisible(false);
                t2.setVisible(true);
                break;
            case "Email":
                t2.setText("");
                t2.setEditable(true);
                tenth.setVisible(false);
                twelve.setVisible(false);
                crse.setVisible(false);
                t2.setVisible(true);
                c2.setVisible(false);
                break;
            case "Class X(%)":
                tenth.setVisible(true);
                twelve.setVisible(false);
                c2.setVisible(false);
                t2.setVisible(false);
                t2.setEditable(false);
                crse.setVisible(false);
                break;
            case "Class XII(%)":
                twelve.setVisible(true);
                tenth.setVisible(false);
                t2.setVisible(false);
                t2.setEditable(false);
                c2.setVisible(false);
                crse.setVisible(false);
                break;
            case "Aadhar No":
                t2.setText("");
                c2.setVisible(false);
                t2.setEditable(true);
                tenth.setVisible(false);
                crse.setVisible(false);
                twelve.setVisible(false);
                t2.setVisible(true);
                break;
            case "Roll No":
                c2.setVisible(true);
                t2.setEditable(true);
                tenth.setVisible(false);
                twelve.setVisible(false);
                t2.setVisible(false);
                crse.setVisible(false);
                break;
            case "Course":
                c2.setVisible(false);
                t2.setEditable(false);
                tenth.setVisible(false);
                twelve.setVisible(false);
                t2.setVisible(false);
                crse.setVisible(true);

            default:
                break;

        }
    }

}
