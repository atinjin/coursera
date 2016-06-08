import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Donghyun Ryan Jin [https://github.com/atinjin]
 * coursera on 2016. 6. 3..
 */
public class GenerateData {
    public static void main(String[] args) throws IOException {
        File file = new File("./data.txt");
        StringBuilder data = new StringBuilder();
        int max = 100000;
        FileWriter writer = new FileWriter(file);
        writer.write(max+"\n");
        Random random = new Random();
        for(int i=0; i<max; i++) {
            int num = Integer.valueOf(random.nextInt());
            if(num < 0) num = num * -1;
            writer.write(String.valueOf(num)+" ");
        }
    }
}
