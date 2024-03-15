package chunyinyu.entities;

public class Riviste extends Elemento{

    private TipoRiviste tipoRiviste;
    public Riviste(String isbn, String titolo, int annoPubblicazione, int numeroPagine) {
        super(isbn, titolo, annoPubblicazione, numeroPagine);
    }

    public TipoRiviste getTipoRiviste() {
        return tipoRiviste;
    }

}
