
package com.mycompany.i.d_nilsondiaz;
/* Course name and code -> Algorithms And Complexity
   Student name and ID -> Nilson David Diaz Hasbun ID 200152551
   Name of the activity -> I+D
   Date -> 17/11/2022
   Description of the activity |
                               V
   El algoritmo de par más cercano se usa para encontrar la distancia más cercana. cortes entre dos coordenadas generadas al azar en una LinkedList
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ID_NilsonDiaz {
    private static int cont; //Se mantiene un seguimiento de cada repeticion.
    
    public ID_NilsonDiaz(){
        cont = 0;
    }
public int getCompar() {
        return cont;
    }
    
    public static double[] BruteForce(Lista coordenadas, double d_min) { // It is the closest pair with Brute Force Algorithm.
        double dmin = d_min;
        double[] V = new double[3]; //A matrix is created to store the D_Min and the point with the closest pair.
        V[0] = dmin;
        for (int i = 0; i < coordenadas.tamanio; i++) {
            for (int j = i + 1; j < coordenadas.tamanio; j++) {
                double d = distance(coordenadas, i, j); //The distance with each pair is compared.
                if (d < dmin) {
                    cont++;
                    dmin = d;
                    V[0] = d;
                    V[1] = coordenadas.get(i).sp.Posi;
                    V[2] = coordenadas.get(j).sp.Posi;
                } else {
                    cont++;
                }
            }
        }
        return V;
    }
    
 public static double distance(Lista coords, int i, int j) { // The distance between I and J is calculated
        // unpacks coordinates of the ith and jth elements.
        int x1 = coords.get(i).sp.X;
        int x2 = coords.get(j).sp.X;
        int y1 = coords.get(i).sp.Y;
        int y2 = coords.get(j).sp.Y;
        double d = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1); // computes their distance
        return Math.sqrt(d);
    }
 
  public static double[] ClosestPair(int n, Lista X, double Medium) {
        // Is the closest pair using recursity
        if (n > 3) { //If there are more than 3 particles, the plane is divided by 2.
            double[] g1 = new double[3];
            double[] g2 = new double[3];
            int Llimite = 0;
            cont++;
            if (n % 2 == 1) {
                Llimite = 1;
            }
            Lista gg2 = X.SingleL(n / 2, n, n / 2);
            Lista gg1 = X.SingleL(0, n / 2, n / 2);
            g1 = ClosestPair(n / 2, gg1, Medium);
            g2 = ClosestPair(n / 2, gg2, Medium);
            double[] g = new double[3];
            if (g1[0] < g2[0]) { // The closest pairs are stored
                g = g1;
                cont++;
            } else {
                cont++;
                g = g2;
            }
            Lista candidato = Candidatf(X, g[0]); //List that stores possible coordinates.
            // Bruteforte is applied if there are at least two candidates
            if (candidato.tamanio > 1) {
                cont++;
                g1 = BruteForce(candidato, Medium);
                if (g1[0] < g[0]) {
                    cont++;
                    return g1; //The current minimum distance with the candidates is compared
                } else {
                    cont++;
                    return g;
                }
            } else {
                cont++;
                return g;
            }
        } else {
            cont++;
            double[] v = new double[3];
            return BruteForce(X, Medium); // Bruteforte is applied if there is 3 or less
        }
    }
    

    public static void coordenadasp(List<int[]> coorde) { // Coordinates are printed.
        for (int i = 0; i < coorde.size(); i++) {
            System.out.println("X: " + coorde.get(i)[0] + " Y: " + coorde.get(i)[1] + " Posicion: " + coorde.get(i)[2]);
        }
    }

    public static Lista Candidatf(Lista Coors, double min) {
        ArrayList<Special> cn = new ArrayList<Special>();
        int i = 0;
        while (i < Coors.tamanio / 2) { //Positions between X and Y are compared.
            // of both subsets.
            if (Math.abs(Coors.get(i).sp.X - Coors.get(Coors.tamanio / 2).sp.X) < min && Math.abs(Coors.get(i).sp.Y - Coors.get(Coors.tamanio / 2).sp.Y) < min) {
                cont++;
                cn.add(Coors.get(i).sp);//A candidate is created when the distance is less than d_min.
                i++;
            } else {
                cont++;
                i = Coors.tamanio / 2;
            }
        }
        while (i < Coors.tamanio) { //They are compared not to get repeated.
            if (Math.abs(Coors.get(i).sp.X - Coors.get(Coors.tamanio / 2 - 1).sp.X) < min
                    && Math.abs(Coors.get(i).sp.Y - Coors.get(Coors.tamanio / 2 - 1).sp.Y) < min) {
                cont++;
                cn.add(Coors.get(i).sp);
                i++;
            } else {
                cont++;
                i = Coors.tamanio;
            }
        }
        // Linkedlist is passed from Arraylist
        Lista Ll;
        if (cn.isEmpty()) {
            Ll = new Lista(null, cn.size());
        } else {
            Ll = new Lista(new Node(cn.get(0)), cn.size());
            Node P = Ll.Cabeza;
            for (int j = 1; j < cn.size(); j++) {
                P.next = new Node(cn.get(j));
                P = P.next;
            }
        }
        return Ll;
    }

   

   

    public static Lista Iniciar(int T) { //Random coordinates are created on Linkedlist.
        Random Rem = new Random();
        Node P = null;
        Node PTR = null;
        for (int i = 0; i < T; i++) {
            Special Te = new Special(Rem.nextInt(10000), Rem.nextInt(10000), i);
            Node Tem = new Node(Te);
            if (i == 0) {
                PTR = Tem;
                P = PTR;
            } else {
                P.next = Tem;
                P = P.next;
            }
        }
        Orde(PTR);
        Lista L = new Lista(PTR, T);
        P = L.Cabeza;
        while (P.next != null) {
            P = P.next;
        }
        // P.next = list.head;
        return L;
    }

    private static void Orde(Node PTR) { //Linkedlist is ordered with respect to X.
        Node P = PTR;
        int tam = 0;
        while (P != null) {
            tam++;
            P = P.next;
        }
        P = PTR;
        for (int i = 0; i < tam; i++) {
            int min = P.sp.X;
            Node P2 = P.next;
            while (P2 != null) {
                if (P2.sp.X < min) {
                    Special temp = P2.sp;
                    P2.sp = P.sp;
                    P.sp = temp;
                    min = P.sp.X;
                }
                P2 = P2.next;
            }
            P = P.next;
        }
    }

    public static void main(String[] args) {
        Analisis tiempos = new Analisis();
        tiempos.AnalisisCoord(20000);
    }
}