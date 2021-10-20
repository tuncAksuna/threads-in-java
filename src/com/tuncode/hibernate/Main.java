package com.tuncode.hibernate;

import com.tuncode.hibernate.basics.Printer;
import com.tuncode.hibernate.synchorizedMethodAndLocks.AlotOfLocksForSynchorized;

public class Main {

    public static void main(String[] args) {

        System.out.println("Main thread is being ran");

        Thread printer1 = new Thread(new Printer("Printer1"));
        Thread printer2 = new Thread(new Printer("Printer2"));

        //printer1.start();
        //printer2.start();

        /*****************************************************************************************/

        AlotOfLocksForSynchorized forSynchorized = new AlotOfLocksForSynchorized();
        long startTime = System.currentTimeMillis();

        forSynchorized.addValue();

        long endTime = System.currentTimeMillis();

        System.out.println("SPENNT TIME BY A LOT OF LOCKS : " + (endTime - startTime));

    }
}
