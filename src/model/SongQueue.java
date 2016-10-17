package model;

import java.util.ArrayList;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

/**
 * This class acts as a queue to play songs from the jukebox in order.
 * 
 * @author Colin Widner and Qiming Wan
 *
 */

public class SongQueue implements ListModel {
	
	private ArrayList<Song> queue;
	private static SongQueue list;
	private int size;
	
	/*
	 * The SongQueue constructor.
	 */
	private SongQueue() {
		queue = new ArrayList<>();
		size = 0;
	}
	
	/*
	 * The getInstance method of the SongQueue class.
	 * 
	 * Returns: The instance of the SonQueue.
	 */
	public static SongQueue getInstance() {
		if(list == null)
			list = new SongQueue();
		
		return list;
	}

	/*
	 * Adds a song to the queue.
	 * 
	 * Parameters:
	 * 	s - The song to be added to the queue.
	 */
	public void addSong(Song s) {
		queue.add(s);
		size++;
	}
	
	/*
	 * Determines if the queue is empty.
	 * 
	 * Returns: True if the size of the queue is zero, false otherwise.
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/*
	 * Removes the Song from the front of the queue.
	 * 
	 * Returns: The Song object that was removed from the queue.
	 */
	public Song pop() {
		size--;
		return queue.remove(0);
	}
	
	/*
	 * Returns the size of the queue.
	 * 
	 * Returns: An integer that is the amount of songs in the queue.
	 */
	public int getSize() {
		return size;
	}

	/**
	 * NEED TO IMPLEMENT THESE METHODS BELOW.
	 */
	
	@Override
	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub
		
	}

	
}
