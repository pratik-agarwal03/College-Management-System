package university.management.system;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Splash{
    public static void main(String s[]){
        Frame f = new Frame("PICT University"); 
        f.setVisible(true); 
        int i;
        int x=1;
        for(i=2;i<=600;i+=4,x+=1){
            f.setLocation((800-((i+x)/2) ),500-(i/2));
            f.setSize(i+3*x,i+x/2);  
            try{
                Thread.sleep(10);
            }catch(Exception e) { }
        }
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Splash.class.getName()).log(Level.SEVERE, null, ex);
        }
            f.setVisible(false);
            Login f1 = new Login();
    }
}
class Frame extends JFrame{
    Thread t1;
    Frame(String s){
        super(s);
        setLayout(new FlowLayout());
        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/university.jpg"));
        Image i1 = c1.getImage().getScaledInstance(1000, 700,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        
        JLabel m1 = new JLabel(i2);
        add(m1);
      
    }
    
}