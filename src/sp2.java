//задание 2
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class sp2 {
    public static void main(String[] args) {
        // Получаем все процессы, запущенные в операционной системе
        List<ProcessHandle> processes = ProcessHandle.allProcesses().collect(Collectors.toList());
        processes.sort(Comparator.comparingLong(ProcessHandle::pid));
        System.out.println(processes);

        for (ProcessHandle process : processes) {
            // Получаем имя процесса
            String processName = process.info().command().orElse("Неизвестно"); //тут же идёт обработка, если отсутствует имя

            // Получаем ID процесса
            long processId = process.pid();

            System.out.println("Имя процесса: " + processName);
            System.out.println("ID: " + processId);
            System.out.println();}

        // Находим первый запущенный процесс
        ProcessHandle firstProcess = processes.get(0);
        System.out.println(firstProcess);

        // Выводим информацию о первом процессе
        System.out.println("ID: " + firstProcess.pid());
        System.out.println("Название: " + firstProcess.info().command().orElse("Неизвестно"));
        System.out.println("Статус: " + firstProcess.isAlive());
    }
}
