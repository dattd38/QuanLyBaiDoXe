package DTO;

public class ViTriDTO {
	
	private String tenViTri;
        private String trangThaiViTri;
	private String tenKhuVuc;
	  public ViTriDTO() {
		super();
	}
	public ViTriDTO( String tenViTri,String trangThaiViTri , String tenKhuVuc) {
		super();
		
		this.tenViTri = tenViTri;
                this.trangThaiViTri = trangThaiViTri;
		this.tenKhuVuc = tenKhuVuc;
		
	}
	
	public String getTenViTri() {
		return tenViTri;
	}
	public void setTenViTri(String tenViTri) {
		this.tenViTri = tenViTri;
	}
	public String getTenKhuVuc() {
		return tenKhuVuc;
	}
	public void setTenKhuVuc(String tenKhuVuc) {
		this.tenKhuVuc = tenKhuVuc;
	}
	public String getTrangThaiViTri() {
		return trangThaiViTri;
	}
	public void setTrangThaiViTri(String trangThaiViTri) {
		this.trangThaiViTri = trangThaiViTri;
	}
	

}
