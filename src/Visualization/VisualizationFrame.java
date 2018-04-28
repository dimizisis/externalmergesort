package Visualization;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
		JPanel btnPassPanel = new JPanel();
		btnPassPanel.setBackground(SystemColor.inactiveCaption);
		btnPassPanel.setBounds(10, 85, 643, 38);
		frame.getContentPane().add(btnPassPanel);
		btnPassPanel.setLayout(new BorderLayout(0, 0));
		
		/* btnEnterPass0 enters you in first pass of external merge sort. */
		
		JButton btnEnterPass0 = new JButton("Enter Pass 0");
		btnPassPanel.add(btnEnterPass0, BorderLayout.CENTER);
		btnEnterPass0.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		JPanel passPanel0 = new JPanel();
		passPanel0.setBackground(SystemColor.inactiveCaption);
		passPanel0.setBounds(10, 134, 643, 83);
		frame.getContentPane().add(passPanel0);
		passPanel0.setLayout(new BoxLayout(passPanel0, BoxLayout.X_AXIS));
		
		/* Keeping an ArrayList with panels (panels = array's pages). */
		
		ArrayList<JPanel> array = new ArrayList<JPanel>();
		
		/* Keeping an ArrayList with records' text fields. */
		
		ArrayList<JTextField> records = new ArrayList<JTextField>();
		
		for(int i=0;i<N;i++) {
			
			/* Add new page. */
			
			array.add(new JPanel());
			
			/* Visualization with 2 records. */
			
			/* Setting records' appearance. */
			
			JTextField tempRec = setRecordAppearance(new JTextField(""));
			
			/* Keeping records' text fields in ArrayList. */
			
			records.add(tempRec);
			
			/* Add records' text fields in page. */
			
			array.get(array.size() - 1).add(tempRec);
			
			/* Adding gap between records text fields. */
			
			array.get(array.size() - 1).add(Box.createRigidArea(new Dimension(3,0)));
			
			/* Setting records' appearance. */
			
			tempRec = setRecordAppearance(new JTextField(""));
			
			/* Add records' text fields in page. */
			
			records.add(tempRec);
			
			/* Add records' text fields in page. */
			
			array.get(array.size() - 1).add(tempRec);
			
			/* Centerize */
			
			array.get(array.size() - 1).setAlignmentX(Component.CENTER_ALIGNMENT);
			
			/* Adding page to array panel. */
			
			initialPanel.add(array.get(array.size() - 1));
			
			/* Black border line for each page of array. */
			
			array.get(array.size() - 1).setBorder(BorderFactory.createLineBorder(Color.black));
			
			/* Adding gap between pages. */
			
			array.get(array.size() - 1).add(Box.createRigidArea(new Dimension(10,0)));

		}
		
		btnEnterPass0.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				for(int i=0;i<N;i++) {
					
					/* Add new page. */
					
					array.add(new JPanel());
					
					array.get(array.size() - 1).setPreferredSize(new Dimension(65,83));
					
					array.get(array.size() - 1).setMaximumSize(new Dimension(array.get(0).getSize()));
					
					array.get(array.size() - 1).setMinimumSize(new Dimension(array.get(0).getSize()));
					
					array.get(array.size() - 1).setLayout(new BoxLayout(array.get(array.size() - 1), BoxLayout.Y_AXIS));
					
					/* Visualization with 2 records. */
					
					/* Setting records' appearance. */
					
					JTextField tempRec = setRecordAppearance(new JTextField(""));
					
					/* Keeping records' text fields in ArrayList. */
					
					records.add(tempRec);
					
					/* Add records' text fields in page. */
					
					array.get(array.size() - 1).add(tempRec);
					
					/* Adding gap between records text fields. */
					
					array.get(array.size() - 1).add(Box.createRigidArea(new Dimension(3,0)));
					
					/* Setting records' appearance. */
					
					tempRec = setRecordAppearance(new JTextField(""));
					
					/* Add records' text fields in page. */
					
					records.add(tempRec);
					
					/* Add records' text fields in page. */
					
					array.get(array.size() - 1).add(tempRec);
					
					/* Centerize */
					
					array.get(array.size() - 1).setAlignmentX(Component.CENTER_ALIGNMENT);
					
					/* Adding page to array panel. */
					
					passPanel0.add(array.get(array.size() - 1));
					
					/* Black border line for each page of array. */
					
					array.get(array.size() - 1).setBorder(BorderFactory.createLineBorder(Color.black));

				}
				
				TestThread b = new TestThread(records,array);
				
			/*	for(int i=0;i<records.size();i++) {
					records.get(i).setText("record"+i);
				} */
		        
				new Thread(b).start();
		            	
		            	
		            }

		});
		
	}
	
	class TestThread implements Runnable{
		
		private ArrayList<JTextField> records;
		private ArrayList<JPanel> array;
		
		public TestThread(ArrayList<JTextField> records, ArrayList<JPanel> array) {
			this.records = records;
			this.array = array;
		}
		

		@Override
		public void run() {
					int i=0;
					while(true){
						
						if (i<=N-1) array.get(i).setBackground(Color.green);
						
						if (i>0) array.get(i-1).setBackground(UIManager.getColor ("Panel.background"));
						
						if (i>=N) break;
						
						int min = Integer.min(Integer.parseInt(records.get(i+i).getText()), Integer.parseInt(records.get(i+i+1).getText()));
						int max = Integer.max(Integer.parseInt(records.get(i+i).getText()), Integer.parseInt(records.get(i+i+1).getText()));
						
						System.out.println(min +" "+max);
						
						Timer timer1;
						Timer timer2;
					        
					    if (records.get(i).getText().equals(String.valueOf(min))) {
					    	timer1 = new Timer(4000, new listener1(i,max,records, i+1));
					    	timer2 = new Timer(2000, new listener2(i,min,records, i));
					    }
					    else {
					    	timer1 = new Timer(4000, new listener1(i,max,records, i));
					    	timer2 = new Timer(2000, new listener2(i,min,records, i+1));
					    }
						
					    timer1.setRepeats(false);
					    timer2.setRepeats(false);
					    timer1.start();
					    timer2.start();
					    
					    try {
							Thread.sleep(4000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					        
					    ++i;

					}
			
		}
		
	}

	class listener1 implements ActionListener {
		
		private int i,max, recIndex;
		private ArrayList<JTextField> recs;
		
		public listener1(int i, int max, ArrayList<JTextField> recs, int recIndex) {
			this.max = max;
			this.i = i;
			this.recs = recs;
			this.recIndex = recIndex;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
		    
		//	recs.get(recIndex).setText("");
			
			if(N==1)
				recs.get(3).setText(String.valueOf(max));
			
			else
				recs.get(2*N+2*i+1).setText(String.valueOf(max));
			
		}
		
	}
	
class listener2 implements ActionListener {
		
		private int i,min,recIndex;
		private ArrayList<JTextField> recs;
		
		public listener2(int i, int min, ArrayList<JTextField> recs, int recIndex) {
			this.min = min;
			this.i = i;
			this.recs = recs;
			this.recIndex = recIndex;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
		//	recs.get(recIndex).setText("");
			
			if (N==1)
				recs.get(2).setText(String.valueOf(min));
			
			else
				recs.get(2*N+2*i).setText(String.valueOf(min));
		}
		
	}
	
	private JTextField setRecordAppearance(JTextField rec) {
		
		/* This method sets specific appearance for records' text fields and returns a JTextField. */
		
		Font font = new Font("SansSerif", Font.BOLD, 18);
		
		rec.setFont(font);
		rec.setHorizontalAlignment(JTextField.CENTER);
		rec.setPreferredSize(new Dimension(40,33));
		rec.setMaximumSize(new Dimension(rec.getPreferredSize()));
		
		return rec;
		
	}
}