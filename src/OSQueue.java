import java.io.*;
import java.util.Scanner;
import net.datastructures.*;

public class OSQueue {
    int maxTimeWaiting;
    SortedPriorityQueue<Integer, Job> jobQueue;    
    int i;
    Job detectedJob; //used as an intermediary for when I need a job variable
    public OSQueue(int maxTime){
        maxTimeWaiting = maxTime;
        jobQueue = new SortedPriorityQueue<>();
        String[] wordsInLine;
        String currentLine;
        Scanner scan = null;
        boolean jobsCompleted = false;
        
        
        try{
            scan = new Scanner(new File("Jobs.txt"));
            while (scan.hasNextLine()){
                currentLine = scan.nextLine();
                wordsInLine = currentLine.split(" ");
                try{
                    if( wordsInLine.length == 9 && wordsInLine[0].compareTo("add") == 0 && wordsInLine[1].compareTo("job") == 0 &&
                        wordsInLine[3].compareTo("with") == 0 && wordsInLine[4].compareTo("length") == 0 &&
                        wordsInLine[6].compareTo("and") == 0 && wordsInLine[7].compareTo("priority") == 0){

                        detectedJob = new Job(Integer.parseInt(wordsInLine[8]),Integer.parseInt(wordsInLine[5]), wordsInLine[2]);
                        jobQueue.insert(detectedJob.priority, detectedJob);

                        runQueueLoop();
                    }
                    else if (currentLine.contains("no new job this slice") && currentLine.length() == 22){
                        runQueueLoop();
                    }
                }
                catch(Exception f){
                    //Used for incorrect line entry, nothing happens since its ignored
                }
            }
            while (jobQueue.size() > 0){
                runQueueLoop();
            }
            System.out.println("Done!");


        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            scan.close();
        }
        
    }


    public void runQueueLoop(){
        ArrayList<Job> removedJobs;
        Job currentlyExecuting;
        //step 1
        currentlyExecuting = jobQueue.removeMin().getValue();
        currentlyExecuting.length--;
        System.out.println(currentlyExecuting);

        //step 2
        removedJobs  = new ArrayList<>();
                for( i = 0; i < jobQueue.size(); i++ ){
                    detectedJob = jobQueue.removeMin().getValue();
                    detectedJob.timeWaiting++;
                    if(detectedJob.timeWaiting > maxTimeWaiting){
                        detectedJob.incrementPriority();
                        detectedJob.timeWaiting = 0;
                    }
                    removedJobs.add(i, detectedJob);
                }   
                for(i = 0; i < removedJobs.size(); i++){
                    detectedJob = removedJobs.get(i);
                    jobQueue.insert(detectedJob.priority, detectedJob);
                    }
        //step 3
        if(currentlyExecuting.length > 0){
            jobQueue.insert(currentlyExecuting.priority, currentlyExecuting);
        }
    }
    
    


}
