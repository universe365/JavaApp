

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;

public class Application {
	private String str="";
	private String[][] array;
	private String[] colName = {"size", "avg time","avg count", "coef time", "coef count"};
	
	public static void main(String[] args) throws IOException {
		Application app = new Application();
	}
	
	public Application() throws IOException {
		JFrame frame = new JFrame();
		JFileChooser fc = new JFileChooser(".");
		fc.showOpenDialog(fc);
		File file = fc.getSelectedFile();
		
		str = getFile(file.toString());
		System.out.println(str);
		
		//string data to array
		array = toArray(str);
		
		// JTable
		JTable table = new JTable(array, colName);
		table.setBounds(30, 40, 300, 300);
		
		
		JScrollPane sp = new JScrollPane(table);
		
		
//		for(String[] st: array) {
//			for(String s: st) {
//				System.out.println(s+"|");
//			}System.out.println();
//		}
		
		JButton btn = new JButton("go back");
		
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BenchmarkSorts.main(null);
				frame.setVisible(false);
			}
			
		});
		
		
		frame.add(sp);
		frame.add(btn, BorderLayout.SOUTH);
		frame.setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth()-600)/2,
						(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight()-300)/2);
		frame.setSize(600,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	private static String getFile(String filePath)
    {
 
        // Declaring object of StringBuilder class
        StringBuilder builder = new StringBuilder();
 
        // try block to check for exceptions where
        // object of BufferedReader class us created
        // to read filepath
        try (BufferedReader buffer = new BufferedReader(
                 new FileReader(filePath))) {
 
            String str;
 
            // Condition check via buffer.readLine() method
            // holding true upto that the while loop runs
            while ((str = buffer.readLine()) != null) {
 
                builder.append(str).append("\n");
            }
        }
 
        // Catch block to handle the exceptions
        catch (IOException e) {
 
            // Print the line number here exception occurred
            // using printStackTrace() method
            e.printStackTrace();
        }
 
        // Returning a string
        return builder.toString();
    }
	
	private String[][] toArray(String str){
		array = new String[12][5];
		
		str = str.trim();
		int begin=0, end=0, i=0, j=0;
		String temp="";
		for(int index=1; index<str.length(); index++) {
			
			if(str.charAt(index-1)=='[')
				begin = index;
			if(str.charAt(index)==',' || str.charAt(index)==']') {
				end = index;
				temp = str.substring(begin, end);
				begin=index+1;
				double digit = Double.parseDouble(temp);
				temp = String.format("%.2f", digit);
				System.out.println(temp);
				
				
				if(temp!="") {
					if(i<12) {
						if(j>=5) {
							i++;
							j=0;
						}
						array[i][j]= temp;
						j++;
						
					}
				}
				
				temp = "";
			}
			
			
		}
		System.out.println();
		return array;
	}

}
