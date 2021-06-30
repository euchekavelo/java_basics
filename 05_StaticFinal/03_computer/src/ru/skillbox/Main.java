package ru.skillbox;

public class Main {

    public static void main(String[] args) {

        //Первый компьютер
        Processor processor = new Processor(2.4, CountCores.SIXTEEN_CORE, "Intel", 0.3);
        RandomAccessMemory randomAccessMemory = new RandomAccessMemory(TypeRandomAccessMemory.DDR4, 16, 0.15);
        HardDisk hardDisk = new HardDisk(TypeHardDisk.SSD, 512, 0.65);
        Monitor monitor = new Monitor(24.0, TypeMonitor.IPS, 4.2);
        Keyboard keyboard = new Keyboard(TypeKeyboard.MECHANICAL, true, 1.15);

        Computer computer = new Computer(processor, randomAccessMemory, hardDisk, monitor,
                                        keyboard, "Celeron Technology", "PC-1248");
        System.out.println("Компьютер №1");
        System.out.println(computer);
        System.out.println();


        //Второй компьютер
        Processor secondProcessor = new Processor(2.7, CountCores.OCTA_CORE, "AMD", 0.35);
        RandomAccessMemory secondRandomAccessMemory = new RandomAccessMemory(TypeRandomAccessMemory.DDR3, 8, 0.21);
        HardDisk secondHardDisk = new HardDisk(TypeHardDisk.SSD, 512, 0.65);
        Monitor secondMonitor = new Monitor(23.4, TypeMonitor.VA, 3.8);
        Keyboard secondKeyboard = new Keyboard(TypeKeyboard.MEMBRANE, false, 0.9);

        Computer secondComputer = new Computer(secondProcessor, secondRandomAccessMemory, secondHardDisk, secondMonitor,
                secondKeyboard, "AMD Technology", "PC-1500");
        System.out.println("Компьютер №2");
        System.out.println(secondComputer);
        System.out.println();


        //Третий компьютер
        Processor thirdProcessor = new Processor(1.8, CountCores.QUAD_CORE, "Toshiba", 0.25);
        RandomAccessMemory thirdRandomAccessMemory = new RandomAccessMemory(TypeRandomAccessMemory.DDR3, 8, 0.24);
        HardDisk thirdHardDisk = new HardDisk(TypeHardDisk.HDD, 2048, 1.3);
        Monitor thirdMonitor = new Monitor(17.3, TypeMonitor.TN, 2.73);
        Keyboard thirdKeyboard = new Keyboard(TypeKeyboard.MEMBRANE, false, 0.75);

        Computer thirdComputer = new Computer(thirdProcessor, thirdRandomAccessMemory, thirdHardDisk, thirdMonitor,
                thirdKeyboard, "Toshiba Technology", "Toshiba1200");
        System.out.println("Компьютер №3");
        System.out.println(thirdComputer);
        System.out.println();

    }
}
