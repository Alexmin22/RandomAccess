import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

public class Main {
    //4. Объединение файлов
    //
    //Считать с консоли 2 имени файла
    //В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
    public static void main(String[] args) throws IOException {
        File file = new File("text1.txt");
        File file2 = new File("text2.txt");

        file.createNewFile();
        file2.createNewFile();
        String st = "Считать с консоли 2 имени файла\n" +
                "В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов";
        String st2 = "У меня для тебя шикарная новость. Вот тебе задания для закрепления полученных навыков." +
                " Выполняй их каждый день, и твои навыки будут расти с неимоверной скоростью. Они специально " +
                "разработаны для выполнения их в Intellij IDEA.";

        try (RandomAccessFile raf = new RandomAccessFile("text1.txt", "rw");
        RandomAccessFile raf2 = new RandomAccessFile("text2.txt", "rw");) {
            raf.write(st.getBytes(StandardCharsets.UTF_8));
            raf2.write(st2.getBytes(StandardCharsets.UTF_8));

            raf.seek(0);

            byte[] bytes = new byte[(int) raf.length()];
            for (int i = 0; i < raf.length(); i++) {
                bytes[i] = raf.readByte();
            }

            raf2.seek(raf2.length()-1);
            raf2.write(bytes);
          }


    }
}