package problem2;

import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author Rudy Leiva
 * @author Bradley Taniguchi
 * 5/1/17
 * CSC 295
 */
public class Worker extends Thread {
    private LinkedBlockingQueue<Task> taskQueue;

    public Worker(LinkedBlockingQueue<Task> taskQueue) {
        this.taskQueue = taskQueue;
    }
    
    public void run()
    {
       while(true)
       {
           Task task = taskQueue.poll();
           if(task == null)
           {
               break;
           }
           //task.weightedRandom();
       }
    }
}
