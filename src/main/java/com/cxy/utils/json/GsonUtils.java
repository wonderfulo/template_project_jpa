package com.cxy.utils.json;//package com.cxy.utils.json;
//
//import com.google.common.reflect.TypeToken;
//import com.google.gson.*;
//import com.google.gson.internal.LinkedTreeMap;
//import com.google.gson.stream.JsonReader;
//import com.google.gson.stream.JsonToken;
//import com.google.gson.stream.JsonWriter;
//import com.vsvz.api.bbs.bean.BbsShowForumBean;
//
//import java.io.IOException;
//import java.lang.reflect.Type;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//
//public class GsonUtils {
//    /**
//     * 实现格式化的时间字符串转时间对象
//     */
//    private static final String DATEFORMAT_default = "yyyy-MM-dd HH:mm:ss";
//
//    /**
//     * 使用默认的gson对象进行反序列化
//     *
//     * @param json
//     * @param typeToken
//     * @return
//     */
//    public static <T> T fromJsonDefault(String json, TypeToken<T> typeToken) {
//        Gson gson = new Gson();
//        return gson.fromJson(json, typeToken.getType());
//    }
//
//    /**
//     * json字符串转list或者map
//     *
//     * @param json
//     * @param typeToken
//     * @return
//     */
//    public static <T> T fromJson(String json, TypeToken<T> typeToken) {
//
////        Gson gson = new GsonBuilder()
////                /**
////                 * 重写map的反序列化
////                 */
////                .registerTypeAdapter(new TypeToken<Map<String, Object>>() {
////                }.getType(), new MapTypeAdapter()).create();
//        Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
//            @Override
//            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
//                return new Date(json.getAsJsonPrimitive().getAsLong());
//            }
//        }).create();
//
//
//        return gson.fromJson(json, typeToken.getType());
//
//    }
//
//
//    /**
//     * json字符串转bean对象
//     *
//     * @param json
//     * @param cls
//     * @return
//     */
//    public static <T> T fromJson(String json, Class<T> cls) {
//
//        Gson gson = new GsonBuilder().setDateFormat(DATEFORMAT_default)
//                .create();
//
//        return gson.fromJson(json, cls);
//
//    }
//
//    /**
//     * 对象转json
//     *
//     * @param obj
//     * @param format
//     * @return
//     */
//    public static String toJson(Object obj, boolean format) {
//
//        GsonBuilder gsonBuilder = new GsonBuilder();
//        /**
//         * 设置默认时间格式
//         */
//        gsonBuilder.setDateFormat(DATEFORMAT_default);
//
//        /**
//         * 添加格式化设置
//         */
//        if (format) {
//            gsonBuilder.setPrettyPrinting();
//        }
//
//        Gson gson = gsonBuilder.create();
//
//        return gson.toJson(obj);
//    }
//
//    public static void main(String[] args) {
////        DataTaskRecord record = new DataTaskRecord();
////        record.setRecordId(111);
////        String toJson = toJson(record, Boolean.FALSE);
////        DataTaskRecord fromJson = fromJson(toJson, DataTaskRecord.class);
////        System.out.println(toJson);
////        System.out.println(fromJson);
////        List<DataTaskRecord> arrayList = Lists.newArrayList(record);
////        String toaJson = toJson(arrayList, Boolean.FALSE);
////        List<DataTaskRecord> taskRecords = fromJson(toaJson, new TypeToken<List<DataTaskRecord>>() {
////        });
////        System.out.println("list ： " + taskRecords);
//
//        String json = "[{\n" +
//                "\t\"activitId\": 41139,\n" +
//                "\t\"context\": \"hfyq\",\n" +
//                "\t\"createName\": \"ccl12\",\n" +
//                "\t\"createNickName\": \"邪火—凤凰\",\n" +
//                "\t\"createUser\": 325265195,\n" +
//                "\t\"headPic\": \"\",\n" +
//                "\t\"replyId\": 0,\n" +
//                "\t\"replyList\": [],\n" +
//                "\t\"replyTarget\": 0,\n" +
//                "\t\"showName\": \"邪火—凤凰\",\n" +
//                "\t\"topicId\": 5646\n" +
//                "}, {\n" +
//                "\t\"activitId\": 41139,\n" +
//                "\t\"context\": \"你猜\",\n" +
//                "\t\"createName\": \"ccl04%\",\n" +
//                "\t\"createNickName\": \"金奖得主\",\n" +
//                "\t\"createUser\": 325265187,\n" +
//                "\t\"headPic\": \"\",\n" +
//                "\t\"replyId\": 0,\n" +
//                "\t\"replyList\": [],\n" +
//                "\t\"replyTarget\": 0,\n" +
//                "\t\"showName\": \"金奖得主\",\n" +
//                "\t\"topicId\": 5647\n" +
//                "}, {\n" +
//                "\t\"activitId\": 41139,\n" +
//                "\t\"context\": \"集结号\",\n" +
//                "\t\"createName\": \"ccl04%\",\n" +
//                "\t\"createNickName\": \"金奖得主\",\n" +
//                "\t\"createUser\": 325265187,\n" +
//                "\t\"headPic\": \"\",\n" +
//                "\t\"replyId\": 0,\n" +
//                "\t\"replyList\": [],\n" +
//                "\t\"replyTarget\": 0,\n" +
//                "\t\"showName\": \"金奖得主\",\n" +
//                "\t\"topicId\": 5650\n" +
//                "}, {\n" +
//                "\t\"activitId\": 41139,\n" +
//                "\t\"context\": \"你参加\",\n" +
//                "\t\"createName\": \"ccl07\",\n" +
//                "\t\"createNickName\": \"ccl07\",\n" +
//                "\t\"createUser\": 325265186,\n" +
//                "\t\"headPic\": \"\",\n" +
//                "\t\"replyId\": 0,\n" +
//                "\t\"replyList\": [],\n" +
//                "\t\"replyTarget\": 0,\n" +
//                "\t\"showName\": \"ccl07\",\n" +
//                "\t\"topicId\": 5652\n" +
//                "}]";
//        List<BbsShowForumBean> taskRecords = GsonUtils.fromJson(json, new TypeToken<List<BbsShowForumBean>>() {
//        });
//
//        for (BbsShowForumBean bbsShowForumBean : taskRecords) {
//            System.out.println(bbsShowForumBean.getCreateName());
//        }
//        //二级评论过滤
//
//    }
//
//    public static class MapTypeAdapter extends TypeAdapter<Object> {
//
//        @Override
//        public Object read(JsonReader in) throws IOException {
//            JsonToken token = in.peek();
//            switch (token) {
//                case BEGIN_ARRAY:
//                    List<Object> list = new ArrayList<Object>();
//                    in.beginArray();
//                    while (in.hasNext()) {
//                        list.add(read(in));
//                    }
//                    in.endArray();
//                    return list;
//
//                case BEGIN_OBJECT:
//                    Map<String, Object> map = new LinkedTreeMap<String, Object>();
//                    in.beginObject();
//                    while (in.hasNext()) {
//                        map.put(in.nextName(), read(in));
//                    }
//                    in.endObject();
//                    return map;
//
//                case STRING:
//                    return in.nextString();
//
//                case NUMBER:
//                    /**
//                     * 改写数字的处理逻辑，将数字值分为整型与浮点型。
//                     */
//                    double dbNum = in.nextDouble();
//
//                    // 数字超过long的最大值，返回浮点类型
//                    if (dbNum > Long.MAX_VALUE) {
//                        return dbNum;
//                    }
//
//                    // 判断数字是否为整数值
//                    long lngNum = (long) dbNum;
//                    if (dbNum == lngNum) {
//                        return lngNum;
//                    } else {
//                        return dbNum;
//                    }
//
//                case BOOLEAN:
//                    return in.nextBoolean();
//
//                case NULL:
//                    in.nextNull();
//                    return null;
//
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        @Override
//        public void write(JsonWriter out, Object value) throws IOException {
//            // 序列化无需实现
//        }
//
//    }
//}