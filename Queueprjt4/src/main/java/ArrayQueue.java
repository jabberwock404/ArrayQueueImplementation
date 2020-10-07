/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JW
 * @param <E>
 */
public class ArrayQueue<E> implements MyQueueInterface<E>{
    
    private E[] ArrQueue;
    private int front;
    private int back;
    private int capacity;
    private int size;
    
    public void ArrayQueue(int intCapacity){
       size = 0;
       front = 0;
       back = 0;
       capacity = intCapacity;
       ArrQueue = (E[]) new Object[capacity];
    }
    
    public void ArrayQueue(){
        size = 0;
        front = 0;
        back = 0;
        capacity = 25;// I chose some random value for the intial array size
        ArrQueue = (E[]) new Object[capacity];
    }
    
    public void enqueue(E element) throws InvalidDataException{
        if(element == null){
            throw new InvalidDataException("Imroper data, cannot be null");
        }
        if(size() == ArrQueue.length){
            //E[] newArrQueue = new E[ArrQueue.length * 2];
            E[] newArrQueue = (E[]) new Object[ArrQueue.length * 2];
            for(int i = 0; i < size();i ++){
                newArrQueue[i] = ArrQueue[(front + i) % ArrQueue.length];
            }
            ArrQueue = newArrQueue;
            front = 0;
            back = size();
        }
        size++;
        ArrQueue[back] = element;
        back = (back + 1) % capacity;
    }
    
    public E dequeue() throws QueueEmptyException{
        if(isEmpty()){
            throw new QueueEmptyException("Cannot dequeue, no items on the queue.");
        }
        E element = ArrQueue[front];
        ArrQueue[front] = null;
        size--;
        front++;
        return element;
    }
    
    public E front ()throws QueueEmptyException {
        if(isEmpty()){
            throw new QueueEmptyException("Cannot return front, queue is empty");
        }
        return ArrQueue[front];
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty(){
        return size() == 0;
    }
}