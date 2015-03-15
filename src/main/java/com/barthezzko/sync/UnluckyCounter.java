package com.barthezzko.sync;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by barthezzko on 08.02.2015.
 */
public class UnluckyCounter {

    public static void main(String[] args) {
        ValueClass vc = new ValueClass();

        for (int i=0;i<10;i++){
            Thread t = new Incrementer(vc);
            t.start();
        }
    }


}

class Incrementer extends Thread {
    Logger logger = LoggerFactory.getLogger(Incrementer.class);

    ValueClass vc;
    public Incrementer(ValueClass vc) {
        this.vc = vc;
    }

    public void run(){
        while (vc.counter<10) ++vc.counter;
        logger.info("result {}", vc.counter);
    }
}

class ValueClass{int counter = 0;}