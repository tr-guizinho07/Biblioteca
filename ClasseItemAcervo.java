public abstract class ClasseItemAcervo {
    private String titulo, codigo;
    private int anoPublicacao;
    private boolean emprestado;
    public ClasseItemAcervo(String titulo, String codigo, int anoPublicacao, boolean emprestado) {
        this.titulo = titulo;
        this.codigo = codigo;
        this.anoPublicacao = anoPublicacao;
        this.emprestado = emprestado;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public int getAnoPublicacao() {
        return anoPublicacao;
    }
    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
    public boolean getEmprestado() {
        return emprestado;
    }
    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    public abstract double calcularMultaAtrasada(int diasAtrasados);

    public void emprestar(){
        if(getEmprestado()){
            System.out.println("Ja esta sendo emprestado");
        }else{
            setEmprestado(true);
            System.out.println("Foi emprestado com sucesso");
        }
    }
    public void devolver(){
        if(getEmprestado()){
            System.out.println("Devolvido com sucesso");
            setEmprestado(false);
        }else{
            System.out.println("Nao tem como devolver o que nao foi pego!!!");
        }
    }
}