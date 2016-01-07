package app;
import java.util.HashSet;

// just because java sucks
class Tuple {
    private static int hashInfo = 40; // Trägt man hier mindestens die Seitenlänge des Käses ein gibt es keine Kollisionen!

    public static void setHashInfo(int h) {
        hashInfo = h;
    }
    final int zero, one, two;
    Tuple (int zero, int one, int two){

        this.zero = zero;
        this.one  = one;
        this.two  = two;
    }

    public static void main(String... args) {
        HashSet<Tuple> eins = new HashSet<Tuple>();
        eins.add(new Tuple(1,1,1));
        System.out.println(eins.contains(new Tuple(1,1,1))); // FALSE WENN MAN HASHCODE NICHT ÜBERSCHREIBT.
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Tuple)) return false;
        if (obj==this) return true;
        Tuple other=(Tuple)obj;
        return (this.zero==other.zero&&this.one==other.one&&this.two==other.two);
    }

    @Override // Ich habe Angefangen mit HashSet, und bringe es jetzt zu Ende
    public int hashCode() {
        return (hashInfo*hashInfo*zero)+(hashInfo*one)+two; // Zu unserer Verteidung: Wenn hashInfo richtig gesetzt ist, ist das garantiert kollisionsfrei.
    }
}
