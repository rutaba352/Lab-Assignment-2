import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Person Form with Banner");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        JLabel bannerLabel = new JLabel("Enter Information:");
        bannerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        bannerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        frame.add(bannerLabel);

        JPanel namePanel = new JPanel();
        namePanel.setLayout(new GridLayout(1, 2));
        namePanel.add(new JLabel("Name:"));
        JTextField nameField = new JTextField();
        namePanel.add(nameField);
        frame.add(namePanel);

        JPanel fatherNamePanel = new JPanel();
        fatherNamePanel.setLayout(new GridLayout(1, 2));
        fatherNamePanel.add(new JLabel("Father Name:"));
        JTextField fatherNameField = new JTextField();
        fatherNamePanel.add(fatherNameField);
        frame.add(fatherNamePanel);

        JPanel cnicPanel = new JPanel();
        cnicPanel.setLayout(new GridLayout(1, 2));
        cnicPanel.add(new JLabel("CNIC:"));
        JTextField cnicField = new JTextField();
        cnicPanel.add(cnicField);
        frame.add(cnicPanel);

        JPanel datePanel = new JPanel();
        datePanel.setLayout(new GridLayout(1, 2));
        SpinnerDateModel model = new SpinnerDateModel();
        JSpinner datePicker = new JSpinner(model);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(datePicker, "dd/MM/yyyy");
        datePicker.setEditor(editor);
        datePanel.add(new JLabel("Date (Picker):"));
        datePanel.add(datePicker);
        frame.add(datePanel);

        JPanel cityPanel = new JPanel();
        cityPanel.setLayout(new GridLayout(1, 2));
        cityPanel.add(new JLabel("City:"));
        JTextField cityField = new JTextField();
        cityPanel.add(cityField);
        frame.add(cityPanel);

        JPanel genderPanel = new JPanel();
        genderPanel.setLayout(new GridLayout(1, 2));
        genderPanel.add(new JLabel("Gender:"));
        JComboBox<String> genderBox = new JComboBox<>(new String[]{"Male", "Female"});
        genderPanel.add(genderBox);
        frame.add(genderPanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        JButton uploadButton = new JButton("Upload Image");
        JButton saveButton = new JButton("Save");
        buttonPanel.add(uploadButton);
        buttonPanel.add(saveButton);
        frame.add(buttonPanel);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String fatherName = fatherNameField.getText();
                String cnic = cnicField.getText();
                Date selectedDate = (Date) datePicker.getValue();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                String formattedDate = formatter.format(selectedDate);
                String city = cityField.getText();
                String gender = (String) genderBox.getSelectedItem();

                if (name.isEmpty() || fatherName.isEmpty() || cnic.isEmpty() || formattedDate.isEmpty() || city.isEmpty() || gender == null) {
                    JOptionPane.showMessageDialog(null, "Please enter all required data.");
                } else {
                    JOptionPane.showMessageDialog(null, "Data saved successfully!");
                    nameField.setText("");
                    fatherNameField.setText("");
                    cnicField.setText("");
                    datePicker.setValue(new Date());
                    cityField.setText("");
                    genderBox.setSelectedIndex(0);
                }
            }
        });

        frame.setVisible(true);
    }
}