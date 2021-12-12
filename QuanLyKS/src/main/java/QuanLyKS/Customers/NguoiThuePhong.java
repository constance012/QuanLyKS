package QuanLyKS.Customers;

import QuanLyKS.Bills.ChiTietHoaDon;
import QuanLyKS.Constants;
import QuanLyKS.Bills.HoaDon;

public class NguoiThuePhong extends ThuePhong implements Constants{
    private String tenKH, gioiTinh, soDT, soCMND, diaChi, email;
    private int maKH;
    HoaDon bill;

    public NguoiThuePhong() {
    }

    public NguoiThuePhong(int maKH, String tenKH, String gioiTinh, String soDT, String soCMND, String diaChi, String email, int soNguoi, int soNgayThue, int maPhg, double soTienThuePhong, double soTienKhachTra, int maHoaDon) {
        super(soNguoi, soNgayThue);
        tenKH = justify_String(tenKH);
        this.tenKH = tenKH;
        
        gioiTinh = justify_String(gioiTinh);
        if (gioiTinh.toLowerCase() != "nam" || gioiTinh.toLowerCase() != "nu")
            gioiTinh = "nam";
        else
            this.gioiTinh = gioiTinh;
        
        soDT = justify_String(soDT);
        this.soDT = soDT;
        soCMND = justify_String(soCMND);
        this.soCMND = soCMND;
        
        maKH = Math.abs(maKH);
        this.maKH = maKH;
        
        soTienThuePhong *= (super.getSoNgayThue() * 0.7);
        
        bill = new ChiTietHoaDon(maKH, tenKH, diaChi, email, soDT, soCMND, soNguoi, soNgayThue, maPhg, soTienThuePhong, soTienKhachTra, maHoaDon);
    }
    
    public String justify_String(String a){
        a = a.trim();
        while (a.contains("  "))
            a = a.replace("  "," ");
        return a;
    }

    public void setTenKH() {
        System.out.println("Nhap ten khach hang:");
        tenKH = sc.nextLine();
        tenKH = justify_String(tenKH);
        this.tenKH = tenKH;
    }

    public void setDiaChi() {
        System.out.println("Nhap dia chi khach hang:");
        diaChi = sc.nextLine();
        diaChi = justify_String(diaChi);
        this.diaChi = diaChi;
    }

    public void setEmail() {
        System.out.println("Nhap email cua khach hang:");
        email = sc.nextLine();
        email = email.trim();
        while (email.contains(" "))
            email = email.replace(" ", "");
        this.email = email;
    }

    public void setGioiTinh() {
        System.out.println("Nhap gioi tinh cua khach hang:");
        while (true){
            gioiTinh = sc.nextLine();
            gioiTinh = justify_String(gioiTinh);
            if (gioiTinh.equalsIgnoreCase("nam") || gioiTinh.equalsIgnoreCase("nu")){
                this.gioiTinh = gioiTinh; break;
            }
            else
                System.out.println("Gioi tinh khong hop le, moi nhap lai:");
        }
    }

    public void setSoDT() {
        System.out.println("Nhap so dien thoai cua khach hang:");
        while (true){
            soDT = sc.nextLine();
            soDT = soDT.trim();
            while (soDT.contains(" "))
                soDT = soDT.replace(" ", "");
            if (soDT.length() < 10 || soDT.length() > 10)
                System.out.println("So dien thoai phai du 10 chu so, moi nhap lai:");
            else{
                this.soDT = soDT; break;
            }
        }
    }

    public void setSoCMND() {
        System.out.println("Nhap so CMND cua khach hang:");
        while (true){
            soCMND = sc.nextLine();
            soCMND = soCMND.trim();
            while (soCMND.contains(" "))
                soCMND = soCMND.replace(" ", "");
            if (soCMND.length() < 12 || soCMND.length() > 12)
                System.out.println("So CMND phai du 12 chu so, moi nhap lai:");
            else{
                this.soCMND = soCMND; break;
            }
        }
    }

    public void setMaKH() {
        System.out.println("Nhap ma so cua khach hang:");
        while (true){
            maKH = Integer.parseInt(sc.nextLine());
            if (maKH <= 0)
                System.out.println("Ma khach hang ko hop le, moi nhap lai:");
            else{
                this.maKH = maKH; break;
            }
        }
    }

    public String getTenKH() {
        return tenKH;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getEmail() {
        return email;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getSoDT() {
        return soDT;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public int getMaKH() {
        return maKH;
    }
    
    @Override
    public void nhap(int maPhg, double soTienThuePhong, double soTienKhachTra, int maHoaDon){
        try{
            super.setSoNguoi();
            super.setSoNgayThue();
            setMaKH();
            setTenKH();
            setDiaChi();
            setEmail();
            setGioiTinh();
            setSoCMND();
            setSoDT();
            if (super.getSoNguoi() > 2)
                soTienThuePhong *= (super.getSoNgayThue() * 0.7 + super.getSoNguoi() * 0.2);
            else
                soTienThuePhong *= (super.getSoNgayThue() * 0.7);
            bill = new ChiTietHoaDon(maKH, tenKH, diaChi, email, soDT, soCMND, soNguoi, soNgayThue, maPhg, soTienThuePhong, soTienKhachTra, maHoaDon);
        } catch (NumberFormatException u){
                System.out.println("\nLOI: Gia tri nhap vao khong hop le.");
        }
    }
    
    @Override
    public void xuat(){
        System.out.printf("\nSo nguoi thue phong: %d | So ngay thue phong: %d\n", soNguoi, soNgayThue);
        System.out.printf("\nMa KH: %d | Ten KH %5s | Gioi tinh: %5s | So CMND: %5s | So Dt: %5s\n", maKH, tenKH, gioiTinh, soCMND, soDT);
    }
    
    @Override
    public void inHoaDon(){
        bill.set_NVLT();
        bill.phThucThanhToan();
    }
    
    @Override
    public void in_DSHoaDon(){
        bill.inHoaDon();
    }
}
