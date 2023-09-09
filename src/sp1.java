//задание 1
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class sp1 {

    public static void main(String[] args) {
        Timer timer = new Timer();
        int delay = 1000; // 1 секунда
        int period = 2000; // 5 секунд

        timer.scheduleAtFixedRate(new TimerTask() {
            int counter = 0;

            @Override
            public void run() {
                try {
                    Process process = Runtime.getRuntime().exec("notepad.exe");// Запуск процесса
                    counter++;
                    System.out.println("Процесс запущен " + counter + " раз");

                    if (counter >= 10) {  // Остановка таймера, если достигнуто нужное количество запусков
                        timer.cancel();
                        timer.purge();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, delay, period);
    }
}
