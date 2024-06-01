package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**
 * Class represents a login interface for an ATM machine.
 * @author khanh
 */
public class Login extends JFrame implements ActionListener {
    
    JButton login, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    Login() {
        setTitle("AUTOMATED TELLER MACHINE");
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Bank Icon.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);
        
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        add(text);
        
        JLabel cardno = new JLabel("Card No.");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(200, 130, 150, 40);
        add(cardno);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(350, 135, 250, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(200, 200, 250, 40);
        add(pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(350, 205, 250, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);
        
        login = new JButton("SIGN IN");
        login.setBounds(350, 250, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(500, 250, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(350, 300, 250, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);
        
        
        getContentPane().setBackground(Color.WHITE);
       
        
        setSize(800,450);
        setVisible(true);
        setLocation(350,200);
        
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");
        } 
        else if(ae.getSource() == login) {
            Conn conn = new Conn();
            String cardNumber = cardTextField.getText();
            String pinNumber = pinTextField.getText();
            String query = "select * from login where cardNumber = '"+cardNumber+"' and pin = '"+pinNumber+"'";
            try {
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number of Pin");
                }
            }
            catch(Exception e) {
                System.out.println(e);
            }
            
        }
        else if(ae.getSource() == signup) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Login();// TODO code application logic here
    }
    
}
