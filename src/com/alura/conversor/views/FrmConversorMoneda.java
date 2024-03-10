package com.alura.conversor.views;

//  Simbología de metodos visuales
//  -------------------------------
//    - CM: conversorMoneda
//    - CMPanel: conversorMonedaPanel
//    - CMCebecera: conversorMonedaCabaecera
//    - CMIngresarCantidadDinero: conversorMonedaIngresarCantidadDinero
//    - CMSeleccionarMoneda: conversorMonedaSeleccionarMoneda
//    - CMCalcularConversion: conversorMonedaCalcularConversion
//    - CMMostrarResultadoConversion: conversorMonedaMostrarResultadoConversion
//    - CMFooter: conversorMonedaFooter

import com.alura.conversor.moneda.ConvetirMoneda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;


public class FrmConversorMoneda extends JFrame {

    private JPanel panel;
    private JLabel lblImageHouse, lblTitulo, lblCantidadDinero, lblMonedaConvertir, lblResultadoConversion, lblImageAluraOracle, lblCopyRight;
    private final ImageIcon imgHouse = new ImageIcon(getClass().getResource("/com/alura/conversor/images/house.png"));
    private JTextField txtCantidadDinero;
    private JComboBox cmbOpcionMoneda;
    private DefaultComboBoxModel modelMonedas;
    private JButton btnConvertirMoneda;
    private final ImageIcon imgAluraOracle = new ImageIcon(getClass().getResource("/com/alura/conversor/images/aluraoracle.png"));


    public FrmConversorMoneda() {
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

    private boolean esValorDecimal(String valor) {
        String regex = "^([\\d]*(?:[\\.]?[\\d]+)+)$";
        Pattern pt = Pattern.compile(regex);
        java.util.regex.Matcher mat = pt.matcher(valor);
        return mat.find();
    }

    private boolean esValorDecimalNegativo(String valor) {
        String regex = "^([-]?[\\d]*(?:[\\.]?[\\d]+)+)$";
        Pattern pt = Pattern.compile(regex);
        java.util.regex.Matcher mat = pt.matcher(valor);
        return mat.find();
    }

    private boolean esValorEntero(String valor) {
        String regex = "^([\\d]+)$";
        Pattern pt = Pattern.compile(regex);
        java.util.regex.Matcher mat = pt.matcher(valor);
        return mat.find();
    }

    private void CMPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        this.getContentPane().add(panel);
    }

    private void CMCabecera() {
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

        lblTitulo = new JLabel("Conversor Monedas");
        lblTitulo.setBounds(300, 40, 400, 30);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 25));
        lblTitulo.setForeground(Color.decode("#323336"));
        panel.add(lblTitulo);

    }

    private void CMIngresarCantidadDinero() {
        lblCantidadDinero = new JLabel("Ingrese la cantidad de dinero:");
        lblCantidadDinero.setBounds(100, 100, 200, 40);
        lblCantidadDinero.setFont(new Font("Arial", Font.PLAIN, 15));
        lblCantidadDinero.setForeground(Color.decode("#323336"));
        panel.add(lblCantidadDinero);

        txtCantidadDinero = new JTextField();
        txtCantidadDinero.setBounds(100, 140, 300, 35);
        txtCantidadDinero.setFont(new Font("Arial", Font.PLAIN, 15));
        txtCantidadDinero.setBorder(BorderFactory.createLineBorder(Color.decode("#0AA06E"), 2,true));
        panel.add(txtCantidadDinero);
    }

    private void CMSeleccionarMoneda() {
        lblMonedaConvertir = new JLabel("Elija la moneda a convertir: ");
        lblMonedaConvertir.setBounds(430, 100, 200, 40);
        lblMonedaConvertir.setFont(new Font("Arial", Font.PLAIN, 15));
        lblMonedaConvertir.setForeground(Color.decode("#323336"));
        panel.add(lblMonedaConvertir);

        String [] monedas = {
                "Pesos a Dolares", "Pesos a Euro", "Pesos a Libras", "Pesos a Yen", "Pesos a Won Coreano",
                "Dolares a Pesos", "Euro a Pesos", "Libras a Pesos", "Yen a Pesos", "Won Coreano a Pesos"
        };
        modelMonedas = new DefaultComboBoxModel(monedas);

        cmbOpcionMoneda = new JComboBox(modelMonedas);
        cmbOpcionMoneda.setBounds(430, 140, 300, 35);
        cmbOpcionMoneda.setFont(new Font("Arial", Font.PLAIN, 15));
        cmbOpcionMoneda.setBorder(BorderFactory.createLineBorder(Color.decode("#0AA06E"), 2,true));
        cmbOpcionMoneda.setForeground(Color.decode("#323336"));
        cmbOpcionMoneda.setBackground(Color.WHITE);
        panel.add(cmbOpcionMoneda);
    }

    private void CMCalcularConversion() {
        btnConvertirMoneda = new JButton("Convertir Moneda");
        btnConvertirMoneda.setBounds(300, 220, 200, 50);
        btnConvertirMoneda.setFont(new Font("Arial", Font.BOLD, 15));
        btnConvertirMoneda.setForeground(Color.WHITE);
        btnConvertirMoneda.setBackground(Color.decode("#0AA06E"));
        btnConvertirMoneda.setBorderPainted(true);
        btnConvertirMoneda.setFocusPainted(false);
        btnConvertirMoneda.setBorder(BorderFactory.createLineBorder(Color.decode("#0AA06E"), 1,true));
        btnConvertirMoneda.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(btnConvertirMoneda);

        ActionListener clickConvertirMoneda = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtCantidadDinero.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(rootPane,
                            "Warning: Debe ingresar la cantidad de dinero a convertir",
                            "Conversor de moneda  - Alura Challenges Oracle ONE",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (!esValorDecimal(txtCantidadDinero.getText())|| !esValorDecimalNegativo(txtCantidadDinero.getText())) {
                    JOptionPane.showMessageDialog(rootPane,
                            String.format("Error: El valor ingresado '%s' no es  válido", txtCantidadDinero.getText()),
                            "Conversor de moneda  - Alura Challenges Oracle ONE",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    double cantidadDinero = Double.parseDouble(txtCantidadDinero.getText());
                    String opcionMoneda = cmbOpcionMoneda.getSelectedItem().toString().toLowerCase();
                    double resultado = 0;

                    ConvetirMoneda convertirMoneda = new ConvetirMoneda();

                    switch (opcionMoneda) {
                        case "pesos a dolares" -> resultado = convertirMoneda.PesosADolares(cantidadDinero);
                        case "pesos a euro" -> resultado = convertirMoneda.PesosAEuro(cantidadDinero);
                        case "pesos a libras" -> resultado = convertirMoneda.PesosALibra(cantidadDinero);
                        case "pesos a yen" -> resultado = convertirMoneda.PesosAYen(cantidadDinero);
                        case "pesos a won coreano" -> resultado = convertirMoneda.PesosAWonCoreano(cantidadDinero);
                        case "dolares a pesos" -> resultado = convertirMoneda.DolaresAPesos(cantidadDinero);
                        case "euro a pesos" -> resultado = convertirMoneda.EuroAPesos(cantidadDinero);
                        case "libras a pesos" -> resultado = convertirMoneda.LibreAPesos(cantidadDinero);
                        case "yen a pesos" -> resultado = convertirMoneda.YenAPesos(cantidadDinero);
                        case "won coreano a pesos" -> resultado = convertirMoneda.WonCoreanoAPesos(cantidadDinero);
                    };
                    lblResultadoConversion.setText(String.format("Tienes $%.2f moneda", resultado));

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(rootPane,
                            String.format("Error: El valor ingresado '%s' no es  válido", txtCantidadDinero.getText()),
                            "Conversor de moneda  - Alura Challenges Oracle ONE",
                            JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Conversor de moneda  - Alura Challenges Oracle ONE", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        btnConvertirMoneda.addActionListener(clickConvertirMoneda);
    }

    private void CMMostrarResultadoConversion() {
        lblResultadoConversion = new JLabel();
        lblResultadoConversion.setBounds(200, 300, 400, 40);
        lblResultadoConversion.setFont(new Font("Arial", Font.PLAIN, 20));
        lblResultadoConversion.setForeground(Color.decode("#323336"));
        lblResultadoConversion.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblResultadoConversion);
    }

    private void CMFooter() {
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
        CMPanel();
        CMCabecera();
        CMIngresarCantidadDinero();
        CMSeleccionarMoneda();
        CMCalcularConversion();
        CMMostrarResultadoConversion();
        CMFooter();
    }
}
