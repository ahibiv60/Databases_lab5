package ua.lviv.iot.rak.controller.sensor;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.lviv.iot.rak.model.Sensor;
import ua.lviv.iot.rak.persistant.SessionManager;

public class SensorController implements SensorImpl {
    private Session session;

    public SensorController(Session session) {
        this.session = session;
    }

    @Override
    public void read() {
        session = SessionManager.getSession();
        try {
            Query query = session.createQuery("from " + "Sensor");
            for (Object obj : query.list()) {
                Sensor item = (Sensor) obj;

                System.out.format(
                        item.getId().toString() + "    " +
                                item.getStatus() + "    " +
                                item.getLocation() + "    " +
                                item.getAreaId() + "\n  "
                );

            }
        } finally {
            session.close();
        }
    }


    @Override
    public void create(Sensor entity) {
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
    public void update(Sensor entity) {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        Sensor item = session.get(Sensor.class, id);
        if (item != null) {
            session.beginTransaction();
            session.delete(item);
            session.getTransaction().commit();
        }
    }
}
