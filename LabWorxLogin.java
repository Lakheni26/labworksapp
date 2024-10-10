import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.util.HashMap;

public class LabWorxLogin {

    // Creates database to store users
    private static HashMap<String, String> usersDatabase = new HashMap<>();
    private static HashMap<String, String> lecturerDatabase = new HashMap<>();

    public static void main(String[] args) {

        // Student login details
        usersDatabase.put("student1", "password1");
        usersDatabase.put("student2", "password2");
        usersDatabase.put("Spha", "password123");
        usersDatabase.put("Lindiwe", "password222");
        usersDatabase.put("Bontle", "password2223");
        usersDatabase.put("Wandile", "password2");

        // Lecturer login credentials
        lecturerDatabase.put("Lungile_Mtshali", "lecturer123");
        lecturerDatabase.put("Noluthando_Ndlovu", "lecturer456");
        lecturerDatabase.put("Thandeka_Mtolo", "lecturer789");
        lecturerDatabase.put("Siyabonga_Ngqakayi", "lecturerABC");
        lecturerDatabase.put("Vuyiswa_Mafu", "lecturerDEF");
        lecturerDatabase.put("Sipho_Mdletshe", "lecturerXYZ");

        // Login page
        JFrame frame = new JFrame("LabWorx - Login");
        frame.setSize(750, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Username label and text field
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 30, 100, 30);
        frame.add(userLabel);

        JTextField userTextField = new JTextField();
        userTextField.setBounds(150, 30, 120, 30);
        frame.add(userTextField);

        // Password label and password field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 70, 100, 30);
        frame.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 70, 120, 30);
        frame.add(passwordField);

        // Login button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(120, 120, 80, 30);
        frame.add(loginButton);

        // Create Account button
        JButton createAccountButton = new JButton("Create Account");
        createAccountButton.setBounds(220, 120, 150, 30);
        frame.add(createAccountButton);

        // Login button action listener
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userTextField.getText();
                String password = new String(passwordField.getPassword());

                // Checking if user is a student
                if (usersDatabase.containsKey(username) && usersDatabase.get(username).equals(password)) {
                    JOptionPane.showMessageDialog(frame, "Student login successful!");
                    frame.dispose();
                    showExperimentSelection();
                }
                // Checking if user is a lecturer
                else if (lecturerDatabase.containsKey(username) && lecturerDatabase.get(username).equals(password)) {
                    JOptionPane.showMessageDialog(frame, "Lecturer login successful!");
                    frame.dispose();
                    showLecturerUploadPage();
                }
                // Invalid login
                else {
                    JOptionPane.showMessageDialog(frame, "Invalid login. Please try again.");
                }
            }
        });

        // Create Account button action listener
        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showSignUpPage(); // Open sign-up page
            }
        });

        frame.setVisible(true);
    }

    // Method to display experiment selection page for students
    public static void showExperimentSelection() {
        JFrame selectionFrame = new JFrame("LabWorx - Select Experiment");
        selectionFrame.setSize(400, 300);
        selectionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        selectionFrame.setLayout(null);

        // List of experiments with YouTube links
        String[] experiments = {"Experiment 1: Chemical Reaction", "Experiment 2: Titration",
                "Experiment 3: Electrolysis", "Experiment 4: Alcohol"};
        JList<String> experimentList = new JList<>(experiments);
        experimentList.setBounds(50, 30, 280, 120);
        selectionFrame.add(experimentList);

        // Select button
        JButton selectButton = new JButton("Watch Video");
        selectButton.setBounds(120, 200, 150, 30);
        selectionFrame.add(selectButton);

        // Button action listener for selecting an experiment and opening YouTube link
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedExperiment = experimentList.getSelectedValue();
                if (selectedExperiment != null) {
                    String videoLink = getYouTubeLink(selectedExperiment);
                    if (videoLink != null) {
                        openWebPage(videoLink);
                    }
                } else {
                    JOptionPane.showMessageDialog(selectionFrame, "Please select an experiment.");
                }
            }
        });

        selectionFrame.setVisible(true);
    }

    // Method to retrieve YouTube link
    public static String getYouTubeLink(String experiment) {
        switch (experiment) {
            case "Experiment 1: Chemical Reaction":
                return "https://www.youtube.com/watch?v=v93j92EQlbc";
            case "Experiment 2: Titration":
                return "https://www.youtube.com/watch?v=dZWxldXPIX8";
            case "Experiment 3: Electrolysis":
                return "https://www.youtube.com/watch?v=tCHE_7QeRUc";
            case "Experiment 4: Alcohol":
                return "https://www.youtube.com/watch?v=v93j92EQlbc";
            default:
                return null;
        }
    }

    // Method to open a webpage (YouTube link)
    public static void openWebPage(String url) {
        try {
            java.awt.Desktop.getDesktop().browse(URI.create(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to display lecturer upload page
    public static void showLecturerUploadPage() {
        JFrame uploadFrame = new JFrame("LabWorx - Lecturer Upload Page");
        uploadFrame.setSize(400, 300);
        uploadFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        uploadFrame.setLayout(null);

        // Label and text field for experiment title
        JLabel experimentLabel = new JLabel("Experiment:");
        experimentLabel.setBounds(50, 30, 100, 30);
        uploadFrame.add(experimentLabel);

        JTextField experimentField = new JTextField();
        experimentField.setBounds(150, 30, 120, 30);
        uploadFrame.add(experimentField);

        // Label and text field for YouTube link
        JLabel linkLabel = new JLabel("YouTube Link:");
        linkLabel.setBounds(50, 70, 100, 30);
        uploadFrame.add(linkLabel);

        JTextField linkField = new JTextField();
        linkField.setBounds(150, 70, 120, 30);
        uploadFrame.add(linkField);

        // Upload button
        JButton uploadButton = new JButton("Upload Video");
        uploadButton.setBounds(120, 120, 150, 30);
        uploadFrame.add(uploadButton);

        // Button action listener for uploading video link
        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String experiment = experimentField.getText();
                String link = linkField.getText();

                if (!experiment.isEmpty() && !link.isEmpty()) {
                    JOptionPane.showMessageDialog(uploadFrame, "Video for " + experiment + " uploaded successfully.");

                } else {
                    JOptionPane.showMessageDialog(uploadFrame, "Please provide both experiment title and YouTube link.");
                }
            }
        });

        uploadFrame.setVisible(true);
    }

    // Method to display the sign-up page
    public static void showSignUpPage() {
        JFrame signUpFrame = new JFrame("LabWorx - Create Account");
        signUpFrame.setSize(400, 300);
        signUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        signUpFrame.setLayout(null);

        // Label and text field for username
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 30, 100, 30);
        signUpFrame.add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(150, 30, 120, 30);
        signUpFrame.add(usernameField);

        // Label and password field for password
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 70, 100, 30);
        signUpFrame.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 70, 120, 30);
        signUpFrame.add(passwordField);

        // Sign-Up button
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(120, 120, 80, 30);
        signUpFrame.add(signUpButton);

        // Button action listener for signing up
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newUsername = usernameField.getText();
                String newPassword = new String(passwordField.getPassword());

                if (!newUsername.isEmpty() && !newPassword.isEmpty()) {
                    // Add user to the student or lecturer database based on the account type
                    usersDatabase.put(newUsername, newPassword);
                    JOptionPane.showMessageDialog(signUpFrame, "Account created successfully!");

                } else {
                    JOptionPane.showMessageDialog(signUpFrame, "Please enter both a username and password.");
                }
            }
        });

        signUpFrame.setVisible(true);
    }
}
