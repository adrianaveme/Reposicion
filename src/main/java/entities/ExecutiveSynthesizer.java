package entities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ExecutiveSynthesizer implements ISynthesizer{

    private final Project project;

    public ExecutiveSynthesizer(Project project) {
        this.project = project;
    }

    @Override
    public List <String> synthezise() throws SabanaResearchException {

        String obj;

        List<String> resume = new ArrayList<>();

        if (project.getIterations().isEmpty())
            throw new SabanaResearchException(SabanaResearchException.BAD_FORMED_PROJECT);

        Duration d;

        for (Iteration i : project.getIterations()){

            d=i.getDuration();
            obj = i.getObjective();
            resume.add("Objetivo: "+obj+ ". Duracion: "+d);
        }

        for (String r : resume){
            System.out.print(r);
        }

        return resume;

    }
}
