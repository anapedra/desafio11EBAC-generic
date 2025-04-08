package org.anasantana.utils;

import java.io.FileWriter;
import java.io.IOException;

public class CarCSVGenerator {

    public static void generateSampleCSV(String outputFilePath) {
        String[] sampleData = {
            "honda,1,Honda,Civic,ABC1D23,9BWZZZ377VT004251,2018,NOVO,true",
            "ford,2,Ford,Focus,DEF2E45,9BWZZZ377VT004252,2019,USADO,false",
            "toyota,3,Toyota,Corolla,GHI3F67,9BWZZZ377VT004253,2020,NOVO,true",
            "honda,4,Honda,Fit,JKL4G89,9BWZZZ377VT004254,2021,USADO,false",
            "ford,5,Ford,Ka,MNO5H01,9BWZZZ377VT004255,2022,NOVO,true"
        };

        try (FileWriter writer = new FileWriter(outputFilePath)) {
            for (String line : sampleData) {
                writer.write(line + "\n");
            }
            System.out.println(" Arquivo cars.csv gerado com sucesso em: " + outputFilePath);
        } catch (IOException e) {
            System.err.println("Erro ao gerar arquivo cars.csv: " + e.getMessage());
        }
    }
}
