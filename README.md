# DIO - Trilha Java Básico
www.dio.me

#### Autores
- [Gleyson Sampaio](https://github.com/glysns)

## Controle de Fluxo - Desafio

Vamos exercitar todo o conteúdo apresentado no módulo de Controle de Fluxo codificando o seguinte cenário.

O sistema deverá receber dois parâmetros via terminal que representarão dois números inteiros, com estes dois números você deverá obter a quantidade de interações (for) e realizar a impressão no console (System.out.print) dos números incrementados, exemplo:

* Se você passar os números 12 e 30, logo teremos uma interação (for) com 18 ocorrências para imprimir os números, exemplo: `"Imprimindo o número 1"`, `"Imprimindo o número 2"` e assim por diante.
* Se o primeiro parâmetro for MAIOR que o segundo parâmetro, você deverá lançar a exceção customizada chamada de `ParametrosInvalidosException` com a segunda mensagem: "O segundo parâmetro deve ser maior que o primeiro"   


1. Crie o projeto `DesafioControleFluxo`
2. Dentro do projeto, crie a classe `Contador.java` para realizar toda a codificação do nosso programa.
3. Dentro do projeto, crie a classe `ParametrosInvalidosException` que representará a exceção de negócio no sistema. 

Abaixo temos um trecho de código no qual você poderá seguir alterando as partes que contenham `??`

```java
public class Contador {
	public static void main(String[] args) {
		Scanner terminal = new Scanner(System.in);
		System.out.println("Digite o primeiro parâmetro");
		int parametroUm = terminal.??;
		System.out.println("Digite o segundo parâmetro");
		int parametroDois = terminal.??;
		
		try {
			//chamando o método contendo a lógica de contagem
			contar(parametroUm, parametroDois);
		
		}catch (? exception) {
			//imprimir a mensagem: O segundo parâmetro deve ser maior que o primeiro
		}
		
	}
	static void contar(int parametroUm, int parametroDois ) throws ParametrosInvalidosException {
		//validar se parametroUm é MAIOR que parametroDois e lançar a exceção
		
		int contagem = parametroDois - parametroUm;
		//realizar o for para imprimir os números com base na variável contagem
	}
}
```

## Acima estava o codigo que deveria realizar, abaixo o codigo que fiz com algumas alterações.

```java
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
```
