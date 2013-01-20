import java.math.BigDecimal;
import java.util.List;

public class PriceCalculator {

    protected void calculatePriceWithTax(Goods goods) {
        double tax = calculateTax(goods);
        double priceWithTax =  goods.getAmount() * (goods.getPrice() + tax);
        goods.setPriceWithTax(priceWithTax);
    }

    public double calculateTax(Goods goods) {
        double tax = 0.0;
        if(!goods.getIsExemption()){
            tax = goods.getPrice() * TaxRate.COMMON;
        }
        if(goods.getIsImport()){
            tax += goods.getPrice() * TaxRate.IMPORT;
        }
        tax = (int) ((tax + 0.04)/5.0 * 100.0) / 100.0 * 5;
        BigDecimal bigDecimal = new BigDecimal(tax);
        bigDecimal =  bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        return bigDecimal.doubleValue();
    }

    public double calculateTotalTax(List<Goods> goodsList) {
        double totalTax = 0.0;
        for(Goods goods: goodsList){
            totalTax += calculateTax(goods);
        }
        return totalTax;
    }

    public double calculateTotalPriceWithTax(List<Goods> goodsList) {
        double totalPriceWithTax = 0.0;
        for(Goods goods : goodsList){
            calculatePriceWithTax(goods);
            totalPriceWithTax += goods.getPriceWithTax();
        }
        return totalPriceWithTax;
    }
}
