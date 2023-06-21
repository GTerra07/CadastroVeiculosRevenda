import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroVeiculos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Veiculos> veiculos = new ArrayList<>();

        System.out.println("Cadastro de Veículos");
        System.out.println("Selecione o tipo de veículo: ");
        System.out.println("1. Moto");
        System.out.println("2. Carro");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();

        System.out.print("Preço: ");
        double preco = scanner.nextDouble();

        if (opcao == 1) {
            System.out.print("Ano: ");
            int ano = scanner.nextInt();

            Moto moto = new Moto(modelo, preco, ano);
            veiculos.add(moto);
        } else if (opcao == 2) {
            System.out.print("Kilometragem: ");
            double km = scanner.nextDouble();

            Carro carro = new Carro(modelo, preco, km);
            veiculos.add(carro);
        }

        System.out.println("Relatório de Veículos:");
        for (Veiculos veiculo : veiculos) {
            veiculo.printDados();
        }

        double totalPreco = calcularTotalPreco(veiculos);
        System.out.println("Total de Preços: " + totalPreco);

        reajustarPrecos(veiculos);

        System.out.println("Relatório de Veículos após reajuste de preços:");
        for (Veiculos veiculo : veiculos) {
            veiculo.printDados();
        }

        double novoTotalPreco = calcularTotalPreco(veiculos);
        System.out.println("Novo Total de Preços: " + novoTotalPreco);
    }

    public static double calcularTotalPreco(List<Veiculos> veiculos) {
        double total = 0.0;
        for (Veiculos veiculo : veiculos) {
            total += veiculo.getPreco();
        }
        return total;
    }

    public static void reajustarPrecos(List<Veiculos> veiculos) {
        for (Veiculos veiculo : veiculos) {
            if (veiculo instanceof Moto) {
                Moto moto = (Moto) veiculo;
                if (moto.ano >= 2008) {
                    double novoPreco = moto.getPreco() * 1.10;
                    moto.setPreco(novoPreco);
                }
            } else if (veiculo instanceof Carro) {
                Carro carro = (Carro) veiculo;
                if (carro.km > 100000) {
                    double novoPreco = carro.getPreco() * 0.92;
                    carro.setPreco(novoPreco);
                }
            }
        }
    }
}
