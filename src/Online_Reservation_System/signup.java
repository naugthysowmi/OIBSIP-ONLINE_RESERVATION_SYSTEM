package Online_Reservation_System;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class signup {
	
	JFrame login_page;
	JLabel user_id, password,comment,passwordsec;
	JTextField id;
	JPasswordField passcode,passcodesec;
	JButton submit;
	Connection con;
	signup() throws SQLException{
		
		String host = "jdbc:mysql://localhost:3307/onlinereservationsystem";
		String username="root";
		String passwor="";
		
		con=DriverManager.getConnection(host,username,passwor);
		login_page = new JFrame();
		login_page.setSize(1650, 1080);
		login_page.setLayout(null);
		login_page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		user_id = new JLabel("Enter the Login Id: ");
		user_id.setBounds(450, 300, 200, 50);
		user_id.setFont(new Font("TimesNewRoman",Font.BOLD,20));
		
		password = new JLabel("Password: ");
		password.setBounds(525, 350, 200, 50);
		password.setFont(new Font("TimesNewRoman",Font.BOLD,20));
		
		passwordsec = new JLabel("Password: ");
		passwordsec.setBounds(525, 408, 200, 50);
		passwordsec.setFont(new Font("TimesNewRoman",Font.BOLD,20));

		
		id = new JTextField();
		id.setBounds(650,312,250,30);
		id.setFont(new Font("TimesNewRoman",Font.PLAIN,15));
		
		passcode = new JPasswordField();
		passcode.setBounds(650,362,250,30);
		passcode.setFont(new Font("TimesNewRoman",Font.PLAIN,15));
		
		passcodesec = new JPasswordField();
		passcodesec.setBounds(650,420,250,30);
		passcodesec.setFont(new Font("TimesNewRoman",Font.PLAIN,15));
		
		submit = new JButton("Login");
		submit.setBounds(700,500,100,40);
		submit.setFont(new Font("TimesNewRoman",Font.BOLD,20));
		
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String usn = id.getText().toString();
				String pass1= String.valueOf(passcode.getPassword());
				String pass2= String.valueOf(passcodesec.getPassword());
				
				if(pass1.equals(pass2)) {

					try {
						PreparedStatement ps = con.prepareStatement("INSERT INTO LOGIN VALUES(?,?)");
						ps.setString(1, usn);
						ps.setString(2, pass1);
						ps.execute();
						Login l = new Login();
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		
				}
				else {
					JOptionPane.showMessageDialog(null, "Password 1 doesnot matches Password 2");
				}
				
			}
			
		});
		
		
		login_page.add(user_id);
		login_page.add(password);
		login_page.add(id);
		login_page.add(passcode);
		login_page.add(submit);
		login_page.add(passcodesec);
		login_page.add(passwordsec);
		login_page.setVisible(true);
		
	}

}
