package com.wemall.manage.admin.tools;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.commons.fileupload.FileItem;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class MultiCommonsMultipartResolver extends CommonsMultipartResolver {
    
    public MultiCommonsMultipartResolver() {
    }
    
    public MultiCommonsMultipartResolver(ServletContext servletContext) {
        super(servletContext);
    }
    
    @Override
    @SuppressWarnings("unchecked")
    protected MultipartParsingResult parseFileItems(List fileItems, String encoding) {
        Map multipartFiles = new HashMap();
        Map multipartParameters = new HashMap();
        
        // Extract multipart files and multipart parameters.
        for (Iterator it = fileItems.iterator(); it.hasNext();) {
            FileItem fileItem = (FileItem) it.next();
            if (fileItem.isFormField()) {
                String value = null;
                if (encoding != null) {
                    try {
                        value = fileItem.getString(encoding);
                    } catch (UnsupportedEncodingException ex) {
                        if (logger.isWarnEnabled()) {
                            logger.warn("Could not decode multipart item '" + fileItem.getFieldName()
                                    + "' with encoding '" + encoding + "': using platform default");
                        }
                        value = fileItem.getString();
                    }
                } else {
                    value = fileItem.getString();
                }
                String[] curParam = (String[]) multipartParameters.get(fileItem.getFieldName());
                if (curParam == null) {
                    // simple form field
                    multipartParameters.put(fileItem.getFieldName(), new String[] { value });
                } else {
                    // array of simple form fields
                    String[] newParam = StringUtils.addStringToArray(curParam, value);
                    multipartParameters.put(fileItem.getFieldName(), newParam);
                }
            } else {
                // multipart file field
                CommonsMultipartFile file = new CommonsMultipartFile(fileItem);
                if (multipartFiles.put(fileItem.getName(), file) != null) {
                    throw new MultipartException("Multiple files for field name [" + file.getName()
                            + "] found - not supported by MultipartResolver");
                }
                if (logger.isDebugEnabled()) {
                    logger.debug("Found multipart file [" + file.getName() + "] of size " + file.getSize()
                            + " bytes with original filename [" + file.getOriginalFilename() + "], stored "
                            + file.getStorageDescription());
                }
            }
        }
        return new MultipartParsingResult(multipartFiles, multipartParameters);
    }
    
}