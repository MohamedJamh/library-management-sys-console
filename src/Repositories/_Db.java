package Repositories;

import java.sql.*;
import java.util.ArrayList;
import _primitive_classes.TypeChecker;

public class _Db {
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/ycminisas";
    private static final String username = "root";
    private static final String password = "";
    public static Connection connection;


    public _Db() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Object queryDatabase(String sql , String returnType){
        try{
            Statement statement = connection.createStatement();
            switch (returnType){
                case "ResultSet" -> {
                    return statement.executeQuery(sql);
                }
                case "Int" -> {
                    return statement.executeUpdate(sql);
                }
                case "Bool" -> {
                    return statement.execute(sql);
                }
            }
            return new Object();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Object queryDatabase(String sql, ArrayList<Object> arrayParameter, String returnType ){
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            for(int i = 0; i < arrayParameter.size(); i++){
                Object parameter = arrayParameter.get(i);
                switch (TypeChecker.getType(parameter)) {
                    case "String" -> {
                        statement.setString(i + 1, (String) parameter);
                    }
                    case "Integer" -> {
                        statement.setInt(i + 1, (int) parameter);
                    }
                    case "Float" -> {
                        statement.setFloat(i + 1, (float) parameter);
                    }
                    case "Boolean" -> {
                        statement.setBoolean(i + 1, (boolean) parameter);
                    }
                }
            }
            switch (returnType){
                case "ResultSet" -> {
                    return statement.executeQuery();
                }
                case "Int" -> {
                    return statement.executeUpdate();
                }
                case "Bool" -> {
                    return statement.execute();
                }
            }
            return new Object();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void disconnect() throws SQLException {
        connection.close();
    }
}
