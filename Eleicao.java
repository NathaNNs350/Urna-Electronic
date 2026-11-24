package urnaeletronica;

import java.util.ArrayList;

public class Eleicao {

    private ArrayList<Candidato> candidatos;
    private int votosBrancos;
    private int votosNulos;

    public Eleicao() {

        candidatos = new ArrayList<Candidato>();
        votosBrancos = 0;
        votosNulos = 0;

        // Candidatos FICTÍCIOS
        candidatos.add(new Candidato("11", "Ana Souza", "Partido do Sol", "/urnaeletronica/imagens/11.jpg"));
        candidatos.add(new Candidato("13", "Luís Inácio", "Partido do Trabalhador", "/urnaeletronica/imagens/CandPlaceholder.png"));
        candidatos.add(new Candidato("22", "Bruno Lima", "Partido da Lua", "/urnaeletronica/imagens/22.jpg"));
        candidatos.add(new Candidato("33", "Carla Mendes", "Partido do Mar", "/urnaeletronica/imagens/33.jpg"));
        candidatos.add(new Candidato("44", "Diego Rocha", "Partido da Serra", "/urnaeletronica/imagens/44.jpg"));
        candidatos.add(new Candidato("67", "Caio Nicolas", "Partido Chadista", "/urnaeletronica/imagens/67.jpg"));
        candidatos.add(new Candidato("69", "José Augusto", "Partido Chadista", "/urnaeletronica/imagens/69.jpg"));
        candidatos.add(new Candidato("28", "Kelson Monteiro", "Partido Chadista", "/urnaeletronica/imagens/28.jpg"));
    }

    public Candidato buscarCandidato(String numero) {
        for (Candidato c : candidatos) {
            if (c.getNumero().equals(numero)) {
                return c;
            }
        }
        return null;
    }

    public void registrarVoto(Candidato candidato) {
        candidato.receberVoto();
    }

    public void registrarBranco() {
        votosBrancos++;
    }

    public void registrarNulo() {
        votosNulos++;
    }

    public int getTotalVotosCandidatos() {
        int total = 0;
        for (Candidato c : candidatos) {
            total += c.getVotos();
        }
        return total;
    }

    public int getTotalGeral() {
        return getTotalVotosCandidatos() + votosBrancos + votosNulos;
    }

    public int getVotosBrancos() {
        return votosBrancos;
    }

    public int getVotosNulos() {
        return votosNulos;
    }

    public ArrayList<Candidato> getCandidatosPorVotos() {
        ArrayList<Candidato> copia = new ArrayList<Candidato>(candidatos);
        copia.sort((a, b) -> Integer.compare(b.getVotos(), a.getVotos()));
        return copia;
    }
}