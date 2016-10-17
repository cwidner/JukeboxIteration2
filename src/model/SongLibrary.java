package model;

import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 * Stores all the songs into a collection.
 * 
 * @author Colin Widner and Qiming Wan
 *
 */
public class SongLibrary implements TableModel {
	
	private ArrayList<Song> songs;
	
	/*
	 * The SongCollection constructor.
	 */
	public SongLibrary() {
		songs = new ArrayList<>();
	}
	
	/*
	 * Adds a Song to the collection.
	 * 
	 * Parameters:
	 * 	s - The Song to be added to the collection.
	 */
	public void addSong(Song s) {
		songs.add(s);
	}
	
	/*
	 * Determines if the collection has a specific song.
	 * 
	 * Parameters:
	 * 	s - The song to search for.
	 * 
	 * Returns: True if the song is in the collection, false otherwise.
	 */
	public boolean contains(Song s) {
	  return songs.contains(s);
	}
	
	/*
	 * Searches the collection to find and return a specific song.
	 * 
	 * Parameters:
	 * 	title - The title of the song to search for.
	 * 
	 * Returns: A Song object of the one searched for.
	 */
	public Song getSong(String title) {
		for(int i = 0; i < songs.size(); i++) {
			if(title.equals(songs.get(i).getTitle()))
				return songs.get(i);
		}
		
		return null;
	}
	
	/**
	 * NEED TO DO EVERY METHOD LISTED BELOW.
	 */

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

}
