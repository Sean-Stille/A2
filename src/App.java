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
 */

/**
 * Main method, all this does is call my OSQueue class
 */
public class App {
    public static void main(String[] args) throws Exception {
        new OSQueue(2);
    }
}
