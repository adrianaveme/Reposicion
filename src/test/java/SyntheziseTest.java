import com.github.javafaker.Faker;
import entities.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SyntheziseTest {

    private static Faker faker;

    SyntheziseTest() {

        faker = new Faker(new Locale("en-US"));
    }

    @Test
    @DisplayName("GIVEN a project with a list of iterations WHEN needed their summary THEN dislpay objective and duration")
    void shouldSyntheziseIterations() throws SabanaResearchException {
        List <Iteration> iterations = new ArrayList<>();
        Project wellFormedProject = new Project(iterations);
        ExecutiveSynthesizer es = new ExecutiveSynthesizer(wellFormedProject);

        Iteration iteration = new Iteration(faker.team().name(), wellFormedProject);
        Iteration iteration2 = new Iteration(faker.team().name(), wellFormedProject);

        iterations.add(iteration);
        iterations.add(iteration2);

        NormalActivity normalActivity = new NormalActivity(faker.team().name(), Activity.ACTIVE_STATE, iteration);
        normalActivity.addStep(new Step(faker.team().name(), Duration.ofDays(1)));

        NormalActivity activity = new NormalActivity(faker.team().name(), Activity.ACTIVE_STATE, iteration2);
        activity.addStep(new Step(faker.team().name(), Duration.ofDays(1)));
        DocumentedActivity documentedActivity = new DocumentedActivity(faker.team().name(), Activity.ACTIVE_STATE, iteration, activity);
        documentedActivity.addQuestion(new Question(Question.EASY_QUESTION, faker.team().name(), Duration.ofDays(1)));

        assertNotNull(wellFormedProject.summarize(es));
    }
    @Test
    @DisplayName("GIVEN a project with iterations without activities WHEN get duration THEN get SabanaResearchException")
    void shouldNotSyntheziseIterations(){
        Group group = new Group(faker.team().name());
        Project wellFormedProject = new Project(faker.team().name(), LocalDate.now().minusDays(10), LocalDate.now().plusDays(10), group);
        Iteration iteration = new Iteration(faker.team().name(), wellFormedProject);
        Iteration iteration2 = new Iteration(faker.team().name(), wellFormedProject);
        List <Iteration> iterations = new ArrayList<>();

        iterations.add(iteration);
        iterations.add(iteration2);
        ExecutiveSynthesizer es = new ExecutiveSynthesizer(wellFormedProject);

        SabanaResearchException exception = assertThrows(SabanaResearchException.class, es::synthezise);
        assertEquals(SabanaResearchException.BAD_FORMED_ITERATION, exception.getMessage());
    }

    @Test
    @DisplayName("GIVEN A list of students WHEN needed a summary THEN display their name and duration")
    void shouldSyntheziseStudents() throws SabanaResearchException {



        List <Activity> assignedActivities = new ArrayList<>();

        Student s1 = new Student("Adriana Velasquez", assignedActivities);
        Student s2 = new Student("Juvenal Urbino", assignedActivities);
        List <Student> students = new ArrayList<>();

        students.add(s1);
        students.add(s2);

        Group group = new Group(faker.team().name());
        Project wellFormedProject = new Project(students, group);
        StudentSynthesizer ss = new StudentSynthesizer(wellFormedProject);

        NormalActivity normalActivity = new NormalActivity(faker.team().name(), Activity.ACTIVE_STATE, null);
        normalActivity.addStep(new Step(faker.team().name(), Duration.ofDays(1)));

        NormalActivity activity = new NormalActivity(faker.team().name(), Activity.ACTIVE_STATE, null);
        activity.addStep(new Step(faker.team().name(), Duration.ofDays(1)));
        DocumentedActivity documentedActivity = new DocumentedActivity(faker.team().name(), Activity.ACTIVE_STATE, null, activity);
        documentedActivity.addQuestion(new Question(Question.EASY_QUESTION, faker.team().name(), Duration.ofDays(1)));

        assignedActivities.add(normalActivity);
        assignedActivities.add(documentedActivity);

        assertNotNull(wellFormedProject.summarize(ss));
    }

    @Test
    @DisplayName("GIVEN A student without assignedActivities WHEN needed a summary THEN Get Sabana Reseaarch Exception")
    void shouldNotSyntheziseStudents() {

        List <Activity> assignedActivities = new ArrayList<>();

        Student s1 = new Student("Adriana Velasquez", assignedActivities);
        Student s2 = new Student("Juvenal Urbino", assignedActivities);
        List <Student> students = new ArrayList<>();

        students.add(s1);
        students.add(s2);
        Group group = new Group(faker.team().name());
        Project project = new Project(students, group);

        StudentSynthesizer ss = new StudentSynthesizer(project);

        SabanaResearchException exception = assertThrows(SabanaResearchException.class, ss::synthezise);
        assertEquals(SabanaResearchException.BAD_FORMED_STUDENT, exception.getMessage());
    }
}



