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


