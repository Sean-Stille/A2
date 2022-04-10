import net.datastructures.*;
/**
 * Name: Sean Stille
 * Date: 4/10/22
 * Description: A2, CPU scheduler
 * Bugs:    I wasn't exactly sure how to allow for names with spaces, for example, you'll notice
 *          the "with length" job was changed to "withLength" for my txt file
 * Reflection:  Overall this went pretty smoothly, I think I could've isolated the methods a bit more.
 *              The main thing I would've changed would be isolating what OSQueue needs to do into more 
 *              than two methods.
 *              I noticed that for output number 3, my output is slightly different. I'm thinking that this is just
 *              the result of different PriorityQueue implementations, and from what I can tell it's just a case
 *              of multiple values having the same priority value
 */

/**
 * Main method, all this does is call my OSQueue class
 */
public class App {
    public static void main(String[] args) throws Exception {
        new OSQueue(0);
    }
}
