
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.mycompany.hibernatedemo.entity.Student;
import java.util.List;
import org.hibernate.Session;

public class Driver {
    public static void main(String[] args) {
        System.out.println("inside main");
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        System.out.println("after session factory");
        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();
            System.out.println("trnsaction begin");
           List<Student>  students = session.createQuery("from Student").list();
            session.getTransaction().commit();
            System.out.println("commit successfully");
            for(Student student: students){
                System.out.println("name : "+student.getName());
                System.out.println("email : "+student.getEmail());
                System.out.println("enrollment" + student.getEnrollment()  );
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            
        }
    }
}
