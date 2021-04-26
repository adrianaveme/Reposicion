package entities;

import java.time.Duration;
import java.util.List;

public class Student {
    private final String name;
    private final List <Activity> assignedActivities;

    public Student(String name, List<Activity> assignedActivities) {
        this.name = name;
        this.assignedActivities = assignedActivities;
    }

    public Duration getActivitiesDuration() throws SabanaResearchException {

        Duration d = Duration.ZERO;

        if (this.assignedActivities.isEmpty())
            throw new SabanaResearchException(SabanaResearchException.BAD_FORMED_STUDENT);

        for (Activity a: assignedActivities){
            d = d.plus(a.getDuration());
        }

        return d;
    }

    public String getName() {
        return this.name;
    }
}
