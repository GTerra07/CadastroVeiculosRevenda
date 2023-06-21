public class Moto extends Veiculos {
    int ano;

    public Moto(String modelo, double preco, int ano) {
        super(modelo, preco);
        this.ano = ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void insertData() {
       
    }
}
