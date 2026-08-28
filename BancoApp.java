import java.util.Scanner;

public class BancoApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione tipo de cuenta:");
        System.out.println("1. Cuenta de Ahorros");
        System.out.println("2. Cuenta Corriente");

        int opcion = scanner.nextInt();
        Cuenta cuenta;

        if (opcion == 1) {
            cuenta = new Cuentahorros("Ximena", 1000);
        } else {
            cuenta = new Cuentacorriente("Ximena", 1000);
        }

        // Menú secundario
        while (true) {
            System.out.println("1. Retirar");
            System.out.println("2. Depositar");
            System.out.println("3. Consultar saldo");
            System.out.println("4. Salir");

            int op = scanner.nextInt();
            switch (op) {
                case 1:
                    System.out.print("Monto a retirar: ");
                    double monto = scanner.nextDouble();
                    cuenta.retirar(monto);
                    break;
                case 2:
                    System.out.print("Monto a depositar: ");
                    double dep = scanner.nextDouble();
                    cuenta.depositar(dep);
                    break;
                case 3:
                    System.out.println("Saldo actual: " + cuenta.getSaldo());
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    return;
            }
        }
    }
}

abstract class Cuenta {
    private String titular;
    private double saldo;
    //private double comision;

public Cuenta(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public String gettitular() {return titular;}
    public void settitular(String titular) {this.titular = titular;}

    public double getSaldo () {return saldo;}
    public void setsaldo(double saldo) {this.saldo = saldo;}
    
    public abstract void retirar (double monto);
    public abstract void depositar (double monto2);
}

    class Cuentahorros extends Cuenta {
         public Cuentahorros(String titular, double saldo) {
        super(titular, saldo);
    }
    public void retirar(double monto) {
        if (getSaldo() >= monto) {
            setsaldo(getSaldo() - monto);
            System.out.println("retiro exitoso, saldo actual:"+ getSaldo());
            } 
        System.out.println("Saldo insuficiente" + getSaldo());
        } 
        public void depositar(double monto2) {
        if (monto2>10000) {
            System.out.println("monto excedido");
        }
        setsaldo(getSaldo() + monto2);
        System.out.println("consignacion exitosa" + getSaldo());
    }
}
     class Cuentacorriente extends Cuenta {
        public Cuentacorriente(String titular, double saldo) {
        super(titular, saldo);
    }
        public void retirar (double monto){
            double sobregiro = 10.5;
            sobregiro = getSaldo() + sobregiro;
             if (sobregiro >= monto) {
            setsaldo(sobregiro - monto);
            System.out.println("retiro exitoso, saldo actual:"+ getSaldo());
            } 
        System.out.println("Saldo insuficiente, monto superior al sobregiro, saldo:" + getSaldo()+ "sobregiro" +sobregiro);
        } 
        public void depositar(double monto2) {
        if (monto2>10000) {
            System.out.println("monto excedido");
        }
        setsaldo(getSaldo() + monto2);
        System.out.println("consignacion exitosa" + getSaldo());
        }
     }
    

     

