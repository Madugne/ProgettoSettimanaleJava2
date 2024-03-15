package chunyinyu;

import chunyinyu.entities.Inventario;
import chunyinyu.entities.Libri;
import chunyinyu.entities.Riviste;
import chunyinyu.entities.TipoRiviste;

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

        System.out.println(inventario);
    }
}