
package project.pkg1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {
    JButton back,deposit;
    String password,Name;
    JTextField amount;
    
    Deposit(String password,String Name){
        this.Name=Name;
        this.password=password;
   setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/back2.png"));
        Image i2 = i1.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1920, 1080);
            add(image); 
        
        
        JLabel heading=new  JLabel("Enter The Amount You Want To Deposit");
          heading.setBounds(250,340,1400,200);
        heading.setForeground(Color.decode("#002446"));
        heading.setFont(new Font("Raleway",Font.BOLD,70));
        image.add(heading);
        
         amount=new JTextField("");
        amount.setBounds(500,600,800,80);
        amount.setFont(new Font("Raleway",Font.BOLD,40));
        amount.setBackground(Color.decode("#002446"));
        amount.setForeground(Color.white);
        image.add(amount);
        
        
      deposit=new JButton("Deposit");
        deposit.setBounds(600,750,250,80);
        deposit.setBackground(Color.decode("#002446"));
        deposit.setFont(new Font("Raleway",Font.BOLD,35));
        deposit.setForeground(Color.white);
        deposit.addActionListener(this);
        image.add(deposit);
        
           back=new JButton("Back");
        back.setBounds(950,750,250,80);
        back.setBackground(Color.decode("#002446"));
        back.setFont(new Font("Raleway",Font.BOLD,35));
        back.setForeground(Color.white);
        back.addActionListener(this);
        image.add(back);
        
        
        
        
         setSize(1920, 1080);
        setLocation(0,0);
        setVisible(true);
            
    }
   @Override
public void actionPerformed(ActionEvent action) {
    
    if(action.getSource()==deposit){
        String number = amount.getText();
        Date date = new Date();
         if (number.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter amount");
        } else if (!number.matches("%d")) { 
            JOptionPane.showMessageDialog(null, "Please enter a valid positive number");
        } 
        
     
        else {
            try {
                
                connection conn=new connection();
                String query ="INSERT INTO bank( Name ,Password, date, type, amount) VALUES('"+Name+"', '"+password+"', '"+date+"', 'Deposit', '"+number+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+number+"Deposited Successfully");
                setVisible(false);
                new Transactions(password,Name).setVisible(true);
                
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    else if(action.getSource()==back){
        setVisible(false);
        new Transactions(password,Name).setVisible(true);
        
        
    }
    
}
public static void main(String args[]){
new Deposit("","");

}}