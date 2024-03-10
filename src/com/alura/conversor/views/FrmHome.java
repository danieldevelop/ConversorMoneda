package com.alura.conversor.views;

//  Simbología de metodos visuales
//  -------------------------------
//    - H: Home
//    - HPanel: homePanel
//    - HCebecera: homeCabaecera
//    - HBotones: homeBotones
//    - HFooter: homeFooter

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.BorderFactory.createLineBorder;

public class FrmHome extends JFrame {
    private JPanel panel;
    private JLabel lblTitulo, lblLeyenda, lblImageAluraOracle, lblCopyRight;
    private JButton btnConvertirMoneda, btnConvertirTemperatura, btnSalir;
    private final ImageIcon imgAluraOracle = new ImageIcon(getClass().getResource("/com/alura/conversor/images/aluraoracle.png"));

    public FrmHome() {
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

    private void HPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        this.getContentPane().add(panel);
    }

    private void HCebecera() {
        lblTitulo = new JLabel("¡Bienvenido a tu Conversor!");
        lblTitulo.setBounds(200, 40, 400, 30);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 25));
        lblTitulo.setForeground(Color.decode("#323336"));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblTitulo);

        lblLeyenda = new JLabel("Alura Challenges Oracle ONE");
        lblLeyenda.setBounds(300, 70, 200, 30);
        lblLeyenda.setFont(new Font("Arial", Font.PLAIN, 15));
        lblLeyenda.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblLeyenda);
    }

    private void HBotones() {
        btnConvertirMoneda = new JButton("Conversor de Moneda");
        btnConvertirMoneda.setBounds(300, 150, 200, 50);
        btnConvertirMoneda.setFont(new Font("Arial", Font.PLAIN, 15));
        btnConvertirMoneda.setForeground(Color.WHITE);
        btnConvertirMoneda.setBackground(Color.decode("#0AA06E"));
        btnConvertirMoneda.setBorderPainted(true);
        btnConvertirMoneda.setFocusPainted(false);
        btnConvertirMoneda.setBorder(createLineBorder(Color.decode("#0AA06E"), 1));
        btnConvertirMoneda.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(btnConvertirMoneda);


        btnConvertirTemperatura = new JButton("Conversor de Temperatura");
        btnConvertirTemperatura.setBounds(300, 220, 200, 50);
        btnConvertirTemperatura.setFont(new Font("Arial", Font.PLAIN, 15));
        btnConvertirTemperatura.setForeground(Color.WHITE);
        btnConvertirTemperatura.setBackground(Color.decode("#0AA06E"));
        btnConvertirTemperatura.setBorderPainted(true);
        btnConvertirTemperatura.setFocusPainted(false);
        btnConvertirTemperatura.setBorder(createLineBorder(Color.decode("#0AA06E"), 1));
        btnConvertirTemperatura.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(btnConvertirTemperatura);


        btnSalir = new JButton("Salir");
        btnSalir.setBounds(300, 290, 200, 50);
        btnSalir.setFont(new Font("Arial", Font.PLAIN, 15));
        btnSalir.setForeground(Color.WHITE);
        btnSalir.setBackground(Color.decode("#0AA06E"));
        btnSalir.setBorderPainted(true);
        btnSalir.setFocusPainted(false);
        btnSalir.setBorder(createLineBorder(Color.decode("#0AA06E"), 1));
        btnSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(btnSalir);


        ActionListener clickConversorMoneda = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmConversorMoneda conversorMoneda = new FrmConversorMoneda();
                conversorMoneda.setVisible(true);
                dispose(); // Cerrar la ventana actual
            }
        };
        btnConvertirMoneda.addActionListener(clickConversorMoneda);

        ActionListener clickConversorTemperatura = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmConversorTemperatura conversorTemperatura = new FrmConversorTemperatura();
                conversorTemperatura.setVisible(true);
                dispose(); // Cerrar la ventana actual
            }
        };
        btnConvertirTemperatura.addActionListener(clickConversorTemperatura);

        ActionListener clickFinish = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(rootPane,
                        "Programa Terminado. ¡Hasta Pronto!",
                        "Conversor de moneda  - Alura Challenges Oracle ONE",
                        JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        };
        btnSalir.addActionListener(clickFinish);
    }

    private void HFooter() {
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
        HPanel();
        HCebecera();
        HBotones();
        HFooter();
    }
}
