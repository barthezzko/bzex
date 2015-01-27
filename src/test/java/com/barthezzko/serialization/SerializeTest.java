package com.barthezzko.serialization;


import junit.framework.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author Mikhail Baytsurov
 *         <br/> 27.01.15 14:52
 */
public class SerializeTest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void test() throws IOException, ClassNotFoundException {
        Cat cat = new Cat(Arrays.asList(new Integer[]{1,2,3,4}));
        FileOutputStream fileOutputStream = new FileOutputStream(new File("cat.ser"));
        ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
        oos.writeObject(cat);
        oos.close();

        FileInputStream fis = new FileInputStream(new File("cat.ser"));
        ObjectInputStream ois = new ObjectInputStream(fis);
        Cat catRead = (Cat)ois.readObject();

        System.out.println(cat);
        System.out.println(catRead);
        Assert.assertEquals(cat, catRead);
    }
}

class Cat implements Serializable {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private void writeObject(ObjectOutputStream stream) throws IOException {
        logger.info("trying to write");
        stream.defaultWriteObject();

    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        //logger.info("reading");
        stream.defaultReadObject();
    }

    private static final long serialVersionUID = -81226293440211567L;
    List<Paw> paws = new ArrayList<Paw>();
    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cat cat = (Cat) o;

        if (!paws.equals(cat.paws)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return paws.hashCode();
    }

    Cat(List<Integer> pawnums){
        name = "Tom";
        for (Integer i:pawnums) paws.add(new Paw(i));
    }

    @Override
    public String toString() {
        return "Cat{" +
                "paws=" + paws +
                ", name='" + name + '\'' +
                '}';
    }

    private class Paw implements Serializable {

        private static final long serialVersionUID = 9036324165989686899L;
        int number;

        public Paw(Integer i) {
            this.number = i;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Paw paw = (Paw) o;

            if (number != paw.number) return false;

            return true;
        }

        @Override
        public int hashCode() {
            return number;
        }

        @Override
        public String toString() {
            return "Paw{" +
                    "number=" + number +
                    '}';
        }
    }
}
