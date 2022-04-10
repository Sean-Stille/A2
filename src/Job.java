import net.datastructures.*;
/**
 * Class used to represented an individual job
 */
public class Job{
    int priority;   //-20 to 20
    int length;     //1-100
    int timeWaiting;
    String name;
    /**
     * 
     * @param priority The priority of a given job
     * @param length The amount of time intervals needed to complete it
     * @param name The name of a given job
     * @throws Exception 
     */
    public Job (int priority, int length, String name) throws Exception{
        if( priority < -20 || priority > 20){
            throw new Exception("Incorrect Insantiation Error");
        }
        if(length < 1 || length > 100){
            throw new Exception("Incorrect Insantiation Error");
        }
        this.priority = priority;
        this.length = length;
        timeWaiting = 0;    //At instantiation, the time waited will always be zero
        this.name = name;
    }
    /**
     * Raises the priority of a given job, this actually subtracts 1 from the int, due to the way
     * java handles comparing
     */
    public void incrementPriority(){
        if(priority > -20){
            priority--;
        }
    }
    /**
     * toString method
     */
    public String toString(){
        return String.format("%s (priority: %d, time remaining: %d)", name, priority, length);
    }


}
