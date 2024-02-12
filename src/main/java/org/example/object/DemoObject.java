package org.example.object;

public class DemoObject implements java.io.Serializable{
    private transient int id;
    private String name;
    public DemoObject(final int id,final String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
