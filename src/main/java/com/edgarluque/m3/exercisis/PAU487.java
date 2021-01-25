package com.edgarluque.m3.exercisis;

public class PAU487 {
    public static void run() {
        MenuConstructorPantalla menu = new MenuConstructorPantalla();
        menu.addTitle("Orbita 10", true);
        menu.addEmptyLine();
        menu.addLine("PAU-487", true);
        menu.addEmptyLine();

        menu.addLine("1. Crea productes i els fica en la BD per inicialitzar-la", false);
        menu.addEmptyLine();
        menu.addLine("2. Crea encarrecs i els fica en la BD per inicialitzar-la", false);
        menu.addEmptyLine();
        menu.addLine("3. Crea els departaments, a partir dels que hi ha en IKSRotarranConstants.DEPARTAMENTS, i els fica en la BD", false);
        menu.addEmptyLine();
        menu.addLine("4. Assigna els encàrrecs als departaments i els productes als encàrrecs", false);
        menu.addEmptyLine();
        menu.addEmptyLine();
        menu.addLine("10. Veure tots els productes que hi ha en la BD", false);
        menu.addEmptyLine();
        menu.addLine("11. Veure tots els encàrrecs que hi ha en la BD", false);
        menu.addEmptyLine();
        menu.addLine("12. Veure tots els departaments que hi ha en la BD", false);
        menu.addEmptyLine();
        menu.addLine("13. Veure totes les dades de tots els departaments que hi ha en la BD", false);
        menu.addEmptyLine();
        menu.addLine("14. Veure els departaments que han comprat 1 producte concret", false);
        menu.addEmptyLine();
        menu.addEmptyLine();
        menu.addLine("20. Exporta els productes a un XML", false);
        menu.addEmptyLine();
        menu.addLine("21. Importa en la BD els productes que hi ha en el XML", false);
        menu.addEmptyLine();
        menu.addEmptyLine();
        menu.addLine("40. Esborrat del \"departament d'Enginyeria\"", false);
        menu.addEmptyLine();
        menu.addLine("41. Esborrat en cascada del \"departament Comandament\"", false);
        menu.addEmptyLine();
        menu.addEmptyLine();
        menu.addEmptyLine();
        menu.addLine("50. Tancar el sistema", false);
        menu.addEmptyLine();
    }
}
