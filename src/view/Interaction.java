package view;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Interaction {

  private static Scanner entree = new Scanner(System.in);

  private static Set<Character> keys = new HashSet<>();

  private Interaction() {
    super();
  }

  public static String lireString() {
    return entree.nextLine();
  }

  public static void resetKeys() {
    keys = new HashSet<>();
  }

  public static void acceptKey(char c) {
    keys.add(Character.valueOf(c));
  }

  public static char readAction() {
    char c;
    boolean out = false;
    do {
      Console.display(" => ");
      c = entree.next(".*").charAt(0);
      for (Character car : keys) {
        if (Character.toUpperCase(car) == Character.toUpperCase(c)) {
          out = true;
        }
      }
    } while (!out);
    entree.nextLine();
    return c;
  }

  public static void pause(int sec) {
    try {
      Thread.sleep((long) (sec * 1000));
    } catch (InterruptedException e) {
      Console.systemeInfoln("Exception");
      Thread.currentThread().interrupt();
    }
  }
}
