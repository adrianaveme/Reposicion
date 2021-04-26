package entities;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private final List<Project> projects;

    public Group(String name) {
        this.projects = new ArrayList<>();
    }

    public void addProject(Project plan) {
        this.projects.add(plan);
    }

    public int countActiveProjects() {
        return(int) this.projects.stream().map(Project::isActive).filter(b -> b).count();
    }

}
