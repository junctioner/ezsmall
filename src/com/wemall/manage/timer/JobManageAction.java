package com.wemall.manage.timer;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 定时任务job组件
 */
@Component("shop_job")
@Transactional
public class JobManageAction {
//    @Autowired
//    private IGoodsService goodsService;
//    @Autowired
//    private IStoreService storeService;
//    @Autowired
//    private IUserService userService;
//    @Autowired
//    private ISysConfigService configService;
//    @Autowired
//    private IStoreCartService storeCartService;
//    @Autowired
//    private IGoodsCartService goodsCartService;

    public void execute(){
//        Map params = new HashMap();
//        params.put("ztc_status", Integer.valueOf(2));
//        List<Goods> goods_audit_list = this.goodsService.query(
//                                           "select obj from Goods obj where obj.ztc_status=:ztc_status",
//                                           params, -1, -1);
//        for (Goods goods : goods_audit_list){
//            if (goods.getZtc_begin_time().before(new Date())){
//                goods.setZtc_dredge_price(goods.getZtc_price());
//                goods.setZtc_status(3);
//                this.goodsService.update(goods);
//            }
//        }
//        params.clear();
//        params.put("ztc_status", Integer.valueOf(3));
//        goods_audit_list = this.goodsService.query(
//                               "select obj from Goods obj where obj.ztc_status=:ztc_status",
//                               params, -1, -1);
//  
//
//        List<Store> stores = this.storeService.query(
//                                 "select obj from Store obj where obj.validity is not null",
//                                 null, -1, -1);
//    
//
//        params.clear();
//        params.put("goods_status", Integer.valueOf(0));
//        List<Goods> goods_list = this.goodsService
//                                 .query(
//                                     "select obj from Goods obj where obj.goods_status=:goods_status",
//                                     params, -1, -1);
//        List goods_vo_list = new ArrayList();
//        for (Goods goods : goods_list){
//            LuceneVo vo = new LuceneVo();
//            vo.setVo_id(goods.getId());
//            vo.setVo_title(goods.getName());
//            vo.setVo_content(goods.getContent());
//            vo.setVo_type("goods");
//            vo.setVo_store_price(CommUtil.null2Double(goods.getPrice()));
//            vo.setVo_add_time(goods.getAddTime().getTime());
//            vo.setVo_goods_salenum(goods.getGoods_salenum());
//            goods_vo_list.add(vo);
//        }
//        String goods_lucene_path = (new StringBuilder(String.valueOf(System.getProperty("wemall.root")))).append(File.separator).append("lucene").append(File.separator).append("goods").toString();
//        File file = new File(goods_lucene_path);
//        if (!file.exists()){
//            CommUtil.createFolder(goods_lucene_path);
//        }
//        LuceneThread goods_thread = new LuceneThread(goods_lucene_path,
//                goods_vo_list);
//        goods_thread.run();
//        SysConfig config = this.configService.getSysConfig();
//        config.setLucene_update(new Date());
//        this.configService.update(config);
//
//        params.clear();
//        Calendar cal = Calendar.getInstance();
//        cal.add(6, -1);
//        params.put("bg_time", CommUtil.formatDate(CommUtil.formatShortDate(cal
//                   .getTime())));
//        List<BargainGoods> bgs = this.bargainGoodsService.query(
//                                     "select obj from BargainGoods obj where obj.bg_time=:bg_time",
//                                     params, -1, -1);
//        for (BargainGoods bg : bgs){
//            bg.setBg_status(-2);
//            this.bargainGoodsService.update(bg);
//            Goods goods = bg.getBg_goods();
//            goods.setBargain_status(0);
//            goods.setGoods_current_price(goods.getStore_price());
//            this.goodsService.update(goods);
//        }
//
//        params.clear();
//        params.put("bg_time", CommUtil.formatDate(
//                       CommUtil.formatShortDate(new Date())));
//        params.put("bg_status", Integer.valueOf(1));
//        bgs = this.bargainGoodsService
//              .query(
//                  "select obj from BargainGoods obj where obj.bg_time=:bg_time and obj.bg_status=:bg_status",
//                  params, -1, -1);
//        Goods goods;
//        for (BargainGoods bg : bgs){
//            goods = bg.getBg_goods();
//            goods.setBargain_status(2);
//            goods.setGoods_current_price(bg.getBg_price());
//            this.goodsService.update(goods);
//        }
//
//        params.clear();
//        cal = Calendar.getInstance();
//        cal.add(6, -1);
//        params.put("addTime", cal.getTime());
//        params.put("sc_status", Integer.valueOf(0));
//        List<StoreCart> cart_list = this.storeCartService
//                                    .query(
//                                        "select obj from StoreCart obj where obj.user.id is null and obj.addTime<=:addTime and obj.sc_status=:sc_status",
//                                        params, -1, -1);
//        for (StoreCart cart : cart_list){
//            for (GoodsCart gc : cart.getGcs()){
//                gc.getGsps().clear();
//                this.goodsCartService.delete(gc.getId());
//            }
//            this.storeCartService.delete(cart.getId());
//        }
//
//        params.clear();
//        cal = Calendar.getInstance();
//        cal.add(6, -7);
//        params.put("addTime", cal.getTime());
//        params.put("sc_status", Integer.valueOf(0));
//        cart_list = this.storeCartService
//                    .query(
//                        "select obj from StoreCart obj where obj.user.id is not null and obj.addTime<=:addTime and obj.sc_status=:sc_status",
//                        params, -1, -1);
//        for (StoreCart cart : cart_list){
//            for (GoodsCart gc : cart.getGcs()){
//                gc.getGsps().clear();
//                this.goodsCartService.delete(gc.getId());
//            }
//            this.storeCartService.delete(cart.getId());
//        }
    }
}




