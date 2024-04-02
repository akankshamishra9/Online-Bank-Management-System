
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener{
    
    
    JTextField panTextField,aadharTextField;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,category,income,education,occupation;
     String formno;
    SignupTwo(String formno){
        this.formno = formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway",Font.BOLD,22));
        name.setBounds(100,140,100,30);
        add(name);
        
        String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.white);
        add(religion);
        
        JLabel Category = new JLabel("Category:");
        Category.setFont(new Font("Raleway",Font.BOLD,20));
        Category.setBounds(100,190,200,30);
        add(Category);
        
         String valCategory[]= {"General","OBC","SC","ST","Other"};
         category = new JComboBox(valCategory);
          category.setBounds(300,190,400,30);
          category.setBackground(Color.white);
        add(category);
      
        
        JLabel Income = new JLabel("Income:");
        Income.setFont(new Font("Raleway",Font.BOLD,22));
        Income.setBounds(100,240,200,30);
        add(Income);
        
        String incomeCategory[]= {"Null","<1,50,000","<2,50,000","<5,00,000","upto 10,00,000"};
         income = new JComboBox(incomeCategory);
          income.setBounds(300,240,400,30);
          income.setBackground(Color.white);
        add(income);
        
        
        JLabel Educational = new JLabel("Educational:");
        Educational.setFont(new Font("Raleway",Font.BOLD,22));
        Educational.setBounds(100,290,200,30);
        add(Educational);
        
        
        
        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway",Font.BOLD,22));
        qualification.setBounds(100,315,200,30);
        add(qualification);
        
         String educationValues[]= {"Non Graduation","Graduate","Post-Graduation","Doctorate","Other"};
        education = new JComboBox(educationValues);
          education.setBounds(300,315,400,30);
          education.setBackground(Color.white);
        add(education);
        
        JLabel Occupation = new JLabel("Occupation:");
         Occupation.setFont(new Font("Raleway",Font.BOLD,22));
        Occupation.setBounds(100,390,200,30);
        add(Occupation);
        
        String occupationalValues[]= {"Salaried","Half-Employed","Business","Student","Retired","Other"};
          occupation = new JComboBox(occupationalValues);
          occupation.setBounds(300,390,400,30);
          occupation.setBackground(Color.white);
        add(occupation);
        
        
        
        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway",Font.BOLD,22));
        pan.setBounds(100,440,200,30);
        add(pan);
        
        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,14));
        panTextField.setBounds(300,440,400,30);
        add(panTextField);
        
        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway",Font.BOLD,22));
        aadhar.setBounds(100,490,200,30);
        add(aadhar);
        
        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway",Font.BOLD,14));
        aadharTextField.setBounds(300,490,400,30);
        add(aadharTextField);
        
        JLabel SeniorCitizen = new JLabel("Senior Citizen:");
       SeniorCitizen.setFont(new Font("Raleway",Font.BOLD,22));
       SeniorCitizen.setBounds(100,540,200,30);
        add(SeniorCitizen);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.white);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.white);
        add(sno);
        
        
        ButtonGroup accountgroup = new ButtonGroup();
        accountgroup.add(syes);
       accountgroup.add(sno);
       
        
        JLabel existing = new JLabel("Existing Account:");
        existing.setFont(new Font("Raleway",Font.BOLD,22));
       existing.setBounds(100,590,200,30);
        add(existing);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.white);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.white);
        add(eno);
        
        
        ButtonGroup existgroup = new ButtonGroup();
        existgroup.add(eyes);
       existgroup.add(eno);
         
      
        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
       getContentPane().setBackground(Color.white);
       
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String sreligion = (String)religion.getSelectedItem();
        String scategory = (String)category.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String seducation = (String)education.getSelectedItem();
        String soccupation = (String)occupation.getSelectedItem();
        String seniorCitizen = null;
        if(syes.isSelected()){
            seniorCitizen = "Yes";
        }else if(sno.isSelected()){
            
            seniorCitizen = "No";
        }
       
        String existing = null;
        if(eyes.isSelected()){
            existing = "Yes";
        }else if(eno.isSelected()){
            existing = "No";
        }
        
        String saadhar = aadharTextField.getText();
        String span = panTextField.getText();
       
         
        try{
           
               Conn c = new Conn(); 
               String Query1 = "insert into signuptwo values('"+formno+"', '"+ sreligion +"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+existing+"','"+seniorCitizen+"')";
               c.s.executeUpdate(Query1);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String args[]) {
       new SignupTwo("").setVisible(true);
    }
}
