package TicTacToe;

import java.util.Scanner;

class TicTacToe {

    public static char[][] board = {
            { '.', '.', '.' },
            { '.', '.', '.' },
            { '.', '.', '.' }
    };

    public static String[] coordinates = { "a1", "a2", "a3", "b1", "b2", "b3", "c1", "c2", "c3", };

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] params) {
        display();

        chooseCase();

        scan.close();
    }

    public static void display() {
        for (char[] cs : board) {
            System.out.println(cs);

        }
    }

    public static void chooseCase() {
        boolean isFound = false;
        int column = 0;
        int row = 0;
        int idPlayer = 1;
        System.out.println("Quelle case choisissez-vous ?");
        while (true) {
            try {
                String choosedCased = scan.next();
                isFound = false;

                char symbol = idPlayer == 1 ? 'x' : 'o';
                for (String coordinate : coordinates) {
                    if (coordinate.equals(choosedCased)) {
                        System.out.println("Vous choisissez " + choosedCased);
                        for (int i = 0; i < choosedCased.length(); i++) {
                            char c = choosedCased.charAt(i);
                            switch (c) {
                                case '1':
                                    column = 0;
                                    break;
                                case '2':
                                    column = 1;
                                    break;
                                case '3':
                                    column = 2;
                                    break;
                                case 'a':
                                    row = 0;
                                    break;
                                case 'b':
                                    row = 1;
                                    break;
                                default:
                                    row = 2;
                                    break;
                            }
                        }
                        if (isAvailable(row, column)) {
                            board[row][column] = symbol;
                            display();
                            if (isEquality()) {
                                System.out.println("Egalité !");
                                System.exit(0);
                            }
                            ;
                            hasWon(idPlayer);
                            isFound = true;
                            idPlayer = idPlayer == 1 ? 2 : 1;
                        } else {
                            System.out.println(
                                    "La case est déjà occupée");
                        }
                        break;
                    }
                }
                if (isFound == false) {
                    System.out.println(
                            "Vous choisissez, devez choisir parmi les coordonnées a1,a2,a3,b1,b2,b3,c1,c2,c3 et pas "
                                    + choosedCased);
                }
            } catch (Exception e) {
                System.out.println("Vous avez une erreur");
            }
        }
    }

    public static void hasWon(int idPlayer) {

        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '.' &&
                    board[i][0] == board[i][1] &&
                    board[i][1] == board[i][2]) {
                System.out.println("Le joueur " + idPlayer + " a gagné !");
                System.exit(0);
            }

            else if (board[0][i] != '.' &&
                    board[0][i] == board[1][i] &&
                    board[1][i] == board[2][i]) {
                System.out.println("Le joueur " + idPlayer + " a gagné !");
                System.exit(0);
            }

            if (board[0][0] != '.' &&
                    board[1][1] == board[0][0] &&
                    board[2][2] == board[1][1]) {
                System.out.println("Le joueur " + idPlayer + " a gagné !");
                System.exit(0);

            }
            if (board[0][2] != '.' &&
                    board[1][1] == board[0][2] &&
                    board[2][0] == board[1][1]) {
                System.out.println("Le joueur " + idPlayer + " a gagné !");
                System.exit(0);
            }
        }
    }

    public static boolean isAvailable(int row, int column) {
        if (board[row][column] == 'x' || board[row][column] == 'o') {
            return false;
        }
        return true;
    }

    public static boolean isEquality() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '.') {
                    return false;
                }
            }
        }

        return true;
    }
}
