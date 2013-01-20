import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class OutputParser {
    public List<String> parse(List<Goods> goodsList) {
        List<String> outputList = new ArrayList<String>();
        DecimalFormat df = new DecimalFormat("0.00");
        for (Goods goods:goodsList){
            String priceWithTax = df.format(goods.getPriceWithTax());
            String output = goods.getAmount() + " " + goods.getName() + ": " + priceWithTax;
            outputList.add(output);
        }
        PriceCalculator calculator = new PriceCalculator();
        outputList.add("Sales Taxes: " + df.format(calculator.calculateTotalTax(goodsList)));
        outputList.add("Total: " + df.format(calculator.calculateTotalPriceWithTax(goodsList)));
        return outputList;
    }
}
