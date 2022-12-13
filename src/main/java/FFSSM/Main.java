/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FFSSM;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author gleroy
 */
public class Main {

    public static void main(String[] args) {

        LocalDate naissance1 = LocalDate.of(04, 06, 1996);
        LocalDate naissance2 = LocalDate.of(1987, Month.MARCH, 3);
        LocalDate delivrance1 = LocalDate.of(20, 11, 2022);
//    * constructeur de Plongeur
//     * @param numeroINSEE
//     * @param nom
//     * @param prenom
//     * @param adresse
//     * @param telephone
//     * @param naissance
//     * @param niveau
//     * @param g 

        Plongeur p1 = new Plongeur("1234AZES", "minela", "pierre", "12 rue de la boustify", "0612345612", naissance1, 2, GroupeSanguin.AMOINS);
        Moniteur m1 = new Moniteur("217215IPES","Delacruz","Luiz","27 avenue de la liberté","0726458421",naissance2, 3,127,GroupeSanguin.BMOINS);
        Club c1 = new Club(m1,"les barbotteurs","125 allée du mas neuf","0625957436");
        Licence l1 = new Licence(p1, "256BCZS", delivrance1,c1);

    }
}
