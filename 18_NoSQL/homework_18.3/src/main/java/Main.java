import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        MongoStorage mongoStorage = new MongoStorage();
        mongoStorage.init();

        FileParse fileParse = new FileParse();
        List<String[]> listOfArraysOfStrings = fileParse.getListOfArraysOfStrings();
        listOfArraysOfStrings.forEach(array -> {
            List<String> courseList = new ArrayList<>(Arrays.asList(array).subList(2, array.length));
            mongoStorage.addANewCollectionDocument(array[0], array[1], courseList);
        });

        System.out.println("Общее количество студентов: " + mongoStorage.getTheTotalNumberOfStudentsInTheDatabase()
                + "\nКоличество студентов старше 40 лет: " + mongoStorage.getTheNumberOfStudentsOverFortyYearsOld() +
                    "\nИмя самого молодого студента: " + mongoStorage.getTheNameOfTheYoungestStudent() +
                "\nСписок курсов самого старого студента: " + mongoStorage.getTheListOfCoursesOfTheOldestStudent());

        //После получения данных почистим коллекцию и закроем клиент.
        mongoStorage.collectionDrop();
        mongoStorage.clientClose();
    }

}
