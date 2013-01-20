import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class PriceCalculatorTest {

    private PriceCalculator calculator;
    private List<Goods> goodsList;

    @Before
    public void setUp() {
        calculator = new PriceCalculator();
        goodsList = new ArrayList<Goods>();
        goodsList.add(new Goods(1, "imported box of chocolates", 10.00, true, true));
        goodsList.add(new Goods(1, "imported bottle of perfume", 47.50, false, true));
    }

    @Test
    public void shouldGetCorrectTotalPriceWithTax() {
        double totalPriceWithTax =  calculator.calculateTotalPriceWithTax(goodsList);
        assertEquals(65.15, totalPriceWithTax, 0.001);
    }

    @Test
    public void shouldGetCorrectTotalTax() {
        double totalTax =  calculator.calculateTotalTax(goodsList);
        assertEquals(7.65, totalTax, 0.001);
    }

    @Test
    public void shouldGetCorrectPriceWithTax() {
        Goods notImportNotExemptionGoods = new Goods(1, "music CD", 14.99, false, false);

        calculator.calculatePriceWithTax(notImportNotExemptionGoods);
        double notImportNotExemptionGoodsPriceWithTax =  notImportNotExemptionGoods.getPriceWithTax();

        assertEquals(16.49, notImportNotExemptionGoodsPriceWithTax, 0.001);
    }

    @Test
    public void shouldGetCorrectTaxOfGoodsExemptionNotImport() {
        double expectTax = 0;
        Goods book = new Goods(1, "book", 12.49, true, false);
        double tax = calculator.calculateTax(book);
        Assert.assertEquals(expectTax, tax, 0.001);
    }

    @Test
    public void shouldGetCorrectTaxOfGoodsNotExemptionNotImport() {
        double expectTax = 1.5;
        Goods CD = new Goods(1, "music CD", 14.99, false, false);
        double tax = calculator.calculateTax(CD);
        Assert.assertEquals(expectTax, tax, 0.001);
    }

    @Test
    public void shouldGetCorrectTaxOfGoodsExemptionAndImport() {
        double expectTax = 0.5;
        Goods importedChocolates = new Goods(1, "imported box of chocolates", 10.00, true, true);
        double tax = calculator.calculateTax(importedChocolates);
        Assert.assertEquals(expectTax, tax, 0.001);
    }

    @Test
    public void shouldGetCorrectTaxOfGoodsImportNotExemption() {
        double expectTax = 7.15;
        Goods importedPerfume = new Goods(1, "imported bottle of perfume", 47.50, false, true);
        double tax = calculator.calculateTax(importedPerfume);
        Assert.assertEquals(expectTax, tax, 0.001);
    }
}
