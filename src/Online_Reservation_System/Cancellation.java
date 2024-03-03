package Online_Reservation_System;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Cancellation {
	
	JFrame cancel;
	JLabel PNR;
	JTextField pnr;
	JButton can;
	Connection con;
	
	Cancellation() throws SQLException{
		
		String host = "jdbc:mysql://localhost:3307/onlinereservationsystem";
		String username="root";
		String passwor="";
		con=DriverManager.getConnection(host,username,passwor);
		
		cancel = new JFrame();
		
		cancel.setSize(1650,1080);
		cancel.setLayout(null);
		cancel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
			cancel.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Hariharan S\\Downloads\\gradient-light-color-background-graphic-free-vector (1).jpg")))));
			}
			catch(Exception e) {
				System.out.println(e);
		}
		
		PNR = new JLabel("Enter the PNR No: ");
		pnr = new JTextField();
		can = new JButton("Submit");
		
		PNR.setBounds(600,200,200,50);
		PNR.setFont(new Font("TimesNewRoman",Font.BOLD,20));
		
		pnr.setBounds(600,250,300,30);
		pnr.setFont(new Font("TimesNewRoman",Font.BOLD,15));
		
		can.setBounds(680,300,100,50);
		can.setFont(new Font("TimesNewRoman",Font.BOLD,20));
		can.setBackground(Color.red);
		can.setForeground(Color.white);
		
		can.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					PreparedStatement ps=con.prepareStatement("DELETE FROM reservation WHERE pnr_no = ?");
					ps.setString(1, pnr.getText().toString());
					ps.execute();
				}
				catch (SQLException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Your reservation of PNR no: "+pnr.getText().toString()+" is cancelled successfully");
			}
			
		});
		
		cancel.add(PNR);
		cancel.add(pnr);
		cancel.add(can);
		cancel.setVisible(true);
		
		
	}

}
