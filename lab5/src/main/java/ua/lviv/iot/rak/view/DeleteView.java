package ua.lviv.iot.rak.view;

import org.hibernate.Session;
import ua.lviv.iot.rak.controller.area.AreaController;
import ua.lviv.iot.rak.controller.irrigationSystem.IrrigationSystemController;
import ua.lviv.iot.rak.controller.motor.MotorController;
import ua.lviv.iot.rak.controller.nozzle.NozzleController;
import ua.lviv.iot.rak.controller.password.PasswordController;
import ua.lviv.iot.rak.controller.pump.PumpController;
import ua.lviv.iot.rak.controller.sensor.SensorController;
import ua.lviv.iot.rak.controller.statisticOfSensor.StatisticOfSensorController;
import ua.lviv.iot.rak.controller.user.UserController;

import java.util.Scanner;

public class DeleteView {

    private Session session;

    public DeleteView(Session session) {
        this.session = session;
    }

    public void show() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter table name:");

        String number = myObj.nextLine();

        /*
         *       AREA
         */
        if (number.equals("area")) {
            AreaController controller = new AreaController(session);

            Scanner row = new Scanner(System.in);
            System.out.println("Enter row id:");
            String id = row.nextLine();
            controller.delete(row.nextInt());

            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
            ;
        }

        /*
         *       IRRIGATION SYSTEM
         */
        if (number.equals("irrigation_system")) {
            IrrigationSystemController controller = new IrrigationSystemController(session);

            Scanner row = new Scanner(System.in);
            System.out.println("Enter row id:");
            String id = row.nextLine();
            int newId = Integer.parseInt(id);
            controller.delete(row.nextInt());

            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }


        /*
         *       MOTOR
         */
        if (number.equals("motor")) {
            MotorController controller = new MotorController(session);

            Scanner row = new Scanner(System.in);
            System.out.println("Enter row id:");
            String id = row.nextLine();
            int newId = Integer.parseInt(id);
            controller.delete(row.nextInt());

            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }

        /*
         *       NOZZLE
         */
        if (number.equals("nozzle")) {
            NozzleController controller = new NozzleController(session);

            Scanner row = new Scanner(System.in);
            System.out.println("Enter row id:");
            String id = row.nextLine();
            int newId = Integer.parseInt(id);
            controller.delete(row.nextInt());

            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }

        /*
         *       PASSWORD
         */
        if (number.equals("password")) {
            PasswordController controller = new PasswordController(session);

            Scanner row = new Scanner(System.in);
            System.out.println("Enter row id:");
            String id = row.nextLine();
            int newId = Integer.parseInt(id);
            controller.delete(row.nextInt());

            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }



        /*
         *       PUMP
         */
        if (number.equals("pump")) {
            PumpController controller = new PumpController(session);

            Scanner row = new Scanner(System.in);
            System.out.println("Enter row id:");
            String id = row.nextLine();
            int newId = Integer.parseInt(id);
            controller.delete(row.nextInt());

            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }


        /*
         *       SENSOR
         */
        if (number.equals("sensor")) {
            SensorController controller = new SensorController(session);

            Scanner row = new Scanner(System.in);
            System.out.println("Enter row id:");
            String id = row.nextLine();
            int newId = Integer.parseInt(id);
            controller.delete(row.nextInt());

            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }


        /*
         *       STATISTIC OF SENSOR
         */
        if (number.equals("statistic_of_sensor")) {
            StatisticOfSensorController controller = new StatisticOfSensorController(session);

            Scanner row = new Scanner(System.in);
            System.out.println("Enter row id:");
            String id = row.nextLine();
            int newId = Integer.parseInt(id);
            controller.delete(row.nextInt());

            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }


        /*
         *       USER
         */
        if (number.equals("user")) {
            UserController controller = new UserController(session);

            Scanner row = new Scanner(System.in);
            System.out.println("Enter row id:");
            String id = row.nextLine();
            int newId = Integer.parseInt(id);
            controller.delete(row.nextInt());

            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        } else {
            System.out.println("Table is not exist");
            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }
    }
}
