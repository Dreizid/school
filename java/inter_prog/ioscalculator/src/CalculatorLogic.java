import java.util.ArrayList; 

public class CalculatorLogic {
    ArrayList<String> memory;
    ArrayList<String> multipication;
    ArrayList<String> division;
    ArrayList<String> addandsub;
    ArrayList<String> temporary;
    ArrayList<Integer> index;

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
        for (int i = 0; i < memory.size(); i++) {
            String current = memory.get(i);
            if (current == "÷" || current == "x" || current == "-" || current == "+") {
                index.add(i);
            }
        }
        for (int i = 0; i < index.size(); i++) {
            if (memory.get(index.get(i)) == "x") {

            }
        }
        
    }

    public double multiply(String x, String y) {
        double result = Double.parseDouble(x) * Double.parseDouble(y);
        return result;
    }
}
