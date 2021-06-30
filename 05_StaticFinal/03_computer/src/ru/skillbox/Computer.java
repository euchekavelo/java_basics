package ru.skillbox;

public class Computer {

    private Processor processor;
    private RandomAccessMemory randomAccessMemory;
    private HardDisk hardDisk;
    private Monitor monitor;
    private Keyboard keyboard;

    private final String vendor;
    private final String name;

    public Computer(Processor processor, RandomAccessMemory randomAccessMemory, HardDisk hardDisk,
                    Monitor monitor, Keyboard keyboard, String vendor, String name)
    {
        this.processor = processor;
        this.randomAccessMemory = randomAccessMemory;
        this.hardDisk = hardDisk;
        this.monitor = monitor;
        this.keyboard = keyboard;
        this.vendor = vendor;
        this.name = name;
    }

    public Processor getProcessor() {
        return processor;
    }

    public RandomAccessMemory getRandomAccessMemory() {
        return randomAccessMemory;
    }

    public HardDisk getHardDisk() {
        return hardDisk;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public String getVendor() {
        return vendor;
    }

    public String getName() {
        return name;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public void setRandomAccessMemory(RandomAccessMemory randomAccessMemory) {
        this.randomAccessMemory = randomAccessMemory;
    }

    public void setHardDisk(HardDisk hardDisk) {
        this.hardDisk = hardDisk;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }


    public String calculateTotalWeight()
    {
        double result = processor.getWeight() + randomAccessMemory.getWeight()
                + hardDisk.getWeight() + monitor.getWeight() + keyboard.getWeight();
        String roundedResult = String.format("%.2f", result) + " кг.";
        return roundedResult;
    }

    public String toString()
    {
        return "Название: " + name + "\n"
                + "Производитель: " + vendor +"\n"
                + "Компоненты:\n"
                + "1. Процессор.\n\t - частота: " + processor.getFrequency() + " МГц\n"
                            + "\t - количество ядер: " + processor.getCountCores() + "\n"
                            + "\t - производитель: " + processor.getVendor() + "\n"
                            + "\t - вес: " + processor.getWeight() + " кг.\n"
                + "2. Оперативная память.\n\t - тип: " + randomAccessMemory.getTypeRandomAccessMemory() + "\n"
                                        + "\t - объем: " + randomAccessMemory.getVolume() + " ГБ.\n"
                                        + "\t - вес: " + randomAccessMemory.getWeight() + " кг.\n"
                + "3. Жесткий диск.\n\t - тип: " + hardDisk.getTypeHardDisk() + "\n"
                                    +"\t - объем памяти: " + hardDisk.getMemorySize() + " ГБ.\n"
                                    +"\t - вес: " + hardDisk.getWeight() + " кг.\n"
                + "4. Экран.\n\t - диагональ: " + monitor.getDiagonal() + " дюйма\n"
                                + "\t - тип: " + monitor.getTypeMonitor() + "\n"
                                + "\t - вес: " + monitor.getWeight() + " кг.\n"
                + "5. Клавиатура.\n\t - тип: " + keyboard.getTypeKeyboard() + "\n"
                                    + "\t - наличие подсветки: " + keyboard.isPresenceBacklight() + "\n"
                                    + "\t - вес: " + keyboard.getWeight() + " кг.\n"
                + "Общий вес компьютера: " + calculateTotalWeight();
    }

}
