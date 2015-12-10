import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Scanner;
import java.io.File;

class Point implements Comparable<Point> {
  public int x,y;

  Point(int a,int b) {
    x = a;
    y = b;
  }

  @Override
  public int hashCode() {
    long z = x << 16 + y;
    long p = 2147483647L; // Primzahl < 2^31
    long a = 1189436865L; // zufällig 0 < a < p
    long b = 1206511853L; // zufällig 0 <= b < p
    // hier m = p

    // Für ein m != p muss da dieser Stelle noch modulo m
    // gerechnet werden
    return (int)((a * z + b) % p);
  }

  @Override
  public boolean equals(Object obj) {
    Point p = (Point) obj;
    if (x == p.x && y == p.y) return true;
    return false;
  }

  @Override
  public int compareTo(Point p) {
    if (x < p.x) return -1;
    if (x > p.x) return  1;
    if (y < p.y) return -1;
    if (y > p.y) return  1;
    return 0;
  }
};

public class MapTest {
  public static void main(String[] args) {

    try (Scanner scan = new Scanner(new File("edges.txt"))) {

        // Anlegen der HashMap, welche einen 2D Punkt auf eine Ganzzahl abbildet
        HashMap<Point,Integer> H = new HashMap<Point,Integer>();

        // Fügt den Punkt p mit einem Index der HashMap zu, falls dieser noch
        // nicht enthalten ist.
        /* 
            491 999 806 546
            45 76 491 999
            403 442 806 546
            64 622 158 24
            642 821 806 546
            64 622 991 458
            45 76 816 505
            217 325 816 505
            491 999 862 799
            459 594 729 403
            83 200 862 799
            158 24 991 458
            459 594 882 418
            729 403 882 418
            491 999 690 87
            491 999 729 403
            217 325 459 594
            403 442 816 505
            64 622 862 799
            124 632 690 87
            729 403 806 546
            690 87 991 458
            64 622 816 505
            459 594 991 458
            459 594 690 87
            170 684 729 403
            403 442 642 821
            158 24 642 821
            690 87 729 403
            45 76 991 458
            83 200 491 999
            45 76 158 24
            882 418 927 263
            217 325 403 442
            729 403 927 263
            299 936 816 505
            83 200 991 458
            816 505 991 458
            170 684 403 442
            642 821 690 87
            217 325 642 821
            45 76 862 799
            124 632 927 263
            64 622 729 403
            862 799 882 418
            491 999 882 418
            299 936 642 821
            217 325 690 87
            158 24 729 403
            806 546 816 505
            158 24 299 936
            816 505 862 799
            64 622 927 263
            170 684 642 821
            217 325 991 458
            83 200 690 87
            729 403 862 799
            45 76 882 418
            124 632 816 505
            217 325 927 263
            491 999 816 505
            299 936 403 442
            217 325 299 936
            403 442 927 263
            816 505 927 263
            124 632 729 403
            45 76 64 622
            83 200 882 418
            862 799 991 458
            83 200 459 594
            64 622 806 546
            927 263 991 458
            45 76 927 263
            64 622 170 684
            124 632 991 458
            170 684 299 936
            816 505 882 418
            64 622 83 200
            64 622 217 325
            806 546 862 799
            124 632 459 594
            64 622 491 999
            299 936 862 799
            299 936 806 546
            217 325 882 418
            299 936 882 418
            862 799 927 263
            642 821 816 505
            170 684 806 546
            45 76 83 200
            45 76 217 325
            83 200 816 505
            124 632 217 325
            299 936 690 87
            217 325 806 546
            690 87 862 799
            158 24 170 684
            299 936 991 458
            83 200 806 546
            170 684 927 263
        */
        int i = 0;

        while (scan.hasNext()) {
            Point p = new Point(scan.nextInt(), scan.nextInt());
          if (!H.containsKey(p))
            H.put(p,i++);
        }
        System.out.println(i);
        
        // Gibt die (Key, Value) Paare aus, die oben hinzugefügt wurden
        for(Map.Entry<Point,Integer> e: H.entrySet())
          System.out.println(e.getKey().x+" "+e.getKey().y+" "+e.getValue());
        /*

        // Selbes für die TreeMap
        TreeMap<Point,Integer> T = new TreeMap<Point,Integer>();

        // Fügt den Punkt p mit einem Index der TreeMap zu, falls dieser noch
        // nicht enthalten ist.
        i = 0;
        for(Point p: P)
          if (!T.containsKey(p))
            T.put(p,i++);

        // Gibt die (Key, Value) Paare aus, die oben hinzugefügt wurden
        for(Map.Entry<Point,Integer> e: T.entrySet())
          System.out.println(e.getKey().x+" "+e.getKey().y+" "+e.getValue());
        */
    } catch (Exception e) {
        e.printStackTrace();
    }
  }
}
