import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class Homework1{
	private static AtomicInteger counter;
	private static boolean ArrayPrime[] = new boolean[(int)1e8 + 1];
	private static long maxArray[] = new long[10];
	private static long val = (long)1e8;
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		counter = new AtomicInteger(1);
		Thread[] threadArray = new Thread[8];
		for (int i = 0; i < threadArray.length; i++) {
			threadArray[i] = new Thread(new Runnable() {
				public void run() {
					sieveThread();
				}
			});
		}
		for (int i = 0; i < threadArray.length; i++) {
			threadArray[i].start();
		}
		for (int i = 0; i < threadArray.length; i++) {
			try {
				threadArray[i].join();
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}

		long sum = 0;
		long total = 0;
		for (int i = 2; i < ArrayPrime.length; i++) {
			if (ArrayPrime[i] == false) {
				sum += (long)i;
				total++;
				maxArr(maxArray, i);
			}
		}
		Arrays.sort(maxArray);		
		long end = System.currentTimeMillis();
		try {
			FileWriter fw=new FileWriter("output.txt");
			fw.write((end - start)/1000.00 + " seconds " + total + " " + sum + "\n");
			for (int i = 0; i < 10; i++) {
				fw.write(maxArray[i] + " ");
			}
			fw.close();
		}
		catch (Exception e) {
            e.getStackTrace();
        }
		
	}
	
	public static void maxArr(long [] max, long num) {
		Arrays.sort(max);
		for (int i = 0; i < 10; i++) {
			if (num > max[i]) {
				max[i] = num;
				break;
			}
		}
	}

	
	public static void sieveThread() {
		long num = (long)counter.incrementAndGet();
        while (num <= val)
        {
        	if (ArrayPrime[(int)num] != false) {
        		num = counter.incrementAndGet();
        		continue;
        	}
        	long i = num * num;
        	while (i <= val) {
        		if (i <= val) {
        			ArrayPrime[(int)i] = true;
                }
        		i += num;
        	}
            num = counter.incrementAndGet();
        }
    
	}
}
