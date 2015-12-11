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
    // ----------------------------------------------------------
    //  Ich hoffe ich irre mich gerade nicht total, aber ich glaube das macht keinen Sinn.
    //  m ist doch die Anzahl der Fächer der HashMap. Die "mod m" Operation wird intern von HashMap durchgeführt,
    //  was man im Quellcode HashMap.java sehen kann: (Auschnitt aus Hashmaps Einfüge-Methode)
    //      ...
    //      if ((tab = table) == null || (n = tab.length) == 0)
    //         n = (tab = resize()).length;
    //      if ((p = tab[i = (n - 1) & hash]) == null)
    //          tab[i] = newNode(hash, key, value, null);
    //      ...
    //
    // n ist also die aktuelle interne kapazität (anzahl der fächer) der HashMap, die wir laut VL m nennen.
    // der index der verwendet wird ist n-1 ge-and-et mit dem hashwert.
    // da HashMap so konstruiert ist, dass die interne Länge immer eine zweierpotzenz (0...010...0) ist,
    // ist n-1 also (0...01...1) in binärdarstellung, also ist ein AND mit dem HashCode ein Abschneiden
    // der signifikantesten bits des Hashes bis inkl. dem bit welches stellenwert n hat.
    // --> entspricht modulo n
    //
    // der schritt "modulo m" scheint also wie erwartet immer unabhängig von der HashFunktion selbst
    // und Teil der Funktionsweise der HashMap zu sein.
    // Die Situation m=p könnte man also nur erzwingen, indem man für p eine zweierpotenz wählte
    // (was aber für unsere Arten von Hashfunktionen nicht geht, weil p prim sein soll),
    // und die HashMap mit einer initialCapacity (=m) von p erstellt.
    //
    //
    //
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
        LinkedList<Integer> outputBuffer = new LinkedList<Integer>();
        while (scan.hasNext()) {
            Point p = new Point(scan.nextInt(), scan.nextInt());
            if (!P.containsKey(p)) {
                P.put(p,i++);
                out.println(""+p.x+" "+p.y);
                outputBuffer.add(i);
            } else {
                outputBuffer.add(P.get(p));
            }
        }
        System.out.println("|P| = "+i);
        out.println("TOTAL: "+i+" UNIQUE POINTS");
        out.println("EDGES AS INDEX PAIRS:");
        for (Iterator vi = outputBuffer.iterator(); vi.hasNext();) {
            out.println("("+vi.next()+","+vi.next()+")");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
  }
}
