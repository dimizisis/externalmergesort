package Visualization;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

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
import javax.swing.JComponent;

import java.awt.BorderLayout;

public class VisualizationFrame {
	
	
	private final int MAXMSECONDS = 2000;
	private final int MINMSECONDS = 1000;
	private JFrame frame;
	private int N, B;
	private boolean generateRandomArray;
	
	/**
	 * Create the application.
	 */
	public VisualizationFrame(int N, int B, boolean generateRandomArray) {
		this.N = N;
		this.B = 3;
		this.generateRandomArray = generateRandomArray;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaption);
		frame.setBounds(100, 100, 950, 750);
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
		btnPassPanel1.setBackground(SystemColor.inactiveCaption);
		btnPassPanel1.setBounds(10, 228, 914, 38);
		frame.getContentPane().add(btnPassPanel1);
		btnPassPanel1.setLayout(new BorderLayout(0, 0));
		
		JButton btnEnterPass1 = new JButton("Enter Pass 1");
		btnEnterPass1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnPassPanel1.add(btnEnterPass1, BorderLayout.CENTER);
		
		JPanel passPanel1 = new JPanel();
		passPanel1.setBackground(SystemColor.inactiveCaption);
		passPanel1.setBounds(10, 277, 914, 83);
		frame.getContentPane().add(passPanel1);
		passPanel1.setLayout(new BoxLayout(passPanel1, BoxLayout.X_AXIS));
		
		JPanel btnPassPanel2 = new JPanel();
		btnPassPanel2.setBackground(SystemColor.inactiveCaption);
		btnPassPanel2.setBounds(10, 371, 914, 38);
		frame.getContentPane().add(btnPassPanel2);
		btnPassPanel2.setLayout(new BorderLayout(0, 0));
		
		JButton btnEnterPass2 = new JButton("Enter Pass 2");
		btnEnterPass2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnPassPanel2.add(btnEnterPass2, BorderLayout.CENTER);
		
		JPanel passPanel2 = new JPanel();
		passPanel2.setBackground(SystemColor.inactiveCaption);
		passPanel2.setBounds(10, 420, 914, 280);
		frame.getContentPane().add(passPanel2);
		passPanel2.setLayout(new BoxLayout(passPanel2, BoxLayout.X_AXIS));
		
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
			
			array.get(array.size() - 1).setAlignmentX(JComponent.CENTER_ALIGNMENT);
			
			/* Adding page to array panel. */
			
			initialPanel.add(array.get(array.size() - 1));
			
			/* Black border line for each page of array. */
			
			array.get(array.size() - 1).setBorder(BorderFactory.createLineBorder(Color.black));
			
			/* Adding gap between pages. */
			
			array.get(array.size() - 1).add(Box.createRigidArea(new Dimension(10,0)));		

		}
		
		if (generateRandomArray) {
			for(int x=0;x<2*N;++x)
				records.get(x).setText(String.valueOf(new Random().nextInt(99 + 1)));
		}
		
		if (N == 1) {
			btnEnterPass1.setVisible(false);
			btnEnterPass2.setVisible(false);
		}
		else if (N == 2)
			btnEnterPass2.setVisible(false);
		
		btnEnterPass0.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				btnEnterPass0.setEnabled(false);
				
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
					
					array.get(array.size() - 1).setAlignmentX(JComponent.CENTER_ALIGNMENT);
					
					/* Adding page to array panel. */
					
					passPanel0.add(array.get(array.size() - 1));
					
					/* Black border line for each page of array. */
					
					array.get(array.size() - 1).setBorder(BorderFactory.createLineBorder(Color.black));

				}
				
				/* New thread for first pass visualization. */
				
				TwoWayPassZero twoWayPass0 = new TwoWayPassZero(records,array);
					
					// Enter pass 0 for B=3 (2-way)
					new Thread(twoWayPass0).start();
		            	
		         }

		});
		
		btnEnterPass1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				btnEnterPass1.setEnabled(false);
				
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
				
				array.get(array.size() - 1).setAlignmentX(JComponent.TOP_ALIGNMENT);
				
				/* Adding page to array panel. */
				
				passPanel1.add(array.get(array.size() - 1));
				
				/* Black border line for each page of array. */
				
				array.get(array.size() - 1).setBorder(BorderFactory.createLineBorder(Color.black));
				
				}
				
				
				/* New thread for first pass visualization. */
				
				TwoWayPassOne twoWayPass1 = new TwoWayPassOne(records,array);
					
					// Enter pass 0 for B=3 (2-way)
					new Thread(twoWayPass1).start();
			}
			
		});
		
		btnEnterPass2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				for(int i=0;i<B-1;i++) {
				
				/* Add new page. */
				
				array.add(new JPanel());
				
				array.get(array.size() - 1).setPreferredSize(new Dimension(95,200));
				
			//	array.get(array.size() - 1).setMaximumSize(new Dimension(array.get(0).getSize()));
				
			//	array.get(array.size() - 1).setMinimumSize(new Dimension(array.get(0).getSize()));
				
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
				
				/* Setting records' appearance. */
				
				tempRec = setRecordAppearance(new JTextField(""));
				
				/* Add records' text fields in page. */
				
				records.add(tempRec);
				
				/* Add records' text fields in page. */
				
				array.get(array.size() - 1).add(tempRec);
				
				/* Setting records' appearance. */
				
				tempRec = setRecordAppearance(new JTextField(""));
				
				/* Add records' text fields in page. */
				
				records.add(tempRec);
				
				/* Add records' text fields in page. */
				
				array.get(array.size() - 1).add(tempRec);
				
				/* Centerize */
				
				array.get(array.size() - 1).setAlignmentX(JComponent.CENTER_ALIGNMENT);
				
				/* Adding page to array panel. */
				
				passPanel2.add(array.get(array.size() - 1));
				
				/* Black border line for each page of array. */
				
				array.get(array.size() - 1).setBorder(BorderFactory.createLineBorder(Color.black));
				
				}			
				
				/* New thread for first pass visualization. */
				
			//	TwoWayPassOne twoWayPass1 = new TwoWayPassOne(records,array);
					
					// Enter pass 0 for B=3 (2-way)
				//	new Thread(twoWayPass1).start();
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
				int max = Integer.max(Integer.parseInt(records.get(2*i).getText()), Integer.parseInt(records.get(2*i+1).getText()));;

				/* timer1 for max appearance, timer2 for min appearance. */
				
				Timer timer1;
				Timer timer2;
				
				/* 
				 * Need to know which text field has the minimum & maximum number, in order to clear
				 * the text field, when we "move" the element to pass zero's panel
				 */
					        
			    if (records.get(2*i).getText().equals(String.valueOf(min))) {
			    	timer1 = new Timer(MAXMSECONDS, new twoWayPass0ListenerMax(i,max,records, 2*i+1));
					timer2 = new Timer(MINMSECONDS, new twoWayPass0ListenerMin(i,min,records, 2*i));
				}
			    else {
					timer1 = new Timer(MAXMSECONDS, new twoWayPass0ListenerMax(i,max,records, 2*i));
					timer2 = new Timer(MINMSECONDS, new twoWayPass0ListenerMin(i,min,records, 2*i+1));
				}
			    
			    /* Starting the timers... */
					
				timer1.setRepeats(false);
				timer2.setRepeats(false);
				timer1.start();
				timer2.start();
				
				/* Thread needs to sleep for 4000 ms = maximum ms for visualization (timer1). */
					    
				try {
					Thread.sleep(MAXMSECONDS);
				} catch (InterruptedException e) {
					// Do nothing...	

				}        
				++i;
			}
		
		}
	}
	
	class TwoWayPassOne implements Runnable{
		
		private ArrayList<JTextField> records;
		private ArrayList<JPanel> array;
		
		public TwoWayPassOne(ArrayList<JTextField> records, ArrayList<JPanel> array) {
			this.records = records;
			this.array = array;
		}		

		@Override
		public void run() {
			
			/* tempArray contains all elements of array (after pass 0). */
			
			ArrayList<Integer> tempArray = new ArrayList<Integer>();
			
			/* tempArrayIndex contains all indexes of records' text fields in records ArrayList. 
			 * We need this ArrayList, in order to know which element from pass 0 is "moved" to array of pass 1
			 * each time.
			 * */
			
			ArrayList<Integer> tempArrayIndex = new ArrayList<Integer>();
			
			/* Initializing ArrayLists. */
			
			for(int j=2*N;j<=2*N+B;j++) {
				tempArray.add(Integer.parseInt(records.get(j).getText()));
				tempArrayIndex.add(j);
			}
			
			/* Making green panels in use. */
			
			for(int j=N;j<N+(B-1);j++)
				array.get(j).setBackground(Color.green);
			
			int i=0;
			
			/* With endofB variable we check how many pages left to read each time. */
			
			int endOfB=B-1;
			
			/* k is used to trace the index of output's text field in records' ArrayList. */
			
			int k=4*N;
			
			int j=N;
			
			while(true){
						
				/* If there are no pages to visit, break. */
						
				if (i>=N) {
					
					/* Make all pages (panels) gray before ending. */
					
					for(int p=0;p<=B-1;++p) array.get(2*N-1-p).setBackground(UIManager.getColor ("Panel.background"));
					
					/* Break when finish. */
					
					break;
				}
				
				if (endOfB==0) {

					int numberOfGreens=2;
					while(true) {
		
						if(j == 2*N-1) {
							
							/* Turn all previous checked pages (panel) gray. */
							
							for(int p=0;p<j-1;++p) array.get(p).setBackground(UIManager.getColor ("Panel.background"));
							
							/* If green, turn it gray (panel's default color). */
							
							if((array.get(j).getBackground()).getRGB() == Color.green.getRGB()) {
								array.get(j).setBackground(UIManager.getColor ("Panel.background"));
								break;
							}
							
							/* If gray, turn it green */
							
							else if(array.get(j).getBackground().getRGB() == UIManager.getColor("Panel.background").getRGB()) {
								array.get(j).setBackground(Color.green);
								tempArray.add(Integer.parseInt(records.get(2*j).getText()));
								tempArrayIndex.add(2*j);
								tempArray.add(Integer.parseInt(records.get(2*j+1).getText()));
								tempArrayIndex.add(2*j+1);	
								break;
							}
						}
						
						else {
							
						/* Turn all previous checked pages (panel) gray. */
							
						for(int p=0;p<j-1;++p) array.get(p).setBackground(UIManager.getColor ("Panel.background"));
						
						/* If green, turn it gray (panel's default color). */
						
						if((array.get(j).getBackground()).getRGB() == Color.green.getRGB())
							array.get(j).setBackground(UIManager.getColor ("Panel.background"));
						
						/* If gray, turn it green */
						
						else if(array.get(j).getBackground().getRGB() == UIManager.getColor("Panel.background").getRGB()) {
							array.get(j).setBackground(Color.green);
							tempArray.add(Integer.parseInt(records.get(2*j).getText()));
							tempArrayIndex.add(2*j);
							tempArray.add(Integer.parseInt(records.get(2*j+1).getText()));
							tempArrayIndex.add(2*j+1);
							--numberOfGreens;
							
							/* If all pages checked, break. */
							
							if(numberOfGreens == 0) 
								break;
							
						}
							
						}
						++j;
					}
					
					endOfB = B-1;
				}
				
				/* Finding min & next min for sorting. */
				
				int min = Collections.min(tempArray);
				int minIndex = tempArrayIndex.get(tempArray.indexOf(min));
				
				/* We remove the min element, in order to find next min. 
				 * We also remove the index from indexes' ArrayList.
				 * */

				tempArrayIndex.remove(tempArray.indexOf(min));
				tempArray.remove(tempArray.indexOf(min));
				
				int nextMin = Collections.min(tempArray);
				int nextMinIndex = tempArrayIndex.get(tempArray.indexOf(nextMin));
				
				/* We remove the min element, in order to find next min. 
				 * We also remove the index from indexes' ArrayList.
				 * */

				tempArrayIndex.remove(tempArray.indexOf(nextMin));
				tempArray.remove(tempArray.indexOf(nextMin));
				
				/* timer1 for max appearance, timer2 for min appearance. */
				
				Timer timer1;
				Timer timer2;
				
				/* 
				 * Need to know which text field has the minimum & maximum number, in order to clear
				 * the text field, when we "move" the element to pass zero's panel
				 */

			    	timer1 = new Timer(MAXMSECONDS, new twoWayPass1ListenerNextMin(nextMin,records, k+1, nextMinIndex));
					timer2 = new Timer(MINMSECONDS, new twoWayPass1ListenerMin(min,records, k, minIndex));
			    
			    /* Starting the timers... */
					
				timer1.setRepeats(false);
				timer2.setRepeats(false);
				timer1.start();
				timer2.start();
				
				/* Thread needs to sleep for 4000 ms = maximum ms for visualization (timer1). */
					    
				try {
					Thread.sleep(MAXMSECONDS);
				} catch (InterruptedException e) {
					// Do nothing...	

				}        
				++i;
				k=4*N+2*i;			
				endOfB--;
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

class twoWayPass1ListenerNextMin implements ActionListener {
	
	private int nextMin, recIndex;
	private ArrayList<JTextField> recs;
	private int nextMinIndex;
	
	public  twoWayPass1ListenerNextMin(int nextMin, ArrayList<JTextField> recs, int recIndex, int nextMinIndex) {
		this.nextMin = nextMin;
		this.recs = recs;
		this.recIndex = recIndex;
		this.nextMinIndex = nextMinIndex;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		/* 
		 * When we sort the array, every element is deleted from initial array, and it is
		 * "moved" to pass zero's panel.
		 */
	    
		recs.get(nextMinIndex).setText("");
		
		/* If N==1, we know where we put max. */
		
		if(N==1)
			recs.get(3).setText(String.valueOf(nextMin));
		
		/* Else, 2*N+2*i+1 is the function that gives us the position of max text field. */
		
		else
			recs.get(recIndex).setText(String.valueOf(nextMin));
		
	}
	
}

class twoWayPass1ListenerMin implements ActionListener {
	
	private int min,minIndex,recIndex;
	private ArrayList<JTextField> recs;
	
	public twoWayPass1ListenerMin(int min, ArrayList<JTextField> recs, int recIndex, int minIndex) {
		this.min = min;
		this.recs = recs;
		this.recIndex = recIndex;
		this.minIndex = minIndex;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		/* 
		 * When we sort the array, every element is deleted from initial array, and it is
		 * "moved" to pass zero's panel.
		 */
		
		recs.get(minIndex).setText("");
		
		/* If N==1, we know where we put min. */
		
		if (N==1)
			recs.get(2).setText(String.valueOf(min));
		
		/* Else, 2*N+2*i is the function that gives us the position of min's text field. */
		
		else
			recs.get(recIndex).setText(String.valueOf(min));
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