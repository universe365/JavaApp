

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BenchmarkSorts {
	static JFrame frame;
    static JButton btnApp;
	static JButton btnA1, btnA2;
//    static JTextArea text;
    static JLabel lblA1, lblA2;

    private int setNum, dataSize, size, totalSize;
    private int[] tempArr;
    private double avgCount, avgTime, coefTime, coefCount, tCount, tTime;  
    private double[] coefTimes, coefCounts;
	private ArrayList<String> dataInfo;
    private String str="";
	
	public static void main(String[] args) {
		
		new BenchmarkSorts();
		
	}
	
	private void init(){
        setNum=12;
        dataSize = 40;
		tempArr= new int[dataSize];
		dataInfo = new ArrayList<String>();
        coefTimes = new double[dataSize];
        coefCounts = new double[dataSize];
    }


	public BenchmarkSorts() {
        
        frame = new JFrame("Algorithm Project");

        // btnRun = new JButton("Run the algorithms");
        btnApp = new JButton("See result");
		btnA1 = new JButton("Run Bubble Sort");
		btnA2 = new JButton("Run Merge Sort");
		lblA1 = new JLabel();
		lblA2 = new JLabel();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,2));
        // panel.add(btnRun);
		panel.add(btnA1);
		panel.add(lblA1);
		panel.add(btnA2);
		panel.add(lblA2);
       
        
        panel.add(btnApp);


        frame.add(panel);

		
		btnA1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				lblA2.setText("start sort");
				init();

				for(int i=0; i<setNum; i++){
					System.out.print("\n"+(i+1)+": ");
            		try {
						tempArr = createData(dataSize);
		//				text.setText(text.getText()+"\n");
					
						//bubble sort
						BubbleSort bs = new BubbleSort(tempArr);
						bs.startSort();
						bs.sort(tempArr, dataSize);
						checkArr(tempArr);
						bs.endSort();
						tCount += bs.getCount();
						tTime += bs.getTime();
						coefCounts[i] = tCount;
						coefTimes[i]= tTime;
						System.out.println("bubble[size: "+size+", time:"+bs.getTime()+", count:"+bs.getCount()+"]");
						
					} catch (UnsortedException e) {
						e.printStackTrace();
					}

					System.out.println("================<info>=======================");

					avgTime = tTime/dataSize;
					avgCount = tCount/dataSize;
					coefCount = Math.round(getCoefficientOfVariance(coefCounts) * 100.0)/ 100.0;
					coefTime = Math.round(getCoefficientOfVariance(coefTimes)*100.0)/ 100.0;
					System.out.println("Time:"+tTime+
										",Count:"+tCount+
										", AvgTime:"+avgTime+
										", AvgCount:"+avgCount+
										", CoefTime:"+coefCount+
										", CoefCount:"+coefTime);
					dataInfo.add("["+size+","+avgTime+","+avgCount+","+coefTime+","+coefCount+"]");
				}

				



				JFileChooser fileChooser = new JFileChooser(".");
            	fileChooser.setDialogTitle("Specify a file to save");   
            	 
            	int userSelection = fileChooser.showSaveDialog(frame);
            	 
            	if (userSelection == JFileChooser.APPROVE_OPTION) {
            	    File fileToSave = fileChooser.getSelectedFile();
            	    writer(fileToSave);
            	    System.out.println("Save as file: " + fileToSave.getAbsolutePath());
            	}
            	
            	System.out.println(str);
				lblA1.setText("Bubble sort data saved!");
			}
			
		});

		btnA2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				lblA2.setText("start sort");
								
				init();

				for(int i=0; i<setNum; i++){
					

					System.out.print("\n"+(i+1)+": ");
            		try {
						tempArr = createData(dataSize);
		//				text.setText(text.getText()+"\n");
					
						//bubble sort
						MergeSort ms = new MergeSort(tempArr);
						ms.startSort();
						ms.sort(tempArr, dataSize);
						checkArr(tempArr);
						ms.endSort();
						tCount += ms.getCount();
						tTime += ms.getTime();
						coefCounts[i] = tCount;
						coefTimes[i]= tTime;
						System.out.println("bubble[size: "+size+", time:"+ms.getTime()+", count:"+ms.getCount()+"]");
						
					} catch (UnsortedException e) {
						e.printStackTrace();
					}

					System.out.println("================<info>=======================");

					avgTime = tTime/dataSize;
					avgCount = tCount/dataSize;
					coefCount = Math.round(getCoefficientOfVariance(coefCounts) * 100.0)/ 100.0;
					coefTime = Math.round(getCoefficientOfVariance(coefTimes)*100.0)/ 100.0;
					System.out.println("Time:"+tTime+
										",Count:"+tCount+
										", AvgTime:"+avgTime+
										", AvgCount:"+avgCount+
										", CoefTime:"+coefCount+
										", CoefCount:"+coefTime);
					
					dataInfo.add("["+size+","+avgTime+","+avgCount+","+coefTime+","+coefCount+"]");
				}

				



				JFileChooser fileChooser = new JFileChooser(".");
            	fileChooser.setDialogTitle("Specify a file to save");   
            	 
            	int userSelection = fileChooser.showSaveDialog(frame);
            	 
            	if (userSelection == JFileChooser.APPROVE_OPTION) {
            	    File fileToSave = fileChooser.getSelectedFile();
            	    writer(fileToSave);
            	    System.out.println("Save as file: " + fileToSave.getAbsolutePath());
            	}
            	
            	System.out.println(str);
				lblA2.setText("Merge Sort data saved!");

			}
			
		});


        btnApp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Application.main(null);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				frame.setVisible(false);
			}
        	
        });


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth()-600)/2,
				(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight()-300)/2);
        frame.setSize(600,300);
        frame.setVisible(true);

	}


	 private int[] createData(int n){

		int[] arr= new int[n];
		for(int i=0; i<n; i++){
			arr[i] = (int)(Math.random()*100 + 1);
			totalSize+= arr[i];

			if(i%10==0) System.out.println();
			
			if(i==n-1){
				System.out.println(arr[i]);
			}else{
				System.out.print(arr[i]+", ");
			}

		}		
		size = totalSize/n;
		return arr;
	}

	    
	    private void writer(File file) {
	    	BufferedWriter w;
	    	try {
	    		if(file == null) {
	    			new File("./data.txt");
	    		}
				w = new BufferedWriter(new FileWriter(file.toPath().toString()));
				// w.write(str);
				// w.newLine();

				for(int i=0; i<dataInfo.size(); i++){
					w.write(dataInfo.get(i));
					w.newLine();
				}



				w.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			lblA2.setText("saved!");
	    }
	    
	    private double getMean(double[] data) {
	    	double sum=0;
	    	for(double d: data) {
	    		sum += d;
	    	}
	    	return sum/ data.length;
	    }
	    
	    private double getStandardDeviation(double[] data) {
	    	double sum = 0;
	    	for(double d: data) {
	    		sum+= (d - getMean(data)) * (d - getMean(data));
	    	}
	    	return Math.sqrt(sum/(data.length-1));
	    }
	    
	    private double getCoefficientOfVariance(double[] data) {
	    	return ((getStandardDeviation(data))/getMean(data))*100;
	    }
	    
	
		/**
		 * 
		 * @param arr if arr is not sort complete, throws UnsortedException
		 * @throws UnsortedException 
		 */
		private void checkArr(int[] arr) throws UnsortedException {
			for(int i=1; i<arr.length; i++) {
				for(int j=0; j<i;j++) {
					if(arr[j]>arr[i]) {
						throw new UnsortedException();
					}
				}
			}
		}
		
		
		
}
