package com.coderby.myapp.upload.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderby.myapp.upload.dao.IUploadFileRepository;
import com.coderby.myapp.upload.model.UploadFileVO;

@Service
public class UploadFileService implements IUploadFileService {
	@Autowired
	IUploadFileRepository uploadFileRepository;
	
	@Override
	public void uploadFile(UploadFileVO file) {
		// TODO Auto-generated method stub
		file.setFileId(uploadFileRepository.getMaxFileId()+1);
		uploadFileRepository.uploadFile(file);
	}

	@Override
	public List<UploadFileVO> getFileList(String dir) {
		// TODO Auto-generated method stub
		return uploadFileRepository.getFileList(dir);
	}

	@Override
	public List<UploadFileVO> getAllFileList() {
		// TODO Auto-generated method stub
		return uploadFileRepository.getAllFileList();
	}

	@Override
	public List<UploadFileVO> getImageList(String dir) {
		// TODO Auto-generated method stub
		return uploadFileRepository.getImageList(dir);
	}

	@Override
	public UploadFileVO getFile(int fileId) {
		// TODO Auto-generated method stub
		return uploadFileRepository.getFile(fileId);
	}

	@Override
	public String getDirectoryName(int fileId) {
		// TODO Auto-generated method stub
		return uploadFileRepository.getDirectoryName(fileId);
	}

	@Override
	public void updateDirectory(int[] fileIds, String directoryName) {
		// TODO Auto-generated method stub
		for(int fileId:fileIds){
			HashMap<String , Object> map= new HashMap<String, Object>();
			map.put("fileId", fileId);
			map.put("directoryName", directoryName);
			uploadFileRepository.updateDirectory(map);
		}
	}

	@Override
	public void deleteFile(int fileId) {
		// TODO Auto-generated method stub
		uploadFileRepository.deleteFile(fileId);
	}

	@Override
	public void updateFile(UploadFileVO file) {
		// TODO Auto-generated method stub
		uploadFileRepository.updateFile(file);
	}

}
