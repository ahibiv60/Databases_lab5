package ua.lviv.iot.rak.controller.area;

import ua.lviv.iot.rak.model.Area;

public interface AreaImpl {
    public void read();
    public void create(Area entity);
    public void update(Area entity);
    public void delete(int id);
}
