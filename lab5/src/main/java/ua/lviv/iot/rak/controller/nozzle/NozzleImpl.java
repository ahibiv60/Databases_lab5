package ua.lviv.iot.rak.controller.nozzle;

import ua.lviv.iot.rak.model.IrrigationSystem;
import ua.lviv.iot.rak.model.Nozzle;

public interface NozzleImpl {
    public void read();
    public void create(Nozzle entity);
    public void update(Nozzle entity);
    public void delete(int id);
}
