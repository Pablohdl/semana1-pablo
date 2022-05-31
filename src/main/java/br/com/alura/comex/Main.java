package br.com.alura.comex;

import br.com.alura.comex.model.Pedido;
import br.com.alura.comex.processadores.ProcessadorDeCSV;
import br.com.alura.comex.processadores.ProcessadorDeJSON;
import br.com.alura.comex.processadores.ProcessadorDeXML;
import br.com.alura.comex.relatorios.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException {

        String arquivoCSV = "src/main/resources/pedidos.csv";
        List<Pedido> pedidosCSV = new ProcessadorDeCSV().getPedidos(arquivoCSV);

        String xmlPedido = "src/main/resources/pedidos.xml";
        List<Pedido> pedidosXML = new ProcessadorDeXML().getPedidos(xmlPedido);

        String jsonPedido = "src/main/resources/pedidos.json";
        List<Pedido> pedidosjson = new ProcessadorDeJSON().getPedidos(jsonPedido);

        RelatorioSintetico sintetico = new RelatorioSintetico(pedidosXML);
        RelatorioClientesFieis fidelidade = new RelatorioClientesFieis(pedidosXML);
        RelatorioCategoriaQuantidade category = new RelatorioCategoriaQuantidade(pedidosXML);
        RelatorioClientesMaisLucrativos lucrativo = new RelatorioClientesMaisLucrativos(pedidosXML);
        RelatorioProdutosMaisVendidos prod = new RelatorioProdutosMaisVendidos(pedidosXML);
        RelatorioProdutoMaisCaroCategoria prodcaro = new RelatorioProdutoMaisCaroCategoria(pedidosXML);

        RelatorioSintetico.imprimirRelatorioValoresTotais(sintetico);
        RelatorioClientesFieis.imprimirRelatorioClientesFieis(fidelidade);
        RelatorioCategoriaQuantidade.imprimirRelatorioDeCategorias(category);
        RelatorioProdutosMaisVendidos.imprimirRelatorioDeProdutosMaisVendidos(prod);
        RelatorioClientesMaisLucrativos.imprimirRelatorioDeClientesMaisLucrativos(lucrativo);
        RelatorioProdutoMaisCaroCategoria.imprimirRelatorioDeProdutosMaisCaroCategoria(prodcaro);


    }

    }


