import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class InputParserTest {

    private InputParser parser;

    @Before
    public void setUp() {
        parser=  new InputParser();
    }

    @Test
    public void shouldParseOneInputToOneGoods() throws Exception {
        Goods expectGoods = new Goods(1, "imported box of chocolates", 10.00, true, true);
        String inputStr = "1 imported box of chocolates at 10.00";

        Goods goods = parser.parseToGoods(inputStr);

        assertThat(goods, is(expectGoods));
    }

    @Test
    public void shouldParseInputListToGoodsList() {
        List<String> inputList = new ArrayList<String>();
        inputList.add("1 imported box of chocolates at 10.00");
        inputList.add("1 music CD at 14.99");
        List<Goods> expectGoodsList = new ArrayList<Goods>();
        expectGoodsList.add(new Goods(1, "imported box of chocolates", 10.00, true, true));
        expectGoodsList.add(new Goods(1, "music CD", 14.99, false, false));

        List<Goods> goodsList = parser.parseToGoodsList(inputList);

        assertThat(goodsList.size(), is(expectGoodsList.size()));
        assertThat(goodsList.get(0), is(expectGoodsList.get(0)));
        assertThat(goodsList.get(1), is(expectGoodsList.get(1)));
    }
}
