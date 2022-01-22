package osprojet;

import java.lang.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Arrays;

public class OsProjet {

    public static int list[] = new int[9000000];

    public static void setList(int[] list) {
        OsProjet.list = list;
    }

    public static int[] getList() {
        return list;
    }

    public static synchronized void min(int[] x) {
        long minstart = System.nanoTime();
        Integer min = null;

        for (int i = 0; i < x.length; i++) {
            if (i == 0) {
                min = x[i];
            }
            if (min > x[i]) {
                min = x[i];
            }
        }
        long minsend = System.nanoTime();
        System.out.println("Time taken to calcualte min in nanosecond = " + (minsend - minstart));
        
        System.out.println("Min is :"+min);
    }

    public static int max(int[] x) {
        long minstart = System.nanoTime();
        
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex1) {
            Logger.getLogger(OsProjet.class.getName()).log(Level.SEVERE, null, ex1);
        }
        int max = 0;
        for (int i = 0; i < x.length; i++) {
            if (max < x[i]) {
                max = x[i];
            }
        }
        long minsend = System.nanoTime();
        System.out.println("Time taken to calcualte max in nanosecond = " + (minsend - minstart));
        
        return max;
    }

    public static void print(int[] list) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex1) {
            Logger.getLogger(OsProjet.class.getName()).log(Level.SEVERE, null, ex1);
        }
        System.out.println(Arrays.toString(list));
        System.out.println("----------------------------------------------------------");
    }

    public static void main(String[] args) {
        // TODO code application logic here.

        ExecutorService ex = Executors.newCachedThreadPool();
        parallelAssignment p1 = new parallelAssignment(0, 3000000);
        parallelAssignment p2 = new parallelAssignment(3000000, 6000000);
        parallelAssignment p3 = new parallelAssignment(6000000, 9000000);

        ex.submit(p3);
        ex.submit(p2);
        ex.submit(p1);

        ex.shutdown();
        
        print(list);
        

        ExecutorService ex2 = Executors.newCachedThreadPool();
        Sort s1 = new Sort(0, 3000000);
        Sort s2 = new Sort(3000000, 6000000);
        Sort s3 = new Sort(6000000, 9000000);

        ex2.submit(s3);
        ex2.submit(s2);
        ex2.submit(s1);

        ex2.shutdown();
        
        print(list);

        ExecutorService ex3 = Executors.newCachedThreadPool();
        Sum ss1 = new Sum(0, 3000000);
        Sum ss2 = new Sum(3000000, 6000000);
        Sum ss3 = new Sum(6000000, 9000000);

        ex3.submit(ss1);
        ex3.submit(ss2);
        ex3.submit(ss3);

        ex3.shutdown();
        
        

        System.out.println("Max is :"+OsProjet.max(list));
        OsProjet.min(list);

    }
}
