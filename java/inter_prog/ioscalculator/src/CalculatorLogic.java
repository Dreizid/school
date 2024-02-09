import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculatorLogic {
    ArrayList<String> memory;
    ArrayList<String> temporary;
    ArrayList<Integer> index;
    ArrayList<String> operators;

    public CalculatorLogic () {
        memory = new ArrayList<>();
        temporary = new ArrayList<>();
        index = new ArrayList<>();
    }

    public void addToArray (int x) {
        memory.add(String.valueOf(x));
    }

    public void addToArray (String x) {
        memory.add(x);
    }

    public String calculate () {
        this.findOperators();
        mdas("×", "÷");
        mdas("+", "-");

        return removeZero(memory.get(0));
    }

    public void mdas(String operator1, String operator2) {
        while (memory.contains(operator1) || memory.contains(operator2)) {
            for (int currIndex = 0; currIndex < index.size(); currIndex++) {
                if (memory.get(index.get(currIndex)) == operator1 || memory.get(index.get(currIndex)) == operator2) {
                    int start;
                    int end;
                    if (index.size() == 1) {
                        start = 0;
                        end = memory.size();
                    }
                    else if (currIndex == 0) {
                        start = 0;
                        end = index.get(currIndex + 1);
                    }
                    else if (currIndex == index.size() - 1) {
                        start = index.get(currIndex - 1) + 1;
                        end = memory.size();
                    }
                    else {
                        start = index.get(currIndex - 1) + 1;
                        end = index.get(currIndex + 1);
                    }
                    for (int i = start; i < end; i++) {
                        temporary.add(memory.get(i));
                    }
                    String combined = String.join("", temporary);
                    ArrayList<String> split = new ArrayList<>(Arrays.asList(combined.split("[×÷\\+\\-]")));
                    double result = 0;
                    if (memory.get(index.get(currIndex)).equals("×")) {
                        result = multiply(replaceNeg(split.get(0)), replaceNeg(split.get(1)));
                    }
                    else if (memory.get(index.get(currIndex)).equals("÷")) {
                        result = div(replaceNeg(split.get(0)), replaceNeg(split.get(1)));
                    }
                    else if (memory.get(index.get(currIndex)).equals("+")) {
                        result = add(replaceNeg(split.get(0)), replaceNeg(split.get(1)));
                    }
                    else if (memory.get(index.get(currIndex)).equals("-")) {
                        result = subtract(replaceNeg(split.get(0)), replaceNeg(split.get(1)));
                    }
                    
                    for (int i = start; i < end; i++) {
                        memory.remove(start);
                    }
                    memory.add(start ,String.valueOf(result));
                    temporary.clear();
                    this.findOperators();
                }
            }
        }
    }

    public void clear() {
        memory.clear();
        index.clear();
        temporary.clear();
    }

    public void findOperators() {
        ArrayList<String> operators = new ArrayList<>(Arrays.asList("×", "÷", "+", "-"));
        index.clear();
        for (int i = 0; i < memory.size(); i++) {
            String current = memory.get(i);
            if (operators.contains(current)) {
                index.add(i);
            }
        }
    }

    public String removeZero(String answer) {
        String[] wholeNumber = answer.split("\\.");
        String decimal = wholeNumber[1];
        int total = 0;
        for (int i = 0; i < wholeNumber[1].length(); i++) {
            total += Character.getNumericValue(decimal.charAt(i));
        }
        if (total <= 0) {
            return String.valueOf((int)Double.parseDouble(answer));
        } 
        return answer;
    }

    public String replaceNeg(String x) {
        if (x.contains("neg")) {
            x = x.replace("neg", "");
            x = String.valueOf(Double.parseDouble(x) - (Double.parseDouble(x) * 2));
        }
        return x;
    }


    public double multiply(String x, String y) {
        double result = Double.parseDouble(x) * Double.parseDouble(y);
        return result;
    }

    public double div(String x, String y) { 
        double result = Double.parseDouble(x) / Double.parseDouble(y);
        return result;
    }

    public double add(String x, String y) { 
        double result = Double.parseDouble(x) + Double.parseDouble(y);
        return result;
    }

    public double subtract(String x, String y) { 
        double result = Double.parseDouble(x) - Double.parseDouble(y);
        return result;
    }
}

