import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
//---------------------------------------------
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
//---------------------------------------------
import java.io.IOException;
//---------------------------------------------
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
//---------------------------------------------

public class Project5 extends JFrame {
	
	private JButton showStationButton;
	private JButton calculateHDButton;
	private JButton addStationButton;
	//---------------------------------------------
	private JTextArea sliderText;
	private JTextArea stationToAdd;
	//---------------------------------------------
	private JTextField sliderSelectedValue;
	private JTextField zeroCountText;
	private JTextField oneCountText;
	private JTextField twoCountText;
	private JTextField threeCountText;
	private JTextField fourCountText;
	//---------------------------------------------
	private JLabel compareWithLabel;
	private JLabel enterHamDistLabel;
	private JLabel distanceZeroLabel;
	private JLabel distanceOneLabel;
	private JLabel distanceTwoLabel;
	private JLabel distanceThreeLabel;
	private JLabel distanceFourLabel;
	//---------------------------------------------
	private JComboBox<String> dropDown;
	//---------------------------------------------
	private JSlider valueSlider;
	//---------------------------------------------
	private JLabel drawFavStation;
	private SignaturePanel drawPanel;
	
	//---------------------------------------------
	public int getHamDist(String STID1, String STID2) throws IOException
	{
		int hamDist = 0;
		String stationID1 = STID1;
		String stationID2 = STID2;
		
		for(int i = 0; i < 4; i++) {
			if(stationID1.charAt(i) != stationID2.charAt(i)) {
					hamDist++;
			}
		}
		return hamDist;
	}
	
	private void setupSignaturePanel() {
		drawPanel = new SignaturePanel();
		drawPanel.setBounds(350, 50, 500, 500);
		drawPanel.addMouseMotionListener(new MouseMotionListener()
		{
			@Override
			public void mouseMoved(MouseEvent e) {}

			@Override
			public void mouseDragged(MouseEvent e)
			{
				// add a point to the panel on drag and repaint.
//				spanel.setSignature(sign);
				drawPanel.addPoint(new Point(e.getX(), e.getY()));
				drawPanel.repaint();
			}
		});
	}
	
	private void setupJTextFields() {
		sliderSelectedValue = new JTextField();
		sliderSelectedValue.setEditable(false);
		sliderSelectedValue.setBounds(150, 15, 130, 20);
		
		zeroCountText = new JTextField();
		zeroCountText.setEditable(false);
		zeroCountText.setBounds(120, 550, 130, 20);
		
		oneCountText = new JTextField();
		oneCountText.setEditable(false);
		oneCountText.setBounds(120, 580, 130, 20);
		
		twoCountText = new JTextField();
		twoCountText.setEditable(false);
		twoCountText.setBounds(120, 610, 130, 20);
		
		threeCountText = new JTextField();
		threeCountText.setEditable(false);
		threeCountText.setBounds(120, 640, 130, 20);
		
		fourCountText = new JTextField();
		fourCountText.setEditable(false);
		fourCountText.setBounds(120, 670, 130, 20);
	}

	private void setupJTextAreas() {
		
		sliderText = new JTextArea();
		sliderText.setLineWrap(true);
		sliderText.setWrapStyleWord(true);
		sliderText.setBounds(10, 130, 280, 300);
		
		stationToAdd = new JTextArea();
		stationToAdd.setLineWrap(true);
		stationToAdd.setWrapStyleWord(true);
		stationToAdd.setBounds(150, 750, 130, 20);
	}
	
	private void setupJLabels() {
		drawFavStation = new JLabel();
		drawFavStation.setText("Draw Your Favourite Weather Station!");
		drawFavStation.setBounds(350, 10, 250, 30);
		
		compareWithLabel = new JLabel();
		compareWithLabel.setText("Compare with:");
		compareWithLabel.setBounds(20, 450, 130, 30);
		
		enterHamDistLabel = new JLabel();
		enterHamDistLabel.setText("Enter Hamming Dist: ");
		enterHamDistLabel.setBounds(10, 10, 160, 30);
		
		distanceZeroLabel = new JLabel();
		distanceZeroLabel.setText("Distance 0");
		distanceZeroLabel.setBounds(10, 550, 130, 30);
		
		distanceOneLabel = new JLabel();
		distanceOneLabel.setText("Distance 1");
		distanceOneLabel.setBounds(10, 580, 130, 30);
		
		distanceTwoLabel = new JLabel();
		distanceTwoLabel.setText("Distance 2");
		distanceTwoLabel.setBounds(10, 610, 130, 30);
		
		distanceThreeLabel = new JLabel();
		distanceThreeLabel.setText("Distance 3");
		distanceThreeLabel.setBounds(10, 640, 130, 30);
		
		distanceFourLabel = new JLabel();
		distanceFourLabel.setText("Distance 4");
		distanceFourLabel.setBounds(10, 670, 130, 30);
	}

	private void setupJButtons() {
		ArrayList<String> stations = new ArrayList<String>();
		try {
			File mesoInput = new File("Mesonet.txt");
			Scanner mesoInScanner = new Scanner(mesoInput);
			while(mesoInScanner.hasNextLine()) {
				stations.add(mesoInScanner.next());
				mesoInScanner.nextLine();
			}
			mesoInScanner.close();
		}
		catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		showStationButton = new JButton("Show Station");
		showStationButton.setBounds(10, 100, 130, 30);
		showStationButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String textString = "";
				for(int i = 0; i < stations.size(); i++) {
					int hamDist = 0;
					String dropString = "";
					
					dropString += dropDown.getSelectedItem();
					
					try {
						hamDist = getHamDist(dropString, stations.get(i));
					} 
					catch (IOException e1) {
						e1.printStackTrace();
					}
					
					if(hamDist == valueSlider.getValue()) {
						textString += stations.get(i);
						textString += "\n";
					}
				}
				sliderText.setText(textString);
			}
		});
		
		calculateHDButton = new JButton("Calculate HD");
		calculateHDButton.setBounds(10, 500, 130, 30);
		calculateHDButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int zeroCount = 0;
				int oneCount = 0;
				int twoCount = 0;
				int threeCount = 0;
				int fourCount = 0;
				
				for(int i = 0; i < stations.size(); i++) {
					int hamDist;
					try {
						hamDist = getHamDist((String)dropDown.getSelectedItem(), stations.get(i));
						if(hamDist == 0) {
							zeroCount++;
						}
						else if(hamDist == 1) {
							oneCount++;
						}
						else if(hamDist == 2) {
							twoCount++;
						}
						else if(hamDist == 3) {
							threeCount++;
						}
						else if(hamDist == 4) {
							fourCount++;
						}
					} 
					catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				zeroCountText.setText(new String("" + zeroCount));
				oneCountText.setText(new String("" + oneCount));
				twoCountText.setText(new String("" + twoCount));
				threeCountText.setText(new String("" + threeCount));
				fourCountText.setText(new String("" + fourCount));
			}	
		});	
		
		addStationButton = new JButton("Add station");
		addStationButton.setBounds(0, 750, 130, 30);
		addStationButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dropDown.addItem(stationToAdd.getText());
			}	
		});
	}
	
	private void setupDropdown() throws FileNotFoundException {
		ArrayList<String> stations = new ArrayList<String>();
		File mesoIn = new File("Mesonet.txt");
		Scanner mesoInScanner = new Scanner(mesoIn);
		while(mesoInScanner.hasNextLine()) {
			stations.add(mesoInScanner.next());
			mesoInScanner.nextLine();
		}
		mesoInScanner.close();
		
		dropDown = new JComboBox<String>();
		for(int index = 0; index < stations.size(); index++) {
			dropDown.addItem(stations.get(index));
		}
		
		dropDown.setBounds(120, 450, 130, 30);
	}
	
	private void setupSlider() {
		
		valueSlider = new JSlider(1, 4, 2);
		valueSlider.setBounds(10, 50, 200, 40);
		valueSlider.setMajorTickSpacing(1);
		valueSlider.setPaintTicks(true);
		valueSlider.setPaintLabels(true);
		valueSlider.setSnapToTicks(true);
		valueSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				String sliderSelectedVal = "";
				sliderSelectedVal += valueSlider.getValue();
				sliderSelectedValue.setText(sliderSelectedVal);			
			}
		});
	}
	
	public Project5() throws FileNotFoundException {
		super("Hamming Distance");
		
		setupSignaturePanel();
		setupJTextFields();
		setupJTextAreas();
		setupJLabels();
		setupJButtons();
		setupDropdown();
		setupSlider();
		
		add(showStationButton);
		add(calculateHDButton);
		add(addStationButton);	
		add(valueSlider);	
		add(sliderText);
		add(sliderSelectedValue);
		add(zeroCountText);
		add(oneCountText);
		add(twoCountText);
		add(threeCountText);
		add(fourCountText);
		add(stationToAdd);
		add(compareWithLabel);
		add(enterHamDistLabel);
		add(distanceZeroLabel);
		add(distanceOneLabel);
		add(distanceTwoLabel);
		add(distanceThreeLabel);
		add(distanceFourLabel);
		add(dropDown);
		add(drawFavStation);
		add(drawPanel);
		
		sliderSelectedValue.setText("" + valueSlider.getValue());
		
		setLayout(null);
		setSize(900, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setVisible(true);
	}

	public static void main(String[] args) throws FileNotFoundException {
			new Project5();
	}
}
