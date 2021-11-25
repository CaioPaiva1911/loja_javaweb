package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBQuery;

public class Produtos {
	private int idProduto;
	private String fabricante;
	private String nome;
	private String marca;
	private String modelo;
	private int idCategoria;
	private String descricao;
	private String unidadeMedida;
	private double largura;
	private double altura;
	private double profundidade;
	private double peso;
	private String cor;

	private String tableName = "lojinha.produtos";
	private String fieldsName = "idProduto, fabricante, nome, marca, modelo, idCategoria, descricao, unidadeMedida, double largura, double altura, double profundidade, double peso, cor";
	private String keyField = "idProduto";
	
	private DBQuery dbQuery = null;
	
	public Produtos(){
		this.dbQuery = new DBQuery(this.tableName, this.fieldsName, this.keyField);
	}
	
	public Produtos(int idProduto, String fabricante, String nome, String marca, String modelo, int idCategoria, String descricao, String unidadeMedida, double largura, double altura, double profundidade, double peso, String cor) {
		this.dbQuery = new DBQuery(this.tableName, this.fieldsName, this.keyField);
		
		this.setIdProduto( idProduto );
		this.setFabricante(fabricante);
		this.setNome( nome );
		this.setMarca(marca);
		this.setModelo( modelo );
		this.setIdCategoria(idCategoria);
		this.setDescricao( descricao );
		this.setUnidadeMedida(unidadeMedida);
		this.setLargura( largura );
		this.setProfundidade(profundidade);
		this.setPeso( peso );
		this.setCor(cor);
		
	}
	
	public Produtos(String idProduto, String fabricante, String nome, String marca, String modelo, String idCategoria, String descricao, String unidadeMedida, double largura, double altura, double profundidade, double peso, String cor) {
		this.dbQuery = new DBQuery(this.tableName, this.fieldsName, this.keyField);
		
		this.setIdProduto(((idProduto==null)?0:Integer.valueOf(idProduto)));
		this.setFabricante(fabricante);
		this.setNome( nome );
		this.setMarca(marca);
		this.setModelo( modelo );
		this.setIdCategoria(((idCategoria==null)?0:Integer.valueOf(idCategoria)));
		this.setDescricao( descricao );
		this.setUnidadeMedida(unidadeMedida);
		this.setLargura( largura );
		this.setProfundidade(profundidade);
		this.setPeso( peso );
		this.setCor(cor);
		
	}
	
	public String[] toArray() {
		return(
				new String[] {
					""+this.getIdProduto(),
					""+this.getFabricante(),
					""+this.getNome(),
					""+this.getMarca(),
					""+this.getModelo(),
					""+this.getIdCategoria(),
					""+this.getDescricao(),
					""+this.getUnidadeMedida(),
					""+this.getLargura(),
					""+this.getProfundidade(),
					""+this.getPeso(),
					""+this.getCor()
				}
				
		);
	}
	
	public void save() {
		if((this.getIdProduto() == 0)) {
			this.dbQuery.insert(this.toArray());
		} else {
			this.dbQuery.update(this.toArray());
		}
	}
	
	public void delete() {
		if (this.getIdProduto() > 0) {
			this.dbQuery.delete(this.toArray());
		}
	}
	
	public String listAll() {
		ResultSet rs = this.dbQuery.select("");
		String saida = "<br>";
		saida += "<table border=1>";
		
		try {
			while(rs.next()) {
				saida += "<tr>";
				saida += "<td>" + rs.getString("idProduto") + "</td>";
				saida += "<td>" + rs.getString("fabricante") + "</td>";
				saida += "<td>" + rs.getString("nome") + "</td>";
				saida += "<td>" + rs.getString("marca") + "</td>";
				saida += "<td>" + rs.getString("modelo") + "</td>";
				saida += "<td>" + rs.getString("idCategoria") + "</td>";
				saida += "<td>" + rs.getString("idCategoria") + "</td>";
				saida += "<td>" + rs.getString("descricao") + "</td>";
				saida += "<td>" + rs.getString("unidadeMedida") + "</td>";
				saida += "<td>" + rs.getString("largura") + "</td>";
				saida += "<td>" + rs.getString("profundidade") + "</td>";
				saida += "<td>" + rs.getString("peso") + "</td>";
				saida += "<td>" + rs.getString("cor") + "</td>";
				saida += "</tr><br>";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		saida += "</table>";
		return (saida);
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public double getLargura() {
		return largura;
	}

	public void setLargura(double largura) {
		this.largura = largura;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getProfundidade() {
		return profundidade;
	}

	public void setProfundidade(double profundidade) {
		this.profundidade = profundidade;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
	
	
	
	
	
	
	
}
