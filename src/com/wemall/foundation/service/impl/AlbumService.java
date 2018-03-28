package com.wemall.foundation.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sun.org.apache.xml.internal.dtm.ref.DTMDefaultBaseIterators.InternalAxisIteratorBase;
import com.wemall.core.query.support.IPageList;
import com.wemall.core.query.support.IQueryObject;
import com.wemall.foundation.domain.Album;
import com.wemall.foundation.service.IAlbumService;

@Service
@Transactional
public class AlbumService implements IAlbumService{

	@Override
	public boolean save(Album album) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Long paramLong) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Album paramAlbum) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IPageList list(IQueryObject paramIQueryObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Album getObjById(Long paramLong) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Album getObjByProperty(String paramString1, String paramString2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Album> query(String paramString, Map paramMap, int paramInt1, int paramInt2) {
		// TODO Auto-generated method stub
		return null;
	}

}
