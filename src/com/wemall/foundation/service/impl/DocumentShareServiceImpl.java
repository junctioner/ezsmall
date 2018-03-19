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
import com.wemall.foundation.domain.ArticleClass;
import com.wemall.foundation.domain.DocumentShare;
import com.wemall.foundation.service.IDocumentShareService;

@Service
@Transactional
public class DocumentShareServiceImpl implements IDocumentShareService {
    @Resource(name = "documentShareDao")
    private IGenericDAO<DocumentShare> documentShareDao;

    public boolean save(DocumentShare documentShare){
        try {
            this.documentShareDao.save(documentShare);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public DocumentShare getObjById(Long id){
    	DocumentShare documentShare = (DocumentShare)this.documentShareDao.get(id);
        if (documentShare != null){
            return documentShare;
        }

        return null;
    }

    public boolean delete(Long id){
        try {
            this.documentShareDao.remove(id);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public boolean batchDelete(List<Serializable> documentShare){
        for (Serializable id : documentShare){
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
        GenericPageList pList = new GenericPageList(DocumentShare.class, query,
                params, this.documentShareDao);
        if (properties != null){
            PageObject pageObj = properties.getPageObj();
            if (pageObj != null)
                pList.doList(pageObj.getCurrentPage() == null ? 0 : pageObj
                             .getCurrentPage().intValue(), pageObj.getPageSize() == null ? 0 :
                             pageObj.getPageSize().intValue());
        }else{
            pList.doList(0, -1);
        }

        return pList;
    }

    public boolean update(DocumentShare documentShare){
        try {
            this.documentShareDao.update(documentShare);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public List<DocumentShare> query(String query, Map params, int begin, int max){
        return this.documentShareDao.query(query, params, begin, max);
    }
}
