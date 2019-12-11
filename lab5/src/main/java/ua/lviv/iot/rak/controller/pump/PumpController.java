package ua.lviv.iot.rak.controller.pump;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.lviv.iot.rak.model.Pump;
import ua.lviv.iot.rak.persistant.SessionManager;

public class PumpController implements PumpImpl {
    private Session session;

    public PumpController(Session session) {
        this.session = session;
    }

    @Override
    public void read() {
        session = SessionManager.getSession();
        try {
            Query query = session.createQuery("from " + "Pump");
            for (Object obj : query.list()) {
                Pump item = (Pump) obj;

                System.out.format(
                        item.getId().toString() + "    " +
                                item.getStatus() + "    " +
                                item.getAmountOfPumpedWater() + "    " +
                                item.getAreaId() + "\n  "
                );

            }
        } finally {
            session.close();
        }
    }


    @Override
    public void create(Pump entity) {
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
    public void update(Pump entity) {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        Pump item = session.get(Pump.class, id);
        if (item != null) {
            session.beginTransaction();
            session.delete(item);
            session.getTransaction().commit();
        }
    }
}
