package ua.lviv.iot.rak.controller.user;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.lviv.iot.rak.model.User;
import ua.lviv.iot.rak.persistant.SessionManager;

public class UserController implements UserImpl {
    private Session session;

    public UserController(Session session) {
        this.session = session;
    }

    @Override
    public void read() {
        session = SessionManager.getSession();
        try {
            Query query = session.createQuery("from " + "Motor");
            for (Object obj : query.list()) {
                User item = (User) obj;

                System.out.format(
                        item.getId().toString() + "    " +
                                item.getName() + "    " +
                                item.getEmail() + "    " +
                                item.getPhone() + "\n  "
                );

            }
        } finally {
            session.close();
        }
    }


    @Override
    public void create(User entity) {
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
    public void update(User entity) {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        User item = session.get(User.class, id);
        if (item != null) {
            session.beginTransaction();
            session.delete(item);
            session.getTransaction().commit();
        }
    }
}
