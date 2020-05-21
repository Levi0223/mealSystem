package service;

import util.DBUtil;

import java.util.List;
import java.util.Map;

public class FoodService {
    private DBUtil dbUtil;

    public FoodService() {
        dbUtil = new DBUtil();
    }

    //读取排名前三的菜品
    public List<Map<String, String>> getHotFood() {
        String sql = "SELECT * FROM food ORDER BY hits DESC LIMIT 0,3";
        return dbUtil.getList(sql);
    }

    //读取点餐率排名前三的特价菜品
    public List<Map<String, String>> getCheapFood() {
        String sql = "SELECT * FROM food WHERE comment > 0 ORDER BY hits DESC LIMIT 0,3";
        return dbUtil.getList(sql);
    }

    //读取点餐率排名前三的厨师推荐菜品
    public List<Map<String, String>> getChiefRecommend() {
        String sql = "SELECT * FROM food WHERE comment = 0 ORDER BY hits DESC LIMIT 0,3";
        return dbUtil.getList(sql);
    }

    //查询所有菜品信息
    public List<Map<String, String>> getFoodInfo() {
        String sql = "SELECT f.*,ft.typename FROM food f JOIN foodtype ft on f.type=ft.id";
        return dbUtil.getList(sql);
    }

    //根据菜名查询菜品信息
    public Map<String, String> getFoodInfoById(String id) {
        String sql = "SELECT f.*,ft.typename FROM food f JOIN foodtype ft on f.type=ft.id where f.id = ?";
        String[] params = new String[]{id};
        return dbUtil.getMap(sql, params);
    }

    //添加菜品信息
    public int addFood(String foodname, String feature, String material, String price, String type, String picture,
                       String hits, String comment) {
        String sql = "insert into food values(null,?,?,?,?,?,?,?,?)";
        String[] params = new String[]{foodname, feature, material, price, type, picture, hits, comment};
        return dbUtil.update(sql, params);
    }

    //按分类查找
    public List<Map<String, String>> getFoodByType(String type) {
        String sql = "SELECT f.*,ft.typename FROM food f JOIN foodtype ft on f.type=ft.id where f.type=?";
        String[] params = new String[]{type};
        return dbUtil.getList(sql, params);
    }

    //按照分类和名称查找
    public List<Map<String, String>> getFoodByNameAndType(String type, String name) {
        String sql = "select f.*,ft.typename from food f join foodtype ft on f.type=ft.id where f.type=? and f.foodname like ?";
        String[] params = new String[]{type, "%" + name + "%"};
        return dbUtil.getList(sql, params);
    }

    //按照名称查找
    public List<Map<String, String>> getFoodByName(String name) {
        String sql = "select f.*,ft.typename from food f join foodtype ft on f.type=ft.id where f.foodname like ?";
        String[] params = new String[]{"%" + name + "%"};
        return dbUtil.getList(sql, params);
    }

}
