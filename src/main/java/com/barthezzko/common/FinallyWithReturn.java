package com.barthezzko.common;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by barthezzko on 08.02.2015.
 */
public class FinallyWithReturn {

    static Logger logger = LoggerFactory.getLogger(FinallyWithReturn.class);

    public static void main(String[] args) {
        logger.info("Result {}", new FinallyWithReturn().returnOne());
    }

    public int returnOne(){
        try{
           return 1;
        }
        finally{
            logger.info("finally invoked");
        }
    }

}
