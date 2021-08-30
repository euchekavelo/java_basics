public class Main {

    public static void main(String[] args) {
        ReceivingPictures receivingPictures = new ReceivingPictures("https://lenta.ru/");
        receivingPictures.getImagesFromTheSite();
    }

}
