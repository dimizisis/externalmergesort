package Visualization;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;

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
		
		if (B <= N)
			this.B = B;
		else
			this.B = N;
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaption);
		frame.setBounds(100, 100, 950, 490);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		/* Initial panel has our input array. */
		
		JPanel initialPanel = new JPanel();
		initialPanel.setBackground(SystemColor.inactiveCaption);
		initialPanel.setBounds(10, 11, 914, 63);
		frame.getContentPane().add(initialPanel);
		initialPanel.setLayout(new BoxLayout(initialPanel, BoxLayout.X_AXIS));
		initialPanel.setBorder(BorderFactory.createLineBorder(Color.red));
		
		/* enterPass0Panel only contains a button. */
		
		JPanel btnPassPanel0 = new JPanel();
		btnPassPanel0.setBackground(SystemColor.inactiveCaption);
		btnPassPanel0.setBounds(10, 85, 914, 38);
		frame.getContentPane().add(btnPassPanel0);
		btnPassPanel0.setLayout(new BorderLayout(0, 0));
		
		/* btnEnterPass0 enters you in first pass of external merge sort. */
		
		JButton btnEnterPass0 = new JButton("Enter Pass 0");
		btnPassPanel0.add(btnEnterPass0, BorderLayout.CENTER);
		btnEnterPass0.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		JPanel passPanel0 = new JPanel();
		passPanel0.setBackground(SystemColor.inactiveCaption);
		passPanel0.setBounds(10, 134, 914, 83);
		frame.getContentPane().add(passPanel0);
		passPanel0.setLayout(new BoxLayout(passPanel0, BoxLayout.X_AXIS));
		
		JPanel btnPassPanel1 = new JPanel();
		btnPassPanel1.setBounds(10, 228, 914, 38);
		frame.getContentPane().add(btnPassPanel1);
		btnPassPanel1.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("Enter Pass 1");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnPassPanel1.add(btnNewButton, BorderLayout.CENTER);
		
		JPanel passPanel1 = new JPanel();
		passPanel1.setBackground(SystemColor.inactiveCaption);
		passPanel1.setBounds(10, 277, 914, 110);
		frame.getContentPane().add(passPanel1);
		
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
					
					array.get(array.size() - 1).setLayout(new BoxLayout(array.get(array.size() - 1), BoxLayout.X_AXIS));
					
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
				
				/* New thread for first pass visualization. */
				
				TwoWayPassZero twoWayPass0 = new TwoWayPassZero(records,array);
				PassZero pass0 = new PassZero(records,array);
				
				if (B == 3) { 
					
					// Enter pass 0 for B=3 (2-way)
					new Thread(twoWayPass0).start();
				}
				
				else {
					
					new Thread(pass0).start();
				}
		            	
		            	
		            }

		});
		
	}
	
	class TwoWayPassZero implements Runnable{
		
		private ArrayList<JTextField> records;
		private ArrayList<JPanel> array;
		
		public TwoWayPassZero(ArrayList<JTextField> records, ArrayList<JPanel> array) {
			this.records = records;
			this.array = array;
		}
		

		@Override
		public void run() {
			int i=0;
			while(true){
		
				/* If we are not in last page, turn page's panel green. */
				
				if (i<=N-1) array.get(i).setBackground(Color.green);
				
				/* Every time we finish visiting a page, turn default panel color. */
						
				if (i>0) array.get(i-1).setBackground(UIManager.getColor ("Panel.background"));
				
				/* If there are no pages to visit, break. */
						
				if (i>=N) break;
				
				/* Finding min & max for sorting. */
						
				int min = Integer.min(Integer.parseInt(records.get(2*i).getText()), Integer.parseInt(records.get(2*i+1).getText()));
				int max = Integer.max(Integer.parseInt(records.get(2*i).getText()), Integer.parseInt(records.get(2*i+1).getText()));

				/* timer1 for max appearance, timer2 for min appearance. */
				
				Timer timer1;
				Timer timer2;
				
				/* 
				 * Need to know which text field has the minimum & maximum number, in order to clear
				 * the text field, when we "move" the element to pass zero's panel
				 */
					        
			    if (records.get(2*i).getText().equals(String.valueOf(min))) {
			    	timer1 = new Timer(4000, new twoWayPass0ListenerMax(i,max,records, 2*i+1));
					timer2 = new Timer(2000, new twoWayPass0ListenerMin(i,min,records, 2*i));
				}
			    else {
					timer1 = new Timer(4000, new twoWayPass0ListenerMax(i,max,records, 2*i));
					timer2 = new Timer(2000, new twoWayPass0ListenerMin(i,min,records, 2*i+1));
				}
			    
			    /* Starting the timers... */
					
				timer1.setRepeats(false);
				timer2.setRepeats(false);
				timer1.start();
				timer2.start();
				
				/* Thread needs to sleep for 4000 ms = maximum ms for visualization (timer1). */
					    
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// Do nothing...	

				}        
				++i;
			}
		
		}
	}
	
class PassZero implements Runnable{
		
		private ArrayList<JTextField> records;
		private ArrayList<JPanel> array;
		
		public PassZero(ArrayList<JTextField> records, ArrayList<JPanel> array) {
			this.records = records;
			this.array = array;
		}
		

		@Override
		public void run() {
			
			ArrayList<Integer> min = new ArrayList<Integer>();
			ArrayList<Integer> max = new ArrayList<Integer>();
			int i=0;
			while(true){

				/* If there are no pages to visit, break. */
				
				if (i>=N) break;
		
				/* If we are not in last page, turn page's panel green. */
				
				if (i<=N-1) {
					for(int j=i;j<B;++j) {
						
						if (j==N) break;
						
						else array.get(j).setBackground(Color.green);
					}
				}
				else
					array.get(i).setBackground(Color.green);
				
				/* Every time we finish visiting a page, turn default panel color. */
						
				if (i>0) { 
				
					for(int j=i;j<B;++j) {
					
						if (i<0) break;
					
						else {
							try {
								array.get(i-j).setBackground(UIManager.getColor ("Panel.background"));
							}
							catch(Exception e) {
								break;
							}
						}
					
					}
				}
				
				if(i==0) {
				
				/* Finding min & max for sorting. */
					
				for(int j=i;j<B;++j) {
					min.add(Integer.min(Integer.parseInt(records.get(2*j+i).getText()), Integer.parseInt(records.get(i+2*j+1).getText())));
					max.add(Integer.max(Integer.parseInt(records.get(i+2*j).getText()), Integer.parseInt(records.get(i+2*j+1).getText())));
					System.out.println("i: "+i+" j: "+j+" min: "+min.get(min.size()-1)+" max: "+max.get(max.size()-1));
				}	
				
				Collections.sort(min, Collections.reverseOrder());
				Collections.sort(max, Collections.reverseOrder());
				
				}

				/* timer1 for max appearance, timer2 for min appearance. */
				
				Timer timer1;
				Timer timer2;
				
				/* 
				 * Need to know which text field has the minimum & maximum number, in order to clear
				 * the text field, when we "move" the element to pass zero's panel
				 */      
			    	timer1 = new Timer(4000, new pass0ListenerMax(i,max,records, i+i+1));
					timer2 = new Timer(2000, new pass0ListenerMin(i,min,records, i+i));
			    
			    /* Starting the timers... */
					
				timer1.setRepeats(false);
				timer2.setRepeats(false);
				timer1.start();
				timer2.start();
				
				/* Thread needs to sleep for 4000 ms = maximum ms for visualization (timer1). */
					    
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// Do nothing...	

				}        
				++i;
			}
		
		}
	}

class pass0ListenerMax implements ActionListener {
	
	private int recIndex;
	private int i;
	private ArrayList<Integer> max;
	private ArrayList<JTextField> recs;
	
	public  pass0ListenerMax(int i, ArrayList<Integer> max, ArrayList<JTextField> recs, int recIndex) {
		this.max = max;
		this.recs = recs;
		this.recIndex = recIndex;
		this.i = i;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		/* 
		 * When we sort the array, every element is deleted from initial array, and it is
		 * "moved" to pass zero's panel.
		 */
	    
		recs.get(recIndex).setText("");
		
		/* If N==1, we know where we put max. */
		
		if(N==1)
			recs.get(3).setText(String.valueOf(max.get(0)));
		
		/* Else, 2*N+2*i+1 is the function that gives us the position of max text field. */
		
		else {
			recs.get(2*N+2*i+1).setText(String.valueOf(max.get(max.size()-1)));
			max.remove(max.get(max.size()-1));
		}
		
	}
	
}

class pass0ListenerMin implements ActionListener {
	
	private int recIndex;
	private ArrayList<Integer> min;
	private ArrayList<JTextField> recs;
	private int i;
	
	public pass0ListenerMin(int i, ArrayList<Integer> min, ArrayList<JTextField> recs, int recIndex) {
		this.min = min;
		this.recs = recs;
		this.recIndex = recIndex;
		this.i = i;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		/* 
		 * When we sort the array, every element is deleted from initial array, and it is
		 * "moved" to pass zero's panel.
		 */
		
		recs.get(recIndex).setText("");
		
		/* If N==1, we know where we put min. */
		
		if (N==1)
			recs.get(3).setText(String.valueOf(min.get(0)));
		
		/* Else, 2*N+2*i is the function that gives us the position of min's text field. */
		
		else {
			recs.get(2*N+2*i).setText(String.valueOf(min.get(min.size()-1)));
			min.remove(min.get(min.size()-1));
		}

	}
	
}

	class twoWayPass0ListenerMax implements ActionListener {
		
		private int i,max, recIndex;
		private ArrayList<JTextField> recs;
		
		public  twoWayPass0ListenerMax(int i, int max, ArrayList<JTextField> recs, int recIndex) {
			this.max = max;
			this.i = i;
			this.recs = recs;
			this.recIndex = recIndex;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			/* 
			 * When we sort the array, every element is deleted from initial array, and it is
			 * "moved" to pass zero's panel.
			 */
		    
			recs.get(recIndex).setText("");
			
			/* If N==1, we know where we put max. */
			
			if(N==1)
				recs.get(3).setText(String.valueOf(max));
			
			/* Else, 2*N+2*i+1 is the function that gives us the position of max text field. */
			
			else
				recs.get(2*N+2*i+1).setText(String.valueOf(max));
			
		}
		
	}
	
class twoWayPass0ListenerMin implements ActionListener {
		
		private int i,min,recIndex;
		private ArrayList<JTextField> recs;
		
		public twoWayPass0ListenerMin(int i, int min, ArrayList<JTextField> recs, int recIndex) {
			this.min = min;
			this.i = i;
			this.recs = recs;
			this.recIndex = recIndex;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			/* 
			 * When we sort the array, every element is deleted from initial array, and it is
			 * "moved" to pass zero's panel.
			 */
			
			recs.get(recIndex).setText("");
			
			/* If N==1, we know where we put min. */
			
			if (N==1)
				recs.get(2).setText(String.valueOf(min));
			
			/* Else, 2*N+2*i is the function that gives us the position of min's text field. */
			
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