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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class windowSupprimer extends JFrame {
	JWindow w ;
	JPanel p;
	JLabel l ;
	@SuppressWarnings("rawtypes")
	JComboBox c1;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	windowSupprimer() {
		w = new JWindow(this); 
		p  = new JPanel();
        String[] arr = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
  
        l = new JLabel("recherche Num"); 
        l.setForeground(Color.red);
        
		c1 = new JComboBox(arr);
        c1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				
		        if (e.getSource() == c1) { 
		        	int res= JOptionPane.showConfirmDialog(null, "confirmer vous la suppression");
		        	if (res == 0) return;
		        	
		        	try {
						Pilote.deleteFromDb(Integer.parseInt((String) c1.getSelectedItem()));
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
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
