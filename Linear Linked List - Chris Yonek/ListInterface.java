// Course Code: CSC 211-651
// Assignment: 5 - Linear Linked List
// Due Date: 10/22/2020
//Christopher Yonek: This is the ListInterface
public interface ListInterface<T> {
	public void add(T newEntry);
	public boolean add(int newPosition, T newEntry);
	public T remove(int givenPosition);
	public void removeByItemName(T item);
	public void clear();
	public boolean replace(int givenPosition, T newEntry);
	public T getEntry(int givenPosition);
	public boolean contains(T anEntry);
	public String seek(T anEntry);
	public int getLength();
	public boolean isEmpty();
	public boolean isFull();
	//public T[] toArray();
	public void printList();
}
