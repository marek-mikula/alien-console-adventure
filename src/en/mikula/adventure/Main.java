package en.mikula.adventure;

import en.mikula.adventure.base.Game;

import java.io.FileNotFoundException;

/**
 * @author Marek Mikula
 * @version 4/6/2021
 */
public class Main {

    public static void main(String[] args) {
        try {
            new Game(args).start();
        } catch (FileNotFoundException e) {
            System.out.println("The file does not exist!");
        }
    }

}
