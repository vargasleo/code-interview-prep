package TODOheap;

import java.util.*;

// Leetcode - 347. Top K Frequent Elements
class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        Queue<Integer> frequencyHeap = new PriorityQueue<>(Comparator.comparingInt(frequencyMap::get));

        for (Integer value : frequencyMap.keySet()) {
            frequencyHeap.add(value);
            if (frequencyHeap.size() > k) {
                frequencyHeap.poll();
            }
        }

        int[] topKFrequents = new int[k];
        for (int i = 0; i < k; i++) {
            topKFrequents[i] = frequencyHeap.poll();
        }
        return topKFrequents;
    }
}
