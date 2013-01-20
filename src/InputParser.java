import java.util.ArrayList;
import java.util.List;

public class InputParser {
    public Goods parseToGoods(String input) {
        int index = input.indexOf(" ");
        int amount = Integer.parseInt(input.substring(0, index));
        String inputInfo = input.substring(index, input.length()).trim();
        String[] inputStr = inputInfo.split(" at ");
        String goodsName = inputStr[0];
        double goodsPrice = Double.parseDouble(inputStr[1]);
        boolean isImport = false;
        if(inputStr[0].contains("imported")){
            isImport = true;
        }
        boolean isExemption = checkExemption(goodsName);
        Goods goods = new Goods(amount, goodsName, goodsPrice, isExemption, isImport);
        return goods;
    }

    private Boolean checkExemption(String goodsName) {
        for(ExemptionGoods exemptionGoods: ExemptionGoods.values()){
            if(exemptionGoods.getName().equals(goodsName)){
                return true;
            }
        }
        return false;
    }

    public List<Goods> parseToGoodsList(List<String> inputList) {
        List<Goods> goodsList = new ArrayList<Goods>();
        for(String input: inputList){
            goodsList.add(parseToGoods(input));
        }
        return goodsList;
    }
}
