package QuanLyKS;

import QuanLyKS.Customers.NguoiThuePhong;
import QuanLyKS.Customers.ThuePhong;
import QuanLyKS.Hotels.Phong;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class App implements Constants{
    int maHD = 1;
    Phong dsp[] = new Phong[1];
    ThuePhong booking[] = new NguoiThuePhong [1];
    String path, file_name;
    
    //Hàm hiện menu
    public void menu(){
        System.out.println("\n----------Danh sach chuc nang----------\n");
        System.out.println("1. Doc du lieu tu file text.");
        System.out.println("2. Luu thay doi vao file.");
        System.out.println("3. Xuat danh sach cac phong.");
        System.out.println("4. Them phong.");
        System.out.println("5. Xoa phong.");
        System.out.println("6. Sua doi thong tin phong co san.");
        System.out.println("7. Tim phong.");
        System.out.println("8. Dat phong.");
        System.out.println("9. In hoa don.");
        System.out.println("10. In danh sach cac hoa don truoc do.");
        System.out.println("11. Thoat chuong trinh.");
        System.out.println("----------");
        System.out.println("Ban muon thuc hien dieu gi?");
    }
    
    //Hàm chuẩn hóa chuỗi
    public String justify_String(String a){
        a = a.trim();
        while (a.contains("  "))
            a = a.replace("  "," ");
        return a;
    }
    
    //Hàm đọc file rooms.txt
    public void Read_From_File(){
        int maSo, soNguoi;
        String loai, ten, tinhTrang, line;

        try{
            System.out.println("Nhap duong dan den file:");
            path = sc.nextLine();
            System.out.println("Nhap ten file:");
            file_name = sc.nextLine();
            FileReader fr = new FileReader(path + "\\" + file_name + ".txt");
            BufferedReader br = new BufferedReader(fr);
            while (true){
                line = br.readLine();
                if (line==null) 
                    break;
                if (dsp[0]!=null)
                    dsp = Arrays.copyOf(dsp, dsp.length + 1);
                String str[] = line.split(";");
                loai = str[0];
                maSo = Integer.parseInt(str[1]);
                ten = str[2];
                tinhTrang = str[3];
                soNguoi = Integer.parseInt(str[4]);
                dsp[dsp.length-1] = new Phong(maSo,loai,ten,tinhTrang,soNguoi);
            }
            System.out.println("DOC FILE TEXT THANH CONG!");
            br.close();
            fr.close();
        } catch (IOException x){
            System.out.println("Xay ra loi khi doc file, vui long thu lai.");
        }
    }
    
    //Hàm ghi dữ liệu vào file
    public void Write_To_File(){
        String input;
        try{
            System.out.println("He thong se ghi de len file gan nhat truoc do, ban dong y chu? (yes or no)");
            input = sc.nextLine();
            input = input.trim();
            
            if (input.toLowerCase().startsWith("y") == false){
                System.out.println("Nhap duong dan den file:");
                path = sc.nextLine();
                System.out.println("Nhap ten file:");
                file_name = sc.nextLine();
            }
            
            if(path == null || file_name == null)
                System.out.println("KO TIM THAY FILE GAN NHAT TRUOC DO DE GHI DE.");
            else{
                FileWriter fw = new FileWriter(path + "\\" + file_name + ".txt");
                BufferedWriter bw = new BufferedWriter(fw);
                for (Phong ob:dsp){
                    bw.write(ob.toString());
                    bw.newLine();
                }
                System.out.println("CAC THAY DOI DA DUOC LUU LAI.");
                bw.close();
                fw.close();
            }
        } catch (IOException x) {
            System.out.println("Xay ra loi khi ghi file, vui long thu lai.");
        } catch (NullPointerException y){
            System.out.println("\nLUU Y: MOT SO VI TRI TRONG DANH SACH CO THE CHUA CO DU LIEU.");
        }
    }
    
    //Hàm xuất danh sách phòng
    public void xuat_all(){
        try{
            if (dsp[0] == null)
                System.out.println("DANH SACH CHUA CO DU LIEU, VUI LONG THU LAI.");
            else{
                System.out.println("Xuat danh sach cac phong:\n");
                int i = 0;
                for (Phong ob:dsp){
                    System.out.printf("STT: %3d ", i);
                    ob.xuat();
                    i++;
                }
            }
        } catch (NullPointerException y){
            System.out.println(" (VI TRI NAY CHUA CO DU LIEU.)");
        }
    }
    
    //Hàm chèn thêm 1 phòng vào danh sách
    public void chen_ptu(){
        int k;
        boolean exist = false;
        System.out.println("Nhap vi tri muon chen:");
        while (true){
            k = Integer.parseInt(sc.nextLine());
            if (k < 0 || k >= dsp.length)
                System.out.println("Vi tri chen ko hop le, moi nhap lai:");
            else{
                dsp = Arrays.copyOf(dsp, dsp.length + 1);
                break;
            }
        }

        for(int i=dsp.length - 1; i>k; i--)
            dsp[i] = dsp[i - 1];
        while (true){
            dsp[k] = new Phong();
            dsp[k].setID();
            
            //Kiểm tra mã phòng có bị trùng hay không
            for (int i=0; i<k; i++)
                if (dsp[k].getID() == dsp[i].getID())
                    exist = true;
            for (int i=dsp.length - 1; i>k; i--)
                if (dsp[k].getID() == dsp[i].getID())
                    exist = true;
            
            if (exist){
                System.out.println("Ma phong bi trung, vui long nhap lai.");
                exist = false;
            }
            else{
                dsp[k].nhap();
                break;
            }
        }
        System.out.println("THEM PHONG THANH CONG!");
        System.out.println("\nLUU Y: CAC THAY DOI CHUA DUOC LUU LAI VAO FILE.");
    }
    
    //Hàm xóa 1 phòng từ danh sách
    public void xoa_ptu(){
        int x;
        System.out.println("Nhap STT cua phong can xoa:");
        while (true){
            x = Integer.parseInt(sc.nextLine());
            if (x < 0 || x >= dsp.length)
                System.out.println("STT can xoa ko hop le, moi nhap lai:");
            else
                break;
        }
        if (dsp[x] == null)
            System.out.println("VI TRI NAY CHUA CO DU LIEU, KO THE XOA.");
        else{
            for (int i=x; i<dsp.length - 1; i++)
                dsp[i] = dsp[i + 1];
            dsp = Arrays.copyOf(dsp, dsp.length - 1);
            System.out.println("XOA THANH CONG!");
            System.out.println("\nLUU Y: CAC THAY DOI CHUA DUOC LUU LAI VAO FILE.");
        }
    }
    
    //Hàm sửa đổi thông tin của 1 phòng có sẵn trong danh sách
    public void sua_phong(){
        int x;
        boolean exist = false;
        System.out.println("Nhap STT cua phong can sua doi:");
        while (true){
            x = Integer.parseInt(sc.nextLine());
            if (x < 0 || x >= dsp.length)
                System.out.println("STT cua phong can sua doi ko hop le, moi nhap lai:");
            else
                break;
        }
        if (dsp[x] == null)
            System.out.println("VI TRI NAY CHUA CO DU LIEU, KO THE SUA.");
        else{
            while (true){
                dsp[x] = new Phong();
                dsp[x].setID();
                
                //Kiểm tra mã phòng có bị trùng hay không
                for (int i=0; i<x; i++)
                    if (dsp[x].getID() == dsp[i].getID())
                        exist = true;
                for (int i=dsp.length - 1; i>x; i--)
                    if (dsp[x].getID() == dsp[i].getID())
                        exist = true;
                
                if (exist){
                    System.out.println("Ma phong bi trung, vui long nhap lai.");
                    exist = false;
                }
                else{
                    dsp[x].nhap();
                    break;
                }
            }
            System.out.println("CHINH SUA THANH CONG!");
            System.out.println("\nLUU Y: CAC THAY DOI CHUA DUOC LUU LAI VAO FILE.");
        }
    }
    
    //Hàm tìm kiếm phòng dựa trên thuộc tính
    public void tim_phong(){
        try{
            String input, keyword;
            int j = 0;
            boolean found = false;
            
            if (dsp[0] == null)
                System.out.println("DANH SACH CHUA CO DU LIEU, KHONG THE TIM KIEM.");
            else{
                System.out.println("Ban muon tim phong theo thuoc tinh gi?");
                System.out.println("('Loai phong' hay 'Tinh trang' hay 'So nguoi' hay 'ten phong')");
                while (true){
                    keyword = sc.nextLine();
                    keyword = justify_String(keyword);

                    //Tìm theo loại phòng
                    if (keyword.equalsIgnoreCase("loai phong")){
                        System.out.println("Nhap loai phong can tim kiem:");
                        input = sc.nextLine();
                        input = justify_String(input);
                        System.out.println("\nKet qua:\n");
                        for (int i=0; i<dsp.length; i++)
                            if (dsp[i].getTenLoaiPhong().equalsIgnoreCase(input)){
                                System.out.printf("STT: %3d ", j);
                                dsp[i].xuat();
                                found = true;
                                j++;
                            }
                            else if (i == dsp.length - 1 && found == false)
                                System.out.println("Khong tim thay phong thoa yeu cau da cho!");
                        break;
                    }

                    //Tìm theo tình trạng
                    else if (keyword.equalsIgnoreCase("tinh trang")){
                        System.out.println("Nhap tinh trang cua cac phong can tim kiem:");
                        input = sc.nextLine();
                        input = justify_String(input);
                        System.out.println("\nKet qua:\n");
                        for (int i=0; i<dsp.length; i++)
                            if (dsp[i].getTinhTrang().equalsIgnoreCase(input)){
                                System.out.printf("STT: %3d ", j);
                                dsp[i].xuat();
                                found = true;
                                j++;
                            }
                            else if (i == dsp.length - 1 && found == false)
                                System.out.println("Khong tim thay phong thoa yeu cau da cho!");
                        break;
                    }

                    //Tìm theo số người
                    else if (keyword.equalsIgnoreCase("so nguoi")){
                        System.out.println("Nhap so nguoi cua cac phong can tim kiem:");
                        input = sc.nextLine();
                        input = justify_String(input);
                        System.out.println("\nKet qua:\n");
                        for (int i=0; i<dsp.length; i++)
                            if (dsp[i].getSoNguoi() == Integer.parseInt(input)){
                                System.out.printf("STT: %3d ", j);
                                dsp[i].xuat();
                                found = true;
                                j++;
                            }
                            else if (i == dsp.length - 1 && found == false)
                                System.out.println("Khong tim thay phong thoa yeu cau da cho!");
                        break;
                    }

                    //Tìm theo tên phòng
                    else if (keyword.equalsIgnoreCase("ten phong")){
                        System.out.println("Nhap ten cua cac phong can tim kiem:");
                        input = sc.nextLine();
                        input = justify_String(input);
                        System.out.println("\nKet qua:\n");
                        for (int i=0; i<dsp.length; i++)
                            if (dsp[i].getTenPhong().charAt(0) == input.charAt(0)){
                                System.out.printf("STT: %3d ", j);
                                dsp[i].xuat();
                                found = true;
                                j++;
                            }
                            else if (i == dsp.length - 1 && found == false)
                                System.out.println("Khong tim thay phong thoa yeu cau da cho!");
                        break;
                    }

                    //Hỏi lại khi thuộc tính ko hợp lệ
                    else
                        System.out.println("Thuoc tinh can tim ko hop le, moi nhap lai:");
                }
            }
        } catch (NullPointerException y){
            System.out.println("\nDANH SACH CHUA CO DU LIEU, VUI LONG THU LAI.");
        }
    }
    
    //Hàm đặt phòng
    public void dat_phong(){
        try{
            int x;
            boolean done = false;
            double datCoc;
            if (dsp[0] == null)
                System.out.println("DANH SACH CHUA CO DU LIEU, KHONG THE TIEN HANH DAT PHONG.");
            else{
                System.out.println("DAT PHONG CHO KHACH HANG:\n");
                System.out.println("Chon ma phong muon dat:");
                while (true){
                    x = Integer.parseInt(sc.nextLine());
                    for (int i=0; i<dsp.length ;i++)
                        //Nếu tìm thấy x trùng với 1 mã phòng nào đó
                        if (dsp[i].getID() == x){
                            //Nếu phòng con trống
                            if (dsp[i].getTinhTrang().equalsIgnoreCase("con trong")){
                                booking[booking.length - 1] = new NguoiThuePhong();

                                System.out.println("Nhap so tien dat coc truoc cua khach:");
                                while (true){
                                    datCoc = Double.parseDouble(sc.nextLine());
                                    if (datCoc < dsp[i].getGiaCa())
                                        System.out.println("So tien dat coc nho hon gia ca cua phong, moi nhap lai:");
                                    else
                                        break;
                                }
                                booking[booking.length - 1].nhap(dsp[i].getID(), dsp[i].getGiaCa(), datCoc, maHD);
                                maHD++;
                                dsp[i].setTinhTrang();
                                done = true;
                                break;
                            } 
                            //Nếu phòng đã có người
                            else{
                                System.out.println("Phong da chon da co nguoi, vui long chon phong khac:");
                                done = false;
                                break;
                            }
                        }
                        //Nếu chạy hết vòng for mà ko tìm thấy phòng phù hợp
                        else if (i == dsp.length - 1){
                            System.out.println("\nLOI: Ma phong da nhap ko ton tai, vui long nhap lai:");
                            break;
                        }

                    if(done){
                        System.out.println("DAT PHONG THANH CONG!");
                        break;
                    }
                }
            }
        } catch (NullPointerException y){
            System.out.println("\nDANH SACH CHUA CO DU LIEU, VUI LONG THU LAI.");
        }
    }
    
    //Hàm in hóa đơn thanh toán
    public void in_hd(){
        try{
            booking[booking.length - 1].inHoaDon();
            
            //Tăng số lượng phần tử khi thêm mới 1 hóa đơn
            if (booking[booking.length - 1]!=null)
                booking = Arrays.copyOf(booking, booking.length + 1);
        } catch (NullPointerException y){
            System.out.println("\nKHACH HANG CHUA DAT PHONG, KHONG THE IN HOA DON.");
        }
    }
    
    public void in_dshd(){
        try{
            System.out.println("Xuat danh sach hoa don cua cac khach hang truoc do:");
            for(ThuePhong ob:booking){
                ob.in_DSHoaDon();
            }
        } catch (NullPointerException y){
            System.out.println("");
        }
    }
    
    //Hàm main
    public static void main(String[] args) {
        App app = new App();
        int choice = 0;
        do{
            try{
                app.menu();
                choice = Integer.parseInt(sc2.nextLine());
                System.out.println("");
                switch (choice){
                    case 1: app.Read_From_File(); break;

                    case 2: app.Write_To_File(); break;

                    case 3: app.xuat_all(); break;

                    case 4: app.chen_ptu(); break;

                    case 5: app.xoa_ptu(); break;

                    case 6: app.sua_phong(); break;

                    case 7: app.tim_phong(); break;

                    case 8: app.dat_phong(); break;

                    case 9: app.in_hd(); break;
                    
                    case 10: app.in_dshd(); break;

                    case 11: System.out.println("Terminating..."); break;
                    
                    default: System.out.println("Gia tri nhap vao ko ton tai trong danh sach chuc nang."); break;
                }
            } catch (NumberFormatException u){
                System.out.println("\nLOI: Gia tri phai la 1 so.");
            }
        } while (choice != 11);
    }
}
