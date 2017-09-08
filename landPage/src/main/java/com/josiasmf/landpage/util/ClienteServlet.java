package com.josiasmf.landpage.util;

import com.josiasmf.landpage.model.Cliente;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ClienteServlet")
public class ClienteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("acao");
        String destino = "sucesso.jsp";
        String mensagem = "";
        List<Cliente> lista = new ArrayList<>();

        Cliente cliente = new Cliente();
        ClienteRepository clienteRepository = new ClienteRepository();

        try {

            //Se a ação for DIFERENTE de Listar são lidos os dados da tela
            if (!acao.equalsIgnoreCase("Listar")) {
                cliente.setNome(request.getParameter("nome"));
                cliente.setEmail(request.getParameter("email"));

            }

            if (acao.equalsIgnoreCase("Incluir")) {
                // Verifica se a matrícula informada já existe no Banco de Dados
                // Se existir enviar uma mensagem senão faz a inclusão
//                if (clienteRepository.findById(serialVersionUID)) {
//                    mensagem = "Matrícula informada já existe!";
//                } else {
                    clienteRepository.insert(cliente);
//                }
            } else if (acao.equalsIgnoreCase("Alterar")) {
                clienteRepository.update(serialVersionUID, cliente);
            } else if (acao.equalsIgnoreCase("Excluir")) {
                clienteRepository.delete(serialVersionUID);
            } else if (acao.equalsIgnoreCase("Consultar")) {
                request.setAttribute("cliente", cliente);
                cliente = clienteRepository.findById(serialVersionUID);
                destino = "aluno.jsp";
            }
        } catch (Exception e) {
            mensagem += e.getMessage();
//            destino = "erro.jsp";
            e.printStackTrace();
        }

        // Se a mensagem estiver vazia significa que houve sucesso!
        // Senão será exibida a tela de erro do sistema.
        if (mensagem.length() == 0) {
            mensagem = "Cliente Cadastrado com sucesso!";
        } else {
            destino = "erro.jsp";
        }

        // Lista todos os registros existente no Banco de Dados
        lista = clienteRepository.findAll();
        request.setAttribute("listaCliente", lista);
        request.setAttribute("mensagem", mensagem);

        //O sistema é direcionado para a página 
        //sucesso.jsp Se tudo ocorreu bem
        //erro.jsp se houver algum problema.
        RequestDispatcher rd = request.getRequestDispatcher(destino);
        rd.forward(request, response);
    }
}
