/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JW
 */
public interface MyQueueInterface<E> {
    public interface Queue <E> {
        public void enqueue(E element) throws InvalidDataException;
        public E dequeue() throws QueueEmptyException;
        public E front() throws QueueEmptyException;
        public int size();
        public boolean isEmpty();
    }
}
