import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.DirectedWeightedPseudograph;

import java.util.*;

// We need jgrapht library to work on this solution

class Solution extends StationNamesHolder {
    static Scanner input = new Scanner(System.in);
    // All data identifiers are "static" as their values do not change
    // Create new objects (stations)
    private static Station a = new Station("ALPHA");
    private static Station b = new Station("BETA");
    private static Station c = new Station("GAMA");
    private static Station d = new Station("DELTA");
    private static Station e = new Station("EPSILON");
    
    // We need a tool to map Station object with its String name
    private static Map<String, Station> mapOfStations = new HashMap<String, Station>();

    // Mapping keys with their values
    static {
        mapOfStations.put("ALPHA", a);
        mapOfStations.put("BETA", b);
        mapOfStations.put("GAMA", c);
        mapOfStations.put("DELTA", d);
        mapOfStations.put("EPSILON", e);
    }

    // Applying the algorithm
    private DijkstraShortestPath<Station, String> algorithm =
            new DijkstraShortestPath<Station, String>(createGraph());

    static DirectedWeightedPseudograph createGraph() {
        // Creating the graph itself
        DirectedWeightedPseudograph<Station, DefaultWeightedEdge> graph =
                new DirectedWeightedPseudograph<Station, DefaultWeightedEdge>(DefaultWeightedEdge.class);
        // Adding vertices (the meeting points of two lines that form an angle)
        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addVertex(d);
        graph.addVertex(e);
        // Adding the weights (the distance from one point to another)
        graph.setEdgeWeight(graph.addEdge(a, b), 3);
        graph.setEdgeWeight(graph.addEdge(b, a), 3);
        graph.setEdgeWeight(graph.addEdge(a, d), 6);
        graph.setEdgeWeight(graph.addEdge(b, c), 7);
        graph.setEdgeWeight(graph.addEdge(c, d), 8);
        graph.setEdgeWeight(graph.addEdge(d, e), 9);
        graph.setEdgeWeight(graph.addEdge(e, d), 9);
        graph.setEdgeWeight(graph.addEdge(d, c), 9);
        graph.setEdgeWeight(graph.addEdge(d, b), 5);
        graph.setEdgeWeight(graph.addEdge(c, e), 3);
        return graph;
    }

    void takeInput() {
        // Take user input and print out results
        displayNames();
        System.out.println("Start station: ");
        String startPoint = input.nextLine().toUpperCase();
        Station startStation = mapOfStations.get(startPoint);

        System.out.println("End station: ");
        String endPoint = input.nextLine().toUpperCase();
        Station endStation = mapOfStations.get(endPoint);

        System.out.println("\nFor the shortest path use stations: ");

        GraphPath myPath;
        try {
            myPath = algorithm.getPath(startStation, endStation);
            // Looping through the already mapped stations
            for (int i = 0; i <= myPath.getLength(); i++) {
                Station listOfStations = (Station) myPath.getVertexList().get(i);
                System.out.println(listOfStations.getName());
            }
            System.out.println("\nThe cost of your trip is: £" + myPath.getWeight());
        } catch (Exception e) {
            System.out.println("\nAn error occurred. Please, try later.");
        }
    }
    // TODO
    @Override
    boolean checkInput() {
        return false;
    }
}
