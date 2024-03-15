package chunyinyu.entities;

public class Riviste extends Elemento{

    private TipoRiviste tipoRiviste;
    public Riviste(String isbn, String titolo, int annoPubblicazione, int numeroPagine, TipoRiviste tipoRiviste) {
        super(isbn, titolo, annoPubblicazione, numeroPagine);
        this.tipoRiviste = tipoRiviste;
    }

    public TipoRiviste getTipoRiviste() {
        return tipoRiviste;
    }

    @Override
    public String toString() {
        return "Riviste{" +
                "tipoRiviste=" + tipoRiviste +
                ", isbn='" + super.getIsbn() + '\'' +
                ", titolo='" + super.getTitolo() + '\'' +
                ", annoPubblicazione=" + super.getAnnoPubblicazione() +
                ", numeroPagine=" + super.getNumeroPagine() +
                '}';
    }
}
