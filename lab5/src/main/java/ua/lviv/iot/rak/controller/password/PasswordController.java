package ua.lviv.iot.rak.controller.password;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.lviv.iot.rak.model.Password;
import ua.lviv.iot.rak.persistant.SessionManager;

public class PasswordController implements PasswordImpl {
    private Session session;

    public PasswordController(Session session) {
        this.session = session;
    }

    @Override
    public void read() {
        session = SessionManager.getSession();
        try {
            Query query = session.createQuery("from " + "Password");
            for (Object obj : query.list()) {
                Password item = (Password) obj;

                System.out.format(
                        item.getId().toString() + "    " +
                        item.getPassword() + "    " +
                        item.getUserId() + "\n  "
                );

            }
        } finally {
            session.close();
        }
    }


    @Override
    public void create(Password entity) {
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
    public void update(Password entity) {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        Password item = session.get(Password.class, id);
        if (item != null) {
            session.beginTransaction();
            session.delete(item);
            session.getTransaction().commit();
        }
    }
}
