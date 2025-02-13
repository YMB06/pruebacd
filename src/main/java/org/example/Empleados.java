package org.example;

// Clase principal EmpleadoBR
public class Empleados {

    public void main(String[] args) {
        CalculadoraSalarios calculadora = new CalculadoraSalarios();
        try {
            float salarioBruto = calculadora.calculaSalarioBruto(TipoEmpleado.vendedor, 1200, 10);
            float salarioNeto = calculadora.calculaSalarioNeto(salarioBruto);
            System.out.println("Salario Bruto: " + salarioBruto);
            System.out.println("Salario Neto: " + salarioNeto);
        } catch (BRException e) {
            e.printStackTrace();
        }
    }

    public enum TipoEmpleado {
        vendedor, encargado
    }

    public class BRException extends Exception {
        public BRException(String message) {
            super(message);
        }
    }

    public class CalculadoraSalarios {

        public float calculaSalarioBruto(TipoEmpleado tipo, float ventasMes, float horasExtra) throws BRException {
            if (tipo == null || ventasMes < 0 || horasExtra < 0) {
                throw new BRException("Parámetros inválidos.");
            }
            float salarioBase = (tipo == TipoEmpleado.vendedor) ? 1000 : 1500;
            float prima = (ventasMes >= 1500) ? 200 : (ventasMes >= 1000) ? 100 : 0;
            return salarioBase + prima + horasExtra * 20;
        }

        public float calculaSalarioNeto(float salarioBruto) throws BRException {
            if (salarioBruto < 0) {
                throw new BRException("Salario bruto no puede ser negativo.");
            }
            float retencion = (salarioBruto >= 1500) ? 0.18f : (salarioBruto >= 1000) ? 0.16f : 0f;
            return salarioBruto * (1 - retencion);
        }
    }
}


/*Método | Especificación

float calculaSalarioBruto(TipoEmpleado tipo, float ventasMes, float horasExtra)
El salario base será 1000 euros si el empleado es de tipo TipoEmpleado.vendedor, y de 1500 euros si es de tipo TipoVendedor.encargado. A esta cantidad se le sumará una prima de 100 euros si ventasMes es mayor o igual que 1000 euros, y de 200 euros si fuese al menos de 1500 euros. Por último, cada hora extra se pagará a 20 euros. Si tipo es null, o ventasMes o horasExtra toman valores negativos, el método lanzará una excepción de tipo BRException.

float calculaSalarioNeto(float salarioBruto)
Si el salario bruto es menor de 1000 euros, no se aplicará ninguna retención.
Para salarios a partir de 1000 euros, y menores de 1500 euros, se les aplicará un 16%, y a los salarios a partir de 1500 euros se les aplicará un 18%.
El método nos devolverá salarioBruto * (1 - retencion), o BRException si el salario es menor que cero.*/