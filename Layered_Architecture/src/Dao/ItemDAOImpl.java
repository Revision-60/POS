package Dao;

import db.DBConnection;
import model.ItemDTO;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements CrudDAO <ItemDTO,String>{
    @Override
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?", dto.getDescription(), dto.getUnitPrice(), dto.getQtyOnHand(), dto.getCode());
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ItemDTO search(String code) throws SQLException, ClassNotFoundException {
       ResultSet rst=  SQLUtil.executeQuery("SELECT * FROM Item WHERE code=?",code);
       if (rst.next()){
           return new ItemDTO(rst.getString(1),
                   rst.getString(2),
                   rst.getBigDecimal(3),
                   rst.getInt(4));
       }
       return null;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }
//    @Override
//    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
////        Connection connection = DBConnection.getDbConnection().getConnection();
////        Statement stm = connection.createStatement();
//       // ResultSet rst = stm.executeQuery("SELECT * FROM Item");
//        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM Item");
//        ArrayList<ItemDTO> allItems = new ArrayList<>();
//        while (rst.next()) {
//            String code = rst.getString(1);
//            String description = rst.getString(2);
//            BigDecimal price = rst.getBigDecimal(3);
//            int qtyOnHand = rst.getInt(4);
//            allItems.add(new ItemDTO(code, description, price, qtyOnHand));
//        }
//        return allItems;
//    }
//
//    @Override
//    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException {
////        Connection connection = DBConnection.getDbConnection().getConnection();
////        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Item WHERE code=?");
////        pstm.setString(1, code);
////        return pstm.executeUpdate() > 0;
//       return SQLUtil.executeUpdate("DELETE FROM Item WHERE code=?",code);
//    }
//
//    @Override
//    public boolean addItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
////        Connection connection = DBConnection.getDbConnection().getConnection();
////        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)");
////        pstm.setString(1, dto.getCode());
////        pstm.setString(2, dto.getDescription());
////        pstm.setBigDecimal(3, dto.getUnitPrice());
////        pstm.setInt(4, dto.getQtyOnHand());
////        return pstm.executeUpdate() > 0;
//       return SQLUtil.executeUpdate("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",dto.getCode(),dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand());
//    }
//
//    @Override
//    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
////        Connection connection = DBConnection.getDbConnection().getConnection();
////        PreparedStatement pstm = connection.prepareStatement("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?");
////        pstm.setString(1, dto.getDescription());
////        pstm.setBigDecimal(2, dto.getUnitPrice());
////        pstm.setInt(3, dto.getQtyOnHand());
////        pstm.setString(4, dto.getCode());
////        return pstm.executeUpdate() > 0;
//      return   SQLUtil.executeUpdate("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand(),dto.getCode());
//    }
//
//    @Override
//    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
////        Connection connection = DBConnection.getDbConnection().getConnection();
//////        PreparedStatement pstm = connection.prepareStatement("SELECT code FROM Item WHERE code=?");
//////        pstm.setString(1, code);
//////        return pstm.executeQuery().next();
//         ResultSet rst=SQLUtil.executeQuery("SELECT code FROM Item WHERE code=?",code);
//         return rst.next();
//    }
//
//    @Override
//    public String generateNewId() throws SQLException, ClassNotFoundException {
//       // Connection connection = DBConnection.getDbConnection().getConnection();
//        //ResultSet rst = connection.createStatement().executeQuery("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
//        ResultSet rst = SQLUtil.executeQuery("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
//        if (rst.next()) {
//            String id = rst.getString("code");
//            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
//            return String.format("I00-%03d", newItemId);
//        } else {
//            return "I00-001";
//        }
//    }
}
