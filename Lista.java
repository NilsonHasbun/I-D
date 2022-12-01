/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.i.d_nilsondiaz;

public class Lista {
    Node Cabeza;
    int tamanio;
    
    public Lista(Node c, int T) { //Linkedlist is implemented
        this.Cabeza = c;
        this.tamanio = T;
    }

    public Node get(int i) {
        if (i == 0) {
            return this.Cabeza;
        } else {
            if (i < 0 || i > tamanio) {
                System.out.println("Error");
                return null;
            } else {
                Node P = this.Cabeza;
                for (int j = 0; j < i; j++) {
                    P = P.next;
                }
                return P;
            }
        }
    }

    public Lista SingleL(int i, int E, int tam) { //Se crea una sublista
        Lista Ls = new Lista(new Node(this.get(i).sp), tam);
        Node P = Ls.Cabeza;
        for (int j = 1; j < tam; j++) {
            P.next = new Node(this.get(j).sp);
            P = P.next;
        }
        return Ls;
    }
}