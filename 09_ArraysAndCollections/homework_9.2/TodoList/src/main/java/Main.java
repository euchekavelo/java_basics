import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        // TODO: написать консольное приложение для работы со списком дел todoList

        String regexList = "LIST";
        String regexAdd = "ADD\\s.+";
        String regexAddIndex = "\\d+\\s.+";
        String regexEdit = "EDIT\\s\\d+\\s.+";
        String regexDelete = "DELETE\\s\\d+";
        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }

            if (input.matches(regexList))
            {
                String outputLine = "";
                ArrayList<String> outputList = todoList.getTodos();
                if (!outputList.isEmpty()) {
                    for (int i = 0; i < outputList.size(); i++) {
                        outputLine = outputLine.concat(i + " - " + outputList.get(i) + System.lineSeparator());
                    }
                    System.out.println(outputLine.trim());
                }
                else
                    System.out.println("Список дел пока пуст.");
            }
            else if (input.matches(regexAdd))
            {
                String element = input.replaceFirst("ADD\\s", "");
                if (element.matches(regexAddIndex))
                {
                    int start = element.indexOf(" ");
                    int lengthLine = element.length();
                    String textNumber = element.substring(0, start);
                    int index = Integer.parseInt(textNumber);

                    todoList.add(index, element.substring(start + 1, lengthLine));
                }
                else
                    todoList.add(element);
            }
            else if (input.matches(regexEdit))
            {
                String element = input.replaceFirst("EDIT\\s", "");
                int start = element.indexOf(" ");
                int lengthLine = element.length();
                String textNumber = element.substring(0, start);
                int index = Integer.parseInt(textNumber);

                todoList.edit(element.substring(start + 1, lengthLine), index);
            }
            else if (input.matches(regexDelete))
            {
                int start = input.indexOf(" ");
                int lengthLine = input.length();
                String textNumber = input.substring(start + 1, lengthLine);
                int index = Integer.parseInt(textNumber);

                todoList.delete(index);
            }

        }

    }
}
