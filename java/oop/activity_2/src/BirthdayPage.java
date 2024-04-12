import javax.swing.*;
import javax.swing.JSpinner.NumberEditor;

import java.awt.*;
import java.time.LocalDate;
import java.time.Period;

public class BirthdayPage extends BasePage{
    protected static int[] maxDate = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    protected static String[] months = {"January", "Febrary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    protected int month;
    protected int day;
    protected int year;

    protected LocalDate timeNow;

    protected JPanel topPanel;
    protected JPanel bottomPanel;

    protected SpinnerNumberModel dayModel;
    protected SpinnerNumberModel monthModel;
    protected SpinnerNumberModel yearModel;

    protected JSpinner daySpinner;
    protected JSpinner monthSpinner;
    protected JSpinner yearSpinner;

    protected NumberEditor editor;

    protected JLabel dateValue;
    protected JLabel userAgeLabel;

    protected static JLabel dayLabel = new JLabel("Day: ");
    protected static JLabel monthLabel = new JLabel("Month: ");
    protected static JLabel yearLabel = new JLabel("Year: ");

    public BirthdayPage() {
        setLayout(new BorderLayout());
        initComponents();
        loadLayout();
        addListeners();
    }

    @Override
    protected void initComponents() {
        timeNow = LocalDate.now();

        topPanel = new JPanel();
        bottomPanel = new JPanel();

        dayModel = new SpinnerNumberModel(1, 1, 31, 1);
        monthModel = new SpinnerNumberModel(1, 1, 12, 1);
        yearModel = new SpinnerNumberModel(2024, 1000, 3000, 1);

        daySpinner = new JSpinner(dayModel);
        monthSpinner = new JSpinner(monthModel);
        yearSpinner = new JSpinner(yearModel);

        day = timeNow.getDayOfMonth();
        month = timeNow.getMonthValue();
        year = timeNow.getYear();

        dateValue = new JLabel(String.format("%s %d, %d", months[month - 1], day, year));
        userAgeLabel = new JLabel("0 years");

        editor = new NumberEditor(yearSpinner, "####");
        yearSpinner.setEditor(editor);
    }

    @Override       
    protected void loadLayout() {
        add(topPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        topPanel.setLayout(new GridLayout(1, 6));
        topPanel.add(dayLabel);
        topPanel.add(daySpinner);

        topPanel.add(monthLabel);
        topPanel.add(monthSpinner);

        topPanel.add(yearLabel);
        topPanel.add(yearSpinner);

        bottomPanel.setLayout(new GridLayout(2, 0));
        bottomPanel.add(dateValue);
        bottomPanel.add(userAgeLabel);

    }

    @Override
    protected void addListeners() {
        daySpinner.addChangeListener(e -> {
            day = (int)daySpinner.getValue();
            updateValues();
        });
        monthSpinner.addChangeListener(e -> {
            month = (int)monthSpinner.getValue();
            dayModel.setMaximum(maxDate[month - 1]);
            daySpinner.setModel(dayModel);
            updateValues();
        });
        yearSpinner.addChangeListener(e -> {
            year = (int)yearSpinner.getValue();
            updateValues();
        });
    }

    protected void updateValues() {
        dateValue.setText(String.format("%s %d, %d", months[month - 1], day, year));
        LocalDate birthdate = LocalDate.of(year, month, day);
        Period age = Period.between(birthdate, timeNow);
        userAgeLabel.setText(String.valueOf(age.getYears()));
        
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new BirthdayPage());
        frame.setVisible(true);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
