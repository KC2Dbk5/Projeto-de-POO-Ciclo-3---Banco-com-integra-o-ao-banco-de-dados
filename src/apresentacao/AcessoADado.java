package apresentacao;

import java.sql.*;

public class AcessoADado {
    private static final String URL = "jdbc:postgresql://localhost:5432/seu_banco";
    private static final String USUARIO = "seu_usuario";
    private static final String SENHA = "sua_senha";

    private Connection conexao;

    // Construtor para inicializar a conexão
    public AcessoADado() {
        try {
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    // Método para cadastrar uma conta
    public String cadastrar_conta(String numero, float saldo) {
        String sql = "INSERT INTO contas (numero, saldo) VALUES (?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, numero);
            stmt.setFloat(2, saldo);
            stmt.executeUpdate();
            return "Conta cadastrada com sucesso.\n";
        } catch (SQLException e) {
            return "Erro ao cadastrar conta: " + e.getMessage() + "\n";
        }
    }

    // Método para cadastrar uma conta normal
    public String cadastrar_conta_normal(String numero) {
        String sql = "INSERT INTO conta_normal (numero) VALUES (?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, numero);
            stmt.executeUpdate();
            return "Conta normal cadastrada com sucesso.\n";
        } catch (SQLException e) {
            return "Erro ao cadastrar conta normal: " + e.getMessage() + "\n";
        }
    }

    // Método para atualizar saldo
    public String atualizar_saldo(String numero, double saldo) {
        String sql = "UPDATE contas SET saldo = ? WHERE numero = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setDouble(1, saldo);
            stmt.setString(2, numero);
            stmt.executeUpdate();
            return "Saldo atualizado com sucesso.\n";
        } catch (SQLException e) {
            return "Erro ao atualizar saldo: " + e.getMessage() + "\n";
        }
    }

    // Método para consultar contas
    public String listar_contas() {
        String sql = "SELECT * FROM contas";
        StringBuilder resultado = new StringBuilder();
        try (Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                resultado.append("Número: ").append(rs.getString("numero"))
                         .append(", Saldo: ").append(rs.getDouble("saldo")).append("\n");
            }
        } catch (SQLException e) {
            return "Erro ao listar contas: " + e.getMessage() + "\n";
        }
        return resultado.toString();
    }

    // Fechar conexão
    public void fecharConexao() {
        try {
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fechar a conexão: " + e.getMessage());
        }
    }
}