package com.IdeaProjects.StepicExercises;

// Stepic.Step 5.3
/*
Реализуйте метод, который зачитает данные из InputStream и преобразует их в строку, используя заданную кодировку.
        Пример
        InputStream последовательно возвращает четыре байта: 48 49 50 51.
        Метод, вызванный для такого InputStream и кодировки ASCII, должен вернуть строку "0123".
*/



import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
public class Step5_3_readAsString {
    private static void testValues() throws IOException {
        byte [] b=new byte[] {48,49,50,51};
        String str = readAsString(new ByteArrayInputStream(b), StandardCharsets.US_ASCII);
    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        try (InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset)) {
            int buf1=inputStreamReader.read();
            StringBuilder stringBuilder = new StringBuilder();
            while (buf1!=-1){
                char c = (char)buf1;
                stringBuilder.append(c);
                buf1=inputStreamReader.read();
            }
            return stringBuilder.toString();
        }
    }
}
