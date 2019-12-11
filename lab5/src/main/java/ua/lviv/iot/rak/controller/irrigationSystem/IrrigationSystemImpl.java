package ua.lviv.iot.rak.controller.irrigationSystem;

import ua.lviv.iot.rak.model.IrrigationSystem;

public interface IrrigationSystemImpl {
    public void read();
    public void create(IrrigationSystem entity);
    public void update(IrrigationSystem entity);
    public void delete(int id);
}
