package com.mycinema.dao;

import com.mycinema.model.Book;
import com.mycinema.model.Category;
import com.mycinema.model.User;
import com.mycinema.service.UserService;

import javax.jws.soap.SOAPBinding;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class UserDao extends  BaseDao {
    public ArrayList<User> selectAll()
    {
        ArrayList<User> list=new ArrayList<>();
        try{
            openConnection();
            ResultSet resultSet1=executeQuery("select * from user");
            while(resultSet1.next())
            {
                User user =new User();
                user.setId(resultSet.getInt("user_id"));
                user.setUsername(resultSet.getString("user_name"));
                user.setPassword(resultSet.getString("password"));
                user.setAddress(resultSet.getString("address"));
                user.setEmail(resultSet.getString("email"));
                user.setPhone(resultSet.getString("phone"));
                user.setRole(resultSet.getInt("role"));
                list.add(user);
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        finally {
            closeResource();
        }
        return list;
    }
    public int insertUser(User user) {
        int count = 0;
        try {
            openConnection();
            String sql = "insert into user(user_name, password, address, phone, email, role) VALUES (?, ?, ?, ?, ?, ?)";
            count=executeUpdate(sql, user.getUsername(),
                    user.getPassword(),
                    user.getAddress(),
                    user.getPhone(),
                    user.getEmail(),
                    user.getRole());
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            closeResource();
        }
        return count;
    }

    public boolean usernameExists(String username) {
        try {
            openConnection();
            String sql = "SELECT COUNT(*) FROM user WHERE user_name = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            closeResource();
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
        return false;
    }

    public User selectByUsernameAndPassword(String username, String password, int role) {
        User user = null;
        try {
            openConnection();
            ResultSet resultSet = executeQuery("select * from user where user_name=? and password=? and role=?", username, password, role);
            if (resultSet.next()) {
                user = new User();
                user.setUsername(resultSet.getString("user_name"));
                user.setRole(resultSet.getInt("role"));
                user.setPhone(resultSet.getString("phone"));
                user.setPassword(resultSet.getString("password"));
                user.setId(resultSet.getInt("user_id"));
                user.setEmail(resultSet.getString("email"));
                user.setAddress(resultSet.getString("address"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            closeResource();
        }
        return user;
    }

    public static void main(String[] args) {


        UserDao movieDao=new UserDao();
        ArrayList<User> list=movieDao.selectAll();
        for (User movie:list){
            System.out.println(movie.getId());
        }
    }
}
