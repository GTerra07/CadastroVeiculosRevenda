public class Carro extends Veiculos {
    double km;

    public Carro(String modelo, double preco, double km) {
        super(modelo, preco);
        this.km = km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public void insertData() {
        
    }
}
