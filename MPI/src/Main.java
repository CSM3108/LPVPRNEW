import mpi.*;

public class Main {
    public static void main(String[] args) throws Exception {
        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        int unitsize = 5;
        int root = 0;

        int[] send_buffer = new int[unitsize * size];
        int[] recv_buffer = new int[unitsize];
        int[] result_buffer = new int[size];

        // Root initializes array
        if (rank == root) {
            System.out.println("Root initializing array:");
            for (int i = 0; i < unitsize * size; i++) {
                send_buffer[i] = i + 1;
                System.out.print(send_buffer[i] + " ");
            }
            System.out.println();
        }

        // Scatter
        MPI.COMM_WORLD.Scatter(send_buffer, 0, unitsize, MPI.INT,
                recv_buffer, 0, unitsize, MPI.INT, root);

        // Compute local sum
        int local_sum = 0;
        for (int i = 0; i < unitsize; i++) {
            local_sum += recv_buffer[i];
        }

        System.out.println("Process " + rank + " local sum: " + local_sum);

        // Gather results
        MPI.COMM_WORLD.Gather(new int[]{local_sum}, 0, 1, MPI.INT,
                result_buffer, 0, 1, MPI.INT, root);

        // Final sum
        if (rank == root) {
            int total = 0;
            for (int i = 0; i < size; i++) {
                total += result_buffer[i];
            }
            System.out.println("Final sum: " + total);
        }

        MPI.Finalize();
    }
}
