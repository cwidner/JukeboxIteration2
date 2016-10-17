package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.Song;
import model.SongLibrary;

public class SongLibraryTest {
	@Test
	public void testContainsAndGet(){
    SongLibrary songs = SongLibrary.getInstance();	
	
	assertFalse(songs.contains("abcdef"));
	assertTrue(songs.contains("Flute"));
	assertNull(songs.getSong("asdfasdf"));
	Song s = songs.getSong("Flute");
	assertEquals("flute.aif", s.getFileName());
	assertEquals("Flute", s.getTitle());
	assertEquals("Sun Microsystems", s.getArtist());
	assertEquals(5, s.getSongLength());
	
	}
	
	@Test
	public void testJTableMethods() {
		SongLibrary lib = SongLibrary.getInstance();
		
		assertEquals(9, lib.getRowCount());
		assertEquals(3, lib.getColumnCount());
		
		assertEquals("Artist", lib.getColumnName(0));
		assertEquals("Title", lib.getColumnName(1));
		assertEquals("Seconds", lib.getColumnName(2));
		assertNull(lib.getColumnName(3));
		
		assertEquals(String.class, lib.getColumnClass(0));
		assertEquals(Integer.class, lib.getColumnClass(2));
		
		assertFalse(lib.isCellEditable(0, 0));
		
		assertEquals("Sun Microsystems", lib.getValueAt(2, 0));
	}
	
}
