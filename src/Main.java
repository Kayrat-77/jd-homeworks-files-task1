import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static Date date = new Date();

    public static void main(String[] args) throws IOException {

        Path directoryPath = Paths.get("D:\\Games");

        List<String> gamesDir = Arrays.asList("src", "res", "savegames", "temp");
        List<String> srcDir = Arrays.asList("main", "test");
        List<String> resDir = Arrays.asList("drawables", "vectors", "icons");

        createDirectory(String.valueOf(directoryPath), gamesDir);
        createDirectory(directoryPath + "\\src", srcDir);
        createDirectory(directoryPath + "\\res", resDir);

        List<String> mainFiles = Arrays.asList("Main.java", "Utils.java");
        List<String> tempFiles = Arrays.asList("temp.txt");

        createFiles(directoryPath + "\\src\\main", mainFiles);
        createFiles(directoryPath + "\\temp", tempFiles);

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(directoryPath + "\\temp\\temp.txt"))) {
            writer.write(sb.toString());
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
//        System.out.println(sb);

    }

    public static void createDirectory(String path, List<String> list) {
        list.forEach(dir -> {
            File dirs = new File(path, dir);
            if (!dirs.exists()) {
                if (dirs.mkdir()) {
                    sb.append(date + " <> Каталог " + dirs.getName() + " успешно создан в: " + dirs.getAbsolutePath());
                    sb.append("\n");
                } else {
                    sb.append(date + " <> " + dirs.getName() + "Ошибка при создании!\n");
                }
            } else {
                sb.append(date + " <> " + "Каталог был создан ранее\n");
            }
        });
    }

    public static void createFiles(String path, List<String> list) {
        list.forEach(file -> {
                    File files = new File(path, file);
                    if (!files.exists()) {
                        try {
                            if (files.createNewFile()) {
                                sb.append(date + " <> Файл " + files.getName() + " успешно создан в: " + files.getAbsolutePath());
                                sb.append("\n");
                            } else {
                                sb.append(date + " <> " + files.getName() + "Ошибка при создании!\n");
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        sb.append(date + " <> " + "Файл был создан ранее\n");
                    }
                }
        );

    }

}