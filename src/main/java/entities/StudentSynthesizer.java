package entities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class StudentSynthesizer implements ISynthesizer{

    public List <Student> students;
    public ArrayList<String> resume;

    public StudentSynthesizer(List<Student> students) {
        this.students = students;
    }


    @Override
    public List <String> synthezise() throws SabanaResearchException {

        resume = new ArrayList<>();

        Duration d;
        String n;

        for (Student s : this.students){
            d=s.getActivitiesDuration();
            n=s.getName();
            resume.add("Estudiante: "+n+ ", Duracion: "+ d);

        }

        return resume;

    }
}
