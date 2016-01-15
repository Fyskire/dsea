package app;

// default java stuff
import java.util.Vector;
import java.util.Collections;

class SpanningTree {

    static Vector<Tuple> kruskal (Vector<Triple> cities, int cityCount){

        // final mst and vector of all edges
        Vector<Tuple> mst = new Vector<Tuple>();
        Vector<WeightedEdge> edges = new Vector<WeightedEdge>();

        for (int i = 0; i < cityCount; i++) {
            for (int j = i; j < cityCount*2; j++) {
                edges.add(new WeightedEdge(euclid(cities.get(i), cities.get(j)),new Tuple(i,j)));
            }
        }

        // sort all edges
        Collections.sort(edges);
        UnionFind u = new UnionFind(cityCount*2);
        for (int i = cityCount; i<cityCount*2-1;i++) {
            u.union(i,i+1);
        }
        for (WeightedEdge we: edges) {
            if (u.find(we.edge.x)==u.find(we.edge.y)) {
                continue;
            }
            mst.add(new Tuple(we.edge.x, we.edge.y));
            u.union(we.edge.x, we.edge.y);
        }

        return mst;
    }

    static double euclid(Triple a, Triple b){

        return ((a.x - b.x) * (a.x - b.x) +
               (a.y - b.y) * (a.y - b.y) +
               (a.z - b.z) * (a.z - b.z));
    }

}
