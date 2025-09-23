import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileTree {
    private static int MAX_NAME_LENGTH = 15;
    private static int MAX_DEPTH = 2;
    private static boolean writeToFile = false;

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Enter the root path: ");
            String rootPath = in.nextLine();
            System.out.print("Enter max name length (default 15 ,<=-1 means no limit): ");
            MAX_NAME_LENGTH = in.nextInt();
            if(MAX_NAME_LENGTH <= -1) MAX_NAME_LENGTH = 999;
            System.out.print("Enter max depth (default 2): ");
            MAX_DEPTH = in.nextInt();
            System.out.print("Write output to file? (1 true , 0 false, default false): ");
            // writeToFile = in.nextBoolean();
            int writeOption = in.nextInt();
            writeToFile = (writeOption == 1);
            if (!writeToFile)
                printFileTree(rootPath, 0, true);
            else {
                try (java.io.BufferedWriter writer =
                         Files.newBufferedWriter(Paths.get("file_tree.txt"), StandardCharsets.UTF_8)) { // 强制 UTF-8
                    printFileTree(rootPath, 0, true, writer);
                } catch (java.io.IOException e) {
                    System.err.println("Error writing to file: " + e.getMessage());
                }
            }
        }
    }

    private static void printFileTree(String path, int level, boolean isLast) {
        if (level > MAX_DEPTH)
            return; // Limit depth to avoid too deep recursion
        java.io.File root = new java.io.File(path);
        if (!root.exists()) {
            System.out.println("Path does not exist.");
            return;
        }
        printIndent(level);

        if (!isLast) {
            System.out.print("├─ ");
        } else {
            System.out.print("└─ ");
        }
        System.out.println(root.getName().substring(0, Math.min(MAX_NAME_LENGTH, root.getName().length())));
        if (root.isDirectory()) {
            java.io.File[] files = root.listFiles();
            if (files == null || files.length == 0) {
                return; // 目录为空或不可读，避免 files[-1]
            }
            if (files != null) {
                java.io.File LastFile = files[files.length - 1];
                for (java.io.File file : files) {
                    printFileTree(file.getAbsolutePath(), level + 1, file.equals(LastFile));
                }
            }
        }
    }

    private static void printFileTree(String path, int level, boolean isLast, java.io.BufferedWriter writer) throws java.io.IOException {
        if (level > MAX_DEPTH)
            return; // Limit depth to avoid too deep recursion
        java.io.File root = new java.io.File(path);
        if (!root.exists()) {
            writer.write("Path does not exist.\n");
            return;
        }
        for (int i = 0; i < level; i++) {
            writer.write("    "); // 4 spaces for each level
        }

        if (!isLast) {
            writer.write("├─ ");
        } else {
            writer.write("└─ ");
        }
        writer.write(root.getName().substring(0, Math.min(MAX_NAME_LENGTH, root.getName().length())) + "\n");
        if (root.isDirectory()) {
            java.io.File[] files = root.listFiles();
            if (files == null || files.length == 0) {
                return; // 目录为空或不可读，避免 files[-1]
            }
            if (files != null) {
                java.io.File LastFile = files[files.length - 1];
                for (java.io.File file : files) {
                    printFileTree(file.getAbsolutePath(), level + 1, file.equals(LastFile), writer);
                }
            }
        }
    }

    private static void printIndent(int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("    "); // 4 spaces for each level
        }
    }
}
