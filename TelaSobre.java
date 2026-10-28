package urnaeletronica;

import java.awt.*;
import javax.swing.*;

public class TelaSobre extends JFrame {
    
    ///MENU INICIAL PARA TESTES!///
    
    private JLabel lbTexto;
    private JButton btVotar, btApurar, btSobre, btVaza;
    private JPanel pBtMenu;

    public TelaSobre() {
        setLayout(new GridLayout(2, 1));

        lbTexto = new JLabel("Tela Sobre!!");
        //btVotar = new JButton("Votar");
        //btApurar = new JButton("Resultado");
        //btSobre = new JButton("Sobre");
        //btVaza = new JButton("Sair");
        //pBtMenu = new JPanel(new GridLayout(4, 1));

        add(lbTexto);
        //add(pBtMenu);
        //pBtMenu.add(btVotar);
        //pBtMenu.add(btApurar);
        //pBtMenu.add(btSobre);
        //pBtMenu.add(btVaza);

        //btVotar.addActionListener(e -> new TelaVotacao());

        setTitle("Sobre");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 500);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
