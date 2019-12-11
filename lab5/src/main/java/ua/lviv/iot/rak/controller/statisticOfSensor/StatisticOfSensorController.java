package ua.lviv.iot.rak.controller.statisticOfSensor;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.lviv.iot.rak.model.StatisticOfSensor;
import ua.lviv.iot.rak.persistant.SessionManager;

public class StatisticOfSensorController implements StatisticOfSensorImpl {
    private Session session;

    public StatisticOfSensorController(Session session) {
        this.session = session;
    }

    @Override
    public void read() {
        session = SessionManager.getSession();
        try {
            Query query = session.createQuery("from " + "StatisticOfSensor");
            for (Object obj : query.list()) {
                StatisticOfSensor item = (StatisticOfSensor) obj;

                System.out.format(
                        item.getId().toString() + "    " +
                                item.getTime() + "    " +
                                item.getTemperature() + "    " +
                                item.getLighting() + "    " +
                                item.getHumidity() + "    " +
                                item.getSensorId() + "\n  "
                );

            }
        } finally {
            session.close();
        }
    }


    @Override
    public void create(StatisticOfSensor entity) {
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
    public void update(StatisticOfSensor entity) {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        StatisticOfSensor item = session.get(StatisticOfSensor.class, id);
        if (item != null) {
            session.beginTransaction();
            session.delete(item);
            session.getTransaction().commit();
        }
    }
}
