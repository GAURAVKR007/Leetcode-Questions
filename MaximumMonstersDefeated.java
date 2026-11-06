import java.util.PriorityQueue;

public class MaximumMonstersDefeated {

    public static int maxMonstersDefeated(int n, int e, int[] power, int[] bonus) {

        // dont give code idiot
        int countDefeated = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < n; i++) {
            queue.add(new int[] { power[i], bonus[i] });
        }

        while (!queue.isEmpty()) {
            int[] currMonster = queue.poll();

            if (e < currMonster[0]) {
                break;
            }

            e += currMonster[1];
            countDefeated++;
        }

        return countDefeated;
    }

    public static void main(String[] args) {
        int n = 5;
        int e = 10;

        int[] power = { 11, 3, 15, 7, 20 };
        int[] bonus = { 5, 2, 10, 1, 3 };

        System.out.println(maxMonstersDefeated(n, e, power, bonus));
    }
}