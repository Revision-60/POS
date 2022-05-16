package Dao;

import model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl implements CrudDAO <CustomerDTO,String>{
    @Override
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM Customer");
        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
        while (rst.next()) {
            allCustomers.add(new CustomerDTO(rst.getString(1), rst.getString(2), rst.getString(3)));
        }
        return allCustomers;
    }

    @Override
    public boolean save(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public CustomerDTO search(String id) throws SQLException, ClassNotFoundException {

        ResultSet resultSet=SQLUtil.executeQuery("SELECT * FROM Customer WHERE id=?",id);
        if (resultSet.next()){
            return  new CustomerDTO(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3));
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
//    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
//        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM Customer");
//        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
//        while (rst.next()) {
//            allCustomers.add(new CustomerDTO(rst.getString(1),  rst.getString(2), rst.getString(3)));
//        }
//        return allCustomers;
//    }
//
//    @Override
//    public boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
//        return SQLUtil.executeUpdate("INSERT INTO Customer (id,name, address) VALUES (?,?,?)", dto.getId(), dto.getName(), dto.getAddress());
//    }
//
//
//    @Override
//    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
//        return SQLUtil.executeUpdate("UPDATE Customer SET name=?, address=? WHERE id=?", dto.getName(), dto.getAddress(), dto.getId());
//    }
//
//
//    @Override
//    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
//        ResultSet rst = SQLUtil.executeQuery("SELECT id FROM Customer WHERE id=?",id);
//        return rst.next();
//    }
//
//
//    @Override
//    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
//        return SQLUtil.executeUpdate("DELETE FROM Customer WHERE id=?",id);
//    }
//
//    @Override
//    public String generateNewID() throws SQLException, ClassNotFoundException {
//        ResultSet rst = SQLUtil.executeQuery("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
//        if (rst.next()) {
//            String id = rst.getString("id");
//            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
//            return String.format("C00-%03d", newCustomerId);
//        } else {
//            return "C00-001";
//        }
//    }

}


