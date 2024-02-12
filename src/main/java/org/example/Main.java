package org.example;

import org.example.object.DemoObject;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DemoObject object = new DemoObject(1, "Demo");
        String filename = "demo.ser";
        serializeObject(object,filename);
        deserializeObject(filename);
    }

    public static void serializeObject(Object obj,String filename) throws IOException {
        FileOutputStream outStream = new FileOutputStream(filename);
        ObjectOutputStream objStream = new ObjectOutputStream(outStream);
        // data before serialization
        System.out.println("--------------------");
        System.out.println("Before Serialization");
        System.out.println("--------------------");
        printData(obj);
        objStream.writeObject(obj);
        DemoObject demo = (DemoObject) obj;
        demo.setName("sample");
        objStream.close();
        outStream.close();
    }

    public static void deserializeObject(String filename) throws IOException, ClassNotFoundException{
        FileInputStream instream = new FileInputStream(filename);
        ObjectInputStream objStream = new ObjectInputStream(instream);
        Object obj = objStream.readObject();
        System.out.println("\n--------------------");
        System.out.println("After Serialization");
        System.out.println("--------------------");
        printData(obj);
        instream.close();
        objStream.close();
    }

    public static void printData(Object obj){
        DemoObject demo = (DemoObject) obj;
        System.out.println("Id: "+demo.getId());
        System.out.println("Name: "+demo.getName());
    }

}