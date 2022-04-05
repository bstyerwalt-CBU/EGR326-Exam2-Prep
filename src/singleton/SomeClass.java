package singleton;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Robbie Sollie - SomeClass.java - EGR326 - CBU - 2019-04-01
 */
public class SomeClass {
    private List<List<String>> list;
    private Map<Integer, String> map;
    private Point p;

    private volatile static SomeClass uniqueInstance;

    public static synchronized SomeClass getInstance() {
        if (uniqueInstance == null) {
            synchronized (SomeClass.class) {
                if (uniqueInstance == null) {
                    return new SomeClass();
                }
            }
        }

        return uniqueInstance;
    }


    private SomeClass() {
        list = new ArrayList<>();
        map = new TreeMap<>();
        p = new Point(10, 10);
    }


}
