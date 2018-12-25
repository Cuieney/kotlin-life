package org.cuieney.videolife.entity;

import java.util.List;

/**
 * Created by cuieney on 2017/6/8.
 */

public class KuulaImageBean {


    /**
     * status : 0
     * payload : {"id":"7PXWm","uuid":"5b4d-ca1e-6dd7-8119","description":"Piaza de San Pietro.jpg","cover":"01","views":11148,"privacy":"public","featured":"1531867752","tiny":"1","created":"1531824727","user":{"id":"34505","name":"IgnacioBorregoPolanco","type":"0","displayname":"Ignacio Borrego Polanco","picture":"1","website":"http://www.ignacioborregopolanco.com","settings":null,"url":"https://kuula.co/profile/IgnacioBorregoPolanco"},"n":"216732","photos":[{"id":"216802","name":"01","sizes":["8000","4096"],"options":{"heading":1.5707963267949,"roll":0,"pitch":0,"crop":false,"flat":false,"orientation":0,"zoom":0,"pitchLimit":0,"lensflare":0,"glare":0.1,"sunIntensity":0.1,"tinyRot":0,"tinyScale":0.5,"tinyBulge":0.5,"tinyInvert":0,"tinyOffsetX":0,"tinyOffsetY":0,"tinySaved":false,"sun":null,"filter":"none","filterintensity":1,"format":"jpg","showInfo":false,"showLocation":false,"location":null,"latlng":null,"info":null,"original":{"width":8000,"height":4000}},"addons":"[]","xmp":"<x:xmpmeta xmlns:x=\"adobe:ns:meta/\" x:xmptk=\"Adobe XMP Core 5.6-c142 79.160924, 2017/07/13-01:06:39        \"> <rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"> <rdf:Description rdf:about=\"\" xmlns:GPano=\"http://ns.google.com/photos/1.0/panorama/\" xmlns:xmp=\"http://ns.adobe.com/xap/1.0/\" xmlns:photoshop=\"http://ns.adobe.com/photoshop/1.0/\" xmlns:xmpMM=\"http://ns.adobe.com/xap/1.0/mm/\" xmlns:stEvt=\"http://ns.adobe.com/xap/1.0/sType/ResourceEvent#\" xmlns:dc=\"http://purl.org/dc/elements/1.1/\" GPano:ProjectionType=\"equirectangular\" GPano:UsePanoramaViewer=\"True\" GPano:CroppedAreaImageWidthPixels=\"8000\" GPano:CroppedAreaImageHeightPixels=\"4000\" GPano:FullPanoWidthPixels=\"8000\" GPano:FullPanoHeightPixels=\"4000\" GPano:CroppedAreaLeftPixels=\"0\" GPano:CroppedAreaTopPixels=\"0\" GPano:StitchingSoftware=\"PTGui Pro 10.0.17 (www.ptgui.com)\" xmp:CreatorTool=\"Adobe Photoshop CC (Windows)\" xmp:ModifyDate=\"2018-03-18T18:08:23+01:00\" xmp:CreateDate=\"2018-03-13T19:47:25\" xmp:MetadataDate=\"2018-03-18T18:08:23+01:00\" photoshop:DateCreated=\"2018-03-13T19:47:25\" photoshop:LegacyIPTCDigest=\"9A8C4B7273792BCEA0C9DA9A9772B609\" photoshop:ColorMode=\"3\" photoshop:ICCProfile=\"sRGB IEC61966-2.1\" xmpMM:DocumentID=\"adobe:docid:photoshop:69e02a8f-e6e5-c446-abf2-6338591d15a4\" xmpMM:InstanceID=\"xmp.iid:3d41387f-303a-f34b-9e96-1da72a08b60d\" xmpMM:OriginalDocumentID=\"588EB24D627B2A444B82A34C8B34F86E\" dc:format=\"image/jpeg\"> <photoshop:DocumentAncestors> <rdf:Bag> <rdf:li>D2B1EABB8328F8D914AE65E16063D1D0<\/rdf:li> <\/rdf:Bag> <\/photoshop:DocumentAncestors> <xmpMM:History> <rdf:Seq> <rdf:li stEvt:action=\"saved\" stEvt:instanceID=\"xmp.iid:c0ad3cea-3b14-cf4e-b4da-38a164a86853\" stEvt:when=\"2018-03-18T18:07:05+01:00\" stEvt:softwareAgent=\"Adobe Photoshop CC (Windows)\" stEvt:changed=\"/\"/> <rdf:li stEvt:action=\"saved\" stEvt:instanceID=\"xmp.iid:3d41387f-303a-f34b-9e96-1da72a08b60d\" stEvt:when=\"2018-03-18T18:08:23+01:00\" stEvt:softwareAgent=\"Adobe Photoshop CC (Windows)\" stEvt:changed=\"/\"/> <\/rdf:Seq> <\/xmpMM:History> <\/rdf:Description> <\/rdf:RDF> <\/x:xmpmeta>"}],"likes":9,"comments":0,"wholiked":[{"name":"fdelvallephoto","displayname":"Fernando Del Valle Reynoso"},{"name":"leandrobello","displayname":"Leandro Bello"},{"name":"Palodya53","displayname":"Palodya53"},{"name":"samaanbotros","displayname":"Samaan Botros"},{"name":"TheSmithDroneian","displayname":"The SmithDroneian"},{"name":"Mirador360","displayname":"Pentti Sairanen"},{"name":"frreenk","displayname":"frreenk"},{"name":"magda","displayname":"Magda"},{"name":"bartek","displayname":" Bartek Drozdz"}]}
     * action : get
     * exectime : 892
     */

    private double status;
    private PayloadBean payload;
    private String action;
    private double exectime;

    public double getStatus() {
        return status;
    }

    public void setStatus(double status) {
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

    public double getExectime() {
        return exectime;
    }

    public void setExectime(double exectime) {
        this.exectime = exectime;
    }

    public static class PayloadBean {
        /**
         * id : 7PXWm
         * uuid : 5b4d-ca1e-6dd7-8119
         * description : Piaza de San Pietro.jpg
         * cover : 01
         * views : 11148
         * privacy : public
         * featured : 1531867752
         * tiny : 1
         * created : 1531824727
         * user : {"id":"34505","name":"IgnacioBorregoPolanco","type":"0","displayname":"Ignacio Borrego Polanco","picture":"1","website":"http://www.ignacioborregopolanco.com","settings":null,"url":"https://kuula.co/profile/IgnacioBorregoPolanco"}
         * n : 216732
         * photos : [{"id":"216802","name":"01","sizes":["8000","4096"],"options":{"heading":1.5707963267949,"roll":0,"pitch":0,"crop":false,"flat":false,"orientation":0,"zoom":0,"pitchLimit":0,"lensflare":0,"glare":0.1,"sunIntensity":0.1,"tinyRot":0,"tinyScale":0.5,"tinyBulge":0.5,"tinyInvert":0,"tinyOffsetX":0,"tinyOffsetY":0,"tinySaved":false,"sun":null,"filter":"none","filterintensity":1,"format":"jpg","showInfo":false,"showLocation":false,"location":null,"latlng":null,"info":null,"original":{"width":8000,"height":4000}},"addons":"[]","xmp":"<x:xmpmeta xmlns:x=\"adobe:ns:meta/\" x:xmptk=\"Adobe XMP Core 5.6-c142 79.160924, 2017/07/13-01:06:39        \"> <rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"> <rdf:Description rdf:about=\"\" xmlns:GPano=\"http://ns.google.com/photos/1.0/panorama/\" xmlns:xmp=\"http://ns.adobe.com/xap/1.0/\" xmlns:photoshop=\"http://ns.adobe.com/photoshop/1.0/\" xmlns:xmpMM=\"http://ns.adobe.com/xap/1.0/mm/\" xmlns:stEvt=\"http://ns.adobe.com/xap/1.0/sType/ResourceEvent#\" xmlns:dc=\"http://purl.org/dc/elements/1.1/\" GPano:ProjectionType=\"equirectangular\" GPano:UsePanoramaViewer=\"True\" GPano:CroppedAreaImageWidthPixels=\"8000\" GPano:CroppedAreaImageHeightPixels=\"4000\" GPano:FullPanoWidthPixels=\"8000\" GPano:FullPanoHeightPixels=\"4000\" GPano:CroppedAreaLeftPixels=\"0\" GPano:CroppedAreaTopPixels=\"0\" GPano:StitchingSoftware=\"PTGui Pro 10.0.17 (www.ptgui.com)\" xmp:CreatorTool=\"Adobe Photoshop CC (Windows)\" xmp:ModifyDate=\"2018-03-18T18:08:23+01:00\" xmp:CreateDate=\"2018-03-13T19:47:25\" xmp:MetadataDate=\"2018-03-18T18:08:23+01:00\" photoshop:DateCreated=\"2018-03-13T19:47:25\" photoshop:LegacyIPTCDigest=\"9A8C4B7273792BCEA0C9DA9A9772B609\" photoshop:ColorMode=\"3\" photoshop:ICCProfile=\"sRGB IEC61966-2.1\" xmpMM:DocumentID=\"adobe:docid:photoshop:69e02a8f-e6e5-c446-abf2-6338591d15a4\" xmpMM:InstanceID=\"xmp.iid:3d41387f-303a-f34b-9e96-1da72a08b60d\" xmpMM:OriginalDocumentID=\"588EB24D627B2A444B82A34C8B34F86E\" dc:format=\"image/jpeg\"> <photoshop:DocumentAncestors> <rdf:Bag> <rdf:li>D2B1EABB8328F8D914AE65E16063D1D0<\/rdf:li> <\/rdf:Bag> <\/photoshop:DocumentAncestors> <xmpMM:History> <rdf:Seq> <rdf:li stEvt:action=\"saved\" stEvt:instanceID=\"xmp.iid:c0ad3cea-3b14-cf4e-b4da-38a164a86853\" stEvt:when=\"2018-03-18T18:07:05+01:00\" stEvt:softwareAgent=\"Adobe Photoshop CC (Windows)\" stEvt:changed=\"/\"/> <rdf:li stEvt:action=\"saved\" stEvt:instanceID=\"xmp.iid:3d41387f-303a-f34b-9e96-1da72a08b60d\" stEvt:when=\"2018-03-18T18:08:23+01:00\" stEvt:softwareAgent=\"Adobe Photoshop CC (Windows)\" stEvt:changed=\"/\"/> <\/rdf:Seq> <\/xmpMM:History> <\/rdf:Description> <\/rdf:RDF> <\/x:xmpmeta>"}]
         * likes : 9
         * comments : 0
         * wholiked : [{"name":"fdelvallephoto","displayname":"Fernando Del Valle Reynoso"},{"name":"leandrobello","displayname":"Leandro Bello"},{"name":"Palodya53","displayname":"Palodya53"},{"name":"samaanbotros","displayname":"Samaan Botros"},{"name":"TheSmithDroneian","displayname":"The SmithDroneian"},{"name":"Mirador360","displayname":"Pentti Sairanen"},{"name":"frreenk","displayname":"frreenk"},{"name":"magda","displayname":"Magda"},{"name":"bartek","displayname":" Bartek Drozdz"}]
         */

        private String id;
        private String uuid;
        private String description;
        private String cover;
        private double views;
        private String privacy;
        private String featured;
        private String tiny;
        private String created;
        private UserBean user;
        private String n;
        private double likes;
        private double comments;
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

        public double getViews() {
            return views;
        }

        public void setViews(double views) {
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

        public double getLikes() {
            return likes;
        }

        public void setLikes(double likes) {
            this.likes = likes;
        }

        public double getComments() {
            return comments;
        }

        public void setComments(double comments) {
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
             * id : 34505
             * name : IgnacioBorregoPolanco
             * type : 0
             * displayname : Ignacio Borrego Polanco
             * picture : 1
             * website : http://www.ignacioborregopolanco.com
             * settings : null
             * url : https://kuula.co/profile/IgnacioBorregoPolanco
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
             * id : 216802
             * name : 01
             * sizes : ["8000","4096"]
             * options : {"heading":1.5707963267949,"roll":0,"pitch":0,"crop":false,"flat":false,"orientation":0,"zoom":0,"pitchLimit":0,"lensflare":0,"glare":0.1,"sunIntensity":0.1,"tinyRot":0,"tinyScale":0.5,"tinyBulge":0.5,"tinyInvert":0,"tinyOffsetX":0,"tinyOffsetY":0,"tinySaved":false,"sun":null,"filter":"none","filterintensity":1,"format":"jpg","showInfo":false,"showLocation":false,"location":null,"latlng":null,"info":null,"original":{"width":8000,"height":4000}}
             * addons : []
             * xmp : <x:xmpmeta xmlns:x="adobe:ns:meta/" x:xmptk="Adobe XMP Core 5.6-c142 79.160924, 2017/07/13-01:06:39        "> <rdf:RDF xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"> <rdf:Description rdf:about="" xmlns:GPano="http://ns.google.com/photos/1.0/panorama/" xmlns:xmp="http://ns.adobe.com/xap/1.0/" xmlns:photoshop="http://ns.adobe.com/photoshop/1.0/" xmlns:xmpMM="http://ns.adobe.com/xap/1.0/mm/" xmlns:stEvt="http://ns.adobe.com/xap/1.0/sType/ResourceEvent#" xmlns:dc="http://purl.org/dc/elements/1.1/" GPano:ProjectionType="equirectangular" GPano:UsePanoramaViewer="True" GPano:CroppedAreaImageWidthPixels="8000" GPano:CroppedAreaImageHeightPixels="4000" GPano:FullPanoWidthPixels="8000" GPano:FullPanoHeightPixels="4000" GPano:CroppedAreaLeftPixels="0" GPano:CroppedAreaTopPixels="0" GPano:StitchingSoftware="PTGui Pro 10.0.17 (www.ptgui.com)" xmp:CreatorTool="Adobe Photoshop CC (Windows)" xmp:ModifyDate="2018-03-18T18:08:23+01:00" xmp:CreateDate="2018-03-13T19:47:25" xmp:MetadataDate="2018-03-18T18:08:23+01:00" photoshop:DateCreated="2018-03-13T19:47:25" photoshop:LegacyIPTCDigest="9A8C4B7273792BCEA0C9DA9A9772B609" photoshop:ColorMode="3" photoshop:ICCProfile="sRGB IEC61966-2.1" xmpMM:DocumentID="adobe:docid:photoshop:69e02a8f-e6e5-c446-abf2-6338591d15a4" xmpMM:InstanceID="xmp.iid:3d41387f-303a-f34b-9e96-1da72a08b60d" xmpMM:OriginalDocumentID="588EB24D627B2A444B82A34C8B34F86E" dc:format="image/jpeg"> <photoshop:DocumentAncestors> <rdf:Bag> <rdf:li>D2B1EABB8328F8D914AE65E16063D1D0</rdf:li> </rdf:Bag> </photoshop:DocumentAncestors> <xmpMM:History> <rdf:Seq> <rdf:li stEvt:action="saved" stEvt:instanceID="xmp.iid:c0ad3cea-3b14-cf4e-b4da-38a164a86853" stEvt:when="2018-03-18T18:07:05+01:00" stEvt:softwareAgent="Adobe Photoshop CC (Windows)" stEvt:changed="/"/> <rdf:li stEvt:action="saved" stEvt:instanceID="xmp.iid:3d41387f-303a-f34b-9e96-1da72a08b60d" stEvt:when="2018-03-18T18:08:23+01:00" stEvt:softwareAgent="Adobe Photoshop CC (Windows)" stEvt:changed="/"/> </rdf:Seq> </xmpMM:History> </rdf:Description> </rdf:RDF> </x:xmpmeta>
             */

            private String id;
            private String name;
            private OptionsBean options;
            private String addons;
            private String xmp;
            private List<String> sizes;

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

            public String getAddons() {
                return addons;
            }

            public void setAddons(String addons) {
                this.addons = addons;
            }

            public String getXmp() {
                return xmp;
            }

            public void setXmp(String xmp) {
                this.xmp = xmp;
            }

            public List<String> getSizes() {
                return sizes;
            }

            public void setSizes(List<String> sizes) {
                this.sizes = sizes;
            }

            public static class OptionsBean {
                /**
                 * heading : 1.5707963267949
                 * roll : 0
                 * pitch : 0
                 * crop : false
                 * flat : false
                 * orientation : 0
                 * zoom : 0
                 * pitchLimit : 0
                 * lensflare : 0
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
                 * showInfo : false
                 * showLocation : false
                 * location : null
                 * latlng : null
                 * info : null
                 * original : {"width":8000,"height":4000}
                 */

                private double heading;
                private double roll;
                private double pitch;
                private boolean crop;
                private boolean flat;
                private double orientation;
                private double zoom;
                private double pitchLimit;
                private double lensflare;
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
                private boolean showInfo;
                private boolean showLocation;
                private Object location;
                private Object latlng;
                private Object info;
                private OriginalBean original;

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

                public boolean isCrop() {
                    return crop;
                }

                public void setCrop(boolean crop) {
                    this.crop = crop;
                }

                public boolean isFlat() {
                    return flat;
                }

                public void setFlat(boolean flat) {
                    this.flat = flat;
                }

                public double getOrientation() {
                    return orientation;
                }

                public void setOrientation(double orientation) {
                    this.orientation = orientation;
                }

                public double getZoom() {
                    return zoom;
                }

                public void setZoom(double zoom) {
                    this.zoom = zoom;
                }

                public double getPitchLimit() {
                    return pitchLimit;
                }

                public void setPitchLimit(double pitchLimit) {
                    this.pitchLimit = pitchLimit;
                }

                public double getLensflare() {
                    return lensflare;
                }

                public void setLensflare(double lensflare) {
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

                public boolean isShowInfo() {
                    return showInfo;
                }

                public void setShowInfo(boolean showInfo) {
                    this.showInfo = showInfo;
                }

                public boolean isShowLocation() {
                    return showLocation;
                }

                public void setShowLocation(boolean showLocation) {
                    this.showLocation = showLocation;
                }

                public Object getLocation() {
                    return location;
                }

                public void setLocation(Object location) {
                    this.location = location;
                }

                public Object getLatlng() {
                    return latlng;
                }

                public void setLatlng(Object latlng) {
                    this.latlng = latlng;
                }

                public Object getInfo() {
                    return info;
                }

                public void setInfo(Object info) {
                    this.info = info;
                }

                public OriginalBean getOriginal() {
                    return original;
                }

                public void setOriginal(OriginalBean original) {
                    this.original = original;
                }

                public static class OriginalBean {
                    /**
                     * width : 8000
                     * height : 4000
                     */

                    private double width;
                    private double height;

                    public double getWidth() {
                        return width;
                    }

                    public void setWidth(double width) {
                        this.width = width;
                    }

                    public double getHeight() {
                        return height;
                    }

                    public void setHeight(double height) {
                        this.height = height;
                    }
                }
            }
        }

        public static class WholikedBean {
            /**
             * name : fdelvallephoto
             * displayname : Fernando Del Valle Reynoso
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