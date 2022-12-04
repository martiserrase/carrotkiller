package com.example.interaction.api;

/* EXAMPLE of the GET of the Chuck Norris Fact API: https://api.chucknorris.io/jokes/random/
"categories": [],
    "created_at": "2020-01-05 13:42:21.179347",
    "icon_url": "https://assets.chucknorris.host/img/avatar/chuck-norris.png",
    "id": "gGB2h0BbRqeW9so_TIvFEg",
    "updated_at": "2020-01-05 13:42:21.179347",
    "url": "https://api.chucknorris.io/jokes/gGB2h0BbRqeW9so_TIvFEg",
    "value": "S
 */

public class ChuckNorris {

    private String[] categories;
    private String created_at;
    private String icon_url;
    private String id;
    private String updated_at;
    private String url;
    private String value;

    public String[] getCategories() {
        return categories;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public String getId() {
        return id;
    }

    public String getUpdated_at() {
        return created_at;
    }

    public String getUrl() {
        return url;
    }

    public String getValue() {
        return value;
    }
}
