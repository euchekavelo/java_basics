import java.util.HashSet;
import java.util.Random;

public class Main {

    private static final int SLEEP = 1000; // 1 секунда
    private static final String FRAGMENT_STRING = " - На главной странице показываем пользователя ";

    public static void main(String[] args) throws InterruptedException {
        RedisStorage redisStorage = new RedisStorage();
        redisStorage.init();

        //Создадим и сразу добавим в очередь Redis через коллекцию "RScoredSortedSet" 20 пользователей по ключу "registered_users".
        for (int i = 0; i < 20; i++){
            User user = new User();
            redisStorage.addRegisteredUser(user.getTimeRegistration(), user.getUserName());
        }

        //Получим массив с отсортированными элементами из Redis, используя коллекцию "RScoredSortedSet".
        String[] arrayOfElements = redisStorage.getAnArrayOfElements();
        redisStorage.shutdown();

        //Бесконечный цикл.
        while (true) {
            int counter = 0;
            int numberIteration = 0;
            int numberRandomElement;
            HashSet<String> randomItems = new HashSet<>();//Коллекция для хранения случайных пользователей.
            for (int i = 0; i < arrayOfElements.length; i++) {

                //На первом шаге определим номер итерации, на которой необходимо показать случайного пользователя.
                if (counter == 0){
                    numberIteration = new Random().nextInt(arrayOfElements.length / 2);
                }

                //На определенной ранее итерации определим случайного пользователя, который оплатил услугу очередности.
                if (counter == numberIteration){
                    numberRandomElement = new Random().nextInt(arrayOfElements.length);
                    randomItems.add(arrayOfElements[numberRandomElement]);
                    System.out.println(" > Пользователь \"" + arrayOfElements[numberRandomElement] + "\" оплатил услугу \n"
                            + FRAGMENT_STRING + "\"" + arrayOfElements[numberRandomElement] + "\"");
                }

                if (i == arrayOfElements.length / 2 - 1){
                    counter = 0;
                }

                counter++;

                if (!randomItems.contains(arrayOfElements[i]))
                    System.out.println(FRAGMENT_STRING + "\"" + arrayOfElements[i] + "\"");
                else
                    continue;

                Thread.sleep(SLEEP);
            }
        }
    }

}
