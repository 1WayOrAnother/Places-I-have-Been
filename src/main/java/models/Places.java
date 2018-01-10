package models;
import java.util.ArrayList;

/**
 * Created by Guest on 1/10/18.
 */
public class Places {
    private String name;
    private String date;
    private boolean lived;
    private String food;
    private String activities;
    private int id;
    private static ArrayList instances = new ArrayList();

    public Places(String name, String date, boolean lived, String food, String activities) {
        this.name = name;
        this.date = date;
        this.lived = lived;
        this.food = food;
        this.activities = activities;
        instances.add(this);
        this.id = instances.size();
    }

    public String getName() {return this.name;}
    public String getDate() {return this.date;}
    public boolean getLived() {return this.lived;}
    public String getFood() {return this.food;}
    public String getActivities() {return this.activities;}
    public int getId() {return this.id;}
    public static ArrayList getAll() {return instances;}
    public static void clearAll() {instances.clear();}
    public static Object findById(int id) {return instances.get(id-1);}
}
