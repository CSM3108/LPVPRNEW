import java.util.Arrays;

public class BullyAlgorithm {
    static int n = 5;
    static boolean[] alive = new boolean[n];

    public static void main(String[] args) {
        Arrays.fill(alive, true);
        System.out.println("=== Coordinator is Process 4 ===");

        System.out.println("\n--- Process 4 (Coordinator) crashes! ---");
        alive[4] = false;

        int initiator = 1;
        System.out.println("Process " + initiator + " starts the election.");
        election(initiator);
    }

    static void election(int id) {
        boolean higherAlive = false;
        for (int i = id + 1; i < n; i++) {
            System.out.println("Election message: Process " + id + " -> Process " + i);
            if (alive[i]) {
                System.out.println("OK message: Process " + i + " -> Process " + id);
                higherAlive = true;
                election(i);
                return;
            }
        }

        // If no higher process responded, this process becomes leader
        if (!higherAlive) {
            System.out.println("\n*** Process " + id + " is the new Coordinator! ***");
            // Inform everyone else
            for (int i = 0; i < n; i++) {
                if (i != id && alive[i]) {
                    System.out.println("Coordinator message: " + id + " -> Process " + i + ": I am the leader.");
                }
            }
        }
    }
}
