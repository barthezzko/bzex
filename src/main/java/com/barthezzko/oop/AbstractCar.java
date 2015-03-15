package com.barthezzko.oop;

/**
 * Created by barthezzko on 11.03.2015.
 */
public abstract class AbstractCar {
    /**
     * Created by barthezzko on 11.03.2015.
     */

    private Wheel[] wheels = new Wheel[4];
    private Engine engine;

    /*
    * incapsulation - hiding the data and provide accessor methods
    * */

    public Wheel[] getWheels() {
        return wheels;
    }

    public void setWheels(Wheel[] wheels) {
        this.wheels = wheels;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }


    public static class Wheel {

    }
    
    public abstract static class Engine{

        public abstract boolean isLaunched();
    } 

    public abstract void go();
}
