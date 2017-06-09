package org.cuieney.videolife.entity;

import java.util.List;

/**
 * Created by cuieney on 2017/6/8.
 */

public class KuulaListBean {

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
         * posts : [{},{},{},{},{},{},{},{},{},{},{},{"id":"7lpzg","uuid":"5931-c1fb-81fd-a405","description":"Angkok Ta Prohm (吳哥窟塔普倫廟1), Cambodia. ancient architecture# hindu temples# cultural heritage#","cover":"01","privacy":"public","views":"99","tiny":"0","featured":"0","created":"1496433325","comments":"0","likes":"8","user":{"id":"7171","name":"Chuen","displayname":null,"picture":"0","type":"0"}}]
         * page : {"total":854,"size":12,"index":0,"start":0,"end":12,"hasPrev":false,"hasNext":true,"nextIndex":1}
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
             * total : 854
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
             * id : 7lpzg
             * uuid : 5931-c1fb-81fd-a405
             * description : Angkok Ta Prohm (吳哥窟塔普倫廟1), Cambodia. ancient architecture# hindu temples# cultural heritage#
             * cover : 01
             * privacy : public
             * views : 99
             * tiny : 0
             * featured : 0
             * created : 1496433325
             * comments : 0
             * likes : 8
             * user : {"id":"7171","name":"Chuen","displayname":null,"picture":"0","type":"0"}
             */

            private String id;
            private String uuid;
            private String description;
            private String cover;
            private String privacy;
            private String views;
            private String tiny;
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
                 * id : 7171
                 * name : Chuen
                 * displayname : null
                 * picture : 0
                 * type : 0
                 */

                private String id;
                private String name;
                private Object displayname;
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

                public Object getDisplayname() {
                    return displayname;
                }

                public void setDisplayname(Object displayname) {
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
