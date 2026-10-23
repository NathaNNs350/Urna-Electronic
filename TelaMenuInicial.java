package urnaeletronica;

import java.awt.*;
import javax.swing.*;

public class TelaMenuInicial extends JFrame {
    
    ///MENU INICIAL PARA TESTES!///
    
    private JLabel lbTexto;
    private JButton btVotar, btApurar, btSobre, btVaza;
    private JPanel pBtMenu;

    public TelaMenuInicial() {
        setLayout(new GridLayout(2, 1));

        lbTexto = new JLabel("Urna Eletônica");
        btVotar = new JButton("Votar");
        btApurar = new JButton("Resultado");
        btSobre = new JButton("Sobre");
        btVaza = new JButton("Sair");
        pBtMenu = new JPanel(new GridLayout(4, 1));

        add(lbTexto);
        add(pBtMenu);
        pBtMenu.add(btVotar);
        pBtMenu.add(btApurar);
        pBtMenu.add(btSobre);
        pBtMenu.add(btVaza);

        btVotar.addActionListener(e -> new TelaVotacao());

        setTitle("Urninha papae");
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
