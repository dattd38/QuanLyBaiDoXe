package DTO;

public class VeDTO {
	private String maVe;
	private String tinhTrangVe;
	
        public VeDTO() {
		super();
	}
	public VeDTO(String maVe, String tinhTrangVe) {
		super();
		this.maVe = maVe;
		this.tinhTrangVe = tinhTrangVe;
	}

	public String getMaVe() {
		return maVe;
	}

	public void setMaVe(String maVe) {
		this.maVe = maVe;
	}

	public String getTinhTrangVe() {
		return tinhTrangVe;
	}

	public void setTinhTrangVe(String tinhTrangVe) {
		this.tinhTrangVe = tinhTrangVe;
	}
	
	
}
