package university.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Project extends JFrame implements ActionListener{
    Project(){
        super("College Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920,830);
       
        setLayout(new BorderLayout());
        ImageIcon ic =  new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/pune.jpg"));
        Image i3 = ic.getImage().getScaledInstance(1900, 750,Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        JLabel background=new JLabel(icc3);
        add(background);
        background.setLayout(new FlowLayout());
        setForeground(new Color(0,0,0,0f));
        
        JLabel notices = new JLabel("Notices");
        notices.setBounds(30,1880,100,60);
        notices.setFont(new Font("monospaced",Font.BOLD,56));
        notices.setForeground(Color.red);
        background.add(notices);
        
        JMenuBar mb  = new JMenuBar();
        JMenu master = new JMenu("Master");
        JMenuItem m1 = new JMenuItem("New Faculty");
        JMenuItem m2 = new JMenuItem("New Student Admission");
        master.setForeground(Color.BLUE);
        
        
        m1.setFont(new Font("monospaced",Font.BOLD,16));
        m1.setBackground(Color.WHITE);
        
        m2.setFont(new Font("monospaced",Font.BOLD,16));
        m2.setBackground(Color.WHITE);
    
        
        m1.addActionListener(this);
        m2.addActionListener(this);
        
        conn c = new conn();
        int srNo = 1;
        int i=0,j=0;
        String x[] = {"Sr.No","Date","Title","Description"};
        String y[][];
        
        ResultSet rSet;
        try {
            ResultSet rS = c.s.executeQuery("select count(*) from notice");
            rS.next();
            int cnt = rS.getInt(1);
            System.out.println("CNT" + Integer.toString(cnt));
            y = new String[8][4];
            ResultSet n = c.s.executeQuery("select * from notice");
            while(n.next()){
                String title = n.getString("title");
                String notice = n.getString("notice");
                String date = n.getString("date");
                y[i][j++] = Integer.toString(srNo);
                y[i][j++] = date;
                y[i][j++] = title;
                y[i][j++] = notice;
                i++;
                j=0;
                srNo++;
                
            }
            JTable table = new JTable(y,x);
            JScrollPane sp = new JScrollPane(table);
            sp.setBounds(20,200,4800,330);
            background.add(sp);
        
        } catch (SQLException ex) {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JMenu noticeAdd = new JMenu("Notice");
        JMenuItem i1 = new JMenuItem("Add Notice");
        noticeAdd.setForeground(Color.blue);
        i1.setFont(new Font("monospaced",Font.BOLD,16));
        i1.addActionListener(this);
        JMenu user = new JMenu("Faculty Details");
        JMenuItem u1 = new JMenuItem("Computer Science Faculty");
        JMenuItem u2 = new JMenuItem("IT Faculty");
        JMenuItem u3 = new JMenuItem("ENTC Faculty");
        user.setForeground(Color.blue);
        
        u1.setFont(new Font("monospaced",Font.BOLD,16));
        u1.setBackground(Color.WHITE);
        
        u2.setFont(new Font("monospaced",Font.BOLD,16));
        u2.setBackground(Color.WHITE);
        u3.setFont(new Font("monospaced",Font.BOLD,16));
        u3.setBackground(Color.WHITE);
        u1.addActionListener(this);
        u2.addActionListener(this);
        u3.addActionListener(this);
        JMenu report = new JMenu("Update Details");
        JMenuItem r1 = new JMenuItem("Update Students");
        JMenuItem r2 = new JMenuItem("Update Teachers");
        report.setForeground(Color.blue);
        
        r1.setFont(new Font("monospaced",Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        
        r1.addActionListener(this);
        
        r2.setFont(new Font("monospaced",Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        
        r2.addActionListener(this);
        
        JMenu fee = new JMenu("Fee Details");
        JMenuItem s1 = new JMenuItem("Fee Structure");
        fee.setForeground(Color.BLUE);
        
        s1.setFont(new Font("monospaced",Font.BOLD,16));
        s1.setBackground(Color.WHITE);
        
        s1.addActionListener(this);
        
        JMenu details = new JMenu("Student Details");
        JMenuItem j1 = new JMenuItem("Computer Science");
        JMenuItem j2 = new JMenuItem("IT");
        JMenuItem j3 = new JMenuItem("ENTC");
        details.setForeground(Color.blue);

        j1.setBackground(Color.WHITE);
        j1.setFont(new Font("monospaced",Font.BOLD,16));
        
        j2.setBackground(Color.WHITE);
        j2.setFont(new Font("monospaced",Font.BOLD,16));
        
        j3.setBackground(Color.WHITE);
        j3.setFont(new Font("monospaced",Font.BOLD,16));
        
        j1.addActionListener(this);
        j2.addActionListener(this);
        j3.addActionListener(this);
        
        JMenu exit = new JMenu("Exit");
        JMenuItem ex = new JMenuItem("Exit");
        exit.setForeground(Color.blue);
        

        ex.setFont(new Font("monospaced",Font.BOLD,16));
        ex.setBackground(Color.WHITE);
        
        ex.addActionListener(this);
        
        

        master.add(m1);
        master.add(m2);
        
        user.add(u1);
        user.add(u2);
        user.add(u3);
        
        report.add(r1);
        report.add(r2);
        
        fee.add(s1);
        exit.add(ex); 

        noticeAdd.add(i1);
        details.add(j1);
        details.add(j2);
        details.add(j3);
        mb.add(master);
        mb.add(user);
        mb.add(details);
        mb.add(report);
        mb.add(fee);
        mb.add(noticeAdd);
        mb.add(exit);
        
        setJMenuBar(mb);    
        
        setFont(new Font("Senserif",Font.BOLD,16));
        setLayout(new FlowLayout());
        setVisible(false);
    }
    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        if(msg.equals("New Student Admission")){
            new AddStudent().f.setVisible(true);
            
        }else if(msg.equals("New Faculty")){
            new AddTeacher().f.setVisible(true);
            
        }
        else if(msg.equals("Add Notice")){
            new AddNotice().f.setVisible(true);
            
        }else if(msg.equals("Computer Science")){
            new StudentDetailsComputer().setVisible(true);
            
        }
        else if(msg.equals("IT")){
            new StudentDetailsIT().setVisible(true);
            
        }
        else if(msg.equals("ENTC")){
            new StudentDetailsENTC().setVisible(true);
            
        }else if(msg.equals("Computer Science Faculty")){
            new TeacherDetailsComputer().setVisible(true);
            
        }
        else if(msg.equals("IT Faculty")){
            new StudentDetailsIT().setVisible(true);
            
        }
        else if(msg.equals("ENTC Faculty")){
            new StudentDetailsENTC().setVisible(true);
            
        }
        else if(msg.equals("Update Students")){
            new UpdateStudent().f.setVisible(true);
           
        }
        else if(msg.equals("Update Teachers")){
            new UpdateTeacher().f.setVisible(true);
           
        }
        else if(msg.equals("Fee Structure")){
            new FeeStructure().setVisible(true);
           
        }
        else if(msg.equals("Exit")){
            System.exit(0);
        }
    }
    
    
    public static void main(String[] args){
        new Project().setVisible(true);
    }
    
}
