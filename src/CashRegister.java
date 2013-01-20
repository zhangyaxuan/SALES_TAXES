import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CashRegister {
    public static void main(String args[]) throws IOException {
        List<String> inputList = input();
        InputParser inputParser = new InputParser();
        List<Goods> goodsList = inputParser.parseToGoodsList(inputList);
        PriceCalculator calculator = new PriceCalculator();
        calculator.calculateTotalPriceWithTax(goodsList);
        OutputParser outputParser = new OutputParser();
        List<String> outputList = outputParser.parse(goodsList);
        output(outputList);
    }

    private static void output(List<String> outputList) {
        for (String output: outputList){
            System.out.println(output);
        }
    }

    private static List<String> input() {
        Scanner scanner = new Scanner(System.in);
        List<String> inputList = new ArrayList<String>();
        String input;
        while (! (input = scanner.nextLine()).isEmpty()){
            inputList.add(input);
        }
        return inputList;
    }
}
