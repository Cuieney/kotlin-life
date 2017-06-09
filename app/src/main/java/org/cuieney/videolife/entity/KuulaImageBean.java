package org.cuieney.videolife.entity;

import java.util.List;

/**
 * Created by cuieney on 2017/6/8.
 */

public class KuulaImageBean {


    /**
     * status : 0
     * payload : {"id":"7l0mZ","uuid":"5936-8b2f-bc74-0719","description":"Outdoor Basement","cover":"01","views":69,"privacy":"public","featured":"41717","tiny":"0","created":"1496746859","user":{"id":"7742","name":"motasemaltwair","type":"0","displayname":"Motasem Al Twair","picture":"1","website":"","settings":null,"url":"https://kuula.co/profile/motasemaltwair"},"n":"41717","photos":[{"id":"41719","name":"01","sizes":["5000","4096"],"options":{"heading":1.5707963267949,"roll":0,"pitch":0,"zoom":0,"lensflare":false,"glare":0.1,"sunIntensity":0.1,"tinyRot":0,"tinyScale":0.5,"tinyBulge":0.5,"tinyInvert":0,"tinyOffsetX":0,"tinyOffsetY":0,"tinySaved":false,"sun":null,"filter":"none","filterintensity":1,"format":"jpg"},"urls":["https://files.kuula.io/5936-8b2f-bc74-0719/01-5000.jpg","https://files.kuula.io/5936-8b2f-bc74-0719/01-4096.jpg"]}],"likes":4,"comments":1,"wholiked":[{"name":"3rddimensionstudio","displayname":"3rdDimensionStudio"},{"name":"magda","displayname":"Magda"},{"name":"FPG","displayname":"FPG"},{"name":"bartek","displayname":"Bartek Drozdz"}]}
     * action : get
     * exectime : 826
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
         * id : 7l0mZ
         * uuid : 5936-8b2f-bc74-0719
         * description : Outdoor Basement
         * cover : 01
         * views : 69
         * privacy : public
         * featured : 41717
         * tiny : 0
         * created : 1496746859
         * user : {"id":"7742","name":"motasemaltwair","type":"0","displayname":"Motasem Al Twair","picture":"1","website":"","settings":null,"url":"https://kuula.co/profile/motasemaltwair"}
         * n : 41717
         * photos : [{"id":"41719","name":"01","sizes":["5000","4096"],"options":{"heading":1.5707963267949,"roll":0,"pitch":0,"zoom":0,"lensflare":false,"glare":0.1,"sunIntensity":0.1,"tinyRot":0,"tinyScale":0.5,"tinyBulge":0.5,"tinyInvert":0,"tinyOffsetX":0,"tinyOffsetY":0,"tinySaved":false,"sun":null,"filter":"none","filterintensity":1,"format":"jpg"},"urls":["https://files.kuula.io/5936-8b2f-bc74-0719/01-5000.jpg","https://files.kuula.io/5936-8b2f-bc74-0719/01-4096.jpg"]}]
         * likes : 4
         * comments : 1
         * wholiked : [{"name":"3rddimensionstudio","displayname":"3rdDimensionStudio"},{"name":"magda","displayname":"Magda"},{"name":"FPG","displayname":"FPG"},{"name":"bartek","displayname":"Bartek Drozdz"}]
         */

        private String id;
        private String uuid;
        private String description;
        private String cover;
        private int views;
        private String privacy;
        private String featured;
        private String tiny;
        private String created;
        private UserBean user;
        private String n;
        private int likes;
        private int comments;
        private List<PhotosBean> photos;
        private List<WholikedBean> wholiked;

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

        public int getViews() {
            return views;
        }

        public void setViews(int views) {
            this.views = views;
        }

        public String getPrivacy() {
            return privacy;
        }

        public void setPrivacy(String privacy) {
            this.privacy = privacy;
        }

        public String getFeatured() {
            return featured;
        }

        public void setFeatured(String featured) {
            this.featured = featured;
        }

        public String getTiny() {
            return tiny;
        }

        public void setTiny(String tiny) {
            this.tiny = tiny;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public String getN() {
            return n;
        }

        public void setN(String n) {
            this.n = n;
        }

        public int getLikes() {
            return likes;
        }

        public void setLikes(int likes) {
            this.likes = likes;
        }

        public int getComments() {
            return comments;
        }

        public void setComments(int comments) {
            this.comments = comments;
        }

        public List<PhotosBean> getPhotos() {
            return photos;
        }

        public void setPhotos(List<PhotosBean> photos) {
            this.photos = photos;
        }

        public List<WholikedBean> getWholiked() {
            return wholiked;
        }

        public void setWholiked(List<WholikedBean> wholiked) {
            this.wholiked = wholiked;
        }

        public static class UserBean {
            /**
             * id : 7742
             * name : motasemaltwair
             * type : 0
             * displayname : Motasem Al Twair
             * picture : 1
             * website :
             * settings : null
             * url : https://kuula.co/profile/motasemaltwair
             */

            private String id;
            private String name;
            private String type;
            private String displayname;
            private String picture;
            private String website;
            private Object settings;
            private String url;

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

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
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

            public String getWebsite() {
                return website;
            }

            public void setWebsite(String website) {
                this.website = website;
            }

            public Object getSettings() {
                return settings;
            }

            public void setSettings(Object settings) {
                this.settings = settings;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class PhotosBean {
            /**
             * id : 41719
             * name : 01
             * sizes : ["5000","4096"]
             * options : {"heading":1.5707963267949,"roll":0,"pitch":0,"zoom":0,"lensflare":false,"glare":0.1,"sunIntensity":0.1,"tinyRot":0,"tinyScale":0.5,"tinyBulge":0.5,"tinyInvert":0,"tinyOffsetX":0,"tinyOffsetY":0,"tinySaved":false,"sun":null,"filter":"none","filterintensity":1,"format":"jpg"}
             * urls : ["https://files.kuula.io/5936-8b2f-bc74-0719/01-5000.jpg","https://files.kuula.io/5936-8b2f-bc74-0719/01-4096.jpg"]
             */

            private String id;
            private String name;
            private OptionsBean options;
            private List<String> sizes;
            private List<String> urls;

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

            public OptionsBean getOptions() {
                return options;
            }

            public void setOptions(OptionsBean options) {
                this.options = options;
            }

            public List<String> getSizes() {
                return sizes;
            }

            public void setSizes(List<String> sizes) {
                this.sizes = sizes;
            }

            public List<String> getUrls() {
                return urls;
            }

            public void setUrls(List<String> urls) {
                this.urls = urls;
            }

            public static class OptionsBean {
                /**
                 * heading : 1.5707963267949
                 * roll : 0
                 * pitch : 0
                 * zoom : 0
                 * lensflare : false
                 * glare : 0.1
                 * sunIntensity : 0.1
                 * tinyRot : 0
                 * tinyScale : 0.5
                 * tinyBulge : 0.5
                 * tinyInvert : 0
                 * tinyOffsetX : 0
                 * tinyOffsetY : 0
                 * tinySaved : false
                 * sun : null
                 * filter : none
                 * filterintensity : 1
                 * format : jpg
                 */

                private double heading;
                private double roll;
                private double pitch;
                private double zoom;
                private boolean lensflare;
                private double glare;
                private double sunIntensity;
                private double tinyRot;
                private double tinyScale;
                private double tinyBulge;
                private double tinyInvert;
                private double tinyOffsetX;
                private double tinyOffsetY;
                private boolean tinySaved;
                private Object sun;
                private String filter;
                private double filterintensity;
                private String format;

                public double getHeading() {
                    return heading;
                }

                public void setHeading(double heading) {
                    this.heading = heading;
                }

                public double getRoll() {
                    return roll;
                }

                public void setRoll(double roll) {
                    this.roll = roll;
                }

                public double getPitch() {
                    return pitch;
                }

                public void setPitch(double pitch) {
                    this.pitch = pitch;
                }

                public double getZoom() {
                    return zoom;
                }

                public void setZoom(double zoom) {
                    this.zoom = zoom;
                }

                public boolean isLensflare() {
                    return lensflare;
                }

                public void setLensflare(boolean lensflare) {
                    this.lensflare = lensflare;
                }

                public double getGlare() {
                    return glare;
                }

                public void setGlare(double glare) {
                    this.glare = glare;
                }

                public double getSunIntensity() {
                    return sunIntensity;
                }

                public void setSunIntensity(double sunIntensity) {
                    this.sunIntensity = sunIntensity;
                }

                public double getTinyRot() {
                    return tinyRot;
                }

                public void setTinyRot(double tinyRot) {
                    this.tinyRot = tinyRot;
                }

                public double getTinyScale() {
                    return tinyScale;
                }

                public void setTinyScale(double tinyScale) {
                    this.tinyScale = tinyScale;
                }

                public double getTinyBulge() {
                    return tinyBulge;
                }

                public void setTinyBulge(double tinyBulge) {
                    this.tinyBulge = tinyBulge;
                }

                public double getTinyInvert() {
                    return tinyInvert;
                }

                public void setTinyInvert(double tinyInvert) {
                    this.tinyInvert = tinyInvert;
                }

                public double getTinyOffsetX() {
                    return tinyOffsetX;
                }

                public void setTinyOffsetX(double tinyOffsetX) {
                    this.tinyOffsetX = tinyOffsetX;
                }

                public double getTinyOffsetY() {
                    return tinyOffsetY;
                }

                public void setTinyOffsetY(double tinyOffsetY) {
                    this.tinyOffsetY = tinyOffsetY;
                }

                public boolean isTinySaved() {
                    return tinySaved;
                }

                public void setTinySaved(boolean tinySaved) {
                    this.tinySaved = tinySaved;
                }

                public Object getSun() {
                    return sun;
                }

                public void setSun(Object sun) {
                    this.sun = sun;
                }

                public String getFilter() {
                    return filter;
                }

                public void setFilter(String filter) {
                    this.filter = filter;
                }

                public double getFilterintensity() {
                    return filterintensity;
                }

                public void setFilterintensity(double filterintensity) {
                    this.filterintensity = filterintensity;
                }

                public String getFormat() {
                    return format;
                }

                public void setFormat(String format) {
                    this.format = format;
                }
            }
        }

        public static class WholikedBean {
            /**
             * name : 3rddimensionstudio
             * displayname : 3rdDimensionStudio
             */

            private String name;
            private String displayname;

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
        }
    }
}
