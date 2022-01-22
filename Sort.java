package osprojet;

import java.util.Arrays;

public class Sort extends Thread {

    private int start;
    private int end;

    public Sort(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        long minstart = System.nanoTime();
        Arrays.sort(OsProjet.getList(), start, end);
        //System.out.println(Arrays.toString(OsProjet.getList()));
        long minsend = System.nanoTime();
        System.out.println("Time taken to calcualte sort in nanosecond = " + (minsend - minstart));
    }
}
