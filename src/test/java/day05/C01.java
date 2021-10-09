package day05;

import org.junit.Test;

public class C01 {

    //Javadaki gibi seleniumda da belirli islevleri yapan methodlar olusturabiliriz
    //Ancak bu methodlar cagrilmadikca calismazlar
    public void ilkTestMethodu () {

        System.out.println("Ilk test methodumuz");
    }

    //JUnit ile notasyon kullanarak siradan methodlari test methoduna donusturebiliriz
    //Bir Test methodu bagimsiz olarak calisabilen test yapmamiza imkan verir
    //test notasyonu sayesinde main method mecburiyeti ortadan kalkar
    @Test
    public void notasyonluIlkTestMethodu () {
        System.out.println("notasyonlu ilk test methodumuz");
    }

}
