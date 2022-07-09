// Course Code: CSC 211-651
// Assignment: 5 - Linear Linked List
// Due Date: 10/22/2020
// Author:Christopher Yonek
/* Description: This class and testClass is a linear linked list that uses a node class
to index and keep track of each item. Data fields prev and next are used to update
where an item is in the node
 */

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

/*This class gives the customer the ability to manipulate
a list without using an array. Using nodes helps give only relevant
information about the list, like finding an item and removing it
from a specific location.
 */
public class LinkedList<T> implements ListInterface<T> {
	/*
	Declaring the first and last nodes in the list
	 */
	private Node firstNode;
	private Node lastNode;

	/*
	This subclass contains constructors to initialize
	future and previous nodes on the list
	 */
	private class Node {
		private T    data;
		private Node prev;
		private Node next;

		/*
		This calls a constructor class and makes the
		previous node and next node null
		 */
		private Node(T dataPortion) {
			this(null, dataPortion, null);	
		}

		/*
		This method is used for taking data and putting it
		in the previous node or the next node.
		 */
		private Node(Node prevNode, T dataPortion, Node nextNode) {
			prev = prevNode;
			data = dataPortion;
			next = nextNode;	
		}
	} // end Node class

	/*
	This custom constructor just makes the first
	and last node null to begin with
	 */
	public LinkedList() {
		firstNode = null;
		lastNode = null;
	}

	/*
	Add( newEntry) takes in a generic type of data
	and adds it to the last node. However, it first
	will add it to the firstNode if the list has
	nothing
	 */
	@Override
	public void add(T newEntry) {
		Node newNode = new Node(lastNode, newEntry, null);

		if (isEmpty()) {
			firstNode = newNode;
		}
		else {
			lastNode.next = newNode;
		}
		lastNode = newNode;
	}

	/*
	This is a future method that will allow the user to
	give a later position in the list and fill the Node()
	method with a newEntry
	 */
	@Override
	public boolean add(int givenPosition, T newEntry) {
		boolean added = false;
		Node newNode = new Node(newEntry);

		if (isEmpty()) {
//			System.out.println("Link is empty, inserting at index " + index + ", calling add(newEntry)");
			add(newEntry);
			added = true;
		}
		else if (givenPosition == 0) {
//			System.out.println("Inserting at index " + index + ", givenPosition is " + givenPosition);
			newNode.next = firstNode;
			firstNode = newNode;
			added = true;
		}
		else {
			Node currentNode = getNode(givenPosition);

			if (currentNode == null) {
//					System.out.println("Inserting at the end, index " + index);
				lastNode.next = newNode;
				newNode.prev = lastNode;
				lastNode = newNode;
				added = true;
			}
			else {
//					System.out.println("Inserting before currentNode, index " + index);
				Node prevNode = currentNode.prev;
				newNode.prev = prevNode;
				newNode.next = currentNode;
				prevNode.next = newNode;
				currentNode.prev = newNode;
				added = true;
			}
		}

		return added;
	}

	/*
	This method takes in a position value
	from the list and makes the string in the
	position null. It accounts for the list being
	empty, being at the position last entered,
	and any position between the first and last Node
	 */
	@Override
	public T remove(int givenPosition) {
		T data = null;

		if (isEmpty()) {
			return data;
		}
		else if (givenPosition == 0) {
			data = firstNode.data;
			firstNode = firstNode.next;
			firstNode.prev = null;
		}
		else {
			Node currentNode = getNode(givenPosition);
			if (currentNode == null) {
				return data;
			}
			else if (currentNode == lastNode) {
				data = currentNode.data;
				lastNode = currentNode.prev;
				lastNode.next = null;
			}
			else {
				data = currentNode.data;
				Node prevNode = currentNode.prev;
				Node nextNode = currentNode.next;
				prevNode.next = currentNode.next;
				nextNode.prev = currentNode.prev;
			}
		}

		return data;
	}

	/*
	Clears the entire list by making the
	first and last node null
	 */
	@Override
	public void clear() {
		firstNode = lastNode = null;
	}

	/*
	This method takes in a position in the list and
	finds the node of that item and replaces it with
	with a newEntry supplied by the customer
	 */
	@Override
	public boolean replace(int givenPosition, T newEntry) {
		if (isEmpty()) {
			return false;
		}
		else {
			Node currentNode = getNode(givenPosition);
			if (currentNode != null) {
				currentNode.data = newEntry;
				return true;
			}
		}

		return false;
	}

	/*
	This method is used to find the position in the list
	by retrieving it from getNode()
	 */
	@Override
	public T getEntry(int givenPosition) {
		if (isEmpty()) {
			return null;
		}
		else {
			Node currentNode = getNode(givenPosition);
			if (currentNode != null) {
				return currentNode.data;
			}
			else {
				return null;
			}
		}
	}

	/*
	This method checks if anEntry matches an item
	in the list by looping through and moving to
	the next node each iteration until it finds it.
	 */
	@Override
	public boolean contains(T anEntry) {
		boolean found = false;
		Node currentNode = firstNode;

		while (!found && (currentNode != null)) {
			found = anEntry.equals(currentNode.data);
			currentNode = currentNode.next;
		}

		return found;
	}

	/*
	This method takes in an anEntry and loops
	to check if each node matches anEntry when
	it finally finds a node
	 */
	public String seek(T anEntry) {
		String locations = new String();
		Node currentNode = firstNode;
		int index = 1;
		while (currentNode != null) {
			if(anEntry.equals(currentNode.data)){
				locations += "Item is found at the location : "+index+"\n";
			}
			currentNode = currentNode.next;
			index++;
		}

		return locations;

	}

	@Override
	public int getLength() {
		int count = 0;
		Node currentNode = firstNode;

		while (currentNode != null) {
			count++;
			currentNode = currentNode.next;
		}

		return count;
	}

	@Override
	public boolean isEmpty() {
		return firstNode == null;
	}

	/*
	Each time the user makes a change from the list
	via the menu it will print out the current contents of
	the list. This is just used for verifying if the code works.
	 */
	@Override
	public void printList() {
		Node currentNode = firstNode;

		if (isEmpty()) {
			System.out.println("List is empty");
		}
		else {
			System.out.println("==CURRENT LIST==");
			while (currentNode != null) {
			System.out.println(currentNode.data);
			currentNode = currentNode.next;
			}
		}
	}

	/*
	This list can hold any number of items. So when
	checking if full it will return false.
	 */
	@Override
	public boolean isFull() {
		return false;
	}

	/*
	This method returns a currentNode by taking in the value of its position
	and looping through until the index of the nodes is equal to the position
	given
	 */
	private Node getNode(int givenPosition) {
		int index = 0;
		Node currentNode = firstNode;

		while ((index != givenPosition) && (currentNode != null)) {
			currentNode = currentNode.next;
			index++;
		}

		return currentNode;
	}

	/*
	This uses ArrayList because it creates a separate list
	apart from the one being used in LinkedList.java
	 */
	public void removeByItemName(T item){
		List<Integer> locations = new ArrayList<Integer>(); //Makes a list of locations for the nodes
		Node recentNode = firstNode;
		int index = 1;

		while(recentNode != null){
			if(item.equals(recentNode.data)){
				locations.add(index);
			}
			recentNode = recentNode.next;
			index++;
		}

		if(!locations.isEmpty()){
			System.out.println("Choose the location of the item to be removed!");
			Scanner input = new Scanner(System.in);
			boolean removed = false;
			do{ //This runs first and stops when removed is true
				int askedLocation = input.nextInt();
				if(askedLocation == 0){ // Requested location can't be zero, exit method
					System.out.println("Item is not removed. Location can't be zero!");
					break;
				}
				else if(locations.contains(askedLocation)){ //After location is found it removes to from the list
					remove(askedLocation);
					System.out.println("Item at requested location is removed! ");
					System.out.println(" ");
					printList();
					removed = true;
				}

			} while(!removed);

		} else{ //Lets user know the index is wrong
			System.out.println("Requested item doesn't exist in the list!");
		}

	}
}
