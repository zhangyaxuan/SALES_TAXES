import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class OutputParserTest {
    @Test
    public void testParse() throws Exception {
        List<Goods> goodsList = new ArrayList<Goods>();
        goodsList.add(new Goods(1, "imported box of chocolates", 10.00, true, true));
        goodsList.add(new Goods(1, "imported bottle of perfume", 47.50, false, true));
        List<String> expectedOutputList = new ArrayList<String>();
        expectedOutputList.add("1 imported box of chocolates: 10.50");
        expectedOutputList.add("1 imported bottle of perfume: 54.65");
        expectedOutputList.add("Sales Taxes: 7.65");
        expectedOutputList.add("Total: 65.15");

        PriceCalculator priceCalculator = new PriceCalculator();
        priceCalculator.calculateTotalPriceWithTax(goodsList);
        OutputParser outputParser = new OutputParser();
        List<String> outputList = outputParser.parse(goodsList);

        assertThat(outputList.size(), is(expectedOutputList.size()));
        assertThat(outputList.get(0), is(expectedOutputList.get(0)));
        assertThat(outputList.get(1), is(expectedOutputList.get(1)));
        assertThat(outputList.get(2), is(expectedOutputList.get(2)));
        assertThat(outputList.get(3), is(expectedOutputList.get(3)));
    }
}
