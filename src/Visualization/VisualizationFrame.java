package Visualization;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.BorderLayout;

public class VisualizationFrame {

	private JFrame frame;
	private int N, B;
	
	/**
	 * Create the application.
	 */
	public VisualizationFrame(int N, int B) {
		this.N = N;
		this.B = B;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaption);
		frame.setBounds(100, 100, 679, 490);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		/* Initial panel has our input array. */
		
		JPanel initialPanel = new JPanel();
		initialPanel.setBackground(SystemColor.inactiveCaption);
		initialPanel.setBounds(10, 11, 643, 63);
		frame.getContentPane().add(initialPanel);
		initialPanel.setLayout(new BoxLayout(initialPanel, BoxLayout.X_AXIS));
		initialPanel.setBorder(BorderFactory.createLineBorder(Color.red));
		
		/* enterPass0Panel only contains a button. */
		
		JPanel enterPass0Panel = new JPanel();
		enterPass0Panel.setBackground(SystemColor.inactiveCaption);
		enterPass0Panel.setBounds(10, 85, 643, 38);
		frame.getContentPane().add(enterPass0Panel);
		enterPass0Panel.setLayout(new BorderLayout(0, 0));
		
		/* btnEnterPass0 enters you in first pass of external merge sort. */
		
		JButton btnEnterPass0 = new JButton("Enter Pass 0");
		enterPass0Panel.add(btnEnterPass0, BorderLayout.CENTER);
		btnEnterPass0.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		/* Keeping an ArrayList with panels (panels = array's pages). */
		
		ArrayList<JPanel> array = new ArrayList<JPanel>();
		
		/* Keeping an ArrayList with records' text fields. */
		
		ArrayList<JTextField> records = new ArrayList<JTextField>();
		
		for(int i=0;i<N;i++) {
			
			/* Add new page. */
			
			array.add(new JPanel());
			
			/* Visualization with 2 records. */
			
			JTextField rec1 = new JTextField("");
			JTextField rec2 = new JTextField("");
			
			/* Setting records' appearance. */
			
			setRecordAppearance(rec1);
			setRecordAppearance(rec2);
			
			/* Keeping records' text fields in ArrayList. */
			
			records.add(rec1);
			records.add(rec2);
			
			/* Add records' text fields in page. */
			
			array.get(i).add(rec1);
			array.get(i).add(Box.createRigidArea(new Dimension(3,0)));
			array.get(i).add(rec2);
			
			/* Centerize */
			
			array.get(i).setAlignmentX(Component.CENTER_ALIGNMENT);
			
			/* Adding page to array panel. */
			
			initialPanel.add(array.get(i));
			
			array.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
			
			array.get(i).add(Box.createRigidArea(new Dimension(10,0)));

		}	
		
	}
	
	private void setRecordAppearance(JTextField rec) {
		
		/* This method sets specific appearance for records' text fields. */
		
		Font font = new Font("SansSerif", Font.BOLD, 18);
		
		rec.setFont(font);
		rec.setHorizontalAlignment(JTextField.CENTER);
		rec.setPreferredSize(new Dimension(40,33));
		rec.setMaximumSize(new Dimension(rec.getPreferredSize()));
		
	}
	

}