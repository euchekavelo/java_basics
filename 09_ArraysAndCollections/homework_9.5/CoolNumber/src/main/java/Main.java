import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<String> carNumbers = CoolNumbers.generateCoolNumbers();

        while (true)
        {
            TreeMap<Long, String> results = new TreeMap<>();
            System.out.println("Введите автомобильный номер для поиска:");
            String input = InputUser.getLine();

            System.out.print("Поиск перебором: ");
            long startTime = System.nanoTime();
            CoolNumbers.bruteForceSearchInList(carNumbers, input);
            long endTime = System.nanoTime() - startTime;
            System.out.println(", поиск занял " + endTime + " нс." +
                    "\n----------------------------------------------------------");
            results.put(endTime, "Поиск элемента перебором");

            List<String> sortedCarNumbers = new ArrayList<>(carNumbers);
            Collections.sort(sortedCarNumbers);
            System.out.print("Бинарный поиск: ");
            startTime = System.nanoTime();
            CoolNumbers.binarySearchInList(sortedCarNumbers, input);
            endTime = System.nanoTime() - startTime;
            System.out.println(", поиск занял " + endTime + " нс." +
                    "\n----------------------------------------------------------");
            results.put(endTime, "Поиск элемента бинарным поиском");

            HashSet<String> hashSet = new HashSet<>(carNumbers);
            System.out.print("Поиск в HashSet: ");
            startTime = System.nanoTime();
            CoolNumbers.searchInHashSet(hashSet, input);
            endTime = System.nanoTime() - startTime;
            System.out.println(", поиск занял " + endTime + " нс." +
                    "\n----------------------------------------------------------");
            results.put(endTime, "Поиск элемента в HashSet");

            TreeSet<String> treeSet = new TreeSet<>(carNumbers);
            System.out.print("Поиск в TreeSet: ");
            startTime = System.nanoTime();
            CoolNumbers.searchInTreeSet(treeSet, input);
            endTime = System.nanoTime() - startTime;
            System.out.println(", поиск занял " + endTime + " нс.\n");
            results.put(endTime, "Поиск элемента в TreeSet");

            long firstKey = results.firstKey();
            System.out.println("Самый быстрый поиск:\n" + results.get(firstKey) + " - " + firstKey + " наносекунд.\n");
        }
    }
}
