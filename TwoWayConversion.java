package Converter;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class TwoWayConversion extends JFrame implements ActionListener {
JLabel title, fahr, cels;
JTextField infahr, incels;
JButton cToF, fToC, clear;
JPanel panel,fortitle, forbuttons, forfahr, forcelcius, forboth;
int degreeFahr, degreeCels;
String inputF, inputC;

	public TwoWayConversion(){
	
		title = new JLabel ("Convert from Fahrenheit to Celcius");
		fahr = new JLabel("Fahreinheit");
		cels = new JLabel("Celcius");
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		infahr = new JTextField(8);
		incels = new JTextField(8);
		infahr.addActionListener(this);
		incels.addActionListener(this);
		
		cToF = new JButton("C-F");
		fToC = new JButton("F-C");
		clear = new JButton ("Clear");
		clear.addActionListener(this);
		cToF.addActionListener(this);
		fToC.addActionListener(this);
		
		forfahr = new JPanel();
		forfahr.setLayout((new BoxLayout(forfahr,BoxLayout.Y_AXIS)));
		fahr.setAlignmentX(Component.CENTER_ALIGNMENT);
		forfahr.add(fahr);
		
		forfahr.add(infahr);
		
		forcelcius =  new JPanel();
		forcelcius.setLayout((new BoxLayout(forcelcius, BoxLayout.Y_AXIS)));
		cels.setAlignmentX(Component.CENTER_ALIGNMENT);
		forcelcius.add(cels);
		forcelcius.add(incels);
		
		forboth = new JPanel();
		forboth.setLayout((new BoxLayout(forboth, BoxLayout.X_AXIS)));
		forboth.add(forfahr);
		forboth.add(forcelcius);
		
		panel = new JPanel();
		fortitle = new JPanel();
		forbuttons = new JPanel();
		fortitle.add(title);
		forbuttons.add(fToC);
		forbuttons.add(cToF);
		forbuttons.add(clear); 
		
		panel.setLayout((new BoxLayout(panel, BoxLayout.Y_AXIS)));
		panel.add(fortitle);
		panel.add(forboth);
		panel.add(forbuttons);   
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int choice = JOptionPane.showConfirmDialog(null, "Are you sure you would like you quit?","",JOptionPane.YES_NO_OPTION);
				if (choice == JOptionPane.YES_OPTION) {
					System.out.println("choice "+choice);
					
					System.exit(0);
				}
			}
		});		
		Dimension d = new Dimension(400, 240);
		panel.setPreferredSize(d);
		setVisible(true);
		setContentPane(panel);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	

		pack();
		
	
		  degreeCels = ((degreeFahr-32) * 5) / 9;
		
		  degreeFahr = degreeCels*9/5 + 32;
	}
	
	
	public void converttoCelcius(){
		 
		      degreeCels = ((degreeFahr-32) * 5) / 9;
		    } 
		
	
	public void converttoFahr(){
		degreeFahr = degreeCels*9/5 + 32;
	}

	
	
	
public void actionPerformed (ActionEvent e){
 
try{
	
if (e.getSource() == fToC){
	inputF = infahr.getText();
	degreeFahr = Integer.parseInt(inputF);
	converttoCelcius();
	incels.setText(Integer.toString(degreeCels) );
	
}

else if (e.getSource() == cToF){
	inputC = incels.getText();
	degreeCels= Integer.parseInt(inputC);
	converttoFahr();
	infahr.setText(Integer.toString(degreeFahr));
	
}
else if (e.getSource() == clear){ 
	infahr.setText("32");
	incels.setText("0");
	
}}
	
catch (NumberFormatException common){
	JOptionPane.showMessageDialog(null, "Enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
	infahr.setText(null);
	incels.setText(null);
}
}

	
	
	public static void main(String[] args) {
new TwoWayConversion();

}



}

