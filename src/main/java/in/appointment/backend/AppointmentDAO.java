package in.appointment.backend;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class AppointmentDAO {
    public void addAppointment(Appointment appointment) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(appointment);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<Appointment> listAppointments() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Appointment", Appointment.class).list();
        }
    }

    public void deleteAppointment(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Appointment appointment = session.get(Appointment.class, id);
            if (appointment != null) {
                session.delete(appointment);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
