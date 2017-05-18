package problem2;

import java.util.ArrayList;
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
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Problem 2");
               
        LinkedBlockingQueue<Task> tasks = new LinkedBlockingQueue<>();
        LinkedBlockingQueue<SpecialNumbers> results = new LinkedBlockingQueue<>();
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
        
        // start timmer now
        double startTime = System.currentTimeMillis();
        
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
            
            tasks.add(new Task(start, end, specialNumbers, results));
        }
        
        // set the number of worker threads
        // These guys will work on the tasks
        workers = new Worker[numberOfWorkers];
        
        // now we need to populate the list of workers
        for (int i = 0; i < numberOfWorkers; i++) {
            workers[i] = new Worker(tasks);
        }
        
        //start the workers
        for (Worker worker : workers) {
            worker.start();
        }
        
        // join/wait the workers
        for (Worker worker: workers) {
            worker.join();
        }
        
        
        //Im suppose to check the variance here. Instead I am just going to
        //do the calculations but do nothign with them
        getVarient(results, specialNumbers);
        
        System.out.println("We are suppose to print out the numbers that"
                + " meet the variance requirement, but we didn't finish implimenting it. "
                + "Anyways, heres the runtime.");
        
        double endTime = System.currentTimeMillis();
        System.out.println("=======");
        System.out.println("Time (ms): " + (endTime- startTime));
        System.out.println("Threads/Workers: " + numberOfWorkers);
        System.out.println("Tasks-per worker: " + numberOfTasks);
    }
    /**
     * Utility function used to calculate the last requirement of the prompt.
     * This function will calculate the variance of each of the 3 properties
     * then return an array list of special numbers that match the requirements.
     * @param results a list of SpecialNumbers that already match the first 3 
     *  requirements. 
     * @param numbers the original list of SpecialNumbers. This will be checked
     *  At the beginning to calculate the total variance.
     * @return an array list of SpecialNumbers that match all the requirement.
     * DIDNT FINISH IMPLIMENTING THE VARIANCE CALCULATIONS OF THE 3 DIFFERENT PARAMETERS
     * 
     */
    public static ArrayList<SpecialNumbers> getVarient(LinkedBlockingQueue<SpecialNumbers> results, SpecialNumbers[] numbers) {
        ArrayList<SpecialNumbers> finalResuls = new ArrayList<>();
        
        //get the sums for the 3 attributes
        int nonPrimeNumSum = 0;
        int primeNumSum = 0;
        int perfectNumSum = 0;
        
        // calculate the sums
        for (SpecialNumbers number : numbers) {
            nonPrimeNumSum += number.getNonPrimeNum();
            primeNumSum += number.getPrimeNum();
            perfectNumSum += number.getPerfectNum();
        }
        
        int nonPrimeNumMean = nonPrimeNumSum/numbers.length;
        int primeNumMean = primeNumSum/numbers.length;
        int perfectNumMean = perfectNumSum/numbers.length;
        
        // calculate the TOP of the variance formula
        int nonPrimeNumVarTop = 0;
        int primeNumVarTop = 0;
        int perfectNumVarTop = 0;

        for (SpecialNumbers number : numbers) {
            nonPrimeNumVarTop += Math.pow(number.getNonPrimeNum() - nonPrimeNumMean, 2);
            primeNumVarTop += Math.pow(number.getPrimeNum() - primeNumMean, 2);
            perfectNumVarTop += Math.pow(number.getPerfectNum() - perfectNumMean, 2);
        }
        
        //now finally calculate the variance by applying the bottom
        int nonPrimeNumVariance = nonPrimeNumVarTop/numbers.length-1;
        int primeNumVariance = primeNumVarTop/numbers.length-1;
        int perfectNumVariance = perfectNumVarTop/numbers.length-1;
        
        // I give up, to much MATHS
        return null;
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
