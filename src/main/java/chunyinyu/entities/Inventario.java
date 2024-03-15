package chunyinyu.entities;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
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

    public void salvaSuDisco(String filePath) {
        try {
            File file = new File(filePath);
            List<String> lines = new ArrayList<>();
            for (Elemento elemento : catalogo) {
                String line = elemento.getClass().getName() + "," +
                        elemento.getIsbn() + "," +
                        elemento.getTitolo() + "," +
                        elemento.getAnnoPubblicazione() + "," +
                        elemento.getNumeroPagine();
                if (elemento instanceof Libri) {
                    Libri libro = (Libri) elemento;
                    line += "," + libro.getAutore() + "," + libro.getGenere();
                }
                lines.add(line);
            }
            FileUtils.writeLines(file, lines);
            System.out.println("Inventario salvato su disco.");
        } catch (IOException e) {
            System.out.println("Errore durante il salvataggio su disco.");
            e.printStackTrace();
        }
    }

    public void caricaDaDisco(String filePath) {
        try {
            File file = new File(filePath);
            List<String> lines = FileUtils.readLines(file, StandardCharsets.UTF_8);
            catalogo.clear();
            for (String line : lines) {
                String[] parts = line.split(",");
                String className = parts[0];
                String isbn = parts[1];
                String titolo = parts[2];
                int annoPubblicazione = Integer.parseInt(parts[3]);
                int numeroPagine = Integer.parseInt(parts[4]);

                Elemento elemento;
                if (className.equals(Libri.class.getName())) {
                    String autore = parts[5];
                    String genere = parts[6];
                    elemento = new Libri(isbn, titolo, annoPubblicazione, numeroPagine, autore, genere);
                } else {
                    elemento = new Elemento(isbn, titolo, annoPubblicazione, numeroPagine);
                }

                catalogo.add(elemento);
            }
            System.out.println("Inventario caricato da disco.");
        } catch (IOException e) {
            System.out.println("Errore durante il caricamento da disco.");
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Inventario{" +
                "catalogo=" + catalogo +
                '}';
    }
}
