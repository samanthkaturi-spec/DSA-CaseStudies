/*GPS Navigation System Using Dijkstra Algorithm*/
import java.util.*;

class Pair {
    String node;
    int distance;

    Pair(String node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

public class Main {

    public static void main(String[] args) {

        Map<String, List<Pair>> graph = new HashMap<>();

        graph.put("A", Arrays.asList(
                new Pair("B", 4),
                new Pair("C", 1)));

        graph.put("B", Arrays.asList(
                new Pair("D", 1)));

        graph.put("C", Arrays.asList(
                new Pair("B", 2),
                new Pair("D", 5)));

        graph.put("D", new ArrayList<>());

        PriorityQueue<Pair> pq =
                new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));

        Map<String, Integer> dist = new HashMap<>();

        pq.add(new Pair("A", 0));
        dist.put("A", 0);

        while (!pq.isEmpty()) {

            Pair current = pq.poll();

            for (Pair neighbor : graph.get(current.node)) {

                int newDist = current.distance + neighbor.distance;

                if (!dist.containsKey(neighbor.node)
                        || newDist < dist.get(neighbor.node)) {

                    dist.put(neighbor.node, newDist);
                    pq.add(new Pair(neighbor.node, newDist));
                }
            }
        }

        System.out.println("Shortest Distances from A:");

        for (String node : dist.keySet()) {
            System.out.println(node + " : " + dist.get(node));
        }
    }
}
