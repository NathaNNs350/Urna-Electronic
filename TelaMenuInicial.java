package urnaeletronica;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class TelaMenuInicial extends JFrame {

    ///MENU INICIAL PARA TESTES!///
    
    private Eleicao eleicao;
        
    private JLabel lbTexto;
    private JButton btVotar, btApurar, btSobre, btVaza;
    private JPanel pBtMenu;

    public TelaMenuInicial() {
        setLayout(new GridLayout(2, 1));
        
        eleicao = new Eleicao();

        lbTexto = new JLabel("Urna Eletônica");
        btVotar = new JButton("Votar");
        btApurar = new JButton("Resultado");
        btSobre = new JButton("Sobre");
        btVaza = new JButton("Sair");
        pBtMenu = new JPanel(new GridLayout(4, 1, 10, 10));

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
        
        pBtMenu.setBorder(BorderFactory.createEmptyBorder(0, 220, 20, 220));

        add(lbTexto);
        add(pBtMenu);
        pBtMenu.add(btVotar);
        pBtMenu.add(btApurar);
        pBtMenu.add(btSobre);
        pBtMenu.add(btVaza);

        btVotar.addActionListener(e -> new TelaVotacao(eleicao));
        btApurar.addActionListener(e -> new TelaApuracao(eleicao));
        btSobre.addActionListener(e -> new TelaSobre());
        btVaza.addActionListener(e -> dispose());

        setTitle("Urna Remake");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    // Main para iniciar o código
    public static void main(String[] args) {
        new TelaMenuInicial();
    }
}
