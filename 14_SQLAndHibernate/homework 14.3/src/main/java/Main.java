import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernatePlugin.getSessionFactory();
             Session session = sessionFactory.openSession()) {

            Transaction transaction = session.beginTransaction();

            //Получим дату некоторой подписки.
            System.out.println("\nДата некоторой подписки:");
            Subscription subscription = session.get(Subscription.class, new CompositeKey(1, 2));
            System.out.println(subscription.getSubscriptionDate());

            //Выведем некоторую информацию об имеющихся подписках (ид студента, дата подписки) на курс с ID = 45.
            System.out.println("\nНекоторая информация о подписках по определенному курсу:");
            Course course = session.get(Course.class, 45);
            List<Subscription> subscriptionList = course.getSubscriptionList();
            subscriptionList.forEach(eachSubscription -> System.out.println(eachSubscription.getStudent().getId()
                    + " " + eachSubscription.getSubscriptionDate()));

            //Получим наименования курсов, а также их ID у некоторого студента c ID = 46.
            Student student = session.get(Student.class, 46);
            List<Course> courseList = student.getCourseList();
            System.out.println("\nСписок курсов у некоторого студента:");
            courseList.forEach(eachCourse -> System.out.println(eachCourse.getName() + " - ID: " + eachCourse.getId()));
            System.out.println();

            //Получим количество курсов, которые ведет учитель с ID = 20
            System.out.println("\nКоличетсво курсов, которые ведет учитель:");
            Teacher teacher = session.get(Teacher.class, 20);
            List<Course> courseListFromTheTeacher = teacher.getCourseList();
            System.out.println(courseListFromTheTeacher.size() + "\n");

            transaction.commit();

        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
