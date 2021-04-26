package entities;

public class SabanaResearchException extends Exception {

    public static final String BAD_FORMED_PROJECT = "The project is bad formed, it hasn't iterations.";
    static final String BAD_FORMED_SPROJECT = "The project is bad formed, it doesnt have students.";
    public static final String BAD_FORMED_ITERATION = "The iteration is bad formed, it hasn't activities.";
    public static final String BAD_FORMED_NORMAL_ACTIVITY = "The normal activity is bad formed, it hasn't steps.";
    public static final String BAD_FORMED_DOCUMENTED_ACTIVITY = "The documented activity is bad formed, it hasn't questions.";
    public static final String BAD_FORMED_DOCUMENTED_ACTIVITY_WITHOUT_NORMAL_QUESTION = "The documented activity is bad formed, it hasn't normal activity associated.";
    public static final String BAD_FORMED_STUDENT = "The student, doesnt have assignedActivities.";

    public SabanaResearchException(String message) {
        super(message);
    }
}
