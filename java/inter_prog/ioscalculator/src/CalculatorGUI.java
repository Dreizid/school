import javax.swing.*;   
import java.awt.*;
import java.text.DecimalFormat;

public class CalculatorGUI extends JFrame{

    JPanel buttons;
    JTextField textDisplay;
    CalculatorLogic mem;
    Font textFont;
    String currText;
    String tempText;
    int numCount;
    boolean DOT_ON = false;
    boolean CAN_OPERATE = false;

    public CalculatorGUI (){
        mem = new CalculatorLogic();
        tempText = "";
        currText = "";
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(350, 500);
        this.loadDisplay();
        this.loadOperations();
        this.loadUtility();
        this.loadNumbers();
        this.loadBottom();

    }

    public void loadDisplay() {
        Color displayColor = new Color(34, 33, 33);
        JPanel display = new JPanel();
        display.setPreferredSize(new Dimension(350, 150));
        display.setLayout(new BorderLayout());
        display.setBackground(displayColor);
        this.add(display, BorderLayout.NORTH);

        textFont = new Font("SANS_SERIF", Font.PLAIN, 70);
        textDisplay = new JTextField();
        textDisplay.setPreferredSize(new Dimension(350, 75));
        textDisplay.setBackground(displayColor);
        textDisplay.setForeground(Color.WHITE);
        textDisplay.setEditable(false);
        textDisplay.setBorder(null);
        textDisplay.setFont(textFont);
        textDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
        display.add(textDisplay, BorderLayout.SOUTH);

    }

    public void loadOperations() {
        // Panel
        JPanel operationsPanel = new JPanel();
        operationsPanel.setPreferredSize(new Dimension(85, 320));
        operationsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        operationsPanel.setBackground(Color.ORANGE);
        this.add(operationsPanel, BorderLayout.EAST);

        // Buttons
        String[] operations = {"÷", "×", "+", "-", "="}; 
        int NUMBEROFBUTTONS = operations.length;
        JButton[] operationsButtonList = new JButton[NUMBEROFBUTTONS];
        for (int i = 0; i < NUMBEROFBUTTONS; i++) {
            operationsButtonList[i] = new JButton(operations[i]);
            operationsButtonList[i].setPreferredSize(new Dimension(86, 62));
            operationsButtonList[i].setBackground(new Color(248,134,20));
            operationsButtonList[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.darkGray));
            operationsButtonList[i].setForeground(Color.WHITE);
            operationsButtonList[i].setFont(new Font("Arial", Font.PLAIN, 20));
            operationsPanel.add(operationsButtonList[i]);
            String currOp = operations[i];
            if (currOp == "=") {
                operationsButtonList[i].setPreferredSize(new Dimension(86, 64));
                operationsButtonList[i].addActionListener(e -> {
                    String result = mem.calculate();  
                    DOT_ON = false;
                    textDisplay.setText(handleDigitInput(result));
                });
            }
            else {
                operationsButtonList[i].addActionListener(e -> {
                    if (CAN_OPERATE == true) {
                        textDisplay.setText(textDisplay.getText() + currOp);
                        currText = textDisplay.getText();
                        tempText = "";
                        DOT_ON = false;
                        CAN_OPERATE = false;
                        numCount = 0;
                        mem.addToArray(currOp);
                    }
                });
            }
        }

        buttons = new JPanel();
        buttons.setLayout(new BorderLayout());
        this.add(buttons, BorderLayout.WEST);

    }

    public void loadUtility() {
        JPanel utilityPanel = new JPanel();
        utilityPanel.setPreferredSize(new Dimension(250, 64));
        utilityPanel.setLayout(new GridLayout(1, 3));
        utilityPanel.setBackground(Color.GRAY);
        buttons.add(utilityPanel, BorderLayout.NORTH);

        // Buttons
        String[] utilities = {"C", "+/-", "%"};
        int NUMBEROFUTILITY = utilities.length;
        JButton[] utilityButtonList = new JButton[NUMBEROFUTILITY];
        for (int i = 0; i < NUMBEROFUTILITY; i++) {
            utilityButtonList[i] = new JButton(utilities[i]);
            utilityButtonList[i].setBackground(new Color(219,220,222));
            utilityPanel.add(utilityButtonList[i]);
            String currSym = utilities[i];
            if (currSym.equals("C")) {
                utilityButtonList[i].addActionListener(e -> {
                    mem.clear();
                    tempText = "";
                    currText = "";
                    DOT_ON = false;
                    CAN_OPERATE = false;
                    textDisplay.setText("");
                    textDisplay.setFont(textFont);
                    
                });
            }
            else if (currSym.equals("+/-")) {
                utilityButtonList[i].addActionListener(e -> {
                    currText += "-";
                    textDisplay.setText("-" + textDisplay.getText());
                    mem.addToArray("neg");
                });
            }
            utilityButtonList[i].addActionListener(e -> {
                System.out.println(currSym);
            });
        }

    }

    public void loadNumbers() {
        JPanel numbers = new JPanel();
        numbers.setPreferredSize(new Dimension(250, 250));
        numbers.setLayout(new GridLayout(3, 3));
        buttons.add(numbers, BorderLayout.WEST);

        // Buttons
        int NUMBEROFNUMBUTTONS = 9;
        int addNum = NUMBEROFNUMBUTTONS + 1;
        JButton[] numbersButtonList = new JButton[NUMBEROFNUMBUTTONS];
        for (int i = 0; i < NUMBEROFNUMBUTTONS / 3; i++) {
            addNum -= 3;
            for (int num = addNum; num < addNum + 3; num++) {
                numbersButtonList[num - 1] = new JButton(String.valueOf(num));
                numbersButtonList[num - 1].setBackground(new Color(209,210,214));
                numbers.add(numbersButtonList[num - 1]);
                int currNum = num;
                numbersButtonList[num - 1].addActionListener(e -> {
                    tempText += String.valueOf(currNum);
                    textDisplay.setText(currText + handleDigitInput(tempText));
                    mem.addToArray(currNum);
                    CAN_OPERATE = true;
                    numCount++;
                });
            }
            
        }
    }

    public void loadBottom() {
        JPanel bottom = new JPanel();
        bottom.setPreferredSize(new Dimension(250, 64));
        bottom.setLayout(new GridBagLayout());
        bottom.setBackground(Color.BLACK);
        buttons.add(bottom, BorderLayout.SOUTH);

        GridBagConstraints cons = new GridBagConstraints();
        cons.fill = GridBagConstraints.BOTH;

        JButton zeroButton = new JButton("0");
        cons.weightx = 2.19;
        cons.weighty = 2.2;
        zeroButton.setBackground(new Color(209,210,214));
        zeroButton.addActionListener(e -> {
            tempText += String.valueOf("0");
            textDisplay.setText(currText + handleDigitInput(tempText));
            numCount++;
            mem.addToArray("0");
        });
        bottom.add(zeroButton, cons);
        JButton dotButton = new JButton(".");
        cons.weightx = 0.81;
        cons.weighty = 0.8;
        dotButton.setBackground(new Color(209,210,214));
        dotButton.addActionListener(e -> {
            if (DOT_ON == false && mem.memory.size() != 0 && numCount > 0) {
                DOT_ON = true;
                tempText += String.valueOf(".");
                textDisplay.setText(currText + handleDigitInput(tempText));
                mem.addToArray(".");
            }
        });
        bottom.add(dotButton, cons);


    }

    private String handleDigitInput(String number) {
        if (number.contains(",")) {
            number = number.replace(",", "");
        }
        double numericValue = Double.parseDouble(number);
        DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
        return decimalFormat.format(numericValue);
    }

    public static void main(String[] args) {
        CalculatorGUI gui = new CalculatorGUI();
        gui.setVisible(true);
    }
}