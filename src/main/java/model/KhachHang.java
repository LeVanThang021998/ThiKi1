package model;

/**
 *
 * Họ tên sinh viên: Lê Văn Thắng
 */
public class KhachHang {
    private String maso;
    private String hoten;
    private int sonhankhau;
    private double chisocu;
    private double chisomoi;            

    //constructor
    public KhachHang() {
    }

    public KhachHang(String maso) {
        this.maso = maso;
    }

    public KhachHang(String maso, String hoten, int sonhankhau, double chisocu, double chisomoi) {
        this.maso = maso;
        this.hoten = hoten;
        this.sonhankhau = sonhankhau;
        this.chisocu = chisocu;
        this.chisomoi = chisomoi;
    }

    //setter và getter

    public String getMaso() {
        return maso;
    }

    public void setMaso(String maso) {
        this.maso = maso;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getSonhankhau() {
        return sonhankhau;
    }

    public void setSonhankhau(int sonhankhau) {
        this.sonhankhau = sonhankhau;
    }

    public double getChisocu() {
        return chisocu;
    }

    public void setChisocu(double chisocu) {
        this.chisocu = chisocu;
    }

    public double getChisomoi() {
        return chisomoi;
    }

    public void setChisomoi(double chisomoi) {
        this.chisomoi = chisomoi;
    }
      
    
    //phương thức tính toán    

    public double getTieuThu()
    {
      return chisomoi-chisocu;
    }
    
    
    public double tinhTienTra()
    {      
          double tieuThu = getTieuThu();
        double dinhMuc = getDinhMuc();
        double gia = 0;

        if (tieuThu <= dinhMuc) {
            gia = tieuThu * 6700;
        } else if (tieuThu <= dinhMuc + 2) {
            gia = dinhMuc * 6700 + (tieuThu - dinhMuc) * 12900;
        } else {
            gia = dinhMuc * 6700 + 2 * 12900 + (tieuThu - dinhMuc - 2) * 14400;
        }

        // Tính thuế GTGT và các khoản phụ phí
        double thueGTGT = gia * 0.05;
        double TDVTN = gia * 0.25;
        double thueTDVTN = TDVTN * 0.08;

        return gia + thueGTGT + TDVTN + thueTDVTN;
    }

    private double getDinhMuc() {
       return sonhankhau * 4;
    }
}