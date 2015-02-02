package com.barthezzko.serialization;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * Created by barthezzko on 2/2/15.
 */
public class StaticsIgnored {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testMe() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(new File("cat.ser"));
        ObjectInputStream ois = new ObjectInputStream(fis);
        Cat catRead = (Cat)ois.readObject();
        logger.info(catRead.CAT_GROUP);
    }

}
