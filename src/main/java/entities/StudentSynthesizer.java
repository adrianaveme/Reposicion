package entities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class StudentSynthesizer implements ISynthesizer{

    public List <Student> students;
    public ArrayList<String> resume;
    private final Project project;

    public StudentSynthesizer(Project project) {
        this.project = project;
    }


    @Override
    public List <String> synthezise() throws SabanaResearchException {

        resume = new ArrayList<>();

        Duration d;
        String n;

        if (project.getStudents().isEmpty())
            throw new SabanaResearchException(SabanaResearchException.BAD_FORMED_SPROJECT);

        for (Student s : project.getStudents()){
            d=s.getActivitiesDuration();
            n=s.getName();
            resume.add("Estudiante: "+n+ ", Duracion: "+ d);

        }

        for (String r : resume){
            System.out.println(r);
        }

        return resume;

    }
}
