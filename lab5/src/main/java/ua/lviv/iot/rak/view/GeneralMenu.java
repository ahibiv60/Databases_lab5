package ua.lviv.iot.rak.view;

import org.hibernate.Session;

import java.util.Scanner;

public class GeneralMenu {
    private Session session;

    public GeneralMenu(Session session) {
        this.session = session;
    }

    public void show() {
        System.out.println("\n\n");
        System.out.println("[ 1 ] show table");
        System.out.println("[ 2 ] add row");
        System.out.println("[ 3 ] update row");
        System.out.println("[ 4 ] delete row");
        System.out.println("[ 0 ] << back");

        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter number");

        String number = myObj.nextLine();

        if (number.equals("1")){
            OneTableView oneTable = new OneTableView(session);
            oneTable.show();
        }
        if (number.equals("2")){
            AddView addView = new AddView(session);
            addView.show();
        }
        if (number.equals("3")){
            UpdateView updateView = new UpdateView(session);
            updateView.show();
        }
        if (number.equals("4")){
            DeleteView deleteView = new DeleteView(session);
            deleteView.show();
        }
        if (number.equals("0")){
            MainView mainView = new MainView(session);
            mainView.show();
        }
    }
}
