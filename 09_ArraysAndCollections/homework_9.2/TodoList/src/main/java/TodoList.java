import java.util.ArrayList;

public class TodoList {

    private ArrayList<String> list = new ArrayList<>();

    public void add(String todo) {
        // TODO: добавьте переданное дело в конец списка
        list.add(todo);
        System.out.println("Добавлено дело \"" + todo+ "\" в конец списка.");
    }

    public void add(int index, String todo) {
        // TODO: добавьте дело на указаный индекс,
        //  проверьте возможность добавления

        if (index >= 0 && index < list.size())
        {
            list.add(index, todo);
            System.out.println("Добавлено дело \"" + todo + "\" в список по указанному индексу.");
        }
        else {
            System.out.println("Указанный номер в списке не найден.");
            add(todo);
        }
    }

    public void edit(String todo, int index) {
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения

        if (index >= 0 && index < list.size())
        {
            String pastValue = list.get(index);
            list.set(index, todo);
            System.out.println("Дело \"" + pastValue + "\" заменено на \"" + list.get(index) + "\".");
        }
        else
            System.out.println("Элемента с указанным номером в списке не существует. Изменение невозможно.");
    }

    public void delete(int index) {
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела

        if (index >= 0 && index < list.size())
        {
            String deletedCase = list.get(index);
            list.remove(index);
            System.out.println("Дело \"" + deletedCase + "\" удалено из списка.");
        }
        else
            System.out.println("Дела с таким номером в списке не существует. Удаление невозможно.");
    }

    public ArrayList<String> getTodos() {
        // TODO: вернуть список дел
        return list;
    }

}