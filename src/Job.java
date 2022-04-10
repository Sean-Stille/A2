import net.datastructures.*;

public class Job{
    int priority;   //-20 to 20
    int length;     //1-100
    int timeWaiting;
    String name;

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

    public void incrementPriority(){
        if(priority > -20){
            priority--;
        }
    }
    
    public int compareTo(Job j) {
        return priority - j.priority;
    }

    public String toString(){
        return String.format("%s (priority: %d, time remaining: %d)", name, priority, length);
    }


}
