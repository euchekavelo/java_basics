public class Main {

    public static final String PATH = "src/test/resources/movementList.csv";

    public static void main(String[] args) {

        Movements movements = new Movements(PATH);
        System.out.println("Общая сумма расходов: " + movements.getExpenseSum() + " руб.");
        System.out.println("Общая сумма доходов: " + movements.getIncomeSum() + " руб.");
        System.out.println();
        System.out.println("Общие суммы расходов по организациям:\n" + movements.getAmountOfExpensesByOrganization());

    }
}
