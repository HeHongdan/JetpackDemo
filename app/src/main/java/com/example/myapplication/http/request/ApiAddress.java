package com.example.myapplication.http.request;

import com.example.myapplication.http.bean.ArticleBean;
import com.example.myapplication.http.bean.ArticleListBean;
import com.example.myapplication.http.bean.HomeBannerEntity;
import com.example.myapplication.http.bean.Integral;
import com.example.myapplication.http.bean.LoginBean;
import com.example.myapplication.http.bean.WeChatBean;
import com.example.myapplication.http.data.HttpBaseResponse;
import com.example.myapplication.http.bean.ImageBean;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * 网络请求接口地址
 *
 * @author devel
 */
public interface ApiAddress {


    /**
     * 获取闪屏页图片
     *
     * @param format
     * @param idx
     * @param n
     * @return
     */
    @GET("HPImageArchive.aspx")
    Observable<ImageBean> getImage(@Query("format") String format, @Query("idx") int idx, @Query("n") int n);

    /**
     * 登陆
     *
     * @return
     */
    @FormUrlEncoded
    @POST("user/login")
    Observable<HttpBaseResponse<LoginBean>> Login(@Field("username") String username, @Field("password") String password);

    /**
     * 退出
     *
     * @return
     */
    @GET("user/logout/json")
    Observable<HttpBaseResponse<Object>> logout();


    /**
     * 注册
     *
     * @return
     */
    @FormUrlEncoded
    @POST("user/register")
    Observable<HttpBaseResponse<Object>> register(@Field("username") String username,
                                                  @Field("password") String password,
                                                  @Field("repassword") String repwd);


    /**
     * 获取首页banner
     *
     * @return
     */
    @GET("banner/json")
    Observable<HomeBannerEntity> getBanner();


    /**
     * 获取置顶文章
     *
     * @return
     */
    @GET("article/top/json")
    Observable<HttpBaseResponse<List<ArticleBean>>> getTopArticleList();

    /**
     * 首页文章列表
     * 方法：GET
     *
     * @param page 页码
     * @return
     */
    @GET("article/list/{page}/json")
    Observable<HttpBaseResponse<ArticleListBean>> getArticleList(@Path("page") int page);


    /**
     * 获取微信公众号列表
     *
     * @return
     */
    @GET("wxarticle/chapters/json")
    Observable<HttpBaseResponse<List<WeChatBean>>> getWechatList();


    /**
     * 获取微信公众号文章列表
     *
     * @return
     */
    @GET("wxarticle/list/{id}/{page}/json")
    Observable<HttpBaseResponse<ArticleListBean>> getWechatArticleList(@Path("id") int id, @Path("page") int page);


    /**
     * 获取收藏的文章
     *
     * @return
     */
    @GET("lg/collect/list/{page}/json")
    Observable<HttpBaseResponse<ArticleListBean>> getCollectList(@Path("page") int page);


    /**
     * 获取积分
     *
     * @return
     */
    @GET("lg/coin/userinfo/json")
    Observable<HttpBaseResponse<Integral>> getMyIntegral();


    /**
     * ToDo列表
     * 方法：GET
     *
     * @param page 页码
     * @return
     */
    @GET("lg/todo/v2/list/{page}/json")
    Observable<HttpBaseResponse<Object>> getToDoList(@Path("page") int page);

}
