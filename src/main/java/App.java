public class App {
    public static void main(String[] args) {
        final short[][] MATRIX_A = {
            {11, 255, -678},
            {-2, 441, 0},
            {54, -111, 512}
        };

        final short[][] MATRIX_B = {
            {-173, 123, -154},
            {0, 42, 455},
            {-256, -143, 300}
        };

        // Check matrices before operation
        if (MATRIX_A == null || MATRIX_B == null) {
            System.out.println("Matrices should not be null");
            System.exit(1);
        }

        if (!(MATRIX_A instanceof short[][]) || !(MATRIX_B instanceof short[][])) {
            System.out.println("Matrices should be short[][]");
            System.exit(1);
        }

        if (MATRIX_A.length != MATRIX_B.length) {
            System.out.println("Number of rows should be the same");
            System.exit(1);
        }

        for (int i = 0; i < MATRIX_A.length; i++) {
            if (MATRIX_A[i].length != MATRIX_B[i].length) {
                System.out.println("Number of columns should be the same");
                System.exit(1);
            }
        }

        // Perform XOR operation
        int rows = MATRIX_A.length;
        int cols = MATRIX_A[0].length;
        short[][] matrix_C = new short[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix_C[i][j] = (short) (MATRIX_A[i][j] ^ MATRIX_B[i][j]);
            }
        }

        // Print result
        System.out.println("MATRIX_A XOR MATRIX_B =");
        for (short[] row : matrix_C) {
            for (short value : row) {
                System.out.print(String.format("%5d", value) + " ");
            }
            System.out.println();
        }
        System.out.println();

        // Get sum of min elements from each row
        int sum = 0;
        for (short[] row : matrix_C) {
            short min = row[0];
            for (short value : row) {
                if (value < min) {
                    min = value;
                }
            }
            sum += min;
        }

        // Print result
        System.out.println("Sum of min elements from each row of matrix C =");
        System.out.println(sum);
    }
}
