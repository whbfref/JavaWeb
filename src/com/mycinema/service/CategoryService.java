package com.mycinema.service;

import com.mycinema.dao.CategoryDao;
import com.mycinema.model.Category;

import java.util.ArrayList;

public class CategoryService {
    CategoryDao categoryDao=new CategoryDao();
    public ArrayList<Category> findAll()
    {
        return categoryDao.selectAll();
    }
}
