package Cars;

public enum AutoBrand {
    Tesla,
    Audi,
    BMW,
    Toyota,
    Nissan;

    public static AutoBrand getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
