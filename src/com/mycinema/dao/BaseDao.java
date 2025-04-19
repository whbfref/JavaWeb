package com.mycinema.dao;
import java.sql.*;
public class BaseDao {
     protected Connection connection;
     protected PreparedStatement preparedStatement;
     protected ResultSet resultSet;
     public void openConnection()throws ClassNotFoundException, SQLException
     {
         Class.forName("com.mysql.cj.jdbc.Driver");
         connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
     }
     public ResultSet executeQuery(String sql, Object...params)throws SQLException
     {
          preparedStatement=connection.prepareStatement(sql);
          if(params!=null)
          {
               int index=1;
               for(Object object:params)
               {
                    preparedStatement.setObject(index,object);
                    index++;
               }
          }
          resultSet=preparedStatement.executeQuery();
          return resultSet;
     }
     public int executeUpdate(String sql,Object...params)throws SQLException
     {
          int count=0;
          preparedStatement=connection.prepareStatement(sql);
          if(params!=null)
          {
               int index=1;
               for(Object object:params)
               {
                    preparedStatement.setObject(index,object);
                    index++;
               }
          }
          count=preparedStatement.executeUpdate();
          return count;
     }
     public void closeResource()
     {
          if(resultSet!=null)
          {
               try
               {
                    resultSet.close();
               }
               catch (SQLException exception)
               {
                    exception.printStackTrace();
               }

          }
          if(preparedStatement!=null)
          {
               try
               {
                    preparedStatement.close();
               }
               catch (SQLException exception)
               {
                    exception.printStackTrace();
               }
          }
          if(connection!=null)
          {
               try
               {
                    connection.close();
               }
               catch (SQLException exception)
               {
                    exception.printStackTrace();
               }
          }
     }

}
