package Customers;

import Data.Constants;

public abstract class ThuePhong implements Constants {
	int soNguoi, soNgayThue;

	public ThuePhong() {
	}

	public ThuePhong(int soNguoi, int soNgayThue) {
		soNguoi = Math.abs(soNguoi);
		this.soNguoi = soNguoi;
		soNgayThue = Math.abs(soNgayThue);
		this.soNgayThue = soNgayThue;
	}

	public void setSoNguoi() {
		System.out.println("Nhap so nguoi thue phong:");
		while (true) {
			soNguoi = Integer.parseInt(sc.nextLine());
			if (soNguoi <= 0)
				System.out.println("So nguoi ko hop le, moi nhap lai:");
			else {
				this.soNguoi = soNguoi;
				break;
			}
		}
	}

	public void setSoNgayThue() {
		System.out.println("Nhap so ngay muon thue phong:");
		while (true) {
			soNgayThue = Integer.parseInt(sc.nextLine());
			if (soNgayThue <= 0)
				System.out.println("So ngay thue phong ko hop le, moi nhap lai:");
			else {
				this.soNgayThue = soNgayThue;
				break;
			}
		}
	}

	public int getSoNguoi() {
		return soNguoi;
	}

	public int getSoNgayThue() {
		return soNgayThue;
	}

	public abstract void nhap(int maPhg, double soTienThuePhong, double soTienKhachTra, int maHoaDon);

	public abstract void xuat();

	public abstract void inHoaDon();

	public abstract void in_DSHoaDon();
}
