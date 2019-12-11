import org.hibernate.Session;
import ua.lviv.iot.rak.persistant.SessionManager;
import ua.lviv.iot.rak.view.MainView;

public class Main {
    public static void main(final String[] args) {
        try (Session session = SessionManager.getSession()) {
            new MainView(session).show();
        }
    }
}