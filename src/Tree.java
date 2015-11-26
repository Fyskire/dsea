/*
 * Nr.1 c)  "Welche Eingabe würde den längsten Pfad von der Wurzel zu den Blättern maximieren?"
 *          Eine Eingabe, die bereits komplett auf- oder absteigend sortiert ist. 
 *          Dann hätte jeder Knoten genau einen Kind-Knoten und die maximale Tiefe wäre exakt gleich der Anzahl der Knoten. 
 *          Der Baum hätte dann im Prinzip die Form einer verketteten Liste.
 *
 *      d)  "...stellen Sie eine Vermutung über das asymptotische Verhalten der Tiefe an."
 *          Die durchschnittliche Maximale Tiefe scheint sich für eine Verzehnfachung der Eingabegröße etwa um 10 zu erhöhen.
 *          Näherungsweise entspricht die Tiefe (log₁₀(n)-1)*10, was Element von O(log(n)) ist. 
 *          Dies stimmt auch mit dem in der VL ausgerechneten Erwartungswert für die maximale Tiefe bei zufälliger Eingabe überein.
 *      e)
 *          Zwei mögliche Szenarios wären:
 *          1. für sortierte DataSets, indem jeder Key nur einmal vorkommen darf, selbst wenn in der Ursprungsmenge ein Item mehrfach vorkommt
 *          (siehe Warenkorbanalyse, Apriori, FPGrowth)(wie bei TreeSets).
 *          2. Datenbanken, auch mit mehrfach vorkommenden Schlüsseln. Binärbäume bieten sich zur Organisation der Daten an, da sie diverse
 *          Funktionen erlauben, wie zB Ausgabe der Daten in Reihenfolge der Sortierung,
 *          entgegen der Sortierung und potentiell logarithmische Suchfunktion.
 *
 */

import java.util.*;
// Wrapper class, there is no need for customization
class Tree<T extends Comparable<T>> extends AbstractTree<T> {

    public Tree(T key) {
        root = new Node<T>(key);
    }

    public boolean insert(T key) {
        return root.insert(key);
    }

    public boolean isIn(T key) {
        return root.isIn(key);
    }

    // all the traversal methods! :D |--> :(
    public void preorder() {
        root.preorder();
        System.out.println("");
    }

    public void inorder() {
        root.inorder();
        System.out.println("");
    }

    public void postorder() {
        root.postorder();
        System.out.println("");
    }

    // recursive depth method
    public int maxDepth() {
        return root.maxDepth();
    }

    public static void main(String args[]) {
        Random rnd = new Random();

        for (int k = 2; k <= 6; k++) {
            System.out.print("n = 10^"+k+" | 10 Runs: [          ]\b\b\b\b\b\b\b\b\b\b\b");

            int n = (int) Math.pow(10,k);
            double avgDepth = 0;

            // 10 Runs
            for (int i = 0; i < 10; i++) {
                // generate List {1,...,n}
                ArrayList<Integer> numbers = new ArrayList<Integer>(n);
                for (int j = 1; j <= n; j++)
                    numbers.add(j);

                // Since we cannot create an empty Tree, the insertion of the first number is singled out.
                int index = rnd.nextInt(n); // choose a random element from the number list
                Tree<Integer> tree1 = new Tree<Integer>(numbers.get(index)); // insert chosen number into tree
                // Since the deletion of a single element from an ArrayList runs in linear time,
                // we move the number to the end of the list instead and effectively decrease both the range of our next random integer,
                // and the last index of the number list.
                // This operation should run in constant time per element.

                // swap randomly chosen element with last element of the list
                Integer swp = numbers.get(index);
                numbers.set(index, numbers.get(n-1));
                numbers.set(n-1, swp);

                // insert the other n-1 elements similarly
                for (int j = 1; j < n; j++) {
                    index = rnd.nextInt(n-j); // range decreases by 1 after each insertion
                    tree1.insert(numbers.get(index));
                    swp = numbers.get(index);
                    numbers.set(index, numbers.get(n-j-1)); // index of last element of the list decreases by 1 after each insertion
                    numbers.set(n-j-1, swp);
                }
                avgDepth += (double) tree1.maxDepth();

                System.out.print("#");
            }
            avgDepth = avgDepth/10;

            System.out.print("] | ");
            System.out.println("avgDepth = "+avgDepth);
        }
    }
}
