public class ContaBanco {

    public int numConta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;

    public void estadoAtual() {
        System.out.println("------------------------------------");
        System.out.println("Conta: " + this.getNumConta());
        System.out.println("Tipo: " + this.getTipo());
        System.out.println("Dono: " + this.getDono());
        System.out.println("Saldo: " + this.getSaldo());
        System.out.println("Status: " + this.getStatus());
    }

    public void abrirConta(String t) {
        this.setTipo(t);
        this.setStatus(true);
        if (t == "cc") {
            this.setSaldo (50);
        } else if(t == "cp") {
            this.setSaldo(150);
        }
        System.out.println("Conta Aberta com Sucesso");
    }
    
    public void fecharConta() {
        if(this.getSaldo() > 0) {
            System.out.println("Conta ainda possui dinheiro");
        } else if (this.getSaldo() < 0){
            System.out.println("Sua conta esta em debito");
        } else {
            this.setStatus(false);
            System.out.println("Conta fechado com sucesso");
        }
    }

    public void depositar(float v) {
        if (this.getStatus()) {
            this.setSaldo(this.getSaldo() + v);
            System.out.println("Deposito realizado com sucesso na conta " + this.getDono());
        } else {
            System.out.println("Impossível depositar");
        }
    }

    public void sacar(float v) {
        if (this.getStatus()) {
            if (this.getSaldo() >= v) {
                this.setSaldo(this.getSaldo() - v);
                System.out.println("Saque realizado na conta de " + getDono());
            } else {
                System.out.println("Saldo insuficiente para saque");
            }
        } else {
            System.out.println("Impossível sacar de uma conta fechada !");
        }
    }

    public void pagarMensalidade() {
        int v = 0;
        if (this.getTipo() == "cc") {
            v = 12;
        } else if (this.getTipo() == "cp"){
            v = 20;
        }
        if (this.getStatus()) {
            this.setSaldo(this.getSaldo() - v);
            System.out.println("Mensalidade paga com sucesso por " + this.getDono());
        } else {
            System.out.println("Impossível pagar uma conta fechada!");
        }
    }

    public ContaBanco() {
        this.setSaldo(0);
        this.setStatus(false);
    }

    public void setNumConta(int n) {
        this.numConta = n;
    }

    public int getNumConta() {
        return this.numConta;
    }

    public void setTipo(String t) {
        this.tipo = t;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setDono(String d) {
        this.dono = d;
    }

    public String getDono() {
        return this.dono;
    }

    public void setSaldo(float s) {
        this.saldo = s;
    }

    public float getSaldo() {
        return this.saldo;
    }

    public void setStatus(boolean s) {
        this.status = s;
    }

    public boolean getStatus() {
        return this.status;
    }

}   