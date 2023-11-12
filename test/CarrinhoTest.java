package com.ada.test;

import com.ada.loja.Carrinho;
import com.ada.loja.Produto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarrinhoTest {

    @Test
    public void carrinhoInicialmenteVazio() {
        Carrinho carrinho = new Carrinho();
        Assertions.assertTrue(carrinho.isVazio());
        Assertions.assertEquals(0, carrinho.getQtde());
    }

    @Test
    public void adicionarProdutoAumentaQtde() {
        Carrinho carrinho = new Carrinho();
        Produto produto = new Produto(1,"Camiseta", 10.00);
        carrinho.adicionar(produto);
        Assertions.assertFalse(carrinho.isVazio());
        Assertions.assertEquals(1, carrinho.getQtde());
    }

    @Test
    public void adicionarProdutoDuplicadoNaoAumentaQtde() {
        Carrinho carrinho = new Carrinho();
        Produto produto = new Produto(1,"Camiseta", 10.00);
        carrinho.adicionar(produto);
        carrinho.adicionar(produto);
        Assertions.assertFalse(carrinho.isVazio());
        Assertions.assertEquals(1, carrinho.getQtde());
    }

    @Test
    public void verificaExistenciaDeProdutoAdicionado() {
        Carrinho carrinho = new Carrinho();
        Produto produto = new Produto(1,"Camiseta", 10.00);
        carrinho.adicionar(produto);
        Assertions.assertTrue(carrinho.contem(produto));
    }

    @Test
    public void verificaNaoExistenciaDeProdutoNaoAdicionado() {
        Carrinho carrinho = new Carrinho();
        Produto produto = new Produto(2,"Calça", 20.00);
        Assertions.assertFalse(carrinho.contem(produto));
    }
}