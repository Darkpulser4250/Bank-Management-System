package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JLabel label1, label2, label3;
    JTextField textField2;
    JPasswordField passwordField3;

    JButton button1,button2,button3;
    Login(){
        super("Bank Management System");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,10,100,100);
        add(image);

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image ii2 = ii1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        iimage.setBounds(630,350,100,100);
        add(iimage);

        label1 = new JLabel("WELCOME TO ATM");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 38));
        label1.setBounds(230,125,450,40);
        add(label1);

        label2 = new JLabel("Card No:");
        label2.setFont(new Font("Ralway", Font.BOLD, 28));
        label2.setForeground(Color.WHITE);
        label2.setBounds(150,190,375,30);
        add(label2);

        textField2 = new JTextField(15);
        textField2.setBounds(325,190,230,30);
        textField2.setFont(new Font("Arial", Font.BOLD,14));
        add(textField2);

        label3 = new JLabel("PIN: ");
        label3.setFont(new Font("Ralway", Font.BOLD, 28));
        label3.setForeground(Color.WHITE);
        label3.setBounds(150,250,375,30);
        add(label3);

        passwordField3 = new JPasswordField(15);
        passwordField3.setBounds(325,250,230,30);
        passwordField3.setFont(new Font("Arial", Font.BOLD, 14));
        add(passwordField3);

        button1 = new JButton("SIGN IN");
        button1.setFont(new Font("Arial", Font.BOLD, 14));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        button1.setBounds(300,300,100, 30);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("CLEAR");
        button2.setFont(new Font("Arial", Font.BOLD, 14));
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.setBounds(430,300,100, 30);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("SIGN UP");
        button3.setFont(new Font("Arial", Font.BOLD, 14));
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.BLACK);
        button3.setBounds(300,350,230, 30);
        button3.addActionListener(this);
        add(button3);

        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
        Image iii2 = iii1.getImage().getScaledInstance(850,480,Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel iiimage = new JLabel(iii3);
        iiimage.setBounds(0,0,850,480);
        add(iiimage);


        setLayout(null);
        setSize(850,480);
        setLocation(450,200);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if (e.getSource()==button1){
                Connn c = new Connn();
                String cardno = textField2.getText();
                String pin = passwordField3.getText();
                String q = "select * from login where card_number = '"+cardno+"' and  pin = '"+pin+"'";
                ResultSet resultSet = c.statement.executeQuery(q);
                if (resultSet.next()){
                    setVisible(false);
                    new main_Class(pin);
                }else {
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or PIN");
                }


            }else if (e.getSource() == button2){
                textField2.setText("");
                passwordField3.setText("");
            }else if (e.getSource() == button3){
                new Signup();
                setVisible(false);
            }
        }catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Login();
    }
}




















/*
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener { //JFrame is used in swing package used for gui
//    Text Fields
    JLabel label_Greeting, card_Num, pin; // Global Declare

//    Input Fields
    JTextField card_Num_Field;
    JPasswordField pin_Field;

//  Buttons
    JButton sign_Up_Button, clear_Button, sign_In_Button;

    Login(){ // Login Constructor
        super("Bank System Management System"); // Window Name ~ always keep under the constructor name or else you get error

//      Image bank logo
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image i1_image = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT); //scaling the loaded image
        ImageIcon i1_imageIcon = new ImageIcon(i1_image); //make visible on frame
        JLabel image = new JLabel(i1_imageIcon);
        image.setBounds(350,10,100,100);
        add(image); //add image to the frame

//      Image2 card hand
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("icons/card.png"));
        Image i2_image = i2.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT); //scaling the loaded image
        ImageIcon i2_imageIcon = new ImageIcon(i2_image); //make visible on frame
        JLabel image_2 = new JLabel(i2_imageIcon);
        image_2.setBounds(630,350,100,100);
        add(image_2); //add image to the frame

        label_Greeting = new JLabel("WELCOME TO ATM"); //label is used to add texts field
        label_Greeting.setForeground(Color.BLACK); //Set label color
        label_Greeting.setFont(new Font("AvantGarde", Font.BOLD, 38));
        label_Greeting.setBounds(230,125,450,40);
        add(label_Greeting);

        card_Num = new JLabel("Card Num: ");
        card_Num.setForeground(Color.BLACK); //Set label color
        card_Num.setFont(new Font("Ralway", Font.BOLD, 28));
        card_Num.setBounds(150,190,375,30);
        add(card_Num);

        pin = new JLabel("Pin: ");
        pin.setForeground(Color.BLACK); //Set label color
        pin.setFont(new Font("Ralway", Font.BOLD, 28));
        pin.setBounds(150,250,375,30);
        add(pin);

        //User Input Card_Num
        card_Num_Field = new JTextField(15);
        card_Num_Field.setBounds(325,190,230,30);
        card_Num_Field.setFont(new Font("Arial", Font.BOLD, 14));
        add(card_Num_Field);

        //User Input Pin
        pin_Field = new JPasswordField(15);
        pin_Field.setBounds(325,250,230,30);
        pin_Field.setFont(new Font("Arial", Font.BOLD, 14));
        add(pin_Field);

        // Sign_in set up
        sign_In_Button = new JButton("Sign In");
        sign_In_Button.setFont(new Font("Arial", Font.BOLD, 14));
        sign_In_Button.setForeground(Color.YELLOW);
        sign_In_Button.setBackground(Color.BLACK);
        sign_In_Button.setBounds(324,300,100,30);
        sign_In_Button.addActionListener(this);
        add(sign_In_Button);

        //clear_Button set up
        clear_Button = new JButton("Clear");
        clear_Button.setFont(new Font("Arial", Font.BOLD, 14));
        clear_Button.setForeground(Color.YELLOW);
        clear_Button.setBackground(Color.BLACK);
        clear_Button.setBounds(455,300,100,30);
        clear_Button.addActionListener(this);
        add(clear_Button);

        //Sign_up set up
        sign_Up_Button = new JButton("Sign Up");
        sign_Up_Button.setFont(new Font("Arial", Font.BOLD, 14));
        sign_Up_Button.setForeground(Color.YELLOW);
        sign_Up_Button.setBackground(Color.BLACK);
        sign_Up_Button.setBounds(324,350,230,40);
        sign_Up_Button.addActionListener(this);
        add(sign_Up_Button);

//      Image3 Background
        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icons/backbg.png"));
        Image i3_image = i3.getImage().getScaledInstance(850,480, Image.SCALE_DEFAULT); //scaling the loaded image
        ImageIcon i3_imageIcon = new ImageIcon(i3_image); //make visible on frame
        JLabel image_3 = new JLabel(i3_imageIcon);
        image_3.setBounds(0,0,850,480);
        add(image_3); //add image to the frame


        setLayout(null);
        setSize(850,480);
        setLocation(320,200); // set the location of the frame to the middle or location of your choice on the screen when it pops up
        setVisible(true); // without this frame is invisible by default ~ needs to be below the image you want in your frame
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if (e.getSource() == sign_In_Button){

            }
            else if (e.getSource() == clear_Button){
                card_Num_Field.setText("");
                pin_Field.setText("");
            }
            else if (e.getSource() == sign_Up_Button){

            }
        }
            catch (Exception E){
                E.printStackTrace();
            }
    }

    public static void main(String[] args) {
        new Login(); //Login Object

    }
}
*/
