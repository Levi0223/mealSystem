package service;

import util.DBUtil;

import java.util.List;
import java.util.Map;

public class DCService {
    private DBUtil dbUtil;

    public DCService() {
        dbUtil = new DBUtil();
    }

    //
    public int addToDC(String user_id, String[] f_ids) {
        int rows = 0;
        String sql = "insert into diningcar values(null,?,?)";
        if (f_ids != null) {
            for (String food_id :
                    f_ids) {
                String[] params = new String[]{user_id, food_id};
                rows += dbUtil.update(sql, params);
            }
            sql = "update food set hits=hits+1 where id=?";
            for (String food_id :
                    f_ids) {
                String[] params = new String[]{food_id};
                dbUtil.update(sql, params);
            }
        }
        return rows;
    }

    //得到用户点餐信息
    public List<Map<String, String>> getUserDc(String user_id) {
        String sql = "SELECT dc.id as dcid,f.*,ft.typename FROM diningcar as dc JOIN food as f on dc.foodid=f.id JOIN foodtype as ft on f.type=ft.id WHERE dc.userid=?";
        String[] params = new String[]{user_id};
        return dbUtil.getList(sql, params);
    }

    //删除用户点餐信息
    public Integer delFromDc(String[] dc_ids) {
        int rows = 0;
        //更新点餐率
        String sql = "update food set hits=hits-1 where id=(select foodid from diningcar where id=?)";
        if (dc_ids != null) {
            for (String dc_id :
                    dc_ids) {
                String[] params = new String[]{dc_id};
                dbUtil.update(sql, params);
            }
            //从点餐车删除
            sql = "delete from diningcar where id=?";
            for (String dc_id :
                    dc_ids) {
                String[] params = new String[]{dc_id};
                rows += dbUtil.update(sql, params);
            }

        }
        return rows;
    }

}

