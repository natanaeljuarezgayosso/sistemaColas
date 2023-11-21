import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SistemaDeColas extends JFrame {
    private JTextField landa;
    private JTextField miu;
    private JTextField unidadmedida;
    private JTextArea resultados;

    public SistemaDeColas() {
        setTitle("Sistema de Colas - Interfaz Gráfica");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        landa = new JTextField();
        miu = new JTextField();
        unidadmedida = new JTextField();
        JButton calcularButton = new JButton("Calcular");
        resultados = new JTextArea();
        resultados.setEditable(false);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("Valor de landa: "));
        panel.add(landa);
        panel.add(new JLabel("Valor de miu: "));
        panel.add(miu);
        panel.add(new JLabel("Unidad de medida (dias, horas, minutos, segundos): "));
        panel.add(unidadmedida);
        panel.add(calcularButton);
        panel.add(new JLabel("Resultados: "));
        panel.add(new JScrollPane(resultados));

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularResultados();
            }
        });

        getContentPane().add(panel);
    }

    private void calcularResultados() {
        double landaValue = Double.parseDouble(landa.getText());
        double miuValue = Double.parseDouble(miu.getText());
        String unidadValue = unidadmedida.getText();

        double L = landaValue / (miuValue - landaValue);
        double Lq = Math.pow(landaValue, 2) / (miuValue * (miuValue - landaValue));
        double W = 1 / (miuValue - landaValue);
        double Wq = landaValue / (miuValue * (miuValue - landaValue));
        double Po = 1 - (landaValue / miuValue);
        double P = landaValue / miuValue;

        resultados.setText("L: " + L + " clientes esperando en el sistema.\n" +
                "Lq: " + Lq + " clientes esperando en la cola.\n" +
                "W: " + W + " " + unidadValue + " de espera en el sistema.\n" +
                "Wq: " + Wq + " " + unidadValue + " de espera en la cola.\n" +
                "Po: " + Po + "% de que esté desocupado el sistema.\n" +
                "P: " + P + " de que esté ocupado el sistema.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SistemaDeColas().setVisible(true);
            }
        });
    }
}
