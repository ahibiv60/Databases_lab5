package ua.lviv.iot.rak.controller.area;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.lviv.iot.rak.model.Area;
import ua.lviv.iot.rak.persistant.SessionManager;

public class AreaController implements AreaImpl {
    private Session session;

    public AreaController(Session session) {
        this.session = session;
    }

    @Override
    public void read() {
        session = SessionManager.getSession();
        try {
            Query query = session.createQuery("from " + "Area");
            for (Object obj : query.list()) {
                Area item = (Area) obj;

                System.out.format(
                        item.getId().toString() + "    " +
                                item.getLocation() + "    " +
                                item.getIrrigationSystemId() + "\n  "
                );

            }
        } finally {
            session.close();
        }
    }


    @Override
    public void create(Area entity) {
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
    public void update(Area entity) {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        Area item = session.get(Area.class, id);
        if (item != null) {
            session.beginTransaction();
            session.delete(item);
            session.getTransaction().commit();
        }
    }
}
