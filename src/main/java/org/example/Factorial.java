package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
        public class Factorial {
    public static int calculo(int valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("El número debe ser mayor que 0");
        }
        int facto = 1;
        for (int i = 2; i <= valor; i++) {
            facto *= i;
        }
        if (facto < 0) {
            throw new ArithmeticException("Overflow, número " + valor + " demasiado grande");
        }

        return facto;
    }
}

/*       public class Factorial {
   public static int calculo(int valor)[1] {
       if (valor < 0) [2] {
           throw new IllegalArgumentException("El número debe ser mayor que 0");[3]
       }
       int facto = 1;
       for (int i = 2; i <= valor; i++)[4] {
           facto *= i;[5]
       }
       if (facto < 0)[6] {
           throw new ArithmeticException("Overflow, número " + valor + " demasiado grande");[7]
       }


       return facto; [8]
   }
}
*/
