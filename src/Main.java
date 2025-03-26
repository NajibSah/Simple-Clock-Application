import java.time.Clock;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {



        // create a SimpleClock Thread
        SimpleClock clockThread = new SimpleClock();
        Thread thread = new Thread(clockThread);
        // Start the high priority thread
        thread.start();

        // Stop the high priority thread
        //clockThread.stop();

        

    }
}