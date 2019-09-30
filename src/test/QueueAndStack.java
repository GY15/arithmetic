package test;

import java.util.*;

/**
 * Created by 61990 on 2017/10/11.
 */
public class QueueAndStack {
    static List<Character> queue = new LinkedList<>();
    static Stack<Character> stack = new Stack<>();
//    public static void main(String[] args) {
//
//    }
    // Write your code here.

    public static void pushCharacter(char c){
        stack.push(c);
    }
    public static void enqueueCharacter(char c){
        queue.add(0,c);
    }
    public static char popCharacter(){
        return stack.pop();
    }
    public static char dequeueCharacter(){
        char c = queue.get(queue.size()-1);
        queue.remove(queue.size()-1);
        return c;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();

        // Convert input String to an array of characters:
        char[] s = input.toCharArray();

        // Create a Tanchishe object:
        QueueAndStack p = new QueueAndStack();

        // Enqueue/Push all chars to their respective data structures:
        for (char c : s) {
            p.pushCharacter(c);
            p.enqueueCharacter(c);
        }

        // Pop/Dequeue the chars at the head of both data structures and compare them:
        boolean isPalindrome = true;
        for (int i = 0; i < s.length/2; i++) {
            if (p.popCharacter() != p.dequeueCharacter()) {
                isPalindrome = false;
                break;
            }
        }

        //Finally, print whether string s is palindrome or not.
        System.out.println( "The word, " + input + ", is "
                + ( (!isPalindrome) ? "not a palindrome." : "a palindrome." ) );
    }
}

