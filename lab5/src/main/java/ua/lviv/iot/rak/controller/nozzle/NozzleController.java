package ua.lviv.iot.rak.controller.nozzle;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.lviv.iot.rak.model.Nozzle;
import ua.lviv.iot.rak.persistant.SessionManager;

public class NozzleController implements NozzleImpl {
    private Session session;

    public NozzleController(Session session) {
        this.session = session;
    }

    @Override
    public void read() {
        session = SessionManager.getSession();
        try {
            Query query = session.createQuery("from " + "Nozzle");
            for (Object obj : query.list()) {
                Nozzle item = (Nozzle) obj;

                System.out.format(
                        item.getId().toString() + "    " +
                                item.getStatus() + "    " +
                                item.getLocation() + "    " +
                                item.getMaxWaterConsumption() + "    " +
                                item.getAreaId() + "\n  "
                );

            }
        } finally {
            session.close();
        }
    }


    @Override
    public void create(Nozzle entity) {
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
    public void update(Nozzle entity) {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        Nozzle item = session.get(Nozzle.class, id);
        if (item != null) {
            session.beginTransaction();
            session.delete(item);
            session.getTransaction().commit();
        }
    }
}
