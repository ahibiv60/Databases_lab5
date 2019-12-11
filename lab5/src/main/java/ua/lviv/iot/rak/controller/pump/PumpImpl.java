package ua.lviv.iot.rak.controller.pump;

import ua.lviv.iot.rak.model.Pump;

public interface PumpImpl {
    public void read();
    public void create(Pump entity);
    public void update(Pump entity);
    public void delete(int id);
}
