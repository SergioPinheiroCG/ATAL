package br.edu.unifacisa.orderingsystem;

/**
 * A classe Pedido representa um pedido realizado por um cliente na cafeteria.
 * Cada pedido tem um nome de cliente, descrição, prioridade e indicação se é VIP.
 */
public class Pedido {
    private String nomeCliente;       // Nome do cliente que fez o pedido
    private String descricaoPedido;   // Descrição do pedido (ex: "Café com leite")
    private int prioridade;           // Prioridade do pedido (valores maiores indicam maior prioridade)
    private boolean isVip;            // Indica se o cliente é VIP

    // Construtor da classe Pedido que inicializa os atributos com os valores fornecidos
    public Pedido(String nomeCliente, String descricaoPedido, int prioridade, boolean isVip) {
        this.nomeCliente = nomeCliente;
        this.descricaoPedido = descricaoPedido;
        this.prioridade = prioridade;
        this.isVip = isVip;
    }

    // Getters e setters para acessar os atributos privados
    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getDescricaoPedido() {
        return descricaoPedido;
    }

    public void setDescricaoPedido(String descricaoPedido) {
        this.descricaoPedido = descricaoPedido;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }

    // Método toString sobrescrito para exibir o pedido de forma legível
    @Override
    public String toString() {
        return nomeCliente + " (Prioridade: " + prioridade + ") - Descrição: " + descricaoPedido;
    }
}
