
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {

    String pinnumber;
    MiniStatement(String pinnumber){
        
        this.pinnumber = pinnumber;
        setLayout(null);
        
        JLabel mini = new JLabel();
        add(mini);
        
        JLabel bank = new JLabel("State Bank Of India");
        bank.setBounds(130,20,200,20);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20,80,400,20);
        add(card);
       
        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("Select * from login where pin = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number: " +rs.getString("cardnumber").substring(0,4) +"xxxxxxxx" +rs.getString("cardnumber").substring(12));
            
            }
            
        }catch(Exception e){
            
            System.out.println(e);
        }
        
        try{
            Conn conn = new Conn();
            int bal =0;
            ResultSet rs = conn.s.executeQuery("Select * from bank where pin = '"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText() +"<html>"+ rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type")  + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
            if(rs.getString("type").equals("Deposit")){
                     
                     bal += Integer.parseInt(rs.getString("amount"));
                     
                 }else{
                     bal -= Integer.parseInt(rs.getString("amount"));
                 }
               }
            balance.setText("Your Current Account Balance is Rs. "+bal);
        }catch(Exception e){
            System.out.println(e);
        }
        
        mini.setBounds(20,140,400,200);
        
        setTitle("MiniStatement");
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        
        
    }
    
    public static void main(String args[]) {
       
        new MiniStatement("");
    }
}
