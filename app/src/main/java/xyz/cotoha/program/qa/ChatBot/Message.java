package xyz.cotoha.program.qa.ChatBot;

public class Message {
    public enum Sender { USER, BOT }

    private String text;
    private Sender sender;
    private boolean isError;

    public Message(String text, Sender sender, boolean isError) {
        this.text = text;
        this.sender = sender;
        this.isError = isError;
    }

    public String getText() {
        return text;
    }

    public Sender getSender() {
        return sender;
    }

    public boolean isError() {
        return isError;
    }
}
