package com.company;

import java.util.*;

public class Graph {

    private Map<Vertex, List<Vertex>> adjVertices;

    Graph() {
        this.adjVertices = new HashMap<>();
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");
        graph.breadthFirstSearch();
        graph.depthFirstSearch();
    }

    void addVertex(String label) {
        Vertex newVertex = new Vertex(label);
        adjVertices.putIfAbsent(newVertex, new ArrayList<>());
    }

    void addEdge(String label1, String label2) {
        Vertex newVertex1 = new Vertex(label1);
        Vertex newVertex2 = new Vertex(label2);
        adjVertices.get(newVertex1).add(newVertex2);
        adjVertices.get(newVertex2).add(newVertex1);
    }

    void removeEdge(String label1, String label2) {
        Vertex newVertex1 = new Vertex(label1);
        Vertex newVertex2 = new Vertex(label2);
        List<Vertex> adjVertices1 = adjVertices.get(newVertex1);
        List<Vertex> adjVertices2 = adjVertices.get(newVertex2);
        if (adjVertices1 != null) {
            adjVertices1.remove(newVertex2);
        }
        if (adjVertices2 != null) {
            adjVertices2.remove(newVertex1);
        }
    }

    void removeVertex(String label) {
        Vertex newVertex = new Vertex(label);
        adjVertices.values().stream().forEach(e -> e.remove(newVertex));
        adjVertices.remove(newVertex);
    }

    List<Vertex> getAdjacentVertice(String label) {
        return adjVertices.get(new Vertex(label));
    }

    void breadthFirstSearch() {
        Queue<Vertex> queue = new LinkedList<>();
        Collection<String> resultSet = new HashSet<>();
        Vertex source = new Vertex("Bob");
        queue.add(source);
        resultSet.add(source.label);
        while (!queue.isEmpty()) {
            Vertex v = queue.poll();
            List<Vertex> vertices = adjVertices.get(v);
            for (Vertex vertex : vertices) {
                if (!resultSet.contains(vertex.label)) {
                    resultSet.add(vertex.label);
                    queue.add(vertex);
                }
            }
        }
        resultSet.forEach(System.out::print);
    }

    void depthFirstSearch() {
        Stack<String> stack = new Stack<>();
        Set<String> set = new LinkedHashSet<>();
        Vertex source = new Vertex("Bob");
        stack.push(source.label);
        while (!stack.isEmpty()) {
            String v = stack.pop();
            if (!set.contains(v)) {
                set.add(v);
                for (Vertex vert : getAdjacentVertice(v)) {
                    stack.push(vert.label);
                }
            }
        }
        System.out.println("\n");
        for (String v : set) {
            System.out.print(v + " ");
        }
    }

    class Vertex {
        private String label;

        public Vertex(String label) {
            this.label = label;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getOuterType().hashCode();
            result = prime * result + ((label == null) ? 0 : label.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Vertex other = (Vertex) obj;
            if (!getOuterType().equals(other.getOuterType()))
                return false;
            if (label == null) {
                if (other.label != null)
                    return false;
            } else if (!label.equals(other.label))
                return false;
            return true;
        }

        @Override
        public String toString() {
            return label;
        }


        private Graph getOuterType() {
            return Graph.this;
        }
    }

}
