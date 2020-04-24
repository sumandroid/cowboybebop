package com.company;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

//Doesn't work when edges have negative weights as it is based on greedy approach
public class DjiktraAlgorithm {

    public static void main(String []args){
        Graph graph = new Graph(5, 8);
        graph.edges[0].src = 0;
        graph.edges[0].dest = 1;
        graph.edges[0].weight = 1;

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
        graph.edges[7].weight = 3;
        execute(graph, 0);
    }

    static void execute(Graph graph, int source){
        int E = graph.e;
        int V = graph.v;
        int[] dist = new int[V];
        for(int i = 0; i < V; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[source] = 0;
        Set<Integer> settledSet = new HashSet<>();
        Set<Integer> unSettledSet = new HashSet<>();
        unSettledSet.add(source);
        while(unSettledSet.size() != 0){
            Stream<Edge> currentEdges = Arrays.stream(graph.edges).filter(e -> e.src == source);
            int currentNode = getLowestDistantEdge(currentEdges);
            unSettledSet.remove(source);
            currentEdges.forEach(edge -> {

                unSettledSet.add(edge.dest);
            });

        }
    }

    static void calculateMinimumDistance(){
    }

    static int getLowestDistantEdge(Stream<Edge> edges){
        return 0;
    }

    static class Graph {
        int v;
        int e;
        Edge edges[];

        Graph(int  v, int e){
            this.v = v;
            this.e = e;
            this.edges = new Edge[e];
            for(int i = 0; i < e; i++){
                edges[i] = new Edge();
            }
        }
    }

    static class Edge {
        int src;
        int dest;
        int weight;

        Edge(){
            this.src = this.dest = this.weight = 0;
        }

    }
}
