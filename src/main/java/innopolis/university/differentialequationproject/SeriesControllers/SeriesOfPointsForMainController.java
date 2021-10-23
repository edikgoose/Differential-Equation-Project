package innopolis.university.differentialequationproject.SeriesControllers;

import innopolis.university.differentialequationproject.InitialValueProblem;
import innopolis.university.differentialequationproject.SolutionMethodsClasses.Solution;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SeriesOfPointsForMainController extends SeriesOfPointsController{
    private final Solution solution;

    public SeriesOfPointsForMainController(Solution solution, String name) {
        super(name);
        this.solution = solution;
    }

    @Override
    public void update(InitialValueProblem initialValueProblem, int numberOfPoints, double maxX, int maxN) throws IllegalArgumentException {
        double step =  ((maxX - initialValueProblem.getX0())/numberOfPoints);
        if(numberOfPoints <= 0){
            throw new IllegalArgumentException("N must be positive");
        }
        if(step <= 0){
            throw new IllegalArgumentException("X_MAX cannot be less than X_0");
        }


        ObservableList<Number> listOfNewSteps = FXCollections.observableArrayList();
        for(double x = initialValueProblem.getX0(); x < maxX; x+=step){
            listOfNewSteps.add(x);
        }


        super.seriesOfPoints.setData(solution.solutionFunc(listOfNewSteps, initialValueProblem));
    }
}
