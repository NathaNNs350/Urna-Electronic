package urnaeletronica;

public class Candidato {

    private String numero, nome, partido;
    private int votos;

    ///Construtor///
    public Candidato(String numero, String nome, String partido) {
        this.numero = numero;
        this.nome = nome;
        this.partido = partido;
        this.votos = 0;
    }

    ///Métodos///
    public String getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public String getPartido() {
        return partido;
    }

    public int getVotos() {
        return votos;
    }

    public void receberVoto() {
        votos++;
    }
}
