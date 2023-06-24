/*
A palindrome is a string that reads the same backwards and forwards. 
Use a deque to implement a program that tests whether a line of text is a palindrome. 
The program reads a line, then outputs whether the input is a palindrome or not.

Example, if the input is: senile felines!
the output is: "Yes, "senile felines!" is a palindrome."

Example, if the input is: rotostor
the output is: "No, "rotostor" is not a palindrome."

Ignore punctuation and spacing. Assume all alphabetic characters will be lowercase.
Special case: A one-character string is a palindrome.
Hint: The deque must be a Deque of Characters, 
but ordinary chars will be automatically converted to Characters when added to the deque.
*/

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Deque;

public class LAB2 {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String line;

        /* Type your code here. */
        Deque<Character> deque = new LinkedList<Character>();
        boolean isPalindrome = true;

        line = scnr.nextLine();

        for (int i = 0; i < line.length(); ++i) {
            char j = line.charAt(i);
            if (Character.isLetter(j)) {
                deque.addLast(Character.toLowerCase(j));
            }
        }

        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char back = deque.removeLast();

            if (front == back) {
                continue;
            }
            else {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("Yes, \"" + line + "\" is a palindrome.");
        } else {
            System.out.println("No, \"" + line + "\" is not a palindrome.");
        }

        scnr.close();
    }
}