package flyweight;

import java.awt.*;
import java.util.Map;

public class Point {
    private final int x;
    private final int y;
    private final Rectangle rec;
    private volatile static Map<String, Point> map;

    public Point getInstance(int x, int y, Rectangle rec) {
        String key = x + "," + y + "," + "," + rec;
        if (!map.containsKey(key)) {
            synchronized (Point.class) {
                if (!map.containsKey(key)) {
                    map.put(key, new Point(x, y, rec));
                }
            }
        }
        return map.get(key);
    }

    private Point(int x, int y, Rectangle rec) {
        this.x = x;
        this.y = y;
        this.rec = rec;
    }
}
