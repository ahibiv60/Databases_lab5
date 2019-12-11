package ua.lviv.iot.rak.controller.irrigationSystem;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.lviv.iot.rak.model.IrrigationSystem;
import ua.lviv.iot.rak.persistant.SessionManager;

public class IrrigationSystemController implements IrrigationSystemImpl {
    private Session session;

    public IrrigationSystemController(Session session) {
        this.session = session;
    }

    @Override
    public void read() {
        session = SessionManager.getSession();
        try {
            Query query = session.createQuery("from " + "IrrigationSystem");
            for (Object obj : query.list()) {
                IrrigationSystem item = (IrrigationSystem) obj;

                System.out.format(
                        item.getId().toString() + "    " +
                                item.getStatus() + "    " +
                                item.getTime() + "    " +
                                item.getUserId() + "\n  "
                );

            }
        } finally {
            session.close();
        }
    }


    @Override
    public void create(IrrigationSystem entity) {
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
    public void update(IrrigationSystem entity) {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        IrrigationSystem item = session.get(IrrigationSystem.class, id);
        if (item != null) {
            session.beginTransaction();
            session.delete(item);
            session.getTransaction().commit();
        }
    }
}
