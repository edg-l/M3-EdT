package com.edgarluque.m3;

/**
 * Hello world!
 *
 */
public class PNS24_Puma
{
    public static void main( String[] args ) {
        TextFrame textFrame = new TextFrame();
        textFrame.addTitle("Orbita 10", true);
        textFrame.addEmptyLine();
        textFrame.addLine("PNS-24 Puma" ,true);
        textFrame.addEmptyLine();
        textFrame.addSeparator();
        textFrame.addLine("1. Sistema de navegació Krona", false);
        textFrame.addLine("2. Sistema d'atac Orion", false);
        textFrame.addLine("3. Sistema de defensa Sirena", false);
        textFrame.addLine("4. Sistema de comunicacions Evkalipt", false);
        textFrame.addLine("5. Sistema d'identificació Khom-Nikel", false);
        textFrame.addLine("6. Sistema de visualització PPV", false);
        textFrame.addLine("7. Sistema de grabació Kristall", false);
        textFrame.addEmptyLine();
        textFrame.addLine("10. Control de sondes Delta", false);
        textFrame.addEmptyLine();
        textFrame.addLine("50. Tancar el sistema", false);
        textFrame.addEmptyLine();
        textFrame.addSeparator();
        System.out.println(textFrame.toString());
    }
}
