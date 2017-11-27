/**
 * Copyright © 2017 公司名. All rights reserved.
 * 
 * @Title: PersonDao.java
 * @Prject: BoardGame
 * @Package: com.gzdgm.xmt.dao
 * @Description: TODO
 * @author: siyuan
 * @date: 2017年11月27日 上午9:54:02
 * @version: V1.0
 */
package com.symon.sun.boardgame.dao;

import com.symon.sun.boardgame.entity.Person;
import com.symon.sun.boardgame.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: PersonDao
 * @Description: TODO
 * @author: siyuan
 * @date: 2017年11月27日 上午9:54:02
 */
public class PersonDao {

    /**
     * 
     * @Title: readDisplayTable
     * @Description: 拿到Person数据库中的所有信息
     * @return
     * @return: List<Person>
     */
    public List<Person> readPersonTable() {
        DBUtil db = new DBUtil();
        ArrayList<Person> list = new ArrayList<Person>();
        Person person = null;
        Connection conn = null;
        Statement smt = null;
        ResultSet rs = null;
        String tablename = "tb_person";

        try {
            conn = db.getConnection();
            smt = conn.createStatement();
            String sql = "SELECT * FROM " + tablename + " ORDER BY total_score DESC";
            rs = smt.executeQuery(sql);
            while (rs.next()) {
                person = new Person();
                person.setId(rs.getLong("id"));
                person.setName(rs.getString("name"));
                person.setWolf_score(rs.getString("wolf_score"));
                person.setGod_score(rs.getString("god_score"));
                person.setVillager_score(rs.getString("villager_score"));
                person.setTotal_score(rs.getString("total_score"));
                list.add(person);
                // System.out.println(person.getName());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (smt != null) {
                    smt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
