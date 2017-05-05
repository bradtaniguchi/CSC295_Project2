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
    private LinkedBlockingQueue<SpecialNumbers> jobs;
    public Worker(LinkedBlockingQueue<SpecialNumbers> jobs) {
        this.jobs = jobs;
    }
}
