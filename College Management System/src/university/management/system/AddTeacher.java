package university.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;
import javax.swing.*;

class AddTeacher implements ActionListener{

    JFrame f;
    JLabel id,id1,id2,id3,id4,id5,id6,id7,id8,id9,id19,id10,id11,id12,id15,id16,id17,lab,lab1,lab2;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t19;
    JButton b,b1,b2,b3;
    JComboBox c1,c2,c3;
    
    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    long first = Math.abs(first4);

    AddTeacher(){
        f = new JFrame("Add Teacher");
        f.setBackground(Color.white);
        f.setLayout(null);

        id15=new JLabel();
        id15.setBounds(0,0,900,700);
        id15.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/fifth.jpg"));
        Image i3 = img.getImage().getScaledInstance(920, 600,Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        id15.setIcon(icc3);

        id8 = new JLabel("New Teacher Details");
        id8.setBounds(320,5,500,50);
        id8.setFont(new Font("serif",Font.ITALIC,25));
        id8.setForeground(Color.black);
        id15.add(id8);
        f.add(id15);

 
        id1 = new JLabel("Name");
        id1.setBounds(50,150,100,30);
        id1.setFont(new Font("serif",Font.BOLD,20));
        id1.setForeground(Color.black);
        id15.add(id1);

        t1=new JTextField();
        t1.setBounds(200,150,150,30);
        id15.add(t1);

        id2 = new JLabel("Father's Name");
        id2.setBounds(400,150,200,30);
        id2.setFont(new Font("serif",Font.BOLD,20));
        id2.setForeground(Color.black);
        id15.add(id2);

        t2=new JTextField();
        t2.setBounds(600,150,150,30);
        id15.add(t2);

        id3= new JLabel("Last Name");
        id3.setBounds(50,200,100,30);
        id3.setFont(new Font("serif",Font.BOLD,20));
        id3.setForeground(Color.black);
        id15.add(id3);

        t3=new JTextField();
        t3.setBounds(200,200,150,30);
        id15.add(t3);

        id4= new JLabel("DOB (yyyy-mm-dd)");  
        id4.setBounds(400,200,200,30);
        id4.setForeground(Color.black);
        id4.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id4);

        t4=new JTextField();
        t4.setBounds(600,200,150,30);
        id15.add(t4);

        id5= new JLabel("Address");
        id5.setBounds(50,250,100,30);
        id5.setForeground(Color.black);
        id5.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id5);

        t5=new JTextField();
        t5.setBounds(200,250,150,30);
        id15.add(t5);

        id6= new JLabel("Phone");
        id6.setBounds(400,250,100,30);
        id6.setForeground(Color.black);
        id6.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id6);

        t6=new JTextField();
        t6.setBounds(600,250,150,30);
        id15.add(t6);

        id7= new JLabel("Email Id");
        id7.setBounds(50,300,100,30);
        id7.setForeground(Color.black);
        id7.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id7);

        t7=new JTextField();
        t7.setBounds(200,300,150,30);
        id15.add(t7);

        id8= new JLabel("Class X(%)");
        id8.setBounds(400,300,130,30);
        id8.setForeground(Color.black);
        id8.setFont(new Font("serif",Font.BOLD,20));    
        id15.add(id8);

        t8=new JTextField();
        t8.setBounds(600,300,150,30);
        id15.add(t8);

        id9= new JLabel("Class XII(%)");
        id9.setBounds(50,350,130,30);
        id9.setForeground(Color.black);
        id9.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id9);

        t9=new JTextField();
        t9.setBounds(200,350,150,30);
        id15.add(t9);


        id10= new JLabel("Aadhar No");
        id10.setBounds(400,350,100,30);
        id10.setForeground(Color.black);
        id10.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id10);

        t10=new JTextField();
        t10.setBounds(600,350,150,30);
        id15.add(t10);

        
        lab=new JLabel("Teaching Degree");
        lab.setBounds(50,400,150,30);
	lab.setFont(new Font("serif",Font.BOLD,20));
        lab.setForeground(Color.black);
        id15.add(lab);
            
        String course[] = {"BTech","MTech"};
        c1 = new JComboBox(course);
        c1.setBackground(Color.WHITE);
        c1.setBounds(200,400,150,30);
        id15.add(c1);
        
        JLabel desig = new JLabel("Designation");
        desig.setBounds(50,450,150,30);
        desig.setForeground(Color.black);
        desig.setFont(new Font("serif",Font.BOLD,20));
        id15.add(desig);
        
        String post[] = {"HOD","Professor","Assistant Professor"};
        c3 = new JComboBox(post);
        c3.setBackground(Color.WHITE);
        c3.setBounds(200,450,150,30);
        id15.add(c3);
        
        
        lab2=new JLabel("Department");
        lab2.setBounds(400,400,150,30);
        lab2.setForeground(Color.black);
	lab2.setFont(new Font("serif",Font.BOLD,20));
        id15.add(lab2);
        
        String branch[] = {"Computer Science","IT","ENTC"};
        c2 = new JComboBox(branch);
        c2.setBackground(Color.WHITE);
        c2.setBounds(600,400,150,30);
        id15.add(c2);
        
        id11= new JLabel("Emp id");
        id11.setBounds(400,450,150,30);
        id11.setForeground(Color.black);
        id11.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id11);

        t11=new JTextField();
        t11.setText("101"+first);
        t11.setBounds(600,450,150,30);
        id15.add(t11);
        
        id19= new JLabel("Age");
        id19.setBounds(430,500,150,30);
        id19.setForeground(Color.black);
        id19.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id19);

        t19=new JTextField();
        t19.setBounds(600,500,150,30);
        id15.add(t19);
        
        b = new JButton("Submit");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(250,550,150,40);
        
        id15.add(b);

        b1=new JButton("Cancel");   
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(450,550,150,40);
        
        id15.add(b1);
        
        b.addActionListener(this);
        b1.addActionListener(this);
        
        f.setVisible(true);
        f.setSize(900,700);
        f.setLocation(400,150);
        f.getContentPane().setBackground(Color.WHITE);
    }

    public void actionPerformed(ActionEvent ae){
        
        String a = t1.getText();
        String bb = t2.getText();
        String c = t3.getText();
        String d = t4.getText();
        String e = t5.getText();
        String ff = t6.getText();
        String g = t7.getText();
        String h = t8.getText();
        String i = t9.getText();
        String j = t10.getText();
        String k = (String)c1.getSelectedItem();
        String l = t11.getText();
        String m = (String)c2.getSelectedItem();
        String n = (String)c3.getSelectedItem();
        String age = t19.getText();
        if(ae.getSource() == b){
            try{
                
                conn cc = new conn();
                int c_id,dept_id;
                System.out.println(m + k);
                if(m=="Computer Science"){
                    dept_id = 1;
                    if(k=="BTech")
                        c_id=1;
                    else
                        c_id=2;
                }
                else if(m=="IT"){
                    dept_id = 2;
                    if(k=="BTech")
                        c_id=1;
                    else
                        c_id=2;
                }
                else{
                    dept_id = 3;
                    if(k=="BTech")
                        c_id=1;
                    else
                        c_id=2;
                }
                System.out.println(c_id);
                if(n.equals("HOD")){
                ResultSet r = cc.s.executeQuery("select dept_id,hod from department where dept_id = "+dept_id+"");
                //System.out.println(r.next());
                if(r.next()==false){
                    System.out.println("FALSE");
                    String q = "insert into teacher values('"+a+"','"+bb+"','"+c+"','"+d+"','"+e+"','"+ff+"','"+g+"','"+h+"','"+i+"','"+j+"','"+l+"',"+c_id+","+dept_id+",'"+age+"')";
                cc.s.executeUpdate(q);
                cc.s.executeUpdate("insert into department(dept_name,dept_id,hod) values('"+m+"',"+dept_id+",'"+a+"' )");
                JOptionPane.showMessageDialog(null,"Teacher Details Inserted Successfully");
                f.setVisible(false);
                }
                else{
                    System.out.println("TRUE");
                    JOptionPane.showMessageDialog(null,"HOD already exists");
                }
                }
                else{
                System.out.println("HERE");
                String q = "insert into teacher values('"+a+"','"+bb+"','"+c+"','"+d+"','"+e+"','"+ff+"','"+g+"','"+h+"','"+i+"','"+j+"','"+l+"',"+c_id+","+dept_id+",'"+age+"')";
                cc.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Teacher Details Inserted Successfully");
                f.setVisible(false);
                
                }
                
            }catch(Exception ee){
                System.out.println("The error is:"+ee);
            }
        }else if(ae.getSource() == b1){
            f.setVisible(false);
            new Project().setVisible(true);
            
        }
    }
    public static void main(String[] arg){
        new AddTeacher().f.setVisible(true);
    }
}