package edu.isu.cs.cs3308;

import edu.isu.cs.cs3308.structures.Queue;
import edu.isu.cs.cs3308.structures.Stack;
import edu.isu.cs.cs3308.structures.impl.LinkedQueue;

/**
 *
 * @author Isaac Griffith
 * @author
 */
public class StackScan {

    /**
     * Tests whether the given stack contains the provided element.
     * Implementation should use a queue to scan the stack and reconstruct it
     * when done.
     *
     * @param <E> Type of elements stored in the stack
     * @param stack Stack to be scanned.
     * @param element Element to search the stack for.
     * @return True if the given stack is not null and contains the given
     * element. Returns false if both the stack and element are not null and the
     * stack does not contain the element, if either the stack or element is
     * null, or if the stack is emtpy.
     */
    public static <E> boolean scanStack(final Stack<E> stack, E element) {
        //throw new UnsupportedOperationException("Not yet implemented");
        boolean toReturn = false;

        if (stack != null && element != null) {
            LinkedQueue<E> usefulQ = new LinkedQueue<>();

            while (stack.size() > 0){
                usefulQ.offer(stack.pop());
            }

            while (usefulQ.size() >0){
                if (usefulQ.peek() == element){
                    toReturn = true;
                }
                stack.push(usefulQ.poll());
            }
            stack.reverse();

        }
        return toReturn;
    }
}
