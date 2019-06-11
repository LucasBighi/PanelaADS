package Basic;




public class Aluno {

    private String nome;
    private String apelido;
    private String idade;

    public Aluno(String nome, String apelido, String idade) {
        this.nome = nome;
        this.apelido = apelido;
        this.idade = idade;
    }

    public Aluno() {
        this.nome = "";
        this.apelido = "";
        this.idade = "";
    }
    
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the apelido
     */
    public String getApelido() {
        return apelido;
    }

    /**
     * @param apelido the apelido to set
     */
    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    /**
     * @return the idade
     */
    public String getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(String idade) {
        this.idade = idade;
    }
}
