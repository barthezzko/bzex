package com.barthezzko.modifiers;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by barthezzko on 11.03.2015.
 */
public class Child extends Parent {

    private static Logger logger = LoggerFactory.getLogger(Child.class);

    static {
        logger.info("logger invoked on class load by classloader");
    }

    protected void doSmth(){
        super.doSmth();
        {
            //do nothing here
            //onlyMy(); <-- can't see private
        }
    }

    @Test
    public void testMe(){
        new Child();
    }

}
