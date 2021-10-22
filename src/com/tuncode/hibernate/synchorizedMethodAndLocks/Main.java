package com.tuncode.hibernate.synchorizedMethodAndLocks;

public class Main {
    public static void main(String[] args) {
        AlotOfLocksForSynchorized forSynchorized = new AlotOfLocksForSynchorized();
        long startTime = System.currentTimeMillis();

        forSynchorized.addValue();

        long endTime = System.currentTimeMillis();

        System.out.println("SPENT TIME BY A LOT OF LOCKS : " + (endTime - startTime));
    }

}
