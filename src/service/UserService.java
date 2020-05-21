package service;

import util.DBUtil;

import java.util.List;
import java.util.Map;

public class UserService {
    private DBUtil dbUtil;

    public UserService() {
        dbUtil = new DBUtil();
    }

    //根据用户名和密码查询用户信息
    public Map<String, String> getUserInfo(String username, String password) {
        String sql = "select * from user where username=? and password=?";
        String[] params = new String[]{username, password};
        return dbUtil.getMap(sql, params);
    }

    //添加用户信息
    public Integer addUser(String username, String password, String identity, String tel, String address) {
        String sql = "insert into user values(null,?,?,?,?,?)";
        String[] params = new String[]{username, password, identity, tel, address};
        int rows = dbUtil.update(sql, params);
        return rows;
    }

    //根据id删除用户信息
    public Integer deleteUser(String id) {
        String sql = "delete from user where id = ?";
        String[] params = new String[]{id};
        int rows = dbUtil.update(sql, params);
        return rows;
    }

    //查询所有用户信息
    public List<Map<String, String>> selectUserInfo() {
        String sql = "select * from user";
        return dbUtil.getList(sql);
    }

    //修改用户信息
    public int updateUserInfo(String id, String pw, String tel, String addr) {
        String sql = "update user set password=?,telephone=?,address=? where id=?";
        String[] params = new String[]{pw, tel, addr, id};
        return dbUtil.update(sql, params);
    }

//    //根据用户id查询用户信息
//    public Map<String, String> getUserInfo(String username, String password) {
//        String sql = "select * from user where username=? and password=?";
//        String[] params = new String[]{username, password};
//        return dbUtil.getMap(sql, params);
//    }
}
