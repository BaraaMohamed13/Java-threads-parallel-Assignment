package osprojet;

import java.lang.*;
import java.util.*;

public class parallelAssignment extends Thread {

    private int start;
    private int end;

    public parallelAssignment(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        long minstart = System.nanoTime();
        for (int i = start; i < end; i++) {
            OsProjet.getList()[i] = (int) (Math.random() * 9);
        }
       // System.out.println(Arrays.toString(OsProjet.getList()));
        long minsend = System.nanoTime();
        System.out.println("Time taken to calcualte the Parallel Assignment in nanosecond = "+(minsend-minstart));
    }
}
