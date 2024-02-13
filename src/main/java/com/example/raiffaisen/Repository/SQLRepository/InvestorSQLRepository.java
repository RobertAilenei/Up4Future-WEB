package com.example.raiffaisen.Repository.SQLRepository;

import com.example.raiffaisen.Domain.Entitate;
import com.example.raiffaisen.Domain.Investor;
import com.example.raiffaisen.Repository.ExceptionRepository.RepositoryException;
import com.example.raiffaisen.Repository.GenericRepository;
import org.sqlite.SQLiteDataSource;

import java.sql.*;
import java.util.Iterator;

public class InvestorSQLRepository<T extends Entitate> extends GenericRepository<Investor> implements AutoCloseable {
    /**
     * Repository pentru entitatea Investor folosind SQLite
     **/
    private static final String JDBC_URL =
            "jdbc:sqlite:Investor.db";  // Protocol:sqlite:loculUndeAvemDB

    private Connection conn = null;

    public InvestorSQLRepository() {
        // 1. Stabilit conexiunea cu baza de data
        openConnection();

//        // 2. Daca nu exista tabela Investor, o creeam
//        // 'CREATE IF NOT EXISTS ...'
        createSchema();
//
//        // 3. Incarca obiectele din baza de date (citeste tabela Investor)
        getAll();
    }

        public void add(Investor investor) throws RepositoryException {
            // 1. Adaugat in baza de date
            // PreparedStatement (impotriva SQL Injection)
            // 'INSERT INTO Domain.Investor VALUES (?,?,?,...)'
            // 2. Daca nu avem exceptii, adaugat in data

            System.out.println("Adding an Investor");

            try {
                try (PreparedStatement statement = conn.prepareStatement("INSERT INTO Investor VALUES (?, ?, ?, ?, ?, ?)")) {
                    statement.setInt(1, investor.getId());
                    statement.setString(2, investor.getInvestorName());
                    statement.setInt(3,investor.getInvestorAge());
                    statement.setString(4,investor.getInvestorEmail());
                    statement.setString(5,investor.getInvestorPassword());
                    statement.setFloat(6,investor.getInvestorMoney());

                    super.add(investor);

                    statement.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void delete(int ID) throws RepositoryException {
            // 2. Sters din baza de data
            // 'DELETE Domain.Masina WHERE ...'

            try {
                try (PreparedStatement statement = conn.prepareStatement("DELETE FROM Investor WHERE id =" + ID)) {
                    super.delete(ID);
                    statement.executeUpdate();

                    // FIXME - Trebuie sters Investitorul cu Id-ul = ID, fara sa mai luam toate masinile din Baza de date mereu si mereu
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void update(Investor investor) {
            try {
                String updateSql = "UPDATE Investor SET name = ? SET age = ? SET email = ? SET password = ? SET money = ? WHERE id = ?";

                try (PreparedStatement statement = conn.prepareStatement(updateSql)) {
                    statement.setInt(1, investor.getId());
                    statement.setString(2, investor.getInvestorName());
                    statement.setInt(3,investor.getInvestorAge());
                    statement.setString(4,investor.getInvestorEmail());
                    statement.setString(5,investor.getInvestorPassword());
                    statement.setFloat(6,investor.getInvestorMoney());

                    super.update(investor);

                    // Step 4: Execute the update statement
                    int rowsAffected = statement.executeUpdate();

                    if (rowsAffected > 0) {
                        System.out.println("Investor updated successfully.");
                    } else {
                        System.out.println("Investor with ID " + investor.getId() + " not found.");
                    }
                }
            } catch (SQLException | RepositoryException e) {
                System.out.println(e.getMessage());
            }
        }


    @Override
    public void close() throws Exception {
        // inchidem conexiunea spre baza de date
    }

    @Override
    public Iterator iterator() {
        return entitati.iterator();
    }

    private void openConnection() {
        try {
            // with DataSource
            SQLiteDataSource ds = new SQLiteDataSource();
            ds.setUrl(JDBC_URL);
            if (conn == null || conn.isClosed())
                conn = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void createSchema() {
        try {
            try (final Statement stmt = conn.createStatement()) {
                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Investor(id int PRIMARY KEY, name varchar(200), age int, email varchar(200), password varchar(200), money float);");
            }
        } catch (SQLException e) {
            System.err.println("[ERROR] createSchema : " + e.getMessage());
        }
    }

    private void getAll() {
        entitati.clear();

        System.out.println(
                "Luam investitorii din baza de date"
        );
        try {
            try (PreparedStatement statement = conn.prepareStatement("SELECT * from Investor");
                 ResultSet rs = statement.executeQuery();) {
                while (rs.next()) {
                    Investor investor = new Investor(rs.getInt("id"), rs.getString("name"), rs.getInt("age"),rs.getString("email"),rs.getString("password"),rs.getFloat("money"));
                    entitati.add(investor);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
