package com.banking.customer.file;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileUploadResponse {

	
	
	 private String fileId;
	    private String fileName;
	   

		private String fileType;
	    private String message;
	    private boolean uploadStatus;
	    private String downloadUri;

	   
}
