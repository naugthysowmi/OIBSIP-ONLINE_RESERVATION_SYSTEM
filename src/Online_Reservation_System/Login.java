package Online_Reservation_System;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login {
	
	JFrame login_page;
	JLabel user_id, password,comment;
	JTextField id;
	JPasswordField passcode;
	JButton submit,new_register;
	signup sp;
	
	Connection con;
	
	Login() throws SQLException{
		

		String host = "jdbc:mysql://localhost:3307/onlinereservationsystem";
		String username="root";
		String passwor="";
		
		con=DriverManager.getConnection(host,username,passwor);
		
		login_page = new JFrame();
		
		try {
			login_page.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("D:\\App Icons\\rybrand-1656472974.png")))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		login_page.pack();
		login_page.setSize(1650, 1080);
		login_page.setLayout(null);
		user_id = new JLabel("Enter the Login Id: ");
		user_id.setBounds(450, 300, 200, 50);
		user_id.setFont(new Font("TimesNewRoman",Font.BOLD,20));
		
		password = new JLabel("Password: ");
		password.setBounds(525, 350, 200, 50);
		password.setFont(new Font("TimesNewRoman",Font.BOLD,20));
		
		new_register = new JButton("Sign up, click here");
		new_register.setBounds(650,500,200,40);
		new_register.setFont(new Font("TimesNewRoman",Font.BOLD,15));
		new_register.setBackground(Color.GREEN);
		new_register.setForeground(Color.black);
		
		id = new JTextField();
		id.setBounds(650,312,250,30);
		id.setFont(new Font("TimesNewRoman",Font.PLAIN,15));
		
		passcode = new JPasswordField();
		passcode.setBounds(650,362,250,30);
		passcode.setFont(new Font("TimesNewRoman",Font.PLAIN,15));
		
		submit = new JButton("Login");
		submit.setBounds(700,450,100,40);
		submit.setFont(new Font("TimesNewRoman",Font.BOLD,20));
		submit.setBackground(Color.blue);
		submit.setForeground(Color.white);
		
		
		new_register.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					sp = new signup();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}	
		});
		
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String usn=id.getText().toString();
				String pass = String.valueOf(passcode.getPassword());
				ResultSet rs;
				
				try {
					PreparedStatement ps = con.prepareStatement("Select * from login where id = ?");
					ps.setString(1, usn);
					rs=ps.executeQuery();
					rs.next();
					
					if(rs.getString(1).equals(usn)&& rs.getString(2).equals(pass)) {
						Home h=new Home();
					}	
					else {
						JOptionPane.showMessageDialog(null,"Incorrect Password");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"Incorrect User Name or Password");
				}		
			}
		});
		
		
		
		login_page.add(user_id);
		login_page.add(password);
		login_page.add(id);
		login_page.add(passcode);
		login_page.add(submit);
		login_page.add(new_register);
		login_page.setVisible(true);
	}

}
