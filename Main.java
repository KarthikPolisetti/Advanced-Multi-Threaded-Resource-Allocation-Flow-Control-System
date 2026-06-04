package RollerCoaster;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;



class ParkMetrics{
    private final AtomicInteger visitorCount=new AtomicInteger(0);
    private final ReentrantReadWriteLock lock=new ReentrantReadWriteLock();
    private int waitTime;
    public void recordVisitorWalkIn(){
                visitorCount.incrementAndGet();
                System.out.println("Current No Of Visitors is :"+visitorCount.get());
    }


    public void updateWaitime(int min){
        lock.writeLock().lock();
        try{
            System.out.println("Updating  ride wait time ");
            this.waitTime=min;

        }
        finally{
            lock.writeLock().unlock();
        }
    }


    public int checkWaitTime(){
        lock.readLock().lock();
        try{
            System.out.println("Reading ride wait time");
            return waitTime;
        }
        finally{
            lock.readLock().unlock();
        }
    }
}


class RideQueue{
    private final ArrayBlockingQueue<String> q=new ArrayBlockingQueue<>(50);

            public void addGuestToLine(String guestName) throws InterruptedException {
                q.put(guestName);
                System.out.println(guestName+" added to the ride queue.");
            }


            public String boardGuest() throws InterruptedException {
                
                String guest = q.take();
                System.out.println(guest+" boarded the ride.");
                return guest;
            }
            

}

class CoasterTrain implements Runnable {
    private final int trainId;
     private final RideQueue rideQueue;

    public CoasterTrain(int id, RideQueue rideQueue) {
        this.trainId=id;
        this.rideQueue=rideQueue;
    }
    public void run(){
            
                try{
                    System.out.println("Guest On boarded on train"+trainId);
                    final CountDownLatch latch=new CountDownLatch(4);
                    
                    for (int i = 1; i <= 4; i++) {
                    String passenger = rideQueue.boardGuest(); 
                    System.out.println(passenger + " has buckled into Seat " + i + " of Train [" + trainId + "].");
                    
                }

                    for(int i=1;i<=4;i++){
                        System.out.println("Passenger " + i + " clicked harness for Train [" + trainId + "]");
                        latch.countDown();
                    }
                    latch.await();
System.out.println("Train [" + trainId + "] has arrived at the platform. Beginning boarding...");                }
                catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                }

            

    }

}





public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Welcome to the Roller Coaster!");
        RideQueue rideQueue=new RideQueue();
        ParkMetrics pm=new ParkMetrics();
        ExecutorService fleetManager = Executors.newFixedThreadPool(3);




        for(int i=0;i<15;i++){
                CoasterTrain train=new CoasterTrain(i, rideQueue);
                fleetManager.submit(train);
        }


         for(int i=1;i<=60;i++){
                rideQueue.addGuestToLine("Guest_"+i);
            }
            pm.recordVisitorWalkIn();
            pm.updateWaitime(30);
            System.out.println("Current Wait Time: "+pm.checkWaitTime()+" minutes");
            fleetManager.shutdown();
    }
}
