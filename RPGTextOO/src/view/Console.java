package view;

public class Console {

  private Console() {
    super();
  }

  public static void systemeInfo(String s) {
    System.out.print(">>>\t" + s + "\n");
  }

  public static void systemeInfoln(String s) {
    systemeInfo(s + "\n");
  }

  public static void display(String s) {
    System.out.println(s);
    Interaction.pause(1);
  }

  public static void displayln(String s) {
    display("\n" + s);
  }
}
