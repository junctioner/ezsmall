package com.wemall.foundation.service;

import java.util.List;
import java.util.Map;

import com.wemall.core.query.support.IPageList;
import com.wemall.core.query.support.IQueryObject;
import com.wemall.foundation.domain.Album;

public interface IAlbumService {
	 public abstract boolean save(Album album);

	    public abstract boolean delete(Long paramLong);

	    public abstract boolean update(Album paramAlbum);

	    public abstract IPageList list(IQueryObject paramIQueryObject);

	    public abstract Album getObjById(Long paramLong);

	    public abstract Album getObjByProperty(String paramString1, String paramString2);

	    public abstract List<Album> query(String paramString, Map paramMap, int paramInt1, int paramInt2);

}
