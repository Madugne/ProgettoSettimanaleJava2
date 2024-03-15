package chunyinyu;

import chunyinyu.entities.*;

import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        Scanner scanner = new Scanner(System.in);

        Libri libro1 = new Libri("ISBN1", "DragonBall", 1984, 500, "Akira Toriyama", "Shonen");
        Libri libro2 = new Libri("ISBN2", "DragonBallZ", 1984, 550, "Akira Toriyama", "Shonen");
        Libri libro3 = new Libri("ISBN3", "GhostInTheShell", 1992, 100, "Masamune Shirow", "Scifi");
        Libri libro4 = new Libri("ISBN4", "GhostInTheShellVol2", 2001, 100, "Masamune Shirow", "Scifi");
        Libri libro5 = new Libri("ISBN5", "Akira", 1982, 300, "Katsuhiro Otomo", "thriller");
        Riviste rivista1 = new Riviste("ISBN6", "ShonenJump", 2000, 20, TipoRiviste.SETTIMANALE);
        Riviste rivista2 = new Riviste("ISBN7", "ShonenJumpSuper", 2001, 30, TipoRiviste.MENSILE);
        Riviste rivista3 = new Riviste("ISBN8", "ShonenJumpDeluxe", 2002, 40, TipoRiviste.SEMESTRALE);
        Riviste rivista4 = new Riviste("ISBN9", "ShonenJump2", 2003, 50, TipoRiviste.SETTIMANALE);

        inventario.aggiungiElemento(libro1);
        inventario.aggiungiElemento(libro2);
        inventario.aggiungiElemento(libro3);
        inventario.aggiungiElemento(libro4);
        inventario.aggiungiElemento(libro5);
        inventario.aggiungiElemento(rivista1);
        inventario.aggiungiElemento(rivista2);
        inventario.aggiungiElemento(rivista3);
        inventario.aggiungiElemento(rivista4);

        int selezione = 0;
        while (selezione != 8) {
            System.out.println();
            System.out.println("1 - Ricerca per ISBN\n");
            System.out.println("2 - Ricerca per anno pubblicazione\n");
            System.out.println("3 - Ricerca per autore\n");
            System.out.println("4 - Aggiunta di un elemento\n");
            System.out.println("5 - Rimozione di un elemento dato un codice ISBN\n");
            System.out.println("6 - Salvataggio su disco dell'inventario\n");
            System.out.println("7 - Caricamento su disco dell'inventario\n");
            System.out.println("8 - Per uscire");

            selezione = scanner.nextInt();
            switch (selezione) {
                case 1:
                    System.out.println("Inserisci ISBN:");
                    String isbn = scanner.next();
                    Elemento trovatoIsbn = inventario.ricercaIsbn(isbn.toUpperCase());
                    if (trovatoIsbn != null) {
                        System.out.println("Elemento corrispondente all'isbn: " + trovatoIsbn.getTitolo());
                    } else {
                        System.out.println("Nessun elemento trovato");
                    }
                    break;

                case 2:
                    System.out.println("Inserisci anno di pubblicazione:");
                    int anno = scanner.nextInt();
                    List<Elemento> trovatiAnno = inventario.ricercaAnnoPubblicazione(anno);
                    if (trovatiAnno != null) {
                        System.out.println("Elementi corrispondente all'anno: ");
                        trovatiAnno.forEach(trovato -> System.out.println("- " + trovato.getTitolo()));
                    } else {
                        System.out.println("Nessun elemento trovato");
                    }
                    break;

                case 3:
                    System.out.println("Inserisci autore:");
                    String autore = scanner.nextLine();
                    List<Elemento> trovatiAutore = inventario.ricercaPerAutore(autore);
                    if (trovatiAutore != null) {
                        System.out.println("Elementi corrispondente all'autore: ");
                        trovatiAutore.forEach(trovato -> System.out.println("- " + trovato.getTitolo()));
                    } else {
                        System.out.println("Nessun elemento trovato");
                    }
                    break;

                case 4:
                    System.out.println("Inserisci elemento da creare: 1 per libro o 2 per rivista");
                    int scelta = scanner.nextInt();
                    System.out.println("Inserisci il codice ISBN:");
                    String codiceIsbn = scanner.next();
                    System.out.println("Inserisci il titolo:");
                    String titolo = scanner.next();
                    System.out.println("Inserisci l'anno di pubblicazione:");
                    int annoPubblicazione = scanner.nextInt();
                    System.out.println("Inserisci il numero di pagine:");
                    int numeroPagine = scanner.nextInt();
                    System.out.println();
                    if (scelta == 1) {
                        System.out.println("Inserisci l'autore");
                        String autoreLibro = scanner.next();
                        System.out.println("Inserisci il genere");
                        String genere = scanner.next();
                        Libri libro = new Libri(codiceIsbn, titolo, annoPubblicazione, numeroPagine, autoreLibro, genere);
                        inventario.aggiungiElemento(libro);
                        System.out.println("Libro aggiunto: " + libro);
                    } else if (scelta == 2) {
                        System.out.println("Inserisci il tipo di rivista:\n 1 per settimanale\n 2 per mensile \n 3 per semestrale");
                        selezione = scanner.nextInt();
                        TipoRiviste tipoSelezionato = null;
                        switch (selezione) {
                            case 1:
                                tipoSelezionato = TipoRiviste.SETTIMANALE;
                                break;
                            case 2:
                                tipoSelezionato = TipoRiviste.MENSILE;
                                break;
                            case 3:
                                tipoSelezionato = TipoRiviste.SEMESTRALE;
                                break;
                            default:
                                System.out.println("Errore");
                                break;
                        }
                        Riviste rivista = new Riviste(codiceIsbn, titolo, annoPubblicazione, numeroPagine, tipoSelezionato);
                        inventario.aggiungiElemento(rivista);
                        System.out.println("Rivista aggiunta: " + rivista);
                    } else {
                        System.out.println("Errore");
                        break;
                    }
                    break;

                case 5:
                    System.out.println("Inserisci l'ISBN per rimuovere l'elemento corrispondente: ");
                    String isbnDaRimuovere = scanner.next();
                    if (inventario.ricercaIsbn(isbnDaRimuovere) == null) {
                        System.out.println("Errore: ISBN non trovato");
                    } else {
                        inventario.rimuoviElemento(isbnDaRimuovere);
                        System.out.println("Elemento rimosso");
                    }

                    break;

                case 6:
                    break;

                case 7:
                    break;

                case 8:
                    System.out.println("Programma terminato");
                    break;

                default:
                    System.out.println("Errore");
                    break;
            }
        }
    }
}