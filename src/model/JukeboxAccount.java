package model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * 
 * @author Colin Widner and Qiming Wan
 * 
 *         This class acts as a student account for the jukebox. It stores the
 *         student's username, password, and the amount of credit left in the
 *         student's account. The class also keeps track how many songs the
 *         student has played on the current day.
 *
 */
public class JukeboxAccount {

	private String name;
	private String password;
	private int credit;
	private ArrayList<LocalDate> timesPlayed;

	/*
	 * The JukeboxAccount constructor
	 * 
	 * Parameters: n - The username of the account p - The password of the
	 * account
	 */
	public JukeboxAccount(String n, String p) {
		this.name = n;
		this.password = p;
		this.credit = 90000;
		this.timesPlayed = new ArrayList<>();
	}

	/*
	 * Returns the username of the JukeboxAccount object.
	 * 
	 * Returns: A String that represents the username of the JukeboxAccount
	 * object.
	 */
	public String getName() {
		return this.name;
	}

	/*
	 * Returns the password of the JukeboxAccount object.
	 * 
	 * Returns: A String that represents the password of the JukeboxAccount
	 * object.
	 */
	public String getPassword() {
		return this.password;
	}

	/*
	 * Returns the amount of time left on the JukeboxAccount object in seconds.
	 * 
	 * Returns: An integer that is the amount of seconds left in the
	 * JukeboxAccount object.
	 */
	public int getCredit() {
		return this.credit;
	}

	/*
	 * Counts the amount of times the JukeboxAccount has played a song on the
	 * current day.
	 * 
	 * Parameters: d - The date to compare how many times the JukeboxAccount has
	 * played a song.
	 * 
	 * Returns: An integer that determines the amount of times the
	 * JukeboxAccount has played a song on the current day.
	 * 
	 */
	public int timesPlayed(LocalDate d) {
		int times = 0;

		for (int i = 0; i < timesPlayed.size(); i++) {
			if (d.compareTo(timesPlayed.get(i)) == 0)
				times++;
		}
		return times;
	}

	/*
	 * Determines whether or not the JukeboxAccount can play a song on the given
	 * day.
	 * 
	 * Parameters: d - The date to compare how many times the JukeboxAccount has
	 * played a song.
	 * 
	 * Returns: False if the JukeboxAccount has played a song three times on the
	 * given day, true if less.
	 */
	public boolean canPlay(LocalDate d) {

		if (timesPlayed.size() < 3)
			return true;

		for (int i = 0; i < timesPlayed.size(); i++) {
			if (d.compareTo(timesPlayed.get(i)) != 0)
				return true;
		}
		return false;
	}

	/*
	 * Adds the date played to the times played record when a song is played on
	 * this JukeboxAccount.
	 * 
	 * Parameters: d - The date to compare how many times the JukeboxAccount has
	 * played a song.
	 */
	public void play(LocalDate d) {
		if (timesPlayed.size() < 3) {
			timesPlayed.add(d);
			return;
		}

		for (int i = 0; i < timesPlayed.size(); i++) {
			if (d.compareTo(timesPlayed.get(i)) != 0) {
				timesPlayed.remove(i);
				timesPlayed.add(d);
				return;
			}
		}

	}

	/*
	 * Withdraws the amount of time the account has left by the time of the song
	 * played.
	 * 
	 * Parameters: time - The amount of time the song is.
	 */
	public void withdraw(int time) {
		this.credit = credit - time;
	}
}
