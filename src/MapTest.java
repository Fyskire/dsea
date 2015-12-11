import java.util.*;
import java.io.*;

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

    try (Scanner scan = new Scanner(new File("edges.txt"));
         PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")))) {
        out.println("UNIQUE POINTS:");
        // Anlegen der HashMap, welche einen 2D Punkt auf eine Ganzzahl abbildet
        HashMap<Point,Integer> P = new HashMap<Point,Integer>();

        // Fügt den Punkt p mit einem Index der HashMap zu, falls dieser noch
        // nicht enthalten ist.
        int i = 0;
        LinkedList<Integer> V = new LinkedList<Integer>();
        while (scan.hasNext()) {
            Point p = new Point(scan.nextInt(), scan.nextInt());
            if (!P.containsKey(p)) {
                P.put(p,i++);
                out.println(""+p.x+" "+p.y);
                V.add(i);
            } else {
                V.add(P.get(p));
            }
        }
        System.out.println("|P| = "+i);
        out.println("EDGES AS INDEX PAIRS:");
        for (Iterator vi = V.iterator(); vi.hasNext();) {
            out.println(""+vi.next()+" "+vi.next());
        }
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
