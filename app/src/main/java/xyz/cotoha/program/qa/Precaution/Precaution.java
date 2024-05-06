package xyz.cotoha.program.qa.Precaution;

public class Precaution {
    private String question;
    private String answer;

    public Precaution(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}