public class Goods {
    private String name;
    private double price;
    private double priceWithTax;
    private boolean isExemption;
    private boolean isImport;
    private int amount;

    public Goods(int amount, String name, double price, boolean isExemption, boolean isImport) {
        this.amount = amount;
        this.name = name;
        this.price = price;
        this.isExemption = isExemption;
        this.isImport = isImport;
    }

    public boolean getIsExemption() {
        return isExemption;
    }

    public boolean getIsImport() {
        return isImport;
    }


    public double getPrice() {
        return price;
    }

    public double getPriceWithTax() {
        return priceWithTax;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Goods goods = (Goods) o;

        if (isExemption != goods.isExemption) return false;
        if (isImport != goods.isImport) return false;
        if (Double.compare(goods.price, price) != 0) return false;
        if (name != null ? !name.equals(goods.name) : goods.name != null) return false;
        if (amount != goods.amount) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = price != +0.0d ? Double.doubleToLongBits(price) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (isExemption ? 1 : 0);
        result = 31 * result + (isImport ? 1 : 0);
        return result;
    }

    public void setPriceWithTax(double priceWithTax) {
        this.priceWithTax = priceWithTax;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }
}
