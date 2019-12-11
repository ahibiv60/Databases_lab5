package ua.lviv.iot.rak.controller.motor;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.lviv.iot.rak.model.Motor;
import ua.lviv.iot.rak.persistant.SessionManager;

public class MotorController implements MotorImpl {
    private Session session;

    public MotorController(Session session) {
        this.session = session;
    }

    @Override
    public void read() {
        session = SessionManager.getSession();
        try {
            Query query = session.createQuery("from " + "Motor");
            for (Object obj : query.list()) {
                Motor item = (Motor) obj;

                System.out.format(
                        item.getId().toString() + "    " +
                                item.getTime() + "    " +
                                item.getPumpId() + "\n  "
                );

            }
        } finally {
            session.close();
        }
    }


    @Override
    public void create(Motor entity) {
        session = ua.lviv.iot.rak.persistant.SessionManager.getSession();
        try {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
            System.out.println(".saved");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Motor entity) {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        Motor item = session.get(Motor.class, id);
        if (item != null) {
            session.beginTransaction();
            session.delete(item);
            session.getTransaction().commit();
        }
    }
}
