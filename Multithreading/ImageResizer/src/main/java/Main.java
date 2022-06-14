import java.io.File;
import java.util.*;
import java.util.concurrent.*;

public class Main
{
    private static int newWidth = 300;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String srcFolder = "F:/Java-Разработчик/ImageResizerExperiments/src";
        String dstFolderSclar = "F:/Java-Разработчик/ImageResizerExperiments/dstScalr";
        String dstFolderStandardScale = "F:/Java-Разработчик/ImageResizerExperiments/dst";

        //TODO: реализовать передачу вида обработки фотографий через конктруктор (разобраться с применением паттерна Strategy)
        executeImageResizing(getProcessorsCount(), srcFolder, dstFolderSclar);
        executeImageResizingStandard(getProcessorsCount(), srcFolder, dstFolderStandardScale);

        System.out.println("Все потоки отработали. Поток Main завершается.");
    }

    private static void executeImageResizing(int processorsCount, String srcFolder, String dstFolder)
            throws ExecutionException, InterruptedException {

        File srcDir = new File(srcFolder);
        File[] files = srcDir.listFiles();
        assert files != null;

        int filesCountForOneCore = files.length/processorsCount;

        ExecutorService executorService = Executors.newFixedThreadPool(processorsCount);
        List<Future<?>> tasks = new ArrayList<>();
        for (int i = 0; i < (processorsCount - 1); i++) {
            File[] filesPart = new File[filesCountForOneCore];
            System.arraycopy(files, filesCountForOneCore * i, filesPart, 0, filesPart.length);
            tasks.add(executorService.submit(() -> new ImageResizer(filesPart, newWidth, dstFolder).run()));
        }
        int lengthOfLastPartOfFiles = files.length - filesCountForOneCore * (processorsCount - 1);
        File[] filesLastPart = new File[lengthOfLastPartOfFiles];
        System.arraycopy(files, filesCountForOneCore* (processorsCount - 1), filesLastPart, 0, filesLastPart.length);
        tasks.add(executorService.submit(() -> new ImageResizer(filesLastPart, newWidth, dstFolder).run()));
        for (Future<?> task: tasks) {
            task.get();
        }
        executorService.shutdown();
    }

    private static void executeImageResizingStandard(int processorsCount, String srcFolder, String dstFolder)
            throws ExecutionException, InterruptedException {

        File srcDir = new File(srcFolder);
        File[] files = srcDir.listFiles();
        assert files != null;

        int filesCountForOneCore = files.length/processorsCount;

        ExecutorService executorService = Executors.newFixedThreadPool(processorsCount);
        List<Future<?>> tasks = new ArrayList<>();
        for (int i = 0; i < (processorsCount - 1); i++) {
            File[] filesPart = new File[filesCountForOneCore];
            System.arraycopy(files, filesCountForOneCore * i, filesPart, 0, filesPart.length);
            tasks.add(executorService.submit(() -> new ImageResizerStandardScale(filesPart, newWidth, dstFolder).run()));
        }
        int lengthOfLastPartOfFiles = files.length - filesCountForOneCore * (processorsCount - 1);
        File[] filesLastPart = new File[lengthOfLastPartOfFiles];
        System.arraycopy(files, filesCountForOneCore* (processorsCount - 1), filesLastPart, 0, filesLastPart.length);
        tasks.add(executorService.submit(() -> new ImageResizerStandardScale(filesLastPart, newWidth, dstFolder).run()));
        for (Future<?> task: tasks) {
            task.get();
        }
        executorService.shutdown();
    }

    private static int getProcessorsCount() {
        Runtime runtime = Runtime.getRuntime();
        int nmbrOfProcessors = runtime.availableProcessors();
        System.out.println("Количество логических процессоров " + nmbrOfProcessors);
        return nmbrOfProcessors;
    }


}