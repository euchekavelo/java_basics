public class Main {

    public static void main(String[] args) {

        PhysicalPerson personJohn = new PhysicalPerson();
        personJohn.put(10000);
        personJohn.getInformation();

        LegalPerson personLinda = new LegalPerson();
        personLinda.put(200000);
        personLinda.take(100);
        personLinda.getInformation();

        IndividualBusinessman personDavid = new IndividualBusinessman();
        personDavid.put(1000000);
        personDavid.put(300);
        personDavid.getInformation();

    }

}
