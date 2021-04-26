package entities;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Project {

    private LocalDate dateEnd;
    private List<Iteration> iterations;
    private List<Student> students;

    public Project(String name, LocalDate dateInit, LocalDate dateEnd, Group group) {
        this.dateEnd = dateEnd;
        this.iterations = new ArrayList<>();

        group.addProject(this);
    }

    public Project(List<Iteration> iterations) {
        this.iterations = iterations;
    }
    public Project(List<Student> students, Group group) {
        this.students = students;
    }


    public void addIteration(Iteration iteration) {
        this.iterations.add(iteration);
    }

    public Duration getDuration() throws SabanaResearchException {

        if (this.iterations.isEmpty())
            throw new SabanaResearchException(SabanaResearchException.BAD_FORMED_PROJECT);

        Duration d = Duration.ZERO;
        for (Iteration i : this.iterations){
            d=d.plus(i.getDuration());
        }
        return d;
    }

    public boolean isActive() {
        boolean isActive;

        if(LocalDate.now().isAfter(this.dateEnd)){
            isActive = false;
        }
        else{
            int openActivities = this.countOpenActivities();
            isActive = openActivities > 0;
        }

        return isActive;
    }


    public int countOpenActivities(){

        return this.iterations
                .stream()
                .map(Iteration::countOpenActivities)
                .reduce(0, Integer::sum);
    }


    public List <String> summarize(ISynthesizer es) throws SabanaResearchException {
            return es.synthezise();
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public List<Iteration> getIterations() {
        return this.iterations;
    }

    public List<Student> getStudents() {
        return students;
    }
}
