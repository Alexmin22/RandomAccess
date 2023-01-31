
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

public class SortingChar {
    //6. ������������� ��������
    //
    //��������� ����������� � ����� ���������� - ������ �����, ������� �������� ���������� �����.
    //��������� ������� ���������� ������� �������.
    //������������� ��������� �� ����������� ���� ASCII (�������� � �����). ������: ','=44, 's'=115, 't'=116
    //������� �� ������� ��������������� ���������:
    //[������1] �������1
    //[������2] �������2
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
