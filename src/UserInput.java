import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Slime on 27/12/2016.
 */
public class UserInput {
    public static void main(String[] args) throws IOException {

        String input = "";
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        input = br.readLine();
        System.out.println(input); 

    }
}
