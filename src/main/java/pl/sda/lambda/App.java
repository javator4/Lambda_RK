package pl.sda.lambda;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@FunctionalInterface
interface Square {
    int square(int x);
}


public class App {
    public static void main(String[] args) {


        List<String> names = Arrays.asList("Kasia", "Ania", "Zosia", "Bartek");

//        Collections.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        });

        System.out.println(names);

        Collections.sort(names, (String s1, String s2) -> s1.compareTo(s2));

        System.out.println(names);
        System.out.println();
        System.out.println(SampleData.membersOfTheBeatles);

        Collections.sort(SampleData.membersOfTheBeatles, new Comparator<Artist>() {
            @Override
            public int compare(Artist o1, Artist o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });


        System.out.println(SampleData.membersOfTheBeatles);

        Square s = (int x) -> x * x;
        System.out.println(s.square(2));


        String[] a = {"cat", "dog", "mouse", "rat", "pig", "rabbit", "hamster", "parrot"};
        List<String> animals = Arrays.asList(a);
        // Tradycyjna pętla
        for (String animal : animals) {
            System.out.print(animal + "; ");
        }
        System.out.println();
        // Wyrażenie lambda
        animals.forEach((x) -> System.out.print(x + "; "));

        System.out.println();
        animals.forEach(System.out::println);

        List<String> fruits = Arrays.asList("apple", "banana", "cherry", "plum", "pear", "pinapple");
        System.out.println();
        fruits.stream().
                filter((x) -> x.startsWith("a")).
                map((x) -> x.toUpperCase()).
                forEach(System.out::println);

        List<String> result = fruits.stream().filter((x) -> x.startsWith("p")).map((x) -> x.toUpperCase()).collect(Collectors.toList());

        System.out.println(result);


        int couter = 0;
        for (Artist members : SampleData.membersOfTheBeatles) {
            if (members.getNationality().equals("UK")) {
                couter++;
            }
        }


        long number = SampleData.membersOfTheBeatles.stream().filter((x) -> x.getNationality().equals("UK")).count();

        System.out.println(couter);
        System.out.println(number);

        List<String> stringList = Stream.of("a", "b", "c")
                .map((x) -> x.toUpperCase())
                .collect(Collectors.toList());

        List<String> stringList1 = Arrays.asList("a", "b", "c").stream().map((x) -> x.toUpperCase())
                .collect(Collectors.toList());


        System.out.println();
        List<String> dataWthiNumbers = Arrays.asList("a", "122as", "a23", "b32ss", "3a");

        for (String data : dataWthiNumbers) {
            if (Character.isDigit(data.charAt(0))) {
                System.out.println(data);
            }
        }

        List<String> resultNumber = dataWthiNumbers.stream().
                filter(x -> Character.isDigit(x.charAt(0))).
                collect(Collectors.toList());

        resultNumber.forEach((x) -> System.out.println(x));

// flat.map - spłaszczanie listy wielowymiarowej
        List<Integer> flat = Stream.of(Arrays.asList(2, 3, 4), Arrays.asList(33, 32, 44))
                .flatMap(numbers -> numbers.stream())
                .collect(Collectors.toList());

        System.out.println(flat);


        List<Track> tracks = Arrays.asList(
                new Track("Bakai", 524),
                new Track("Violets For Your FUrs", 378),
                new Track("Time Was", 451));

        Track minTrack = tracks.stream().min(Comparator.comparing(track -> track.getLength())).get();

        System.out.println(minTrack);


        //napisać znajdowanie najkróttszego utworu bez użycia stream - pętla for i if


//        for (Track t : tracks) {
//            if (t.getLength() < trackTemp) {
//                trackTemp = t.getLength()
//            }
//
//        }

    }


}

