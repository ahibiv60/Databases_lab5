package ua.lviv.iot.rak.controller.password;

import ua.lviv.iot.rak.model.Password;

public interface PasswordImpl {
    public void read();
    public void create(Password entity);
    public void update(Password entity);
    public void delete(int id);
}
