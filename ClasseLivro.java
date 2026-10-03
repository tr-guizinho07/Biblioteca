public class ClasseLivro extends ClasseItemAcervo {
    private String autor;
    private int numeroPaginas;
    public ClasseLivro(String titulo, String codigo, int anoPublicacao, boolean emprestado, String autor, int numeroPaginas) {
        super(titulo, codigo, anoPublicacao, emprestado);
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public int getNumeroPaginas() {
        return numeroPaginas;
    }
    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }
    @Override
    public double calcularMultaAtrasada(int diasAtrasados) {
        double multa = diasAtrasados * 0.5;
        return multa;
    }
}
