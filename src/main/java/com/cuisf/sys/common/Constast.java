package com.cuisf.sys.common;

/**
 * Created by Administrator on 2020-03-21.
 */
public interface  Constast{
        /**
         * 状态码
         *
         */
        public static final Integer OK=200;
        public static final Integer ERROR=-1;

        /**
         * 用户默认密码
         */
        public static final String USER_DEFAULT_PWD = "def123456";

        /**
         * 菜单权限类型
         */
        public static final String TYPE_MEAU ="menu";
        public static final String TYPE_PERMISSION ="permission";

        /**
         * 可以状态
         */
        public static final Object AVALIABLE_TRUE=1;
        public static final Object AVALIABLE_FALSE=0;

        /**
         * 用户类型
         */
        public static final Integer USER_TYPE_SUPER=0;
        public static final Integer USER_TYPE_NORMAL=1;

        /**
         * 展开类型
         */
        public static final Integer OPEN_TURE=1;
        public static final Integer OPEN_FALSE=0;



}
