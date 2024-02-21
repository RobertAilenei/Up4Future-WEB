//package com.example.raiffaisen.Repository.SQLRepository;
//
////import com.example.raiffaisen.Domain.Entitate;
////import com.example.raiffaisen.Domain.Startup;
//import com.example.raiffaisen.Repository.ExceptionRepository.RepositoryException;
////import com.example.raiffaisen.Repository.GenericRepository;
//import org.sqlite.SQLiteDataSource;
//
//import java.sql.*;
//import java.util.Iterator;
//
//public class StartupSQLRepository <T extends Entitate> extends GenericRepository<Startup> implements AutoCloseable {
//    /**
//     * Repository pentru entitatea Startup folosind SQL
//     */
//    private static final String JDBC_URL =
//            "jdbc:sqlite:Startup.db";  // Protocol:sqlite:loculUndeAvemDB
//
//    private Connection conn = null;
//
//    public StartupSQLRepository() {
//        // 1. Stabilit conexiunea cu baza de data
//        openConnection();
//
////        // 2. Daca nu exista tabela Startup, o creeam
////        // 'CREATE IF NOT EXISTS ...'
//        createSchema();
////
////        // 3. Incarca obiectele din baza de date (citeste tabela Startup)
//        getAll();
//    }
//
//    public void add(Startup startup) throws RepositoryException {
//        // 1. Adaugat in baza de date
//        // PreparedStatement (impotriva SQL Injection)
//        // 'INSERT INTO Domain.Masina VALUES (?,?,?,...)'
//        // 2. Daca nu avem exceptii, adaugat in data
//
//        System.out.println("Adding an Startup");
//
//        try {
//            try (PreparedStatement statement = conn.prepareStatement("INSERT INTO Startup VALUES (?, ?)")) {
//                statement.setInt(1, startup.getId());
//                statement.setString(2, startup.getStartupName());
//
//                super.add(startup);
//
//                statement.executeUpdate();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void delete(int ID) throws RepositoryException {
//        // 2. Sters din baza de data
//        // 'DELETE Domain.Masina WHERE ...'
//
//        try {
//            try (PreparedStatement statement = conn.prepareStatement("DELETE FROM Startup WHERE id =" + ID)) {
//                super.delete(ID);
//                statement.executeUpdate();
//
//                // FIXME - Trebuie sters Startup-ul cu Id-ul = ID, fara sa mai luam toate Startup-urile din Baza de date mereu si mereu
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void update(Startup startup) throws RepositoryException {
//        try {
//            String updateSql = "UPDATE Startup SET name = ? WHERE id = ?";
//
//            try (PreparedStatement statement = conn.prepareStatement(updateSql)) {
//                statement.setString(1, startup.getStartupName());
//                statement.setInt(2, startup.getId());
//
//                super.update(startup);
//
//                // Step 4: Execute the update statement
//                int rowsAffected = statement.executeUpdate();
//
//                if (rowsAffected > 0) {
//                    System.out.println("Startup updated successfully.");
//                } else {
//                    System.out.println("Startup with ID " + startup.getId() + " not found.");
//                }
//            }
//        } catch (SQLException | RepositoryException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//
//    @Override
//    public void close() throws Exception {
//        // inchidem conexiunea spre baza de date
//    }
//
//    @Override
//    public Iterator iterator() {
//        return entitati.iterator();
//    }
//
//    private void openConnection() {
//        try {
//            // with DataSource
//            SQLiteDataSource ds = new SQLiteDataSource();
//            ds.setUrl(JDBC_URL);
//            if (conn == null || conn.isClosed())
//                conn = ds.getConnection();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    void createSchema() {
//        try {
//            try (final Statement stmt = conn.createStatement()) {
//                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Startup(id int PRIMARY KEY, name varchar(200));");
//            }
//        } catch (SQLException e) {
//            System.err.println("[ERROR] createSchema : " + e.getMessage());
//        }
//    }
//
//    private void getAll() {
//        entitati.clear();
//
//        System.out.println(
//                "Luam startup-urile din baza de date"
//        );
//        try {
//            try (PreparedStatement statement = conn.prepareStatement("SELECT * from Startup");
//                 ResultSet rs = statement.executeQuery();) {
//                while (rs.next()) {
//                    Startup startup = new Startup(rs.getInt("id"), rs.getString("name"));
//                    entitati.add(startup);
//                }
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }}
