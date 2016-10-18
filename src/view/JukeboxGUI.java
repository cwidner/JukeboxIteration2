package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


import controller.Jukebox;
import controller.JukeboxAccount;
import model.JukeboxAccountCollection;
import model.SongLibrary;
import model.SongQueue;




public class JukeboxGUI extends JFrame {

	public static void main(String[] args) {
		JukeboxGUI g = new JukeboxGUI();
		g.setVisible(true);
	}

	private static Jukebox box;
	private static JukeboxAccount currentUser;
    private static LocalDate today;
	
 private static JPanel signInBoard(){
	     JPanel signInBoard;
		 JPanel view;
		 JLabel user;
		 JLabel word;
		 JTextField userInput;
		 JPasswordField passInput;
		 JButton signIn;
		 JButton signOut;
		 JLabel status;
		 JButton arrowButton;

	
		    signInBoard=new JPanel();
		    signInBoard.setSize(250,150);
		    signInBoard.setLayout(new FlowLayout());
		    view = new JPanel();
			view.setLayout(new GridLayout(3, 3));
			user = new JLabel("Account Name");
			word = new JLabel("Password");
			userInput = new JTextField();
			passInput = new JPasswordField(15);
			signIn = new JButton("Login");
			signOut = new JButton("Sign out");
			status = new JLabel("Status: Sign in to play music");
			
			view.add(user);
			view.add(userInput);
			view.add(word);
			view.add(passInput);
			view.add(signOut);
			view.add(signIn);
			
			signInBoard.add(view);
			signInBoard.add(status);

			signIn.addActionListener(new ButtonListener());
			signOut.addActionListener(new ButtonListener());
	 
	    
			return signInBoard;
 }
 


	public JukeboxGUI() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(400, 200);
		this.setLocation(100, 30);
		this.setLayout(new FlowLayout());
		box = new Jukebox();
		currentUser = null;
		today = LocalDate.now();

		ButtonListener log = new ButtonListener();
	    
		  // set up the JFrame
	    setTitle("Jukebox");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(700, 800);
	    setLocation(30, 30);
	    
	   
	    // TODO: 2) Need a new StudentCollection as our model
	    SongLibrary songCollection = SongLibrary.getInstance();
	 
	    // TODO: 3) Construct the JTable (table) with our model as an argument (could use setModel)
	    JTable table = new JTable();
	    table.setModel(songCollection);
	      
	    // TODO: 4) Construct a JScrollPane to decorate table so that if the data exceeds the 
	    // side of the table in the  GUI, then it automatically becomes scrollable.
	    JScrollPane sc = new JScrollPane(table);
	    // TODO: 5) Add JScrollPane to this JFrame
	    this.add(sc);
	    
	    
	   RowSorter<TableModel> rs = new TableRowSorter<TableModel>(songCollection);
	   
	   table.setRowSorter(rs);
	    
	    // TODO: Run this code to see if the JTable appears (no code to write)

	    
	    // TODO: 6) Construct a new RowSorter<TableModel> to be a TableRowSorter
	    // while setting its model to model
	 
	    // TODO: 7) Link up table and the sorter
	 
	    // Layout the GUI
	   
	    JPanel songAndAccountPanel = new JPanel();
	    
	    
	    SongQueue playList = SongQueue.getInstance();	 
	    JList list = new JList();
	    list.setModel(playList);	    
	    JScrollPane sc2 = new JScrollPane(list);	 
	    songAndAccountPanel.add(sc2);
	    songAndAccountPanel.add(JukeboxGUI.signInBoard());
	    this.add(sc2,BorderLayout.WEST);
	      
	    JButton button = new JButton("Click me!");
	    JPanel panel = new JPanel();
	    panel.setMaximumSize(new Dimension(30, 30));
	    panel.add(button);
	    add(panel, BorderLayout.CENTER);

	    // Listen to the button click
	    button.addActionListener(new ButtonListener());
	    
	    
	
	}
//
//	private class ButtonListener implements ActionListener {
//
//		public void actionPerformed(ActionEvent e) {
//			String text = ((JButton) e.getSource()).getText();
//			today = LocalDate.now();
//			if (text.equals("Login")) {
//				char[] passwordInChars = passInput.getPassword();
//				String username = userInput.getText();
//
//				if (box.isAccount(username)) {
//					String pass = "";
//					
//					for (int i = 0; i < passwordInChars.length; i++) {
//						pass += passwordInChars[i];
//					}
//					
//					if(box.passwordMatches(username, pass)) {
//						currentUser = box.getAccount(username);
//						String hoursLeft = String.format("%02d", currentUser.getCredit()/60/60);
//						String minutesLeft = String.format("%02d", currentUser.getCredit()/60%60);
//						String secondsLeft = String.format("%02d", currentUser.getCredit()%60);
//						status.setText(currentUser.timesPlayed(today) + " played, " + hoursLeft  + ":" +
//						 minutesLeft + ":" + secondsLeft);
//					} else {
//						status.setText("Status: Invalid username/password");
//					}
//				} else {
//					status.setText("Status: username does not exist");
//				}
//
//			}
//
//			if (text.equals("Sign out")) {
//				currentUser = null;
//				status.setText("Status: Sign in to play music");
//				userInput.setText("");
//				passInput.setText("");
//			}
//			
//			if(text.equals("Play song 1")) {
//				Song s = box.getSong("Flute");
//				
//				if(currentUser == null) {
//					JOptionPane.showMessageDialog(null, "ERROR: Must sign in to play songs");
//				
//				} else if(!s.canPlay(today)) {
//					JOptionPane.showMessageDialog(null, "ERROR: Song daily play limit reached");
//				
//				} else if(!currentUser.canPlay(today)) {
//					JOptionPane.showMessageDialog(null, "ERROR: Account daily play limit reached");
//				
//				} else {
//					s.play(today);
//					currentUser.play(today);
//					
//					currentUser.withdraw(s.getSongLength());
//					
//					String hoursLeft = String.format("%02d", currentUser.getCredit()/60/60);
//					String minutesLeft = String.format("%02d", currentUser.getCredit()/60%60);
//					String secondsLeft = String.format("%02d", currentUser.getCredit()%60);
//					status.setText(currentUser.timesPlayed(today) + " played, " + hoursLeft  + ":" +
//							 minutesLeft + ":" + secondsLeft);
//					
//					if(!box.isPlaying()) {
//						box.addToQueue(s);
//						box.play();
//					} else
//						box.addToQueue(s);
//				}
//				
//			}
//			
//			if(text.equals("Play song 2")) {
//				Song s = box.getSong("Space Music");
//				
//				if(currentUser == null) {
//					JOptionPane.showMessageDialog(null, "ERROR: Must sign in to play songs");
//				
//				} else if(!s.canPlay(today)) {
//					JOptionPane.showMessageDialog(null, "ERROR: Song daily play limit reached");
//				
//				} else if(!currentUser.canPlay(today)) {
//					JOptionPane.showMessageDialog(null, "ERROR: Account daily play limit reached");
//				
//				} else {
//					s.play(today);
//					currentUser.play(today);
//					
//					currentUser.withdraw(s.getSongLength());
//					
//					String hoursLeft = String.format("%02d", currentUser.getCredit()/60/60);
//					String minutesLeft = String.format("%02d", currentUser.getCredit()/60%60);
//					String secondsLeft = String.format("%02d", currentUser.getCredit()%60);
//					status.setText(currentUser.timesPlayed(today) + " played, " + hoursLeft  + ":" +
//							 minutesLeft + ":" + secondsLeft);
//					
//					if(!box.isPlaying()) {
//						box.addToQueue(s);
//						box.play();
//					} else
//						box.addToQueue(s);
//				}
//			}
	//	}
//	}
}