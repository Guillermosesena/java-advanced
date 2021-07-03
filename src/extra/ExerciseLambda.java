package extra;

import java.util.ArrayList;
import java.util.List;

public class ExerciseLambda {
    static void print(String message)
    {
        System.out.println(message);
    }

    public static void main(String[] args) {
        List<String> messages = new ArrayList<String>();
        messages.add("Hola");
        messages.add("Adios");

        messages.forEach(System.out::println);
        messages.forEach(ExerciseLambda::print);
    }
}
