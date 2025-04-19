package com.mycinema.service;
import com.mycinema.dao.BorrowDao;
import com.mycinema.model.Book;
import com.mycinema.model.Borrow;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
public class BorrowService {
    private BorrowDao borrowDao;

    public BorrowService() {
        borrowDao = new BorrowDao(); // 假设您有一个 DAO 类来执行数据库操作
    }

    public String borrowBook(int userId, int bookId) {
        // 检查图书是否可借
        if (!isBookAvailable(bookId)) {
            return "这本书已经被借出，无法借阅。";
        }

        Timestamp borrowTime = new Timestamp(System.currentTimeMillis());
        Borrow borrow = new Borrow(userId, bookId, borrowTime, null, "借阅中");
        int result = borrowDao.insert(borrow);

        if (result > 0) {
            return "借阅成功！";
        } else {
            return "借阅失败，请重试。";
        }
    }

    private boolean isBookAvailable(int bookId) {
        // 在这里实现检查书籍是否可借的逻辑
        // 返回 true 如果书籍可借，返回 false 如果不可借
        // 例如，可以检查数据库中的状态字段
        return true; // 简化处理
    }
    private BorrowDao borrowDao1 = new BorrowDao(); // 使用具体的 BorrowDao
    public void borrowBook(Borrow borrow) {
        borrowDao.insert(borrow);
    }
    public int insertBorrow(Borrow borrow) { return borrowDao.insert(borrow);}
    public List<Borrow> getAllBorrowRecords() throws SQLException, ClassNotFoundException {
        List<Borrow> borrowList = null; // 初始化借阅记录列表
        try {
            borrowDao.openConnection(); // 打开数据库连接
            borrowList = borrowDao.getAllBorrowRecords(); // 获取借阅记录
        } finally {
            borrowDao.closeResource(); // 关闭资源，确保在发生异常时也能关闭
        }
        return borrowList; // 返回借阅记录列表
    }
}
