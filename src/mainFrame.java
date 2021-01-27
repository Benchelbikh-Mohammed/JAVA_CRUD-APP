import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class mainFrame {
	
	private JFrame mainFrame;
	JPanel panel;
	private JMenuBar menuBar;
	private JMenu avionMenu;
	private JMenu piloteMenu;
	
	private mainFrame() {
		mainFrame = new JFrame("Avion/pilote");
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		menuBar = new JMenuBar();
		avionMenu = new JMenu("Avion");
		piloteMenu = new JMenu("Pilote");
		
		setUpAvionMenu();
		setUpPiloteMenu();
		
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		
        
		mainFrame.getContentPane().add(panel);
        mainFrame.setJMenuBar(menuBar);
        
        
        mainFrame.setPreferredSize(new Dimension(800, 400));
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
	}
	
	private void setUpAvionMenu() {
		JMenuItem avionNewMenuItem = new JMenuItem("nouveau");
		JMenuItem avionModifyMenuItem = new JMenuItem("modifier");
		JMenuItem avionDeleteMenuItem = new JMenuItem("supprimer");
		
		avionNewMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		avionModifyMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});

		avionDeleteMenuItem.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
		
			}
		});
		
		
		
		avionMenu.add(avionNewMenuItem);
		avionMenu.add(avionModifyMenuItem);
		avionMenu.add(avionDeleteMenuItem);
	
		menuBar.add(avionMenu);
	}
	
	private void setUpPiloteMenu() {
		JMenuItem piloteNewMenuItem = new JMenuItem("nouveau");
		JMenuItem piloteModifyMenuItem = new JMenuItem("modifier");
		JMenuItem piloteDeleteMenuItem = new JMenuItem("supprimer");
		
		piloteNewMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new WindowAjouter();
			}
		});
		
		piloteModifyMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new windowModifier();
			}
		});

		piloteDeleteMenuItem.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				new windowSupprimer();
			}
		});
		
		piloteMenu.add(piloteNewMenuItem);
		piloteMenu.add(piloteModifyMenuItem);
		piloteMenu.add(piloteDeleteMenuItem);
	
		menuBar.add(piloteMenu);
	}
	
	
	
	
	
	
	
   
  

	
	public static void main(String[] args) throws ClassNotFoundException {
		
		new mainFrame();

	}
	

}
