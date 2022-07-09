// Course Code: CSC 211-651
// Assignment: 3 - Queue
// Due Date: 10/13/2020
// Author:Christopher Yonek
/* Description: This creates a queue that items go into and the functions in the program allow elements to be shifted, added and removed
 */

import java.util.Arrays;

public  class ArrayCircularQ<T> implements QInterface<T>{

    /*Initializes an array to hold the queue in,
    *qRear adds an new item to the queue while elements are removed from qFront.
    *qContents is the current number of items in the queue, qMax is the most
    *a queue can hold. The default size is 5.
    */
    private T[] qArry;
    private int qFront;
    private int qRear;
    private int qContents;
    private int qMax;
    private final int DEFAULT_SIZE = 5;

    /* This is a no-arg constructor that just assigns the
    *default value, instead of always needing an argument in
    *ArrayCircularQ()
    */
    public ArrayCircularQ() {
        qMax = DEFAULT_SIZE;
        qArry = (T[]) new Object[qMax];
        qFront = 0;
        qRear = -1;
        qContents = 0;
    }

    /*A constructor assigning initial values,
    *the front initially has zero while the back has one less.
    *It also starts as an empty Queue, TestArrayCircularQ
    *uses this method
    */
    public ArrayCircularQ(int s) {
        qMax = s;
        T[] tempQArry = (T[]) new Object[qMax];
        qFront = 0;
        qRear = -1;
        qContents = 0;
        qArry = tempQArry;
    }

    /*When qRear is evenly divisible by qMax
    *the modulo of qRear + 1 on qMax is zero.
    *this allows you to wrap entries around the queue.
    */
    public void insert(T newEntry) {
        qRear = (qRear + 1) % qMax;
        qArry[qRear] = newEntry;
        qContents++;
    }


    /*This removes an element in the front of the Queue.
    *It doesn't shift any elements in the Array holding the queue
    *but puts an empty string in place of the removed element.
    */
    public T remove(){
        if(qContents == 0) //if the queue is empty give null
            return null;

        T qCount = qArry[qFront];
        qArry[qFront] = null;
        qFront = (qFront + 1) % qMax;

        if(qFront == qMax) //This reset the front to zero so
            qFront = 0;    // qFront can't be greater than qMax

        qContents--; //since item is removed, the contents decreases
        return qCount;
    }

    /* Returns the front of the Queue */
    public T peek() {
        return qArry[qFront];
    }

    /*Checks if the queue is empty*/
    public boolean isEmpty() {
        return (qContents == 0);
    }

    /* Removes everything in the queue for null */
    public void clear(){
        qFront = 0;
        qRear = -1;
        qContents = 0;
    }

    /*This prints out the contents of
    *the Queue and the array associated with it.
    *It will tell the user if its empty.
    */

    public void printQ() {
        if(qContents < 1){
            System.out.println("The queue is empty");
            return;
        }

        System.out.println("Circular Array: "+Arrays.toString(qArry));
        System.out.print("Circular Array Queue: ");

        int tempQfront = qFront;

        for(int i = 1; i <= qContents; i++) {
            System.out.print(qArry[tempQfront] + " "); // This for-loop prints out each
            tempQfront = (tempQfront + 1) % qMax;      // element in the Queue
        }
        System.out.println();
    }


    /*If the queue exceeds max amount
    * option 4 in TestArrayCircular will
    * return true */
    public boolean isFull() {
        return (qContents == qMax);
    }

}
