
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    /**
     * Force the user to enter an integer in the range between min and max
     * @param mess
     * @param min
     * @param max
     * @return int
     */
    public int inputSizeMatrix(String mess, int min, int max) {
        int num;
        do {
            System.out.print(mess);
            try {
                // Enter number integer
                num = Integer.parseInt(sc.nextLine());
                // Number in the range then return
                if (num >= min && num <= max) {
                    return num;
                // Number don't in the range then enter again    
                } else {
                    System.out.println("Out of range. You must choose ("+min+" -> "+max+")");
                }
            } catch (NumberFormatException e) {
                System.out.println("Values of matrix must be the number");
            }
        } while (true);
    }

    /**
     * Enter the elements of matrix
     * @param a 
     */
    public void inputMatrix(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] = inputSizeMatrix("Enter matrix[" + (i+1) + "][" + (j+1) + "]: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        }
    }

    /**
     * Print matrix
     * @param a 
     */
    public void printMatrix(int[][] a) {
        if (a == null) {
            return;
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print("[" + a[i][j] + "]");
            }
            System.out.println("");
        }
    }

    /**
     * Function add matrix
     * @param a1
     * @param a2
     * @return int[][]
     */
    public int[][] addMatrix(int[][] a1, int[][] a2) {
        // Check 2 matrix have same size?
        if (a2.length != a1.length || a2[0].length != a1[0].length) // If don't same size then return null
        {
            return null;
        }
        // Declare a matrix of the same size as 2 added matrices
        int[][] res = new int[a1.length][a1[0].length];
        // Add matrix
        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a1[0].length; j++) {
                res[i][j] = a1[i][j] + a2[i][j]; //the value at position i,j of matrix 1 plus the value at position i,j of matrix 2
            }
        }
        return res;
    }
    
    /**
     * Function subtract matrix
     * @param a1
     * @param a2
     * @return 
     */
    public int[][] subMatrix(int[][] a1, int[][] a2) {
        // Check 2 matrix have same size?
        if (a2.length != a1.length || a2[0].length != a1[0].length)// If don't same size then return null
        {
            return null;
        }
        // Declare a matrix of the same size as 2 added matrices
        int[][] res = new int[a1.length][a1[0].length];
        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a1[0].length; j++) {
                res[i][j] = a1[i][j] - a2[i][j];//The value at position i,j of matrix 1 subtract the value at position i,j of matrix 2
            }
        }
        return res;
    }

    /**
     * Function multiplication matrix
     * @param a1
     * @param a2
     * @return 
     */
    public int[][] mulMatrix(int[][] a1, int[][] a2) {
        //Columns of matrix 1 that are different from rows of matrix 2 cannot be multiplied return null
        if (a1[0].length != a2.length) {
            return null;
        }
        // Declare a matrix with the same row as the row of matrix 1 and the same colunm as the columm of matrix 2
        int[][] res = new int[a1.length][a2[0].length];
        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a2[0].length; j++) {
                for (int k = 0; k < a1[0].length; k++) {
                    res[i][j] += a1[i][k] * a2[k][j]; // Rows of matrix 1 multiply by columns of matrix 2 then add together
                }
            }
        }
        return res;
    }

    /**
     * Prints the main menu and handles user input for 
     * main menu commands.
     * @param args 
     */
    public static void main(String[] args) {
        Main m = new Main();
        int choice;
        
        // Print menu
        do {
            System.out.println("=== Calculator program ===");
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Quit");
            choice = m.inputSizeMatrix("Your choice: ", 1, 4);
            // The user enters what he wants to use
            switch (choice) {
                // Add matrix
                case 1: {
                    System.out.println("-------- Addition --------");
                    int[][] Matrix1 = new int[m.inputSizeMatrix("Enter row matrix 1: ", 1, Integer.MAX_VALUE)][m.inputSizeMatrix("Enter col matrix 1: ", 1, Integer.MAX_VALUE)];
                    m.inputMatrix(Matrix1);
                    int[][] Matrix2 = new int[m.inputSizeMatrix("Enter row matrix 2: ", 1, Integer.MAX_VALUE)][m.inputSizeMatrix("Enter col matrix 2: ", 1, Integer.MAX_VALUE)];
                    m.inputMatrix(Matrix2);
                    System.out.println("-------- Result --------");
                    m.printMatrix(Matrix1);
                    System.out.println("+");
                    m.printMatrix(Matrix2);
                    System.out.println("=");
                    if (m.addMatrix(Matrix1, Matrix2) == null) {
                        System.out.println("Can't add 2 matrix different size");
                    } else {
                        m.printMatrix(m.addMatrix(Matrix1, Matrix2));
                    }

                    break;
                }
                // Sub matrix
                case 2: {
                    System.out.println("-------- Subtraction --------");
                    int[][] Matrix1 = new int[m.inputSizeMatrix("Enter row matrix 1: ", 1, Integer.MAX_VALUE)][m.inputSizeMatrix("Enter col matrix 1: ", 1, Integer.MAX_VALUE)];
                    m.inputMatrix(Matrix1);
                    int[][] Matrix2 = new int[m.inputSizeMatrix("Enter row matrix 2: ", 1, Integer.MAX_VALUE)][m.inputSizeMatrix("Enter col matrix 2: ", 1, Integer.MAX_VALUE)];
                    m.inputMatrix(Matrix2);
                    System.out.println("-------- Result --------");
                    m.printMatrix(Matrix1);
                    System.out.println("-");
                    m.printMatrix(Matrix2);
                    System.out.println("=");
                    if (m.subMatrix(Matrix1, Matrix2) == null) {
                        System.out.println("Can't sub 2 matrix different size");
                    } else {
                        m.printMatrix(m.subMatrix(Matrix1, Matrix2));
                    }

                    break;
                }
                // Mul matrix
                case 3: {
                    System.out.println("-------- Multiplication --------");
                    int[][] Matrix1 = new int[m.inputSizeMatrix("Enter row matrix 1: ", 1, Integer.MAX_VALUE)][m.inputSizeMatrix("Enter col matrix 1: ", 1, Integer.MAX_VALUE)];
                    m.inputMatrix(Matrix1);
                    int[][] Matrix2 = new int[m.inputSizeMatrix("Enter row matrix 2: ", 1, Integer.MAX_VALUE)][m.inputSizeMatrix("Enter col matrix 2: ", 1, Integer.MAX_VALUE)];
                    m.inputMatrix(Matrix2);
                    System.out.println("-------- Result --------");
                    m.printMatrix(Matrix1);
                    System.out.println("*");
                    m.printMatrix(Matrix2);
                    System.out.println("=");
                    if (m.mulMatrix(Matrix1, Matrix2) == null) {
                        System.out.println("Can't mul 2 matrix ");
                    } else {
                        m.printMatrix(m.mulMatrix(Matrix1, Matrix2));
                    }
                    break;
                }
                // Exit program
                default:
                    break;
            }
        } while (choice != 4);
    }
}
