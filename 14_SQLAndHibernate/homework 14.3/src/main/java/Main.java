import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernatePlugin.getSessionFactory();
             Session session = sessionFactory.openSession()) {

            Transaction transaction = session.beginTransaction();

            String hqlGetSampleFromPurchaseList = "From " + PurchaseList.class.getSimpleName();
            Query query = session.createQuery(hqlGetSampleFromPurchaseList);
            List<PurchaseList> purchaseLists = query.getResultList();

            purchaseLists.forEach(purchaseList -> {
                String studentName = purchaseList.getStudentName();
                String courseName = purchaseList.getCourseName();

                String hqlGetSampleFromStudents = "From " + Student.class.getSimpleName()
                                                            + " Where name = '" + studentName + "'";
                Student student = (Student) session.createQuery(hqlGetSampleFromStudents).getSingleResult();

                String hqlGetSampleFromCourses = "From " + Course.class.getSimpleName()
                                                            + " Where name = '" + courseName + "'";
                Course course = (Course) session.createQuery(hqlGetSampleFromCourses).getSingleResult();

                LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();
                linkedPurchaseList.setKey(new CompositeKey(student.getId(), course.getId()));
                session.save(linkedPurchaseList);
            });

            transaction.commit();
            System.out.println("Таблица \"" + LinkedPurchaseList.class.getName() + "\" успешно сформирована в БД.");

        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
