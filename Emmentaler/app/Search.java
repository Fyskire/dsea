package app;

// java default stuff
import java.util.Vector;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Deque;
import java.util.Collection;
import app.Tuple;

class Search {

    private static Set<Tuple> checked;
    private static Deque<Vector<Tuple>> q;

    private static void check(boolean [][][] cheese, Tuple currentNode, Vector<Tuple> path) {
        Tuple newNode;
        newNode = new Tuple(currentNode.zero-1, currentNode.one, currentNode.two);
        if (legalNode(cheese, newNode)) remember(newNode, path);
        newNode = new Tuple(currentNode.zero+1, currentNode.one, currentNode.two);
        if (legalNode(cheese, newNode)) remember(newNode, path);
        newNode = new Tuple(currentNode.zero, currentNode.one-1, currentNode.two);
        if (legalNode(cheese, newNode)) remember(newNode, path);
        newNode = new Tuple(currentNode.zero, currentNode.one+1, currentNode.two);
        if (legalNode(cheese, newNode)) remember(newNode, path);
        newNode = new Tuple(currentNode.zero, currentNode.one, currentNode.two-1);
        if (legalNode(cheese, newNode)) remember(newNode, path);
        newNode = new Tuple(currentNode.zero, currentNode.one, currentNode.two+1);
        if (legalNode(cheese, newNode)) remember(newNode, path);
    }

    private static boolean legalNode(boolean [][][] cheese, Tuple node) {
        return (node.zero >= 0 && node.zero < cheese.length &&
            node.one >= 0 && node.one < cheese[0].length &&
            node.two >= 0 && node.two < cheese[0][0].length &&
            !cheese[node.zero][node.one][node.two] &&
            !checked.contains(node));
    }

    static private void remember(Tuple node, Vector<Tuple> path) {
        Vector<Tuple> newPath = new Vector<Tuple>(path);
        newPath.add(node);
        q.add(newPath);
        checked.add(node);
    }

    public static Vector<Tuple> BFS (boolean [][][] cheese, Tuple origin){
        checked = new HashSet<Tuple>();
        q = new LinkedList<Vector<Tuple>>();
        Vector<Tuple> originPath = new Vector<Tuple>();
        originPath.add(origin);
        q.add(originPath);
        checked.add(origin);
        while (!q.isEmpty()) {
            Vector<Tuple> currentPath = q.remove();
            Tuple currentNode = currentPath.lastElement();
            if (currentNode.one==0) return currentPath;
            check(cheese, currentNode, currentPath);
        }
    return new Vector<Tuple>();
    }

    public static Vector<Tuple> DFS (boolean [][][] cheese, Tuple origin){
        checked = new HashSet<Tuple>();
        q = new LinkedList<Vector<Tuple>>();
        Vector<Tuple> originPath = new Vector<Tuple>();
        originPath.add(origin);
        q.add(originPath);
        checked.add(origin);
        while (!q.isEmpty()) {
            Vector<Tuple> currentPath = q.removeLast(); //der einzige unterschied zu BFS;
            Tuple currentNode = currentPath.lastElement();
            if (currentNode.one==0) return currentPath;
            check(cheese, currentNode, currentPath);
        }
    return new Vector<Tuple>();
    }

}
