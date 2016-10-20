package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Song;
import model.SongQueue;

public class SongQueueTest {

	@Test
	public void testConstructorAndGetters() {
		SongQueue q = SongQueue.getInstance();
		
		assertEquals(3, q.getSize());
	}

	@Test
	public void testAddSong() {
		SongQueue q = SongQueue.getInstance();
		
		Song a = new Song("DanseMacabreViolinHook.mp3");
		a.setArtistName("Kevin MacLeod");
		a.setSongTitle("Danse Macabre");
		a.setSongLength(34);

		Song b = new Song("DeterminedTumbao.mp3");
		b.setArtistName("FreePlay Music");
		b.setSongTitle("Determined Tumbao");
		b.setSongLength(20);
		
		q.addSong(a);
		q.addSong(b);
		
		assertFalse(q.isEmpty());
		assertEquals(2, q.getSize());
	}
	
	@Test
	public void testPop() {
		SongQueue q =SongQueue.getInstance();
		
		Song a = new Song("DanseMacabreViolinHook.mp3");
		a.setArtistName("Kevin MacLeod");
		a.setSongTitle("Danse Macabre");
		a.setSongLength(34);

		Song b = new Song("DeterminedTumbao.mp3");
		b.setArtistName("FreePlay Music");
		b.setSongTitle("Determined Tumbao");
		b.setSongLength(20);
		
		q.addSong(a);
		q.addSong(b);
		Song s = q.pop();
		
		assertFalse(q.isEmpty());
		assertEquals(3, q.getSize());
		assertEquals("Danse Macabre", s.getTitle());
	}

}
