package urnaeletronica;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class TelaMenuInicial extends JFrame {

    ///MENU INICIAL PARA TESTES!///
    
    private Eleicao eleicao;

    private TelaVotacao telaVotacao;
    private TelaApuracao telaApuracao;
    private TelaSobre telaSobre;

    private JLabel lbTitulo, lbSubTitulo;
    private JButton btVotar, btApurar, btSobre, btVaza;
    private JPanel pTitulo, pBtMenu;
    private JMenuBar mbMenu;
    private JMenu mArquivo, mAjuda;
    private JMenuItem miSair, miSobre;

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
        mbMenu = new JMenuBar();
        mArquivo = new JMenu("Arquivo");
        mAjuda = new JMenu("Ajuda");
        miSair = new JMenuItem("Sair");
        miSobre = new JMenuItem("Sobre");

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
        mArquivo.add(miSair);
        mAjuda.add(miSobre);
        mbMenu.add(mArquivo);
        mbMenu.add(mAjuda);
        pTitulo.add(lbTitulo);
        pTitulo.add(lbSubTitulo);
        pBtMenu.add(btVotar);
        pBtMenu.add(btApurar);
        pBtMenu.add(btSobre);
        pBtMenu.add(btVaza);
        setJMenuBar(mbMenu);

        btVotar.addActionListener(e -> abrirVotacao());
        btApurar.addActionListener(e -> verificarMesario());
        btSobre.addActionListener(e -> abrirSobre());
        btVaza.addActionListener(e -> sair());
        miSobre.addActionListener(e -> abrirSobre());
        miSair.addActionListener(e -> sair());

        setTitle("Urna Remake");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void abrirVotacao() {
        if (telaVotacao == null || !telaVotacao.isDisplayable()) {
            telaVotacao = new TelaVotacao(eleicao);
        } else {
            telaVotacao.toFront();
        }
    }

    private void abrirResultado() {
        if (telaApuracao == null || !telaApuracao.isDisplayable()) {
            telaApuracao = new TelaApuracao(eleicao);
        } else {
            telaApuracao.toFront();
        }
    }

    private void verificarMesario() {
        JPasswordField campo = new JPasswordField(10);
        int opcao = JOptionPane.showConfirmDialog(this, campo, "Confirmação do Mesario",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (opcao == JOptionPane.OK_OPTION
                && new String(campo.getPassword()).equals("1234")) {
            abrirResultado();
        } else if (opcao == JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(this, "A Senha Informada está incorreta", "Senha Incorreta", HEIGHT);
        }
    }

    private void abrirSobre() {
        if (telaSobre == null || !telaSobre.isDisplayable()) {
            telaSobre = new TelaSobre();
        } else {
            telaSobre.toFront();
        }
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

    // Main para iniciar o código
    public static void main(String[] args) {
        new TelaMenuInicial();
    }
}
