import java.util.HashMap;
import java.util.Map;

public class ClasseAcervo <T extends ClasseItemAcervo> {
    Map<String, T> guardar = new HashMap<>();
    public void adicionar(String codigo, T item){
        if(guardar.containsKey(codigo)){
            System.out.println("O item ja existe na lista!");
        }else{
            guardar.put(codigo, item);
            System.out.println("Item guardado com sucesso");
        }
    }
    public T buscarCodigo(String codigo){
        if(guardar.containsKey(codigo)){
            return guardar.get(codigo);
        }else{
            System.out.println("Este codigo nao existe!!!");
            return null;
        }
    }
    public void remover(String codigo){
        if(guardar.containsKey(codigo)){
            System.out.println("Item removido com sucesso!");
            guardar.remove(codigo);
        }else{
            System.out.println("Nao tem como remover um item que nao existe!");
        }
    }
    public void contarItensEmprestados(){
        Long total = guardar.values().stream()
            .filter(a -> a.getEmprestado())
            .count();
        System.out.println("Total de itens emprestados: " + total);
    }
    public Map<String, T> getGuardar() {
        return this.guardar;
    }
    
}
