import java.util.*;

public class CoolNumbers {

    private final static int MIN_NUMBER_REGION = 1; //Минимальный номер региона
    private final static int MAX_NUMBER_REGION = 199; //Максимальынй номер региона
    private final static int COUNT_NUMBERS = 2000000; //Требуемое количество номеров в коллекции
    private final static int COUNT_CHARS = 6; //Общее количество символов в номере без кода региона

    public static List<String> generateCoolNumbers()
    {
        Set<String> carsNumbers = new HashSet<>();
        Random random = new Random();
        while (carsNumbers.size() <= COUNT_NUMBERS)
        {
            List<String> charsList = new ArrayList<>(Arrays.asList("А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"));
            String subsequence = "";

            //Генерируем первую часть из 6 фрагментов номера
            for (int i = 0; i < COUNT_CHARS; i++)
            {
                if (i == 0)
                {
                    int randomIndex = random.nextInt(charsList.size());
                    subsequence = subsequence.concat(charsList.get(randomIndex));
                }
                else if (i == 1)
                {
                    int randomDigit = random.nextInt(10);
                    subsequence = subsequence.concat(Integer.toString(randomDigit));
                }
                else if (i == 2 || i == 3)
                    subsequence = subsequence.concat(Character.toString(subsequence.charAt(1)));
                else if (i == 4)
                {
                    int randomIndex = random.nextInt(charsList.size());
                    char firstSymbol = subsequence.charAt(0);
                    String element = charsList.get(randomIndex);
                    if (element.equals(Character.toString(firstSymbol)))
                    {
                        charsList.remove(randomIndex);
                        randomIndex = random.nextInt(charsList.size());
                        subsequence = subsequence.concat(charsList.get(randomIndex));
                    }
                    else
                        subsequence = subsequence.concat(element);
                }
                else
                {
                    int randomIndex = random.nextInt(charsList.size());
                    char firstSymbol = subsequence.charAt(0);
                    char secondSymbol = subsequence.charAt(4);
                    String element = charsList.get(randomIndex);
                    if (!element.equals(Character.toString(firstSymbol)) && !element.equals(Character.toString(secondSymbol)))
                        subsequence = subsequence.concat(element);
                    else
                    {
                        charsList.remove(randomIndex);
                        randomIndex = random.nextInt(charsList.size());
                        subsequence = subsequence.concat(charsList.get(randomIndex));
                    }

                }
            }

            //Генерируем вторую часть - номер региона
            int randomDigit = (int) (Math.random() * (MAX_NUMBER_REGION - MIN_NUMBER_REGION + 1)) + MIN_NUMBER_REGION;
            if (randomDigit <= 9)
                subsequence = subsequence.concat(0 + Integer.toString(randomDigit));
            else
                subsequence = subsequence.concat(Integer.toString(randomDigit));

            //Если сгенерированный элемент отсутствует в коллекции, тогда добавляем его.
            if (!carsNumbers.contains(subsequence))
                carsNumbers.add(subsequence);
        }

        return new ArrayList<>(carsNumbers);
    }

    public static boolean bruteForceSearchInList(List<String> list, String number)
    {
        boolean findingElement = false;
        for (String element : list)
        {
            if (element.equals(number))
            {
                findingElement = true;
                break;
            }
        }

        if (findingElement)
            System.out.print("номер найден");
        else
            System.out.print("номер не найден");

        return findingElement;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number)
    {
        boolean findingElement = false;
        int index = Collections.binarySearch(sortedList, number);
        if (index >= 0)
        {
            findingElement = true;
            System.out.print("номер найден");
        }
        else
            System.out.print("номер не найден");

        return findingElement;
    }


    public static boolean searchInHashSet(HashSet<String> hashSet, String number)
    {
        boolean findingElement = false;
        if (hashSet.contains(number))
        {
            findingElement = true;
            System.out.print("номер найден");
        }
        else
            System.out.print("номер не найден");

        return findingElement;
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number)
    {
        boolean findingElement = false;
        if (treeSet.contains(number))
        {
            findingElement = true;
            System.out.print("номер найден");
        }
        else
            System.out.print("номер не найден");

        return findingElement;
    }

}
