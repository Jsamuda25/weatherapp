package Converter;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WeatherLogin extends JFrame implements ActionListener {
ImageIcon img,scaledimg;
JLabel imglabel;
JLabel user, password;
JTextField userin;
JPasswordField passwordin;
JPanel imgpanel, buttonpanel,panelleft, panelright, paneloverall, inputPassword, inputUsername;
JButton signin, exit;
String username = new String (Integer.toString(451912));
String pass = new String ("good");


	
	public WeatherLogin(){
	buttonpanel = new JPanel();
	imgpanel = new JPanel();	
	panelleft = new JPanel();
	panelright = new JPanel();
	paneloverall = new JPanel();
	
	// labels 
	user = new JLabel("Username (Card Number):");
	user.setAlignmentX(Component.CENTER_ALIGNMENT);
	password = new JLabel ("Password");
	password.setAlignmentX(Component.CENTER_ALIGNMENT);
	imglabel = new JLabel();
	
	
	//panel for text and passwordfields
	inputPassword = new JPanel();
	inputUsername = new JPanel();
	userin = new JTextField(15);
	passwordin = new JPasswordField(15);
	passwordin.addActionListener(this);
	userin.addActionListener(this);
	inputUsername.add(userin);
	inputPassword.add(passwordin);
	
	
	// buttons
	signin = new JButton("Sign In");
	exit = new JButton ("Exit");
	signin.addActionListener(this);
	exit.addActionListener(this);
	
	// panel for buttons at the bottom
	buttonpanel.add(signin);
	buttonpanel.add(exit);
	
	// adding image
	img = new ImageIcon(getClass().getResource("weather.jpg"));
	imglabel.setIcon(img);
	
	// panel to the left with image
	imgpanel.add(imglabel);
	panelleft.add(imgpanel);

	
	// panel beside image
	panelright.setLayout(new BoxLayout(panelright, BoxLayout.Y_AXIS));
	panelright.add(user);
	panelright.add(inputUsername);
	panelright.add(password);
	panelright.add(inputPassword);
	panelright.add(buttonpanel);
	
	// panel overall
	paneloverall.setLayout(new BoxLayout (paneloverall, BoxLayout.X_AXIS));
	paneloverall.add(panelleft);
	paneloverall.add(panelright);
	paneloverall.setBorder(BorderFactory.createLineBorder(Color.black));
	
	Dimension d = new Dimension(450, 240);
	paneloverall.setPreferredSize(d);
	
	setVisible(true);
	setTitle("Weather Converter");
	setContentPane(paneloverall);
	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	pack();
	

	}
	public void actionPerformed(ActionEvent e){
	
		if (e.getSource() == exit){
			
			JOptionPane.showMessageDialog(null, "Thank you for choosing Weather Converter!","Weather Converter", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
	
	else if ( (userin.getText().equals(username )) && ( (new String(passwordin.getPassword())).equals(pass))){
				
			
			JOptionPane.showMessageDialog(null, "You have successfully logged in!","Weather Converter", JOptionPane.INFORMATION_MESSAGE);
		new TwoWayConversion();
		setVisible(false);	
			
		}
		
		else if (!(userin.getText().equals(username)) ||	! (new String(passwordin.getPassword())).equals(pass)){
			
			JOptionPane.showMessageDialog(null, "The username/password you entered is incorrect!","Weather Converter", JOptionPane.ERROR_MESSAGE);
		}
		}
		
	
	public static void main(String[] args) {
		new WeatherLogin();
		}
}

