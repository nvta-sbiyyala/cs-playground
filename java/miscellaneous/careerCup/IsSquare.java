import java.io.*;
import java.util.*;

/**
 * Given 4 points, determine if they form a square or not
 */
class Point {
    int x;
    int y;
  
    private Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    static Point newPoint(int x, int y) {
        return new Point(x, y);
    }
}

public class IsSquare {
    
    public static void main(String[] args) {
        tests();
    }

    static void tests() {
        Point a = Point.newPoint(4, 0);
        Point b = Point.newPoint(0, 4);
        Point c = Point.newPoint(-4, 0);
        Point d = Point.newPoint(0, -4);
        
        assert(isSquare(a, b, c, d));
        assert(isSquare(a, c, b, d));
        assert(isSquare(a, d, c, b));

        a = Point.newPoint(-3, 2);
        b = Point.newPoint(-2, 6);
        c = Point.newPoint(2, 7);
        d = Point.newPoint(1, 3);
        
        assert(!isSquare(a, b, c, d));
    }
    
    static boolean isSquare(Point a, 
                            Point b,
                            Point c, 
                            Point d) {

        double dist_ab = distance(a, b); 
        double dist_bc = distance(b, c); 
        double dist_cd = distance(c, d); 
        double dist_da = distance(d, a);

        Set<Double> pointSet = new TreeSet<>(Arrays.asList(dist_ab, dist_bc, dist_cd, dist_da));
        Double[] pointArray = new Double[pointSet.size()];

        int i = 0;
        for (Double elem : pointSet) {
            pointArray[i++] = elem;
        }

        if (pointArray.length > 2) {
            return false;
        } else {
            if (pointArray.length == 1) {
                // eliminate the rombhus possibility
                double dist_ac = distance(a, c);
                double dist_bd = distance(b, d);
                
                double side = pointArray[0];
                double diagonal_length = hypo(side, side);
                
                return dist_ac == dist_bd &&
                    dist_ac == diagonal_length;
                    
            } else {
                // do a perpendicularity check
                double min = pointArray[0];
                double max = pointArray[1];

                double diagonal_length = hypo(min, min);

                return diagonal_length == max;
            }
        }
    }

    static double hypo(double d1, double d2) {
        return Math.sqrt(Math.pow(d1, 2) + Math.pow(d2, 2));
    }

    /**
     * sqrt(pow(a, 2) + pow(b, 2))
     */
    static double distance(Point a, Point b) {    
        double x_val = Math.pow((b.x - a.x), 2);
        double y_val = Math.pow((b.y - a.y), 2);
    
        double dist = Math.sqrt(x_val+y_val);
    
        return dist;
    }
}
