package com.unsada.pbo.masterData;

public class Kasir {
	private String namaKasir;
	private String usernameKasir;
	private String passwordKasir;
	private String noHp;
	private boolean isLogin;
	
	public Kasir(String namaKasir, String usernameKasir, String passwordKasir, String noHp) {
		this.namaKasir = namaKasir;
		this.usernameKasir = usernameKasir;
		this.passwordKasir = passwordKasir;
		this.noHp = noHp;
	}
	
	
	
	public String getUsernameKasir() {
		return usernameKasir;
	}

	public void setUsernameKasir(String usernameKasir) {
		this.usernameKasir = usernameKasir;
	}

	public String getNamaKasir() {
		return namaKasir;
	}

	public void setNamaKasir(String namaKasir) {
		this.namaKasir = namaKasir;
	}

	public String getPasswordKasir() {
		return passwordKasir;
	}

	public void setPasswordKasir(String passwordKasir) {
		this.passwordKasir = passwordKasir;
	}

	public String getNoHp() {
		return noHp;
	}

	public void setNoHp(String noHp) {
		this.noHp = noHp;
	}
	
	public boolean setIsLogin(boolean isLogin) {
		return this.isLogin = isLogin;
	}
	
	public boolean isLogin() {
		return isLogin;
	}
}
