package com.wemall.foundation.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wemall.core.dao.IGenericDAO;
import com.wemall.core.query.GenericPageList;
import com.wemall.core.query.PageObject;
import com.wemall.core.query.support.IPageList;
import com.wemall.core.query.support.IQueryObject;
import com.wemall.foundation.domain.Comment;
import com.wemall.foundation.service.ICommentService;


@Service
@Transactional
public class CommentServiceImpl implements ICommentService {
	@Resource(name = "commentDao")
	private IGenericDAO<Comment> commentDao;



	 public boolean save(Comment comment){
	        try {
	            this.commentDao.save(comment);
	            return true;
	        } catch (Exception e){
	            e.printStackTrace();
	        }

	        return false;
	    }

	    public Comment getObjById(Long id){
	        Comment comment = (Comment)this.commentDao.get(id);
	        if (comment != null){
	            return comment;
	        }

	        return null;
	    }

	    public boolean delete(Long id){
	        try {
	            this.commentDao.remove(id);
	            return true;
	        } catch (Exception e){
	            e.printStackTrace();
	        }

	        return false;
	    }

	    public boolean batchDelete(List<Serializable> commentIds){
	        for (Serializable id : commentIds){
	            delete((Long)id);
	        }

	        return true;
	    }

	 
	    public IPageList list(IQueryObject properties){
	        if (properties == null){
	            return null;
	        }
	        String query = properties.getQuery();
	        Map params = properties.getParameters();
	        GenericPageList pList = new GenericPageList(Comment.class, query,
	                params, this.commentDao);
	        if (properties != null){
	            PageObject pageObj = properties.getPageObj();
	            if (pageObj != null){
	                pList.doList(pageObj.getCurrentPage() == null ? 0 : pageObj
	                        .getCurrentPage().intValue(), pageObj.getPageSize() == null ? 0 :
	                        pageObj.getPageSize().intValue());
	            }
	        }else{
	            pList.doList(0, -1);
	        }

	        return pList;
	    }

	    public boolean update(Comment comment){
	        try {
	            this.commentDao.update(comment);
	            return true;
	        } catch (Exception e){
	            e.printStackTrace();
	        }

	        return false;
	    }

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Comment> query(String paramString, Map paramMap, int paramInt1, int paramInt2) {
		return commentDao.query(paramString, paramMap, paramInt1, paramInt2);
	}

}
