package ua.lviv.iot.rak.controller.sensor;

import ua.lviv.iot.rak.model.Sensor;

public interface SensorImpl {
    public void read();
    public void create(Sensor entity);
    public void update(Sensor entity);
    public void delete(int id);
}
