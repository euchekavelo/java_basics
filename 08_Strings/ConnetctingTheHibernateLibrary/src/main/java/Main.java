import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try (SessionFactory sessionFactory = HibernatePlugin.getSessionFactory();
             Session session = sessionFactory.openSession()){
            System.out.println("Введите ID курса:");
            int valueId = Integer.parseInt(scanner.nextLine());

            Course course = session.get(Course.class, valueId);
            String output = course.getName() + " - " + course.getStudentsCount() + " студ.";
            System.out.println(output);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("Работа программы завершена.");
    }

}
