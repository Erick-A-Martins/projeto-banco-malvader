package view;

import java.awt.*;
import java.time.LocalDate;

import javax.swing.*;

import model.Cliente;
import model.ContaCorrente;
import model.Endereco;
import model.Funcionario;

public class CadastroContaCorrente {
	public static void main(String[] args) {
        JFrame Tela = new JFrame("Banco Malvader");
        Tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        Tela.setSize(600, 600); 
        Tela.setLocationRelativeTo(null);
        Tela.setLayout(new BorderLayout());

        JLabel Titulo = new JLabel("Cadastro de conta corrente", SwingConstants.CENTER);
        Titulo.setFont(new Font("Arial", Font.BOLD, 15));
    	Titulo.setForeground(new Color(0, 102, 204));
    	Titulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        
        Tela.add(Titulo, BorderLayout.NORTH);

        JPanel Principal = new JPanel();
        Principal.setLayout(new GridLayout(16, 2, 10, 5));
        
        JScrollPane scroll = new JScrollPane(Principal);
       
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        Principal.add(new JLabel("ID:"));
        JTextField IdCliente = new JTextField(20);
        Principal.add(IdCliente);

        Principal.add(new JLabel("Agencia:"));
        JTextField Agencia = new JTextField(20);
        Principal.add(Agencia);

        Principal.add(new JLabel("Numero da conta:"));
        JTextField Numero = new JTextField(20);
        Principal.add(Numero);

        Principal.add(new JLabel("Nome do Cliente:"));
        JTextField Nome = new JTextField(20);
        Principal.add(Nome);

        Principal.add(new JLabel("CPF: "));
        JTextField CPF = new JTextField(20);
        Principal.add(CPF);

        Principal.add(new JLabel("Data de Nascimento: "));
        JTextField DataNascimento = new JTextField(20);
        Principal.add(DataNascimento);

        Principal.add(new JLabel("Telefone: "));
        JTextField Telefone = new JTextField(20);
        Principal.add(Telefone);

        Principal.add(new JLabel("Senha: "));
        JPasswordField Senha = new JPasswordField(15);
        Senha.setEchoChar('*'); 
        Principal.add(Senha);
        
        Principal.add(new JLabel("Limite: "));
        JTextField Limite = new JTextField(20);
        Principal.add(Limite);
        
        Principal.add(new JLabel("Data de vencimento: "));
        JTextField DataVencimento = new JTextField(20);
        Principal.add(DataVencimento);
        
        Principal.add(new JLabel("CEP: "));
        JTextField Cep = new JTextField(20);
        Principal.add(Cep);
        
        Principal.add(new JLabel("Local: "));
        JTextField Local = new JTextField(20);
        Principal.add(Local);
        
        Principal.add(new JLabel("Número da casa: "));
        JTextField NumCasa = new JTextField(20);
        Principal.add(NumCasa);
        
        Principal.add(new JLabel("Bairro: "));
        JTextField Bairro = new JTextField(20);
        Principal.add(Bairro);
        
        Principal.add(new JLabel("Cidade: "));
        JTextField Cidade = new JTextField(20);
        Principal.add(Cidade);
        
        Principal.add(new JLabel("Estado: "));
        JTextField Estado = new JTextField(20);
        Principal.add(Estado);

        JPanel PainelBotao = new JPanel();
        JButton Enviar = new JButton("Enviar");
        Enviar.setFont(new Font("Arial", Font.BOLD, 16));
    	Enviar.setBackground(new Color(0, 102, 204));
    	Enviar.setForeground(Color.WHITE);
    	Enviar.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        PainelBotao.add(Enviar);
        
        JButton Voltar = new JButton("Voltar");
        Voltar.setFont(new Font("Arial", Font.BOLD, 16));
    	Voltar.setBackground(new Color(0, 102, 204));
    	Voltar.setForeground(Color.WHITE);
    	Voltar.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        PainelBotao.add(Voltar);
        
        Voltar.addActionListener(env -> {            
    	    CadastroContaView.main(new String[] {});
    	    Tela.dispose();
        });
        
        Enviar.addActionListener(env -> {
            Tela.dispose();

            ContaCorrente cc = new ContaCorrente();
            cc.setAgencia_conta(Agencia.getText());
            cc.setNumero_conta(Integer.parseInt(Numero.getText()));
            cc.setLimite(Integer.parseInt(Limite.getText()));

            cc.setDataVencimento(LocalDate.parse(DataVencimento.getText()));

            String id = IdCliente.getText();
            int idCliente = Integer.parseInt(id);

            String nome = Nome.getText();
            String cpf = CPF.getText();
            LocalDate dataNasc = LocalDate.parse(DataNascimento.getText());
            String telefone = Telefone.getText();
            char[] senha = Senha.getPassword();
            String senhaString = new String(senha);
            Endereco end = new Endereco();
            
            // SETTERS DO ENDEREÇO ABAIXO
            
            end.setCep(Cep.getText());
            end.setLocal(Local.getText());
            end.setNumeroCasa(Integer.parseInt(NumCasa.getText()));
            end.setBairro(Bairro.getText());
            end.setCidade(Cidade.getText());
            end.setEstado(Estado.getText());
            
            //

            Cliente c = new Cliente(idCliente, nome, cpf, dataNasc, telefone, end, senhaString);
            cc.setCliente(c);

            Funcionario.abrirConta(cc, end);
        });
        
        
        Tela.add(new JScrollPane(Principal), BorderLayout.CENTER);
        Tela.add(PainelBotao, BorderLayout.SOUTH);

        Tela.setVisible(true);   
    }

}
