public class ClasseRevista extends ClasseItemAcervo {
    private int edicao;
    public ClasseRevista(String titulo, String codigo, int anoPublicacao, boolean emprestado, int edicao) {
        super(titulo, codigo, anoPublicacao, emprestado);
        this.edicao = edicao;
    }
    public int getEdicao() {
        return edicao;
    }
    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }
    @Override
    public double calcularMultaAtrasada(int diasAtrasados) {
        double multa = 0;
        if(diasAtrasados > 30){
            multa = (diasAtrasados * 0.2) * 2;
        }else{
            multa = diasAtrasados * 0.2;
        }
        return multa;
    }
    
}
