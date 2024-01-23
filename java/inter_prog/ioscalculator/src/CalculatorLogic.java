import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculatorLogic {
    ArrayList<String> memory;
    ArrayList<String> multipication;
    ArrayList<String> division;
    ArrayList<String> addandsub;
    ArrayList<String> temporary;
    ArrayList<Integer> index;
    ArrayList<String> operators;

    public CalculatorLogic () {
        memory = new ArrayList<>();
        multipication = new ArrayList<>();
        division = new ArrayList<>();
        addandsub = new ArrayList<>();
        temporary = new ArrayList<>();
        index = new ArrayList<>();
    }

    public void addToArray (int x) {
        memory.add(String.valueOf(x));
    }

    public void addToArray (String x) {
        memory.add(x);
    }

    public void calculate () {
        System.out.println("Initial: ");
        for (String num: memory) {
            System.out.print(num);
        }
        System.out.println();
        this.findOperators();

            // Loop through the indices of the found operators
        while (memory.contains("×") || memory.contains("÷")) {
            for (int currIndex = 0; currIndex < index.size(); currIndex++) {
                // Check if current value of index is equal to the current operator
                if (memory.get(index.get(currIndex)) == "×"|| memory.get(index.get(currIndex)) == "÷") {
                    int start;
                    int end;
                    // Case for 1 expression ex. 3x5, 2x2, 5x5
                    if (index.size() == 1) {
                        start = 0;
                        end = memory.size();
                    }
                    // Case for multiple expression but operator is at the start ex. 3x5+2, 2x6-9
                    else if (currIndex == 0) {
                        start = 0;
                        end = index.get(currIndex + 1);
                    }
                    // Case for when the expression is at the end ex. 2+2x5, 6-8x2
                    else if (currIndex == index.size() - 1) {
                        start = index.get(currIndex - 1) + 1;
                        end = memory.size();
                    }
                    // Case in the middle ex. 3+3x6-9
                    else {
                        start = index.get(currIndex - 1);
                        end = index.get(currIndex + 1);
                    }
                    // Copy the selected indidices
                    for (int i = start; i < end; i++) {
                        temporary.add(memory.get(i));
                    }
                    String combined = String.join("", temporary);
                    ArrayList<String> split = new ArrayList<>(Arrays.asList(combined.split("[×÷\\+\\-]")));
                    double result = 0;
                    if (memory.get(index.get(currIndex)).equals("×")) {
                        result = multiply(split.get(0), split.get(1));
                    }
                    else if (memory.get(index.get(currIndex)).equals("÷")) {
                        result = div(split.get(0), split.get(1));
                    }

                    for (int i = start; i < end; i++) {
                        memory.remove(start);
                    }
                    memory.add(start ,String.valueOf(result));
                    System.out.println("Updated: ");
                    for (String num: memory) {
                        System.out.print(num);
                    }
                    temporary.clear();
                    System.out.println();
                    this.findOperators();
                }
            }
        }

        while (memory.contains("+") || memory.contains("-")) {
            for (int currIndex = 0; currIndex < index.size(); currIndex++) {
                // Check if current value of index is equal to the current operator
                int start;
                int end;
                // Case for 1 expression ex. 3x5, 2x2, 5x5
                if (index.size() == 1) {
                    start = 0;
                    end = memory.size();
                }
                // Case for multiple expression but operator is at the start ex. 3x5+2, 2x6-9
                else if (currIndex == 0) {
                    start = 0;
                    end = index.get(currIndex + 1);
                }
                // Case for when the expression is at the end ex. 2+2x5, 6-8x2
                else if (currIndex == index.size() - 1) {
                    start = index.get(currIndex - 1) + 1;
                    end = memory.size();
                }
                // Case in the middle ex. 3+3x6-9
                else {
                    start = index.get(currIndex - 1);
                    end = index.get(currIndex + 1);
                }
                // Copy the selected indidices
                for (int i = start; i < end; i++) {
                    temporary.add(memory.get(i));
                    System.out.print(memory.get(i));
                }
                String combined = String.join("", temporary);
                ArrayList<String> split = new ArrayList<>(Arrays.asList(combined.split("[×÷\\+\\-]")));
                double result = 0;
                if (memory.get(index.get(currIndex)).equals("+")) {
                    result = add(split.get(0), split.get(1));
                }
                else if (memory.get(index.get(currIndex)).equals("-")) {
                    result = subtract(split.get(0), split.get(1));
                }
                
                for (int i = start; i < end; i++) {
                    memory.remove(start);
                }
                memory.add(start ,String.valueOf(result));
                for (String num: memory) {
                    System.out.println("Memory: ");
                    System.out.print(num);
                }
                temporary.clear();
                System.out.println();
                this.findOperators();
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
        System.out.println("x: " + x + "y: " + y);
        double result = Double.parseDouble(x) - Double.parseDouble(y);
        return result;
    }
}

