package view;

import Utils.Utils;

import javax.swing.*;
import java.awt.*;

public class Main {
    private static GraphicsConfiguration gc;
    private static BtnOkActionListener btnOkActionListener = new BtnOkActionListener();

    public static void main(String[] args) {

        JFrame frame= new JFrame(gc);
        frame.setTitle(Utils.TITULO);
        frame.setSize(Utils.LARGURA_JANELA, Utils.ALTURA_JANELA);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        JLabel textoPense = new JLabel(Utils.FRASE_INICIO, SwingConstants.CENTER);
        textoPense.setBounds(30, 10, 250, 15);
        frame.add(textoPense);

        JButton btnOk = new JButton(Utils.TXT_BOTAO);
        btnOk.setBounds(120, 45, 60, 30);
        btnOk.addActionListener(btnOkActionListener);
        frame.add(btnOk);

        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
