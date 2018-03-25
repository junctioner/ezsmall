package com.wemall.core.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 镊畾涔夋敞閲婏紝鐢ㄤ簬鏉冮檺镙￠獙
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface SecurityMapping {
    public abstract String title();// 镙囬

    public abstract String value();// url鍦板潃链?

    public abstract String rname();// 瑙掕壊鍚?

    public abstract String rcode();// 瑙掕壊浠ｇ爜

    public abstract int rsequence();// 瑙掕壊搴忓佛

    public abstract String rgroup();// 瑙掕壊缁?

    public abstract String rtype();// 瑙掕壊绫诲瀷

    public abstract boolean display();// 鏄惁鏄剧ず
}