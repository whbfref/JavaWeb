package com.mycinema.dao;

import com.mycinema.model.Book;
import com.mycinema.model.Review;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookDao extends BaseDao{
    public ArrayList<Book> selectAll()
    {
        ArrayList<Book> list=new ArrayList<>();
        try{
            openConnection();
             ResultSet resultSet1=executeQuery("select * from book");
            while(resultSet1.next())
            {
                Book book =new Book();
                book.setId(resultSet.getInt("bookId"));
                book.setCategoryId(resultSet.getInt("category_id"));
                book.setPublish_time(resultSet.getDate("publish_time"));
                book.setBookname(resultSet.getString("bookname"));
                book.setAuthor(resultSet.getString("author"));
                book.setPublisher(resultSet.getString("publisher"));
                book.setTranslator(resultSet.getInt("translator"));
                book.setPrice(resultSet.getFloat("price"));
                book.setDescription(resultSet.getString("description"));
                book.setComment_count(resultSet.getInt("comment_count"));
                book.setCreate_userid(resultSet.getInt("create_userid"));
                book.setModify_userid(resultSet.getInt("modify_userid"));
                list.add(book);
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
    public ArrayList<Book> searchBooks(String title, String author) {
        ArrayList<Book> list = new ArrayList<>();
        try {
            openConnection();

            // 使用 ? 占位符来防止 SQL 注入
            String sql = "SELECT * FROM book WHERE bookname LIKE ? AND author LIKE ?";
            // 设置模糊查询参数，加上通配符
            String titleParam = "%" + (title != null ? title : "") + "%";
            String authorParam = "%" + (author != null ? author : "") + "%";

            ResultSet resultSet = executeQuery(sql, titleParam, authorParam);
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("bookId"));
                book.setCategoryId(resultSet.getInt("category_id"));
                book.setPublish_time(resultSet.getDate("publish_time"));
                book.setBookname(resultSet.getString("bookname"));
                book.setAuthor(resultSet.getString("author"));
                book.setPublisher(resultSet.getString("publisher"));
                book.setTranslator(resultSet.getInt("translator"));
                book.setPrice(resultSet.getFloat("price"));
                book.setDescription(resultSet.getString("description"));
                book.setComment_count(resultSet.getInt("comment_count"));
                book.setCreate_userid(resultSet.getInt("create_userid"));
                book.setModify_userid(resultSet.getInt("modify_userid"));
                list.add(book);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            closeResource();
        }
        return list;
    }
    public int delete(int id){
        int count=0;
        try{
            openConnection();
            count=executeUpdate("delete from book where bookId=?",id);
        }catch (Exception exception)
        {
            exception.printStackTrace();
        }
        finally {
            closeResource();
        }
        return count;
    }
//    public static void main(String[] args) {
//        BookDao bookDAO = new BookDao();
//        int bookIdToDelete = 0;  // 假设我们要删除 bookId 为 1 的书籍
//        int result = bookDAO.delete(bookIdToDelete);
//
//        if (result > 0) {
//            System.out.println("成功删除 bookId 为 " + bookIdToDelete + " 的书籍，受影响的行数: " + result);
//        } else {
//            System.out.println("没有找到 bookId 为 " + bookIdToDelete + " 的书籍，未能删除。");
//        }
//    }
    public Book selectByIdI(int id)
    {
        Book book =null;
        try{
            openConnection();
            ResultSet resultSet=executeQuery("select * from book where bookId=?",id);
            while(resultSet.next())
            {
                book =new Book();
                book.setId(resultSet.getInt("bookId"));
                book.setCategoryId(resultSet.getInt("category_id"));
                book.setPublish_time(resultSet.getDate("publish_time"));
                book.setBookname(resultSet.getString("bookname"));
                book.setAuthor(resultSet.getString("author"));
                book.setPublisher(resultSet.getString("publisher"));
                book.setTranslator(resultSet.getInt("translator"));
                book.setPrice(resultSet.getFloat("price"));
                book.setDescription(resultSet.getString("description"));
                book.setComment_count(resultSet.getInt("comment_count"));
                book.setCreate_userid(resultSet.getInt("create_userid"));
                book.setModify_userid(resultSet.getInt("modify_userid"));
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        finally {
            closeResource();
        }
        return book;
    }

    public int updateBook(Book book) {
        int count = 0;
        try {
            openConnection();
            String sql = "UPDATE book SET bookname = ?, author = ?, publisher = ?, category_id = ?, publish_time = ?,translator=?,price=?,description=?,comment_count=?,create_userid=?,modify_userid=? WHERE bookId = ?";
            count = executeUpdate(sql,
                    book.getBookname(),
                    book.getAuthor(),
                    book.getPublisher(),
                    book.getCategoryId(),
                    book.getPublish_time(),
                    book.getPrice(),
                    book.getTranslator(),
                    book.getDescription(),
                    book.getComment_count(),
                    book.getCreate_userid(),
                    book.getModify_userid(),
                    book.getId());
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            closeResource();
        }
        return count;
    }
//    public static void main(String[] args) {
//        // 创建 BookDao 实例
//        BookDao bookDao = new BookDao();
//
//        // 创建一个 Book 对象用于更新
//        Book bookToUpdate = new Book();
//        bookToUpdate.setId(0); // 假设我们要更新 id 为 1 的书籍
//        bookToUpdate.setBookname("Updated Book Name");
//        bookToUpdate.setAuthor("Updated Author");
//        bookToUpdate.setPublisher("Updated Publisher");
//        bookToUpdate.setPublish_time(java.sql.Date.valueOf("2023-01-01")); // 替换为新的发布日期
//        bookToUpdate.setCategoryId(4); // 假设类别 ID 为 10
//        bookToUpdate.setPrice(49); // 新的价格
//        bookToUpdate.setTranslator(5); // 假设翻译者 ID 为 5
//        bookToUpdate.setDescription("Updated Description");
//        bookToUpdate.setComment_count(15); // 假设评论数量更新为 15
//        bookToUpdate.setCreate_userid(2);
//        bookToUpdate.setModify_userid(2); // 假设修改用户 ID 为 2
//        int result = bookDao.updateBook(bookToUpdate);
//        if (result > 0) {
//            System.out.println("图书更新成功！");
//        } else {
//            System.out.println("图书更新失败！");
//        }
//    }
    public int insertBook(Book book)
    {
        int count=0;
        try{
            openConnection();
            String sql="insert into book(bookId,bookname,author,publisher,category_id,publish_time,translator,price,description,comment_count,create_userid,modify_userid)values(?,?,?,?,?,?,?,?,?,?,?,?)";
            count=executeUpdate(sql,
                    book.getId(),
                    book.getBookname(),
                    book.getAuthor(),
                    book.getPublisher(),
                    book.getCategoryId(),
                    book.getPublish_time(),
                    book.getTranslator(),
                    book.getPrice(),
                    book.getDescription(),
                    book.getComment_count(),
                    book.getCreate_userid(),
                    book.getModify_userid());
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        finally {
            closeResource();
        }
        return count;
    }
//    public static void main(String[] args) {
//        // 创建一个 Book 对象
//        Book book = new Book();
//        book.setBookname("Java");
//        book.setAuthor("John Doe");
//        book.setPublisher("Tech");
//        book.setCategoryId(1); // 假设 1 是有效的类别 ID
//        book.setPublish_time(java.sql.Date.valueOf("2023-10-01")); // 假设我们使用 java.sql.Date
//        book.setTranslator(20);
//        book.setPrice(39);
//        book.setDescription("An in-depth guide to Java programming.");
//        book.setComment_count(0);
//        book.setCreate_userid(1); // 假设 1 是有效的用户 ID
//
//        // 调用 insertBook 方法
//        BookDao bookDAO = new BookDao(); // 假设您有一个名为 BookDAO 的类来处理数据库操作
//        int result = bookDAO.insertBook(book);
//
//        // 检查结果
//        if (result > 0) {
//            System.out.println("插入成功，插入的记录数: " + result);
//        } else {
//            System.out.println("插入失败");
//        }
//    }
}
