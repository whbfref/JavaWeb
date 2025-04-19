package com.mycinema.dao;

import com.mycinema.model.Book;
import com.mycinema.model.Borrow;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
public class BorrowDao extends BaseDao {
    public List<Borrow> getAllBorrowRecords() throws SQLException {
        List<Borrow> borrowList = new ArrayList<>();
        String sql = "SELECT * FROM borrow";
        ResultSet resultSet = executeQuery(sql);
        while (resultSet.next()) {
            Borrow borrow = new Borrow();
            borrow.setRecordId(resultSet.getInt("record_id"));
            borrow.setUserId(resultSet.getInt("user_id"));
            borrow.setBookId(resultSet.getInt("bookid"));
            borrow.setBorrowTime(resultSet.getTimestamp("borrow_time"));
            borrow.setReturnTime(resultSet.getTimestamp("return_time"));
            borrow.setStatus(resultSet.getString("status"));
            borrowList.add(borrow);
        }
        return borrowList;
    }

    public int insert(Borrow borrow) {

        int count = 0;
        try {
            openConnection();
            String sql = "INSERT INTO borrow (record_id,user_id, bookid, borrow_time, return_time, status) VALUES (?,?, ?, ?, ?, ?)";
            count = executeUpdate(sql,
                    borrow.getRecordId(),
                    borrow.getUserId(),
                    borrow.getBookId(),
                    borrow.getBorrowTime(),
                    borrow.getReturnTime(),
                    borrow.getStatus());
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            closeResource();
        }
        return count;
    }
}
//    public static void main(String[] args) {
//        BorrowDao borrowDAO = new BorrowDao();
//
//        // 创建一个新的 Borrow 对象
//        Borrow borrow = new Borrow(
//                3,
//                1, // userId
//                3, // bookId
//                new Timestamp(System.currentTimeMillis()), // borrowTime
//                null, // returnTime (尚未归还所以设为 null)
//                "borrowed" // status
//        );
//
//        // 插入到数据库
//        int result = borrowDAO.insert(borrow);
//
//        // 输出插入结果
//        if (result > 0) {
//            System.out.println("借阅记录插入成功！");
//        } else {
//            System.out.println("借阅记录插入失败。");
//        }
//    }
//}