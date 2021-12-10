package QuanLyKS.Bills;

import QuanLyKS.Constants;
import QuanLyKS.Hotels.LeTan;

public class ChiTietHoaDon extends HoaDon implements Constants{
    private String tenKH, diaChi, email, soDT, soCMND;
    private int soNgayThue, maPhg, maKH;
    private double soTienThuePhong, soTienKhachTra, thueGTGT;
    boolean ATM;
    CreditCard card;
    LeTan nvlt;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(int maKH, String tenKH, String diaChi, String email, String soDT, String soCMND, int soNgayThue, int maPhg, double soTienThuePhong, double soTienKhachTra, int maHoaDon) {
        super(maHoaDon);
        
        this.maKH = maKH;
        
        tenKH = justify_String(tenKH);
        this.tenKH = tenKH;
        
        diaChi = justify_String(diaChi);
        this.diaChi = diaChi;
        
        email = justify_String(email);
        this.email = email;
        
        soDT = justify_String(soDT);
        this.soDT = soDT;
        
        soCMND = justify_String(soCMND);
        this.soCMND = soCMND;
        
        if (soNgayThue <= 0)
            this.soNgayThue = 1;
        else
            this.soNgayThue = soNgayThue;
        
        this.maPhg = maPhg;
        
        if (soTienThuePhong <= 0)
            this.soTienThuePhong = 1;
        else
            this.soTienThuePhong = soTienThuePhong;
        if (soTienKhachTra <= 0)
            this.soTienKhachTra = 1;
        else
            this.soTienKhachTra = soTienKhachTra;
        this.thueGTGT = soTienThuePhong * 0.05;
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
        email = email.trim();
        while (email.contains(" "))
            email = email.replace(" ", "");
        this.email = email;
    }
    
    public void setSoDT() {
        System.out.println("Nhap so dien thoai cua khach hang:");
        soDT = sc.nextLine();
        soDT = soDT.trim();
        while (soDT.contains(" "))
            soDT = soDT.replace(" ", "");
        this.soDT = soDT;
    }

    public void setSoCMND() {
        System.out.println("Nhap so CMND cua khach hang:");
        soCMND = sc.nextLine();
        soCMND = soCMND.trim();
        while (soCMND.contains(" "))
            soCMND = soCMND.replace(" ", "");
        this.soCMND = soCMND;
    }

    public void setSoNgayThue() {
        System.out.println("Nhap so ngay thue phong:");
        while (true){
            soNgayThue = Integer.parseInt(sc.nextLine());
            if (soNgayThue <= 0)
                System.out.println("So ngay thue phong khong hop le, moi nhap lai:");
            else{
                this.soNgayThue = soNgayThue; break;
            }
        }
    }

    public void setSoTienThuePhong() {
        System.out.println("Nhap so tien thue phong:");
        while (true){
            soTienThuePhong = Double.parseDouble(sc.nextLine());
            if (soTienThuePhong <= 0)
                System.out.println("Gia tri ko hop le, moi nhap lai:");
            else{
                this.soTienThuePhong = soTienThuePhong; break;
            }
        }
    }

    public void setSoTienKhachTra() {
        System.out.println("Nhap so tien khach tra:");
        while (true){
            soTienKhachTra = Double.parseDouble(sc.nextLine());
            if (soTienKhachTra <= 0)
                System.out.println("Gia tri ko hop le, moi nhap lai:");
            else if (soTienKhachTra < tinhTongTien())
                System.out.println("So tien nho hon gia ca cua phong, vui long nhap lai:");
            else{
                this.soTienKhachTra = soTienKhachTra; break;
            }
        }
    }

    public void setThueGTGT() {
        this.thueGTGT = soTienThuePhong * 0.05;
    }

    @Override
    public void set_NVLT() {
        nvlt = new LeTan();
        nvlt.nhap();
    }

    public String getTenKH() {
        return tenKH;
    }

    public int getSoNgayThue() {
        return soNgayThue;
    }

    public double getSoTienThuePhong() {
        return soTienThuePhong;
    }

    public double getSoTienKhachTra() {
        return soTienKhachTra;
    }

    public double getThueGTGT() {
        return thueGTGT;
    }

    @Override
    public double tinhTongTien() {
        return soTienThuePhong + thueGTGT;
    }
    
    public double tinhTienThua(){
        return soTienKhachTra - tinhTongTien();
    }

    @Override
    public void inHoaDon() {
        System.out.println("\n\n----------HOA DON THANH TOAN----------");
        System.out.printf("Ngay: %d/%d/%d\n", DATE, MONTH+1, YEAR);
        System.out.printf("Ma hoa don: %d\n", getMaHoaDon());
        System.out.println("-----NHAN VIEN LE TAN-----");
        System.out.printf("Ma LT: %d\n", nvlt.getMaLT());
        System.out.printf("Ho ten: %5s\n", nvlt.getTen());
        System.out.printf("So dien thoai: %5s\n", nvlt.getSoDt());
        System.out.printf("Email: %5s\n", nvlt.getEmail());
        System.out.println("-----KHACH HANG-----");
        System.out.printf("Ma KH: %d\n", maKH);
        System.out.printf("Ho ten khach hang: %5s\n", tenKH);
        System.out.printf("Dia chi: %5s\n", diaChi);
        System.out.printf("Email: %5s\n", email);
        System.out.printf("So dien thoai: %5s\n", soDT);
        System.out.printf("So CMND: %5s\n", soCMND);
        System.out.println("-----THANH TOAN-----");
        System.out.printf("Ma so cua phong da dat: %d\n", maPhg);
        System.out.printf("So ngay thue phong: %d\n", soNgayThue);
        System.out.printf("Tien thue phong: %5.1f VND\n", soTienThuePhong);
        System.out.printf("Thue GTGT: %5.1f VND\n", thueGTGT);
        System.out.println("-----");
        System.out.printf("Tong so tien can tra: %5.1f VND\n", tinhTongTien());
        if (ATM){
            System.out.printf("-----THANH TOAN BANG THE TIN DUNG-----\n");
            System.out.printf("So the: %5s\n", card.getSoThe());
            System.out.printf("Loai the: %5s\n", card.getLoaiThe());
            System.out.printf("Ho ten chu the: %5s\n", card.getTenChuThe());
            System.out.printf("Ngay het han: %d/%d\n", card.getMonth(), card.getYear());
            System.out.printf("So tien giao dich: %5.1f VND\n", soTienKhachTra);
        }
        else{
            System.out.println("-----THANH TOAN BANG TIEN MAT-----\n");
            System.out.printf("Tien khach tra: %5.1f VND\n", soTienKhachTra);
            System.out.printf("Tien thoi lai cho khach: %5.1f VND\n", tinhTienThua());
        }
        System.out.println("\n-----XIN CAM ON QUY KHACH-----");
    }
    
    @Override
    public void phThucThanhToan(){
        String input;
        System.out.println("Vui long chon phuong thuc thanh toan de thuc hien giao dich: (ATM or Cash)"); 
        while (true){
            input = sc.nextLine();
            input = input.trim();
            while (input.contains(" "))
                input = input.replace(" ","");
            if (input.equalsIgnoreCase("atm") || input.equalsIgnoreCase("cash"))
                //Nếu giao dịch bằng thẻ
                if (input.equalsIgnoreCase("atm")){
                    ATM = true;
                    card = new CreditCard();
                    card.nhap();
                    //Nếu đồng ý lấy quyền truy cập
                    if (card.layQuyenTruyCap()){
                        soTienKhachTra = card.giaoDich(tinhTongTien());
                        //Nếu từ chối giao dịch
                        if (soTienKhachTra == 0){
                            System.out.println("Da tu choi giao dich.");
                            break;
                        }
                        //Nếu đồng ý giao dịch
                        else{
                            inHoaDon(); break;
                        }
                    }
                    //Nếu từ chối lấy quyền tuy cập
                    else{
                        System.out.println("Tu choi truy cap vao the, giao dich that bai."); break;
                    }
                }
                
                //Nếu trả tiền mặt
                else{
                    ATM = false;
                    setSoTienKhachTra();
                    inHoaDon();
                    break;
                }
            else
                System.out.println("Vui long nhap 'ATM' neu dung the tin dung hoac 'Cash' neu thanh toan tien mat:");
        }
    }
    
    public void nhap(){
        setMaHoaDon();
        setTenKH();
        setDiaChi();
        setEmail();
        setSoDT();
        setSoCMND();
        setSoNgayThue();
        setSoTienThuePhong();
        phThucThanhToan();
        setThueGTGT();
    }
}
