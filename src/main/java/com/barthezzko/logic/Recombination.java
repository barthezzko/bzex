package com.barthezzko.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by barthezzko on 2/2/15.
 */
public class Recombination {

    private static char[] CHAR_LIST = {'a', 'b', 'c'};

    static Logger logger = LoggerFactory.getLogger(Recombination.class);

    public static void main(String ... args){
        for (int i=0; i<3; i++){
            char[] resp = new char[3];
            resp[0] = CHAR_LIST[i];
            for (int j=0; j<3; j++){
                if (CHAR_LIST[j] == resp[0]) continue;
                resp[1] = CHAR_LIST[j];
                resp[2] = CHAR_LIST[j==1? 2: 1];
                logger.info("RESPONSE {}", resp);
            }
        }
    }

}
