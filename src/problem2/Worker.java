package problem2;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * @author Rudy Leiva
 * @author Bradley Taniguchi
 * 5/1/17
 * CSC 295
 */
public class Worker extends Thread 
    {
        private ConcurrentLinkedQueue<Task> taskQueue;
        
        public Worker(ConcurrentLinkedQueue<Task> taskQueue) {
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
