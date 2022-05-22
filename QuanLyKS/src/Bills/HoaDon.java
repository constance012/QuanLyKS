package Bills;

import Data.Constants;

public abstract class HoaDon implements Constants {
	private int maHoaDon;

	public HoaDon() {
	}

	public HoaDon(int maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public void setMaHoaDon() {
		System.out.println("Nhap ma so hoa don:");
		while (true) {
			maHoaDon = Integer.parseInt(sc.nextLine());
			if (maHoaDon <= 0)
				System.out.println("Ma hoa don khong hop le, moi nhap lai:");
			else {
				this.maHoaDon = maHoaDon;
				break;
			}
		}
	}

	public int getMaHoaDon() {
		return maHoaDon;
	}

	public abstract double tinhTongTien();

	public abstract void inHoaDon();

	public abstract void phThucThanhToan();

	public abstract void set_NVLT();
}
