package leetcode.middle.arrays;

import java.util.*;

public class findItinerary {
    public static void main(String[] args) {
        List<List<String>> lists = new ArrayList<>();
        List<String> list = new ArrayList<>();
         list = new ArrayList<>();
        list.add("JFK");
        list.add("SFO");
        lists.add(list);
         list = new ArrayList<>();
        list.add("JFK");
        list.add("ATL");
        lists.add(list);
         list = new ArrayList<>();
        list.add("SFO");
        list.add("ATL");
        lists.add(list);
        list = new ArrayList<>();
        list.add("ATL");
        list.add("JFK");
        lists.add(list);
        list = new ArrayList<>();
        list.add("ATL");
        list.add("SFO");
        lists.add(list);
        new findItinerary().findItinerary(lists);
    }
    Map<String, Queue<String>> flights;
    LinkedList<String> path;
    public List<String> findItinerary(List<List<String>> tickets) {
        flights = new HashMap<>();
        path = new LinkedList<>();
        for(int i = 0; i < tickets.size(); i++){
            String from = tickets.get(i).get(0);
            String to = tickets.get(i).get(1);
            Queue queue = flights.getOrDefault(from, new PriorityQueue<>());
            queue.add(to);
            flights.put(from,queue);
        }
        dfs("JFK");
        return path;
    }

    public void dfs(String departure) {
        Queue<String> arrivals = flights.get(departure);
        while (arrivals != null && !arrivals.isEmpty())
            dfs(arrivals.poll());
        path.addFirst(departure);
    }
}
