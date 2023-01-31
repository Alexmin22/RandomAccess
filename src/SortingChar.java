
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

public class SortingChar {
    //6. Встречаемость символов
    //
    //Программа запускается с одним параметром - именем файла, который содержит английский текст.
    //Посчитать частоту встречания каждого символа.
    //Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
    //Вывести на консоль отсортированный результат:
    //[символ1] частота1
    //[символ2] частота2
    public static void main(String[] args) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile("engText.txt", "rw")) {

            int[] ascii = new int[126 - 31];
            int counter = 0;
            for (int i = 32; i < 127; i++) {
                ascii[counter] = i;
                counter++;
            }

            String a = raf.readLine();
            while (raf.readLine() != null) {
                a += raf.readLine();
            }

            char[] ch = a.toCharArray();
            for (int integ : ascii) {
                int count = 0;
                for (int i = 0; i < ch.length; i++) {
                    if (integ == ch[i]) {
                        count++;
                    }
                }
                if (count != 0) {
                    System.out.println(" '" + (char) integ + "' = " + count);
                }

            }
            }
        }
    }
