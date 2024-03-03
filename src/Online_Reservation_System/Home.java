package Online_Reservation_System;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.io.File;
import javax.swing.ImageIcon;
public class Home {
	
	Home(){
		JFrame home = new JFrame();
		try {
		home.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("D:\\App Icons\\screenshot-20211222-035405-galle.jpg")))));
		}
		catch(Exception e) {
			System.out.println(e);
		}
		home.setSize(1650,1080);
		home.setLayout(null);
		
		JButton register=new JButton("Reservation Form");
		register.setBounds(550,200,350,50);
		register.setFont(new Font("TimesNewRoman",Font.BOLD,20));
		register.setBackground(Color.blue);
		register.setForeground(Color.white);
		JButton cancellation = new JButton("Cancellation Form");
		cancellation.setBounds(550,300,350,50);
		cancellation.setFont(new Font("TimesNewRoman",Font.BOLD,20));
		cancellation.setBackground(Color.red);
		cancellation.setForeground(Color.white);
		
		register.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					reservation_UI re=new reservation_UI();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		cancellation.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Cancellation cancel=new Cancellation();
				}
				catch(Exception e2) {
					System.out.println(e2);
				}
			}
			
		});
		
		home.add(register);
		home.add(cancellation);
		home.setVisible(true);
	}
	

}
