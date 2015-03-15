package com.barthezzko.oop.impl;

import com.barthezzko.oop.AbstractCar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by barthezzko on 11.03.2015.
 */
public class Mazda6 extends AbstractCar {


    private static Logger logger = LoggerFactory.getLogger(Mazda6.class);

    public Mazda6() {
        for (int i=0;i<getWheels().length;i++) getWheels()[i] = new Wheel();
        setEngine(new MazdaCoolEngine());
    }

    @Override
    public void go() {
        if (getWheels().length ==4 && getEngine().isLaunched()){
            logger.info("ready to go!");
        }
    }

    public static final class MazdaCoolEngine extends Engine{

        @Override
        public boolean isLaunched() {
            return false;
        }
    }
}
