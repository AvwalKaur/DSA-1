import java.util.Scanner;

class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class optimalSolution {
    public static Node removeNthFromEnd(Node head, int N){
        Node slow = head;
        Node fast = head;

        for(int i=0; i<N; i++){
            fast = fast.next;
        }

        if(fast == null){
            return head.next;
        }

        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return head;
    }

    // Utility function to print the linked list
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Utility function to create a linked list from user input
    public static Node createList(Scanner scanner) {
        System.out.print("Enter the number of nodes: ");
        int n = scanner.nextInt();
        if (n == 0) return null;

        System.out.print("Enter the elements of the list: ");
        Node head = new Node(scanner.nextInt());
        Node current = head;

        for (int i = 1; i < n; i++) {
            current.next = new Node(scanner.nextInt());
            current = current.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create the linked list from user input
        Node head = createList(scanner);

        System.out.print("Enter the position (n) of the node to remove from the end: ");
        int n = scanner.nextInt();

        System.out.println("Original list:");
        printList(head);

        // Remove the nth node from the end
        head = removeNthFromEnd(head, n);

        System.out.println("List after removing " + n + "th node from the end:");
        printList(head);

        scanner.close();
    }    
}
