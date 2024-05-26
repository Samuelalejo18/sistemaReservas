package co.edu.konradlorenz.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.StubNotFoundException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ViewReservaPago extends JFrame{

    // Creación de los componentes a usar 
    private JPanel contentPane;
    private JPanel mainPanel;
    private JLabel lblImg;
    private JLabel lblImgCard;


    public ViewReservaPago() {
    	 setTitle("Payment Method");
         setSize(500, 300);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLocationRelativeTo(null);
         getContentPane().setLayout(new BorderLayout());
         
         // Header Panel
         JPanel headerPanel = new JPanel();
         headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
         headerPanel.add(new JLabel("Menu principal"));
         headerPanel.add(new JLabel(" | "));
         headerPanel.add(new JLabel("Detalles de hospedaje"));
         headerPanel.add(new JLabel(" | "));
         JLabel paymentMethodLabel = new JLabel("Payment method");
         paymentMethodLabel.setForeground(Color.BLUE);
         headerPanel.add(paymentMethodLabel);
         getContentPane().add(headerPanel, BorderLayout.NORTH);
         
         // Card Image Panel
         JPanel cardImagePanel = new JPanel();
         cardImagePanel.setLayout(new BoxLayout(cardImagePanel, BoxLayout.Y_AXIS));
         JLabel cardImageLabel = new JLabel(new ImageIcon("path/to/your/card/image.png"));
         cardImagePanel.add(cardImageLabel);
         getContentPane().add(cardImagePanel, BorderLayout.WEST);
         
         // Payment Details Panel
         JPanel paymentDetailsPanel = new JPanel();
         paymentDetailsPanel.setLayout(new GridLayout(5, 2, 5, 5));
         paymentDetailsPanel.setBorder(BorderFactory.createTitledBorder("Payment Details"));
         
         paymentDetailsPanel.add(new JLabel("Numero de Tarjeta:"));
         JTextField cardNumberField = new JTextField();
         paymentDetailsPanel.add(cardNumberField);
         
         paymentDetailsPanel.add(new JLabel("Propietario de la tarjeta:"));
         JTextField cardholderNameField = new JTextField();
         paymentDetailsPanel.add(cardholderNameField);
         
         paymentDetailsPanel.add(new JLabel("Fecha de vencimiento:"));
         JPanel expiryPanel = new JPanel();
         expiryPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
         JTextField expiryMonthField = new JTextField(2);
         JTextField expiryYearField = new JTextField(4);
         expiryPanel.add(expiryMonthField);
         expiryPanel.add(new JLabel("/"));
         expiryPanel.add(expiryYearField);
         paymentDetailsPanel.add(expiryPanel);
         
         paymentDetailsPanel.add(new JLabel("CVV:"));
         JTextField cvvField = new JTextField();
         paymentDetailsPanel.add(cvvField);
         
         // Buttons
         JPanel buttonPanel = new JPanel();
         buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
         JButton confirmButton = new JButton("CONFIRM AND PAY");
         confirmButton.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         	}
         });
         JButton cancelButton = new JButton("CANCEL");
         buttonPanel.add(confirmButton);
         buttonPanel.add(cancelButton);
         
         getContentPane().add(paymentDetailsPanel, BorderLayout.CENTER);
         getContentPane().add(buttonPanel, BorderLayout.SOUTH);
     }

     public static void main(String[] args) {
         SwingUtilities.invokeLater(() -> {
             new ViewReservaPago().setVisible(true);
         });
     }
}