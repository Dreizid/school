import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;

public class Grading extends JFrame{
    final int NUMBER_OF_ACTIVITIES = 5;
    final int NUMBER_OF_LAB = 5;
    final int NUMBER_OF_LONGEXAM = 2;
    final Font TITLE_FONT = new Font("Courier New", Font.BOLD, 23);
    JTextField[] activities;
    JTextField[] labActivities;
    JTextField[] longExam;
    GridBagConstraints outerCons;
    GridBagConstraints innerCons;
    GridBagConstraints titleCons;
    GridBagConstraints buttonCons;
    double totalActivities;
    double totalLab;
    double totalExam;
    JLabel backgroundLabel;
    JLabel NORTH;
    JLabel SOUTH;
    JLabel EAST;
    JLabel WEST;

    public Grading() {
        activities = new JTextField[NUMBER_OF_ACTIVITIES];
        labActivities = new JTextField[NUMBER_OF_LAB];
        longExam = new JTextField[NUMBER_OF_LONGEXAM];

        // Inner constraints
        innerCons = new GridBagConstraints();
        innerCons.fill = GridBagConstraints.BOTH;
        innerCons.gridx = 0;
        innerCons.gridy = 1;
        innerCons.insets = new Insets(1, 1, 10, 5);

        // Outer constraints
        outerCons = new GridBagConstraints();
        outerCons.fill = GridBagConstraints.BOTH;
        outerCons.gridx = 0;
        outerCons.gridy = 0;
        outerCons.weightx = 1;
        outerCons.weighty = 1;

        // Title cons
        titleCons = new GridBagConstraints();
        titleCons.fill = GridBagConstraints.BOTH;
        titleCons.gridx = 0;
        titleCons.gridwidth = 2;
        titleCons.anchor = GridBagConstraints.CENTER;
        titleCons.insets = new Insets(1, 0, 20, 1);

        // Button cons
        buttonCons = new GridBagConstraints();
        buttonCons.gridx = 0;
        buttonCons.gridwidth = 2;
        buttonCons.anchor = GridBagConstraints.CENTER;
        buttonCons.insets = new Insets(15, 1, 1, 1);

        // Background
        NORTH = new JLabel(" ");
        SOUTH = new JLabel(" ");
        WEST = new JLabel(" ");
        EAST = new JLabel(" ");
        NORTH.setPreferredSize(new Dimension(0 ,150));
        SOUTH.setPreferredSize(new Dimension(0 ,150));
        WEST.setPreferredSize(new Dimension(175 ,0));
        EAST.setPreferredSize(new Dimension(175 ,0));
        setSize(new Dimension(650,700));
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        backgroundLabel = new JLabel(new ImageIcon("C:\\Users\\Andrei\\Desktop\\VScode\\School\\java\\inter_prog\\grading_system\\src\\background.jpg"));
        backgroundLabel.setLayout(new BorderLayout());
        add(backgroundLabel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeActivitiesPanel();
    }

    private void initializeActivitiesPanel() {
        // Initialize components
        JPanel activitiesPanel = new RoundedCornerPanel(20);
        JLabel activitiesTitle = new JLabel("Activities", SwingConstants.CENTER);
        activitiesTitle.setFont(TITLE_FONT);
        activitiesPanel.setPreferredSize(new Dimension(300, 300));    
        activitiesPanel.setLayout(new GridBagLayout());
        activitiesPanel.add(activitiesTitle, titleCons);
        for (int count = 0; count < NUMBER_OF_ACTIVITIES; count++) {
            JLabel number = new JLabel("Activity " + String.valueOf(count + 1));
            JTextField textField = new RoundJTextField(6);
            number.setFont(new Font("Arial", Font.PLAIN, 11));
            innerCons.gridx = 0;
            innerCons.gridy++;
            activitiesPanel.add(number, innerCons);
            innerCons.gridx = 1;
            activitiesPanel.add(textField, innerCons);
            activities[count] = textField;
        }
        JButton loadLab = new JButton("Next page");
        loadLab.setBackground(Color.WHITE);
        loadLab.addActionListener(e -> {
            if (computeActivities()) {
                activitiesPanel.setVisible(false);
                initializeLabPanel();
            }
        });
        buttonCons.gridy = innerCons.gridy + 1;
        activitiesPanel.add(loadLab, buttonCons);

        backgroundLabel.add(SOUTH, BorderLayout.SOUTH);
        backgroundLabel.add(NORTH, BorderLayout.NORTH);      
        backgroundLabel.add(EAST, BorderLayout.EAST);
        backgroundLabel.add(WEST, BorderLayout.WEST);
        backgroundLabel.add(activitiesPanel, BorderLayout.CENTER);
    }

    private void initializeLabPanel() {
        // Initialize components
        JPanel labPanel = new RoundedCornerPanel(20);
        JLabel labTitle = new JLabel("Lab", SwingConstants.CENTER);
        labTitle.setFont(TITLE_FONT);
        labPanel.setSize(300, 300);
        labPanel.setLayout(new GridBagLayout());
        labPanel.add(labTitle, titleCons);
        innerCons.weightx = 0;
        innerCons.gridx = 0;
        for (int count = 0; count < NUMBER_OF_LAB; count++) {
            JLabel number = new JLabel("Lab activity " + String.valueOf(count + 1));
            JTextField textField = new RoundJTextField(6);
            number.setFont(new Font("Arial", Font.PLAIN, 11));
            innerCons.gridx = 0;
            innerCons.gridy++;
            labPanel.add(number, innerCons);
            innerCons.gridx = 1;
            labPanel.add(textField, innerCons);
            labActivities[count] = textField;
        }

        JButton loadExam = new JButton("Next page");
        loadExam.setBackground(Color.WHITE);
        loadExam.addActionListener(e -> {
            if (computeLab()) {
                labPanel.setVisible(false);
                initializeExamPanel();
            }
        });
        buttonCons.gridy = innerCons.gridy + 1;
        labPanel.add(loadExam, buttonCons);

        
        backgroundLabel.add(labPanel, BorderLayout.CENTER);
    }

    private void initializeExamPanel () {
        // Initialize components
        JPanel examPanel = new RoundedCornerPanel(20);
        JLabel examTitle = new JLabel("Exams", SwingConstants.CENTER);
        examTitle.setFont(TITLE_FONT);
        examPanel.setLayout(new GridBagLayout());
        examPanel.setSize(300, 300);
        examPanel.add(examTitle, titleCons);
        for (int count = 0; count < NUMBER_OF_LONGEXAM; count++) {
            JLabel number = new JLabel("Exam " + String.valueOf(count + 1));
            JTextField textField = new RoundJTextField(6);
            number.setFont(new Font("Arial", Font.PLAIN, 11));
            number.setLabelFor(textField);
            innerCons.gridx = 0;
            innerCons.gridy++;
            examPanel.add(number, innerCons);
            innerCons.gridx = 1;
            examPanel.add(textField, innerCons);
            longExam[count] = textField;
        }
        JButton loadResult = new JButton("Next page");
        loadResult.setBackground(Color.WHITE);
        loadResult.addActionListener(e -> {
            if (computeExam()) {
                examPanel.setVisible(false);
                computeResults();
            }
        });
        buttonCons.gridy = innerCons.gridy + 1;
        examPanel.add(loadResult, buttonCons);
        
        backgroundLabel.add(examPanel, BorderLayout.CENTER);
    }

    private void initializeResults(String actGrade, String labGrade, String examGrade, String finalGrade, boolean failed) {
        String[] titles = {"Activity", "Lab Activity", "Long Exam", "Final"};
        String[] grades = {actGrade, labGrade, examGrade, finalGrade};
        JPanel resultsPanel = new RoundedCornerPanel(20);
        JPanel finalGradePanel = new JPanel();
        resultsPanel.setLayout(new GridBagLayout());
        finalGradePanel.setLayout(new GridBagLayout());
        TitledBorder border = BorderFactory.createTitledBorder("Final Grade");
        border.setTitleFont(new Font(Font.SERIF, Font.PLAIN, 20));
        finalGradePanel.setBorder(border);

        innerCons.gridy = 0;
        for (int i = 0; i < 3; i++) {
            innerCons.gridy++;
            JLabel titleLabel = new JLabel("Your " + titles[i] + " grade is:");
            titleLabel.setHorizontalAlignment(JLabel.CENTER);
            titleLabel.setFont(new Font(Font.SERIF, Font.PLAIN, 14));
            resultsPanel.add(titleLabel, innerCons);
            JLabel gradeLabel = new JLabel(grades[i]);
            gradeLabel.setFont(new Font(Font.SERIF, Font.BOLD, 17));
            gradeLabel.setHorizontalAlignment(JLabel.CENTER);
            innerCons.gridy++;
            resultsPanel.add(gradeLabel, innerCons);
        }
        innerCons.gridy++;
        JLabel titleLabel = new JLabel("Your " + titles[3] + " grade is " + grades[3]);
        titleLabel.setFont(new Font(Font.SERIF, Font.BOLD, 14));
        if (failed) {
            titleLabel = new JLabel("<html>Your " + titles[3] + " grade is " + "<font color='red'>" + grades[3]);
        }
        innerCons.insets = new Insets(10, 1, 10, 5);
        finalGradePanel.add(titleLabel, innerCons);
        resultsPanel.add(finalGradePanel, innerCons);

        backgroundLabel.add(resultsPanel, BorderLayout.CENTER);
        if (failed) {
            errorMessage();
        }
    }

    private boolean computeActivities () {
        String ERROR_MESSAGE = "Please input a valid number";
        try {
            totalActivities = 0;
            for (int actIndex = 0; actIndex < NUMBER_OF_ACTIVITIES; actIndex++) {
                totalActivities += Double.parseDouble(activities[actIndex].getText());
            }
            totalActivities /= NUMBER_OF_ACTIVITIES;
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(new JFrame(), ERROR_MESSAGE, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private boolean computeLab () {
        String ERROR_MESSAGE = "Please input a valid number";
        try {
            totalLab = 0;
            for (int labIndex = 0; labIndex < NUMBER_OF_LAB; labIndex++) {
                totalLab += Double.parseDouble(labActivities[labIndex].getText());
            }
            totalLab /= NUMBER_OF_LAB;
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(new JFrame(), ERROR_MESSAGE, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }  
    }

    private boolean computeExam () {
        String ERROR_MESSAGE = "Please input a valid number";
        try {
            totalExam = 0;
            for (int examIndex = 0; examIndex < NUMBER_OF_LONGEXAM; examIndex++) {
                totalExam += Double.parseDouble(longExam[examIndex].getText());
            }
            totalExam /= NUMBER_OF_LONGEXAM;
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(new JFrame(), ERROR_MESSAGE, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }  
    }

    public void computeResults() {
        final double ACTIVITIES_PERCENT = 0.3;
        final double LAB_PERCENT = 0.3;
        final double EXAM_PERCENT = 0.4;
        final double passingGrade = 70;

        double finalTotal = (totalActivities * ACTIVITIES_PERCENT) + (totalExam * EXAM_PERCENT) + (totalLab * LAB_PERCENT);

        initializeResults(String.valueOf(totalActivities), String.valueOf(totalLab), String.valueOf(totalExam), String.valueOf(finalTotal), finalTotal < passingGrade);
        
    }

    private void errorMessage () {
        String ERROR_MESSAGE = "You failed!";
        JOptionPane.showMessageDialog(new JFrame(), ERROR_MESSAGE, "Failed",
        JOptionPane.WARNING_MESSAGE);
    }

    public static void main(String[] args) {
        Grading grade = new Grading();
        grade.setLocationRelativeTo(null);
        grade.setVisible(true);
    }


}
