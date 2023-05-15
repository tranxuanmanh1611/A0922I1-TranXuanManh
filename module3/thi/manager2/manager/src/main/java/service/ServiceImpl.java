package service;

import model.BenhAn;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceImpl implements Service{

    private static final String url = "jdbc:mysql://localhost:3306/patient_manager?useSSL=false";
    private static final String username = "root";
    private static final String pass = "123456789";
    private static final String driver = "com.mysql.jdbc.Driver";

    private Connection getConnection() {
        Connection cn = null;
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            cn = DriverManager.getConnection(url, username, pass);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cn;
    }

    @Override
    public List<BenhAn> getAll() {
        String sql_get_all = "select benh_an.id, benh_an.benh_nhan_id, benh_nhan.name, benh_an.in_date, benh_an.out_date, benh_an.reason " +
                "from benh_an join benh_nhan on benh_an.benh_nhan_id = benh_nhan.id";
        List<BenhAn> benh_an_list = new ArrayList<>();
        try(Connection cn=getConnection(); PreparedStatement sm = cn.prepareStatement(sql_get_all); ResultSet rs=sm.executeQuery()){
            while (rs.next()){
                String benh_an_id = rs.getString(1);
                String benh_nhan_id = rs.getString(2);
                String benh_nhan_name = rs.getString(3);
                String vao = rs.getString(4);
                String ra = rs.getString(5);
                String ly_do = rs.getString(6);


                benh_an_list.add(new BenhAn(benh_an_id,benh_nhan_id,benh_nhan_name,vao,ra,ly_do));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return benh_an_list;
    }

    @Override
    public BenhAn getById(String id) {
        String sql_by_id = "select benh_an.id, benh_an.benh_nhan_id, benh_nhan.name, benh_an.in_date, benh_an.out_date, benh_an.reason " +
                "from benh_an join benh_nhan on benh_an.benh_nhan_id = benh_nhan.id" +
                " where benh_an.id = ?";
        BenhAn benhAn = null;
        try(Connection cn =getConnection();PreparedStatement sm = cn.prepareStatement(sql_by_id)){
            sm.setString(1,id);
            ResultSet rs = sm.executeQuery();
            while (rs.next()){
                String benh_an_id = rs.getString(1);
                String benh_nhan_id = rs.getString(2);
                String benh_nhan_name = rs.getString(3);
                String vao = rs.getString(4);
                String ra = rs.getString(5);
                String ly_do = rs.getString(6);

                benhAn=new BenhAn(benh_an_id,benh_nhan_id,benh_nhan_name,vao,ra,ly_do);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return benhAn;
    }

    @Override
    public void update(String id, String name, String ngay_vao, String ngay_ra, String ly_do) {
        String benh_nhan_id = getBenhNhanId(id);
        String sql_update_benh_nhan ="update benh_nhan set name = ? where id = ?";
        String sql_update_benh_an ="update benh_an set in_date=?, out_date=?, reason=? where id=?";
        try (Connection cn = getConnection(); PreparedStatement sm1 = cn.prepareStatement(sql_update_benh_nhan)){
            sm1.setString(1,name);
            sm1.setString(2,benh_nhan_id);
            sm1.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try (Connection cn=getConnection();PreparedStatement sm2 =cn.prepareStatement(sql_update_benh_an)){
            sm2.setString(1,ngay_vao);
            sm2.setString(2,ngay_ra);
            sm2.setString(3,ly_do);
            sm2.setString(4,id);
            sm2.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getBenhNhanId(String idBenhAn){
        String sql_get_id_benh_nhan ="select benh_nhan_id from benh_an where id =?";
        String id = null;
        try (Connection cn=getConnection();PreparedStatement sm=cn.prepareStatement(sql_get_id_benh_nhan)){
            sm.setString(1,idBenhAn);
            ResultSet rs = sm.executeQuery();
            while (rs.next()){
                id=rs.getString(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }

public void delete(String id){
        String sql_delete = "delete from benh_an where id =?";
                try(Connection cn=getConnection();PreparedStatement sm = cn.prepareStatement(sql_delete)){
                    sm.setString(1,id);
                    sm.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
}
}
