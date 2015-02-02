package com.barthezzko.serialization;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by barthezzko on 2/2/15.
 */
public class NotSerializable {

    @Test
    public void trySerialize() throws IOException {
        Vehicle vehicle = new Vehicle();
        vehicle.wheels.add(new Wheel());
        FileOutputStream fileOutputStream = new FileOutputStream(new File("vehicle.ser"));
        ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
        oos.writeObject(vehicle);
        oos.close();
    }
}

class Vehicle implements Serializable {
    List<Wheel> wheels = new ArrayList<Wheel>();
}

class Wheel {}