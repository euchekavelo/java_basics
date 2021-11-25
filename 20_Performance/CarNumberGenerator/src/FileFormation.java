import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileFormation implements Runnable {

    private final int number;

    public FileFormation(int number){
        this.number = number;
    }

    private void generateFileWithNumbers() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("res/numbers" + number + ".txt");

        char[] letters = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};
        for (int regionCode = 1; regionCode < 100; regionCode++) {
            StringBuilder builder = new StringBuilder();
            for (int number = 1; number < 1000; number++) {
                for (char firstLetter : letters) {
                    for (char secondLetter : letters) {
                        for (char thirdLetter : letters) {
                            builder.append(firstLetter);
                            builder.append(padNumber(number, 3));
                            builder.append(secondLetter);
                            builder.append(thirdLetter);
                            builder.append(padNumber(regionCode, 2));
                            builder.append("\n");
                        }
                    }
                }
            }
            writer.write(builder.toString());
        }

        writer.flush();
        writer.close();
    }

    private String padNumber(int number, int numberLength) {
        StringBuilder numberStr = new StringBuilder(Integer.toString(number));
        int padSize = numberLength - numberStr.length();

        if (padSize > 0) {
            for (int i = 0; i < padSize; i++)
                numberStr.insert(0,'0');
        }

        return numberStr.toString();
    }

    @Override
    public void run() {
        try {
            generateFileWithNumbers();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
