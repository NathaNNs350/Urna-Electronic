package urnaeletronica;

import java.awt.*;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;

public class TelaVotacao extends JFrame {

    ///MENU DAS VOTAÇÔES - EM PROGRESSO///

    private static final int L_IMG = 120;
    private static final int A_IMG = 160;

    private JLabel lbSeuVoto, lbCargo, lbDigito1, lbDigito2, lbNome, lbPartido, lbAviso, lbFoto;
    private JButton bt0, bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, btBranco, btCorrige, btConfirma;
    private JButton[] btNumeros;
    private JPanel pUrna, pNumeros, pAcao, pInformacao, pDigitos, pFoto, pCentral;
    private String numeroDigi;
    private Boolean Branco;
    private Candidato candidatoSelec;
    private Eleicao eleicao;

    public TelaVotacao(Eleicao eleicao) {
        {//Variáveis Gerais
            setLayout(new BorderLayout());

            this.eleicao = eleicao;
            numeroDigi = "";
            Branco = true;
            candidatoSelec = null;
        }
        {//Labels
            lbSeuVoto = new JLabel("SEU VOTO PARA");
            lbSeuVoto.setFont(new Font("Arial", Font.PLAIN, 14));
            lbCargo = new JLabel("PREFEITO");
            lbCargo.setFont(new Font("Arial", Font.BOLD, 26));
            lbDigito1 = criarLabelDigito();
            lbDigito2 = criarLabelDigito();
            lbNome = new JLabel("");
            lbNome.setFont(new Font("Arial", Font.BOLD, 18));
            lbPartido = new JLabel("");
            lbPartido.setFont(new Font("Arial", Font.PLAIN, 16));
            lbAviso = new JLabel("");
            lbAviso.setFont(new Font("Arial", Font.PLAIN, 12));
            lbFoto = new JLabel("", JLabel.CENTER);
        }
        {//Outros - Excessões - Botões
            pNumeros = new JPanel(new GridLayout(4, 3, 6, 4));
            btNumeros = new JButton[10];
            for (int i = 1; i <= 9; i++) {
                btNumeros[i] = criarBtNum(i);
                pNumeros.add(btNumeros[i]);
            }
            btNumeros[0] = criarBtNum(0);
            pNumeros.add(new JLabel(""));
            pNumeros.add(btNumeros[0]);
            pNumeros.add(new JLabel(""));
            btBranco = new JButton("BRANCO");
            btCorrige = new JButton("CORRIGE");
            btConfirma = new JButton("CONFIRMA");
        }
        {//Painéis
            pInformacao = new JPanel(new GridLayout(6, 1));
            pDigitos = new JPanel(new FlowLayout(FlowLayout.LEFT));
            pAcao = new JPanel(new GridLayout(1, 3, 4, 4));
            pUrna = new JPanel(new BorderLayout());
            pFoto = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
            pCentral = new JPanel(new BorderLayout());
        }
        {//Configurações - Estilização
            pUrna.setBackground(new Color(50, 50, 50));
            pNumeros.setBackground(new Color(50, 50, 50));
            pAcao.setBackground(new Color(50, 50, 50));
            pDigitos.setBackground(Color.WHITE);
            pInformacao.setBackground(Color.WHITE);
            pFoto.setBackground(Color.WHITE);
            criaBtAcao(btBranco, Color.WHITE, Color.BLACK);
            criaBtAcao(btCorrige, new Color(220, 120, 0), Color.BLACK);
            criaBtAcao(btConfirma, new Color(0, 120, 0), Color.WHITE);

            pUrna.setBorder(BorderFactory.createEmptyBorder(110, 20, 60, 20));
            pNumeros.setBorder(BorderFactory.createEmptyBorder(0, 0, 40, 0));
            pFoto.setPreferredSize(new Dimension(L_IMG + 30, A_IMG + 50));

            lbFoto.setPreferredSize(new Dimension(L_IMG, A_IMG));
            lbFoto.setHorizontalAlignment(SwingConstants.CENTER);
            lbFoto.setVerticalAlignment(SwingConstants.CENTER);
            lbFoto.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        }
        {//Montagem/Adições da tela
            add(pCentral, BorderLayout.CENTER);
            add(pUrna, BorderLayout.EAST);
            pCentral.add(pInformacao, BorderLayout.CENTER);
            pCentral.add(pFoto, BorderLayout.EAST);
            pInformacao.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
            pInformacao.add(lbSeuVoto);
            pInformacao.add(lbCargo);
            pInformacao.add(pDigitos);
            pInformacao.add(lbNome);
            pInformacao.add(lbPartido);
            pInformacao.add(lbAviso);
            pDigitos.add(lbDigito1);
            pDigitos.add(lbDigito2);
            pAcao.add(btBranco);
            pAcao.add(btCorrige);
            pAcao.add(btConfirma);
            pUrna.add(pNumeros, BorderLayout.CENTER);
            pUrna.add(pAcao, BorderLayout.SOUTH);
            pFoto.add(lbFoto);
        }
        {//Ações
            btBranco.addActionListener(e -> votarBranco());
            btCorrige.addActionListener(e -> reiniciar());
            btConfirma.addActionListener(e -> confirmar());
            reiniciar();
        }
        {//Configurações finais (da Tela)
            setTitle("Urna Remake - Votando");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setSize(880, 500);
            setVisible(true);
            setLocationRelativeTo(null);
        }
    }

    //MÉTODOS DA CLASSE
    private JLabel criarLabelDigito() {
        JLabel label = new JLabel("", JLabel.CENTER);
        label.setPreferredSize(new Dimension(45, 55));
        label.setFont(new Font("Arial", Font.BOLD, 30));
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        return label;
    }

    private JButton criarBtNum(int numero) {
        String digito = String.valueOf(numero);
        JButton botao = new JButton(digito);
        botao.setFont(new Font("Arial", Font.BOLD, 20));
        botao.setBackground(Color.BLACK);
        botao.setForeground(Color.WHITE);
        botao.setOpaque(true);
        botao.setBorderPainted(false);
        botao.addActionListener(e -> digitar(digito));
        return botao;
    }

    private void criaBtAcao(JButton botao, Color fundo, Color texto) {
        botao.setBackground(fundo);
        botao.setForeground(texto);
        botao.setOpaque(true);
        botao.setBorderPainted(false);
        botao.setFont(new Font("Arial", Font.BOLD, 11));
        botao.setMargin(new Insets(0, 0, 0, 0));
        botao.setPreferredSize(new Dimension(95, 45));
    }

    private ImageIcon carregarFoto(String caminho) {
        if (caminho == null) {
            return null;
        }
        URL url = getClass().getResource(caminho);
        if (url == null) {
            return null; // arquivo não encontrado dentro do projeto
        }
        ImageIcon original = new ImageIcon(url);
        Image reduzida = original.getImage().getScaledInstance(
                L_IMG, A_IMG, Image.SCALE_SMOOTH);
        return new ImageIcon(reduzida);
    }

    //IMPORTANTE ESTUDAR
    private void TocarSom(String caminhoNoJar) {
        try {
            // 1. Busca o arquivo de áudio de DENTRO do .jar
            InputStream audioSrc = TelaVotacao.class.getResourceAsStream(caminhoNoJar);

            InputStream bufferedIn = new BufferedInputStream(audioSrc);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

            Thread.sleep(clip.getMicrosecondLength() / 1000);

            clip.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void mostrarFoto(Candidato candidato) {
        ImageIcon icone = carregarFoto(candidato.getFoto());
        if (icone != null) {
            lbFoto.setIcon(icone);
            lbFoto.setText("");
        } else {
            lbFoto.setIcon(null);
            lbFoto.setText("SEM FOTO");
        }
        lbFoto.setVisible(true);
    }

    private void digitar(String digito) {
        if (Branco || numeroDigi.length() >= 2) {
            return;
        }
        numeroDigi += digito;
        atualizarDisplay();
    }

    private void votarBranco() {
        if (numeroDigi.length() > 0) {
            lbAviso.setText("Para votar em BRANCO, aperte CORRIGE antes.");
            return;
        }
        Branco = true;
        atualizarDisplay();
    }

    private void fecharUrna(boolean ativo) {
        btBranco.setEnabled(ativo);
        btCorrige.setEnabled(ativo);
        btConfirma.setEnabled(ativo);
    }

    private void reiniciar() {
        numeroDigi = "";
        Branco = false;
        candidatoSelec = null;

        lbSeuVoto.setText("SEU VOTO PARA");
        lbCargo.setText("PREFEITO");
        lbNome.setText("");
        lbPartido.setText("");
        lbAviso.setText("");
        pDigitos.setVisible(true);
        atualizarDisplay();
        fecharUrna(true);
    }

    private void confirmar() {
        if (Branco) {
            eleicao.registrarBranco();
        } else if (numeroDigi.length() < 2) {
            lbAviso.setText("Digite os 2 números do candidato ou aperte BRANCO.");
            return; // voto incompleto: não registra nada
        } else if (candidatoSelec != null) {
            eleicao.registrarVoto(candidatoSelec);
        } else {
            eleicao.registrarNulo();
        }
        mostrarFim();
    }

    //IMPORTANTE ESTUDAR
    private void atualizarDisplay() {
        lbDigito1.setText("");
        lbDigito2.setText("");
        lbFoto.setVisible(false);
        if (numeroDigi.length() >= 1) {
            lbDigito1.setText(numeroDigi.substring(0, 1));
        }
        if (numeroDigi.length() >= 2) {
            lbDigito2.setText(numeroDigi.substring(1, 2));
            candidatoSelec = null;
            lbNome.setText("");
            lbPartido.setText("");
            lbAviso.setText("");
        }
        if (Branco) {
            lbNome.setText("VOTO EM BRANCO");
            lbAviso.setText("Aperte CONFIRMA para confirmar ou CORRIGE para refazer.");
        } else if (numeroDigi.length() == 2) {
            candidatoSelec = eleicao.buscarCandidato(numeroDigi);
            if (candidatoSelec != null) {
                lbNome.setText("Nome: " + candidatoSelec.getNome());
                lbPartido.setText("Partido: " + candidatoSelec.getPartido());
                mostrarFoto(candidatoSelec);
                lbAviso.setText("Aperte CONFIRMA para confirmar ou CORRIGE para refazer.");
            } else {
                lbNome.setText("NÚMERO ERRADO");
                lbPartido.setText("VOTO NULO");
                lbAviso.setText("Aperte CONFIRMA para confirmar ou CORRIGE para refazer.");
            }
        }
    }

    private void mostrarFim() {
        fecharUrna(false);
        lbSeuVoto.setText("");
        lbCargo.setText("FIM");
        pDigitos.setVisible(false);
        lbNome.setText("");
        lbPartido.setText("");
        lbFoto.setVisible(false);
        lbAviso.setText("Obrigado por votar!");

        Timer temporizador = new Timer(2500, e -> reiniciar());
        temporizador.setRepeats(false);
        temporizador.start();
        TocarSom("/urnaeletronica/sons/confirma-urna.wav");
    }

    public static void main(String[] args) {
        new TelaVotacao(new Eleicao());
    }
}
