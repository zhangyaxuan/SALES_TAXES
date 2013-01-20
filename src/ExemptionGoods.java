public enum ExemptionGoods {
    BOOK("book"),
    BOX_OF_CHOCOLATES("imported box of chocolates"),
    CHOCOLATE_BAR("chocolate bar"),
    HEADACHE_PILL("packet of headache pills");

    public String getName() {
        return name;
    }

    String name;
    ExemptionGoods(String name) {
        this.name = name;
    }
}
