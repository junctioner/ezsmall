package com.wemall.core.tools;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * @author John澧炲姞
 * 鍒涘缓镞ユ湡 2015-10-16
 */
public class OperateImage {
    public OperateImage(){
        super();
    }

    /**
     * 瀵瑰浘鐗囱鍓紝骞舵妸瑁佸壀鏂板浘鐗囦缭瀛?
     * @param srcPath 璇诲彇婧愬浘鐗囱矾寰?
     * @param toPath	鍐椤叆锲剧墖璺缎
     * @param x 鍓垏璧峰镣箈鍧愭爣
     * @param y 鍓垏璧峰镣箉鍧愭爣
     * @param width 鍓垏瀹藉害
     * @param height	 鍓垏楂桦害
     * @param readImageFormat  璇诲彇锲剧墖镙煎纺
     * @param writeImageFormat 鍐椤叆锲剧墖镙煎纺
     * @throws IOException
     */
    public void cropImage(String srcPath, String toPath,
                          int x, int y, int width, int height,
                          String readImageFormat, String writeImageFormat) throws IOException {
        FileInputStream fis = null ;
        ImageInputStream iis = null ;
        try {
            //璇诲彇锲剧墖鏂囦欢
            fis = new FileInputStream(srcPath);
            Iterator it = ImageIO.getImageReadersByFormatName(readImageFormat);
            ImageReader reader = (ImageReader) it.next();
            //銮峰彇锲剧墖娴?
            iis = ImageIO.createImageInputStream(fis);
            reader.setInput(iis, true) ;
            ImageReadParam param = reader.getDefaultReadParam();
            //瀹氢箟涓€涓烦褰?
            Rectangle rect = new Rectangle(x, y, width, height);
            //鎻愪緵涓€涓?BufferedImage锛屽皢鍏剁敤浣滆В镰佸儚绱犳暟鎹殑鐩爣銆?
            param.setSourceRegion(rect);
            BufferedImage bi = reader.read(0, param);
            //淇濆瓨鏂板浘鐗?
            ImageIO.write(bi, writeImageFormat, new File(toPath));
        } finally {
            if(fis != null)
                fis.close();
            if(iis != null)
                iis.close();
        }
    }

    /**
     * 鎸夊€岖巼缂╁皬锲剧墖
     * @param srcImagePath 璇诲彇锲剧墖璺缎
     * @param toImagePath 鍐椤叆锲剧墖璺缎
     * @param widthRatio	瀹藉害缂╁皬姣斾緥
     * @param heightRatio	 楂桦害缂╁皬姣斾緥
     * @throws IOException
     */
    public void reduceImageByRatio(String srcImagePath, String toImagePath, int widthRatio, int heightRatio) throws IOException {
        FileOutputStream out = null;
        try {
            //璇诲叆鏂囦欢
            File file = new File(srcImagePath);
            // 鏋勯€营mage瀵硅薄
            BufferedImage src = javax.imageio.ImageIO.read(file);
            int width = src.getWidth();
            int height = src.getHeight();
            // 缂╁皬杈归昵
            BufferedImage tag = new BufferedImage(width / widthRatio, height / heightRatio, BufferedImage.TYPE_INT_RGB);
            // 缁桦埗 缂╁皬  鍚庣殑锲剧墖
            tag.getGraphics().drawImage(src, 0, 0, width / widthRatio, height / heightRatio, null);
            out = new FileOutputStream(toImagePath);
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            encoder.encode(tag);
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            if(out != null){
                out.close();
            }
        }
    }

    /**
     * 闀块佩绛夋瘮渚嬬缉灏忓浘鐗?
     * @param srcImagePath 璇诲彇锲剧墖璺缎
     * @param toImagePath 鍐椤叆锲剧墖璺缎
     * @param ratio 缂╁皬姣斾緥
     * @throws IOException
     */
    public void reduceImageEqualProportion(String srcImagePath, String toImagePath, int ratio) throws IOException {
        FileOutputStream out = null;
        try {
            //璇诲叆鏂囦欢
            File file = new File(srcImagePath);
            // 鏋勯€营mage瀵硅薄
            BufferedImage src = javax.imageio.ImageIO.read(file);
            int width = src.getWidth();
            int height = src.getHeight();
            // 缂╁皬杈归昵
            BufferedImage tag = new BufferedImage(width / ratio, height / ratio, BufferedImage.TYPE_INT_RGB);
            // 缁桦埗 缂╁皬  鍚庣殑锲剧墖
            tag.getGraphics().drawImage(src, 0, 0, width / ratio, height / ratio, null);
            out = new FileOutputStream(toImagePath);
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            encoder.encode(tag);
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            if(out != null){
                out.close();
            }
        }
    }

    /**
     * 鎸夊€岖巼鏀惧ぇ锲剧墖
     * @param srcImagePath 璇诲彇锲惧舰璺缎
     * @param toImagePath 鍐椤叆鍏ヨ璺缎
     * @param widthRatio	瀹藉害鏀惧ぇ姣斾緥
     * @param heightRatio 楂桦害鏀惧ぇ姣斾緥
     * @throws IOException
     */
    public void enlargementImageByRatio(String srcImagePath, String toImagePath, int widthRatio, int heightRatio) throws IOException {
        FileOutputStream out = null;
        try {
            //璇诲叆鏂囦欢
            File file = new File(srcImagePath);
            // 鏋勯€营mage瀵硅薄
            BufferedImage src = javax.imageio.ImageIO.read(file);
            int width = src.getWidth();
            int height = src.getHeight();
            // 鏀惧ぇ杈归昵
            BufferedImage tag = new BufferedImage(width * widthRatio, height * heightRatio, BufferedImage.TYPE_INT_RGB);
            //缁桦埗鏀惧ぇ鍚庣殑锲剧墖
            tag.getGraphics().drawImage(src, 0, 0, width * widthRatio, height * heightRatio, null);
            out = new FileOutputStream(toImagePath);
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            encoder.encode(tag);
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            if(out != null){
                out.close();
            }
        }
    }


    /**
     * 闀块佩绛夋瘮渚嬫斁澶у浘鐗?
     * @param srcImagePath 璇诲彇锲惧舰璺缎
     * @param toImagePath 鍐椤叆鍏ヨ璺缎
     * @param ratio	鏀惧ぇ姣斾緥
     * @throws IOException
     */
    public void enlargementImageEqualProportion(String srcImagePath, String toImagePath, int ratio) throws IOException {
        FileOutputStream out = null;
        try {
            //璇诲叆鏂囦欢
            File file = new File(srcImagePath);
            // 鏋勯€营mage瀵硅薄
            BufferedImage src = javax.imageio.ImageIO.read(file);
            int width = src.getWidth();
            int height = src.getHeight();
            // 鏀惧ぇ杈归昵
            BufferedImage tag = new BufferedImage(width * ratio, height * ratio, BufferedImage.TYPE_INT_RGB);
            //缁桦埗鏀惧ぇ鍚庣殑锲剧墖
            tag.getGraphics().drawImage(src, 0, 0, width * ratio, height * ratio, null);
            out = new FileOutputStream(toImagePath);
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            encoder.encode(tag);
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            if(out != null){
                out.close();
            }
        }
    }

    /**
     * 閲岖疆锲惧舰镄勮竟闀垮ぇ灏?
     * @param srcImagePath
     * @param toImagePath
     * @param width
     * @param height
     * @throws IOException
     */
    public void resizeImage(String srcImagePath, String toImagePath, int width, int height) throws IOException {
        FileOutputStream out = null;
        try {
            //璇诲叆鏂囦欢
            File file = new File(srcImagePath);
            // 鏋勯€营mage瀵硅薄
            BufferedImage src = javax.imageio.ImageIO.read(file);
            // 鏀惧ぇ杈归昵
            BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            //缁桦埗鏀惧ぇ鍚庣殑锲剧墖
            tag.getGraphics().drawImage(src, 0, 0, width, height, null);
            out = new FileOutputStream(toImagePath);
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            encoder.encode(tag);
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            if(out != null){
                out.close();
            }
        }
    }

    /**
     * 妯悜鎷兼帴锲剧墖锛堜袱寮狅级
     * @param firstSrcImagePath 绗竴寮犲浘鐗囩殑璺缎
     * @param secondSrcImagePath	绗簩寮犲浘鐗囩殑璺缎
     * @param imageFormat	鎷兼帴鐢熸垚锲剧墖镄勬牸寮?
     * @param toPath	鎷兼帴鐢熸垚锲剧墖镄勮矾寰?
     */
    public void joinImagesHorizontal(String firstSrcImagePath, String secondSrcImagePath, String imageFormat, String toPath){
        try {
            //璇诲彇绗竴寮犲浘鐗?
            File  fileOne  =  new  File(firstSrcImagePath);
            BufferedImage  imageOne = ImageIO.read(fileOne);
            int  width  =  imageOne.getWidth();//锲剧墖瀹藉害
            int  height  =  imageOne.getHeight();//锲剧墖楂桦害
            //浠庡浘鐗囦腑璇诲彇RGB
            int[]  imageArrayOne  =  new  int[width * height];
            imageArrayOne  =  imageOne.getRGB(0, 0, width, height, imageArrayOne, 0, width);

            //瀵圭浜屽紶锲剧墖锅氱浉鍚岀殑澶勭悊
            File  fileTwo  =  new  File(secondSrcImagePath);
            BufferedImage  imageTwo  =  ImageIO.read(fileTwo);
            int width2 = imageTwo.getWidth();
            int height2 = imageTwo.getHeight();
            int[]   ImageArrayTwo  =  new  int[width2 * height2];
            ImageArrayTwo  =  imageTwo.getRGB(0, 0, width, height, ImageArrayTwo, 0, width);
            //ImageArrayTwo  =  imageTwo.getRGB(0,0,width2,height2,ImageArrayTwo,0,width2);

            //鐢熸垚鏂板浘鐗?
            //int height3 = (height>height2 || height==height2)?height:height2;
            BufferedImage  imageNew  =  new  BufferedImage(width * 2, height, BufferedImage.TYPE_INT_RGB);
            //BufferedImage  imageNew  =  new  BufferedImage(width+width2,height3,BufferedImage.TYPE_INT_RGB);
            imageNew.setRGB(0, 0, width, height, imageArrayOne, 0, width); //璁剧疆宸﹀崐閮ㄥ垎镄凴GB
            imageNew.setRGB(width, 0, width, height, ImageArrayTwo, 0, width); //璁剧疆鍙冲崐閮ㄥ垎镄凴GB
            //imageNew.setRGB(width,0,width2,height2,ImageArrayTwo,0,width2);//璁剧疆鍙冲崐閮ㄥ垎镄凴GB

            File  outFile  =  new  File(toPath);
            ImageIO.write(imageNew,  imageFormat,  outFile);//鍐椤浘鐗?
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 妯悜鎷兼帴涓€缁勶纸澶氩紶锛夊浘镀?
     * @param pics  灏呜鎷兼帴镄勫浘镀?
     * @param type 锲惧儚鍐椤叆镙煎纺
     * @param dst_pic 锲惧儚鍐椤叆璺缎
     * @return
     */
    public  boolean joinImageListHorizontal(String[] pics, String type, String dst_pic){
        try {
            int len = pics.length;
            if (len < 1){
                System.out.println("pics len < 1");
                return false;
            }
            File[] src = new File[len];
            BufferedImage[] images = new BufferedImage[len];
            int[][] imageArrays = new int[len][];
            for (int i = 0; i < len; i++){
                src[i] = new File(pics[i]);
                images[i] = ImageIO.read(src[i]);
                int width = images[i].getWidth();
                int height = images[i].getHeight();
                imageArrays[i] = new int[width * height];// 浠庡浘鐗囦腑璇诲彇RGB
                imageArrays[i] = images[i].getRGB(0, 0, width, height,  imageArrays[i], 0, width);
            }

            int dst_width = 0;
            int dst_height = images[0].getHeight();
            for (int i = 0; i < images.length; i++){
                dst_height = dst_height > images[i].getHeight() ? dst_height : images[i].getHeight();
                dst_width += images[i].getWidth();
            }
            //System.out.println(dst_width);
            //System.out.println(dst_height);
            if (dst_height < 1){
                System.out.println("dst_height < 1");
                return false;
            }
            /*
             * 鐢熸垚鏂板浘鐗?
             */
            BufferedImage ImageNew = new BufferedImage(dst_width, dst_height,  BufferedImage.TYPE_INT_RGB);
            int width_i = 0;
            for (int i = 0; i < images.length; i++){
                ImageNew.setRGB(width_i, 0, images[i].getWidth(), dst_height,  imageArrays[i], 0, images[i].getWidth());
                width_i += images[i].getWidth();
            }
            File outFile = new File(dst_pic);
            ImageIO.write(ImageNew, type, outFile);// 鍐椤浘鐗?
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * 绾靛悜鎷兼帴锲剧墖锛堜袱寮狅级
     * @param firstSrcImagePath 璇诲彇镄勭涓€寮犲浘鐗?
     * @param secondSrcImagePath	璇诲彇镄勭浜屽紶锲剧墖
     * @param imageFormat 锲剧墖鍐椤叆镙煎纺
     * @param toPath	锲剧墖鍐椤叆璺缎
     */
    public void joinImagesVertical(String firstSrcImagePath, String secondSrcImagePath, String imageFormat, String toPath){
        try {
            //璇诲彇绗竴寮犲浘鐗?
            File  fileOne  =  new  File(firstSrcImagePath);
            BufferedImage  imageOne = ImageIO.read(fileOne);
            int  width  =  imageOne.getWidth();//锲剧墖瀹藉害
            int  height  =  imageOne.getHeight();//锲剧墖楂桦害
            //浠庡浘鐗囦腑璇诲彇RGB
            int[]  imageArrayOne  =  new  int[width * height];
            imageArrayOne  =  imageOne.getRGB(0, 0, width, height, imageArrayOne, 0, width);

            //瀵圭浜屽紶锲剧墖锅氱浉鍚岀殑澶勭悊
            File  fileTwo  =  new  File(secondSrcImagePath);
            BufferedImage  imageTwo  =  ImageIO.read(fileTwo);
            int width2 = imageTwo.getWidth();
            int height2 = imageTwo.getHeight();
            int[]   ImageArrayTwo  =  new  int[width2 * height2];
            ImageArrayTwo  =  imageTwo.getRGB(0, 0, width, height, ImageArrayTwo, 0, width);
            //ImageArrayTwo  =  imageTwo.getRGB(0,0,width2,height2,ImageArrayTwo,0,width2);

            //鐢熸垚鏂板浘鐗?
            //int width3 = (width>width2 || width==width2)?width:width2;
            BufferedImage  imageNew  =  new  BufferedImage(width, height * 2, BufferedImage.TYPE_INT_RGB);
            //BufferedImage  imageNew  =  new  BufferedImage(width3,height+height2,BufferedImage.TYPE_INT_RGB);
            imageNew.setRGB(0, 0, width, height, imageArrayOne, 0, width); //璁剧疆涓婂崐閮ㄥ垎镄凴GB
            imageNew.setRGB(0, height, width, height, ImageArrayTwo, 0, width); //璁剧疆涓嫔崐閮ㄥ垎镄凴GB
            //imageNew.setRGB(0,height,width2,height2,ImageArrayTwo,0,width2);//璁剧疆涓嫔崐閮ㄥ垎镄凴GB

            File  outFile  =  new  File(toPath);
            ImageIO.write(imageNew,  imageFormat,  outFile);//鍐椤浘鐗?
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 绾靛悜鎷兼帴涓€缁勶纸澶氩紶锛夊浘镀?
     * @param pics		灏呜鎷兼帴镄勫浘镀忔暟缁?
     * @param type	鍐椤叆锲惧儚绫诲瀷
     * @param dst_pic	鍐椤叆锲惧儚璺缎
     * @return
     */
    public  boolean joinImageListVertical(String[] pics, String type, String dst_pic){
        try {
            int len = pics.length;
            if (len < 1){
                System.out.println("pics len < 1");
                return false;
            }
            File[] src = new File[len];
            BufferedImage[] images = new BufferedImage[len];
            int[][] imageArrays = new int[len][];
            for (int i = 0; i < len; i++){
                //System.out.println(i);
                src[i] = new File(pics[i]);
                images[i] = ImageIO.read(src[i]);
                int width = images[i].getWidth();
                int height = images[i].getHeight();
                imageArrays[i] = new int[width * height];// 浠庡浘鐗囦腑璇诲彇RGB
                imageArrays[i] = images[i].getRGB(0, 0, width, height,  imageArrays[i], 0, width);
            }

            int dst_height = 0;
            int dst_width = images[0].getWidth();
            for (int i = 0; i < images.length; i++){
                dst_width = dst_width > images[i].getWidth() ? dst_width : images[i].getWidth();
                dst_height += images[i].getHeight();
            }
            //System.out.println(dst_width);
            //System.out.println(dst_height);
            if (dst_height < 1){
                System.out.println("dst_height < 1");
                return false;
            }
            /*
             * 鐢熸垚鏂板浘鐗?
             */
            BufferedImage ImageNew = new BufferedImage(dst_width, dst_height,  BufferedImage.TYPE_INT_RGB);
            int height_i = 0;
            for (int i = 0; i < images.length; i++){
                ImageNew.setRGB(0, height_i, dst_width, images[i].getHeight(),  imageArrays[i], 0, dst_width);
                height_i += images[i].getHeight();
            }
            File outFile = new File(dst_pic);
            ImageIO.write(ImageNew, type, outFile);// 鍐椤浘鐗?
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * 鍚埚苟锲剧墖(鎸夋寚瀹氩垵濮媥銆乱鍧愭爣灏嗛檮锷犲浘鐗囱创鍒板簳锲句箣涓?
     * @param negativeImagePath 鑳屾櫙锲剧墖璺缎
     * @param additionImagePath	闄勫姞锲剧墖璺缎
     * @param x 闄勫姞锲剧墖镄勮捣濮嬬偣x鍧愭爣
     * @param y  闄勫姞锲剧墖镄勮捣濮嬬偣y鍧愭爣
     * @param toPath 锲剧墖鍐椤叆璺缎
     * @throws IOException
     */
    public void mergeBothImage(String negativeImagePath, String additionImagePath, int x, int y, String toPath) throws IOException {
        InputStream is = null;
        InputStream is2 = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(negativeImagePath);
            is2 = new FileInputStream(additionImagePath);
            BufferedImage image = ImageIO.read(is);
            BufferedImage image2 = ImageIO.read(is2);
            Graphics g = image.getGraphics();
            g.drawImage(image2, x, y, null);
            os = new FileOutputStream(toPath);
            JPEGImageEncoder enc = JPEGCodec.createJPEGEncoder(os);
            enc.encode(image);
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            if(os != null){
                os.close();
            }
            if(is2 != null){
                is2.close();
            }
            if(is != null){
                is.close();
            }
        }
    }

    /**
     * 灏嗕竴缁勫浘鐗囦竴娆℃€ч檮锷犲悎骞跺埌搴曞浘涓?
     * @param negativeImagePath		婧愬浘镀忥纸搴曞浘锛夎矾寰?
     * @param additionImageList	闄勫姞锲惧儚淇℃伅鍒楄〃
     * @param imageFormat	锲惧儚鍐椤叆镙煎纺
     * @param toPath	锲惧儚鍐椤叆璺缎
     * @throws IOException
     */
    public void mergeImageList(String negativeImagePath, List additionImageList, String imageFormat, String toPath) throws IOException {
        InputStream is = null;
        InputStream is2 = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(negativeImagePath);
            BufferedImage image = ImageIO.read(is);
            //Graphics g=image.getGraphics();
            Graphics2D g = image.createGraphics();;
            BufferedImage image2 = null;
            if(additionImageList != null){
                for(int i = 0; i < additionImageList.size(); i++){
                    //瑙ｆ瀽闄勫姞锲剧墖淇℃伅锛歺鍧愭爣銆?y鍧愭爣銆?additionImagePath闄勫姞锲剧墖璺缎
                    //锲剧墖淇℃伅瀛桦偍鍦ㄤ竴涓暟缁勪腑
                    String[] additionImageInfo = (String[]) additionImageList.get(i);
                    int x = Integer.parseInt(additionImageInfo[0]);
                    int y = Integer.parseInt(additionImageInfo[1]);
                    String additionImagePath = additionImageInfo[2];
                    //璇诲彇鏂囦欢杈揿叆娴侊紝骞跺悎骞跺浘鐗?
                    is2 = new FileInputStream(additionImagePath);
                    //System.out.println(x+"  :  "+y+"  :  "+additionImagePath);
                    image2 = ImageIO.read(is2);
                    g.drawImage(image2, x, y, null);
                }
            }
            os = new FileOutputStream(toPath);
            ImageIO.write(image,  imageFormat,  os);//鍐椤浘鐗?
            //JPEGImageEncoder enc=JPEGCodec.createJPEGEncoder(os);
            //enc.encode(image);
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            if(os != null){
                os.close();
            }
            if(is2 != null){
                is2.close();
            }
            if(is != null){
                is.close();
            }
        }
    }

    /**
     * 灏嗛檮锷犲浘鐗囧悎骞跺埌搴曞浘镄勫乏涓婅
     * @param negativeImagePath 搴曞浘璺缎
     * @param additionImagePath	闄勫姞锲剧墖璺缎
     * @param toPath	鍚堟垚锲剧墖鍐椤叆璺缎
     * @throws IOException
     */
    public void mergeBothImageTopleftcorner(String negativeImagePath, String additionImagePath, String toPath) throws IOException {
        InputStream is = null;
        InputStream is2 = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(negativeImagePath);
            is2 = new FileInputStream(additionImagePath);
            BufferedImage image = ImageIO.read(is);
            BufferedImage image2 = ImageIO.read(is2);
            Graphics g = image.getGraphics();
            g.drawImage(image2, 0, 0, null);
            os = new FileOutputStream(toPath);
            JPEGImageEncoder enc = JPEGCodec.createJPEGEncoder(os);
            enc.encode(image);
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            if(os != null){
                os.close();
            }
            if(is2 != null){
                is2.close();
            }
            if(is != null){
                is.close();
            }
        }
    }

    /**
     * 灏嗛檮锷犲浘鐗囧悎骞跺埌搴曞浘镄勫彸涓婅
     * @param negativeImagePath 搴曞浘璺缎
     * @param additionImagePath	闄勫姞锲剧墖璺缎
     * @param toPath	鍚堟垚锲剧墖鍐椤叆璺缎
     * @throws IOException
     */
    public void mergeBothImageToprightcorner(String negativeImagePath, String additionImagePath, String toPath) throws IOException {
        InputStream is = null;
        InputStream is2 = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(negativeImagePath);
            is2 = new FileInputStream(additionImagePath);
            BufferedImage image = ImageIO.read(is);
            BufferedImage image2 = ImageIO.read(is2);
            Graphics g = image.getGraphics();
            g.drawImage(image2, image.getWidth() - image2.getWidth(), 0, null);
            os = new FileOutputStream(toPath);
            JPEGImageEncoder enc = JPEGCodec.createJPEGEncoder(os);
            enc.encode(image);
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            if(os != null){
                os.close();
            }
            if(is2 != null){
                is2.close();
            }
            if(is != null){
                is.close();
            }
        }
    }

    /**
     * 灏嗛檮锷犲浘鐗囧悎骞跺埌搴曞浘镄勫乏涓嬭
     * @param negativeImagePath 搴曞浘璺缎
     * @param additionImagePath	闄勫姞锲剧墖璺缎
     * @param toPath	鍚堟垚锲剧墖鍐椤叆璺缎
     * @throws IOException
     */
    public void mergeBothImageLeftbottom(String negativeImagePath, String additionImagePath, String toPath) throws IOException {
        InputStream is = null;
        InputStream is2 = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(negativeImagePath);
            is2 = new FileInputStream(additionImagePath);
            BufferedImage image = ImageIO.read(is);
            BufferedImage image2 = ImageIO.read(is2);
            Graphics g = image.getGraphics();
            g.drawImage(image2, 0, image.getHeight() - image2.getHeight(), null);
            os = new FileOutputStream(toPath);
            JPEGImageEncoder enc = JPEGCodec.createJPEGEncoder(os);
            enc.encode(image);
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            if(os != null){
                os.close();
            }
            if(is2 != null){
                is2.close();
            }
            if(is != null){
                is.close();
            }
        }
    }

    /**
     * 灏嗛檮锷犲浘鐗囧悎骞跺埌搴曞浘镄勫乏涓嬭
     * @param negativeImagePath 搴曞浘璺缎
     * @param additionImagePath	闄勫姞锲剧墖璺缎
     * @param toPath	鍚堟垚锲剧墖鍐椤叆璺缎
     * @throws IOException
     */
    public void mergeBothImageRightbottom(String negativeImagePath, String additionImagePath, String toPath) throws IOException {
        InputStream is = null;
        InputStream is2 = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(negativeImagePath);
            is2 = new FileInputStream(additionImagePath);
            BufferedImage image = ImageIO.read(is);
            BufferedImage image2 = ImageIO.read(is2);
            Graphics g = image.getGraphics();
            g.drawImage(image2, image.getWidth() - image2.getWidth(), image.getHeight() - image2.getHeight(), null);
            os = new FileOutputStream(toPath);
            JPEGImageEncoder enc = JPEGCodec.createJPEGEncoder(os);
            enc.encode(image);
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            if(os != null){
                os.close();
            }
            if(is2 != null){
                is2.close();
            }
            if(is != null){
                is.close();
            }
        }
    }

    /**
     * 灏嗛檮锷犲浘鐗囧悎骞跺埌搴曞浘镄勬涓ぎ
     * @param negativeImagePath 搴曞浘璺缎
     * @param additionImagePath	闄勫姞锲剧墖璺缎
     * @param toPath	鍚堟垚锲剧墖鍐椤叆璺缎
     * @throws IOException
     */
    public void mergeBothImageCenter(String negativeImagePath, String additionImagePath, String toPath) throws IOException {
        InputStream is = null;
        InputStream is2 = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(negativeImagePath);
            is2 = new FileInputStream(additionImagePath);
            BufferedImage image = ImageIO.read(is);
            BufferedImage image2 = ImageIO.read(is2);
            Graphics g = image.getGraphics();
            g.drawImage(image2, image.getWidth() / 2 - image2.getWidth() / 2, image.getHeight() / 2 - image2.getHeight() / 2, null);
            os = new FileOutputStream(toPath);
            JPEGImageEncoder enc = JPEGCodec.createJPEGEncoder(os);
            enc.encode(image);
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            if(os != null){
                os.close();
            }
            if(is2 != null){
                is2.close();
            }
            if(is != null){
                is.close();
            }
        }
    }

    /**
     * 灏嗛檮锷犲浘鐗囧悎骞跺埌搴曞浘镄勪笂杈逛腑澶?
     * @param negativeImagePath 搴曞浘璺缎
     * @param additionImagePath	闄勫姞锲剧墖璺缎
     * @param toPath	鍚堟垚锲剧墖鍐椤叆璺缎
     * @throws IOException
     */
    public void mergeBothImageTopcenter(String negativeImagePath, String additionImagePath, String toPath) throws IOException {
        InputStream is = null;
        InputStream is2 = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(negativeImagePath);
            is2 = new FileInputStream(additionImagePath);
            BufferedImage image = ImageIO.read(is);
            BufferedImage image2 = ImageIO.read(is2);
            Graphics g = image.getGraphics();
            g.drawImage(image2, image.getWidth() / 2 - image2.getWidth() / 2, 0, null);
            os = new FileOutputStream(toPath);
            JPEGImageEncoder enc = JPEGCodec.createJPEGEncoder(os);
            enc.encode(image);
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            if(os != null){
                os.close();
            }
            if(is2 != null){
                is2.close();
            }
            if(is != null){
                is.close();
            }
        }
    }

    /**
     * 灏嗛檮锷犲浘鐗囧悎骞跺埌搴曞浘镄勪笅杈逛腑澶?
     * @param negativeImagePath 搴曞浘璺缎
     * @param additionImagePath	闄勫姞锲剧墖璺缎
     * @param toPath	鍚堟垚锲剧墖鍐椤叆璺缎
     * @throws IOException
     */
    public void mergeBothImageBottomcenter(String negativeImagePath, String additionImagePath, String toPath) throws IOException {
        InputStream is = null;
        InputStream is2 = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(negativeImagePath);
            is2 = new FileInputStream(additionImagePath);
            BufferedImage image = ImageIO.read(is);
            BufferedImage image2 = ImageIO.read(is2);
            Graphics g = image.getGraphics();
            g.drawImage(image2, image.getWidth() / 2 - image2.getWidth() / 2, image.getHeight() - image2.getHeight(), null);
            os = new FileOutputStream(toPath);
            JPEGImageEncoder enc = JPEGCodec.createJPEGEncoder(os);
            enc.encode(image);
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            if(os != null){
                os.close();
            }
            if(is2 != null){
                is2.close();
            }
            if(is != null){
                is.close();
            }
        }
    }

    /**
     * 灏嗛檮锷犲浘鐗囧悎骞跺埌搴曞浘镄勫乏杈逛腑澶?
     * @param negativeImagePath 搴曞浘璺缎
     * @param additionImagePath	闄勫姞锲剧墖璺缎
     * @param toPath	鍚堟垚锲剧墖鍐椤叆璺缎
     * @throws IOException
     */
    public void mergeBothImageLeftcenter(String negativeImagePath, String additionImagePath, String toPath) throws IOException {
        InputStream is = null;
        InputStream is2 = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(negativeImagePath);
            is2 = new FileInputStream(additionImagePath);
            BufferedImage image = ImageIO.read(is);
            BufferedImage image2 = ImageIO.read(is2);
            Graphics g = image.getGraphics();
            g.drawImage(image2, 0, image.getHeight() / 2 - image2.getHeight() / 2, null);
            os = new FileOutputStream(toPath);
            JPEGImageEncoder enc = JPEGCodec.createJPEGEncoder(os);
            enc.encode(image);
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            if(os != null){
                os.close();
            }
            if(is2 != null){
                is2.close();
            }
            if(is != null){
                is.close();
            }
        }
    }

    /**
     * 灏嗛檮锷犲浘鐗囧悎骞跺埌搴曞浘镄勫彸杈逛腑澶?
     * @param negativeImagePath 搴曞浘璺缎
     * @param additionImagePath	闄勫姞锲剧墖璺缎
     * @param toPath	鍚堟垚锲剧墖鍐椤叆璺缎
     * @throws IOException
     */
    public void mergeBothImageRightcenter(String negativeImagePath, String additionImagePath, String toPath) throws IOException {
        InputStream is = null;
        InputStream is2 = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(negativeImagePath);
            is2 = new FileInputStream(additionImagePath);
            BufferedImage image = ImageIO.read(is);
            BufferedImage image2 = ImageIO.read(is2);
            Graphics g = image.getGraphics();
            g.drawImage(image2, image.getWidth() - image2.getWidth(), image.getHeight() / 2 - image2.getHeight() / 2, null);
            os = new FileOutputStream(toPath);
            JPEGImageEncoder enc = JPEGCodec.createJPEGEncoder(os);
            enc.encode(image);
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            if(os != null){
                os.close();
            }
            if(is2 != null){
                is2.close();
            }
            if(is != null){
                is.close();
            }
        }
    }

    /**
     * 锲剧墖鐏板寲鎿崭綔
     * @param srcImage 璇诲彇锲剧墖璺缎
     * @param toPath	鍐椤叆鐏板寲鍚庣殑锲剧墖璺缎
     * @param imageFormat 锲剧墖鍐椤叆镙煎纺
     */
    public void grayImage(String srcImage, String toPath, String imageFormat){
        try {
            BufferedImage src = ImageIO.read(new File(srcImage));
            ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
            ColorConvertOp op = new ColorConvertOp(cs, null);
            src = op.filter(src, null);
            ImageIO.write(src, imageFormat, new File(toPath));
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 鍦ㄦ簮锲剧墖涓婅缃按鍗版枃瀛?
     * @param srcImagePath	婧愬浘鐗囱矾寰?
     * @param alpha	阃忔槑搴︼纸0<alpha<1锛?
     * @param font	瀛椾綋锛堜緥濡傦细瀹嬩綋锛?
     * @param fontStyle		瀛椾綋镙煎纺(渚嫔锛氭櫘阃氭牱寮?-Font.PLAIN銆佺矖浣?-Font.BOLD)
     * @param fontSize	瀛椾綋澶у皬
     * @param color	瀛椾綋棰滆壊(渚嫔锛氶粦鑹?-Color.BLACK)
     * @param inputWords		杈揿叆鏄剧ず鍦ㄥ浘鐗囦笂镄勬枃瀛?
     * @param x		鏂囧瓧鏄剧ず璧峰镄刹鍧愭爣
     * @param y		鏂囧瓧鏄剧ず璧峰镄剏鍧愭爣
     * @param imageFormat	鍐椤叆锲剧墖镙煎纺锛坧ng/jpg绛夛级
     * @param toPath	鍐椤叆锲剧墖璺缎
     * @throws IOException
     */
    public void alphaWords2Image(String srcImagePath, float alpha,
                                 String font, int fontStyle, int fontSize, Color color,
                                 String inputWords, int x, int y, String imageFormat, String toPath) throws IOException {
        FileOutputStream fos = null;
        try {
            BufferedImage image = ImageIO.read(new File(srcImagePath));
            //鍒涘缓java2D瀵硅薄
            Graphics2D g2d = image.createGraphics();
            //鐢ㄦ簮锲惧儚濉厖鑳屾櫙
            g2d.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null, null);
            //璁剧疆阃忔槑搴?
            AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
            g2d.setComposite(ac);
            //璁剧疆鏂囧瓧瀛椾綋鍚岖О銆佹牱寮忋€佸ぇ灏?
            g2d.setFont(new Font(font, fontStyle, fontSize));
            g2d.setColor(color);//璁剧疆瀛椾綋棰滆壊
            g2d.drawString(inputWords, x, y); //杈揿叆姘村嵃鏂囧瓧鍙婂叾璧峰x銆乱鍧愭爣
            g2d.dispose();
            fos = new FileOutputStream(toPath);
            ImageIO.write(image, imageFormat, fos);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(fos != null){
                fos.close();
            }
        }
    }

    /**
     * 鍦ㄦ簮锲惧儚涓婅缃浘鐗囨按鍗?
     * 	---- 褰揳lpha==1镞舵枃瀛椾笉阃忔槑锛埚拰鍦ㄥ浘鐗囦笂鐩存帴杈揿叆鏂囧瓧鏁堟灉涓€镙凤级
     * @param srcImagePath	婧愬浘鐗囱矾寰?
     * @param appendImagePath	姘村嵃锲剧墖璺缎
     * @param alpha	阃忔槑搴?
     * @param x		姘村嵃锲剧墖镄勮捣濮媥鍧愭爣
     * @param y		姘村嵃锲剧墖镄勮捣濮媦鍧愭爣
     * @param width	姘村嵃锲剧墖镄勫搴?
     * @param height		姘村嵃锲剧墖镄勯佩搴?
     * @param imageFormat	锲惧儚鍐椤叆锲剧墖镙煎纺
     * @param toPath	锲惧儚鍐椤叆璺缎
     * @throws IOException
     */
    public void alphaImage2Image(String srcImagePath, String appendImagePath,
                                 float alpha, int x, int y, int width, int height,
                                 String imageFormat, String toPath) throws IOException {
        FileOutputStream fos = null;
        try {
            BufferedImage image = ImageIO.read(new File(srcImagePath));
            //鍒涘缓java2D瀵硅薄
            Graphics2D g2d = image.createGraphics();
            //鐢ㄦ簮锲惧儚濉厖鑳屾櫙
            g2d.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null, null);
            //璁剧疆阃忔槑搴?
            AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
            g2d.setComposite(ac);
            //璁剧疆姘村嵃锲剧墖镄勮捣濮媥/y鍧愭爣銆佸搴︺€侀佩搴?
            BufferedImage appendImage = ImageIO.read(new File(appendImagePath));
            g2d.drawImage(appendImage, x, y, width, height, null, null);
            g2d.dispose();
            fos = new FileOutputStream(toPath);
            ImageIO.write(image, imageFormat, fos);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(fos != null){
                fos.close();
            }
        }
    }

    /**
     * 鐢诲崟镣?---- 瀹为台涓婃槸鐢讳竴涓～鍏呴鑹茬殑鍦?
     * ---- 浠ユ寚瀹氱偣鍧愭爣涓轰腑蹇幂敾涓€涓皬鍗婂缎镄勫浑褰紝骞跺～鍏呭叾棰滆壊鏉ュ厖褰撶偣
     * @param srcImagePath	 婧愬浘鐗囬鑹?
     * @param x		镣圭殑x鍧愭爣
     * @param y		镣圭殑y鍧愭爣
     * @param width	濉厖镄勫搴?
     * @param height	濉厖镄勯佩搴?
     * @param ovalColor	濉厖棰滆壊
     * @param imageFormat	鍐椤叆锲剧墖镙煎纺
     * @param toPath	鍐椤叆璺缎
     * @throws IOException
     */
    public void drawPoint(String srcImagePath, int x, int y, int width, int height, Color ovalColor, String imageFormat, String toPath) throws IOException {
        FileOutputStream fos = null;
        try {
            //銮峰彇婧愬浘鐗?
            BufferedImage image = ImageIO.read(new File(srcImagePath));
            //镙规嵁xy镣瑰潗镙囩粯鍒惰繛鎺ョ嚎
            Graphics2D g2d = image.createGraphics();
            g2d.setColor(ovalColor);
            //濉厖涓€涓き鍦嗗舰
            g2d.fillOval(x, y, width, height);
            fos = new FileOutputStream(toPath);
            ImageIO.write(image, imageFormat, fos);
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if(fos != null){
                fos.close();
            }
        }
    }

    /**
     * 鐢讳竴缁勶纸澶氢釜锛夌偣---- 瀹为台涓婃槸鐢讳竴缁勶纸澶氢釜锛夊～鍏呴鑹茬殑鍦?
     * ---- 浠ユ寚瀹氱偣鍧愭爣涓轰腑蹇幂敾涓€涓皬鍗婂缎镄勫浑褰紝骞跺～鍏呭叾棰滆壊鏉ュ厖褰撶偣
     * @param srcImagePath	铡熷浘鐗囱矾寰?
     * @param pointList	镣瑰垪琛?
     * @param width	瀹藉害
     * @param height		楂桦害
     * @param ovalColor 濉厖棰滆壊
     * @param imageFormat	鍐椤叆锲剧墖棰滆壊
     * @param toPath	鍐椤叆璺缎
     * @throws IOException
     */
    public void drawPoints(String srcImagePath, List pointList, int width, int height, Color ovalColor, String imageFormat, String toPath) throws IOException {
        FileOutputStream fos = null;
        try {
            //銮峰彇婧愬浘鐗?
            BufferedImage image = ImageIO.read(new File(srcImagePath));
            //镙规嵁xy镣瑰潗镙囩粯鍒惰繛鎺ョ嚎
            Graphics2D g2d = image.createGraphics();
            g2d.setColor(ovalColor);
            //濉厖涓€涓き鍦嗗舰
            if(pointList != null){
                for(int i = 0; i < pointList.size(); i++){
                    Point point = (Point)pointList.get(i);
                    int x = (int) point.getX();
                    int y = (int) point.getY();
                    g2d.fillOval(x, y, width, height);
                }
            }
            fos = new FileOutputStream(toPath);
            ImageIO.write(image, imageFormat, fos);
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if(fos != null){
                fos.close();
            }
        }
    }

    /**
     * 鐢荤嚎娈?
     * @param srcImagePath	婧愬浘鐗囱矾寰?
     * @param x1	绗竴涓偣x鍧愭爣
     * @param y1	绗竴涓偣y鍧愭爣
     * @param x2	绗簩涓偣x鍧愭爣
     * @param y2	绗簩涓偣y鍧愭爣
     * @param lineColor 绾挎浔棰滆壊
     * @param toPath	锲惧儚鍐椤叆璺缎
     * @param imageFormat	锲惧儚鍐椤叆镙煎纺
     * @throws IOException
     */
    public void drawLine(String srcImagePath, int x1, int y1, int x2, int y2, Color lineColor, String toPath, String imageFormat) throws IOException {
        FileOutputStream fos = null;
        try {
            //銮峰彇婧愬浘鐗?
            BufferedImage image = ImageIO.read(new File(srcImagePath));
            //镙规嵁xy镣瑰潗镙囩粯鍒惰繛鎺ョ嚎
            Graphics2D g2d = image.createGraphics();
            g2d.setColor(lineColor);
            g2d.drawLine(x1, y1, x2, y2);
            fos = new FileOutputStream(toPath);
            ImageIO.write(image, imageFormat, fos);
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if(fos != null){
                fos.close();
            }
        }
    }

    /**
     * 鐢绘姌绾?/ 绾挎
     * ---- 2涓偣鍗崇敾绾挎锛屽涓偣鐢绘姌绾?
     * @param srcImagePath	婧愬浘鐗囱矾寰?
     * @param xPoints	x鍧愭爣鏁扮粍
     * @param yPoints	y鍧愭爣鏁扮粍
     * @param nPoints	镣圭殑鏁伴噺
     * @param lineColor	绾挎浔棰滆壊
     * @param toPath	锲惧儚鍐椤叆璺缎
     * @param imageFormat	锲剧墖鍐椤叆镙煎纺
     * @throws IOException
     */
    public void drawPolyline(String srcImagePath, int[] xPoints, int[] yPoints, int nPoints, Color lineColor, String toPath, String imageFormat) throws IOException {
        FileOutputStream fos = null;
        try {
            //銮峰彇婧愬浘鐗?
            BufferedImage image = ImageIO.read(new File(srcImagePath));
            //镙规嵁xy镣瑰潗镙囩粯鍒惰繛鎺ョ嚎
            Graphics2D g2d = image.createGraphics();
            //璁剧疆绾挎浔棰滆壊
            g2d.setColor(lineColor);
            g2d.drawPolyline(xPoints, yPoints, nPoints);
            //锲惧儚鍐椤嚭璺缎
            fos = new FileOutputStream(toPath);
            ImageIO.write(image, imageFormat, fos);
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if(fos != null){
                fos.close();
            }
        }
    }

    /**
     * 缁桦埗鎶樼嚎锛屽苟绐佸嚭鏄剧ず杞姌镣?
     * @param srcImagePath	婧愬浘鐗囱矾寰?
     * @param xPoints	x鍧愭爣鏁扮粍
     * @param yPoints	y鍧愭爣鏁扮粍
     * @param nPoints	镣圭殑鏁伴噺
     * @param lineColor	杩炵嚎棰滆壊
     * @param width	镣圭殑瀹藉害
     * @param height		镣圭殑楂桦害
     * @param ovalColor	镣圭殑濉厖棰滆壊
     * @param toPath	锲惧儚鍐椤叆璺缎
     * @param imageFormat	锲惧儚鍐椤叆镙煎纺
     * @throws IOException
     */
    public void drawPolylineShowPoints(String srcImagePath, int[] xPoints, int[] yPoints, int nPoints, Color lineColor, int width, int height, Color ovalColor, String toPath, String imageFormat) throws IOException {
        FileOutputStream fos = null;
        try {
            //銮峰彇婧愬浘鐗?
            BufferedImage image = ImageIO.read(new File(srcImagePath));
            //镙规嵁xy镣瑰潗镙囩粯鍒惰繛鎺ョ嚎
            Graphics2D g2d = image.createGraphics();
            //璁剧疆绾挎浔棰滆壊
            g2d.setColor(lineColor);
            //鐢荤嚎鏉?
            g2d.drawPolyline(xPoints, yPoints, nPoints);
            //璁剧疆鍦嗙偣棰滆壊
            g2d.setColor(ovalColor);
            //鐢诲浑镣?
            if(xPoints != null){
                for(int i = 0; i < xPoints.length; i++){
                    int x = xPoints[i];
                    int y = yPoints[i];
                    g2d.fillOval(x, y, width, height);
                }
            }
            //锲惧儚鍐椤嚭璺缎
            fos = new FileOutputStream(toPath);
            ImageIO.write(image, imageFormat, fos);
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if(fos != null){
                fos.close();
            }
        }
    }


    /**
     * 缁桦埗涓€涓敱 x 鍜?y 鍧愭爣鏁扮粍瀹氢箟镄勯棴鍚埚杈瑰舰
     * @param srcImagePath 婧愬浘鐗囱矾寰?
     * @param xPoints	x鍧愭爣鏁扮粍
     * @param yPoints	y鍧愭爣鏁扮粍
     * @param nPoints	鍧愭爣镣圭殑涓暟
     * @param polygonColor	绾挎浔棰滆壊
     * @param imageFormat	锲惧儚鍐椤叆镙煎纺
     * @param toPath	锲惧儚鍐椤叆璺缎
     * @throws IOException
     */
    public void drawPolygon(String srcImagePath, int[] xPoints, int[] yPoints, int nPoints, Color polygonColor, String imageFormat, String toPath) throws IOException {
        FileOutputStream fos = null;
        try {
            //銮峰彇锲剧墖
            BufferedImage image = ImageIO.read(new File(srcImagePath));
            //镙规嵁xy镣瑰潗镙囩粯鍒堕棴鍚埚杈瑰舰
            Graphics2D g2d = image.createGraphics();
            g2d.setColor(polygonColor);
            g2d.drawPolygon(xPoints, yPoints, nPoints);
            fos = new FileOutputStream(toPath);
            ImageIO.write(image, imageFormat, fos);
            g2d.dispose();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(fos != null){
                fos.close();
            }
        }
    }

    /**
     * 缁桦埗骞跺～鍏呭杈瑰舰
     * @param srcImagePath	婧愬浘镀忚矾寰?
     * @param xPoints	x鍧愭爣鏁扮粍
     * @param yPoints	y鍧愭爣鏁扮粍
     * @param nPoints	鍧愭爣镣逛釜鏁?
     * @param polygonColor	澶氲竟褰㈠～鍏呴鑹?
     * @param alpha	澶氲竟褰㈤儴鍒嗛€忔槑搴?
     * @param imageFormat	鍐椤叆锲惧舰镙煎纺
     * @param toPath	鍐椤叆锲惧舰璺缎
     * @throws IOException
     */
    public void drawAndAlphaPolygon(String srcImagePath, int[] xPoints, int[] yPoints, int nPoints, Color polygonColor, float alpha, String imageFormat, String toPath) throws IOException {
        FileOutputStream fos = null;
        try {
            //銮峰彇锲剧墖
            BufferedImage image = ImageIO.read(new File(srcImagePath));
            //镙规嵁xy镣瑰潗镙囩粯鍒堕棴鍚埚杈瑰舰
            Graphics2D g2d = image.createGraphics();
            g2d.setColor(polygonColor);
            //璁剧疆阃忔槑搴?
            AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
            g2d.setComposite(ac);
            g2d.fillPolygon(xPoints, yPoints, nPoints);
            fos = new FileOutputStream(toPath);
            ImageIO.write(image, imageFormat, fos);
            g2d.dispose();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(fos != null){
                fos.close();
            }
        }
    }


    public static void main(String[] args)throws Exception {
        OperateImage imageObj = new OperateImage();

        /*String srcPath = "D:/test/fileSource/004.jpg";
        String toPath = "D:/test/desk/+e004.jpg";
        int x = 200;
        int y = 300;
        int width = 300;
        int height = 200 ;
        String readImageFormat = "jpg";
        String writeImageFormat = "jpg"*/;
        //imageObj.cropImage(srcPath, toPath, x, y, width, height,readImageFormat,writeImageFormat);//鍓垏锲剧墖
        //imageObj.resizeImage(srcPath, toPath, 400, 400);//鎸夋寚瀹氱殑闀垮閲岖疆锲惧舰澶у皬
        //imageObj.reduceImageByRatio(srcPath, toPath, 3, 3);//鎸夋寚瀹氶昵鍜屽镄勬瘮渚嬬缉灏忓浘褰?
        //imageObj.enlargementImageByRatio(srcPath, toPath, 2, 2);//鎸夋寚瀹氶昵鍜屽镄勬瘮渚嬫斁澶у浘褰?
        //imageObj.reduceImageEqualProportion(srcPath, toPath, 4);//闀块佩绛夋瘮渚嬬缉灏?
        //imageObj.enlargementImageEqualProportion(srcPath, toPath, 2);//闀块佩绛夋瘮渚嬫斁澶?
        /* String negativeImagePath = "D:/test/fileSource/004.jpg";
         String additionImagePath = "D:/test/fileSource/005.jpg";
         int x = 200;
         int y = 200;
         String toPath = "D:/test/desk/004+005-rightcenter.jpg";*/
        //imageObj.mergeBothImage(negativeImagePath, additionImagePath, x, y, toPath); //鎸夋寚瀹氩潗镙囧悎骞跺浘鐗?
        //imageObj.mergeBothImageTopleftcorner(negativeImagePath, additionImagePath, toPath);//鍚埚苟鍒板乏涓婅
        //imageObj.mergeBothImageToprightcorner(negativeImagePath, additionImagePath, toPath);//鍚埚苟鍒板彸涓婅
        //imageObj.mergeBothImageLeftbottom(negativeImagePath, additionImagePath, toPath);//鍚埚苟鍒板乏涓嬭
        //imageObj.mergeBothImageRightbottom(negativeImagePath, additionImagePath, toPath);//鍚埚苟鍒板彸涓嬭
        //imageObj.mergeBothImageCenter(negativeImagePath, additionImagePath, toPath);//鍚埚苟鍒版涓ぎ
        //imageObj.mergeBothImageTopcenter(negativeImagePath, additionImagePath, toPath);//鍚埚苟鍒颁笂杈逛腑澶?
        //imageObj.mergeBothImageBottomcenter(negativeImagePath, additionImagePath, toPath);//鍚埚苟鍒颁笅杈逛腑澶?
        //imageObj.mergeBothImageLeftcenter(negativeImagePath, additionImagePath, toPath);//鍚埚苟鍒板乏杈逛腑澶?
        //imageObj.mergeBothImageRightcenter(negativeImagePath, additionImagePath, toPath);//鍚埚苟鍒板彸杈逛腑澶?

        /*
        String srcImage = "D:/test/fileSource/001.jpg";
        String toPath = "D:/test/desk/001-gray.jpg";
        String imageFormat = "jpg";
        imageObj.grayImage(srcImage, toPath, imageFormat);//锲剧墖鐏板寲
         */

        /*
        String firstSrcImagePath = "D:/test/desk/003.jpg";
        String secondSrcImagePath = "D:/test/desk/004.jpg";
        String imageFormat = "jpg";
        String toPath = "D:/test/desk/003-004-join.jpg";
        imageObj.joinImagesHorizontal(firstSrcImagePath, secondSrcImagePath, imageFormat, toPath);//妯悜鎷兼帴锲剧墖
        */

        /*
        String firstSrcImagePath = "D:/test/desk/001-002-join.jpg";
        String secondSrcImagePath = "D:/test/desk/003-004-join.jpg";
        String imageFormat = "jpg";
        String toPath = "D:/test/desk/all-join.jpg";
        imageObj.joinImagesVertical(firstSrcImagePath, secondSrcImagePath, imageFormat, toPath);//绾靛悜鎷兼帴锲剧墖
        */

        /*String srcImagePath = "D:/test/fileSource/002.jpg";
        int[] xPoints = {20,100,160,270,500};
        int[] yPoints = {30,150,172,295,615};
        int nPoints = 5;
        String toPath = "D:/test/desk/polygon-002.png";
        imageObj.drawPolygon(srcImagePath, xPoints, yPoints, nPoints, Color.MAGENTA, "jpg", toPath); //镙规嵁鍧愭爣鏁扮粍缁桦埗澶氲竟褰?
        */

        /*String srcImagePath = "D:/test/fileSource/004.jpg";
        String appendImagePath = "D:/test/fileSource/005.jpg";
        float alpha = 0.2F;
        String  font = "瀹嬩綋";
        int fontStyle = Font.PLAIN;
        int fontSize = 32;
        Color color = Color.RED;
        String inputWords = "锲剧墖涓婅缃按鍗版枃瀛?---- 瀹嬩綋 鏅€氩瓧浣?32鍙峰瓧 绾㈣壊 阃忔槑搴?.5";
        int x = 20;
        int y = 40;
        String imageFormat = "jpg";
        String toPath = "D:/test/desk/alphaI2I-001.png";*/
        //imageObj.alphaWords2Image(srcImagePath, alpha, font, fontStyle, fontSize, color, inputWords, x, y, imageFormat, toPath); //璁剧疆鏂囧瓧姘村嵃
        //imageObj.alphaImage2Image(srcImagePath, appendImagePath, alpha, x, y, 300, 200, imageFormat, toPath);//璁剧疆锲剧墖姘村嵃

        /*
        String srcImagePath = "D:/test/fileSource/003.jpg";
        int[] xPoints = {100,150,200,240,300};
        int[] yPoints = {200,60,280,160,100};
        int nPoints = 5;
        Color lineColor = Color.RED;
        String toPath = "D:/test/desk/polyline-003.jpg";
        String imageFormat = "jpg";
        imageObj.drawPolyline(srcImagePath, xPoints, yPoints, nPoints, lineColor,toPath, imageFormat);//鐢绘姌绾?
         */

        /*
        int x1 = 50;
        int y1 = 100;
        int x2 = 600;
        int y2 = 150;
        Color lineColor = Color.BLUE;
        imageObj.drawLine(srcImagePath, x1, y1, x2, y2, lineColor,toPath, imageFormat);//鐢荤嚎娈?
         */

        /*
        String srcImagePath = "D:/test/fileSource/002.jpg";
        int x = 400;
        int y = 500;
        int width = 10;
        int height = 10;
        Color ovalColor = Color.RED;
        String imageFormat = "jpg";
        String toPath = "D:/test/desk/point-002.jpg";
        imageObj.drawPoint(srcImagePath, x, y, width, height, ovalColor, imageFormat, toPath);//鐢讳竴涓浑镣?
        */

        /*List pointList = new ArrayList();
        Point p1 = new Point(60,80);
        pointList.add(p1);
        Point p2 = new Point(160,80);
        pointList.add(p2);
        Point p3 = new Point(60,180);
        pointList.add(p3);
        Point p4 = new Point(260,180);
        pointList.add(p4);
        Point p5 = new Point(460,380);
        pointList.add(p5);
        String srcImagePath = "D:/test/fileSource/004.jpg";
        int width = 10;
        int height = 10;
        Color ovalColor = Color.RED;
        String imageFormat = "jpg";
        String toPath = "D:/test/desk/points-004.jpg";
        imageObj.drawPoints(srcImagePath, pointList, width, height, ovalColor, imageFormat, toPath);//鐢诲嚭涓€缁勶纸澶氢釜锛夌偣
         */

        /*
        int[] xPoints = {50,100,180,400,600};
        int[] yPoints = {200,100,160,300,640};
        int nPoints = 5;
        Color lineColor = Color.PINK;
        String srcImagePath = "D:/test/fileSource/003.jpg";
        String toPath = "D:/test/desk/showpoints-003.jpg";
        imageObj.drawPolylineShowPoints(srcImagePath, xPoints, yPoints, nPoints, lineColor, width, height, ovalColor, toPath, imageFormat);//鐢绘姌绾垮苟绐佸嚭鏄剧ず镣?
         */

        /*
        String srcImagePath ="D:/test/fileSource/004.jpg";
        int[] xPoints ={50,90,180,320,640};
        int[] yPoints ={200,300,120,240,360};
        int nPoints = 5;
        Color polygonColor = Color.PINK;
        float alpha = (float) 0.2;
        String imageFormat ="jpg";
        String toPath ="D:/test/desk/drawalpha-004.jpg";
        imageObj.drawAndAlphaPolygon(srcImagePath, xPoints, yPoints, nPoints, polygonColor, alpha, imageFormat, toPath);
        */
        /*
        String negativeImagePath = "D:/test/fileSource/001.jpg";
        String additionImagePath = "D:/test/fileSource/006.png";
        String  toPath = "D:/test/fileSource/001.jpg";
        long start = System.currentTimeMillis();
        for(int i=0;i<1000;i++){
        	Random rand = new Random();
        	int x = rand.nextInt(1024);
        	int y =  rand.nextInt(768);
        	imageObj.mergeBothImage(negativeImagePath, additionImagePath, x, y, toPath);//姣忔闄勫姞鍚埚苟涓€寮犲浘鐗?寰幆鑻ュ共娆?
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);*/
        //100 -- 45844
        //1000 -- 411156
        /*鏀硅繘镐濊矾锛氩皢mergeBothImage鏂规硶 淇敼涓簃ergeImageList鏂规硶锛?
        阃氲绷灏嗗浘鐗囩殑鍧愭爣镣硅鍏ist瀹瑰櫒锛岀劧鍚庡啀鍙栧嚭涓€鏉ュ湪鏂规硶涓竴娆℃€т笌锲剧墖鍚埚苟,
        涓嶅啀姣忔閮芥墦寮€搴曞浘銆佷缭瀛桦悎鎴愬浘鐗囷紝鍏抽棴娴?/

        //鍙犲姞缁勫悎锲惧儚
        /*String negativeImagePath = "D:/test/fileSource/001.jpg";
        String  toPath = "D:/test/fileSource/001.jpg";
        String additionImagePath = "D:/test/fileSource/007.png";
        List additionImageList = new ArrayList();
        int count = 0;
        for(int i=0;i<100;i++){//涓轰粈涔堟€绘槸杩炵画鐢熸垚涓€镙风殑闅忔満鏁帮紵锛燂紵
        	Random rand = new Random();
        	int x = rand.nextInt(1020);
        	String xStr = x+"";
        	int y =  rand.nextInt(760);
        	String yStr = y +"";
        	String[] str = {xStr,yStr,additionImagePath};
        	additionImageList.add(str);
        	count++;
        	//System.out.println(xStr+"   :     "+yStr);
        }
        System.out.println(count);
        long start = System.currentTimeMillis();
        imageObj.mergeImageList(negativeImagePath, additionImageList,"jpg", toPath);
        long end = System.currentTimeMillis();
        System.out.println(end-start);*/
        //                                绗竴娆?       绗簩娆?     绗笁娆?
        //100寮犺€楁椂(姣)		--2003			1792			1869           1747        	1871        	1793
        //1000寮犺€楁椂(姣)	--15334			15200		15236         15903			16028		15545
        //10000寮犺€楁椂(姣)	--153010		153340 		152673       154978  		156506 		154854
        //濡傛灉list.size()<=100,鍒栾皟鐢ㄦ鏂规硶锛?
        //濡傛灉list.size()>100,鍒栾皟鐢↗magick镄勬柟娉曘€?

        /*List iamgePathList = new ArrayList();		// D:/test/16a/
        iamgePathList.add("D:/test/16a/12384_2492.jpg");
        iamgePathList.add("D:/test/16a/12384_2493.jpg");
        iamgePathList.add("D:/test/16a/12384_2494.jpg");
        iamgePathList.add("D:/test/16a/12384_2495.jpg");
        iamgePathList.add("D:/test/16a/12384_2496.jpg");
        iamgePathList.add("D:/test/16a/12384_2497.jpg");
        iamgePathList.add("D:/test/16a/12384_2498.jpg");
        iamgePathList.add("D:/test/16a/12384_2499.jpg");
        iamgePathList.add("D:/test/16a/12384_2500.jpg");
        iamgePathList.add("D:/test/16a/12384_2501.jpg");
        iamgePathList.add("D:/test/16a/12384_2502.jpg");*/
        //String imageFormat = "jpg";
        //String toPath = "D:/test/desk/16a_v1.jpg";
        //imageObj.joinImageListHorizontal(iamgePathList, imageFormat, toPath);

        /*String imageFormat = "jpg";
        String[] pics1 = {"D:/test/16a/12384_2502.jpg","D:/test/16a/12384_2501.jpg",
        		"D:/test/16a/12384_2500.jpg","D:/test/16a/12384_2499.jpg","D:/test/16a/12384_2498.jpg",
        		"D:/test/16a/12384_2497.jpg","D:/test/16a/12384_2496.jpg","D:/test/16a/12384_2495.jpg",
        		"D:/test/16a/12384_2494.jpg","D:/test/16a/12384_2493.jpg","D:/test/16a/12384_2492.jpg"};

        String[] pics2 = {"D:/test/16a/12385_2502.jpg","D:/test/16a/12385_2501.jpg",
        		"D:/test/16a/12385_2500.jpg","D:/test/16a/12385_2499.jpg","D:/test/16a/12385_2498.jpg",
        		"D:/test/16a/12385_2497.jpg","D:/test/16a/12385_2496.jpg","D:/test/16a/12385_2495.jpg",
        		"D:/test/16a/12385_2494.jpg","D:/test/16a/12385_2493.jpg","D:/test/16a/12385_2492.jpg"};

        String[] pics3 = {"D:/test/16a/12386_2502.jpg","D:/test/16a/12386_2501.jpg",
        		"D:/test/16a/12386_2500.jpg","D:/test/16a/12386_2499.jpg","D:/test/16a/12386_2498.jpg",
        		"D:/test/16a/12386_2497.jpg","D:/test/16a/12386_2496.jpg","D:/test/16a/12386_2495.jpg",
        		"D:/test/16a/12386_2494.jpg","D:/test/16a/12386_2493.jpg","D:/test/16a/12386_2492.jpg"};

        String[] pics4 = {"D:/test/16a/12387_2502.jpg","D:/test/16a/12387_2501.jpg",
        		"D:/test/16a/12387_2500.jpg","D:/test/16a/12387_2499.jpg","D:/test/16a/12387_2498.jpg",
        		"D:/test/16a/12387_2497.jpg","D:/test/16a/12387_2496.jpg","D:/test/16a/12387_2495.jpg",
        		"D:/test/16a/12387_2494.jpg","D:/test/16a/12387_2493.jpg","D:/test/16a/12387_2492.jpg"};

        String[] pics5 = {"D:/test/16a/12388_2502.jpg","D:/test/16a/12388_2501.jpg",
        		"D:/test/16a/12388_2500.jpg","D:/test/16a/12388_2499.jpg","D:/test/16a/12388_2498.jpg",
        		"D:/test/16a/12388_2497.jpg","D:/test/16a/12388_2496.jpg","D:/test/16a/12388_2495.jpg",
        		"D:/test/16a/12388_2494.jpg","D:/test/16a/12388_2493.jpg","D:/test/16a/12388_2492.jpg"};

        String[] pics6 = {"D:/test/16a/12389_2502.jpg","D:/test/16a/12389_2501.jpg",
        		"D:/test/16a/12389_2500.jpg","D:/test/16a/12389_2499.jpg","D:/test/16a/12389_2498.jpg",
        		"D:/test/16a/12389_2497.jpg","D:/test/16a/12389_2496.jpg","D:/test/16a/12389_2495.jpg",
        		"D:/test/16a/12389_2494.jpg","D:/test/16a/12389_2493.jpg","D:/test/16a/12389_2492.jpg"};

        String toPath1 = "D:/test/desk/16a_v1.jpg";
        String toPath2 = "D:/test/desk/16a_v2.jpg";
        String toPath3 = "D:/test/desk/16a_v3.jpg";
        String toPath4 = "D:/test/desk/16a_v4.jpg";
        String toPath5 = "D:/test/desk/16a_v5.jpg";
        String toPath6 = "D:/test/desk/16a_v6.jpg";

        String[] pics7 = {toPath1,toPath2,toPath3,toPath4,toPath5,toPath6};
        String toPath7 = "D:/test/desk/16a_h1.jpg";

        long start = System.currentTimeMillis();
        imageObj.joinImageListVertical(pics1, imageFormat, toPath1);
        imageObj.joinImageListVertical(pics2, imageFormat, toPath2);
        imageObj.joinImageListVertical(pics3, imageFormat, toPath3);
        imageObj.joinImageListVertical(pics4, imageFormat, toPath4);
        imageObj.joinImageListVertical(pics5, imageFormat, toPath5);
        imageObj.joinImageListVertical(pics6, imageFormat, toPath6);

        imageObj.joinImageListHorizontal(pics7, imageFormat, toPath7);
        long end = System.currentTimeMillis();
        System.out.println(end-start);*/

        String str = "鍖椾含\n涓婃捣\n骞垮窞\n娣卞湷";
        System.out.println(str);
        String path = "c:/relevantdata.txt";
        FileOutputStream fops = new FileOutputStream(path);
        fops.write(str.getBytes());

        BufferedReader inputStream = new BufferedReader(new FileReader(new File(path)));
        String mrMsg = "";
        while((mrMsg = inputStream.readLine()) != null){
            System.out.println(mrMsg);
        }
    }
    //鏁伴噺		11			11x6
    //绾靛悜		375
    //妯悜		391		3250
}
