import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SimpleClock implements Runnable {
    // i had to name my Java Clock class SimpleClock because Java already have a built in Clock Class

    private boolean keepRunning = true;

    public void stop() {
        keepRunning = false;
    }

    // getDateTime get Local time
    public static String getDateTime(Clock clock) {
        LocalDateTime now = LocalDateTime.now(clock);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // Customize format as needed


        return now.format(formatter);
    }
    // clockdisplay is a method to display time in "HH:mm:ss dd-MM-yyyy" format
    public static String clockdisplay (){
        Clock UtcTime = Clock.systemUTC(); // Get system clock in UTC (you can use other clocks if needed)
        String formattedDateTime = SimpleClock.getDateTime(UtcTime);
        System.out.println("Current Date and Time: " + formattedDateTime);

        return formattedDateTime;

    }

    // i implemented Runnable to continuously update and print the current time. 
    @Override
    public void run() {
        while (keepRunning) {
            clockdisplay();  // i called clockdisplay to display time as a thread

            try {
                // Sleep for 1 second
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}