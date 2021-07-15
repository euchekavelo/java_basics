public class Main {

    public static void main(String[] args) {

        String line = "Каждый охотник желает знать, где сидит фазан";

        String[] words = line.split(",?\\s+");
        String[] outputArray = ReverseArray.reverse(words);
        for (String word : outputArray)
        {
            System.out.println(word);
        }

    }
}
