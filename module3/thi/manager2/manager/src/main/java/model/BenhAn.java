package model;

public class BenhAn {
    private String id;
    private String benhNhanId;
    private String tenBenhNhan;
    private String ngayVao;
    private String ngayRa;
    private String liDo;

    public BenhAn(String id, String benhNhanId, String tenBenhNhan, String ngayVao, String ngayRa, String liDo) {
        this.id = id;
        this.benhNhanId = benhNhanId;
        this.tenBenhNhan = tenBenhNhan;
        this.ngayVao = ngayVao;
        this.ngayRa = ngayRa;
        this.liDo = liDo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBenhNhanId() {
        return benhNhanId;
    }

    public void setBenhNhanId(String benhNhanId) {
        this.benhNhanId = benhNhanId;
    }

    public String getTenBenhNhan() {
        return tenBenhNhan;
    }

    public void setTenBenhNhan(String tenBenhNhan) {
        this.tenBenhNhan = tenBenhNhan;
    }

    public String getNgayVao() {
        return ngayVao;
    }

    public void setNgayVao(String ngayVao) {
        this.ngayVao = ngayVao;
    }

    public String getNgayRa() {
        return ngayRa;
    }

    public void setNgayRa(String ngayRa) {
        this.ngayRa = ngayRa;
    }

    public String getLiDo() {
        return liDo;
    }

    public void setLiDo(String liDo) {
        this.liDo = liDo;
    }
}
