import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class windowModifier extends JFrame {
	
	JWindow w ;
	JPanel p;
	JLabel l ;
	@SuppressWarnings("rawtypes")
	JComboBox c1;
	TextField nomField ;
	TextField prenomField;
	JButton sub ;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	windowModifier() {
		
		w = new JWindow(this); 
		
		
		
		p  = new JPanel();
		
		// array of string contating cities 
        String[] arr = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
  
        l = new JLabel("recherche Num"); 
        l.setForeground(Color.red);
        
        
		c1 = new JComboBox(arr);
        
		nomField = new TextField(20);
        prenomField = new TextField(20);
        
  
        // add ItemListener 
        c1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				
		        if (e.getSource() == c1) { 
		  
		            try {
						nomField.setText(Pilote.getOneRow(Integer.parseInt((String) c1.getSelectedItem()))[0]);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		            try {
						prenomField.setText(Pilote.getOneRow(Integer.parseInt((String) c1.getSelectedItem()))[1]);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		        } 
				
			}
        	
        }); 
        

   	 	GridBagConstraints c = new GridBagConstraints();
     	c.gridwidth = GridBagConstraints.REMAINDER;

     	c.fill = GridBagConstraints.HORIZONTAL;
     	p.add(l);
     	p.add(c1 , c);
     	p.add(nomField, c);
     	p.add(prenomField, c);
     	
     	
     	sub = new JButton("Submit"); 
        sub.setFont(new Font("Arial", Font.PLAIN, 15)); 
        sub.setSize(100, 20); 
        sub.setLocation(150, 450); 
        sub.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Pilote.UpdateRowDb(Integer.parseInt((String) c1.getSelectedItem()), nomField.getText(), prenomField.getText());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
				
			}
		}); 
        p.add(sub);
        
        
        w.add(p); 

        // setsize of window 
        w.setSize(400, 400);
        // set visibility of window 
        w.setVisible(true); 
        
        // set location of window 
        w.setLocation(900, 100);
     	
//  
	}

	

}
