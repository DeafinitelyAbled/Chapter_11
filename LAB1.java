import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

/*
Given main(), complete the program to add people to a queue.
The program should read in a list of people's names including "You" (ending with -1),
adding each person to the peopleInQueue queue. Then, remove each person from the queue until
"You" is at the head of the queue. Include print statements as shown in the example below.

Ex: If the input is:    Zadie Smith
                        Tom Sawyer
                        You
                        Louisa Alcott
                        -1
the output is:          Welcome to the ticketing service...
                        You are number 3 in the queue.
                        Zadie Smith has purchased a ticket.
                        You are now number 2
                        Tom Sawyer has purchased a ticket.
                        You are now number 1
                        You can now purchase your ticket!
*/

public class LAB1 {

    public static void main (String[] args) {
        Scanner scnr = new Scanner(System.in);
        String personName = "";
        int counter = 0;
        int youPosition = 0;

        Queue<String> peopleInQueue = new LinkedList<String>();

        personName = scnr.nextLine();
        while (!personName.equals("-1")) {
            // TODO: Add personName to peopleInQueue and
            //       determine position of "You" (youPosition)

            // if the input equals you, keep track of the position
            if (personName.equals("You")) {
                peopleInQueue.add(personName);
                ++counter;
                youPosition = counter;
            }
            else {
                peopleInQueue.add(personName);
                ++counter;
            }

            personName = scnr.nextLine();
        }

        System.out.println("Welcome to the ticketing service... ");
        System.out.println("You are number " + youPosition + " in the queue.");

        // TODO: In a loop, remove head person from peopleInQueue,
        //       output their name and that they have purchased a ticket,
        //       then output your position in the queue. When you are at
        //       the head, output that you can purchase your ticket.
        for (int i = youPosition - 1; 1 <= i; --i) {
            System.out.println(peopleInQueue.remove() + " has purchased a ticket.");
            System.out.println("You are now number " + i);
        }
        System.out.println("You can now purchase your ticket!");
    }
}
