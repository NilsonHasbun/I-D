/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.i.d_nilsondiaz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Analisis {
    private static void create(String name)
    // creates a file with a given name
    {
        try {
            // defines the filename
            String fname = (name);
            // creates a new File object
            File f = new File(fname);

            String msg = "creating file `" + fname + "' ... ";
            // creates the new file
            f.createNewFile();

        } catch (IOException err) {
            // complains if there id an Input/Output Error
            err.printStackTrace();
        }

        return;
    }

    private static void write(String name, int tm, ArrayList<Integer> is, ArrayList<Integer> comparisons,ArrayList<Integer> runtimes){
        try {
            // defines the filename
            String filename = (name);
            PrintWriter out = new PrintWriter(filename);
            String fmt = ("%10s %10s %10s\n"); 
            for (int i = 0; i < tm; ++i) {
                out.printf(fmt, is.get(i), comparisons.get(i), runtimes.get(i));
            }

            out.close();
        } catch (FileNotFoundException err) {
            // complains if file does not exist
            err.printStackTrace();
        }

        return;
    }
    public void AnalisisCoord(int Limite) { //Limite is the number of integers to arrive.
        ArrayList<Integer> Rtimes = new ArrayList<Integer>();
        ArrayList<Integer> id = new ArrayList<Integer>();
        ArrayList<Integer> Comparaciones = new ArrayList<Integer>(); //The lists are initialized.
        for (int i = 50; i < Limite; i = i*3/2) {
            ID_NilsonDiaz NS = new ID_NilsonDiaz(); // A new class is created
            System.out.println(i);
            long tot = 0;
            int C;
            Lista List = NS.Iniciar(i); // We create a coordinate list and order it with respect to X
            for (int j = 0; j < 256; j++) {
                long startTime = System.nanoTime();
                NS.ClosestPair(i, List, 999999999);
                long endTime = System.nanoTime();
                long totalTime = endTime - startTime; // Execution time for each repetition is calculated
                tot = tot + totalTime;
            }
            C = NS.getCompar();
            C = C / 256; //The average iterations is found.
            tot = tot / 256; //The average execution time is found
            Rtimes.add((int) tot);
            id.add(i); //The total number of coordinates are stored in an arrangement
            Comparaciones.add(C);
        }
        create("Times.txt");
        write("Times.txt", id.size(), id, Comparaciones, Rtimes);
    }
}