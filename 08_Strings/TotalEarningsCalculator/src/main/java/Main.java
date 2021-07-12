public class Main {

  public static void main(String[] args) {

    String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
    //TODO: напишите ваш код, результат вывести в консоль

    System.out.println(getAmountEarnings(text));

  }

  public static String getAmountEarnings(String text)
  {
    //Получаем сумму Васи
    String charsetStrFirst = "Вася заработал";
    String charsetStrSecond = "рублей";
    int start1 = text.indexOf(charsetStrFirst) + charsetStrFirst.length();
    int end1 = text.indexOf(charsetStrSecond);
    String textAmountsVasya = text.substring(start1, end1).trim();
    int amountsVasya = Integer.parseInt(textAmountsVasya);

    //Получаем сумму Пети
    String hyphen = "-";
    String charsetStrThird = "рубля";
    int start2 = text.indexOf(hyphen) + hyphen.length();
    int end2 = text.indexOf(charsetStrThird);
    String textAmountsPetya = text.substring(start2, end2).trim();
    int amountsPetya = Integer.parseInt(textAmountsPetya);

    //Получаем сумму Маши
    int start3 = text.lastIndexOf(hyphen) + hyphen.length();
    int end3 = text.lastIndexOf(charsetStrSecond);
    String textAmountsMasha = text.substring(start3, end3).trim();
    int amountsMasha = Integer.parseInt(textAmountsMasha);

    //Подсчитываем общую сумму друзей
    int amountsFriends = amountsVasya + amountsPetya + amountsMasha;

    return Integer.toString(amountsFriends);
  }
}