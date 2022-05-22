package Bills;

import Data.Constants;

public class CreditCard implements Constants {
	private String soThe, loaiThe, ngayHetHan, tenChuThe;
	private int month, year;

	public CreditCard() {
	}

	public CreditCard(String soThe, String loaiThe, String ngayHetHan, String tenChuThe) {
		soThe = soThe.trim();
		while (soThe.contains(" "))
			soThe = soThe.replace("  ", "");
		this.soThe = soThe;
		this.soThe = soThe;

		loaiThe = justify_String(loaiThe);
		if (loaiThe.equalsIgnoreCase("atm") || loaiThe.equalsIgnoreCase("visa"))
			this.loaiThe = loaiThe;
		else
			this.loaiThe = "ATM";

		String str[] = ngayHetHan.split("/");
		this.month = Integer.parseInt(str[0]);
		this.year = Integer.parseInt(str[1]);
		this.tenChuThe = tenChuThe;
	}

	public String justify_String(String a) {
		a = a.trim();
		while (a.contains("  "))
			a = a.replace("  ", " ");
		return a;
	}

	public void setSoThe() {
		System.out.println("Nhap so the:");
		while (true) {
			soThe = sc.nextLine();
			soThe = soThe.trim();
			while (soThe.contains(" "))
				soThe = soThe.replace("  ", "");
			if (soThe.length() < 16 || soThe.length() > 16)
				System.out.println("So the ko hop le, vui long thu lai:");
			else {
				this.soThe = soThe;
				break;
			}
		}
	}

	public void setLoaiThe() {
		System.out.println("Nhap loai the:");
		while (true) {
			loaiThe = sc.nextLine();
			loaiThe = justify_String(loaiThe);
			if (loaiThe.equalsIgnoreCase("atm") || loaiThe.equalsIgnoreCase("visa")) {
				this.loaiThe = loaiThe;
				break;
			} else {
				System.out.println("Loai the ko hop le, moi nhap lai:");
			}
		}
	}

	public void setNgayHetHan() {
		System.out.println("Nhap ngay het han (mm/yyyy):");
		ngayHetHan = sc.nextLine();
		String str[] = ngayHetHan.split("/");
		this.month = Integer.parseInt(str[0]);
		this.year = Integer.parseInt(str[1]);
	}

	public void setTenChuThe() {
		System.out.println("Nhap ten chu the:");
		tenChuThe = sc.nextLine();
		tenChuThe = justify_String(tenChuThe);
		this.tenChuThe = tenChuThe;
	}

	public String getSoThe() {
		return soThe;
	}

	public String getLoaiThe() {
		return loaiThe;
	}

	public String getTenChuThe() {
		return tenChuThe;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public boolean layQuyenTruyCap() {
		System.out.println("He thong se lay quyen truy cap vao the cua ban, ban dong y chu? (yes or no)");
		String input = sc.nextLine();
		input = input.toLowerCase();
		if (input.startsWith("y"))
			return true;
		else
			return false;
	}

	public double giaoDich(double soTien) {
		double soTienKhachTra;
		System.out.println("So tien giao dich la: " + soTien);
		System.out.println("Dong y giao dich? (yes or no)");
		String input = sc.nextLine();
		input = input.toLowerCase();
		if (input.startsWith("y")) {
			soTienKhachTra = soTien;
			return soTienKhachTra;
		} else
			return 0;
	}

	public void nhap() {
		try {
			setSoThe();
			setTenChuThe();
			setLoaiThe();
			setNgayHetHan();
		} catch (NumberFormatException u) {
			System.out.println("\nLOI: Gia tri phai la 1 so.");
		}
	}
}
