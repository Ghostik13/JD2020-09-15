package by.it.siarheikorbut.jd01_14;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    private static String dir() {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String classDir = TaskB.class.getName()
                .replace(TaskB.class.getSimpleName(), "")
                .replace(".", File.separator);
        return path + classDir;
    }

    public static void main(String[] args) {
        File fr = new File(dir() + "text.txt");
        File fw = new File(dir() + "resultTaskB.txt");
        FileWriter os = null;
        FileReader is = null;
        int b;
        int countSigns = 0;
        int countWords = 0;
        StringBuilder line = new StringBuilder();
        try {
            is = new FileReader(fr);
            while ((b = is.read()) != -1) {
                line.append((char) b);
            }
            Pattern patternSigns;
            patternSigns = Pattern.compile("[,.!;?:-]+");
            Pattern patternWords = Pattern.compile("[ёЁа-яА-Я]+");
            Matcher matcher = patternSigns.matcher(line);
            while (matcher.find()) {
                countSigns++;
            }
            matcher = patternWords.matcher(line);
            while (matcher.find()) {
                countWords++;
            }
            line.delete(0, line.length())
                    .append("words=")
                    .append(countWords)
                    .append(",punctuation marks=")
                    .append(countSigns);
            System.out.println(line);
            fw.createNewFile();
            os = new FileWriter(fw);
            os.write(line.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}