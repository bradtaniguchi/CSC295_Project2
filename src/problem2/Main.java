package problem2;

import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author Rudy Leiva
 * @author Bradley Taniguchi
 * 5/1/17
 * CSC 295
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Problem 2");
               
        LinkedBlockingQueue<Task> tasks = new LinkedBlockingQueue<>();
        LinkedBlockingQueue<Boolean> results = new LinkedBlockingQueue<>();
        SpecialNumbers[] specialNumbers = new SpecialNumbers[10000];
        int numberOfWorkers; // # of threads/workers that will be working on tasks
        int sizeOfTask; // # of specialNumbers to calucate in a SINGLE task
        int numberOfTasks; //calculate amount of tasks, to be processed
        Worker[] workers; // these guys will do the Tasks
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Input the number of threads");
        numberOfWorkers = scanner.nextInt();
        
        System.out.println("Input the number of numbers per task");
        sizeOfTask = scanner.nextInt();
        
        // populate the special numbers array
        for (int i = 0; i < specialNumbers.length; i++) {
            specialNumbers[i] = new SpecialNumbers();
        }

        // calculate the number of tasks
        numberOfTasks = specialNumbers.length/sizeOfTask; 
        
        // populate the tasks array
        for (int i = 0; i < numberOfTasks; i++) {
            // I think this math is right... but doesnt it mean we start at 1?
            // idk, the prof used this calculation...
            int start = i * sizeOfTask + 1;
            int end = (i + 1) * 1000;
            
            tasks.add(new Task(start, end, results));
        }
        
        // set the number of worker threads
        // These guys will work on the tasks
        workers = new Worker[numberOfWorkers];
        
        // now we need to populate the list of workers
        for (int i = 0; i < numberOfWorkers; i++) {
            workers[i] = new Worker(tasks);
        }
        
        
        
    }
}
/*
                                                                                                                       
        CCCCCCCCCCCCC   SSSSSSSSSSSSSSS         CCCCCCCCCCCCC      222222222222222        999999999     555555555555555555 
     CCC::::::::::::C SS:::::::::::::::S     CCC::::::::::::C     2:::::::::::::::22    99:::::::::99   5::::::::::::::::5 
   CC:::::::::::::::CS:::::SSSSSS::::::S   CC:::::::::::::::C     2::::::222222:::::2 99:::::::::::::99 5::::::::::::::::5 
  C:::::CCCCCCCC::::CS:::::S     SSSSSSS  C:::::CCCCCCCC::::C     2222222     2:::::29::::::99999::::::95:::::555555555555 
 C:::::C       CCCCCCS:::::S             C:::::C       CCCCCC                 2:::::29:::::9     9:::::95:::::5            
C:::::C              S:::::S            C:::::C                               2:::::29:::::9     9:::::95:::::5            
C:::::C               S::::SSSS         C:::::C                            2222::::2  9:::::99999::::::95:::::5555555555   
C:::::C                SS::::::SSSSS    C:::::C                       22222::::::22    99::::::::::::::95:::::::::::::::5  
C:::::C                  SSS::::::::SS  C:::::C                     22::::::::222        99999::::::::9 555555555555:::::5 
C:::::C                     SSSSSS::::S C:::::C                    2:::::22222                9::::::9              5:::::5
C:::::C                          S:::::SC:::::C                   2:::::2                    9::::::9               5:::::5
 C:::::C       CCCCCC            S:::::S C:::::C       CCCCCC     2:::::2                   9::::::9    5555555     5:::::5
  C:::::CCCCCCCC::::CSSSSSSS     S:::::S  C:::::CCCCCCCC::::C     2:::::2       222222     9::::::9     5::::::55555::::::5
   CC:::::::::::::::CS::::::SSSSSS:::::S   CC:::::::::::::::C     2::::::2222222:::::2    9::::::9       55:::::::::::::55 
     CCC::::::::::::CS:::::::::::::::SS      CCC::::::::::::C     2::::::::::::::::::2   9::::::9          55:::::::::55   
        CCCCCCCCCCCCC SSSSSSSSSSSSSSS           CCCCCCCCCCCCC     22222222222222222222  99999999             555555555     
    :P
*/
