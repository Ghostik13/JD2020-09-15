package by.it.fedorinhyk.jd01_06;

public class TaskC1 {
    public static void main(String[] args) {
        String poem = Poem.text;
        String[] sentences = poem.split("\\n+");
        for (int i=sentences.length-1; i>0;i--) {
            for (int j = 0; j < sentences.length - 1; j++) {
                String temp;
                if (sentences[j].length() > sentences[j + 1].length()) {
                    temp = sentences[j];
                    sentences[j] = sentences[j + 1];
                    sentences[j + 1] = temp;
                }
            }
        }
    }
}

