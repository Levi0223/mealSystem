package service;

import util.DBUtil;

import java.util.List;
import java.util.Map;

public class FoodTypeService {

    private DBUtil dbUtil;

    public FoodTypeService() {
        dbUtil = new DBUtil();
    }

    //查询所有菜品分类信息
    public List<Map<String, String>> getAllFoodTypes() {
        String sql = "select * from foodtype";
        return dbUtil.getList(sql);
    }
}
