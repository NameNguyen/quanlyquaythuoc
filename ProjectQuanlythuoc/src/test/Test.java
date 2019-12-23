package test;

import java.util.List;
import java.util.Scanner;

import dao.Donvi.Donvi_DAO;
import dao.Nuoc.Nuoc_DAO;
import dao.Thuoc.ThemThuoc_DAO;

public class Test {
	private static ThemThuoc_DAO themthuoc_DAO;
	private static Nuoc_DAO nuoc_DAo;
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String str = sc.nextLine();
//		System.out.println("Nhập mã: "+ str);
//		if (checkma(str) == true) {
//			System.out.println("Đúng");
//		} else {
//			System.out.println("Sai");
//		}
		nuoc_DAo = new Nuoc_DAO();
		List<String> dsma = nuoc_DAo.checktrungma();
		System.out.println(dsma);
		
	}
	private static boolean checkma(String str) {
		themthuoc_DAO = new ThemThuoc_DAO();
		List<String> dsma = themthuoc_DAO.checktrungma();
		boolean flag = true;
		while (flag) {
//			ma = randomMa();
			for(String s : dsma){
				if (s.equalsIgnoreCase(str)) {
					return false;
				}
				else {
					return true;
				}
			}
		}
		return false;
	}
}
