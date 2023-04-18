import java.util.Scanner;

public class CalculadoraService {

    public void calcular(){

        Scanner scanner = new Scanner(System.in);

        double result = 0;
        String operator = "";
        boolean done = false;

        while (!done) {

            // Se solicita al usuario que ingrese un número y un operador.

            System.out.print("Ingrese un número y un operador (ejemplo: 5 +): ");

            // Se lee la entrada del usuario y se eliminan todos los espacios en blanco.
            String input = scanner.nextLine().replaceAll("\\s", "");

            // Si el usuario ingresa "exit", se termina el programa.
            if (input.equals("exit")) {
                done = true;
                // Si el usuario ingresa un número seguido de un operador válido, se realiza la operación correspondiente.
            } else if (input.matches("-?\\d+(\\.\\d+)?[+\\-*/%]")) {
                double number = Double.parseDouble(input.replaceAll("[+\\-*/%]", ""));
                String newOperator = input.replaceAll("\\d", "");
                // Se verifica si el usuario intenta dividir por cero.
                if (newOperator.equals("/") && number == 0) {
                    System.out.println("No se puede dividir por cero!");
                } else {
                    // Si hay un operador anterior, se realiza la operación correspondiente con el resultado actual.
                    if (!operator.isEmpty()) {
                        switch (operator) {
                            case "+":
                                result += number;
                                break;
                            case "-":
                                result -= number;
                                break;
                            case "*":
                                result *= number;
                                break;
                            case "/":
                                result /= number;
                                break;
                            case "%":
                                result %= number;
                                break;
                        }
                        System.out.println("Resultado parcial: " + result);
                    } else {
                        // Si no hay un operador anterior, se establece el resultado actual como el número ingresado.
                        result = number;
                    }
                    operator = newOperator;
                }
            } else if (input.matches("-?\\d+(\\.\\d+)?")) {

                // Si el usuario ingresa solo un número, se utiliza el operador anterior para realizar la operación correspondiente.
                double number = Double.parseDouble(input);

                if (!operator.isEmpty()) {
                    switch (operator) {
                        case "+":
                            result += number;
                            break;
                        case "-":
                            result -= number;
                            break;
                        case "*":
                            result *= number;
                            break;
                        case "/":
                            if (number == 0) {
                                // No se permite la división por cero
                                System.out.println("No se puede dividir por cero!");
                            } else {
                                result /= number;
                            }
                            break;
                        case "%":
                            if (number == 0) {
                                // No se permite la división por cero
                                System.out.println("No se puede dividir por cero!");
                            } else {
                                result %= number;
                            }
                            break;
                    }
                    System.out.println("Resultado Parcial: " + result);
                }
            } else {
                // Si el usuario ingresa una entrada inválida, se muestra un mensaje de error.
                System.out.println("Entrada invalida!");
            }
        }
        System.out.println("Resultado final: " + result);
    }
}
