import java.util.*;

public class RingElection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int[] process = new int[n];
        System.out.println("Enter process IDs:");
        for (int i = 0; i < n; i++) {
            process[i] = sc.nextInt();
        }

        System.out.print("Enter initiator index (0 to " + (n - 1) + "): ");
        int initiator = sc.nextInt();
        int maxId = process[initiator];

        System.out.println("\nElection starts from process " + process[initiator]);
        int i = (initiator + 1) % n;

        while (i != initiator) {
            System.out.println("Process " + process[i] + " receives election message");
            if (process[i] > maxId) {
                maxId = process[i];
            }
            i = (i + 1) % n;
        }

        System.out.println("\nProcess " + maxId + " becomes the COORDINATOR");

        // Announcement phase
        i = (initiator + 1) % n;
        while (i != initiator) {
            System.out.println("Coordinator message sent to process " + process[i]);
            i = (i + 1) % n;
        }

        sc.close();
    }
}