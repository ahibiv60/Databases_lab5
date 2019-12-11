package ua.lviv.iot.rak.controller.user;

import ua.lviv.iot.rak.model.User;

public interface UserImpl {
    public void read();
    public void create(User entity);
    public void update(User entity);
    public void delete(int id);
}
