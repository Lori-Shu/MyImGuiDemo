package dao;

import prodetail.CityDetail;
import prodetail.ProDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProDao {
    public ProDao() {
    }
    public List getDetail(Integer id,Connection conn){
        String sql = "select  * from pro where id = ?";
        PreparedStatement ps = null;
        ResultSet rs =null;
        ProDetail pd =null;
        List<ProDetail> pl =new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if(rs.next()) {
                int idx = rs.getInt(1);
                String name = rs.getString(2);
                String jiancheng = rs.getString(3);
                String shenghui = rs.getString(4);
                pd = new ProDetail(idx, name, jiancheng, shenghui);
                pl.add(pd);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(ps != null){
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return pl;

    }
    public List getDetail(Connection conn){
        String sql = "select  * from pro ";
        PreparedStatement ps = null;
        ResultSet rs =null;
        ProDetail pd =null;
        List<ProDetail> pl = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                int idx =rs.getInt(1);
                String name =rs.getString(2);
                String jiancheng = rs.getString(3);
                String shenghui =rs.getString(4);
                pd = new ProDetail(idx,name,jiancheng,shenghui);
                pl.add(pd);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(ps != null){
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return pl;

    }
    public List getCity(Integer id,Connection conn){
        String sql = "select  * from city where provinceid = ? ";
        PreparedStatement ps = null;
        ResultSet rs =null;
        CityDetail cd =null;
        List<CityDetail> cl = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while(rs.next()){
                int idx =rs.getInt(1);
                String name =rs.getString(2);
                cd = new CityDetail(idx,name,id);
                cl.add(cd);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(ps != null){
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return cl;

    }
}
