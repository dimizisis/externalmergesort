package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import Visualization.VisualizationFrame;

import javax.swing.DefaultComboBoxModel;

public class StartFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartFrame window = new StartFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StartFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 321, 225);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnStart = new JButton("Start");
		btnStart.setBounds(101, 152, 89, 23);
		frame.getContentPane().add(btnStart);
		
		JComboBox<String> bValue = new JComboBox<String>();
		bValue.setEnabled(false);
		bValue.setModel(new DefaultComboBoxModel<String>(new String[] {"3"}));
		bValue.setBounds(101, 56, 141, 20);
		frame.getContentPane().add(bValue);
		
		JLabel lblSelectB = new JLabel("Select B:");
		lblSelectB.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectB.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblSelectB.setBounds(10, 53, 81, 23);
		frame.getContentPane().add(lblSelectB);
		
		JLabel lblSelectN = new JLabel("Select N:");
		lblSelectN.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectN.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblSelectN.setBounds(10, 87, 81, 23);
		frame.getContentPane().add(lblSelectN);
		
		JComboBox<String> nValue = new JComboBox<String>();
		nValue.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8"}));
		nValue.setBounds(101, 90, 141, 20);
		frame.getContentPane().add(nValue);
		
		/* Open visualization frame. */
		
		btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               frame.dispose();
               new VisualizationFrame(Integer.parseInt((String)nValue.getSelectedItem()), Integer.parseInt((String)bValue.getSelectedItem()));
            }
        });
	}

}
