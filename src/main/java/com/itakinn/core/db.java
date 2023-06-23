package com.itakinn.core;

import java.sql.*;

import com.itakinn.Main;
import com.itakinn.constantes;

public class db {
    private static final String DATABASE_FILE = "database.db";

    public static void criarDB() {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + DATABASE_FILE);
             Statement stmt = conn.createStatement()) {
            // Criação da tabela
            String sql = "CREATE TABLE IF NOT EXISTS usuarios (\n"
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                    + "nome TEXT NOT NULL,\n"
                    + "saldo INTEGER\n"
                    + ");";
            stmt.execute(sql);
            System.out.println();
            System.out.println("Banco de dados criado com sucesso!");
            System.out.println();
        } catch (SQLException e) {
            System.out.println("Erro ao criar o banco de dados: " + e.getMessage());
        }
        Main.main(null);
    }

    public static void inserirDB(int id, String nome, int saldo) {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + DATABASE_FILE);
             Statement stmt = conn.createStatement()) {
            // Inserção dos dados
            String sql = "INSERT INTO usuarios (id, nome, saldo) VALUES (" + id + ", '" + nome + "', " + saldo + ");";
            stmt.execute(sql);
            System.out.println("Dados inseridos com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
        }
    }
    public static int idd;
    public static String nomee;
    public static Double saldo;
    public static void lerDB(String nome) {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + DATABASE_FILE);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios WHERE nome = '" + nome + "';")) {
            // Leitura dos dados
            if (rs.next()) {
                idd = rs.getInt("id");
                nomee = rs.getString("nome");
                saldo = rs.getDouble("saldo");
                System.out.println();
                System.out.println("ID: " + idd + ", Nome: " + nomee + ", Saldo: " + saldo);
                System.out.println();
            } else {
                System.out.println();
                System.out.println("Adicionando novo nome na DB...");
                System.out.println();
                criarNome(nome);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao ler dados: " + e.getMessage());
        }
    }

    private static void criarNome(String nome) {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + DATABASE_FILE);
             Statement stmt = conn.createStatement()) {
            // Consulta para obter o maior ID existente
            String consultaID = "SELECT MAX(id) AS max_id FROM usuarios;";
            ResultSet rs = stmt.executeQuery(consultaID);

            int novoID = 1; // Valor padrão para o novo ID

            // Verificar se há um ID existente na tabela
            if (rs.next()) {
                int maxID = rs.getInt("max_id");
                novoID = maxID + 1;
            }

            Double saldo = constantes.sldinicio;

            // Inserção dos dados com o novo ID
            String sql = "INSERT INTO usuarios (id, nome, saldo) VALUES (" + novoID + ", '" + nome + "', " + saldo + ");";
            stmt.execute(sql);
            System.out.println();
            System.out.println("Usuário criado com sucesso! ID: " + novoID+" Saldo: "+constantes.sldinicio);
            System.out.println();
            Main.main(null);
        } catch (SQLException e) {
            System.out.println("Erro ao criar usuário: " + e.getMessage());
        }
    }
    public static void addSaldo(Double adicionar, int id) {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + DATABASE_FILE);
         Statement stmt = conn.createStatement()) {
        // Atualização do saldo
        String sql = "UPDATE usuarios SET saldo = saldo + " + adicionar + " WHERE id = " + id + ";";
        stmt.executeUpdate(sql);
        System.out.println();
        System.out.println("Saldo atualizado com sucesso!");
        System.out.println();
        Main.main(null);
    } catch (SQLException e) {
        System.out.println();
        System.out.println("Erro ao atualizar saldo: " + e.getMessage());
        System.out.println();
    }
    }
    public static void removerSaldo(Double valor, int id) {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + DATABASE_FILE);
         Statement stmt = conn.createStatement()) {
        // Atualização do saldo
        String sql = "UPDATE usuarios SET saldo = saldo - " + valor + " WHERE id = " + id + ";";
        stmt.executeUpdate(sql);
        System.out.println();
        System.out.println("Saldo atualizado com sucesso!");
        System.out.println();
        Main.main(null);
    } catch (SQLException e) {
        System.out.println();
        System.out.println("Erro ao atualizar saldo: " + e.getMessage());
        System.out.println();
    }
    }
}
