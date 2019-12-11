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
import ua.lviv.iot.rak.model.*;

import java.util.Scanner;

public class UpdateView {

    private Session session;

    public UpdateView(Session session) {
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
            Area entity = new Area();

            Scanner myObj1 = new Scanner(System.in);
            System.out.println("Enter id:");
            entity.setId(myObj1.nextInt());

            Scanner myObj2 = new Scanner(System.in);
            System.out.println("Enter location:");
            entity.setLocation(myObj2.nextLine());

            Scanner myObj3 = new Scanner(System.in);
            System.out.println("Enter irrigation system id:");
            entity.setIrrigationSystemId(myObj3.nextInt());
            //--
            controller.update(entity);
            //--
            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }

        /*
         *       IRRIGATION SYSTEM
         */
        if (number.equals("irrigation_system")) {

            IrrigationSystemController controller = new IrrigationSystemController(session);
            IrrigationSystem entity = new IrrigationSystem();

            Scanner myObj1 = new Scanner(System.in);
            System.out.println("Enter id:");
            entity.setId(myObj1.nextInt());

            Scanner myObj2 = new Scanner(System.in);
            System.out.println("Enter status:");
            entity.setStatus(myObj2.nextLine());

            Scanner myObj3 = new Scanner(System.in);
            System.out.println("Enter time:");
            entity.setTime(myObj3.nextLine());

            Scanner myObj4 = new Scanner(System.in);
            System.out.println("Enter user id:");
            entity.setUserId(myObj4.nextInt());
            //--
            controller.update(entity);
            //--
            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }


        /*
         *       MOTOR
         */
        if (number.equals("motor")) {

            MotorController controller = new MotorController(session);
            Motor entity = new Motor();

            Scanner myObj1 = new Scanner(System.in);
            System.out.println("Enter id:");
            entity.setId(myObj1.nextInt());

            Scanner myObj2 = new Scanner(System.in);
            System.out.println("Enter status:");
            entity.setStatus(myObj2.nextLine());

            Scanner myObj3 = new Scanner(System.in);
            System.out.println("Enter time:");
            entity.setTime(myObj3.nextLine());

            Scanner myObj4 = new Scanner(System.in);
            System.out.println("Enter pump id:");
            entity.setPumpId(myObj4.nextInt());
            //--
            controller.update(entity);
            //--
            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }

        /*
         *       NOZZLE
         */
        if (number.equals("nozzle")) {

            NozzleController controller = new NozzleController(session);
            Nozzle entity = new Nozzle();

            Scanner myObj1 = new Scanner(System.in);
            System.out.println("Enter id:");
            entity.setId(myObj1.nextInt());

            Scanner myObj2 = new Scanner(System.in);
            System.out.println("Enter status:");
            entity.setStatus(myObj2.nextLine());

            Scanner myObj3 = new Scanner(System.in);
            System.out.println("Enter location:");
            entity.setLocation(myObj3.nextLine());

            Scanner myObj4 = new Scanner(System.in);
            System.out.println("Enter max water consumption:");
            entity.setMaxWaterConsumption(myObj4.nextInt());

            Scanner myObj5 = new Scanner(System.in);
            System.out.println("Enter area id:");
            entity.setAreaId(myObj5.nextInt());
            //--
            controller.update(entity);
            //--
            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }

        /*
         *       PASSWORD
         */
        if (number.equals("password")) {

            PasswordController controller = new PasswordController(session);
            Password entity = new Password();

            Scanner myObj1 = new Scanner(System.in);
            System.out.println("Enter id:");
            entity.setId(myObj1.nextInt());

            Scanner myObj2 = new Scanner(System.in);
            System.out.println("Enter password:");
            entity.setPassword(myObj2.nextLine());

            Scanner myObj3 = new Scanner(System.in);
            System.out.println("Enter user id:");
            entity.setUserId(myObj3.nextInt());
            //--
            controller.update(entity);
            //--
            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }



        /*
         *       PUMP
         */
        if (number.equals("pump")) {

            PumpController controller = new PumpController(session);
            Pump entity = new Pump();

            Scanner myObj1 = new Scanner(System.in);
            System.out.println("Enter id:");
            entity.setId(myObj1.nextInt());

            Scanner myObj2 = new Scanner(System.in);
            System.out.println("Enter status:");
            entity.setStatus(myObj2.nextLine());

            Scanner myObj3 = new Scanner(System.in);
            System.out.println("Enter amount of pumped water:");
            entity.setAmountOfPumpedWater(myObj3.nextInt());

            Scanner myObj4 = new Scanner(System.in);
            System.out.println("Enter area id:");
            entity.setAreaId(myObj4.nextInt());
            //--
            controller.update(entity);
            //--
            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }


        /*
         *       SENSOR
         */
        if (number.equals("sensor")) {

            SensorController controller = new SensorController(session);
            Sensor entity = new Sensor();

            Scanner myObj1 = new Scanner(System.in);
            System.out.println("Enter id:");
            entity.setId(myObj1.nextInt());

            Scanner myObj2 = new Scanner(System.in);
            System.out.println("Enter status:");
            entity.setStatus(myObj2.nextLine());

            Scanner myObj3 = new Scanner(System.in);
            System.out.println("Enter location:");
            entity.setLocation(myObj3.nextLine());

            Scanner myObj4 = new Scanner(System.in);
            System.out.println("Enter area id:");
            entity.setAreaId(myObj4.nextInt());
            //--
            controller.update(entity);
            //--
            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }


        /*
         *       STATISTIC OF SENSOR
         */
        if (number.equals("statistic_of_sensor")) {

            StatisticOfSensorController controller = new StatisticOfSensorController(session);
            StatisticOfSensor entity = new StatisticOfSensor();

            Scanner myObj1 = new Scanner(System.in);
            System.out.println("Enter id:");
            entity.setId(myObj1.nextInt());

            Scanner myObj2 = new Scanner(System.in);
            System.out.println("Enter time:");
            entity.setTime(myObj2.nextLine());

            Scanner myObj3 = new Scanner(System.in);
            System.out.println("Enter temperature:");
            entity.setTemperature(myObj3.nextLine());

            Scanner myObj4 = new Scanner(System.in);
            System.out.println("Enter lighting id:");
            entity.setLighting(myObj4.nextLine());

            Scanner myObj5 = new Scanner(System.in);
            System.out.println("Enter humidity:");
            entity.setHumidity(myObj5.nextLine());

            Scanner myObj6 = new Scanner(System.in);
            System.out.println("Enter sensor id:");
            entity.setSensorId(myObj6.nextInt());
            //--
            controller.update(entity);
            //--
            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }


        /*
         *       USER
         */
        if (number.equals("user")) {

            UserController controller = new UserController(session);
            User entity = new User();

            Scanner myObj1 = new Scanner(System.in);
            System.out.println("Enter id:");
            entity.setId(myObj1.nextInt());

            Scanner myObj2 = new Scanner(System.in);
            System.out.println("Enter name:");
            entity.setName(myObj2.nextLine());

            Scanner myObj0 = new Scanner(System.in);
            System.out.println("Enter email:");
            entity.setEmail(myObj0.nextLine());

            Scanner myObj3 = new Scanner(System.in);
            System.out.println("Enter phone:");
            entity.setPhone(myObj3.nextLine());
            //--
            controller.update(entity);
            //--
            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }
        else {
            System.out.println("Table is not exist");
            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }
    }
}
