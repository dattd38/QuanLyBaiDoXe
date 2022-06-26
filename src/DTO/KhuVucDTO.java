package DTO;

public class KhuVucDTO {
    
	private String tenKhuVuc;
	private String trangThaiKhuVuc;
        public KhuVucDTO() {
		super();
	}
	public KhuVucDTO( String tenKhuVuc, String trangThaiKhuVuc) {
		super();
		
		this.tenKhuVuc = tenKhuVuc;
		this.trangThaiKhuVuc = trangThaiKhuVuc;
	}

	public String getTenKhuVuc() {
		return tenKhuVuc;
	}
	public void setTenKhuVuc(String tenKhuVuc) {
		this.tenKhuVuc = tenKhuVuc;
	}
	public String getTrangThaiKhuVuc() {
		return trangThaiKhuVuc;
	}
	public void setTrangThaiKhuVuc(String trangThaiKhuVuc) {
		this.trangThaiKhuVuc = trangThaiKhuVuc;
	}
	
	

}
