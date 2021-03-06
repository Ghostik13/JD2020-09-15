package by.it.dobrodey.jd01_15;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class TaskC {
    private static String getPath(Class<?> aClass) {
        String packageName = aClass
                .getPackage()
                .getName()
                .replace(".", File.separator)
                .concat(File.separator);
        String root = System.getProperty("user.dir");

        return root + File.separator + "src" +
                File.separator + packageName;
    }
    public static void main(String[] args) {
        File file = new File(getPath(TaskC.class));
        File[] files;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Scanner scanner = new Scanner(System.in);
        String expression;
        String up;
        while (!(expression = scanner.nextLine()).equals("end")) {
            if (expression.equals(("dir"))) {
                files = file.listFiles();
                if (files == null) throw new AssertionError();
                for (File fileIN : files) {
                    if (fileIN.isFile()) {
                        System.out.println(sdf.format(fileIN.lastModified())
                                + " <file> "+fileIN.length()+ " " + fileIN.getName());

                    } else if (fileIN.isDirectory()) {
                        System.out.println(sdf.format(fileIN.lastModified())
                                + " <DIR> "+ fileIN.length() + " " + fileIN.getName());
                    }
                }
                System.out.println();
            }
            if (expression.startsWith(("cd"))) {
                up = expression.replaceAll("cd", "").trim();
                if (up.startsWith("..")) {
                    file = file.getParentFile();
                } else {
                    file = new File(file.toString() + "/" + up);
                }
            }
        }
    }
}