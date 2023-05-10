package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class NovaEmpresa {
	
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		System.out.println("Cadastrando nova empresa");

		String nomeDaEmpresa = request.getParameter("nome");
		String paramAberturaEmpresa = request.getParameter("data");
		
		Date dataAberturaEmpresa = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAberturaEmpresa = sdf.parse(paramAberturaEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeDaEmpresa);
		empresa.setDataAbertura(dataAberturaEmpresa);
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		response.sendRedirect("entrada?acao=ListaEmpresas");
	}

}
