package urnaeletronica;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class TelaMenuInicial extends JFrame {

    ///MENU INICIAL PARA TESTES!///
    
    private Eleicao eleicao;

    private JLabel lbTitulo, lbSubTitulo;
    private JButton btVotar, btApurar, btSobre, btVaza;
    private JPanel pTitulo, pBtMenu;

    public TelaMenuInicial() {
        setLayout(new BorderLayout());

        eleicao = new Eleicao();

        lbTitulo = new JLabel("Urna Eletônica", JLabel.CENTER);
        lbSubTitulo = new JLabel("Um Remake Não oficial", JLabel.CENTER);
        btVotar = new JButton("Votar");
        btApurar = new JButton("Resultado");
        btSobre = new JButton("Sobre");
        btVaza = new JButton("Sair");
        pTitulo = new JPanel(new GridLayout(2, 1));
        pBtMenu = new JPanel(new GridLayout(4, 1, 0, 12));

        lbTitulo.setFont(new Font("Arial Black Normal", Font.BOLD, 24));
        lbTitulo.setForeground(Color.WHITE);
        lbSubTitulo.setFont(new Font("Arial Black Normal", Font.PLAIN, 14));
        lbSubTitulo.setForeground(Color.YELLOW);
        pTitulo.setBackground(new Color(0, 90, 60));
        pTitulo.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        pBtMenu.setBorder(BorderFactory.createEmptyBorder(25, 150, 25, 150));

        {
            btVotar.setFont(new Font("Arial", Font.BOLD, 25));
            btVotar.setBackground(Color.BLACK);
            btVotar.setForeground(Color.WHITE);

            btApurar.setFont(new Font("Arial", Font.BOLD, 25));
            btApurar.setBackground(Color.BLACK);
            btApurar.setForeground(Color.WHITE);

            btSobre.setFont(new Font("Arial", Font.BOLD, 25));
            btSobre.setBackground(Color.BLACK);
            btSobre.setForeground(Color.WHITE);

            btVaza.setFont(new Font("Arial", Font.BOLD, 25));
            btVaza.setBackground(Color.BLACK);
            btVaza.setForeground(Color.WHITE);
        }

        add(pTitulo, BorderLayout.NORTH);
        add(pBtMenu, BorderLayout.CENTER);
        pTitulo.add(lbTitulo);
        pTitulo.add(lbSubTitulo);
        pBtMenu.add(btVotar);
        pBtMenu.add(btApurar);
        pBtMenu.add(btSobre);
        pBtMenu.add(btVaza);

        btVotar.addActionListener(e -> new TelaVotacao(eleicao));
        btApurar.addActionListener(e -> new TelaApuracao(eleicao));
        btSobre.addActionListener(e -> new TelaSobre());
        btVaza.addActionListener(e -> sair());

        setTitle("Urna Remake");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    // Main para iniciar o código
    public static void main(String[] args) {
        new TelaMenuInicial();
    }

    private void sair() {
        int opcao = JOptionPane.showConfirmDialog(this,
                "Deseja sair da urna? Os votos e registros serão perdidos.",
                "Sair",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );
        if (opcao == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}
