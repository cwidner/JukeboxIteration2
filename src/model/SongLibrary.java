package model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;


/**
 * Stores all the songs into a collection.
 * 
 * @author Colin Widner and Qiming Wan
 *
 */
public class SongLibrary implements TableModel, Serializable {
	
	private ArrayList<Song> songs;
	private static SongLibrary library;
	
	/*
	 * The SongCollection constructor.
	 */
	private SongLibrary() {
		songs = new ArrayList<>();
		populateLibrary();
	}
	
	private void populateLibrary() {
		Song a = new Song("DanseMacabreViolinHook.mp3");
		a.setArtistName("Kevin MacLeod");
		a.setSongTitle("Danse Macabre");
		a.setSongLength(34);

		Song b = new Song("DeterminedTumbao.mp3");
		b.setArtistName("FreePlay Music");
		b.setSongTitle("Determined Tumbao");
		b.setSongLength(20);

		Song c = new Song("flute.aif");
		c.setArtistName("Sun Microsystems");
		c.setSongTitle("Flute");
		c.setSongLength(5);

		Song d = new Song("LopingSting.mp3");
		d.setArtistName("Kevin MacLeod");
		d.setSongTitle("Loping Sting");
		d.setSongLength(4);

		Song e = new Song("spacemusic.au");
		e.setArtistName("Unknown");
		e.setSongTitle("Space Music");
		e.setSongLength(6);

		Song f = new Song("SwingCheese.mp3");
		f.setArtistName("FreePlay Music");
		f.setSongTitle("Swing Cheese");
		f.setSongLength(15);

		Song g = new Song("tada.wav");
		g.setArtistName("Microsoft");
		g.setSongTitle("Tada ");
		g.setSongLength(2);

		Song h = new Song("TheCurtainRises.mp3");
		h.setArtistName("Kevin MacLeod");
		h.setSongTitle("The Curtain Rises");
		h.setSongLength(28);

		Song i = new Song("UntameableFire.mp3");
		i.setArtistName("Pierre Langer");
		i.setSongTitle("Untameable Fire");
		i.setSongLength(282);

		addSong(a);
		addSong(b);
		addSong(c);
		addSong(d);
		addSong(e);
		addSong(f);
		addSong(g);
		addSong(h);
		addSong(i);
	}
	
	public Song getSongFromIndex(int i){
		return songs.get(i);
		
		
	}
	public static SongLibrary getInstance() {
		if(library == null)
			library = new SongLibrary();
		
		return library;
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
	public boolean contains(String title) {
	  for(int i = 0; i < songs.size(); i++) {
		  if(title.equals(songs.get(i).getTitle()))
			  return true;
	  }
	  return false;
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

	@Override
	public int getRowCount() {
		
		return songs.size();
	}

	@Override
	public int getColumnCount() {
		
		return 3;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch(columnIndex) {
		case 0:
			return "Artist";
		case 1:
			return "Title";
		case 2:
			return "Seconds";
		default:
			return null;
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if(columnIndex <= 1)
			return String.class;
		
		return Integer.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Song selected = songs.get(rowIndex);
		
		switch(columnIndex) {
		case 0:
			return selected.getArtist();
		case 1:
			return selected.getTitle();
		case 2:
			return selected.getSongLength();
		default:
			return null;
		}
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		
	}

}
