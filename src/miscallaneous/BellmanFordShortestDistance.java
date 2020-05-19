package miscallaneous;

//Bellman ford algo fails where there is a negative weight cycle
//It is based on dynamic programming
public class BellmanFordShortestDistance {

    public static void main(String []args){

        Graph graph = new Graph(5,8);

        //first edge
        System.out.println(graph.e);
        graph.edges[0].src = 0;
        graph.edges[0].dest = 1;
        graph.edges[0].weight = -1;

        graph.edges[1].src = 0;
        graph.edges[1].dest = 2;
        graph.edges[1].weight = 4;

        graph.edges[2].src = 1;
        graph.edges[2].dest = 2;
        graph.edges[2].weight = 3;

        graph.edges[3].src = 1;
        graph.edges[3].dest = 3;
        graph.edges[3].weight = 2;

        // add edge 1-4 (or A-E in above figure)
        graph.edges[4].src = 1;
        graph.edges[4].dest = 4;
        graph.edges[4].weight = 2;

        // add edge 3-2 (or D-C in above figure)
        graph.edges[5].src = 3;
        graph.edges[5].dest = 2;
        graph.edges[5].weight = 5;

        // add edge 3-1 (or D-B in above figure)
        graph.edges[6].src = 3;
        graph.edges[6].dest = 1;
        graph.edges[6].weight = 1;

        // add edge 4-3 (or E-D in above figure)
        graph.edges[7].src = 4;
        graph.edges[7].dest = 3;
        graph.edges[7].weight = -3;
        new BellmanFordShortestDistance().BellmanFord(graph, 0);

    }

    void BellmanFord(Graph graph, int source){
        int E = graph.e;
        int V = graph.v;
        int[] dist = new int[V];
        for(int k = 0; k < V; k++){
            dist[k] = Integer.MAX_VALUE;
        }
        dist[source] = 0;

        for (int i = 0; i < V; i++){
            for(int j = 0; j < E; j++){
                int u = graph.edges[j].src;
                int v = graph.edges[j].dest;
                int weight = graph.edges[j].weight;
                if(dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]){
                    dist[v] = dist[u] + weight;
                }
            }
        }

        for(int j = 0; j < E; j++){
            int u = graph.edges[j].src;
            int v = graph.edges[j].dest;
            int weight = graph.edges[j].weight;
            if(dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]){
                System.out.println("Negative cycle detected");
                return;
            }
        }
        printArr(dist, V);
    }

    void printArr(int dist[], int V)
    {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }


     static class Graph{
        int v;
        int e;
        Edge edges[];

        class Edge{
            int src, dest, weight;

            Edge(){
                src = dest = weight = 0;
            }
        }

        Graph(int v, int e){
            this.v = v;
            this.e = e;
            this.edges = new Edge[e];
            for (int i = 0; i < e; i++)
                edges[i] = new Edge();
        }
    }
}
