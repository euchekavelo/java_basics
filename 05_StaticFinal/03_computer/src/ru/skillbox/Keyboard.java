package ru.skillbox;

public class Keyboard {

    private final TypeKeyboard typeKeyboard; //Тип клавиатуры
    private final boolean presenceBacklight; //Наличие подсветки
    private final double weight; //Вес

    public Keyboard(TypeKeyboard typeKeyboard, boolean presenceBacklight, double weight) {
        this.typeKeyboard = typeKeyboard;
        this.presenceBacklight = presenceBacklight;
        this.weight = weight;
    }

    public TypeKeyboard getTypeKeyboard() {
        return typeKeyboard;
    }

    public boolean isPresenceBacklight() {
        return presenceBacklight;
    }

    public double getWeight() {
        return weight;
    }
}
