mport javax.swing.*;
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
