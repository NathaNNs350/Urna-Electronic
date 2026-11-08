package urnaeletronica;

import java.awt.*;
import javax.swing.*;

public class TelaSobre extends JFrame {

    ///MENU INICIAL PARA TESTES!///
    
    private JLabel lbTitulo, lbAutor, lbTurma, lbEscola, lbProfessor, lbData, lbVersao;
    private JPanel pTitulo, pDados, pRodape;
    private JButton btFechar;

    public TelaSobre() {
        setLayout(new BorderLayout());

        lbTitulo = new JLabel("Urninha Eletrônica Remake", JLabel.CENTER);
        lbAutor = new JLabel("Desenvolvido por: Nathan, Samuel e Elisângela");
        lbTurma = new JLabel("Turma: 2o ano - Curso Técnico em Informatica para Internet");
        lbEscola = new JLabel("Escola: IFCE - Instituto Federal do Ceará");
        lbProfessor = new JLabel("Professor(a): Vitor Adler Reis Paiva");
        lbData = new JLabel("Data: 07/11/2026");
        lbVersao = new JLabel("Versão: 0.5.5");
        btFechar = new JButton("Fechar");
        pTitulo = new JPanel(new FlowLayout());
        pDados = new JPanel(new GridLayout(0, 1, 5, 5));
        pRodape = new JPanel(new FlowLayout());

        lbTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lbTitulo.setForeground(Color.WHITE);

        pTitulo.setBackground(new Color(0, 90, 60));
        pDados.setBorder(BorderFactory.createEmptyBorder(15, 25, 15, 25));

        add(pTitulo, BorderLayout.NORTH);
        add(pDados, BorderLayout.CENTER);
        add(pRodape, BorderLayout.SOUTH);
        pTitulo.add(lbTitulo);
        pDados.add(lbAutor);
        pDados.add(lbTurma);
        pDados.add(lbEscola);
        pDados.add(lbProfessor);
        pDados.add(lbData);
        pDados.add(lbVersao);
        pRodape.add(btFechar);

        btFechar.addActionListener(e -> dispose());

        setTitle("Urna Remake - Sobre");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(450, 320);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
