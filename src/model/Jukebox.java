package model;

import songplayer.EndOfSongEvent;
import songplayer.EndOfSongListener;
import songplayer.SongPlayer;

/**
 * This class coordinates all activities for the Jukebox.
 * 
 * @author Colin Widner and Qiming Wan
 *
 */
public class Jukebox {

	public static String baseDir = System.getProperty("user.dir") + System.getProperty("file.separator") + "src/songfiles"
			+ System.getProperty("file.separator");
	
	private JukeboxAccountCollection accounts;
	private SongLibrary songs;
	private SongQueue queue;
	private boolean playing;

	/*
	 * The Jukebox constructor.
	 */
	public Jukebox() {
		this.accounts = JukeboxAccountCollection.getInstance();
		this.songs = SongLibrary.getInstance();
		this.queue = new SongQueue();
		this.playing = false;
	}

	/*
	 * Determines if the username is paired to a JukeboxAccount in the collection.
	 * 
	 * Parameters:
	 * 	student - The username of the account to search for.
	 * 
	 * Returns: True if the account was found, false otherwise.
	 */
	public boolean isAccount(String username) {
		return accounts.contains(username);
	}
	
	/*
	 * Determines if the username and password match for the JukeboxAccount
	 * 
	 * Parameters:
	 * 	username - The username entered.
	 * 	password - The password entered.
	 * 
	 * Returns: True if the username and password match in the JukeboxAccount, false otherwise.
	 */
	public boolean passwordMatches(String username, String password) {
		JukeboxAccount a = accounts.getAccount(username);
		
		if(password.equals(a.getPassword()))
			return true;
		else
			return false;
	}
	
	/*
	 * Returns the account desired
	 * 
	 * Parameters:
	 * 	username - The username of the account to search for.
	 * 
	 * Returns: A JukeboxAccount object that is desired.
	 */
	public JukeboxAccount getAccount(String username) {
		return accounts.getAccount(username);
	}
	
	/*
	 * Returns the song desired
	 * 
	 * Parameters:
	 * 	title - The song title to search for in the song collection
	 * 
	 * Returns: The desired Song object.
	 */
	public Song getSong(String title) {
		return songs.getSong(title);
	}
	
	public SongLibrary getLibrary() {
		return songs;
	}
	
	public SongQueue getQueue() {
		return queue;
	}

	/*
	 * Adds a song to the queue.
	 * 
	 * Parameters:
	 * 	s - The song to add to the queue.
	 */
	public void addToQueue(Song s) {
		queue.addSong(s);
	}
	
	/*
	 * Determines if a song is currently playing.
	 * 
	 * Returns: True if a song is currently playing, false otherwise.
	 */
	public boolean isPlaying() {
		return this.playing;
	}
	
	/*
	 * Plays the song at the beginning of the queue.
	 */
	public void play() {
		
		if (!queue.isEmpty()) {
			playing = true;
			Song s = queue.pop();
			SongPlayer.playFile(new SongWaiter(), baseDir + s.getFileName());
		}
		return;
	}
	
	private class SongWaiter implements EndOfSongListener {

		@Override
		public void songFinishedPlaying(EndOfSongEvent eventWithFileNameAndDateFinished) {
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			playing = false;
			play();
		}
	
	}
}
