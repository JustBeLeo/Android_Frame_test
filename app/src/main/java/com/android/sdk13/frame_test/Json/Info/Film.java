package com.android.sdk13.frame_test.Json.Info;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Film {

    /**
     * id : 73917
     * movieName : 新版《地狱男爵》剧场预告
     * coverImg : http://img5.mtime.cn/mg/2019/03/01/141330.12746212_120X90X4.jpg
     * movieId : 247677
     * url : http://vfx.mtime.cn/Video/2019/03/01/mp4/190301141332024373.mp4
     * hightUrl : http://vfx.mtime.cn/Video/2019/03/01/mp4/190301141332024373.mp4
     * videoTitle : 地狱男爵：血皇后崛起 中文剧场版预告
     * videoLength : 160
     * rating : -1
     * type : ["动作","冒险","奇幻","科幻"]
     * summary : 血皇后等怪物轮番登场
     */

    private int id;
    private String movieName;
    private String coverImg;
    private int movieId;
    private String url;
    private String hightUrl;
    private String videoTitle;
    private int videoLength;
    private int rating;
    private String summary;
    private List<String> type;



    public static Film objectFromData(String str) {

        return new Gson().fromJson( str, Film.class );
    }

    public static Film objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject( str );

            return new Gson().fromJson( jsonObject.getString( str ), Film.class );
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<Film> arrayFilmFromData(String str) {

        Type listType = new TypeToken<ArrayList<Film>>() {
        }.getType();

        return new Gson().fromJson( str, new TypeToken<ArrayList<Film>>(){}.getType() );
    }

    public static List<Film> arrayFilmFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject( str );
            Type listType = new TypeToken<ArrayList<Film>>() {
            }.getType();

            return new Gson().fromJson( jsonObject.getString( str ), listType );

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHightUrl() {
        return hightUrl;
    }

    public void setHightUrl(String hightUrl) {
        this.hightUrl = hightUrl;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public int getVideoLength() {
        return videoLength;
    }

    public void setVideoLength(int videoLength) {
        this.videoLength = videoLength;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", movieName='" + movieName + '\'' +
                ", coverImg='" + coverImg + '\'' +
                ", movieId=" + movieId +
                ", url='" + url + '\'' +
                ", hightUrl='" + hightUrl + '\'' +
                ", videoTitle='" + videoTitle + '\'' +
                ", videoLength=" + videoLength +
                ", rating=" + rating +
                ", summary='" + summary + '\'' +
                ", type=" + type +
                '}';
    }
}
