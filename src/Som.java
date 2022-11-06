import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Som {

    public static void main(String[] args) {
        // number = "5732";
        // divider 8
        // result = 7352
        String number = args[0];
        Integer divider = Integer.valueOf(args[1]);

        String[] arr = number.split("");

        ArrayList<String> lst = new ArrayList<>(Arrays.asList(arr));

        Integer min = Integer.valueOf(lst.stream().sorted().collect(Collectors.joining()));
        Integer max = Integer.valueOf(lst.stream().sorted(Comparator.reverseOrder()).collect(Collectors.joining()));

        OptionalInt result =
                IntStream.rangeClosed(min, max)
                        .filter(i -> lst.stream().parallel().allMatch(inp -> String.valueOf(i).contains(inp)))
                        .filter(i -> (i % divider == 0))
                        .max();

        result.ifPresent(p -> System.out.println("result: " + p));
    }
}