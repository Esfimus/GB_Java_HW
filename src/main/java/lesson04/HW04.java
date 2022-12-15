package lesson04;

import java.util.ArrayList;
import java.util.Scanner;

public class HW04 {
    public static Scanner scanner = new Scanner(System.in);
    public static boolean backCommand = false;

    /**
     * Creates new two-dimensional array with the required size
     * @param size game grid size
     * @return two-dimensional array
     */
    public static char[][] newMatrix(int size) {
        char[][] matrix = new char[size][size];
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix.length; x++) {
                matrix[y][x] = ' ';
            }
        }
        return matrix;
    }

    /**
     * Creates random value between min and max
     * @param min minimum random value
     * @param max maximum random value
     * @return random value
     */
    public static int random(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    /**
     * Displays matrix with the required formatting
     * @param matrix incoming game grid
     */
    public static void displayMatrix(char[][] matrix) {
        // formatting for grid size < 10
        if (matrix.length < 10) {
            for (int i = 0; i < matrix.length * 2 + 2; i++) {
                System.out.print('͟');
            }
            System.out.println();
            for (int y = 0; y <= matrix.length; y++) {
                for (int x = 0; x <= matrix.length; x++) {
                    // displaying headers
                    if (x == 0 && y == 0) {
                        System.out.print("  ");
                    } else if (x == 0) {
                        System.out.print(y + "|");
                    } else if (y == 0) {
                        System.out.print(x + " ");
                    // displaying matrix with separators
                    } else {
                        System.out.print(matrix[y - 1][x - 1] + "|");
                    }
                }
                System.out.println();
            }
            for (int i = 0; i < matrix.length * 2 + 2; i++) {
                System.out.print('̅');
            }
            System.out.println();
        // formatting for grid size >= 10 with extra space
        } else {
            for (int i = 0; i < matrix.length * 4 + 4; i++) {
                System.out.print('͟');
            }
            System.out.println();
            for (int y = 0; y <= matrix.length; y++) {
                for (int x = 0; x <= matrix.length; x++) {
                    // displaying headers
                    if (x == 0 && y == 0) {
                        System.out.print("    ");
                    } else if (x == 0) {
                        System.out.print(String.format("%02d", y) + " |");
                    } else if (y == 0) {
                        System.out.print(String.format("%02d", x) + "  ");
                    // displaying matrix with separators
                    } else {
                        System.out.print(" " + matrix[y - 1][x - 1] + " |");
                    }
                }
                System.out.println();
            }
            for (int i = 0; i < matrix.length * 4 + 4; i++) {
                System.out.print('̅');
            }
            System.out.println();
        }
    }

    /**
     * Displays the menu and returns the input value
     * @return string value
     */
    public static String mainMenu() {
        System.out.println("""
                ͟͟͟͟͟͟͟͟͟͟͟͟͟͟͟͟͟͟͟͟͟͟͟͟͟͟͟͟
                Welcome to Tic-Tac-Toe game!
                Select players or exit:
                '1' - 1 player
                '2' - 2 players
                'exit' - close the app
                ̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅
                """);
        boolean isString = scanner.hasNextLine();
        if (isString) {
            return scanner.nextLine().toLowerCase();
        } else {
            return "";
        }
    }

    /**
     * Analyses coordinates input, filters incorrect input and returns the updated game grid
     * @param matrix incoming game grid
     * @param symbol current turn of 'X' or 'O'
     * @param size game grid size
     * @return updated game grid
     */
    public static char[][] userInput(char[][] matrix, char symbol, int size) {
        int x;
        int y;
        String inputString;
        do {
            // checking for two integer input
            System.out.println("Enter the coordinates:");
            if (scanner.hasNextInt() && scanner.hasNextInt()) {
                x = scanner.nextInt();
                y = scanner.nextInt();
                scanner.nextLine();
                if (x < 1 || x > size || y < 1 || y > size) {
                    System.out.println("Coordinates should be from 1 to " + size);
                } else if (matrix[y - 1][x - 1] == ' ') {
                    matrix[y - 1][x - 1] = symbol;
                    break;
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                }
            // checking string input for 'back' command and wrong input
            } else {
                inputString = scanner.next().toLowerCase();
                scanner.nextLine();
                if (inputString.equals("back")) {
                    System.out.println("\nSee you next time!\n");
                    backCommand = true; // activation of exit trigger
                    break;
                } else {
                    System.out.println("Wrong input. Please try again.");
                }
            }
        } while(true);
        return matrix;
    }

    /**
     * Analyses current game state, calculates priority values for all cells and makes one hell of a smart move
     * @param matrix current game grid
     * @param symbol current turn of 'X' or 'O'
     * @return updated game grid
     */
    public static char[][] computerInput(char[][] matrix, char symbol) {
        char opSymbol = (symbol == 'X') ? 'O' : 'X';
        int[][] priorityMatrix = new int[matrix.length][matrix.length];
        char[][] potentialMoveMatrix = matrix.clone();
        int winRow = (matrix.length == 3) ? 3 : 4;
        // iterating through evey cell
        for (int y = 0; y < potentialMoveMatrix.length; y++) {
            for (int x = 0; x < potentialMoveMatrix.length; x++) {
                // checking cell value
                if (potentialMoveMatrix[y][x] == ' ') {
                    // creating a copy of the game grid and analysing a potential move
                    potentialMoveMatrix[y][x] = symbol;
                    // checking all possible horizontal rows
                    for (int i = - (winRow - 1); i <= 0; i++) {
                        // filtering existing horizontal rows against walls
                        if (
                            (x + i) >= 0 &&
                            (x + i) + (winRow - 1) < potentialMoveMatrix.length
                        ) {
                            // analysing elements in a row
                            int symbolCount = 0;
                            int opSymbolCount = 0;
                            for (int j = 0; j < winRow; j++) {
                                if (potentialMoveMatrix[y][x + i + j] == symbol) {
                                    symbolCount++;
                                } else if (potentialMoveMatrix[y][x + i + j] == opSymbol) {
                                    opSymbolCount++;
                                }
                            }
                            // sending data for priority calculation
                            priorityMatrix(priorityMatrix, symbolCount, opSymbolCount, x, y);
                        }
                    }
                    // checking all possible vertical rows
                    for (int i = - (winRow - 1); i <= 0; i++) {
                        // filtering existing horizontal rows against walls
                        if (
                            (y + i) >= 0 &&
                            (y + i) + (winRow - 1) < potentialMoveMatrix.length
                        ) {
                            // analysing elements in a row
                            int symbolCount = 0;
                            int opSymbolCount = 0;
                            for (int j = 0; j < winRow; j++) {
                                if (potentialMoveMatrix[y + i + j][x] == symbol) {
                                    symbolCount++;
                                } else if (potentialMoveMatrix[y + i + j][x] == opSymbol) {
                                    opSymbolCount++;
                                }
                            }
                            // sending data for priority calculation
                            priorityMatrix(priorityMatrix, symbolCount, opSymbolCount, x, y);
                        }
                    }
                    // checking all possible ascending diagonal rows
                    for (int i = - (winRow - 1); i <= 0; i++) {
                        // filtering existing ascending diagonal rows against walls
                        if (
                            (x + i) >= 0 &&
                            (x + i) + (winRow - 1) < potentialMoveMatrix.length &&
                            (y - i) < potentialMoveMatrix.length &&
                            (y - i) - (winRow - 1) >= 0
                        ) {
                            // analysing elements in a row
                            int symbolCount = 0;
                            int opSymbolCount = 0;
                            for (int j = 0; j < winRow; j++) {
                                if (potentialMoveMatrix[y - i - j][x + i + j] == symbol) {
                                    symbolCount++;
                                } else if (potentialMoveMatrix[y - i - j][x + i + j] == opSymbol) {
                                    opSymbolCount++;
                                }
                            }
                            // sending data for priority calculation
                            priorityMatrix(priorityMatrix, symbolCount, opSymbolCount, x, y);
                        }
                    }
                    // checking all possible descending diagonal rows
                    for (int i = - (winRow - 1); i <= 0; i++) {
                        // filtering existing descending diagonal rows against walls
                        if (
                                (x + i) >= 0 &&
                                (x + i) + (winRow - 1) < potentialMoveMatrix.length &&
                                (y + i) >= 0 &&
                                (y + i) + (winRow - 1) < potentialMoveMatrix.length
                        ) {
                            // analysing elements in a row
                            int symbolCount = 0;
                            int opSymbolCount = 0;
                            for (int j = 0; j < winRow; j++) {
                                if (potentialMoveMatrix[y + i + j][x + i + j] == symbol) {
                                    symbolCount++;
                                } else if (potentialMoveMatrix[y + i + j][x + i + j] == opSymbol) {
                                    opSymbolCount++;
                                }
                            }
                            // sending data for priority calculation
                            priorityMatrix(priorityMatrix, symbolCount, opSymbolCount, x, y);
                        }
                    }
                    // reverting the potential move state
                    potentialMoveMatrix[y][x] = ' ';
                } else {
                    priorityMatrix[y][x] = 0; // zero priority if the cell is occupied
                }
            }
        }
        // display the priority matrix here - displayMatrixInt(priorityMatrix);
        // searching for the max priority value through the priority matrix
        int max = 0;
        for (int y = 0; y < priorityMatrix.length; y++) {
            for (int x = 0; x < priorityMatrix.length; x++) {
                if (priorityMatrix[y][x] > max) {
                    max = priorityMatrix[y][x];
                }
            }
        }
        // searching for the multiple max values and sending their coordinates to the list of max values coordinates
        ArrayList<int[]> maxCoordinates = new ArrayList<>();
        for (int y = 0; y < priorityMatrix.length; y++) {
            for (int x = 0; x < priorityMatrix.length; x++) {
                if (priorityMatrix[y][x] == max) {
                    int[] currentCoordinates = {y, x};
                    maxCoordinates.add(currentCoordinates);
                }
            }
        }
        // making a move based on a random selection of a cell with max priority if there are a few of them
        int[] randomMaxCoordinates = maxCoordinates.get(random(0, maxCoordinates.size() - 1));
        int xRandom = randomMaxCoordinates[1];
        int yRandom = randomMaxCoordinates[0];
        matrix[yRandom][xRandom] = symbol;
        return matrix;
    }

    /**
     * Evaluates priorities for one cell using its coordinates, increases priority values according to the current game state
     * @param prMatrix previous priority matrix
     * @param symbolCount number of friendly symbols for priority evaluation
     * @param opSymbolCount number of opponent's symbols for priority evaluation
     * @param x coordinate of a cell
     * @param y coordinate of a cell
     * @return updated priority matrix
     */
    public static int[][] priorityMatrix(int[][] prMatrix, int symbolCount, int opSymbolCount, int x, int y) {
        int winRow = (prMatrix.length == 3) ? 3 : 4;
        // (I) max priority - winning state
        if (symbolCount == (winRow)) {
            prMatrix[y][x] += 500;
        // (II) the highest priority - opponent winning state
        } else if (opSymbolCount == (winRow - 1)) {
            prMatrix[y][x] += 100;
        // (III) high priority - close to winning state for opponent
        } else if (opSymbolCount >= 2 && symbolCount == 1) { //opSymbolCount == (winRow - 1)
            prMatrix[y][x] += 30;
        // (IV) very good priority - potentially winning state
        } else if (opSymbolCount == 0 && symbolCount > 1) {
            prMatrix[y][x] += 4;
        // (V) good priority - empty row to build winning state
        } else if (opSymbolCount == 0 && symbolCount == 1) {
            prMatrix[y][x] += 3;
        // (VI) poor priority - the opponent has started building winning state
        } else if (opSymbolCount > 0 && symbolCount == 1) {
            prMatrix[y][x] += 2;
        // (VII) lowest priority - no chance to win for both players
        } else {
            prMatrix[y][x] += 1;
        }
        return prMatrix;
    }

    /**
     * Tic-Tac-Toe game for 2 players
     */
    public static void ticTacToe2() {
        System.out.println();
        int size = gridSize();
        // closing the game if the 'back' command was initialized in submenu 'grid size selection'
        if (size == -1) {
            return;
        }
        char[][] gameGrid = newMatrix(size);
        char symbol;
        boolean currentGameState;
        int turn = 1;
        // playing the game until 'back' command is activated or final game state is reached
        do {
            displayMatrix(gameGrid);
            symbol = (turn % 2 == 0) ? 'O' : 'X';
            userInput(gameGrid, symbol, size);
            currentGameState = gameState(gameGrid);
            turn++;
        } while(!backCommand && !currentGameState);
        if (backCommand) {
            return;
        }
        // calling the option to continue of exit
        System.out.println("Do you want to continue [y/n]?");
        String inputString;
        do {
            inputString = scanner.nextLine().toLowerCase();
            if (inputString.equals("y")) {
                // recursive function call
                ticTacToe2();
                return;
            } else if (inputString.equals("n")) {
                System.out.println("\nSee you next time!\n");
            } else {
                System.out.println("Wrong input. Please try again.");
            }
        } while (!inputString.equals("n"));
    }

    /**
     * Tic-Tac-Toe game for 1 player with computer
     */
    public static void ticTacToe1() {
        System.out.println();
        int size = gridSize();
        // closing the game if the 'back' command was initialized in submenu 'grid size selection'
        if (size == -1) {
            return;
        }
        char symbol;
        boolean currentGameState;
        int turn = 1;
        char[][] gameGrid = newMatrix(size);
        boolean userFirst = false;
        String inputString;
        // selecting who moves first, user or computer, and making the first move
        System.out.println("""
                
                Do you want to move first [y/n]?
                Note, that 'X' always moves first.
                """);
        do {
            inputString = scanner.nextLine().toLowerCase();
            if (inputString.equals("y")) {
                displayMatrix(gameGrid);
                userInput(gameGrid, 'X', size);
                userFirst = true;
                turn++;
                break;
            } else if (inputString.equals("n")) {
                computerInput(gameGrid, 'X');
                turn++;
                break;
            } else {
                System.out.println("Wrong input. Please try again.");
            }
        } while (true);
        if (backCommand) {
            return;
        }
        // playing the game until 'back' command is activated or final game state is reached
        do {
            displayMatrix(gameGrid);
            symbol = (turn % 2 == 0) ? 'O' : 'X';
            if (userFirst) {
                if (turn % 2 == 0) {
                    computerInput(gameGrid, symbol);
                } else {
                    userInput(gameGrid, symbol, size);
                }
            } else {
                if (turn % 2 == 0) {
                    userInput(gameGrid, symbol, size);
                } else {
                    computerInput(gameGrid, symbol);
                }
            }
            currentGameState = gameState(gameGrid);
            turn++;
        } while(!backCommand && !currentGameState);
        if (backCommand) {
            return;
        }
        // calling the option to continue of exit
        System.out.println("Do you want to continue [y/n]?");
        do {
            inputString = scanner.nextLine().toLowerCase();
            if (inputString.equals("y")) {
                // recursive function call
                ticTacToe1();
                return;
            } else if (inputString.equals("n")) {
                System.out.println("\nSee you next time!\n");
            } else {
                System.out.println("Wrong input. Please try again.");
            }
        } while (!inputString.equals("n"));
    }

    /**
     * Analyses current game state for all cells
     * @param matrix incoming game grid
     * @return true for first win sequence found or if there is no empty cells left
     */
    public static boolean gameState(char[][] matrix) {
        int emptyCells = 0;
        int winRow = (matrix.length == 3) ? 3 : 4;
        int winSequence = 1;
        // iterating through evey cell
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix.length; x++) {
                // checking cell value
                if (matrix[y][x] == 'X' || matrix[y][x] == 'O') {
                    // checking row length for the right diagonal direction
                    if (x + (winRow - 1) < matrix.length && y + (winRow - 1) < matrix.length) {
                        // iterating through the right diagonal direction
                        for (int i = 1; i < winRow; i++) {
                            if (matrix[y][x] == matrix[y + i][x + i]) {
                                winSequence++;
                            }
                        }
                        // checking the right diagonal direction for win sequence
                        if (winSequence == winRow) {
                            System.out.println("\nCongratulations! " + matrix[y][x] + " wins!");
                            displayMatrix(matrix);
                            return true;
                        } else {
                            winSequence = 1;
                        }
                    }
                    // checking row length for the left diagonal direction
                    if (x - (winRow - 1) >= 0 && y + (winRow - 1) < matrix.length) {
                        // iterating through the left diagonal direction
                        for (int i = 1; i < winRow; i++) {
                            if (matrix[y][x] == matrix[y + i][x - i]) {
                                winSequence++;
                            }
                        }
                        // checking the left diagonal direction for win sequence
                        if (winSequence == winRow) {
                            System.out.println("\nCongratulations! " + matrix[y][x] + " wins!");
                            displayMatrix(matrix);
                            return true;
                        } else {
                            winSequence = 1;
                        }
                    }
                    // checking row length for the right direction
                    if (x + (winRow - 1) < matrix.length) {
                        // iterating through the right direction
                        for (int i = 1; i < winRow; i++) {
                            if (matrix[y][x] == matrix[y][x + i]) {
                                winSequence++;
                            }
                        }
                        // checking the right direction for win sequence
                        if (winSequence == winRow) {
                            System.out.println("\nCongratulations! " + matrix[y][x] + " wins!");
                            displayMatrix(matrix);
                            return true;
                        } else {
                            winSequence = 1;
                        }
                    }
                    // checking row length for the down direction
                    if (y + (winRow - 1) < matrix.length) {
                        // iterating through the down direction
                        for (int i = 1; i < winRow; i++) {
                            if (matrix[y][x] == matrix[y + i][x]) {
                                winSequence++;
                            }
                        }
                        // checking the down direction for win sequence
                        if (winSequence == winRow) {
                            System.out.println("\nCongratulations! " + matrix[y][x] + " wins!");
                            displayMatrix(matrix);
                            return true;
                        } else {
                            winSequence = 1;
                        }
                    }
                } else {
                    emptyCells++;
                }
            }
        }
        // checking for empty cells and draw
        if (emptyCells == 0) {
            System.out.println("\nDraw! No one wins.");
            displayMatrix(matrix);
            return true;
        }
        return false;
    }

    /**
     * Checks user input and returns the desired grid size if the entered number is valid
     * @return grid size integer
     */
    public static int gridSize() {
        int size;
        String inputString;
        System.out.println("""
                ͟͟͟͟͟͟͟͟͟͟͟͟͟͟͟͟͟͟͟͟͟͟͟͟͟͟͟͟͟
                <<< Tic-Tac-Toe 2 players >>>
                Chose the grid size (3...50)
                Quit any time by typing 'back'
                
                """);
        do {
            // checking the input for integer number
            if (scanner.hasNextInt()) {
                size = scanner.nextInt();
                scanner.nextLine();
                if (size < 3) {
                    System.out.println("The grid size should be more than 3");
                } else if (size > 50) {
                    System.out.println("The size is too big, try to pick a smaller one");
                } else {
                    return size;
                }
            // checking string input for exit command and wrong input
            } else {
                inputString = scanner.next().toLowerCase();
                scanner.nextLine();
                if (inputString.equals("back")) {
                    return -1;
                } else {
                    System.out.println("Wrong input. Please try again.");
                }
            }
        } while(true);
    }

    public static void main(String[] args) {
        String selection;
        boolean close = false;
        do {
            selection = mainMenu();
            backCommand = false; // resetting 'back' trigger
            // selection of game or exit
            switch(selection) {
                case "1" -> ticTacToe1();
                case "2" -> ticTacToe2();
                case "exit" -> close = true;
                default -> System.out.println("Wrong input. Please try again.");
            }
        } while (!close);
        System.out.println("Closing the app...");
    }
}
