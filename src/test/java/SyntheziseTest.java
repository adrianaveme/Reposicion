import com.github.javafaker.Faker;
import entities.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SyntheziseTest {

    private static Faker faker;

    public SyntheziseTest() {

        faker = new Faker(new Locale("en-US"));
    }

    @BeforeEach
    public void setup() throws SabanaResearchException{
        Group group = new Group(faker.team().name());
        Project wellFormedProject = new Project(faker.team().name(), LocalDate.now().minusDays(10), LocalDate.now().plusDays(10), group);
        Iteration iteration = new Iteration(faker.team().name(), wellFormedProject);
        List <Iteration> iterations = new ArrayList<>();

        iterations.add(iteration);
        ExecutiveSynthesizer es = new ExecutiveSynthesizer(iterations);

        NormalActivity normalActivity = new NormalActivity(faker.team().name(), Activity.ACTIVE_STATE, iteration);
        normalActivity.addStep(new Step(faker.team().name(), Duration.ofDays(1)));

        NormalActivity activity = new NormalActivity(faker.team().name(), Activity.ACTIVE_STATE, null);
        activity.addStep(new Step(faker.team().name(), Duration.ofDays(1)));
        DocumentedActivity documentedActivity = new DocumentedActivity(faker.team().name(), Activity.ACTIVE_STATE, iteration, activity);
        documentedActivity.addQuestion(new Question(Question.EASY_QUESTION, faker.team().name(), Duration.ofDays(1)));
    }

    @Test
    @DisplayName("GIVEN sabana research WHEN open an iteration THEN Count open activities")
    public void shouldSyntheziseIterations() throws SabanaResearchException {
        Group group = new Group(faker.team().name());
        Project wellFormedProject = new Project(faker.team().name(), LocalDate.now().minusDays(10), LocalDate.now().plusDays(10), group);
        Iteration iteration = new Iteration(faker.team().name(), wellFormedProject);
        Iteration iteration2 = new Iteration(faker.team().name(), wellFormedProject);
        List <Iteration> iterations = new ArrayList<>();

        iterations.add(iteration);
        iterations.add(iteration2);
        ExecutiveSynthesizer es = new ExecutiveSynthesizer(iterations);

        NormalActivity normalActivity = new NormalActivity(faker.team().name(), Activity.ACTIVE_STATE, iteration);
        normalActivity.addStep(new Step(faker.team().name(), Duration.ofDays(1)));

        NormalActivity activity = new NormalActivity(faker.team().name(), Activity.ACTIVE_STATE, iteration2);
        activity.addStep(new Step(faker.team().name(), Duration.ofDays(1)));
        DocumentedActivity documentedActivity = new DocumentedActivity(faker.team().name(), Activity.ACTIVE_STATE, iteration, activity);
        documentedActivity.addQuestion(new Question(Question.EASY_QUESTION, faker.team().name(), Duration.ofDays(1)));

        assertNotNull(es.synthezise());
        System.out.print(es.synthezise());
    }

    @Test
    @DisplayName("GIVEN sabana research WHEN open an iteration THEN Count open activities")
    public void shouldSyntheziseStudents() throws SabanaResearchException {

        List <Activity> assignedActivities = new ArrayList<>();

        Student s1 = new Student("Adriana Velásquez", assignedActivities);
        Student s2 = new Student("Juvenal Urbino", assignedActivities);
        List <Student> students = new ArrayList<>();

        students.add(s1);
        students.add(s2);
        StudentSynthesizer ss = new StudentSynthesizer(students);

        NormalActivity normalActivity = new NormalActivity(faker.team().name(), Activity.ACTIVE_STATE, null);
        normalActivity.addStep(new Step(faker.team().name(), Duration.ofDays(1)));

        NormalActivity activity = new NormalActivity(faker.team().name(), Activity.ACTIVE_STATE, null);
        activity.addStep(new Step(faker.team().name(), Duration.ofDays(1)));
        DocumentedActivity documentedActivity = new DocumentedActivity(faker.team().name(), Activity.ACTIVE_STATE, null, activity);
        documentedActivity.addQuestion(new Question(Question.EASY_QUESTION, faker.team().name(), Duration.ofDays(1)));

        assignedActivities.add(normalActivity);
        assignedActivities.add(documentedActivity);

        assertNotNull(ss.synthezise());
        System.out.print(ss.synthezise());
    }
}



