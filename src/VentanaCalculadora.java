import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class VentanaCalculadora extends JFrame {
    private JTextField campoResultado;
    private JTextField campoEntrada;
    private Calculator calculadora;
    private CalculatorInvoker invocador;

    public VentanaCalculadora() {
        setTitle("Calculadora  - Memento y Command");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        calculadora = new Calculator();
        invocador = new CalculatorInvoker(calculadora);

        campoResultado = new JTextField("0");
        campoResultado.setFont(new Font("Arial", Font.BOLD, 24));
        campoResultado.setHorizontalAlignment(JTextField.RIGHT);
        campoResultado.setEditable(false);

        campoEntrada = new JTextField();
        campoEntrada.setFont(new Font("Arial", Font.PLAIN, 20));

        JPanel panelBotones = new JPanel(new GridLayout(2, 4, 5, 5));

        panelBotones.add(crearBoton("+", e -> aplicarOperacion(new AddCommand(calculadora, obtenerEntrada()))));
        panelBotones.add(crearBoton("-", e -> aplicarOperacion(new SubtractCommand(calculadora, obtenerEntrada()))));
        panelBotones.add(crearBoton("*", e -> aplicarOperacion(new MultiplyCommand(calculadora, obtenerEntrada()))));
        panelBotones.add(crearBoton("/", e -> aplicarOperacion(new DivideCommand(calculadora, obtenerEntrada()))));
        panelBotones.add(crearBoton("C", e -> aplicarOperacion(new ClearCommand(calculadora))));
        panelBotones.add(crearBoton("Deshacer", e -> {
            invocador.undo();
            actualizarResultado();
        }));
        panelBotones.add(crearBoton("Rehacer", e -> {
            invocador.redo();
            actualizarResultado();
        }));

        add(campoResultado, BorderLayout.NORTH);
        add(campoEntrada, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        setVisible(true);
    }

    private JButton crearBoton(String texto, ActionListener listener) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Arial", Font.BOLD, 16));
        boton.addActionListener(listener);
        return boton;
    }

    private double obtenerEntrada() {
        try {
            return Double.parseDouble(campoEntrada.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido.");
            return 0.0;
        }
    }

    private void aplicarOperacion(Command comando) {
        invocador.executeCommand(comando);
        actualizarResultado();
    }

    private void actualizarResultado() {
        campoResultado.setText(String.valueOf(calculadora.getValue()));
    }
}
