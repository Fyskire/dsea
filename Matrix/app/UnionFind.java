package app;

class UnionFind extends AbstractUnionFind {

    int[] ref, size, next;

    UnionFind(int n) {
        ref = new int[n];
        size = new int[n];
        next = new int[n];
        for (int i=0; i<n; i++) {
            ref[i]=i;
            size[i]=1;
            next[i]=-1;
        }
    }

    public int find(int repr){
        return ref[repr];
    }

    public boolean union(int u, int v){
        int x = ref[u];
        int y = ref[v];
        if (size[x] > size[y]) {
            x = ref[v];
            y = ref[u];
        }
        int h = next[y];
        next[y] = x;
        int z = y;
        while(next[z]>=0) {
            z = next[z];
            ref[z] = y;
        }
        next[z]=h;
        size[y]+=size[x];
        return true;
    }
}
