import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class  MainAcervo {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        boolean continuar = true;
        ClasseAcervo guardar = new ClasseAcervo<>();
        while (continuar) {
            System.out.println("[1] Cadastrar livro");
            System.out.println("[2] Cadastrar Revista");
            System.out.println("[3] Emprestar item");
            System.out.println("[4] Devolver item");
            System.out.println("[5] Listar itens disponiveis");
            System.out.println("[6] Ver quantidade de itens emprestados");
            System.out.println("[7] Remover item");
            System.out.println("[8] Sair");
            int opcao = 0;
            try {
                opcao = leitor.nextInt();
                leitor.nextLine();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Digite um NUMERO");
                System.out.println("\n----------------------\n");
                leitor.nextLine();
            }
            switch (opcao) {
                case 1:
                    System.out.print("Titulo: ");
                    String titulo = leitor.nextLine();
                    System.out.print("Codigo: ");
                    String codigo = leitor.nextLine();
                    System.out.print("Ano de publicacao: ");
                    int anoPublicacao = 0;
                    try {
                        anoPublicacao = leitor.nextInt();
                        leitor.nextLine();
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Digite um NUMERO");
                        System.out.println("\n----------------------\n");
                        leitor.nextLine();
                    }
                    System.out.print("O livro foi emprestado [sim/nao]? ");
                    String sn = leitor.nextLine();
                    boolean emprestado;
                    if(sn.equalsIgnoreCase("sim")){
                        emprestado = true;
                    }else{
                        emprestado = false;
                    }
                    System.out.print("Nome do autor: ");
                    String autor = leitor.nextLine();
                    System.out.print("Numero de paginas: ");
                    int numeroPaginas = 0;
                    try {
                        numeroPaginas = leitor.nextInt();
                        leitor.nextLine();
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Digite um NUMERO");
                        System.out.println("\n----------------------\n");
                        leitor.nextLine();
                    }
                    ClasseLivro livro = new ClasseLivro(titulo, codigo, anoPublicacao, emprestado, autor, numeroPaginas);
                    guardar.adicionar(codigo, livro);
                    System.out.println("\n----------------------\n");
                break;
                case 2:
                    System.out.print("Titulo: ");
                    String tituloR = leitor.nextLine();
                    System.out.print("Codigo: ");
                    String codigoR = leitor.nextLine();
                    System.out.print("Ano de publicacao: ");
                    int anoPublicacaoR = 0;
                    try {
                        anoPublicacaoR = leitor.nextInt();
                        leitor.nextLine();
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Digite um NUMERO");
                        System.out.println("\n----------------------\n");
                        leitor.nextLine();
                    }
                    System.out.print("O revista foi emprestado [sim/nao]? ");
                    String snR = leitor.nextLine();
                    boolean emprestadoR;
                    if(snR.equalsIgnoreCase("sim")){
                        emprestadoR = true;
                    }else{
                        emprestadoR = false;
                    }
                    System.out.print("Edicao da revista: ");
                    int edicao = 0;
                    try {
                        edicao = leitor.nextInt();
                        leitor.nextLine();
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Digite um NUMERO");
                        System.out.println("\n----------------------\n");
                        leitor.nextLine();
                    }
                    ClasseRevista revista = new ClasseRevista(tituloR, codigoR, anoPublicacaoR, emprestadoR, edicao);
                    guardar.adicionar(codigoR, revista);
                    System.out.println("\n----------------------\n");
                break;
                case 3:
                    System.out.print("Digite o codigo: ");
                    String codigoE = leitor.nextLine();
                    if(guardar.getGuardar().containsKey(codigoE)){
                        ClasseItemAcervo item = guardar.buscarCodigo(codigoE);
                        item.emprestar();
                    }else{
                        System.out.println("Item nao encontrado!");
                    }
                    System.out.println("\n----------------------\n");
                break;
                case 4:
                    System.out.print("Digite o codigo: ");
                    String codigoD = leitor.nextLine();
                    if(guardar.getGuardar().containsKey(codigoD)){
                        ClasseItemAcervo item = guardar.buscarCodigo(codigoD);
                        item.devolver();
                    }else{
                        System.out.println("Item nao encontrado!");
                    }
                    System.out.println("\n----------------------\n");
                break;
                case 5:
                    List<ClasseItemAcervo> disponiveis = guardar.getGuardar().values().stream()
                        .map(a -> (ClasseItemAcervo)a)
                        .filter(a -> !((ClasseItemAcervo) a).getEmprestado())
                        .toList();
                    if(disponiveis.isEmpty()){
                        System.out.println("Nao existe item disponivel");
                        System.out.println("\n----------------------\n");
                    }else{
                        disponiveis.stream()
                            .forEach(a -> System.out.println("Titulo: " + a.getTitulo() + "\nCodigo: " + a.getCodigo()));
                            System.out.println("\n----------------------\n");
                    }
                break;
                case 6:
                    guardar.contarItensEmprestados();
                    System.out.println("\n----------------------\n");
                break;
                case 7:
                    System.out.print("Digite o codigo: ");
                    String codigoRemover = leitor.nextLine();
                    guardar.remover(codigoRemover);
                    System.out.println("\n----------------------\n");
                break;
                case 8:
                    continuar = false;
                break;
            
                default:
                    System.out.println("Opcao nao encontrada!");
                    System.out.println("\n----------------------\n");
                break;
            }
        }
    }
}
/*          try {
                
            } catch (java.util.InputMismatchException e) {
                System.out.println("Digite um NUMERO");
                System.out.println("\n----------------------\n");
                leitor.nextLine();
            }*/
