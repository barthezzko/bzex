package com.barthezzko.object;

import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by barthezzko on 12.03.2015.
 */
public class ObjectStuff {

    @Test
    public void toStringMe(){
        Object o = new Object();
        assertEquals(o.toString(), "java.lang.Object@" + Integer.toHexString(o.hashCode()));
    }
}
