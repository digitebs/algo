package oo;

public class Notification {

  class EmailNotification extends Notification {

    public EmailNotification(String receiver) {
      super(receiver);
    }

    @Override
    public String status() {
      return status() + "-email";
    }
  }

  private String receiver;
  private boolean read; // default to false;

  Notification(String receiver) {
    this.receiver = receiver;
  }

  private boolean isRead() {
    return this.read;
  }

  // methods

  public boolean validateReciver() {
    // we can use apache string utils
    return receiver != null && !receiver.equals("");
  }

  public void markAsRead() {
    // not true or not false, make it false hmmm
    this.read = true;
  }

  public String status() {
    return isRead() == true ? "read" : "unread";
  }

  public static void main(String args[]) {
    Notification n = new Notification("jlim");
    System.out.println(n.status());
  }
}
