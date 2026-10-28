package urnaeletronica;

import java.awt.*;
import javax.swing.*;

public class TelaVotacao extends JFrame {

    ///MENU INICIAL PARA TESTES!///
    
    private JLabel lbTexto;
    private JButton bt0, bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, btBranco, btCorrige, btConfirma;
    private JPanel pUrna, pNumeros, pAcao;

    public TelaVotacao() {
        setLayout(new BorderLayout());

        lbTexto = new JLabel("Tela Votação!!");
        bt0 = new JButton("0");
        bt1 = new JButton("1");
        bt2 = new JButton("2");
        bt3 = new JButton("3");
        bt4 = new JButton("4");
        bt5 = new JButton("5");
        bt6 = new JButton("6");
        bt7 = new JButton("7");
        bt8 = new JButton("8");
        bt9 = new JButton("9");
        btBranco = new JButton("BRANCO");
        btCorrige = new JButton("CORRIGE");
        btConfirma = new JButton("CONFIRMA");
        pNumeros = new JPanel(new GridLayout(4, 3, 6, 4));
        pAcao = new JPanel(new GridLayout(1, 3, 4, 4));
        pUrna = new JPanel(new BorderLayout());

        {
            bt0.setFont(new Font("Arial", Font.BOLD, 20));
            bt0.setBackground(Color.BLACK);
            bt0.setForeground(Color.WHITE);
            bt0.setOpaque(true);
            bt0.setBorderPainted(false);

            bt1.setFont(new Font("Arial", Font.BOLD, 20));
            bt1.setBackground(Color.BLACK);
            bt1.setForeground(Color.WHITE);
            bt1.setOpaque(true);
            bt1.setBorderPainted(false);

            bt2.setFont(new Font("Arial", Font.BOLD, 20));
            bt2.setBackground(Color.BLACK);
            bt2.setForeground(Color.WHITE);
            bt2.setOpaque(true);
            bt2.setBorderPainted(false);

            bt3.setFont(new Font("Arial", Font.BOLD, 20));
            bt3.setBackground(Color.BLACK);
            bt3.setForeground(Color.WHITE);
            bt3.setOpaque(true);
            bt3.setBorderPainted(false);

            bt4.setFont(new Font("Arial", Font.BOLD, 20));
            bt4.setBackground(Color.BLACK);
            bt4.setForeground(Color.WHITE);
            bt4.setOpaque(true);
            bt4.setBorderPainted(false);

            bt5.setFont(new Font("Arial", Font.BOLD, 20));
            bt5.setBackground(Color.BLACK);
            bt5.setForeground(Color.WHITE);
            bt5.setOpaque(true);
            bt5.setBorderPainted(false);

            bt6.setFont(new Font("Arial", Font.BOLD, 20));
            bt6.setBackground(Color.BLACK);
            bt6.setForeground(Color.WHITE);
            bt6.setOpaque(true);
            bt6.setBorderPainted(false);

            bt7.setFont(new Font("Arial", Font.BOLD, 20));
            bt7.setBackground(Color.BLACK);
            bt7.setForeground(Color.WHITE);
            bt7.setOpaque(true);
            bt7.setBorderPainted(false);

            bt8.setFont(new Font("Arial", Font.BOLD, 20));
            bt8.setBackground(Color.BLACK);
            bt8.setForeground(Color.WHITE);
            bt8.setOpaque(true);
            bt8.setBorderPainted(false);

            bt9.setFont(new Font("Arial", Font.BOLD, 20));
            bt9.setBackground(Color.BLACK);
            bt9.setForeground(Color.WHITE);
            bt9.setOpaque(true);
            bt9.setBorderPainted(false);
        }
        {
            btBranco.setBackground(Color.WHITE);
            btBranco.setForeground(Color.BLACK);
            btBranco.setOpaque(true);
            btBranco.setBorderPainted(false);
            btBranco.setFont(new Font("Arial", Font.BOLD, 11));
            btBranco.setMargin(new Insets(0, 0, 0, 0));
            btBranco.setPreferredSize(new Dimension(95, 45));
            
            btCorrige.setBackground(new Color(220, 120, 0));
            btCorrige.setForeground(Color.BLACK);
            btCorrige.setOpaque(true);
            btCorrige.setBorderPainted(false);
            btCorrige.setFont(new Font("Arial", Font.BOLD, 11));
            btCorrige.setMargin(new Insets(0, 0, 0, 0));
            btCorrige.setPreferredSize(new Dimension(95, 45));
            
            btConfirma.setBackground(new Color(0, 120, 0));
            btConfirma.setForeground(Color.WHITE);
            btConfirma.setOpaque(true);
            btConfirma.setBorderPainted(false);
            btConfirma.setFont(new Font("Arial", Font.BOLD, 11));
            btConfirma.setMargin(new Insets(0, 0, 0, 0));
            btConfirma.setPreferredSize(new Dimension(95, 45));
        }
        
        pUrna.setBackground(new Color(50, 50, 50));
        pNumeros.setBackground(new Color(50, 50, 50));
        pAcao.setBackground(new Color(50, 50, 50));

        pUrna.setBorder(BorderFactory.createEmptyBorder(110, 20, 60, 20));
        pNumeros.setBorder(BorderFactory.createEmptyBorder(0, 0, 40, 0));

        add(lbTexto, BorderLayout.CENTER);
        add(pUrna, BorderLayout.EAST);
        {
            pNumeros.add(bt9);
            pNumeros.add(bt8);
            pNumeros.add(bt7);
            pNumeros.add(bt6);
            pNumeros.add(bt5);
            pNumeros.add(bt4);
            pNumeros.add(bt3);
            pNumeros.add(bt2);
            pNumeros.add(bt1);
            pNumeros.add(new JLabel(""));
            pNumeros.add(bt0);
            pNumeros.add(new JLabel(""));
        }
        pAcao.add(btBranco);
        pAcao.add(btCorrige);
        pAcao.add(btConfirma);
        pUrna.add(pNumeros, BorderLayout.CENTER);
        pUrna.add(pAcao, BorderLayout.SOUTH);

        //btVotar.addActionListener(e -> new TelaVotacao());
        setTitle("Votação");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 500);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
