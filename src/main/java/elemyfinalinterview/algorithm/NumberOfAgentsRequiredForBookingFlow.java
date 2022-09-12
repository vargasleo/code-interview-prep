package elemyfinalinterview.algorithm;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import static java.util.Optional.ofNullable;

public class NumberOfAgentsRequiredForBookingFlow {

    public static void main(String[] args) {
        final var date1 = LocalDateTime.of(2022, 2, 8, 11, 30);
        final var date2 = LocalDateTime.of(2022, 2, 8, 11, 30);
        final var date23 = LocalDateTime.of(2022, 2, 8, 11, 30);
        final var date3 = LocalDateTime.of(2022, 2, 8, 12, 50);
        final var date4 = LocalDateTime.of(2022, 2, 8, 12, 50);
        final var date7 = LocalDateTime.of(2022, 2, 8, 12, 50);
        final var date74 = LocalDateTime.of(2022, 2, 8, 12, 50);
        final var date5 = LocalDateTime.of(2022, 2, 8, 13, 50);
        final var date6 = LocalDateTime.of(2022, 2, 8, 14, 50);
        final var arg = new LocalDateTime[]{date1, date2, date3, date4, date5, date6, date6, date7, date23, date74};
        Thread t1 = new Thread(() -> {
            Instant start = Instant.now();
            System.out.println("pq O(n²):" + +getNumberOfAgentsNeeded(arg));
            Instant finish = Instant.now();
            System.out.println("pq O(n²) took: " + (finish.toEpochMilli() - start.toEpochMilli()) + "ms");
        });
        Thread t2 = new Thread(() -> {
            Instant start = Instant.now();
            System.out.println("pq O(logn):" + getNumberOfAgentsNeededPQ(arg));
            Instant finish = Instant.now();
            System.out.println("pq O(logn) took: " + (finish.toEpochMilli() - start.toEpochMilli()) + "ms");
        });
        t1.start();
        t2.start();
    }

    public static int getNumberOfAgentsNeededPQ(final LocalDateTime[] dates) {
        if (dates.length == 0) return 0;
        if (dates.length == 1) return 1;

        Comparator<LocalDateTime> comparator = (d1, d2) -> {
            if (d1.isBefore(d2)) return -1;
            if (d1.isAfter(d2)) return 1;
            return 0;
        };

        final var pq = new PriorityQueue<>(comparator);
        pq.addAll(Arrays.asList(dates));
        pq.forEach(System.out::println);
        return rec(new PriorityQueue<>(), pq, 0);
    }

    private static int rec(PriorityQueue<Integer> availableAgents, PriorityQueue<LocalDateTime> agendas, int maxAgents) {
        if (agendas.isEmpty()) return maxAgents;
        var curr = agendas.poll();
        var next = agendas.peek();

        if (availableAgents.poll() == null) maxAgents++;
        if (next != null && curr.plusMinutes(20).isBefore(next))
            for (int i = 0; i < maxAgents; i++) availableAgents.add(1);
        else if (next == null) return maxAgents;
        return rec(availableAgents, agendas, maxAgents);
    }

    public static int getNumberOfAgentsNeeded(final LocalDateTime[] dates) {
        int overlaps = 0;
        int currOverlaps = 0;

        for (int j = 0; j < dates.length; j++) {
            var curr = dates[j];
            for (int i = j + 1; i < dates.length; i++) {
                if (curr.plusMinutes(20).isAfter(dates[i])) {
                    currOverlaps++;
                }
            }
            overlaps = Math.max(currOverlaps, overlaps);
            currOverlaps = 0;
        }
        return overlaps + 1;
    }
}
