class Solution {
    public int[] asteroidCollision(int[] ast) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        
        for (int incoming : ast) {
            boolean destroyed = false;
            
            // clashing
            while (!dq.isEmpty() && dq.peekLast() > 0 && incoming < 0) {
                if (Math.abs(dq.peekLast()) < Math.abs(incoming)) {
                    dq.removeLast(); // stack asteroid explodes, incoming keeps fighting
                    continue; 
                } else if (Math.abs(dq.peekLast()) == Math.abs(incoming)) {
                    dq.removeLast(); // both explode
                    destroyed = true;
                    break;
                } else {
                    destroyed = true; // incoming explodes
                    break;
                }
            }
            
            // did the asteroid survive
            if (!destroyed) {
                dq.addLast(incoming);
            }
        }

        // Convert to array
        int[] out = new int[dq.size()];
        int i = 0;
        for (int val : dq) {
            out[i++] = val;
        }
        return out;
    }
}