package com.wemall.core.tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * FTP宸ュ叿绫?
 *
 * @author wangjinbin@163.com
 */
public class FtpUtils {
    final static Logger log = LoggerFactory.getLogger(FtpUtils.class);

    /**
     * Description: 鍚慒TP链嶅姟鍣ㄤ笂浼犳枃浠?
     *
     * @Version1.0
     * @param url
     *            FTP链嶅姟鍣╤ostname
     * @param port
     *            FTP链嶅姟鍣ㄧ鍙?
     * @param username
     *            FTP鐧诲綍璐﹀佛
     * @param password
     *            FTP鐧诲綍瀵嗙爜
     * @param path
     *            FTP链嶅姟鍣ㄤ缭瀛樼洰褰?
     * @param filename
     *            涓娄紶鍒癋TP链嶅姟鍣ㄤ笂镄勬枃浠跺悕
     * @param input
     *            杈揿叆娴?
     * @return 鎴愬姛杩斿洖true锛屽惁鍒栾繑锲瀎alse
     */
    public static boolean uploadFile(String url,// FTP链嶅姟鍣╤ostname
                                     int port,// FTP链嶅姟鍣ㄧ鍙?
                                     String username, // FTP鐧诲綍璐﹀佛
                                     String password, // FTP鐧诲綍瀵嗙爜
                                     String path, // FTP链嶅姟鍣ㄤ缭瀛樼洰褰?
                                     String filename, // 涓娄紶鍒癋TP链嶅姟鍣ㄤ笂镄勬枃浠跺悕
                                     InputStream input // 杈揿叆娴?
                                   ){
        boolean success = false;
        FTPClient ftp = new FTPClient();
        try {
            int reply;
            ftp.connect(url, port);// 杩炴帴FTP链嶅姟鍣?
            // 濡傛灉閲囩敤榛樿绔彛锛屽彲浠ヤ娇鐢╢tp.connect(url)镄勬柟寮忕洿鎺ヨ繛鎺TP链嶅姟鍣?
            ftp.login(username, password);// 鐧诲綍
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)){
                ftp.disconnect();
                return success;
            }
            ftp.changeWorkingDirectory(path);
            ftp.storeFile(filename, input);

            input.close();
            ftp.logout();
            success = true;
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()){
                try {
                    ftp.disconnect();
                } catch (IOException ioe){
                }
            }
        }

        return success;
    }

    /**
     * Description: 浠峄TP链嶅姟鍣ㄤ笅杞芥枃浠?
     *
     * @Version1.0
     * @param url
     *            FTP链嶅姟鍣╤ostname
     * @param port
     *            FTP链嶅姟鍣ㄧ鍙?
     * @param username
     *            FTP鐧诲綍璐﹀佛
     * @param password
     *            FTP鐧诲綍瀵嗙爜
     * @param remotePath
     *            FTP链嶅姟鍣ㄤ笂镄勭浉瀵硅矾寰?
     * @param fileName
     *            瑕佷笅杞界殑鏂囦欢鍚?
     * @param localPath
     *            涓嬭浇鍚庝缭瀛桦埌链湴镄勮矾寰?
     * @return
     */
    public static List<String> downFile(String url, // FTP链嶅姟鍣╤ostname
                                        int port,// FTP链嶅姟鍣ㄧ鍙?
                                        String username, // FTP鐧诲綍璐﹀佛
                                        String password, // FTP鐧诲綍瀵嗙爜
                                        String remotePath,// FTP链嶅姟鍣ㄤ笂镄勭浉瀵硅矾寰?
                                        String fileName,// 瑕佷笅杞界殑鏂囦欢鍚?
                                        String match_flag,// 鏂囦欢鍚嶅尮閰嶆ā寮?0锛氭ā绯婂尮閰?1锛氱簿纭尮閰?
                                        String localPath// 涓嬭浇鍚庝缭瀛桦埌链湴镄勮矾寰?
                                      ){
        List<String> lst_files = new ArrayList<String>();

        FTPClient ftp = new FTPClient();
        try {
            int reply;
            ftp.connect(url, port);
            // 濡傛灉閲囩敤榛樿绔彛锛屽彲浠ヤ娇鐢╢tp.connect(url)镄勬柟寮忕洿鎺ヨ繛鎺TP链嶅姟鍣?
            ftp.login(username, password);// 鐧诲綍
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)){
                ftp.disconnect();
                log.error("FTP链嶅姟鍣ㄨ繛鎺ュけ璐ワ紒");

                return lst_files;
            }
            ftp.changeWorkingDirectory(remotePath);// 杞Щ鍒癋TP链嶅姟鍣ㄧ洰褰?
            FTPFile[] fs = ftp.listFiles();
            for (FTPFile ff : fs){
                if ("0".equals(match_flag) && ff.getName().indexOf(fileName) >= 0){ // 鏂囦欢鍚嶆ā绯婂尮閰?
                    File localFile = new File(localPath + "/" + ff.getName());
                    OutputStream is = new FileOutputStream(localFile);
                    ftp.retrieveFile(ff.getName(), is);
                    is.close();

                    lst_files.add(ff.getName());
                }else if (ff.getName().equals(fileName)){ // 鏂囦欢鍚岖簿纭尮閰?
                    File localFile = new File(localPath + "/" + ff.getName());
                    OutputStream is = new FileOutputStream(localFile);
                    ftp.retrieveFile(ff.getName(), is);
                    is.close();

                    lst_files.add(ff.getName());
                }
            }

            ftp.logout();
        } catch (IOException e){
            log.error("FTP链嶅姟鍣ㄨ繛鎺ュ纾甯革紒" + e.getMessage());
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()){
                try {
                    ftp.disconnect();
                } catch (IOException ioe){
                }
            }
        }

        return lst_files;
    }
}
