import java.io.IOException;
import java.io.RandomAccessFile;

public class Rounding {
    //Считать с консоли 2 имени файла
    //Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
    //Округлить числа до целых и записать через пробел во второй файл
    //Закрыть потоки. Не использовать try-with-resources
    //Принцип округления:
    //3.49 - 3
    //3.50 - 4
    //3.51 - 4
    //-3.49 - -3
    //-3.50 - -3
    //-3.51 - -4
    public static void main(String[] args) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile("numb.txt", "rw");
             RandomAccessFile raf2 = new RandomAccessFile("numbRes.txt", "rw")) {

            double d;
            int i;
            while (true) {
                String st = raf.readLine();
                if (st==null) {
                    break;
                }
                d = Double.parseDouble(st);
                i= (int) d;

                if (d-(double) i >= 0.50) {
                    i++;
                } else if (d-(double) i < -0.50) {
                    i--;
                }

                raf2.writeBytes("\n"+i);
            }
        }

    }
}
