package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import util.FileHelper;

/**
 *
 * Họ tên sinh viên: Lê Văn Thắng
 */
public class QLKhachHang {

    private ArrayList<KhachHang> dsKhachHang = new ArrayList();

    public QLKhachHang() {
        dsKhachHang = new ArrayList<>();
    }

    public QLKhachHang(ArrayList<KhachHang> dsKhachHang) {
        this.dsKhachHang = dsKhachHang;
    }

    public ArrayList<KhachHang> getDsKhachHang() {
        return dsKhachHang;
    }

    public void setDsKhachHang(ArrayList<KhachHang> dsKhachHang) {
        this.dsKhachHang = dsKhachHang;
    }

   
    public void DocKhachHang(String filename) {
       try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                KhachHang kh = new KhachHang(data[0], data[1], Integer.parseInt(data[2]),
                        Double.parseDouble(data[3]), Double.parseDouble(data[4]));
                dsKhachHang.add(kh);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean GhiHoaDon(String filename) {
          try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (KhachHang kh : dsKhachHang) {
                double tieuThu = kh.getTieuThu();
                double tienTra = kh.tinhTienTra();
                bw.write(kh.getMaso() + ";" + kh.getHoten() + ";" + tieuThu + ";" + tienTra);
                bw.newLine();
            }
            return true; // Trả về true khi ghi thành công
        } catch (IOException e) {
            e.printStackTrace();
            return false; // Trả về false khi gặp lỗi
        }
    }

   
    public void sapXepTheoMucTieuThu() {
        Collections.sort(dsKhachHang, Comparator.comparingDouble(KhachHang::getTieuThu));    
    }
    
    public double getTieuThuCaoNhat()
    {
      double max = 0;
        for (KhachHang kh : dsKhachHang) {
            double tieuThu = kh.getTieuThu();
            if (tieuThu > max) {
                max = tieuThu;
            }
        }
        return max;
    }
    
    public double getTieuThuThapNhat()
    {
          return dsKhachHang.stream()
                .mapToDouble(KhachHang::getTieuThu)
                .min()
                .orElse(0);
    }
    
    public double getTieuThuTrungBinh()
    {
         return dsKhachHang.stream()
                .mapToDouble(KhachHang::getTieuThu)
                .average()
                .orElse(0);
    }
}
