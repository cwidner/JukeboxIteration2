package model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This class stores the filename of a song file and other information of the song.
 * @author Colin Widner and Qiming Wan
 *
 */
public class Song {
	
	private String fileName;
	private String artistName;
	private String songTitle;
	private ArrayList<LocalDate> timesPlayed;
	private int length;
	
	/*
	 * The song constructor.
	 * 
	 * Parameters:
	 * 	file - The filename of the song file.
	 */
	public Song(String file) {
		this.fileName = file;	
		this.timesPlayed = new ArrayList<>();
	}
	
	/*
	 * Returns the filename of the Song.
	 * 
	 * Returns: A String that is the filename of the Song.
	 */
	public String getFileName() {
		return this.fileName;
	}
	
	/*
	 * Sets the name of the artist of the song.
	 * 
	 * Parameters:
	 * 	artist - The name of the artist.
	 */
	public void setArtistName(String artist){
		this.artistName = artist;
		return;
	}
	
	/*
	 * Returns the name of the artist of the song.
	 * 
	 * Returns: A String that is the name of the artist of the song.
	 */
	public String getArtist() {
		return this.artistName;
	}
	
	/*
	 * Sets the title of the song.
	 * 
	 * Parameters:
	 * 	songTitle - The title of the song.
	 */
	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}
	
	/*
	 * Returns the title of the song.
	 * 
	 * Returns: A String that is the title of the song.
	 */
	public String getTitle() {
		return this.songTitle;
	}
	
	/*
	 * Sets the length of the song.
	 * 
	 * Parameters:
	 * 	songLength - The length of the song in seconds.
	 */
	public void setSongLength(int songLength){
		this.length = songLength;
	}
	
	/*
	 * Returns the length of the song.
	 * 
	 * Returns: An int that is the length of the song in seconds.
	 */
	public int getSongLength(){
		return length;
	}
	
	/*
	 * Determines if the song can be played on the given day.
	 * 
	 * Parameters:
	 * 	d - The current date.
	 * 
	 * Returns: False if the song was played three times on the given day,
	 * true otherwise.
	 */
	public boolean canPlay(LocalDate d) {
		if (timesPlayed.size() < 3)
			return true;
		
		for(int i = 0; i < timesPlayed.size(); i++) {
			if(d.compareTo(timesPlayed.get(i)) != 0)
				return true;
		}
		return false;
	}
	
	/*
	 * Adds the most recent time played in the ArrayList
	 * 
	 * Parameters:
	 * 	d - The current date.
	 */
	public void play(LocalDate d){
		if (timesPlayed.size() < 3) {
			timesPlayed.add(d);
			return;
		}
		
		for(int i = 0; i < timesPlayed.size(); i++) {
			if(d.compareTo(timesPlayed.get(i)) != 0) {
				timesPlayed.remove(i);
				timesPlayed.add(d);
				return;
			}
		}
	}

}
