package ua.lviv.iot.rak.controller.statisticOfSensor;

import ua.lviv.iot.rak.model.StatisticOfSensor;

public interface StatisticOfSensorImpl {
    public void read();
    public void create(StatisticOfSensor entity);
    public void update(StatisticOfSensor entity);
    public void delete(int id);
}
