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
import java.io.File;
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

import model.Jukebox;
//import controller.Jukebox;
import model.JukeboxAccount;
import model.JukeboxAccountCollection;
import model.Song;
import model.SongLibrary;
import model.SongQueue;

public class JukeboxGUI extends JFrame {

	public static void main(String[] args) {
		JukeboxGUI g = new JukeboxGUI();
		g.setVisible(true);
	}

	private static Jukebox box;
	private static JTextField userInput;
	private static JPasswordField passInput;
	private static JLabel status;
	private static TableModel model;
	private static JTable table;
	private static JList<SongQueue> list;

	private static JukeboxAccount currentUser;
	private static LocalDate today;
	private static JButton arrowButton;
	private static JPanel wrapper;
	private static SongQueue playlist;

	private static JPanel signInBoard() {
		JPanel signInBoard;
		JPanel view;
		JLabel user;
		JLabel word;
		// JTextField userInput;
		// JPasswordField passInput;
		JButton signIn;
		JButton signOut;
		// JLabel status;

		signInBoard = new JPanel();

		signInBoard.setLayout(new FlowLayout());
		view = new JPanel();
		view.setPreferredSize(new Dimension(280, 80));
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

		ButtonListener push = new ButtonListener();

		signIn.addActionListener(push);
		signOut.addActionListener(push);

		signInBoard.setPreferredSize(new Dimension(280, 200));
		return signInBoard;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JukeboxGUI() {
		
		
		
		
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocation(100, 30);
		this.setLayout(new BorderLayout(20, 10));
		wrapper = new JPanel();
		wrapper.setLayout(new BorderLayout(10, 10));
		box = new Jukebox();
		currentUser = null;
		today = LocalDate.now();

		setTitle("Jukebox");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(30, 30);

		model = box.getLibrary();

		table = new JTable(model);
		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);

		JScrollPane sc = new JScrollPane(table);
		sc.setPreferredSize(new Dimension(450, 465));
		JPanel scWrap = new JPanel();
		JLabel selectSong = new JLabel("Select a Song from this Jukebox");

		// Set the label's font size to the newly determined size.
		selectSong.setFont(new Font("Courier New", Font.BOLD, 20));
		selectSong.setForeground(Color.BLUE);

		selectSong.setSize(300, 20);
		scWrap.add(selectSong);
		scWrap.add(sc);
		scWrap.setLayout(new FlowLayout(FlowLayout.LEFT));
		scWrap.setPreferredSize(new Dimension(455, 450));

		wrapper.add(scWrap, BorderLayout.EAST);

		RowSorter<TableModel> rs = new TableRowSorter<TableModel>(model);

		table.setRowSorter(rs);

		JPanel songAndAccountPanel = new JPanel();

		playlist = box.getQueue();
		list = new JList<SongQueue>(playlist);
		JScrollPane sc2 = new JScrollPane(list);
		sc2.setPreferredSize(new Dimension(280, 350));

		JLabel playlistLabel = new JLabel("Play list(song at top is playing)");
		songAndAccountPanel.add(playlistLabel);
		songAndAccountPanel.add(sc2);
		songAndAccountPanel.add(JukeboxGUI.signInBoard());
		songAndAccountPanel.setPreferredSize(new Dimension(290, 500));
		songAndAccountPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

		wrapper.add(songAndAccountPanel, BorderLayout.WEST);

		JButton button = new JButton();
		button.setText("<-");
		button.setPreferredSize(new Dimension(40, 40));

		/*
		 * try { Image img = ImageIO.read(new File("songfiles/leftarrow.jpg"));
		 * button.setIcon(new ImageIcon(img)); } catch (IOException ex) { }
		 */

		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());

		panel.setPreferredSize(new Dimension(40, 100));

		panel.add(button);

		wrapper.add(panel, BorderLayout.CENTER);

		button.addActionListener(new ButtonListener());
		wrapper.setBorder(BorderFactory.createEmptyBorder(5, 36, 30, 36));
		this.add(wrapper);
		this.pack();

	}

	private static class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String text = ((JButton) e.getSource()).getText();
			today = LocalDate.now();

			if (text.equals("Login")) {
				if (box.isAccount(userInput.getText())) {
					char[] passwordInChars = passInput.getPassword();
					String pass = "";
					for (int i = 0; i < passwordInChars.length; i++) {
						pass += passwordInChars[i];
					}
					if (box.passwordMatches(userInput.getText(), pass)) {
						currentUser = box.getAccount(userInput.getText());
						String hoursLeft = String.format("%02d:", (currentUser.getCredit() / 60) / 60);
						String minutesLeft = String.format("%02d:", (currentUser.getCredit() / 60) % 60);
						String secondsLeft = String.format("%02d", currentUser.getCredit() % 60);

						status.setText(currentUser.getName() + " logged in, " + currentUser.timesPlayed(today)
								+ " selected, " + hoursLeft + minutesLeft + secondsLeft);
					} else {
						JOptionPane.showMessageDialog(null, "username/password are incorrect");
					}
				} else {
					JOptionPane.showMessageDialog(null, "User does not exist");
				}

			}

			else if (text.equals("Sign out")) {
				currentUser = null;
				status.setText("Status: Sign in to play music");
				userInput.setText("");
				passInput.setText("");
			}

			else if (text.equals("<-")) {
				if (currentUser == null)
					JOptionPane.showMessageDialog(null, "Sign in to play music");
				else {
					today = LocalDate.now();
					if (!currentUser.canPlay(today))
						JOptionPane.showMessageDialog(null, "User daily play limit reached");
					else {
						int selectedRow = table.convertRowIndexToModel(table.getSelectedRow());
						Song s = box.getSong((String) model.getValueAt(selectedRow, 1));
						if (!s.canPlay(today)) {
							JOptionPane.showMessageDialog(null, "Song daily play limit reached");
						} else {
							currentUser.play(today);
							s.play(today);
							currentUser.withdraw(s.getSongLength());

							String hoursLeft = String.format("%02d:", (currentUser.getCredit() / 60) / 60);
							String minutesLeft = String.format("%02d:", (currentUser.getCredit() / 60) % 60);
							String secondsLeft = String.format("%02d", currentUser.getCredit() % 60);
							status.setText(currentUser.getName() + " logged in, " + currentUser.timesPlayed(today)
									+ " selected, " + hoursLeft + minutesLeft + secondsLeft);

							if (!box.isPlaying()) {
								box.addToQueue(s);
								box.play();
							} else {
								box.addToQueue(s);
							}

						}
					}
				}
			}

		}

	}
}