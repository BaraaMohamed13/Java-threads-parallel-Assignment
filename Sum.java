package osprojet;

public class Sum extends Thread {

    private int start;
    private int end;

    public Sum(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        long minstart = System.nanoTime();
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += OsProjet.getList()[i];
        }
        System.out.println("the Sum Of Thread Is: "+sum);
        long minsend = System.nanoTime();

        System.out.println("Time taken to calcualte sum in nanosecond = " + (minsend - minstart));
    }

}
