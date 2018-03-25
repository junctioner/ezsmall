package com.wemall.foundation.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.wemall.core.domain.IdEntity;
/**
 * 鍦板尯
 * @author
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_area")
public class Area extends IdEntity implements Serializable{
    /**
     * UID
     */
    private static final long serialVersionUID = -3166365941305570434L;
    //鍦板尯鍚岖О
    private String areaName;

    //鍦板尯瀛愮被
    @OneToMany(mappedBy = "parent", cascade = { javax.persistence.CascadeType.REMOVE })
    private List<Area> childs = new ArrayList<Area>();
    //鍦板尯鐖剁被
    @ManyToOne(fetch = FetchType.LAZY)
    private Area parent;
    //鍦板尯搴忓垪
    private int sequence;
    //鍦板尯绛夌骇
    private int level;

    //鏄惁甯哥敤鍦板尯
    @Column(columnDefinition = "bit default false")
    private boolean common;

    public boolean isCommon(){
        return this.common;
    }

    public void setCommon(boolean common){
        this.common = common;
    }

    public List<Area> getChilds(){
        return this.childs;
    }

    public void setChilds(List<Area> childs){
        this.childs = childs;
    }

    public Area getParent(){
        return this.parent;
    }

    public void setParent(Area parent){
        this.parent = parent;
    }

    public String getAreaName(){
        return this.areaName;
    }

    public void setAreaName(String areaName){
        this.areaName = areaName;
    }

    public int getLevel(){
        return this.level;
    }

    public void setLevel(int level){
        this.level = level;
    }

    public int getSequence(){
        return this.sequence;
    }

    public void setSequence(int sequence){
        this.sequence = sequence;
    }
}
