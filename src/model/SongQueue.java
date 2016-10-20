package model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

/**
 * This class acts as a queue to play songs from the jukebox in order.
 * 
 * @author Colin Widner and Qiming Wan
 *
 */

public class SongQueue implements ListModel<Song>, Serializable {

	private static ArrayList<Song> queue;
	private int size;

	/*
	 * The SongQueue constructor.
	 */
	public SongQueue() {
		queue = new ArrayList<>();
		size = 0;
	}

	/*
	 * Adds a song to the queue.
	 * 
	 * Parameters: s - The song to be added to the queue.
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

	@Override
	public Song getElementAt(int index) {
		return queue.get(index);
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
