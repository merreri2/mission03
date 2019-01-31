package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.Queue;

public class LinkedQueue<E> implements Queue<E> {

    /*
    Fields
     */
    private DoublyLinkedList<E> DLL = new DoublyLinkedList<>();
    /*
    Constructor
     */
    public LinkedQueue(){

    }

        /**
         * @return The number of elements in the queue
         */
        public int size() {
            return DLL.size();
        }

        /**
         * @return tests whether the queue is empty.
         */
        public boolean isEmpty() {
            return DLL.isEmpty();
        }

        /**
         * Inserts an element at the end of the queue.
         *
         * @param element Element to be inserted.
         */
        public void offer(E element) {
            DLL.addLast(element);
        }

        /**
         * @return The value first element of the queue (with out removing it), or
         * null if empty.
         */
        public E peek() {
            return DLL.first();
        }

        /**
         * @return The value of the first element of the queue (and removes it), or
         * null if empty.
         */
        public E poll() {
            return DLL.removeFirst();
        }

        /**
         * Prints the contents of the queue starting at top, one item per line. Note
         * this method should not empty the contents of the queue.
         */
        public void printQueue() {
            DLL.printList();
        }

        /**
         * Tranfers the contents of this queue into the provided queue. The contents
         * of this queue are to found in reverse order at the top of the provided
         * queue. This queue should be empty once the transfer is completed. Note
         * that if the provided queue is null, nothing is to happen.
         *
         * @param into The new queue onto which the reversed order of contents from
         * this queue are to be transferred to the top of, unless the provided queue
         * is null.
         */
        public void transfer(edu.isu.cs.cs3308.structures.Queue<E> into) {
            if (into != null){
                //reverses the contents of this queue
                reverse();
                //places the contents of the provided queue at the end of this queue
                while (into.size() > 0) {
                    offer(into.poll());
                }
                //puts this queue into the provided queue
                while (size() > 0) {
                    into.offer(poll());
                }
            }
        }

        /**
         * Reverses the contents of this queue.
         */
        public void reverse() {
            LinkedStack<E> transferStack = new LinkedStack<>();

            while (size() > 0) {
                transferStack.push(poll());
            }
            while (transferStack.size() > 0){
                offer(transferStack.pop());
            }
        }

        /**
         * Merges the contents of the provided queue onto the bottom of this queue.
         * The order of both queues must be preserved in the order of this queue
         * after the method call. Furthermore, the provided queue must still contain
         * its original contents in their original order after the method is
         * complete. If the provided queue is null, no changes should occur.
         *
         * @param from Queue whose contents are to be merged onto the bottom of
         * this queue.
         */
        public void merge(edu.isu.cs.cs3308.structures.Queue<E> from){
            if (from != null){
                for (int count = 0; count < from.size(); count++){
                    from.offer(from.peek());
                    offer(from.poll());
                }
            }
    }

}
