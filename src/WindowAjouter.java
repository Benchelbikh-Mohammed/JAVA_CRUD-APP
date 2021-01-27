import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JWindow;

public class WindowAjouter extends JFrame implements ActionListener{
	
	JButton sub ;
	JWindow w ;
	JPanel p ;
	JTextField nomField ;
	JTextField prenomField;
	JLabel nomLabel , mno;
	
	
	public WindowAjouter() {
		
	   	 
   	 	w = new JWindow(this); 
   	 	p = new JPanel();
   	 	
   	 	nomLabel = new JLabel("nom Pilote"); 
   	 	nomLabel.setFont(new Font("Arial", Font.PLAIN, 15));  
     	p.add(nomLabel); 
     	
     	
	 	nomField = new JTextField(20);
	 	nomField.setFont(new Font("Arial", Font.PLAIN, 15));  
	    p.add(nomField);
	    nomField.addActionListener(this);
	    
	    
	    mno = new JLabel("prenom pilote"); 
        mno.setFont(new Font("Arial", Font.PLAIN, 15)); 
        p.add(mno); 
	 	
	 	
	 	prenomField = new JTextField(20);
	 	prenomField.setFont(new Font("Arial", Font.PLAIN, 15)); 
        prenomField.setSize(150, 20); 
        prenomField.setLocation(200, 150);
	 	p.add(prenomField);
	 	
  	
	 	sub = new JButton("Submit"); 
        sub.setFont(new Font("Arial", Font.PLAIN, 15)); 
        sub.setSize(100, 20); 
        sub.setLocation(150, 450); 
        sub.addActionListener(this); 
        p.add(sub);
   	 	
        w.add(p); 

        // setsize of window 
        w.setSize(400, 400);
        // set visibility of window 
        w.setVisible(true); 
        
        // set location of window 
        w.setLocation(900, 100);
   	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			Pilote.insertToDb(nomField.getText(), prenomField.getText());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
	
	
}
