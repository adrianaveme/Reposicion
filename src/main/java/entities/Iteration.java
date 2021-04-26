package entities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Iteration {

    private final String objective;
    private final List<Activity> activities;

    public Iteration(String objective, Project project) {
        this.objective = objective;
        this.activities = new ArrayList<>();

        project.addIteration(this);
    }

    public void addActivity(Activity activity) {
        this.activities.add(activity);
    }

    public int countOpenActivities() {
        int count =0;

        for(Activity a: this.activities){
            if(a.isActive()){
                count++;
            }
        }

        return (int) this.activities.stream()
                .map(Activity::isActive)
                .filter(b -> b)
                .count();
    }

    public int countClosedActivities() {

        for(Activity a: this.activities){
            a.isActive();
        }
        return (int) this.activities.stream()
                .map(Activity::isClosed)
                .filter(b -> b)
                .count();
    }

    public Duration getDuration() throws SabanaResearchException {

        Duration d = Duration.ZERO;
        if (this.activities.isEmpty())
            throw new SabanaResearchException(SabanaResearchException.BAD_FORMED_ITERATION);

        for (Activity a : this.activities){
            d=d.plus(a.getDuration());
        }

        return d;
    }

    public String getObjective() {
        return this.objective;
    }
}
