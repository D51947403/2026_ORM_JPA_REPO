package mainaha.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "tm_images")
public class ImageEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "img_id", unique = true, nullable = false, columnDefinition  = "INT")
    private Integer imageId;
     
    @Column(name = "img_name", unique = false, nullable = false, length = 100, columnDefinition  = "VARCHAR(100)")
    private String imageName;
    
     // imageData field as byte[].
    @Column(name = "img_data", unique = false, nullable = false, length = 100000 )
    private byte[] imageData;
    
    @Lob
    @Column(name = "photo_data", unique = false, nullable = false, columnDefinition  = "LONGBLOB")
    private byte[] photoData;
    
	public Integer getImageId() {
		return imageId;
	}
	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public byte[] getImageData() {
		return imageData;
	}
	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}
	public byte[] getPhotoData() {
		return photoData;
	}
	public void setPhotoData(byte[] photoData) {
		this.photoData = photoData;
	}
    
	
    
}
