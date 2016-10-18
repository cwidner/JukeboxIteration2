package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


//import controller.Jukebox;
import model.JukeboxAccount;
import model.SongLibrary;
import model.SongQueue;




public class JukeboxGUI extends JFrame {

	public static void main(String[] args) {
		JukeboxGUI g = new JukeboxGUI();
		g.setVisible(true);
	}

	//private static Jukebox box;
	private static JukeboxAccount currentUser;
    private static LocalDate today;
    private static JButton arrowButton;
    private static JPanel wrapper;
	
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
		 

	
		    signInBoard=new JPanel();
		  
		    signInBoard.setLayout(new FlowLayout());
		    view = new JPanel();
		    view.setPreferredSize(new Dimension(280,80));
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

//			signIn.addActionListener(new ButtonListener());
//			signOut.addActionListener(new ButtonListener());
	 
	        signInBoard.setPreferredSize(new Dimension(280,200));
			return signInBoard;
 }
 


	public JukeboxGUI() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocation(100, 30);
	    this.setLayout(new BorderLayout(20,10));
	    wrapper=new JPanel();
	    wrapper.setLayout(new BorderLayout(10,10));
		box = new Jukebox();
		currentUser = null;
		today = LocalDate.now();

	//	ButtonListener log = new ButtonListener();
	    
		  // set up the JFrame
	    setTitle("Jukebox");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocation(30, 30);
	    
	   
	    // TODO: 2) Need a new StudentCollection as our model
	    SongLibrary songCollection = SongLibrary.getInstance();
	 
	    // TODO: 3) Construct the JTable (table) with our model as an argument (could use setModel)
	    JTable table = new JTable();
	    table.setModel(songCollection);
	    table.setShowHorizontalLines(false);
	    table.setShowVerticalLines(false);
	      
	    // TODO: 4) Construct a JScrollPane to decorate table so that if the data exceeds the 
	    // side of the table in the  GUI, then it automatically becomes scrollable.
	    JScrollPane sc = new JScrollPane(table);
	    sc.setPreferredSize(new Dimension(450,465));
	    JPanel scWrap=new JPanel();
	    JLabel selectSong=new JLabel("Select a Song from this Jukebox");
	   

	    // Set the label's font size to the newly determined size.
	    selectSong.setFont(new Font("Courier New", Font.BOLD, 20));
	    selectSong.setForeground(Color.BLUE);

	    
	    selectSong.setSize(300, 20);
	    scWrap.add(selectSong);
	    scWrap.add(sc);
	    scWrap.setLayout(new FlowLayout(FlowLayout.LEFT));
	    scWrap.setPreferredSize(new Dimension(455,450));
	    
	    
	    
	   wrapper.add(scWrap,BorderLayout.EAST);
	    
	    
	   RowSorter<TableModel> rs = new TableRowSorter<TableModel>(songCollection);
	   
	   table.setRowSorter(rs);
	    
	
	   
	    JPanel songAndAccountPanel = new JPanel();
	    
	    
	    SongQueue playList = SongQueue.getInstance();	 
	    JList list = new JList();
	    list.setModel(playList);	    
	    JScrollPane sc2 = new JScrollPane(list);	
	   sc2.setPreferredSize(new Dimension(280,350));
	    
	    JLabel playlistLabel=new JLabel("Play list(song at top is playing)");
	    songAndAccountPanel.add(playlistLabel);
	    songAndAccountPanel.add(sc2);
	    songAndAccountPanel.add(JukeboxGUI.signInBoard());
	    songAndAccountPanel.setPreferredSize(new Dimension(290,500));
	    songAndAccountPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
	
	//    songAndAccountPanel.setBorder(new EmptyBorder( 10, 20, 10, 0 ) );
	    wrapper.add(songAndAccountPanel,BorderLayout.WEST);
	      
	    JButton button = new JButton();
	    button.setText("Play");
	    button.setBorder(null);
	    button.setPreferredSize(new Dimension(40, 40));
	    
//	    try {
//	      Image img = ImageIO.read(getClass().getResource("songfiles/leftarrow.jpg"));
//	      button.setIcon(new ImageIcon(img));
//	    } catch (IOException ex) {
//	    }
	    JPanel panel = new JPanel();
	    panel.setLayout(new GridBagLayout());
	//    GridBagConstraints gbc = new GridBagConstraints();
	//    gbc.gridwidth = GridBagConstraints.REMAINDER;
	//   gbc.fill = GridBagConstraints.HORIZONTAL;
	    
	    panel.setPreferredSize(new Dimension(40, 100));
	  
	    panel.add(button);

	
	    wrapper.add(panel, BorderLayout.CENTER);
      
	    // Listen to the button click
//	    button.addActionListener(new ButtonListener());
	    wrapper.setBorder(BorderFactory.createEmptyBorder(5, 36, 30, 36));
	    this.add(wrapper);
	    this.pack();
	
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