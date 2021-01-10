package lesson4hw;

import java.util.Random;
import java.util.Scanner;

public class Lesson4X0GameApplication {
    //This the code from the lesson, a little bit improved
    public static int SIZE = 5;
    public static int DOTS_TO_WIN = 3;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static char[][] mapDraft;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static int x, y;

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(0, 0, SIZE, DOT_O)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(0, 0, SIZE, DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    public static boolean checkWin(int iStart, int jStart, int checkSize, char symb) {
     //   int checkSize = iEnd-iStart+1;
        for ( int i = iStart; i < checkSize; i++ ) {
            for ( int j = jStart; j < checkSize; j++ ) {
                if ((j + DOTS_TO_WIN <= checkSize) && (checkHorizontal(i, j, DOTS_TO_WIN, symb)) ||
                        (i + DOTS_TO_WIN <= checkSize) && (checkVertical(i, j, DOTS_TO_WIN, symb)) ||
                        (i - DOTS_TO_WIN >= 0) && (j + DOTS_TO_WIN <= checkSize) && (checkUpDiagonal(i, j, DOTS_TO_WIN, symb)) ||
                        (i + DOTS_TO_WIN <= checkSize) && (j + DOTS_TO_WIN <= checkSize) && (checkDownDiagonal(i, j, DOTS_TO_WIN, symb))
                ) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkHorizontal(int i, int j, int dotsToWin, char symb) {
        for ( int k = 0; k < dotsToWin; k++ ) {
            if (map[i][j + k] != symb) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkVertical(int i, int j, int dotsToWin, char symb) {
        for ( int k = 0; k < dotsToWin; k++ ) {
            if (map[i + k][j] != symb) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkUpDiagonal(int i, int j, int dotsToWin, char symb) {
        for ( int k = 0; k < dotsToWin; k++ ) {
            if (map[i - k][j + k] != symb) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkDownDiagonal(int i, int j, int dotsToWin, char symb) {
        for ( int k = 0; k < dotsToWin; k++ ) {
            if (map[i + k][j + k] != symb) {
                return false;
            }
        }
        return true;
    }

    public static boolean tryToWin(char symb) {
        for ( int i = 0; i < map.length; i++ ) {
            for ( int j = 0; j < map.length; j++ ) {
                if (map[i][j] == DOT_EMPTY) {
                    map[i][j] = DOT_O;
                    if (checkWin(Math.max(0,i - DOTS_TO_WIN + 1), Math.max(0,j - DOTS_TO_WIN + 1), DOTS_TO_WIN * 2 - 1, symb)) {
                        y=i;
                        x=j;
                        return true;
                    } else {
                        map[i][j] = DOT_EMPTY;
                    }
                }
            }
        }
        return false;
    }

    private static boolean tryToBlockWin(char playerSymb, char opponentSymb) {
        for ( int i = 0; i < map.length; i++ ) {
            for ( int j = 0; j < map.length; j++ ) {
                if (map[i][j] == DOT_EMPTY) {
                    map[i][j] = opponentSymb;
                    if (checkWin(Math.max(0,i - DOTS_TO_WIN + 1), Math.max(0,j - DOTS_TO_WIN + 1), DOTS_TO_WIN * 2 - 1, opponentSymb)) {
                        map[i][j] = playerSymb;
                        y=i;
                        x=j;
                        return true;
                    } else {
                        map[i][j] = DOT_EMPTY;
                    }
                }
            }
        }
        return false;
    }

    public static boolean isMapFull() {
        for ( int i = 0; i < SIZE; i++ ) {
            for ( int j = 0; j < SIZE; j++ ) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static void aiTurn() {
               if (!tryToWin(DOT_O)) {
            if (!tryToBlockWin(DOT_O, DOT_X)) {
                               do {
                    x = rand.nextInt(SIZE);
                    y = rand.nextInt(SIZE);
                } while (!isCellValid(x, y));
                System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
                map[y][x] = DOT_O;
            }
        }
    }



//    public static void aiTurnClever() {
//        int x, y;
//        do {
//            x = rand.nextInt(SIZE);
//            y = rand.nextInt(SIZE);
//        } while (!isCellValid(x, y));
//        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
//        map[y][x] = DOT_O;
//    }

//    public static boolean tryToWin(){
//        for
//        return false;
//    }
//
//    public static void aiTurn() {
//        mapDraft = map.clone();
//        tryToWin();
//        int x, y;
//        do {
//            x = rand.nextInt(SIZE);
//            y = rand.nextInt(SIZE);
//        } while (!isCellValid(x, y));
//        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
//        map[y][x] = DOT_O;
//    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for ( int i = 0; i < SIZE; i++ ) {
            for ( int j = 0; j < SIZE; j++ ) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for ( int i = 0; i <= SIZE; i++ ) {
            System.out.print(i + " ");
        }
        System.out.println();
        for ( int i = 0; i < SIZE; i++ ) {
            System.out.print((i + 1) + " ");
            for ( int j = 0; j < SIZE; j++ ) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
