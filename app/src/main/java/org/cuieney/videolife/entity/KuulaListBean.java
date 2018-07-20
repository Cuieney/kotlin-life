package org.cuieney.videolife.entity;

import java.util.List;

/**
 * Created by cuieney on 2017/6/8.
 */

public class KuulaListBean {

    /**
     * status : 0
     * payload : {"posts":[{"id":"7PccT","uuid":"5b50-bac2-8494-1169","description":"Yellow Dandelions in Alta Badia | DOLOMITI","cover":"01","privacy":"public","views":"1326","tiny":"2","flat":"0","featured":"0","created":"1532017580","comments":"2","likes":"4","user":{"id":"34709","name":"phlucavisciani","displayname":"Ph_lucavisciani","picture":"1","type":"0"}},{"id":"7PXWm","uuid":"5b4d-ca1e-6dd7-8119","description":"Piaza de San Pietro.jpg","cover":"01","privacy":"public","views":"11158","tiny":"1","flat":"0","featured":"0","created":"1531824727","comments":"0","likes":"9","user":{"id":"34505","name":"IgnacioBorregoPolanco","displayname":"Ignacio Borrego Polanco","picture":"1","type":"0"}},{"id":"7PJ2l","uuid":"5b47-be59-ddde-2101","description":"Ziemia Lubaczowska\r\nwww.lubaczow360.pl\r\n","cover":"01","privacy":"public","views":"11572","tiny":"1","flat":"0","featured":"0","created":"1531428590","comments":"4","likes":"16","user":{"id":"208","name":"Tomasz","displayname":"Tomasz Mielnik","picture":"1","type":"1"}},{"id":"7PJjB","uuid":"5b47-9a77-c348-7166","description":"View from Tower Bridge: Tamesis river and HMS Belfast.\r\n\r\nLondon, England.\r\n\r\nBy:\r\nFernando Del Valle R.\r\nwww.fdelvalle.com\r\n© 2018\r\n\r\nEquipment:\r\nCanon 70D\r\nOpteka 6.5mm\r\n\r\n#fernando #fdelvalle #pano360 #reflex #canon #70D #fisheye #londonbridge #towerbridge #london #uk","cover":"01","privacy":"public","views":"10871","tiny":"1","flat":"0","featured":"0","created":"1531419330","comments":"0","likes":"5","user":{"id":"27680","name":"fdelvallephoto","displayname":"Fernando Del Valle Reynoso","picture":"1","type":"0"}},{"id":"7PJGB","uuid":"5b44-f70f-a57d-d110","description":"Torriglia, Liguria, northern Italy.\r\nView of the village from the ruins of the medieval castle, dating back to around 1100.","cover":"01","privacy":"public","views":"11528","tiny":"1","flat":"0","featured":"0","created":"1531246745","comments":"2","likes":"12","user":{"id":"2571","name":"Roberto","displayname":"Enjoy360","picture":"1","type":"1"}},{"id":"7P4fH","uuid":"5afa-ee52-59de-3102","description":"Visite du parc","cover":"01","privacy":"public","views":"10627","tiny":"1","flat":"0","featured":"0","created":"1526394494","comments":"0","likes":"7","user":{"id":"27845","name":"MAUMONT","displayname":"MAUMONT","picture":"1","type":"0"}},{"id":"7P9Z6","uuid":"5b3c-4922-2671-5390","description":"jardinlaguna.jpg","cover":"01","privacy":"public","views":"10435","tiny":"1","flat":"0","featured":"0","created":"1530677607","comments":"1","likes":"10","user":{"id":"33346","name":"andreafernandez","displayname":"Andrea Fernandez","picture":"1","type":"0"}},{"id":"7PqJH","uuid":"5b32-1627-1cd5-b141","description":"Waikiki Coast from Hale Koa","cover":"01","privacy":"public","views":"17157","tiny":"1","flat":"0","featured":"0","created":"1530009182","comments":"4","likes":"16","user":{"id":"1471","name":"HawaiiResolution","displayname":"Hawaii Resolution","picture":"1","type":"1"}},{"id":"7PqWH","uuid":"5b34-142e-0f9c-4118","description":"Anusan Night Market in Chiang Mai, Thailand","cover":"01","privacy":"public","views":"14224","tiny":"2","flat":"0","featured":"0","created":"1530140042","comments":"5","likes":"16","user":{"id":"1823","name":"panoramiceye","displayname":"Jim Newberry","picture":"1","type":"0"}},{"id":"7PY6P","uuid":"5b28-09c2-356f-0145","description":"Aberdeen Dragon Boat Racing(香港仔龍舟賽), HK.\r\nDragon Boat Festival#\r\n","cover":"01","privacy":"public","views":"10226","tiny":"1","flat":"0","featured":"0","created":"1529350628","comments":"2","likes":"9","user":{"id":"7171","name":"Chuen","displayname":null,"picture":"0","type":"0"}},{"id":"7PqZT","uuid":"5b32-6e54-aa0b-d139","description":"After the Storm. Visby, Gotland, Sweden. Visby is a must visit. Visby is a beautiful medieval walled market town with a rich history, the streets are narrow and here in the old town you don't need a car.","cover":"01","privacy":"public","views":"9510","tiny":"2","flat":"0","featured":"0","created":"1530032477","comments":"1","likes":"18","user":{"id":"14720","name":"Mirador360","displayname":"Pentti Sairanen","picture":"1","type":"0"}},{"id":"7PkGm","uuid":"5b2a-de61-edad-8183","description":"\r\n\"Judicial Perspective \" drawing360\r\n\r\n#streetart #sketchers #sketching #sketch# #sketch360 #comic360 #artinthestreets #eduardorelero #relero #drawing360 #globalstreetart #dibujo360","cover":"01","privacy":"public","views":"10161","tiny":"1","flat":"0","featured":"0","created":"1529536167","comments":"2","likes":"22","user":{"id":"24709","name":"eduardorelero","displayname":"Eduardo Relero","picture":"1","type":"0"}}],"page":{"total":1232,"size":12,"index":0,"start":0,"end":12,"hasPrev":false,"hasNext":true,"nextIndex":1}}
     * action : explore
     * exectime : 613
     */

    private int status;
    private PayloadBean payload;
    private String action;
    private int exectime;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public PayloadBean getPayload() {
        return payload;
    }

    public void setPayload(PayloadBean payload) {
        this.payload = payload;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getExectime() {
        return exectime;
    }

    public void setExectime(int exectime) {
        this.exectime = exectime;
    }

    public static class PayloadBean {
        /**
         * posts : [{"id":"7PccT","uuid":"5b50-bac2-8494-1169","description":"Yellow Dandelions in Alta Badia | DOLOMITI","cover":"01","privacy":"public","views":"1326","tiny":"2","flat":"0","featured":"0","created":"1532017580","comments":"2","likes":"4","user":{"id":"34709","name":"phlucavisciani","displayname":"Ph_lucavisciani","picture":"1","type":"0"}},{"id":"7PXWm","uuid":"5b4d-ca1e-6dd7-8119","description":"Piaza de San Pietro.jpg","cover":"01","privacy":"public","views":"11158","tiny":"1","flat":"0","featured":"0","created":"1531824727","comments":"0","likes":"9","user":{"id":"34505","name":"IgnacioBorregoPolanco","displayname":"Ignacio Borrego Polanco","picture":"1","type":"0"}},{"id":"7PJ2l","uuid":"5b47-be59-ddde-2101","description":"Ziemia Lubaczowska\r\nwww.lubaczow360.pl\r\n","cover":"01","privacy":"public","views":"11572","tiny":"1","flat":"0","featured":"0","created":"1531428590","comments":"4","likes":"16","user":{"id":"208","name":"Tomasz","displayname":"Tomasz Mielnik","picture":"1","type":"1"}},{"id":"7PJjB","uuid":"5b47-9a77-c348-7166","description":"View from Tower Bridge: Tamesis river and HMS Belfast.\r\n\r\nLondon, England.\r\n\r\nBy:\r\nFernando Del Valle R.\r\nwww.fdelvalle.com\r\n© 2018\r\n\r\nEquipment:\r\nCanon 70D\r\nOpteka 6.5mm\r\n\r\n#fernando #fdelvalle #pano360 #reflex #canon #70D #fisheye #londonbridge #towerbridge #london #uk","cover":"01","privacy":"public","views":"10871","tiny":"1","flat":"0","featured":"0","created":"1531419330","comments":"0","likes":"5","user":{"id":"27680","name":"fdelvallephoto","displayname":"Fernando Del Valle Reynoso","picture":"1","type":"0"}},{"id":"7PJGB","uuid":"5b44-f70f-a57d-d110","description":"Torriglia, Liguria, northern Italy.\r\nView of the village from the ruins of the medieval castle, dating back to around 1100.","cover":"01","privacy":"public","views":"11528","tiny":"1","flat":"0","featured":"0","created":"1531246745","comments":"2","likes":"12","user":{"id":"2571","name":"Roberto","displayname":"Enjoy360","picture":"1","type":"1"}},{"id":"7P4fH","uuid":"5afa-ee52-59de-3102","description":"Visite du parc","cover":"01","privacy":"public","views":"10627","tiny":"1","flat":"0","featured":"0","created":"1526394494","comments":"0","likes":"7","user":{"id":"27845","name":"MAUMONT","displayname":"MAUMONT","picture":"1","type":"0"}},{"id":"7P9Z6","uuid":"5b3c-4922-2671-5390","description":"jardinlaguna.jpg","cover":"01","privacy":"public","views":"10435","tiny":"1","flat":"0","featured":"0","created":"1530677607","comments":"1","likes":"10","user":{"id":"33346","name":"andreafernandez","displayname":"Andrea Fernandez","picture":"1","type":"0"}},{"id":"7PqJH","uuid":"5b32-1627-1cd5-b141","description":"Waikiki Coast from Hale Koa","cover":"01","privacy":"public","views":"17157","tiny":"1","flat":"0","featured":"0","created":"1530009182","comments":"4","likes":"16","user":{"id":"1471","name":"HawaiiResolution","displayname":"Hawaii Resolution","picture":"1","type":"1"}},{"id":"7PqWH","uuid":"5b34-142e-0f9c-4118","description":"Anusan Night Market in Chiang Mai, Thailand","cover":"01","privacy":"public","views":"14224","tiny":"2","flat":"0","featured":"0","created":"1530140042","comments":"5","likes":"16","user":{"id":"1823","name":"panoramiceye","displayname":"Jim Newberry","picture":"1","type":"0"}},{"id":"7PY6P","uuid":"5b28-09c2-356f-0145","description":"Aberdeen Dragon Boat Racing(香港仔龍舟賽), HK.\r\nDragon Boat Festival#\r\n","cover":"01","privacy":"public","views":"10226","tiny":"1","flat":"0","featured":"0","created":"1529350628","comments":"2","likes":"9","user":{"id":"7171","name":"Chuen","displayname":null,"picture":"0","type":"0"}},{"id":"7PqZT","uuid":"5b32-6e54-aa0b-d139","description":"After the Storm. Visby, Gotland, Sweden. Visby is a must visit. Visby is a beautiful medieval walled market town with a rich history, the streets are narrow and here in the old town you don't need a car.","cover":"01","privacy":"public","views":"9510","tiny":"2","flat":"0","featured":"0","created":"1530032477","comments":"1","likes":"18","user":{"id":"14720","name":"Mirador360","displayname":"Pentti Sairanen","picture":"1","type":"0"}},{"id":"7PkGm","uuid":"5b2a-de61-edad-8183","description":"\r\n\"Judicial Perspective \" drawing360\r\n\r\n#streetart #sketchers #sketching #sketch# #sketch360 #comic360 #artinthestreets #eduardorelero #relero #drawing360 #globalstreetart #dibujo360","cover":"01","privacy":"public","views":"10161","tiny":"1","flat":"0","featured":"0","created":"1529536167","comments":"2","likes":"22","user":{"id":"24709","name":"eduardorelero","displayname":"Eduardo Relero","picture":"1","type":"0"}}]
         * page : {"total":1232,"size":12,"index":0,"start":0,"end":12,"hasPrev":false,"hasNext":true,"nextIndex":1}
         */

        private PageBean page;
        private List<PostsBean> posts;

        public PageBean getPage() {
            return page;
        }

        public void setPage(PageBean page) {
            this.page = page;
        }

        public List<PostsBean> getPosts() {
            return posts;
        }

        public void setPosts(List<PostsBean> posts) {
            this.posts = posts;
        }

        public static class PageBean {
            /**
             * total : 1232
             * size : 12
             * index : 0
             * start : 0
             * end : 12
             * hasPrev : false
             * hasNext : true
             * nextIndex : 1
             */

            private int total;
            private int size;
            private int index;
            private int start;
            private int end;
            private boolean hasPrev;
            private boolean hasNext;
            private int nextIndex;

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public int getIndex() {
                return index;
            }

            public void setIndex(int index) {
                this.index = index;
            }

            public int getStart() {
                return start;
            }

            public void setStart(int start) {
                this.start = start;
            }

            public int getEnd() {
                return end;
            }

            public void setEnd(int end) {
                this.end = end;
            }

            public boolean isHasPrev() {
                return hasPrev;
            }

            public void setHasPrev(boolean hasPrev) {
                this.hasPrev = hasPrev;
            }

            public boolean isHasNext() {
                return hasNext;
            }

            public void setHasNext(boolean hasNext) {
                this.hasNext = hasNext;
            }

            public int getNextIndex() {
                return nextIndex;
            }

            public void setNextIndex(int nextIndex) {
                this.nextIndex = nextIndex;
            }
        }

        public static class PostsBean {
            /**
             * id : 7PccT
             * uuid : 5b50-bac2-8494-1169
             * description : Yellow Dandelions in Alta Badia | DOLOMITI
             * cover : 01
             * privacy : public
             * views : 1326
             * tiny : 2
             * flat : 0
             * featured : 0
             * created : 1532017580
             * comments : 2
             * likes : 4
             * user : {"id":"34709","name":"phlucavisciani","displayname":"Ph_lucavisciani","picture":"1","type":"0"}
             */

            private String id;
            private String uuid;
            private String description;
            private String cover;
            private String privacy;
            private String views;
            private String tiny;
            private String flat;
            private String featured;
            private String created;
            private String comments;
            private String likes;
            private UserBean user;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUuid() {
                return uuid;
            }

            public void setUuid(String uuid) {
                this.uuid = uuid;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getPrivacy() {
                return privacy;
            }

            public void setPrivacy(String privacy) {
                this.privacy = privacy;
            }

            public String getViews() {
                return views;
            }

            public void setViews(String views) {
                this.views = views;
            }

            public String getTiny() {
                return tiny;
            }

            public void setTiny(String tiny) {
                this.tiny = tiny;
            }

            public String getFlat() {
                return flat;
            }

            public void setFlat(String flat) {
                this.flat = flat;
            }

            public String getFeatured() {
                return featured;
            }

            public void setFeatured(String featured) {
                this.featured = featured;
            }

            public String getCreated() {
                return created;
            }

            public void setCreated(String created) {
                this.created = created;
            }

            public String getComments() {
                return comments;
            }

            public void setComments(String comments) {
                this.comments = comments;
            }

            public String getLikes() {
                return likes;
            }

            public void setLikes(String likes) {
                this.likes = likes;
            }

            public UserBean getUser() {
                return user;
            }

            public void setUser(UserBean user) {
                this.user = user;
            }

            public static class UserBean {
                /**
                 * id : 34709
                 * name : phlucavisciani
                 * displayname : Ph_lucavisciani
                 * picture : 1
                 * type : 0
                 */

                private String id;
                private String name;
                private String displayname;
                private String picture;
                private String type;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getDisplayname() {
                    return displayname;
                }

                public void setDisplayname(String displayname) {
                    this.displayname = displayname;
                }

                public String getPicture() {
                    return picture;
                }

                public void setPicture(String picture) {
                    this.picture = picture;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }
            }
        }
    }
}
