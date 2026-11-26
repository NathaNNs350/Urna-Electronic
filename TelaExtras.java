package urnaeletronica;

import java.awt.*;
import javax.swing.*;

public class TelaExtras extends JFrame {

    ///EM DESENVOLVIMENTO///
    
    private JLabel lbTitulo, lbCod1, lbCod2, lbCod3, lbProfessor, lbPrePrompts, lbVersao;
    private JPanel pTitulo, pInfoExtra, pFatos, pContIA, pRodape;
    private JButton btFechar;

    public TelaExtras() {
        setLayout(new BorderLayout());

        lbTitulo = new JLabel("Informações Extras de Desenvolvimento", JLabel.CENTER);
        lbProfessor = new JLabel("O Professor Vitor Adler Reis Paiva Ajudou Muito");
        lbVersao = new JLabel("O projeto tomou Aproximadamente 1 mês e meio para ser finalizado");
        lbCod1 = new JLabel("Cerca de 80% do código é próprio ou inspirado no roteiro");
        lbCod2 = new JLabel("Cerca de 12% do código foi copiado do roteiro");
        lbCod3 = new JLabel("Cerca de 8% do código foi Gerado por IA Generativa com exclusividade ao Gemini");
        lbPrePrompts = new JLabel("A Seguir o(os) Prompts usados na geração do conteúdo de IA");
        
        btFechar = new JButton("Fechar");
        pTitulo = new JPanel(new FlowLayout());
        pInfoExtra = new JPanel(new GridLayout(0, 1));
        pRodape = new JPanel(new FlowLayout());
        pFatos = new JPanel(new FlowLayout());
        pContIA = new JPanel(new FlowLayout());

        lbTitulo.setFont(new Font("Arial Black Normal", Font.BOLD, 20));
        lbTitulo.setForeground(Color.WHITE);

        pTitulo.setBackground(new Color(0, 90, 60));
        pInfoExtra.setBorder(BorderFactory.createEmptyBorder(15, 25, 15, 25));

        add(pTitulo, BorderLayout.NORTH);
        add(pInfoExtra, BorderLayout.CENTER);
        add(pRodape, BorderLayout.SOUTH);
        add(pInfoExtra);
        pInfoExtra.add(pFatos);
        pInfoExtra.add(pContIA);
        pTitulo.add(lbTitulo); 
        pFatos.add(lbProfessor);
        pFatos.add(lbVersao);
        pContIA.add(lbCod1);
        pContIA.add(lbCod2);
        pContIA.add(lbCod3);
        pContIA.add(lbPrePrompts);
        pRodape.add(btFechar);

        btFechar.addActionListener(e -> dispose());

        setTitle("Urna Remake - Sobre");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
