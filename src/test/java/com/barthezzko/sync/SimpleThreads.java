package com.barthezzko.sync;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by barthezzko on 05.02.2015.
 */
public class SimpleThreads {

    static Logger logger = LoggerFactory.getLogger(SimpleThreads.class);
    public static void main() throws InterruptedException {
        RunnableTarget rt = new RunnableTarget();
        Thread t = new Thread(rt);
        t.setDaemon(true);
        t.start();
        logger.info("thread started");
        Thread.sleep(1000);
        rt.setPaused(true);
        logger.info("paused");
        Thread.sleep(5000);
        rt.setPaused(false);
        logger.info("resumed");
        Thread.sleep(1000);
        logger.info("exit main");
    }
}

class RunnableTarget implements Runnable {

    public synchronized boolean isPaused() {
        return paused;
    }

    public synchronized void setPaused(boolean paused) {
        this.paused = paused;
    }

    private boolean paused;
    private boolean killed;

    public boolean isKilled() {
        return killed;
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public void run() {
        int i=0;
        while(!isKilled()){
            if (!isPaused()){
                i = waitForMe(i);
                if (isPrime(i)) {
                    logger.info("prime {}", i);
                }
            }
        }
    }

    private int waitForMe(int i) {
        try {
            Thread.currentThread().sleep(100);
            logger.info("current");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return i++;
    }

    synchronized boolean isPrime(int n) {
        //check if n is a multiple of 2
        if (n%2==0) return false;
        //if not, then just check the odds
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }
}
