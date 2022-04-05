package flyweight;

import java.awt.*;
import java.util.Map;

public class Point {
    private final int x;
    private final int y;
    private volatile static Map<String, Point> map;

    public Point getInstance(int x, int y) {
        String key = x + "," + y;
        if (!map.containsKey(key)) {
            synchronized (Point.class) {
                if (!map.containsKey(key)) {
                    map.put(key, new Point(x, y));
                }
            }
        }
        return map.get(key);
    }

    private Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
