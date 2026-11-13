package urnaeletronica;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class TelaApuracao extends JFrame {

    ///MENU INICIAL PARA TESTES!///
    
    private Eleicao eleicao;

    private JLabel lbTitulo;
    private JTextArea taResul;
    private JScrollPane spRolar;
    private JButton btAtualizar, btFechar;
    private JPanel pTitulo, pBts;

    public TelaApuracao(Eleicao eleicao) {
        setLayout(new BorderLayout());

        this.eleicao = eleicao;

        lbTitulo = new JLabel("RESULTADO DA APURAÇÃO", JLabel.CENTER);
        taResul = new JTextArea();
        spRolar = new JScrollPane(taResul);
        btAtualizar = new JButton("Atualizar");
        btFechar = new JButton("Fechar");
        pTitulo = new JPanel(new FlowLayout());
        pBts = new JPanel(new FlowLayout());

        lbTitulo.setFont(new Font("Arial Black Normal", Font.BOLD, 24));
        lbTitulo.setForeground(Color.WHITE);
        taResul.setEditable(false);
        taResul.setFont(new Font("Monospace 821 BT", Font.PLAIN, 16));
        pTitulo.setBackground(new Color(0, 90, 60));

        add(pTitulo, BorderLayout.NORTH);
        add(spRolar, BorderLayout.CENTER);
        add(pBts, BorderLayout.SOUTH);
        pTitulo.add(lbTitulo);
        pBts.add(btAtualizar);
        pBts.add(btFechar);

        btAtualizar.addActionListener(e -> atualizar());
        btFechar.addActionListener(e -> dispose());

        atualizar();

        setTitle("Urna Remake - Apuração");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 500);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void atualizar() {
        taResul.setText(montarRelatorio());
    }

    private String montarRelatorio() {
        StringBuilder sb = new StringBuilder();
        int total = eleicao.getTotalGeral();
        ArrayList<Candidato> ordenados = eleicao.getCandidatosPorVotos();
        sb.append(String.format("%-4s %-18s %6s %8s\n", "No", "Candidato", "Votos", "%"));
        sb.append("------------------------------------------\n");

        for (Candidato c : ordenados) {
            sb.append(String.format("%-4s %-18s %6d %7.1f%%\n", c.getNumero(),
                    c.getNome(), c.getVotos(), percentual(c.getVotos(), total)));

        }
        sb.append("------------------------------------------\n");
        sb.append(String.format("%-4s %-18s %6d %7.1f%%\n", "", "Brancos",
                eleicao.getVotosBrancos(), percentual(eleicao.getVotosBrancos(), total)));
        sb.append(String.format("%-4s %-18s %6d %7.1f%%\n", "", "Nulos",
                eleicao.getVotosNulos(), percentual(eleicao.getVotosNulos(), total)));
        sb.append(String.format("%-4s %-18s %6d\n", "", "TOTAL", total));
        sb.append("\n");
        if (eleicao.getTotalVotosCandidatos() == 0) {
            sb.append("Nenhum voto válido registrado até o momento.");
        } else if (ordenados.size() > 1
                && ordenados.get(0).getVotos() == ordenados.get(1).getVotos()) {
            sb.append("EMPATE entre os primeiros colocados.");
        } else {
            sb.append("Candidato mais votado: " + ordenados.get(0).getNome());
        }
        return sb.toString();
    }

    private double percentual(int parte, int total) {
        if (total == 0) {
            return 0.0; // evita divisão por zero
        }
        return parte * 100.0 / total;
    }

    public static void main(String[] args) {
        Eleicao e = new Eleicao();
        e.registrarVoto(e.buscarCandidato("11"));
        e.registrarVoto(e.buscarCandidato("22"));
        e.registrarVoto(e.buscarCandidato("22"));
        e.registrarVoto(e.buscarCandidato("22"));
        e.registrarVoto(e.buscarCandidato("22"));
        e.registrarVoto(e.buscarCandidato("22"));
        e.registrarVoto(e.buscarCandidato("22"));
        e.registrarVoto(e.buscarCandidato("22"));
        e.registrarVoto(e.buscarCandidato("22"));
        e.registrarVoto(e.buscarCandidato("22"));
        e.registrarVoto(e.buscarCandidato("22"));
        e.registrarVoto(e.buscarCandidato("22"));
        e.registrarVoto(e.buscarCandidato("22"));
        e.registrarNulo();
        new TelaApuracao(e);
    }
}
