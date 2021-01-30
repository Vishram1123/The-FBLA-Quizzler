package theFBLAQuizzler;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.text.*;
import java.time.*;
import java.util.*;
import java.util.regex.*;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import javax.swing.event.*;
import com.sun.tools.javac.*;



public class FBLAQuizzler extends Frame implements WindowListener,ActionListener,ChangeListener{
	 //All variables used. 
	 //Categorized by how they are used (for example: mc_ or _mc_ corresponds to multiple choice, _q_ corresponds to the question, etc).
	 static Random rand = new Random();
	
	 
	 static String mcq;
	 static String mcqa;
	 static String mcqb; 
	 static String mcqc; 
	 static String mcqd;
	 static String mcma;
	 static String amcma;
	 
	 static String saaq; 
	 static String saaqa; 
	 static String saaqb; 
	 static String saaqc; 
	 static String saaqd;
	 static String saama;
	 static String asaama;
	 
	 static String fbq;
	 static String fba;
	 static String fbua = "";
	 static String tfq;
	 static String slq;
	 
	 static String asel = "";
	 static String bsel = "";
	 static String csel = "";
	 static String dsel = "";
	 static String correctanswers = "";
	 
	 static String qdir = System.getProperty("user.home");
	 static String path;
	 static String fbs;
	 
	 static String timefinishtest;
	 static String datefinishtest;
	 static String savetest;
	 
	 static String name = "";
	 
	 
	 static int mcqn = rand.nextInt(10);
	 static int saaqn = rand.nextInt(10);
	 static int fbqn = rand.nextInt(10);
	 static int tfqn = rand.nextInt(10);
	 static int slqn = rand.nextInt(10);
	 
	 static int mca;  
	 static int mcua;
	 
	 static int sla;
	 static int slua;
	 
	 static int score = 0;
	 static int total = 0;
	 
	 static int aselstate = 1;
	 static int bselstate = 1;
	 static int cselstate = 1;
	 static int dselstate = 1;
	 
	 
	 static Boolean saaaa; 
	 static Boolean saaab; 
	 static Boolean saaac; 
	 static Boolean saaad;
	 
	 static Boolean saaua = false;
	 static Boolean saaub = false;
	 static Boolean saauc = false;
	 static Boolean saaud = false;
	 
	 static Boolean tfa;
	 static Boolean tfua;
	 
	 //Components that build the application.
	 //Ones that have a name like q1 are just what they sound like, but components with panel_# or lblNewLabel_# are auxiliary components, used for the look of the application
	 private static JFrame frmTheFblaQuizzler;
	 protected static Object frmTheFBLAQuizzler;
	 
	 private static CardLayout cl;
	 
	 private static JPanel CardLay;
	 private static JPanel introduction;
	 private static JPanel instructions;
	 private static JPanel q1;
	 private static JPanel q2;
	 private static JPanel q3;
	 private static JPanel q4;
	 private static JPanel q5;
	 private static JPanel finalscore;
	 private static JPanel panel_1;
	 private static JPanel panel_2;
	 private static JPanel panel_3;
	 private static JPanel panel_4;
	 private static JPanel panel_5;
	 private static JPanel panel_6;
	 private static JPanel panel_7;
	 private static JPanel panel_8;
	 private static JPanel panel_9;
	 private static JPanel panel_10;
	 private static JPanel panel_11;
	 private static JPanel panel_12;
	 private static JPanel panel_13;
	 private static JPanel panel_14;
	 private static JPanel panel_15;
	 private static JPanel panel_16;
	 private static JPanel panel_17;
	 
	 private static JLabel inst;
	 private static JLabel question1;
	 private static JLabel Question2;
	 private static JLabel question3;
	 private static JLabel Question4;
	 private static JLabel question5;
	 private static JLabel scorelabel;
	 private static JLabel selans;
	 private static JLabel selnumber;
	 private static JLabel selans2;
	 private static JLabel cifb;
	 private static JLabel selans3;
	 private static JLabel lblNewLabel_1;
	 private static JLabel lblNewLabel_2;
	 private static JLabel lblNewLabel_3;
	 private static JLabel lblNewLabel_4;
	 private static JLabel lblNewLabel_5;
	 
	 private static JFormattedTextField textField;
	 private static JFormattedTextField textField_1;

	 private static JButton btnNewButton;
	 private static JButton A1;
	 private static JButton B1;
	 private static JButton C1;
	 private static JButton D1;
	 private static JButton A2;
	 private static JButton B2;
	 private static JButton C2;
	 private static JButton D2;
	 private static JButton True;
	 private static JButton False;
	 private static JButton save; 
	 private static JButton nosave;
	 private static JButton lockinansmultch;
	 private static JButton lockinans;
	 private static JButton lockinansselallapply;
	 private static JButton lockinfilb;
	 private static JButton locktrueorfalse;
	 
	 private static JSlider slider;	 
	 
	 //Download script for Questions.txt.
	 //If the file exists, it asks if you want to delete it. Else, it downloads to the directory specified.
	 public static void download(String url, String fileName) throws IOException{
		try (InputStream in = URI.create(url).toURL().openStream()) {
	        Files.copy(in, Paths.get(fileName));
	    } catch (FileAlreadyExistsException e) {
	    	int qt = JOptionPane.showConfirmDialog(null, "Questions.txt already exists. Do you want to delete it?", "Questions.txt already exists", JOptionPane.YES_NO_OPTION);
	    	if (qt == 0) {
	    		Files.delete(Paths.get(fileName));
	    		try (InputStream in = URI.create(url).toURL().openStream()) {
	    	        Files.copy(in, Paths.get(fileName));
	    	    } 
	    	}
	    }
	 }
	 
	 //Generates the questions from Questions.txt. 
	 //Structured by what question type it is (for example, mc_ or _mc_ is a multiple choice question). Every 10 lines in the Questions.txt corresponds to a different form of information.
	 public static void generateqs() {
		 try {
			 mcq = Files.readAllLines(Paths.get(qdir + path)).get(mcqn + 6);
			 mcqa = Files.readAllLines(Paths.get(qdir + path)).get(mcqn + 19);
			 mcqb = Files.readAllLines(Paths.get(qdir + path)).get(mcqn + 32); 
			 mcqc = Files.readAllLines(Paths.get(qdir + path)).get(mcqn + 45);
			 mcqd = Files.readAllLines(Paths.get(qdir + path)).get(mcqn + 58); 
			 mca = Integer.parseInt(Files.readAllLines(Paths.get(qdir + path)).get(mcqn + 71));  
			 
			 
			 saaq = Files.readAllLines(Paths.get(qdir + path)).get(saaqn + 84); 
			 saaqa = Files.readAllLines(Paths.get(qdir + path)).get(saaqn + 97);
			 saaqb = Files.readAllLines(Paths.get(qdir + path)).get(saaqn + 110);
			 saaqc = Files.readAllLines(Paths.get(qdir + path)).get(saaqn + 123); 
			 saaqd = Files.readAllLines(Paths.get(qdir + path)).get(saaqn + 136); 
			 saaaa = Boolean.parseBoolean(Files.readAllLines(Paths.get(qdir + path)).get(saaqn + 149)); 
			 saaab = Boolean.parseBoolean(Files.readAllLines(Paths.get(qdir + path)).get(saaqn + 162)); 
			 saaac = Boolean.parseBoolean(Files.readAllLines(Paths.get(qdir + path)).get(saaqn + 175)); 
			 saaad = Boolean.parseBoolean(Files.readAllLines(Paths.get(qdir + path)).get(saaqn + 188));
			 
			 
			 fbq = Files.readAllLines(Paths.get(qdir + path)).get(fbqn + 201);
			 fba = Files.readAllLines(Paths.get(qdir + path)).get(fbqn + 214);
			 
			 
			 tfq = Files.readAllLines(Paths.get(qdir + path)).get(tfqn + 227);
			 tfa = Boolean.parseBoolean(Files.readAllLines(Paths.get(qdir + path)).get(tfqn + 240));
			 
			 
			 slq = Files.readAllLines(Paths.get(qdir + path)).get(slqn + 253);
			 sla = Integer.parseInt(Files.readAllLines(Paths.get(qdir + path)).get(slqn + 266));
			 
		} catch (NumberFormatException e2) {
			e2.printStackTrace();
		} catch (IOException e2) {
			System.out.println("One or more files were not found.");
			e2.printStackTrace();
		}
	 }
	 //Gets the name and sets up the instructions page based on it. If the name is blank it asks for a name.
	 public static void validateName() {
			name = textField.getText();
			if (!name.equals("")) {
				name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
				inst.setText("<html><center><p>Hello, " + name + "! You will be taking a 5 question quiz. Get ready.</p></center></html>");
				cl.show(CardLay, "instructions");
				Timer timer = new Timer(3000, new ActionListener() {
				    @Override
				    public void actionPerformed(ActionEvent e) {
				    	cl.show(CardLay, "q1");
				    }
				});
				timer.setRepeats(false);
				timer.start();
			} else {
				JOptionPane.showMessageDialog(null, "You entered a blank name. Please make sure that it isn't blank.");
			}
	 }
	 //Sets up the labels in the questions.
	 public static void setQuestions() {
		 question1.setText("<html><center><p>" + mcq + "</p></center></html>");
		 A1.setText("<html><center><p>" + mcqa + "</p></center></html>");
		 B1.setText("<html><center><p>" + mcqb + "</p></center></html>");
		 C1.setText("<html><center><p>" + mcqc + "</p></center></html>");
		 D1.setText("<html><center><p>" + mcqd + "</p></center></html>");
		 Question2.setText("<html><center><p>" + slq + "</p></center></html>");
		 question3.setText("<html><center><p>" + saaq + "</p></center></html>");
		 A2.setText("<html><center><p>" + saaqa + "</p></center></html>");
		 B2.setText("<html><center><p>" + saaqb + "</p></center></html>");
		 C2.setText("<html><center><p>" + saaqc + "</p></center></html>");
		 D2.setText("<html><center><p>" + saaqd + "</p></center></html>");
		 Question4.setText("<html><center><p>" + fbq + "</p></center></html>");
		 question5.setText("<html><center><p>" + tfq + "</p></center></html>");
	 }
	 //Prints the score to a HTML document based on a template consisting of the date the test is finished, the time the test is finished, and the questions with their corresponding answers.
	 public static void printResults(String rdir) {
     	try {
     	      FileWriter myWriter = new FileWriter(rdir + fbs + name + "_FBLAQ_" + savetest + ".html", true);
     	      myWriter.write("<!DOCTYPE html>");
     	      myWriter.write("<html style=\"background-size: contain; background-image:url('https://www.pngitem.com/pimgs/m/195-1958109_fbla-logo-future-business-leaders-of-america-logo.png');background-repeat: no-repeat; background-position:center;\">");
     	      myWriter.write("	<body style=\"background: rgba(256 , 256, 256, 0.9); background-origin: border-box; font-family: Verdana, Helvetica, sans-serif;\">");
     	      myWriter.write("		<center>");
     	      myWriter.write("			<h1>Great job, " + name + "!</h1>");
     	      myWriter.write("			<h3>You got " + score + " out of " + total + " on " + datefinishtest + " at " + timefinishtest + "!</h3>");
     	      myWriter.write("			<h5>Question 1: " + mcq + "</h5>");
     	      myWriter.write("			<p>");
     	      myWriter.write("				Your Answer: " + mcma);
     	      myWriter.write("			</p>");
     	      myWriter.write("			<p>");
     	      myWriter.write("				Correct Answer: " + amcma);
     	      myWriter.write("			</p>");
     	      myWriter.write("			<h5>Question 2: " + slq + "</h5>");
     	      myWriter.write("			<p>");
     	      myWriter.write("				Your Answer: " + slua);
     	      myWriter.write("			</p>");
     	      myWriter.write("			<p>");
     	      myWriter.write("				Correct Answer: " + sla);
     	      myWriter.write("			</p>");
     	      myWriter.write("			<h5>Question 3: " + saaq + "</h5>");
     	      myWriter.write("			<p>");
     	      myWriter.write("				A: " + saaqa);
     	      myWriter.write("			</p>");
     	      myWriter.write("			<p>");
     	      myWriter.write("				B: " + saaqb);
     	      myWriter.write("			</p>");
     	      myWriter.write("			<p>");
     	      myWriter.write("				C: " + saaqc);
     	      myWriter.write("			</p>");
     	      myWriter.write("			<p>");
     	      myWriter.write("				D: " + saaqd);
     	      myWriter.write("			</p>");
     	      myWriter.write("			<p>");
     	      myWriter.write("				Your Answers: " + asel + bsel + csel + dsel);
     	      myWriter.write("			</p>");
     	      myWriter.write("			<p>");
     	      myWriter.write("				Correct Answers: " + correctanswers);
     	      myWriter.write("			</p>");
     	      myWriter.write("			<h5>Question 4: " + fbq + "</h5>");
     	      myWriter.write("			<p>");
     	      myWriter.write("				Your Answer: " + fbua);
     	      myWriter.write("			</p>");
     	      myWriter.write("			<p>");
     	      myWriter.write("				Correct Answer: " + fba);
     	      myWriter.write("			</p>");
     	      myWriter.write("			<h5>Question 5: " + tfq + "</h5>");
     	      myWriter.write("			<p>");
     	      myWriter.write("				Your Answer: " + tfua);
     	      myWriter.write("			</p>");
     	      myWriter.write("			<p>");
     	      myWriter.write("				Correct Answer: " + tfa);
     	      myWriter.write("			</p>");
     	      myWriter.write("		</center>");
     	      myWriter.write("	</body>");
     	      myWriter.write("</html>");
     	      myWriter.close();
     	    } catch (IOException e1) {
     	      
     	    }
	 }
	 //Creates the application
	 public FBLAQuizzler() {
		try {
			initialize();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Initialize the contents of the frame.
	private void initialize() throws IOException {
        //The dock application icon for MacOS is handled here. It reads the icon directly from my repository. 
		Image image =  ImageIO.read(new URL("https://github.com/Vishram1123/The-FBLA-Quizzler/blob/main/TheFBLAQuizzlerLogo.png?raw=true"));
        try {
        	final Taskbar taskbar = Taskbar.getTaskbar();
            taskbar.setIconImage(image);
        } catch (final UnsupportedOperationException e) {
        	
        } 
        //The main frame. If the close button is clicked at any time, it will ask if you want to quit.
		frmTheFblaQuizzler = new JFrame();
		frmTheFblaQuizzler.setBounds(100, 100, 550, 300);
		frmTheFblaQuizzler.setTitle("The FBLA Quizzler");
		frmTheFblaQuizzler.setIconImage(new ImageIcon(image).getImage());
		frmTheFblaQuizzler.getContentPane().setLayout(new BorderLayout(0, 0));
		frmTheFblaQuizzler.setIconImage(new ImageIcon(image).getImage());
		frmTheFblaQuizzler.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent evt){
                int confirmclose = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit ?", "Quit?", JOptionPane.YES_NO_OPTION);
                if(confirmclose == JOptionPane.YES_OPTION) {
                    System.exit(0);
                } else{
                	frmTheFblaQuizzler.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
		
		//Card layout switches from question to question.
		CardLay = new JPanel();
		frmTheFblaQuizzler.getContentPane().add(CardLay);
		CardLay.setLayout(new CardLayout(0, 0));
		
		//Allows for the application to switch from question to question utilizing the card layout.
		cl = (CardLayout) CardLay.getLayout();
		
		introduction = new JPanel();
		CardLay.add(introduction, "introduction");
		introduction.setLayout(new GridLayout(3, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("<html><center><p>Welcome to the FBLA Quizzler! What is your name?</p></center></html>");
		lblNewLabel.setFont(new Font("Avenir", Font.PLAIN, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		introduction.add(lblNewLabel);
		
		textField = new JFormattedTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Avenir", Font.PLAIN, 13));
		textField.setColumns(10);
		textField.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyPressed(KeyEvent e) {
	            if(e.getKeyCode() == KeyEvent.VK_ENTER){
	            	btnNewButton.doClick();
	            }
	        }
	    });
		introduction.add(textField);
		
		JPanel panel = new JPanel();
		introduction.add(panel);
		
		btnNewButton = new JButton("Ok, let's go!");
		btnNewButton.setFont(new Font("Avenir", Font.PLAIN, 13));
		btnNewButton.setPreferredSize(new Dimension(100, 30));
		btnNewButton.setBorder(BorderFactory.createEmptyBorder());
		btnNewButton.setBorder(new LineBorder(Color.BLACK) );
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBackground(new Color(238,238,238));
		btnNewButton.addActionListener(this);
		panel.add(btnNewButton);
		
		instructions = new JPanel();
		instructions.setLayout(new GridLayout(0, 1, 0, 0));
		CardLay.add(instructions, "instructions");
		
		inst = new JLabel("New label");
		inst.setFont(new Font("Avenir", Font.PLAIN, 20));
		inst.setHorizontalAlignment(SwingConstants.CENTER);
		instructions.add(inst);
		
		q1 = new JPanel();
		q1.setLayout(new GridLayout(4, 1, 0, 0));
		CardLay.add(q1, "q1");
		
		panel_13 = new JPanel();
		panel_13.setLayout(new BorderLayout(0, 0));
		q1.add(panel_13);
		
		question1 = new JLabel("New label");
		question1.setHorizontalAlignment(SwingConstants.CENTER);
		question1.setFont(new Font("Avenir", Font.PLAIN, 18));
		panel_13.add(question1, BorderLayout.CENTER);
		
		lblNewLabel_1 = new JLabel("Multiple Choice");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Avenir", Font.PLAIN, 13));
		panel_13.add(lblNewLabel_1, BorderLayout.SOUTH);
		
		panel_1 = new JPanel();
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		q1.add(panel_1);
		
		A1 = new JButton("New button");
		A1.setFont(new Font("Avenir", Font.PLAIN, 13));
		A1.addActionListener(this);
		A1.setOpaque(true);
		A1.setBorder(BorderFactory.createEmptyBorder());
		A1.setBorder(new LineBorder(Color.BLACK) );
		A1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		A1.setBackground(new Color(238,238,238));
		panel_1.add(A1);
		
		B1 = new JButton("New button");
		B1.setFont(new Font("Avenir", Font.PLAIN, 13));
		B1.setOpaque(true);
		B1.setBorder(BorderFactory.createEmptyBorder());
		B1.setBorder(new LineBorder(Color.BLACK) );
		B1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		B1.setBackground(new Color(238,238,238));
		B1.addActionListener(this);
		panel_1.add(B1);
		
		panel_2 = new JPanel();
		q1.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		C1 = new JButton("New button");
		C1.setFont(new Font("Avenir", Font.PLAIN, 13));
		C1.setOpaque(true);
		C1.setBorder(BorderFactory.createEmptyBorder());
		C1.setBorder(new LineBorder(Color.BLACK) );
		C1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		C1.setBackground(new Color(238,238,238));
		C1.addActionListener(this);
		panel_2.add(C1);
		
		D1 = new JButton("New button");
		D1.setFont(new Font("Avenir", Font.PLAIN, 13));
		D1.setOpaque(true);
		D1.setBorder(BorderFactory.createEmptyBorder());
		D1.setBorder(new LineBorder(Color.BLACK) );
		D1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		D1.setBackground(new Color(238,238,238));
		D1.addActionListener(this);
		panel_2.add(D1);
		
		panel_3 = new JPanel();
		q1.add(panel_3);
		
		lockinansmultch = new JButton("Lock in your answer");
		lockinansmultch.setFont(new Font("Avenir", Font.PLAIN, 13));
		lockinansmultch.setPreferredSize(new Dimension(150, 30));
		lockinansmultch.setBorder(BorderFactory.createEmptyBorder());
		lockinansmultch.setBorder(new LineBorder(Color.BLACK) );
		lockinansmultch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lockinansmultch.setEnabled(false);
		lockinansmultch.setBackground(new Color(238,238,238));
		lockinansmultch.addActionListener(this);
		panel_3.add(lockinansmultch);
		
		selans = new JLabel("");
		selans.setHorizontalAlignment(SwingConstants.CENTER);
		selans.setFont(new Font("Avenir", Font.PLAIN, 13));
		panel_3.add(selans);
		
		q2 = new JPanel();
		CardLay.add(q2, "q2");
		q2.setLayout(new GridLayout(3, 0, 0, 0));
		
		panel_14 = new JPanel();
		panel_14.setLayout(new BorderLayout(0, 0));
		q2.add(panel_14);
		
		Question2 = new JLabel("New label");
		Question2.setHorizontalAlignment(SwingConstants.CENTER);
		Question2.setFont(new Font("Avenir", Font.PLAIN, 18));
		panel_14.add(Question2, BorderLayout.CENTER);
		
		lblNewLabel_2 = new JLabel("Slider");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Avenir", Font.PLAIN, 13));
		panel_14.add(lblNewLabel_2, BorderLayout.SOUTH);
		
		slider = new JSlider();
		slider.setBorder(null);
		slider.setValue(25);
		slider.setMaximum(50);
		slider.setMajorTickSpacing(1);
		slider.setFont(new Font("Avenir", Font.PLAIN, 11));
		slider.setSnapToTicks(true);
		slider.addChangeListener((ChangeListener) this);
		slider.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		q2.add(slider);
		
		panel_4 = new JPanel();
		q2.add(panel_4);
		
		lockinans = new JButton("Lock in your answer");
		lockinans.setFont(new Font("Avenir", Font.PLAIN, 13));
		lockinans.addActionListener(this);
		lockinans.setPreferredSize(new Dimension(150, 30));
		lockinans.setBorder(BorderFactory.createEmptyBorder());
		lockinans.setBorder(new LineBorder(Color.BLACK) );
		lockinans.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lockinans.setEnabled(false);
		lockinans.setBackground(new Color(238,238,238));
		panel_4.add(lockinans);
		
		selnumber = new JLabel("Value: 25");
		selnumber.setFont(new Font("Avenir", Font.PLAIN, 13));
		selnumber.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(selnumber);
		
		q3 = new JPanel();
		q3.setLayout(new GridLayout(4, 1, 0, 0));
		CardLay.add(q3, "q3");
		
		panel_15 = new JPanel();
		panel_15.setLayout(new BorderLayout(0, 0));
		q3.add(panel_15);
		
		question3 = new JLabel("New label");
		question3.setHorizontalAlignment(SwingConstants.CENTER);
		question3.setFont(new Font("Avenir", Font.PLAIN, 18));
		panel_15.add(question3);
		
		lblNewLabel_3 = new JLabel("Select All that Apply");
		lblNewLabel_3.setFont(new Font("Avenir", Font.PLAIN, 13));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_15.add(lblNewLabel_3, BorderLayout.SOUTH);
		
		panel_5 = new JPanel();
		panel_5.setLayout(new GridLayout(0, 2, 0, 0));
		q3.add(panel_5);
		
		A2 = new JButton("New button");
		A2.setFont(new Font("Avenir", Font.PLAIN, 13));
		A2.setOpaque(true);
		A2.setBorder(BorderFactory.createEmptyBorder());
		A2.setBorder(new LineBorder(Color.BLACK) );
		A2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		A2.setBackground(new Color(238,238,238));
		A2.addActionListener(this);
		panel_5.add(A2);
		
		B2 = new JButton("New button");
		B2.setFont(new Font("Avenir", Font.PLAIN, 13));
		B2.setBorder(BorderFactory.createEmptyBorder());
		B2.setBorder(new LineBorder(Color.BLACK) );
		B2.setOpaque(true);
		B2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		B2.setBackground(new Color(238,238,238));
		B2.addActionListener(this);
		panel_5.add(B2);
		
		panel_6 = new JPanel();
		panel_6.setLayout(new GridLayout(0, 2, 0, 0));
		q3.add(panel_6);
		
		C2 = new JButton("New button");
		C2.setFont(new Font("Avenir", Font.PLAIN, 13));
		C2.setOpaque(true);
		C2.setBorder(BorderFactory.createEmptyBorder());
		C2.setBorder(new LineBorder(Color.BLACK) );
		C2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		C2.setBackground(new Color(238,238,238));
		C2.addActionListener(this);
		panel_6.add(C2);
		
		D2 = new JButton("New button");
		D2.setFont(new Font("Avenir", Font.PLAIN, 13));
		D2.setOpaque(true);
		D2.setBorder(BorderFactory.createEmptyBorder());
		D2.setBorder(new LineBorder(Color.BLACK) );
		D2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		D2.setBackground(new Color(238,238,238));
		D2.addActionListener(this);
		panel_6.add(D2);
		
		panel_7 = new JPanel();
		q3.add(panel_7);
		
		lockinansselallapply = new JButton("Lock in your answer");
		lockinansselallapply.setFont(new Font("Avenir", Font.PLAIN, 13));
		lockinansselallapply.addActionListener(this);
		lockinansselallapply.setPreferredSize(new Dimension(150, 30));
		lockinansselallapply.setBorder(BorderFactory.createEmptyBorder());
		lockinansselallapply.setBorder(new LineBorder(Color.BLACK) );
		lockinansselallapply.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lockinansselallapply.setEnabled(false);
		lockinansselallapply.setBackground(new Color(238,238,238));
		panel_7.add(lockinansselallapply);
		
		selans2 = new JLabel("");
		selans2.setHorizontalAlignment(SwingConstants.CENTER);
		selans2.setFont(new Font("Avenir", Font.PLAIN, 13));
		panel_7.add(selans2);
		
		q4 = new JPanel();
		q4.setLayout(new GridLayout(3, 1, 0, 0));
		CardLay.add(q4, "q4");
		
		panel_16 = new JPanel();
		panel_16.setLayout(new BorderLayout(0, 0));
		q4.add(panel_16);
		
		Question4 = new JLabel("n");		
		Question4.setHorizontalAlignment(SwingConstants.CENTER);
		Question4.setFont(new Font("Avenir", Font.PLAIN, 23));
		panel_16.add(Question4);
		
		lblNewLabel_4 = new JLabel("Fill in the Blank");
		lblNewLabel_4.setFont(new Font("Avenir", Font.PLAIN, 13));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_16.add(lblNewLabel_4, BorderLayout.SOUTH);
		
		textField_1 = new JFormattedTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Avenir", Font.PLAIN, 13));
		textField_1.setColumns(10);
		q4.add(textField_1);
		textField_1.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyPressed(KeyEvent e) {
	            if(e.getKeyCode() == KeyEvent.VK_ENTER){
	            	lockinfilb.doClick();
	            }
	        }
	    });
		q4.add(textField_1);
		
		panel_8 = new JPanel();
		q4.add(panel_8);
		
		lockinfilb = new JButton("Lock in your answer");
		lockinfilb.setFont(new Font("Avenir", Font.PLAIN, 13));
		lockinfilb.addActionListener(this);
		lockinfilb.setPreferredSize(new Dimension(150, 30));
		lockinfilb.setBorder(BorderFactory.createEmptyBorder());
		lockinfilb.setBorder(new LineBorder(Color.BLACK) );
		lockinfilb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lockinfilb.setBackground(new Color(238,238,238));
		panel_8.add(lockinfilb);
		
		cifb = new JLabel("");
		cifb.setFont(new Font("Avenir", Font.PLAIN, 13));
		panel_8.add(cifb);
		
		q5 = new JPanel();
		q5.setLayout(new GridLayout(4, 1, 0, 0));
		CardLay.add(q5, "q5");
		
		panel_17 = new JPanel();
		panel_17.setLayout(new BorderLayout(0, 0));
		q5.add(panel_17);
		
		question5 = new JLabel("New label");
		question5.setHorizontalAlignment(SwingConstants.CENTER);
		question5.setFont(new Font("Avenir", Font.PLAIN, 18));
		panel_17.add(question5);
		
		lblNewLabel_5 = new JLabel("True or False");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Avenir", Font.PLAIN, 13));
		panel_17.add(lblNewLabel_5, BorderLayout.SOUTH);
		
		panel_9 = new JPanel();
		panel_9.setLayout(new GridLayout(0, 1, 0, 0));
		q5.add(panel_9);
		
		True = new JButton("True");
		True.setOpaque(true);
		True.setFont(new Font("Avenir", Font.PLAIN, 13));
		True.addActionListener(this);
		True.setBorder(BorderFactory.createEmptyBorder());
		True.setBorder(new LineBorder(Color.BLACK) );
		True.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		True.setBackground(new Color(238,238,238));
		panel_9.add(True);
		
		panel_10 = new JPanel();
		panel_10.setLayout(new GridLayout(0, 1, 0, 0));
		q5.add(panel_10);
		
		False = new JButton("False");
		False.setOpaque(true);
		False.setFont(new Font("Avenir", Font.PLAIN, 13));
		False.addActionListener(this);
		False.setBorder(BorderFactory.createEmptyBorder());
		False.setBorder(new LineBorder(Color.BLACK) );
		False.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		False.setBackground(new Color(238,238,238));
		panel_10.add(False);
		
		panel_11 = new JPanel();
		q5.add(panel_11);
		
		locktrueorfalse = new JButton("Lock in your answer");
		locktrueorfalse.setFont(new Font("Avenir", Font.PLAIN, 13));
		locktrueorfalse.addActionListener(this);
		locktrueorfalse.setPreferredSize(new Dimension(150, 30));
		locktrueorfalse.setBorder(BorderFactory.createEmptyBorder());
		locktrueorfalse.setBorder(new LineBorder(Color.BLACK));
		locktrueorfalse.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		locktrueorfalse.setEnabled(false);
		locktrueorfalse.setBackground(new Color(238,238,238));
		panel_11.add(locktrueorfalse);
		
		selans3 = new JLabel("");
		selans3.setHorizontalAlignment(SwingConstants.CENTER);
		selans3.setFont(new Font("Avenir", Font.PLAIN, 13));
		panel_11.add(selans3);
		
		finalscore = new JPanel();
		finalscore.setLayout(new GridLayout(2, 1, 0, 0));
		CardLay.add(finalscore, "finalscore");
		
		scorelabel = new JLabel("New label");
		scorelabel.setHorizontalAlignment(SwingConstants.CENTER);
		scorelabel.setFont(new Font("Avenir", Font.PLAIN, 20));
		finalscore.add(scorelabel);
		
		panel_12 = new JPanel();
		finalscore.add(panel_12);
		
		nosave = new JButton("Nah, I'd rather not save these results.");
		nosave.setPreferredSize(new Dimension(250, 30));
		nosave.setFont(new Font("Avenir", Font.PLAIN, 13));
		nosave.setBorder(BorderFactory.createEmptyBorder());
		nosave.setBorder(new LineBorder(Color.BLACK) );
		nosave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		nosave.addActionListener(this);
		nosave.setBackground(new Color(238,238,238));
		panel_12.add(nosave);
		
		save = new JButton("I will save my results");
		save.setPreferredSize(new Dimension(150, 30));
		save.setFont(new Font("Avenir", Font.PLAIN, 13));
		save.setBorder(BorderFactory.createEmptyBorder());
		save.setBorder(new LineBorder(Color.BLACK) );
		save.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		save.addActionListener(this);
		save.setBackground(new Color(238,238,238));
		panel_12.add(save);
	}
	//Decides what to do upon a button click
	public void actionPerformed(ActionEvent e) {
		generateqs();
		setQuestions();
		if (e.getSource() == btnNewButton) {
			validateName();
		} else if (e.getSource() == A1) {
			mcua = 1;
			A1.setBackground(Color.CYAN);
			B1.setBackground(new Color(238,238,238));
			C1.setBackground(new Color(238,238,238));
			D1.setBackground(new Color(238,238,238));
			selans.setText("<html><center><p> Your Answer: A </p></center></html>");
			lockinansmultch.setEnabled(true);
		} else if (e.getSource() == B1) {
			mcua = 2;
			B1.setBackground(Color.CYAN);
			A1.setBackground(new Color(238,238,238));
			C1.setBackground(new Color(238,238,238));
			D1.setBackground(new Color(238,238,238));
			selans.setText("<html><center><p> Your Answer: B </p></center></html>");
			lockinansmultch.setEnabled(true);
		} else if (e.getSource() == C1) {
			mcua = 3;
			C1.setBackground(Color.CYAN);
			A1.setBackground(new Color(238,238,238));
			B1.setBackground(new Color(238,238,238));
			D1.setBackground(new Color(238,238,238));
			selans.setText("<html><center><p> Your Answer: C </p></center></html>");
			lockinansmultch.setEnabled(true);
		} else if (e.getSource() == D1) {
			mcua = 4;
			D1.setBackground(Color.CYAN);
			A1.setBackground(new Color(238,238,238));
			B1.setBackground(new Color(238,238,238));
			C1.setBackground(new Color(238,238,238));
			selans.setText("<html><center><p> Your Answer: D </p></center></html>");
			lockinansmultch.setEnabled(true);
		} else if (e.getSource() == lockinansmultch) {
			A1.setEnabled(false);
			B1.setEnabled(false);
			C1.setEnabled(false);
			D1.setEnabled(false);
			lockinansmultch.setEnabled(false);
			switch (mcua) {
			case 1: { A1.setBackground(Color.RED); 
			mcma = mcqa;
			break; }
			case 2: { B1.setBackground(Color.RED); 
			mcma = mcqb;
			break; }
			case 3: { C1.setBackground(Color.RED); 
			mcma = mcqc;
			break; }
			case 4: { D1.setBackground(Color.RED); 
			mcma = mcqd;
			break; }
			}
			switch (mca) {
			case 1: { A1.setBackground(Color.GREEN);
			amcma = mcqa;
			break; }
			case 2: { B1.setBackground(Color.GREEN); 
			amcma = mcqb;
			break; }
			case 3: { C1.setBackground(Color.GREEN); 
			amcma = mcqc;
			break; }
			case 4: { D1.setBackground(Color.GREEN); 
			amcma = mcqd;
			break; }
			}
			if (mcua == mca) {
				score++;
				total++;
				selans.setText("<html><center><p> Great job! That was correct! " + score + " out of " + total + ".</p></center></html>");
			} else {
				total++;
 				selans.setText("<html><center><p> Sorry, incorrect. " + score + " out of " + total + ". The correct answer was \"" + amcma + "\". </p></center></html>");
			}
			Timer timer1 = new Timer(3000, new ActionListener() {
			    @Override
			    public void actionPerformed(ActionEvent e) {
			    	cl.show(CardLay, "q2");
			    }
			});
			timer1.setRepeats(false);
			timer1.start();
		} else if (e.getSource() == lockinans) {
			
			slider.setEnabled(false);
			lockinans.setEnabled(false);
			slua = slider.getValue();
			if (slua == sla) {
				score++;
				total++;
				selnumber.setText("<html><center><p> Great job! That was correct! " + score + " out of " + total + ".</p></center></html>");				
			}
			else {
				total++;
				selnumber.setText("<html><center><p> Sorry, incorrect. " + score + " out of " + total + ". The correct answer was " + sla + ".</p></center></html>");
			}
		Timer timer2 = new Timer(3000, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	cl.show(CardLay, "q3");
		    }
		});
		timer2.setRepeats(false);
		timer2.start();
		} else if (e.getSource() == A2) {
			aselstate++;
			lockinansselallapply.setEnabled(true);
			if (aselstate % 2 == 0) {
				saaua = true;
				asel = " A";
				A2.setBackground(Color.CYAN);
			}
			else {
				saaua = false;
				asel = "";
				A2.setBackground(new Color(238,238,238));
			}
			selans2.setText("Selected Answers:" + asel + bsel + csel + dsel);
		}
		else if (e.getSource() == B2) {
			lockinansselallapply.setEnabled(true);
			bselstate++;
			if (bselstate % 2 == 0) {
				saaub = true;
				bsel = " B";
				B2.setBackground(Color.CYAN);
			}
			else {
				saaub = false;
				bsel = "";
				B2.setBackground(new Color(238,238,238));
			}
			selans2.setText("Selected Answers:" + asel + bsel + csel + dsel);
		} else if (e.getSource() == C2) {
			lockinansselallapply.setEnabled(true);
			cselstate++; 
			if (cselstate % 2 == 0) {
				saauc = true;
				csel = " C";
				C2.setBackground(Color.CYAN);
			}	
			else { 
				saauc = false;
				csel = "";
				C2.setBackground(new Color(238,238,238));
			}
			selans2.setText("Selected Answers:" + asel + bsel + csel + dsel);
		} else if (e.getSource() == D2) {
			lockinansselallapply.setEnabled(true);
			dselstate++;
			if (dselstate % 2 == 0) {
				saaud = true;
				dsel = " D";
				D2.setBackground(Color.CYAN);
			} 
			else { 
				saaud = false;
				dsel = "";
				D2.setBackground(new Color(238,238,238));
			}
			selans2.setText("Selected Answers:" + asel + bsel + csel + dsel);
		} else if (e.getSource() == lockinansselallapply) {
			A2.setEnabled(false);
			B2.setEnabled(false);
			C2.setEnabled(false);
			D2.setEnabled(false);
			lockinansselallapply.setEnabled(false);
			if (saaua == true) {
				A2.setBackground(Color.RED);
			}
			if (saaub == true) {
				B2.setBackground(Color.RED);
			}
			if (saauc == true) {
				C2.setBackground(Color.RED);
			}
			if (saaud == true) {
				D2.setBackground(Color.RED);
			}
			if (saaaa == true) {
				correctanswers = correctanswers + " A";
				A2.setBackground(Color.GREEN);
			}
			if (saaab == true) {
				correctanswers = correctanswers + " B";
				B2.setBackground(Color.GREEN);
			}
			if (saaac == true) {
				correctanswers = correctanswers + " C";
				C2.setBackground(Color.GREEN);
			}
			if (saaad == true) {
				correctanswers = correctanswers + " D";
				D2.setBackground(Color.GREEN);
			}
			if (saaua == saaaa && saaub == saaab && saauc == saaac && saaud == saaad) {
				score++;
				total++;
				selans2.setText("<html><center><p> Great job! That was correct! " + score + " out of " + total + ".</p></center></html>");	
			} else {
				total++;
				selans2.setText("<html><center><p> Sorry, incorrect. " + score + " out of " + total + ". The correct answers were as follows:" + correctanswers + ".</p></center></html>");
			}
			
			Timer timer4 = new Timer(3000, new ActionListener() {
			    @Override
			    public void actionPerformed(ActionEvent e) {
			    	cl.show(CardLay, "q4");
			    }
			});
			timer4.setRepeats(false);
			timer4.start();
		} else if (e.getSource() == lockinfilb) {
			fbua = textField_1.getText();
			if (!fbua.equals("")) {
				textField_1.setEnabled(false);
				lockinfilb.setEnabled(false);
				if (fba.equalsIgnoreCase(fbua)){
					score++;
					total++;
					cifb.setText("<html><center><p> Great job! That was correct! " + score + " out of " + total + ".</p></center></html>");	
				} else { 
					total++;
					cifb.setText("<html><center><p> Sorry, incorrect. " + score + " out of " + total + ". The correct answer was: " + fba + ".</p></center></html>");
				}
				Timer timer5 = new Timer(3000, new ActionListener() {
				    @Override
				    public void actionPerformed(ActionEvent e) {
				    	cl.show(CardLay, "q5");
				    }
				});
				timer5.setRepeats(false);
				timer5.start();
			} else {
				int test = JOptionPane.showConfirmDialog(null, "Are you sure you want to submit a blank answer?", "Blank Answer", JOptionPane.YES_NO_OPTION);
				if (test == 0) {
					textField_1.setEnabled(false);
					lockinfilb.setEnabled(false);
					fbua = textField_1.getText();
					if (fba.equalsIgnoreCase(fbua)){
						score++;
						total++;
						cifb.setText("<html><center><p> Great job! That was correct! " + score + " out of " + total + ".</p></center></html>");	
					} else { 
						total++;
						cifb.setText("<html><center><p> Sorry, incorrect. " + score + " out of " + total + ". The correct answer was: " + fba + ".</p></center></html>");
					}
					Timer timer5 = new Timer(3000, new ActionListener() {
					    @Override
					    public void actionPerformed(ActionEvent e) {
					    	cl.show(CardLay, "q5");
					    }
					});
					timer5.setRepeats(false);
					timer5.start();
				}
			}
		} else if (e.getSource() == True) {
			locktrueorfalse.setEnabled(true);
			tfua = true;
			True.setBackground(Color.CYAN);
			selans3.setText("Your Answer: True");
			False.setBackground(new Color(238,238,238));
		} else if (e.getSource() == False) {
			locktrueorfalse.setEnabled(true);
			tfua = false;
			False.setBackground(Color.CYAN);
			True.setBackground(new Color(238,238,238));
			selans3.setText("Your Answer: False");
		} else if (e.getSource() == locktrueorfalse) {
		   	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		   	DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss aa");
		   	DateFormat saveformat = new SimpleDateFormat("MM-dd-yy_hh-mm-ss");
	    	datefinishtest = dateFormat.format(new Date()).toString();
	    	timefinishtest = timeFormat.format(new Date()).toString();
	    	savetest = saveformat.format(new Date()).toString();
			True.setEnabled(false);
			False.setEnabled(false);
			locktrueorfalse.setEnabled(false);
			if (tfua == true) {
				True.setBackground(Color.RED);
			}
			if (tfua == false) {
				False.setBackground(Color.RED);
			}
			if (tfa == true) {
				True.setBackground(Color.GREEN);
			}
			if (tfa == false) {
				False.setBackground(Color.GREEN);
			}
			if (tfua == tfa) {
				score++;
				total++;
				selans3.setText("<html><center><p> Great job! That was correct! " + score + " out of " + total + ".</p></center></html>");
			} else { 
				total++;
				selans3.setText("<html><center><p> Sorry, incorrect. " + score + " out of " + total + ". The correct answer was " + tfa + ".</p></center></html>");
			}
			if (score >= 4) {
				scorelabel.setText("<html><center><p>Great job, " + name + "! You got " + score + " out of " + total + "! Do you wish to save these results?</p></center></html>");
			} else if (score < 4 && score >= 2) {
				scorelabel.setText("<html><center><p>Not bad, " + name + "! You got " + score + " out of " + total + "! Do you want to save these results? I am sure you could do better.</p></center></html>");
			} else if (score < 2) {
				scorelabel.setText("<html><center><p>Tough luck, " + name + ". You got " + score + " out of " + total + ". Do you still wish to save these results? You could definitely do better.</p></center></html>");
			}
			Timer timer6 = new Timer(3000, new ActionListener() {
			    @Override
			    public void actionPerformed(ActionEvent e) {
			    	cl.show(CardLay, "finalscore");
			    }
			});
			timer6.setRepeats(false);
			timer6.start();
		} else if (e.getSource() == nosave) {
			nosave.setEnabled(false);
			save.setEnabled(false);
			JOptionPane.showMessageDialog(null, "Ok, see you later!");
			System.exit(0);
		} else if (e.getSource() == save) {
			nosave.setEnabled(false);
			save.setEnabled(false);
			JFileChooser fileChooser2 = new JFileChooser();
            fileChooser2.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fileChooser2.setDialogTitle("Where do you want to save your results?");
            int option = fileChooser2.showOpenDialog(frmTheFblaQuizzler);
     
	            if(option == JFileChooser.APPROVE_OPTION){
	       		 	File file2 = fileChooser2.getSelectedFile();
	       		 	String rdir = file2.getAbsolutePath();
	            	printResults(rdir);
	            	JOptionPane.showMessageDialog(null, "Ok, see you later! Your file is saved at " + rdir + fbs + name + "_FBLAQ_" + savetest + ".html");
	            	try {
						Desktop.getDesktop().open(new File(rdir + fbs + name + "_FBLAQ_" + savetest + ".html"));
					} catch (IOException e1) {
					}
	            	System.exit(0);
	            } else {
	            	JOptionPane.showMessageDialog(null, "Ok, see you later!");
	            	System.exit(0);
	    		
	            }
		}
	}
	//Decides to do upon a slider value change
	public void stateChanged(ChangeEvent event) {
		lockinans.setEnabled(true);
		selnumber.setText("Value: " + slider.getValue());
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	 
	//Launches the application
	public static void main(String[] args) {	
		if (qdir.contains("/")) {
			path = "/Questions.txt";
			fbs= "/";
		}
		else if (qdir.contains("\\")) {
			path = "\\Questions.txt";
			fbs = "\\";
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FBLAQuizzler window = new FBLAQuizzler();
					FBLAQuizzler.frmTheFblaQuizzler.setVisible(true);
					try {
						System.out.println(Files.readAllLines(Paths.get(qdir + path)).get(3));
					}
					catch (IOException e) {
						int qtxtnotfound = JOptionPane.showConfirmDialog(null, "Questions.txt was not found. Do you want to download a sample question set?", "Questions.txt was not found", JOptionPane.YES_NO_OPTION);
						if (qtxtnotfound == 0) {
							JFileChooser fileChooser = new JFileChooser();
				            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				            fileChooser.setDialogTitle("Choose where to save Questions.txt");
				            int option = fileChooser.showOpenDialog(frmTheFblaQuizzler);
				            if(option == JFileChooser.APPROVE_OPTION){
				            	File file = fileChooser.getSelectedFile();
				            	qdir = file.getAbsolutePath();
				            	download("https://raw.githubusercontent.com/Vishram1123/The-FBLA-Quizzler/main/Questions.txt", qdir + path);
				            } else {
				            	System.exit(0);
				            }
			            } else { 
			            	JFileChooser fileChooser = new JFileChooser();
				            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				            fileChooser.setDialogTitle("Choose the directory that Questions.txt is in.");
				            int option = fileChooser.showOpenDialog(frmTheFblaQuizzler);
				            if(option == JFileChooser.APPROVE_OPTION){
				            	File file = fileChooser.getSelectedFile();
				            	qdir = file.getAbsolutePath();
				            	while (true) {
					            	if (new File(qdir + path).isFile() == true) {
					            		break;
					            	} else {
					            		option = fileChooser.showOpenDialog(frmTheFblaQuizzler);
					            	}
				            	}
				            } else {
				            	System.exit(0);
				            }
			            }
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}