package Online_Reservation_System;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {

	public static void main(String[] args) throws SQLException, IOException, InterruptedException {
		
		JFrame intro = new JFrame();
		intro.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("D:\\App Icons\\online-railway-reservation-system-project.jpg")))));
		intro.pack();
		intro.setVisible(true);
		Thread.sleep(5000);
		intro.setVisible(false);
		Login index = new Login();
		
	}

}
