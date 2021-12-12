package QuanLyKS.Hotels;

import QuanLyKS.Constants;

public class Phong implements Constants{
    private String tenPhong, tinhTrang, tenLoaiPhong;
    private int ID, soNguoi;
    private double giaCa;

    public Phong() {
    }

    public Phong( int ID, String tenLoaiPhong, String tenPhong, String tinhTrang, int soNguoi) {
        tenLoaiPhong = justify_String(tenLoaiPhong);
        if (tenLoaiPhong.equalsIgnoreCase("thuong") || tenLoaiPhong.equalsIgnoreCase("dac biet") || tenLoaiPhong.equalsIgnoreCase("vip"))
            this.tenLoaiPhong = tenLoaiPhong;
        else
            this.tenLoaiPhong = "Thuong";
        
        tenPhong = justify_String(tenPhong);
        this.tenPhong = tenPhong;
        
        tinhTrang = justify_String(tinhTrang);
        this.tinhTrang = tinhTrang;
        
        ID = Math.abs(ID);
        this.ID = ID;
        
        soNguoi = Math.abs(soNguoi);
        this.soNguoi = soNguoi;
        
        if (tenLoaiPhong.equalsIgnoreCase("thuong"))
            this.giaCa = 100000 * soNguoi * 0.8;
        else if (tenLoaiPhong.equalsIgnoreCase("dac biet"))
            this.giaCa = 250000 * soNguoi * 0.8;
        else
            this.giaCa = 400000 * soNguoi * 0.8;
    }
    
    public String justify_String(String a){
        a = a.trim();
        while (a.contains("  "))
            a = a.replace("  "," ");
        return a;
    }

    public void setTenPhong() {
        System.out.println("Moi nhap ten phong:");
        tenPhong = sc.nextLine();
        tenPhong = justify_String(tenPhong);
        this.tenPhong = tenPhong;
    }

    public void setTinhTrang() {
        System.out.println("Moi nhap tinh trang hien tai cua phong:");
        tinhTrang = sc.nextLine();
        tinhTrang = justify_String(tinhTrang);
        this.tinhTrang = tinhTrang;
    }
    
    public void setTenLoaiPhong() {
        System.out.println("Nhap ten loai phong cua khach san:");
        System.out.println("('Thuong' hoac 'Dac biet' hoac 'VIP')");
        while (true){
            tenLoaiPhong = sc.nextLine();
            tenLoaiPhong = justify_String(tenLoaiPhong);
            if (tenLoaiPhong.equalsIgnoreCase("thuong") || tenLoaiPhong.equalsIgnoreCase("dac biet") || tenLoaiPhong.equalsIgnoreCase("vip")){
                this.tenLoaiPhong = tenLoaiPhong; break;
            }
            else
                System.out.println("Loai phong ko hop le, moi nhap lai:");
        }
    }

    public void setID() {
        System.out.println("Nhap ma so cua phong nay:");
        while (true){
            ID = Integer.parseInt(sc.nextLine());
            if (Integer.toString(ID).length() < 3 || Integer.toString(ID).length() > 3)
                System.out.println("Ma so phong chi co the chua 3 chu so, moi nhap lai:");
            else{
                this.ID = ID;
                break;}
        }
    }

    public void setSoNguoi() {
        System.out.println("Nhap so nguoi cua phong nay:");
        while (true){
            soNguoi = Integer.parseInt(sc.nextLine());
            if (soNguoi <= 0)
                System.out.println("So nguoi khong hop le, moi nhap lai:");
            else{
                this.soNguoi = soNguoi;
                break;}
        }
    }
    
    public void setGiaCa() {
        if (tenLoaiPhong.equalsIgnoreCase("thuong"))
            this.giaCa = 100000 * soNguoi * 0.8;
        else if (tenLoaiPhong.equalsIgnoreCase("dac biet"))
            this.giaCa = 250000 * soNguoi * 0.8;
        else
            this.giaCa = 400000 * soNguoi * 0.8;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public int getID() {
        return ID;
    }

    public int getSoNguoi() {
        return soNguoi;
    }

    public double getGiaCa() {
        return giaCa;
    }

    public String getTenLoaiPhong() {
        return tenLoaiPhong;
    }

    public void nhap(){
        try{
            setTenLoaiPhong();
            setID();
            setTenPhong();
            setTinhTrang();
            setSoNguoi();
            setGiaCa();
        } catch (NumberFormatException u){
                System.out.println("\nLOI: Gia tri phai la 1 so.");
        }
    }

    @Override
    public String toString() {
        return tenLoaiPhong + ";" + ID + ";" + tenPhong + ";" + tinhTrang + ";" + soNguoi;
    }
    
    
    public void xuat(){
        System.out.printf("| Loai phong: %10s | Ma phong: %d | Ten phong: %20s | Tinh trang: %15s | So nguoi: %d | Gia ca: %5.1f VND\n",tenLoaiPhong, ID, tenPhong, tinhTrang, soNguoi, giaCa);
    }
}
