/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segovia_3_arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author TheInnerNerd
 */
public class Segovia_3_Arrays {

    static Scanner sc = new Scanner(System.in);

    static int health = 20;
    static int x = 15;
    static int y = 15;
    static int nx = 15;
    static int ny = 15;
    static int maxX = 30;
    static int maxY = 30;
    static int trapx;
    static int trapy;
    static int score;
    static int enemyX = (int) (Math.random() * maxY);
    static int enemyY = (int) (Math.random() * maxY);
    static int enemyBX = (int) (Math.random() * maxY);
    static int enemyBY = (int) (Math.random() * maxY);
    static int treY = (int) (Math.random() * maxY);
    static int treX = (int) (Math.random() * maxX);
    static int treBY = (int) (Math.random() * maxY);
    static int treBX = (int) (Math.random() * maxX);
    static int treCY = (int) (Math.random() * maxY);
    static int treCX = (int) (Math.random() * maxX);
    static String[][] map = new String[maxX][maxY];
    static boolean[][] traps = new boolean[maxX][maxY];
    static boolean[][] treasureChest = new boolean[maxX][maxY];
    static boolean[][] enemyZ = new boolean[maxX][maxY];
    public static boolean game = true;
    public static boolean enemy = true;
    public static boolean enemyB = true;
    public static boolean Blocked = false;

    public static void main(String[] args) {
        startUp();
    }

    public static void startUp() {
        System.out.println("you are the @ sign the Array City needs \n"
                + "avoid your Xs and get to the treasure they stole\n"
                + "gold diggers");
        if (traps[x][y] == true) {
            x = (int) Math.floor(Math.random() * maxX);
            y = (int) Math.floor(Math.random() * maxY);
        }
        for (int t = 0; t < 50; t++) {
            int trapx = (int) Math.floor(Math.random() * maxX);
            int trapy = (int) Math.floor(Math.random() * maxY);
            traps[trapx][trapy] = true;
        }
        treasureChest[treY][treX] = true;
        treasureChest[treBY][treBX] = true;
        treasureChest[treCY][treCX] = true;
        while (game) {
            printArray();
            move();

        }
    }

    static void move() {
        map[y][x] = " .";
        System.out.println(" which way would you like to go w,a,s,d, or q,e,z,c?");
        String direction = sc.nextLine();
        //north
        if (direction.equalsIgnoreCase("w")) {
            ny--;
            traps();
            enemyZ();
            treasureChest();
            y--;
        }
        //south
        if (direction.equalsIgnoreCase("s")) {
            ny++;
            traps();
            enemyZ();
            treasureChest();
            y++;
        }
        //east
        if (direction.equalsIgnoreCase("d")) {
            nx++;
            traps();
            enemyZ();
            treasureChest();
            x++;
        }
        //west
        if (direction.equalsIgnoreCase("a")) {
            nx--;
            traps();
            enemyZ();
            treasureChest();
            x--;
        }
        //northEast
        if (direction.equalsIgnoreCase("e")) {
            ny--;
            nx++;
            traps();
            enemyZ();
            treasureChest();
            y--;
            x++;
            //northWest
        }
        if (direction.equalsIgnoreCase("q")) {
            y--;
            x--;
            traps();
            enemyZ();
            treasureChest();
            y--;
            x--;
            //southWest    
        }
        if (direction.equalsIgnoreCase("z")) {
            ny++;
            nx--;
            traps();
            enemyZ();
            treasureChest();
            y++;
            x--;
            //southEast    
        }
        if (direction.equalsIgnoreCase("c")) {
            ny++;
            nx++;
            traps();
            enemyZ();
            treasureChest();
            y++;
            x++;
        }
    }

    public static void life() {
        if (health <= 0) {
            System.out.println(" __   __            _                   \n"
                    + " \\ \\ / /__  _   _  | |    ___  ___  ___ \n"
                    + "  \\ V / _ \\| | | | | |   / _ \\/ __|/ _ \\\n"
                    + "   | | (_)  ||_| | | |__| (_) \\__ \\  __/\n"
                    + "   |_|\\___/ \\__,_| |_____\\___/|___/\\___|");
            game = false;
        }
        if(score >= 10){
                        System.out.println("__   __           __        ___       \n"
                    + "\\ \\ / /__  _   _  \\ \\      / (_)_ __  \n"
                    + " \\ V / _ \\| | | |  \\ \\ /\\ / /| | '_ \\ \n"
                    + "  | | (_) | |_| |   \\ V  V / | | | | |\n"
                    + "  |_|\\___/ \\__,_|    \\_/\\_/  |_|_| |_|");
            game = false;
        }
    }

    public static void traps() {
        if (traps[ny][nx]) {
            health -= 5;
            life();
        } else {

        }

    }

    public static void treasureChest() {
        if (treasureChest[ny][nx]) {
            score = +5;
            System.out.println("your score is now " + score);
        }

    }

    public static void enemyZ() {
        if (enemy == true) {
            if (enemyX > nx) {
                map[enemyY][enemyX] = " .";
                enemyX--;
            }
            if (enemyX < nx) {
                map[enemyY][enemyX] = " .";
                enemyX++;
            }
            if (enemyY < ny) {
                map[enemyY][enemyX] = " .";
                enemyY++;
            }
            if (enemyY > ny) {
                map[enemyY][enemyX] = " .";
                enemyY--;
            }
        }
        if (enemyB == true) {
            if (enemyBX > nx) {
                map[enemyBY][enemyBX] = " .";
                enemyBX--;
            }
            if (enemyBX < nx) {
                map[enemyBY][enemyBX] = " .";
                enemyBX++;
            }
            if (enemyBY < ny) {
                map[enemyBY][enemyBX] = " .";
                enemyBY++;
            }
            if (enemyBY > ny) {
                map[enemyBY][enemyBX] = " .";
                enemyBY--;
            }
        }
        if (enemyX == nx && enemyY == ny) {
            System.out.println(" __   __            _                   \n"
                    + " \\ \\ / /__  _   _  | |    ___  ___  ___ \n"
                    + "  \\ V / _ \\| | | | | |   / _ \\/ __|/ _ \\\n"
                    + "   | | (_)  ||_| | | |__| (_) \\__ \\  __/\n"
                    + "   |_|\\___/ \\__,_| |_____\\___/|___/\\___|");
            game = false;
        }

        if (enemyBX == nx && enemyBY == ny) {
            System.out.println(" __   __            _                   \n"
                    + " \\ \\ / /__  _   _  | |    ___  ___  ___ \n"
                    + "  \\ V / _ \\| | | | | |   / _ \\/ __|/ _ \\\n"
                    + "   | | (_)  ||_| | | |__| (_) \\__ \\  __/\n"
                    + "   |_|\\___/ \\__,_| |_____\\___/|___/\\___|");
            game = false;
        }
//        if (enemyX == trapx && enemyY == trapy) {
//            enemy = false;
//
//        }
//        if (enemyBX == trapx && enemyBY == trapy) {
//            enemyB = false;
//        }
//        if (enemy = false) {
//            map[enemyY][enemyX] = "  ";
//        }
//        if (enemyB = false) {
//            map[enemyBY][enemyBX] = "  ";
//        }

    }

    public static void printArray() {

        map[y][x] = " @";
        map[ny][nx] = " @";
        map[enemyY][enemyX] = " X";
        map[enemyBY][enemyBX] = " X";
        for (int i = 0; i <= map[0].length - 1; i++) {
            for (int j = 0; j <= map[1].length - 1; j++) {
                if (j < map[1].length - 1) {
                    if (traps[i][j]) {
                        map[i][j] = " []";
                    }
                    if (treasureChest[i][j]) {
                        map[i][j] = " T";
                    }
                    if (enemyZ[i][j]) {
                        map[i][j] = " X";
                    }
                    if (map[i][j] != " @" && map[i][j] != " []" && map[i][j] != " T" && map[i][j] != " X") {
                        System.out.print("  ");
                    } else {
                        System.out.print(map[i][j]);
                    }
                } else {
                    if (map[i][j] != "  ") {
                        System.out.println("  ");
                    } else {
                        System.out.println(map[i][j]);
                    }
                }

            }
        }
    }
}
