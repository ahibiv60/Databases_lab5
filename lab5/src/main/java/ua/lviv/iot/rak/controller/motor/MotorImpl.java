package ua.lviv.iot.rak.controller.motor;

import ua.lviv.iot.rak.model.IrrigationSystem;
import ua.lviv.iot.rak.model.Motor;

public interface MotorImpl {
    public void read();
    public void create(Motor entity);
    public void update(Motor entity);
    public void delete(int id);
}
