import java.util.InputMismatchException;
import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        String menu = """
                *********************************************
                Mostrando a quantidade de interações 
                (for) e realizar a impressão no console 
                dos números incrementados
                *********************************************
                """;
        System.out.println(menu);

        try {
            System.out.println("Digite o primeiro parâmetro");
            int parametroUm = terminal.nextInt();
            System.out.println("Digite o segundo parâmetro");
            int parametroDois = terminal.nextInt();


            //chamando o método contendo a lógica de contagem
            contar(parametroUm, parametroDois);


        }
        catch (InputMismatchException e){
            //imprimir a mensagem: Inserir apenas numeros inteiros!
            System.out.println("Inserir apenas numeros inteiros!");
        }catch (ParametrosInvalidosException e) {
            //imprimir a mensagem: O segundo parâmetro deve ser maior que o primeiro
            System.out.println("O segundo parâmetro deve ser maior que o primeiro");
        }finally {
            //imprimir a mensagem: O programa foi finalizado!
            System.out.println("O programa foi finalizado!");
        }

    }
    static void contar(int parametroUm, int parametroDois ) throws ParametrosInvalidosException {
        //validar se parametroUm é MAIOR que parametroDois e lançar a exceção
        if (parametroUm > parametroDois){
            throw new ParametrosInvalidosException("O parametroUm deve ser menor que o parametroDois!");
        }

        //realizar o for para imprimir os números com base na variável contagem
        int contagem = parametroDois - parametroUm;
        int contagemDeRepeticoes = 0;
        for (int i = 1; i <= contagem ; i++) {
            System.out.println("Imprimindo o número " + i);
            //Contagem de repetições apenas para conferencia
            contagemDeRepeticoes++;
        }
        System.out.println("O loop foi executado " + contagemDeRepeticoes + " vezes!");

    }
}