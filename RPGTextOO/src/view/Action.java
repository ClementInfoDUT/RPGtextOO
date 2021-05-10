package view;

public class Action {

  private char charToRead;
  private String message;
  private PossibleAction actionToDo;

  public Action(char charToRead, String message, PossibleAction action) {
    super();
    this.charToRead = charToRead;
    this.message = message;
    this.actionToDo = action;
  }

  public char getCharToRead() {
    return charToRead;
  }

  public String getMessage() {
    return message;
  }

  public PossibleAction getAction() {
    return actionToDo;
  }

}
