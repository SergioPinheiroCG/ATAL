package br.edu.unifacisa.orderingsystem;

import java.util.PriorityQueue;
import java.util.Comparator;

public class GerenciamentoPedidos {
    private PriorityQueue<Pedido> filaPedidos;

    public GerenciamentoPedidos() {
        // Comparator para garantir que VIPs tenham prioridade maior
        filaPedidos = new PriorityQueue<>(new Comparator<Pedido>() {
            public int compare(Pedido p1, Pedido p2) {
                return p2.getPrioridade() - p1.getPrioridade(); // maior prioridade primeiro
            }
        });
    }

    // Adiciona um novo pedido
    public void adicionarPedido(String nomeCliente, String descricaoPedido, int prioridade, boolean isVip) {
        Pedido novoPedido = new Pedido(nomeCliente, descricaoPedido, prioridade, isVip);
        filaPedidos.add(novoPedido);
    }

    // Processa o próximo pedido (remove da fila)
    public Pedido processarProximoPedido() {
        return filaPedidos.poll();
    }

    // Visualiza todos os pedidos na fila sem removê-los
    public void visualizarPedidos() {
        if (filaPedidos.isEmpty()) {
            System.out.println("Nenhum pedido na fila.");
        } else {
            for (Pedido p : filaPedidos) {
                System.out.println(p);
            }
        }
    }

    // Remove um pedido cancelado
    public void removerPedidoCancelado(Pedido pedido) {
        filaPedidos.remove(pedido);
    }

    // Atualiza a prioridade de um pedido na fila
    public void atualizarPrioridade(Pedido pedido, int novaPrioridade) {
        filaPedidos.remove(pedido); // Remove o pedido antigo
        pedido.setPrioridade(novaPrioridade); // Atualiza a prioridade
        filaPedidos.add(pedido); // Adiciona novamente com nova prioridade
    }

    // Método para buscar um pedido na fila pelo nome do cliente
    public Pedido buscarPedidoPorNome(String nomeCliente) {
        for (Pedido p : filaPedidos) {
            if (p.getNomeCliente().equalsIgnoreCase(nomeCliente)) {
                return p;
            }
        }
        return null; // Retorna null se o pedido não for encontrado
    }
}
