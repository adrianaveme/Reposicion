package entities;

import java.time.Duration;

public class Question {

    public static final String HARD_QUESTION = "HARD";
    public static final String EASY_QUESTION = "EASY";

    private final Duration dedication;

    public Question(String difficulty, String description, Duration dedication) {
        this.dedication = dedication;
    }

    public Duration getDedication() {
        return dedication;
    }
}
