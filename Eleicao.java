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
        candidatos.add(new Candidato("11", "Ana Souza", "Partido do Sol"));
        candidatos.add(new Candidato("22", "Bruno Lima", "Partido da Lua"));
        candidatos.add(new Candidato("33", "Carla Mendes", "Partido do Mar"));
        candidatos.add(new Candidato("44", "Diego Rocha", "Partido da Serra"));

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
