package com.mycinema.dao;

import com.mycinema.model.Book;
import com.mycinema.model.Category;

import java.sql.ResultSet;
import java.util.ArrayList;
public class CategoryDao extends  BaseDao{
    public ArrayList<Category> selectAll()
    {
        ArrayList<Category> list=new ArrayList<>();
        try
        {
            openConnection();
            ResultSet resultSet=executeQuery("select *  from categories");
            while(resultSet.next())
            {
                Category category=new Category();
                category.setName(resultSet.getString("category_name"));
                category.setId(resultSet.getInt("category_id"));
                category.setDescription(resultSet.getString("description"));
                list.add(category);

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
     public static void main(String[] args) {


        CategoryDao movieDao=new CategoryDao();
        ArrayList<Category> list=movieDao.selectAll();
        for (Category movie:list){
            System.out.println(movie.getDescription());
        }
    } }

