import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.synapsisit.model.Cliente;
import com.synapsisit.model.ItemPedido;
import com.synapsisit.model.PedidoVenda;
import com.synapsisit.model.builder.PedidoVendaBuilder;


public class PedidoVendaTest {
	
	@Test
	public void deveCalucularPedidoParaClienteVip() {
		PedidoVenda pedidoVenda = new PedidoVenda();
		
		//Gerando um pedido de venda;
		
		Cliente cliente = new Cliente();
		cliente.setNome("João");
		cliente.setVip(true);
		pedidoVenda.setCliente(cliente);
		
		ItemPedido item1 = new ItemPedido();
		
		item1.setNome("Bolsa");
		item1.setQuantidade(2);
		item1.setValorUnitario(new BigDecimal("200"));
		
		ItemPedido item2 = new ItemPedido();
		
		item2.setNome("Carteira");
		item2.setQuantidade(1);
		item2.setValorUnitario(new BigDecimal("200"));
		
		//criar uma lista de itens com Arrays.asList(list)
		List<ItemPedido> itensPedido = Arrays.asList(item1, item2);
		pedidoVenda.setItensPedido(itensPedido);
		
		BigDecimal valorTotal = pedidoVenda.getValorTotal();
		
		//Comparação JUnit
		assertEquals(new BigDecimal("576").doubleValue(), valorTotal.doubleValue(), 0.0001);
	}
	
	@Test
	public void deveCalcularValorTotalPedidoParaClienteVipComBuilder() {
		PedidoVenda pedidoVenda = new PedidoVendaBuilder()
												.comClienteVip("João Silva")
												.comItem("Calcuadora", 2, "200")
												.comItem("Mochila", 1, "200")
												.construir();
		
		BigDecimal valorTotal = pedidoVenda.getValorTotal();
		
		//Comparação JUnit
		assertEquals(new BigDecimal("576").doubleValue(), valorTotal.doubleValue(), 0.0001);
	}
	
}
