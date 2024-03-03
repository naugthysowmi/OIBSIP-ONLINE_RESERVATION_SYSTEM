package Online_Reservation_System;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class reservation_UI {
	
	JFrame reserve;
	JLabel name,age,gender,phno,date,pass_cout,tcls,from,to,train_avai;
	JTextField bname,bage,bphno,bdate,bpass_cout,bfrom,bto;
	JComboBox<String[]> bgender,btcls,btrain_avai;
	String gen[]= {"Male","Female","Others"};
	String cls[]= {"First Class AC","Second Class AC","Slepper","General"};
	ArrayList<String> avai;
	JButton breserve,bcheck;
	Connection con;
	Random rand;
	int cout;
	
	reservation_UI() throws SQLException{
		
		String host = "jdbc:mysql://localhost:3307/onlinereservationsystem";
		String username="root";
		String passwor="";
		con=DriverManager.getConnection(host,username,passwor);
		
		rand = new Random();
		
		avai = new ArrayList<String>();
		
		reserve = new JFrame();
		try {
			reserve.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Hariharan S\\Downloads\\202648-plain-light-color-background.jpg")))));
			}
			catch(Exception e) {
				System.out.println(e);
		}
		reserve.setSize(1650,1080);
		reserve.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		reserve.setLayout(null);
		
		
		name = new JLabel("Name");
		age = new JLabel("Age");
		gender = new JLabel("Gender");
		phno = new JLabel("Phno");
		date = new JLabel("Date of travel");
		pass_cout = new JLabel("Passenger count");
		tcls = new JLabel("Reservation class");
		from = new JLabel("Place of departure");
		to = new JLabel("Place of destination");
		train_avai = new JLabel("Train Availability");
		
		bname = new JTextField();
		bage = new JTextField();
		bgender = new JComboBox(gen);
		bphno = new JTextField();
		bdate = new JTextField();
		bpass_cout = new JTextField();
		btcls = new JComboBox(cls);
		bfrom = new JTextField();
		bto = new JTextField();
		breserve = new JButton("Reserve");
		bcheck = new JButton("Check");
		btrain_avai = new JComboBox();
		
		
		name.setBounds(100,100,100,30);
		age.setBounds(100,180,100,30);
		gender.setBounds(100,260,200,30);
		phno.setBounds(100,340,200,30);
		date.setBounds(100,420,200,30);
		pass_cout.setBounds(100,500,200,30);
		tcls.setBounds(100,580,200,30);
		from.setBounds(700,100,200,30);
		to.setBounds(700,180,200,30);
		train_avai.setBounds(700,350,200,30);
		
		bname.setBounds(100,130,300,30);
		bage.setBounds(100,210,100,30);
		bgender.setBounds(100,290,200,30);
		bphno.setBounds(100,370,200,30);
		bdate.setBounds(100,450,150,30);
		bpass_cout.setBounds(100,530,100,30);
		btcls.setBounds(100,610,200,30);
		bfrom.setBounds(700,130,300,30);
		bto.setBounds(700,210,300,30);
		breserve.setBounds(620, 680,200,50);
		bcheck.setBounds(760,280,100,30);
		btrain_avai.setBounds(700,380,700,50);
		
		name.setFont(new Font("TimesNewRoman",Font.BOLD,20));
		age.setFont(new Font("TimesNewRoman",Font.BOLD,20));
		gender.setFont(new Font("TimesNewRoman",Font.BOLD,20));
		phno.setFont(new Font("TimesNewRoman",Font.BOLD,20));
		date.setFont(new Font("TimesNewRoman",Font.BOLD,20));
		pass_cout.setFont(new Font("TimesNewRoman",Font.BOLD,20));
		tcls.setFont(new Font("TimesNewRoman",Font.BOLD,20));
		from.setFont(new Font("TimesNewRoman",Font.BOLD,20));
		to.setFont(new Font("TimesNewRoman",Font.BOLD,20));
		bcheck.setFont(new Font("TimesNewRoman",Font.BOLD,15));
		train_avai.setFont(new Font("TimesNewRoman",Font.BOLD,20));
		btrain_avai.setFont(new Font("TimesNewRoman",Font.BOLD,15));
		
		bname.setFont(new Font("TimesNewRoman",Font.BOLD,15));
		bage.setFont(new Font("TimesNewRoman",Font.BOLD,15));
		bgender.setFont(new Font("TimesNewRoman",Font.BOLD,15));
		bphno.setFont(new Font("TimesNewRoman",Font.BOLD,15));
		bdate.setFont(new Font("TimesNewRoman",Font.BOLD,15));
		bpass_cout.setFont(new Font("TimesNewRoman",Font.BOLD,15));
		btcls.setFont(new Font("TimesNewRoman",Font.BOLD,15));
		bfrom.setFont(new Font("TimesNewRoman",Font.BOLD,15));
		bto.setFont(new Font("TimesNewRoman",Font.BOLD,15));
		
		bcheck.setBackground(Color.red);
		bcheck.setForeground(Color.white);
		breserve.setBackground(Color.green);
		breserve.setForeground(Color.black);
		
		train_avai.setVisible(false);
		btrain_avai.setVisible(false);
		
		
		breserve.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String name = bname.getText().toString();
				int age = Integer.parseInt(bage.getText().toString());
				String gender = bgender.getSelectedItem().toString();
				String phno = bphno.getText().toString();
				String date = bdate.getText().toString();
				int pass_cout = Integer.parseInt(bpass_cout.getText().toString());
				String cls = btcls.getSelectedItem().toString();
				String departure = bfrom.getText().toString();
				String destination = bto.getText().toString();
				int pnr= rand.nextInt(1899999);
				cout = btrain_avai.getSelectedIndex();
				ResultSet rs;
				String train_name="";
				String train_number="";
				String time_dep="";
				
				try {
					PreparedStatement ps = con.prepareStatement("SELECT * FROM train WHERE departure = ? AND destination = ?");
					ps.setString(1, bfrom.getText().toString());
					ps.setString(2, bto.getText().toString());
					rs=ps.executeQuery();
					System.out.println(cout);
					rs.next();
					for(int i=0;i<cout;i++) rs.next();
					train_name=rs.getString(1);
					train_number= rs.getString(2);
					time_dep=rs.getString(5);
					
				}
				catch(Exception e1){
					System.out.println(e1);
				}
				
				
				try {
					PreparedStatement ps =con.prepareStatement("INSERT INTO reservation VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
					ps.setString(1, name);
					ps.setInt(2, age);
					ps.setString(3,gender);
					ps.setString(4, phno);
					ps.setString(5, date);
					ps.setInt(6, pass_cout);
					ps.setString(7, cls);
					ps.setString(8, departure);
					ps.setString(9, destination);
					ps.setString(10, time_dep);
					ps.setString(11, Integer.toString(pnr));
					ps.setString(12, train_name);
					ps.setString(13, train_number);
					ps.execute();
					
					
				} 
				catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null, "Your Ticket reserved Successfully, Your PNR NO : "+pnr);
				
			}
		});
		
		bcheck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				train_avai.setVisible(true);
				btrain_avai.setVisible(true);
				ResultSet rs;
				avai.clear();
				try {
					PreparedStatement ps = con.prepareStatement("SELECT * FROM train WHERE departure = ? AND destination = ?");
					ps.setString(1, bfrom.getText().toString());
					ps.setString(2, bto.getText().toString());
					rs=ps.executeQuery();
				
					while(rs.next()) {
						String state = rs.getString(1) +"-"+rs.getString(2)+" (Departurue Time:"+rs.getString(5)+" && Reach Time:"+rs.getString(6)+")";
						avai.add(state);
					}
					
					int len = avai.size();
					String[] train = new String[len];
					for(int i=0;i<len;i++) train[i]=avai.get(i);
					for(int i=0;i<train.length;i++) btrain_avai.setModel(new DefaultComboBoxModel(train));
					
					
				} 
				catch (SQLException e1) {
					System.out.println("Error occured");
				}
				
			}
			
		});
		
		reserve.add(name);
		reserve.add(age);
		reserve.add(gender);
		reserve.add(phno);
		reserve.add(date);
		reserve.add(pass_cout);
		reserve.add(tcls);
		reserve.add(from);
		reserve.add(to);
		reserve.add(bcheck);
		reserve.add(bname);
		reserve.add(bage);
		reserve.add(bgender);
		reserve.add(bphno);
		reserve.add(bdate);
		reserve.add(bpass_cout);
		reserve.add(btcls);
		reserve.add(bfrom);
		reserve.add(bto);
		reserve.add(breserve);
		reserve.add(train_avai);
		reserve.add(btrain_avai);
		
		reserve.setVisible(true);
	}

}
