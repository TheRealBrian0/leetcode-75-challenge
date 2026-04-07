import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        // Separate queues to store the indices of Radiant and Dire senators
        Deque<Integer> radiant = new ArrayDeque<>();
        Deque<Integer> dire = new ArrayDeque<>();

        // 1. Initial State: Fill the queues with the starting positions
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiant.addLast(i);
            } else {
                dire.addLast(i);
            }
        }

        // 2. The Battle: Continue as long as both parties have senators left
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int rIndex = radiant.pollFirst();
            int dIndex = dire.pollFirst();

            // The senator with the smaller index acts first and bans the other
            if (rIndex < dIndex) {
                // Radiant wins this "duel". 
                // They go to the back of the line for the next round.
                radiant.addLast(rIndex + n);
            } else {
                // Dire wins this "duel".
                dire.addLast(dIndex + n);
            }
        }

        // 3. The Winner: The party that still has senators remaining wins
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}