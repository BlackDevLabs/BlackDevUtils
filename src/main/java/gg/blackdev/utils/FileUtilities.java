package gg.blackdev.utils;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtilities {

    // ========== File Reader ==========
    public static String readFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    // ========== File Writer ==========
    public static void writeFile(String filePath, String content) throws IOException {
        Files.write(Paths.get(filePath), content.getBytes(), StandardOpenOption.CREATE);
    }

    // ========== File Copy ==========
    public static void copyFile(String sourcePath, String destPath) throws IOException {
        Files.copy(Paths.get(sourcePath), Paths.get(destPath), StandardCopyOption.REPLACE_EXISTING);
    }

    // ========== File Deletion ==========
    public static void deleteFile(String filePath) throws IOException {
        Files.deleteIfExists(Paths.get(filePath));
    }

    // ========== Directory Listing ==========
    public static List<String> listFilesInDirectory(String dirPath) throws IOException {
        List<String> fileList = new ArrayList<>();
        DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(dirPath));
        for (Path path : directoryStream) {
            fileList.add(path.toString());
        }
        return fileList;
    }
}
