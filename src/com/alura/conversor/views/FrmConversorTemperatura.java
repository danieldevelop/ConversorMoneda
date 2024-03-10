package com.alura.conversor.views;

//  Simbología de metodos visuales
//  -------------------------------
//    - CT: conversorTemperatura
//    - CTPanel: conversorTemperaturaPanel
//    - CTCabecera: conversorTemperaturaCabecera
//    - CTIngresarTemperatura: conversorTemperaturaIngresarTemperatura
//    - CTSeleccionarGradosTemperatura: conversorTemperaturaSeleccionarGradosTemperatura
//    - CTCalcularTemperatura: conversorTemperaturaCalcularTemperatura
//    - CTMostrarResultadoTemperatura: conversorTemperaturaMostrarResultadoTemperatura
//    - CTFooter: conversorTemperaturaFooter


import com.alura.conversor.temperatura.ConvertirTemperatura;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;

public class FrmConversorTemperatura extends JFrame {

    private JPanel panel;
    private JLabel lblImageHouse, lblTitulo, lblValorTemperatura, lblImageArrowRigth, lblTemperaturaConvertir,
            lblResultadoTemperatura, lblImageAluraOracle, lblCopyRight;
    private final ImageIcon imgHouse = new ImageIcon(getClass().getResource("/com/alura/conversor/images/house.png"));
    private JTextField txtValorTemperatura;
    private final ImageIcon imgArrowRigth = new ImageIcon(getClass().getResource("/com/alura/conversor/images/arrow_rigth.png"));
    private JComboBox cmbOpcionTemperatura;
    private DefaultComboBoxModel modelTemperaturas;
    private JButton btnConvertirTemperatura;
    private final ImageIcon imgAluraOracle = new ImageIcon(getClass().getResource("/com/alura/conversor/images/aluraoracle.png"));


    public FrmConversorTemperatura() {
        this.setTitle("Conversor de moneda  - Alura Challenges Oracle ONE");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(850, 540);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        initComponents();
    }

    private ImageIcon getScaleImage(ImageIcon image, JLabel lblImage) {
        return new ImageIcon(image.getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH));
    }

    private boolean esValorEntero(String valor) {
        String regex = "^([\\d]+)$";
        Pattern pt = Pattern.compile(regex);
        java.util.regex.Matcher mat = pt.matcher(valor);
        return mat.find();
    }

    private void CTPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        this.getContentPane().add(panel);
    }

    private void CTCabecera() {
        lblImageHouse = new JLabel();
        lblImageHouse.setBounds(30, 40, 24, 24);
        lblImageHouse.setIcon(getScaleImage(imgHouse, lblImageHouse));
        lblImageHouse.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(lblImageHouse);

        MouseListener volverHome = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                FrmHome frmHome = new FrmHome();
                frmHome.setVisible(true);
            }
        };
        lblImageHouse.addMouseListener(volverHome);

        lblTitulo = new JLabel("Conversor Temperatura");
        lblTitulo.setBounds(280, 40, 400, 30);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 25));
        lblTitulo.setForeground(Color.decode("#323336"));
        panel.add(lblTitulo);
    }

    private void CTIngresarTemperatura() {
        lblValorTemperatura = new JLabel("Ingrese la temperatura actual: ");
        lblValorTemperatura.setBounds(120, 100, 220, 40);
        lblValorTemperatura.setFont(new Font("Arial", Font.PLAIN, 15));
        lblValorTemperatura.setForeground(Color.decode("#323336"));
        panel.add(lblValorTemperatura);

        txtValorTemperatura = new JTextField();
        txtValorTemperatura.setBounds(120, 140, 250, 35);
        txtValorTemperatura.setFont(new Font("Arial", Font.PLAIN, 15));
        txtValorTemperatura.setBorder(BorderFactory.createLineBorder(Color.decode("#0AA06E"), 2, true));
        panel.add(txtValorTemperatura);
    }

    private void CTSeleccionarGradosTemperatura() {
        lblTemperaturaConvertir = new JLabel("Elija la temperatura a convertir");
        lblTemperaturaConvertir.setBounds(440, 100, 220, 40);
        lblTemperaturaConvertir.setFont(new Font("Arial", Font.PLAIN, 15));
        lblTemperaturaConvertir.setForeground(Color.decode("#323336"));
        panel.add(lblTemperaturaConvertir);

        String [] temperaturas = {
                "Celsius a Fahrenheit",
                "Fahrenheit a Celsius",
                "Celsius a Kelvin",
                "Kelvin a Celsius",
                "Fahrenheit a Kelvin",
                "Kelvin a Fahrenheit"
        };
        modelTemperaturas = new DefaultComboBoxModel(temperaturas);

        cmbOpcionTemperatura = new JComboBox(modelTemperaturas);
        cmbOpcionTemperatura.setBounds(440, 140, 250, 35);
        cmbOpcionTemperatura.setFont(new Font("Arial", Font.PLAIN, 15));
        cmbOpcionTemperatura.setBorder(BorderFactory.createLineBorder(Color.decode("#0AA06E"), 2,true));
        cmbOpcionTemperatura.setForeground(Color.decode("#323336"));
        cmbOpcionTemperatura.setBackground(Color.WHITE);
        panel.add(cmbOpcionTemperatura);
    }

    private void CTCalcularTemperatura() {
        btnConvertirTemperatura = new JButton("Convertir Grados");
        btnConvertirTemperatura.setBounds(300, 220, 200, 50);
        btnConvertirTemperatura.setFont(new Font("Arial", Font.BOLD, 15));
        btnConvertirTemperatura.setForeground(Color.WHITE);
        btnConvertirTemperatura.setBackground(Color.decode("#0AA06E"));
        btnConvertirTemperatura.setBorderPainted(true);
        btnConvertirTemperatura.setFocusPainted(false);
        btnConvertirTemperatura.setBorder(BorderFactory.createLineBorder(Color.decode("#0AA06E"), 1,true));
        btnConvertirTemperatura.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(btnConvertirTemperatura);

        ActionListener clickConvetirTemperatura = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtValorTemperatura.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(rootPane,
                            "Warning: Debe ingresar una temperatura a convertir",
                            "Conversor de Temperatuara - Alura Challenges Oracle ONE",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (!esValorEntero(txtValorTemperatura.getText())) {
                    JOptionPane.showMessageDialog(rootPane,
                            String.format("Error: El valor ingresado '%s' no es  válido", txtValorTemperatura.getText()),
                            "Conversor de Temperatuara - Alura Challenges Oracle ONE",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    int gradoTemperatura = Integer.parseInt(txtValorTemperatura.getText());
                    String opcionTemperatura = cmbOpcionTemperatura.getSelectedItem().toString().toLowerCase();

                    ConvertirTemperatura convertirTemperatura = new ConvertirTemperatura();

                    double resultado = 0;
                    switch (opcionTemperatura) {
                        case "celsius a fahrenheit":
                            resultado = convertirTemperatura.celsiusParaFahrenheit(gradoTemperatura);
                            lblResultadoTemperatura.setText(String.format("El resultado es: %.0f °F", resultado));
                            break;
                        case "fahrenheit a celsius":
                            resultado = convertirTemperatura.fahrenheitParaCelsius(gradoTemperatura);
                            lblResultadoTemperatura.setText(String.format("El resultado es: %.0f °C", resultado));
                            break;
                        case "celsius a kelvin":
                            resultado = convertirTemperatura.celsiusParaKelvin(gradoTemperatura);
                            lblResultadoTemperatura.setText(String.format("El resultado es: %.0f K", resultado));
                            break;
                        case "kelvin a celsius":
                            resultado = convertirTemperatura.kelvinParaCelsius(gradoTemperatura);
                            lblResultadoTemperatura.setText(String.format("El resultado es: %.0f °C", resultado));
                            break;
                        case "fahrenheit a kelvin":
                            resultado = convertirTemperatura.fahrenheitParaKelvin(gradoTemperatura);
                            lblResultadoTemperatura.setText(String.format("El resultado es: %.0f K", resultado));
                            break;
                        case "kelvin a fahrenheit":
                            resultado = convertirTemperatura.kelvinParaFahrenheit(gradoTemperatura);
                            lblResultadoTemperatura.setText(String.format("El resultado es: %.0f °F", resultado));
                            break;
                    }
                } catch(Exception ex) {
                    JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Conversor de Temperatuara  - Alura Challenges Oracle ONE", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        btnConvertirTemperatura.addActionListener(clickConvetirTemperatura);
    }

    private void CTMostrarResultadoTemperatura() {
        lblResultadoTemperatura = new JLabel("");
        lblResultadoTemperatura.setBounds(200, 300, 400, 40);
        lblResultadoTemperatura.setFont(new Font("Arial", Font.PLAIN, 20));
        lblResultadoTemperatura.setForeground(Color.decode("#323336"));
        lblResultadoTemperatura.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblResultadoTemperatura);
    }

    private void CTFooter() {
        lblImageAluraOracle = new JLabel();
        lblImageAluraOracle.setBounds(0, 410, 280, 100);
        lblImageAluraOracle.setIcon(getScaleImage(imgAluraOracle, lblImageAluraOracle));
        panel.add(lblImageAluraOracle);


        lblCopyRight = new JLabel("© 2022 Developer by Daniel Gomez");
        lblCopyRight.setBounds(600, 460, 220, 30);
        lblCopyRight.setFont(new Font("Arial", Font.PLAIN, 13));
        lblCopyRight.setForeground(Color.decode("#323336"));
        lblCopyRight.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblCopyRight);
    }

    public void initComponents() {
        CTPanel();
        CTCabecera();
        CTIngresarTemperatura();

        // Agregamos una flecha directamente aquí
        lblImageArrowRigth = new JLabel();
        lblImageArrowRigth.setBounds(390, 140, 32, 32);
        lblImageArrowRigth.setIcon(getScaleImage(imgArrowRigth, lblImageArrowRigth));
        panel.add(lblImageArrowRigth);

        CTSeleccionarGradosTemperatura();
        CTCalcularTemperatura();
        CTMostrarResultadoTemperatura();
        CTFooter();
    }
}