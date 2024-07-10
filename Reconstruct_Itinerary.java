import java.util.*;

public class Reconstruct_Itinerary {
    public static void main(String[] args) {
        List<List<String>> list2 = new ArrayList<>(List.of(
                new ArrayList<>(List.of("MUC", "LHR")),
                new ArrayList<>(List.of("JFK", "MUC")),
                new ArrayList<>(List.of("SFO", "SJC")),
                new ArrayList<>(List.of("LHR", "SFO"))
        ));

//        list2.forEach(System.out::println);
        Reconstruct_Itinerary reconstructItinerary = new Reconstruct_Itinerary();
        reconstructItinerary.findItinerary(list2);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> ans = new LinkedList<>();
        Map<String, Queue<String>> graph = new HashMap<>();

        for (final List<String> ticket : tickets) {
            graph.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            graph.get(ticket.get(0)).offer(ticket.get(1));
        }

        dfs(graph, "JFK", ans);
        System.out.println(ans);
        return ans;
    }

    private void dfs(Map<String, Queue<String>> graph, final String u, LinkedList<String> ans) {
        final Queue<String> arrivals = graph.get(u);
        while (arrivals != null && !arrivals.isEmpty())
            dfs(graph, arrivals.poll(), ans);
        ans.addFirst(u);
    }
}
