/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_b1_j1.s.p0074;

/**
 *
 * @author Nam
 */
public class MatrixesManagement {
    public void displayMenu() {
        System.out.println("=======Calculator program======");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
    }

    public int choiceOption() {
        Validate input = new Validate();
        return input.option("Your choice:", 1, 4);
    }

    public void additionMatrixes() {
        System.out.println("-------- Addition --------");
        //Input first matrix
        int[][] firstMatrix = enterMatrixAddSub(1, 0, 0);
        //Input second matrix
        int[][] secondMatrix = enterMatrixAddSub(2, firstMatrix.length, firstMatrix[0].length);
        //Add two matrixes
        int[][] sum = addTwoMatrix(firstMatrix, secondMatrix);
        //Display matrixes
        System.out.println("-------- Result --------");
        displayMatrix(firstMatrix);
        System.out.println("+");
        displayMatrix(secondMatrix);
        System.out.println("=");
        displayMatrix(sum);
    }

    private int[][] enterMatrixAddSub(int times, int difRow, int difColumn) {
        Validate input = new Validate();
        int row;
        //Run until check first matrix or two row is equals of two matrixes
        do {
            row = input.integerNumber("Enter Row Matrix " + times + ":");
            //Check is not first matrix
            if (times != 1) {
                //Check two row of matrix equals
                if (difRow == row) {
                    break;
                } else {
                    System.out.println("Row of matrix 2 must equals "
                            + "with row matrix 1. Pls enter again!");
                }
            }
        } while (times != 1);
        int column;
        //Run until check first matrix or two column is equals of two matrixes
        do {
            column = input.integerNumber("Enter Column Matrix " + times + ":");
            //Check is not first matrix
            if (times != 1) {
                //Check two column of matrix equals
                if (difColumn == column) {
                    break;
                } else {
                    System.out.println("Column of matrix 2 must equals "
                            + "with column matrix 1. Pls enter again!");
                }
            }
        } while (times != 1);
        int[][] matrix = new int[row][column];
        //Run row of matrix times
        for (int i = 0; i < row; i++) {
            //Run column of matrix times
            for (int j = 0; j < column; j++) {
                matrix[i][j] = input.matrixValue("Enter Matrix" + times
                        + "[" + (i+1) + "][" + (j+1) + "]:");
            }
        }
        return matrix;
    }

    private int[][] addTwoMatrix(int[][] firstMatrix, int[][] secondMatrix) {
        int row = firstMatrix.length;
        int column = firstMatrix[0].length;
        int[][] sum = new int[row][column];
        //Run row of matrix times
        for (int i = 0; i < row; i++) {
            //Run column of matrix times
            for (int j = 0; j < column; j++) {
                sum[i][j] = firstMatrix[i][j] + secondMatrix[i][j];
            }
        }
        return sum;
    }

    private void displayMatrix(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        //Run row of matrix times
        for (int i = 0; i < row; i++) {
            //Run column of matrix times
            for (int j = 0; j < column; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println("");
        }
    }

    public void subtractionMatrixes() {
        System.out.println("----- Subtraction ------");
        //Input first matrix
        int[][] firstMatrix = enterMatrixAddSub(1, 0, 0);
        //Input second matrix
        int[][] secondMatrix;
        secondMatrix = enterMatrixAddSub(2, firstMatrix.length, firstMatrix[0].length);
        //Subtraction two matrixes
        int[][] difference = subTwoMatrix(firstMatrix, secondMatrix);
        //Display matrixes
        System.out.println("-------- Result --------");
        displayMatrix(firstMatrix);
        System.out.println("-");
        displayMatrix(secondMatrix);
        System.out.println("=");
        displayMatrix(difference);

    }

    private int[][] subTwoMatrix(int[][] firstMatrix, int[][] secondMatrix) {
        int row = firstMatrix.length;
        int column = firstMatrix[0].length;
        int[][] difference = new int[row][column];
        //Run row of first matrix times
        for (int i = 0; i < row; i++) {
            //Run column of first matrix times
            for (int j = 0; j < column; j++) {
                difference[i][j] = firstMatrix[i][j] - secondMatrix[i][j];
            }
        }
        return difference;
    }

    public void multiplicationMatrixes() {
        System.out.println("-------- Multiplication -------");
        //Input first matrix
        int[][] firstMatrix = enterMatrixMul(1, 0);
        //Input second matrix
        int[][] secondMatrix = enterMatrixMul(2, firstMatrix[0].length);
        //Multiple two matrixes
        int[][] multiple = mulTwoMatrix(firstMatrix, secondMatrix);
        //Display matrixes
        System.out.println("-------- Result --------");
        displayMatrix(firstMatrix);
        System.out.println("*");
        displayMatrix(secondMatrix);
        System.out.println("=");
        displayMatrix(multiple);
        System.out.println("");
    }

    private int[][] enterMatrixMul(int times, int difColumn) {
        Validate input = new Validate();
        int row;
        //Run until check is first matrix or column first maxtrix equals with row second maxtrix
        do {
            row = input.integerNumber("Enter Row Matrix " + times + ":");
            //Check is not first matrix
            if (times != 1) {
                if (difColumn == row) {
                    break;
                } else {
                    System.out.println("Row of matrix 2 must equals "
                        + "with column matrix 1. Pls enter again!");
                }
            }
        } while (times != 1);
        int column = input.integerNumber("Enter Column Matrix " + times + ":");
        int[][] matrix = new int[row][column];
        //Run row of first matrix times
        for (int i = 0; i < row; i++) {
            //Run column of first matrix times
            for (int j = 0; j < column; j++) {
                matrix[i][j] = input.matrixValue("Enter Matrix" + times
                        + "[" + (i+1) + "][" + (j+1) + "]:");
            }
        }
        return matrix;
    }

    private int[][] mulTwoMatrix(int[][] firstMatrix, int[][] secondMatrix) {
        int row = firstMatrix.length;
        int column = secondMatrix[0].length;
        int[][] multiple = new int[row][column];
        //Run row of first matrix times
        for (int i = 0; i < row; i++) {
            //Run column of second matrix times
            for (int j = 0; j < column; j++) {
                multiple[i][j] = 0;
                //Run row of second matrix times
                for (int k = 0; k < secondMatrix.length; k++) {
                    multiple[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }
        return multiple;
    }

    public void exitProgram() {
        System.out.println("Thanks!");
    }

    public void wrongOption() {
        System.out.println("Your option don't exist. Pls, choice again.");
    }
}
