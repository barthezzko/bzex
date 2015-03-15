package com.barthezzko.oop;

import com.barthezzko.oop.impl.LadaKalina;
import com.barthezzko.oop.impl.Mazda6;
import org.junit.Test;

/**
 * Created by barthezzko on 11.03.2015.
 */
public class Garage {

    AbstractCar[] cars = new AbstractCar[128];

    @Test
    public void encloseCars(){
        cars[0] = new Mazda6();
        cars[1] = new LadaKalina();
    }


}
