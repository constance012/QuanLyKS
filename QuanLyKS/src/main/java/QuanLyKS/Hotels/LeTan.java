package QuanLyKS.Hotels;

import QuanLyKS.Constants;

public class LeTan implements Constants{
    private String ten, soDt, email;
    private int maLT;

    public LeTan() {
    }

    public LeTan(int maLT, String ten, String soDt, String email) {
        ten = justify_String(ten);
        this.ten = ten;
        
        soDt = soDt.trim();
        while (soDt.contains(" "))
            soDt = soDt.replace(" ","");
        this.soDt = soDt;
        
        maLT = Math.abs(maLT);
        this.maLT = maLT;
        
        email = justify_String(email);
        this.email = email;
    }
    
    public String justify_String(String a){
        a = a.trim();
        while (a.contains("  "))
            a = a.replace("  "," ");
        return a;
    }

    public void setTen() {
        System.out.println("Nhap ten cua nhan vien le tan:");
        ten = sc.nextLine();
        ten = justify_String(ten);
        this.ten = ten;
    }

    public void setSoDt() {
        System.out.println("Nhap so dien thoai cua nhan vien le tan:");
        while (true){
            soDt = sc.nextLine();
            soDt = soDt.trim();
            while (soDt.contains(" "))
                soDt = soDt.replace(" ","");
            if (soDt.length() < 10 || soDt.length() > 10)
                System.out.println("So dien thoai phai du 10 chu so, moi nhap lai:");
            else{
                this.soDt = soDt; break;
            }
        }
    }

    public void setEmail() {
        System.out.println("Nhap email cua nhan vien le tan:");
        email = sc.nextLine();
        email = justify_String(email);
        this.email = email;
    }

    public void setMaLT() {
        System.out.println("Nhap ma so cua nhan vien le tan:");
        while (true){
            maLT = Integer.parseInt(sc.nextLine());
            if (maLT <= 0 || maLT > 999)
                System.out.println("Ma le tan ko hop le, moi nhap lai:");
            else{
                this.maLT = maLT;
                break;
            }
        }
    }

    public String getTen() {
        return ten;
    }

    public String getSoDt() {
        return soDt;
    }

    public String getEmail() {
        return email;
    }

    public int getMaLT() {
        return maLT;
    }
    
    public void nhap(){
        try{
            setMaLT();
            setTen();
            setSoDt();
            setEmail();
        } catch (NumberFormatException u){
            System.out.println("\nLOI: Gia tri phai la 1 so.");
        }
    }
    
    public void xuat(){
        System.out.printf("\nMa LT: %d | Ten: %5s | Nam sinh: %d | So đt: %5s | Email: %5s\n", maLT, ten, soDt, email);
    }
}
