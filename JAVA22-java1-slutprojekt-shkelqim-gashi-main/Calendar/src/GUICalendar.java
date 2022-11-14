import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.time.LocalDate;

/**
 * GUICalendar klassen innehåller en veckokalender med datum, veckodag samt funktioner för att lägga till/ta bort anteckningar
 */

public class GUICalendar extends JFrame {
    private JPanel dayPanel;
    private JTextField dayTF;
    private JButton dayButton, deleteButton;
    private JLabel[] noteLabelArr;


    GUICalendar() {
        super.setTitle("Calendar");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(new GridLayout());
        super.setSize(800, 600);
        ImageIcon image = new ImageIcon("image.webp");
        super.setIconImage(image.getImage());


        for (int i = 1; i < 8; i++) {
            PanelLayout();
            DayOfWeek(i);
            DayDate(i);
            noteLabels();
            dayTF();
            dayButton();
            fillNoteLabels(dayButton, dayTF, noteLabelArr);
            deleteButton();
            deleteNoteLabels(deleteButton, noteLabelArr);
            coloredDay(i);
        }
        super.setVisible(true);
    }

    void PanelLayout() {
        dayPanel = new JPanel();
        dayPanel.setBackground(Color.decode("#e6e6e6"));
        dayPanel.setLayout(new GridLayout(10, 1));
        super.add(dayPanel);
    }

    void DayOfWeek(int i) {
        dayPanel.add(new JLabel(String.valueOf(DateAndDay.calculateDayOfWeek(i)), SwingConstants.CENTER));
    }

    void DayDate(int i) {
        dayPanel.add(new JLabel(String.valueOf(DateAndDay.calculateDate(i)), SwingConstants.CENTER));
    }

    void noteLabels() {
        noteLabelArr = new JLabel[5];
        for (int i = 0; i < 5; i++) {
            JLabel noteLabel = new JLabel();
            noteLabelArr[i] = noteLabel;


            Border border = new LineBorder(Color.decode("#808080"), 2, true);
            noteLabel.setBorder(border);
            dayPanel.add(noteLabel);
        }
    }

    void dayTF() {
        dayTF = new JTextField("");
        dayPanel.add(dayTF);
    }

    void dayButton() {
        dayButton = new JButton("Add");
        dayPanel.add(dayButton);
    }

    void fillNoteLabels(JButton dayButton, JTextField dayTF, JLabel[] noteLabelArr) {
        dayButton.addActionListener(e -> {
            for (int i = 0; i < 5; i++) {
                if (noteLabelArr[i].getText().length() == 0) {
                    noteLabelArr[i].setText(dayTF.getText());
                    break;
                }
            }
        });
    }

    void deleteButton() {
        deleteButton = new JButton("Delete");
        dayPanel.add(deleteButton);
    }

    void deleteNoteLabels(JButton deleteButton, JLabel [] noteLabelArr) {
        deleteButton.addActionListener(e -> {
            for (int i = 0; i < 5; i++) {
                if (noteLabelArr[i].getText().length() > 0) {
                    noteLabelArr[i].setText("");
                    break;
                }
            }
        });
    }

    void coloredDay(int i) {
        int actualDay = LocalDate.now().getDayOfWeek().getValue();

        if (i == actualDay) {
            super.add(dayPanel).setBackground(Color.decode("#b3b3cc"));
        }
    }


}

