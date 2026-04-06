import java.util.ArrayDeque;
import java.util.Deque;
//AI SOLUTION
class RecentCounter {
    // We use a Deque as a Queue (FIFO)
    private Deque<Integer> requests;

    public RecentCounter() {
        requests = new ArrayDeque<>();
    }
    
    public int ping(int t) {
        // 1. Add the current ping to the end of the line
        requests.addLast(t);
        
        // 2. Look at the oldest pings at the front.
        // If they are outside the [t - 3000, t] window, remove them.
        while (!requests.isEmpty() && requests.peekFirst() < t - 3000) {
            requests.removeFirst();
        }
        
        // 3. The number of elements left in the queue is our count
        return requests.size();
    }
}