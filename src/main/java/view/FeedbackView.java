package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FeedbackView extends JDialog {
    public FeedbackView(JDialog parent, String title, String message) {
        super(parent, title);
        setLayout(new BorderLayout());
        setResizable(false);
        setLocationRelativeTo(parent);

        //Message Label
        JLabel messageLabel = new JLabel(message, SwingConstants.CENTER);
        messageLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        //OK Button
        JButton okButton = new JButton("OK");
        okButton.addActionListener((ActionEvent e) -> dispose());
        JPanel buttonPanel = new JPanel();
        okButton.setBackground(Color.WHITE);
        okButton.setFocusPainted(false);
        buttonPanel.add(okButton);

        //INIT
        add(messageLabel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }
}