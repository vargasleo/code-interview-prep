package dynamicprograming;

import java.util.ArrayList;
import java.util.List;

// AlgoExpert - Knapsack Problem
public class Knapsack {

    public static void main(String[] args) {
        System.out.println("Comparing recursive with memo and without memo:");

        int[][] items = {{465, 100},
                {400, 85},
                {255, 55},
                {350, 45},
                {650, 130},
                {1000, 190},
                {455, 100},
                {100, 25},
                {1200, 190},
                {320, 65},
                {750, 100},
                {50, 45},
                {550, 65},
                {100, 50},
                {600, 70},
                {240, 40}};

        System.out.println("Without memo~" + knapsackProblemWithoutMemo(items, 200));
    }

    public static List<List<Integer>> knapsackProblemWithoutMemo(int[][] items, int capacity) {
        var itemIndexes = rec(items, capacity, items.length, new ArrayList<>());
        return List.of(List.of(sumValueByIndexes(items, itemIndexes)), itemIndexes);
    }

    private static List<Integer> rec(int[][] items, int capacity, int index, List<Integer> indexes) {
        if (capacity == 0 || index == 0) {
            return indexes;
        } else if (items[index - 1][1] > capacity) {
            return rec(items, capacity, index - 1, indexes);
        } else {
            var copy = new ArrayList<>(List.copyOf(indexes));
            copy.add(index - 1);
            var itemIndexesWithCurrentItem = rec(items, capacity - items[index - 1][1], index - 1, copy);
            var itemIndexesWithCurrentItemValue = sumValueByIndexes(items, itemIndexesWithCurrentItem);
            var copy2 = new ArrayList<>(List.copyOf(indexes));
            var itemIndexesWithoutCurrentItem = rec(items, capacity, index - 1, copy2);
            var itemIndexesWithoutCurrentItemValue = sumValueByIndexes(items, itemIndexesWithoutCurrentItem);

            if (itemIndexesWithCurrentItemValue > itemIndexesWithoutCurrentItemValue) {
                indexes = itemIndexesWithCurrentItem;
            } else {
                indexes = itemIndexesWithoutCurrentItem;
            }
            return indexes;
        }
    }

    private static Integer sumValueByIndexes(int[][] items, List<Integer> itemIndexesWithCurrentItem) {
        return itemIndexesWithCurrentItem.stream()
                .mapToInt(Integer::intValue)
                .mapToObj(i -> items[i][0])
                .reduce(0, Integer::sum);
    }
}
