package chunyinyu.entities;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Elemento> catalogo;
    public Inventario() {
        catalogo = new ArrayList<>();
    }
    public void aggiungiElemento(Elemento elemento) {
        catalogo.add(elemento);
    }
    public void rimuoviElemento(String isbn) {
        catalogo.removeIf(rimuovi -> rimuovi.getIsbn().equals(isbn));
    }
    public Elemento ricercaIsbn(String isbn) {
        return catalogo.stream().filter(ricercaIsbn -> ricercaIsbn.getIsbn().equals(isbn)).findFirst().orElse(null);
    }
    public List<Elemento> ricercaAnnoPubblicazione(int anno) {
        return catalogo.stream().filter(ricercaAnno -> ricercaAnno.getAnnoPubblicazione() == anno).toList();
    }
    public List<Elemento> ricercaPerAutore(String autore) {
        return catalogo.stream().filter(ricercaAutore -> ricercaAutore instanceof Libri).filter(libro -> ((Libri) libro).getAutore().equals(autore)).toList();
    }

    @Override
    public String toString() {
        return "Inventario{" +
                "catalogo=" + catalogo +
                '}';
    }
}
