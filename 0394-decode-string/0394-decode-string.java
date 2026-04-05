import java.util.ArrayDeque;
import java.util.Deque;

//COMPLETE AI SOLUTION; try on your own later
class Solution {
    public String decodeString(String s) {
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> stringStack = new ArrayDeque<>();
        
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Accumulate multi-digit numbers
                k = k * 10 + (ch - '0');
                
            } else if (ch == '[') {
                // 1. "Save" our current progress and the multiplier
                countStack.push(k);
                stringStack.push(currentString);
                
                // 2. Reset for the new nested level
                currentString = new StringBuilder();
                k = 0;
                
            } else if (ch == ']') {
                // 1. Get the instructions from the "Pause" state
                int repeatTimes = countStack.pop();
                StringBuilder previousString = stringStack.pop();
                
                // 2. Repeat the finished inner block
                // (Using a loop is efficient here because we append to a StringBuilder)
                while (repeatTimes > 0) {
                    previousString.append(currentString);
                    repeatTimes--;
                }
                
                // 3. Move the combined result back into our "current" workspace
                currentString = previousString;
                
            } else {
                // Regular letter: just add it to the current level
                currentString.append(ch);
            }
        }
        
        return currentString.toString();
    }
}