package ua.lviv.iot.rak.view;

import org.hibernate.Session;

import java.util.Scanner;

public class MainView {

    private Session session;

    public MainView(Session session) {
        this.session = session;
    }

    public void show() {
        System.out.println("==================================================");
        System.out.println("=                                                =");
        System.out.println("=                Irrigation System               =");
        System.out.println("=                                                =");
        System.out.println("==================================================");


        System.out.println("[ 1 ] open menu");
        System.out.println("[ 2 ] out");

        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter 1/2");

        String number = myObj.nextLine();

        if (number.equals("1")) {
            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }

        if (number.equals("2")) {
            Out outer = new Out();
            outer.show();
        }

        else {
            System.out.println("Pl, enter 1 or 2");
        }
    }
}
